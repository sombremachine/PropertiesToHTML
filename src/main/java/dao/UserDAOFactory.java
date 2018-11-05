package dao;

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
                    throw new RuntimeException("Поддержка ini файлов еще не реализована.");
                }
                default: {
                    throw new RuntimeException("Неизвестный формат файла.");
                }
            }
            return dao;
        }else{
            throw new RuntimeException("Не задано имя входного файла.");
        }
    }
}
