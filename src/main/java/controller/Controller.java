package main.java.controller;

import main.java.model.Model;
import main.java.view.View;

public interface Controller {
    void generateHTML();
    void setModel(Model model);
    void setView(View view);
}
