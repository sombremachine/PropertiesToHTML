package myPackage.model;


import myPackage.bean.User;
import myPackage.dao.UserDAO;
import myPackage.dao.UserDAOFactory;
import org.apache.log4j.Logger;

public class MyModelImpl implements MyModel {
    private static final Logger log = Logger.getLogger(MyModelImpl.class);

    private UserDAO dao;
    private User modelData = null;

    public MyModelImpl(String filename) {
        try {
            this.dao = UserDAOFactory.getUserDAO(filename);
        }catch (Exception e){
           log.error(e);
        }
    }

    @Override
    public void loadUserData() {
        if (dao != null) {
            modelData = dao.getUserData();
        }
    }

    @Override
    public User getModelData() {
        return modelData;
    }
}
