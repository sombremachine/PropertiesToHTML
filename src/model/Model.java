package model;

import bean.User;

public interface Model {
    void loadUserData();

    User getModelData();
}
