package myPackage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
//@EnableWebMvc
//@ComponentScan({"com.baeldung.freemarker"})
public class MainClass {
    private static final Logger log = Logger.getLogger(MainClass.class);

    static {
        Path path = Paths.get("./log4j.properties");
        if (Files.exists(path)) {
            PropertyConfigurator.configure(path.toString());
        } else {
            PropertyConfigurator.configure(MainClass.class.getResource("/Resources/log4j.properties"));
        }
    }

    public static void main(String... args) {
        SpringApplication.run(MainClass.class, args);
    }
//
//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }

}
