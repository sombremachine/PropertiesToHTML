package controller;

import model.Model;
import view.View;

public interface Controller {
    void generateHTML();
    void setModel(Model model);
    void setView(View view);
}
