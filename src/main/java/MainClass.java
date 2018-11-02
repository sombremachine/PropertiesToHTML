

import controller.Controller;
import controller.ControllerImpl;
import model.Model;
import model.ModelImpl;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import view.View;
import view.ViewToHTMLImpl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainClass {
    private static final Logger log = Logger.getLogger(MainClass.class);

    static {
        Path path = Paths.get("./log4j.properties");
        if (Files.exists(path)) {
            PropertyConfigurator.configure(path.toString());
        } else {
            PropertyConfigurator.configure(MainClass.class.getResource("/main/java/Resources/log4j.properties"));
        }
    }

    public static void main(String... args) {
        String inFileName = null;
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
//            View main.java.view   =   new ViewToConsole();
            Model model = new ModelImpl(inFileName);
            Controller controller = new ControllerImpl();
            controller.setModel(model);
            controller.setView(view);
            controller.generateHTML();
        } else {
            log.debug("Имя входного файла не задано");
            System.out.println("Использование: java -jar PropertiesToHTML.jar -i input_file -o output_file");
            System.out.println();
            System.out.println("\tinput_file \t- путь к входному файлу .proprties");
            System.out.println("\toutput_file\t- путь к генерируемому .html");
            System.out.println();
            System.out.println("Если выходной файл не задан результат выводится в стандартный поток вывода.");
            System.out.println("Для корректного отображения сгенерированного файла в браузере требуется интернет подключение.");
        }
    }
}
