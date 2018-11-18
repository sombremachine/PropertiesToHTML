package myPackage.controller;

import myPackage.model.MyModel;
import myPackage.view.View;

public interface MyController {
    void generateHTML();
    void setMyModel(MyModel myModel);
    void setView(View view);
}
