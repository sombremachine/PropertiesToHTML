package dao;

import bean.User;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertiesFileUserDAO implements UserDAO {
    private static final Logger log = Logger.getLogger(PropertiesFileUserDAO.class);
    private Properties property = new Properties();
    private String fileName;

    public PropertiesFileUserDAO(String fileName) {
        this.fileName = fileName;
    }

    private List<String> getListField(String key) {
//        ArrayList<String> result = null;
        String propertyValue = property.getProperty(key);
        if (propertyValue != null) {
            return Arrays.asList(propertyValue.split("\n"));
        } else {
//            System.err.println("Ключ " + key + " не найден в файле свойств, поле оставлено пустым");
            log.error("Ключ " + key + " не найден в файле свойств, поле оставлено пустым");
            return null;
        }
//        return result;
    }

    private String getField(String key) {
        String propertyValue = property.getProperty(key);
        if (propertyValue == null) {
//            System.err.println("Ключ " + key + " не найден в файле свойств, поле оставлено пустым");
            log.error("Ключ " + key + " не найден в файле свойств, поле оставлено пустым");
        }
        return propertyValue;
    }

    @Override
    public User getUserData() {
        User user = null;
        FileInputStream fis;
        Reader reader = null;
        try {
            fis = new FileInputStream(fileName);
            reader = new InputStreamReader(fis, "UTF-8");
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.err.println("Файл " + fileName +" не найден");
            log.error("Файл " + fileName + " не найден");
//            return null;
            throw new RuntimeException("Файл " + fileName + " не найден");
        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
            return null;
        }
        try {
            //TODO: check null
            property.load(reader);
        } catch (IOException e) {
//            e.printStackTrace();
//            System.err.println("Ошибка при чтении файла " + fileName);
            log.error("Ошибка при чтении файла " + fileName);
            return null;
        }
        if (!property.isEmpty()) {
            user = new User();
            user.setFirstName(getField("firstName"));
            user.setSecondName(getField("secondName"));
            user.setLastName(getField("lastName"));
            user.setBirthDate(getField("birthDate"));
            user.setPhone(getListField("phone"));
            user.setEmail(getListField("email"));
            user.setGoals(getListField("goals"));
            user.setWorkExperience(getListField("workExperience"));
            user.setEducation(getListField("education"));
            user.setAdditionalEducation(getListField("additionalEducation"));
            user.setSkills(getListField("skills"));
            user.setCodeSample(getListField("codeSample"));
            user.setImgSrc(getField("imgSrc"));
        }
        return user;
    }
}
