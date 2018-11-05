package model;


import bean.User;
import dao.UserDAO;
import dao.UserDAOFactory;
import org.apache.log4j.Logger;

public class ModelImpl implements model.Model {
    private static final Logger log = Logger.getLogger(ModelImpl.class);

    private UserDAO dao;
    private User modelData = null;

    public ModelImpl(String filename) {
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
