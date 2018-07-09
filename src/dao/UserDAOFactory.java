package dao;

public class UserDAOFactory {
    public static UserDAO getUserDAO(String fileName){
        UserDAO dao = null;
        if ((fileName != null)&&(!fileName.isEmpty())) {
            String fileExtention = fileName.substring(fileName.lastIndexOf('.') + 1);
            switch (fileExtention.toLowerCase()) {
                case "properties": {
                    dao = new PropertiesFileUserDAO(fileName);
                    break;
                }
                case "ini": {
                    System.out.println("Поддержка ini файлов еще не реализована.");
                    break;
                }
                default: {
                    System.out.println("Неизвестный формат файла");
                    break;
                }
            }
            return dao;
        }else{
            System.err.println("Не задано имя входного файла.\n");
            return null;
        }
    }
}
