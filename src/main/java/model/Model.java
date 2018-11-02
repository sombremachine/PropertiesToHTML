package main.java.model;

import main.java.bean.User;

public interface Model {
    void loadUserData();

    User getModelData();
}
