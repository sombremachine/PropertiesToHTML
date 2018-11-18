package myPackage.controller;

import myPackage.model.MyModel;
import myPackage.model.MyModelMTImpl;
import myPackage.view.View;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class ControllerImpl implements MyController {
    private MyModel myModel;
    private View view;

    @Override
    public void generateHTML() {
        if ((myModel != null) && (view != null)) {
            myModel.loadUserData();
            view.update(myModel.getModelData());
        }
    }

    @Override
    public void setMyModel(MyModel myModel) {
        this.myModel = myModel;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @GetMapping("/")
    public String index(Model model) {
//        model.addAttribute("user", UserDAOFactory.getUserDAO("../data.properties").getUserData());

        MyModel myModel = new MyModelMTImpl(Arrays.asList("../part1.properties","../part2.properties"));
        myModel.loadUserData();
        model.addAttribute("user", myModel.getModelData());
        return "index";
    }
}
