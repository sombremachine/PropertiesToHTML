package myPackage.model;

import myPackage.bean.User;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyModelMTImpl implements MyModel {
    private static final Logger log = Logger.getLogger(MyModelImpl.class);

    private List<Callable<User>> workers = new ArrayList<>();
    private List<Future<User>> results = new ArrayList<>();
    private User modelData = null;

    public MyModelMTImpl(List<String> filenames) {
        try {
            filenames.forEach(x -> workers.add(() -> myPackage.dao.UserDAOFactory.getUserDAO(x).getUserData()));
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void loadUserData() {
        if ((workers != null) && (!workers.isEmpty())) {
            ExecutorService executorService = Executors.newFixedThreadPool(2);

            workers.forEach(x -> results.add(executorService.submit(x)));
            results.forEach(x -> {
                try {
                    modelData = Utils.mergeUsers(modelData, x.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });

            executorService.shutdown();
        }
    }

    @Override
    public User getModelData() {
        return modelData;
    }
}
