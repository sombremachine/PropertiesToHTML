package dao;

import dao.UserDAO;
import org.apache.log4j.Logger;

public class UserDAOFactory {
    private static final Logger log = Logger.getLogger(UserDAOFactory.class);

    public static UserDAO getUserDAO(String fileName){
        UserDAO dao = null;
        if ((fileName != null)&&(!fileName.isEmpty())) {
            String fileExtention = fileName.substring(fileName.lastIndexOf('.') + 1);
            switch (fileExtention.toLowerCase()) {
                case "properties": {
                    log.debug("Используется файл: " + fileName);
                    dao = new dao.PropertiesFileUserDAO(fileName);
                    break;
                }
                case "ini": {
//                    System.out.println("Поддержка ini файлов еще не реализована.");
                    log.warn("Поддержка ini файлов еще не реализована.");
                    break;
                }
                default: {
//                    System.out.println("Неизвестный формат файла");
                    log.error("Неизвестный формат файла");
                    break;
                }
            }
            return dao;
        }else{
//            System.err.println("Не задано имя входного файла.");
            log.warn("Не задано имя входного файла.");
            return null;
        }
    }
}
