package model;


import bean.User;
import dao.UserDAO;
import dao.UserDAOFactory;

public class ModelImpl implements model.Model {
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
