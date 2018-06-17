package dao;

public class UserDAOFactory {
    public static UserDAO getUserDAO(String fileName){
        UserDAO dao = null;
        String fileExtention = fileName.substring(fileName.lastIndexOf('.') + 1);
        switch (fileExtention.toLowerCase()){
            case "properties":{
                dao = new PropertiesFileUserDAO(fileName);
                break;}
            case "xml":{
                System.out.println("Поддержка xml файлов еще не реализована.");
                break;}
            default:{
                System.out.println("Неизвестный формат файла");
                break;}
        }
        return dao;
    }
}
