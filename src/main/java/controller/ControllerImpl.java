package main.java.controller;

import main.java.model.Model;
import main.java.view.View;

public class ControllerImpl implements Controller {
    private Model model;
    private View view;

    @Override
    public void generateHTML() {
        if ((model != null) && (view != null)) {
            model.loadUserData();
            view.update(model.getModelData());
        }
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }
}