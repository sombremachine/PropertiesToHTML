package main.java.model;

import main.java.bean.User;
import main.java.dao.UserDAO;
import main.java.dao.UserDAOFactory;

public class ModelImpl implements Model {
    private UserDAO dao;
    private User modelData = null;

    public ModelImpl(String filename) {
        this.dao = UserDAOFactory.getUserDAO(filename);
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
