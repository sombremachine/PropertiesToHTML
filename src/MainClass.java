import controller.Controller;
import controller.ControllerImpl;
import model.Model;
import model.ModelImpl;
import view.View;
import view.ViewToConsole;
import view.ViewToHTMLImpl;

public class MainClass {
    public static void main(String... args){
        String inFileName  = "default.properties";
        String outFileName = null;

        if (args.length > 0) {
            for (int i = 0; i < args.length / 2; i++) {
                switch (args[i * 2]) {
                    case "-i": {
                        inFileName = args[i * 2 + 1];
                        break;
                    }
                    case "-o": {
                        outFileName = args[i * 2 + 1];
                        break;
                    }
                    default: {
                        System.out.println("Неизвестный ключ: " + args[i * 2]);
                        break;
                    }
                }
            }
            View view = new ViewToHTMLImpl(outFileName);
//        View view   =   new ViewToConsole();
            Model model = new ModelImpl(inFileName);
            Controller controller = new ControllerImpl();
            controller.setModel(model);
            controller.setView(view);
            controller.generateHTML();
        }else{
            System.out.println("Usage: PropertiesToHTML -i input_file -o output_file");
            System.out.println();
            System.out.println("\tinput_file \t- path to input .proprties file");
            System.out.println("\toutput_file\t- path to output .html file");
            System.out.println();
            System.out.println("with no output_file write to standard output");
        }
    }
}
