package view;

import bean.User;
import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ViewToHTMLImpl implements View {
    private String outFileName;

    public ViewToHTMLImpl(String outFileName) {
        this.outFileName = outFileName;
    }

    @Override
    public void update(User user) {
        //Instantiate Configuration class
        if (user != null) {
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
            configuration.setClassForTemplateLoading(this.getClass(), "/");
            configuration.setDefaultEncoding("UTF-8");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

            //Instantiate template
            Template template = null;
            try {
                template = configuration.getTemplate("Resources/index.html");
            } catch (IOException e) {
                //e.printStackTrace();
                System.err.println("Файл шаблона не найден");
                return;
            }

            Writer writer = null;

            if (outFileName == null) {
                writer = new OutputStreamWriter(System.out);
            } else {
                try {
                    writer = new OutputStreamWriter(new FileOutputStream(new File(outFileName)), StandardCharsets.UTF_8);
                } catch (IOException e) {
                    //e.printStackTrace();
                    System.err.println("Невозможно создать файл " + outFileName);
                    return;
                }
            }
            try {
                template.process(user, writer);
            } catch (TemplateException e) {
                //e.printStackTrace();
                System.err.println("Ошибка при обработке шаблона");
                return;
            } catch (IOException e) {
                //e.printStackTrace();
                System.err.println("Невозможно произвести запись в выходной поток");
                return;
            }
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                //e.printStackTrace();
                System.err.println("Невозможно произвести запись в выходной поток");
                return;
            }
        }else{
            System.err.println("Данные из входного файла не прочитаны.\n");
        }
    }
}
