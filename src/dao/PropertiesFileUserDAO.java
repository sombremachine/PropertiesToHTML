package dao;

import bean.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertiesFileUserDAO implements UserDAO {
    private Properties property = new Properties();
    private String fileName;

    public PropertiesFileUserDAO(String fileName) {
        this.fileName = fileName;
    }

    private List<String> getListField(String key){
        ArrayList<String> result = null;
        String propertyValue = null;
        propertyValue = property.getProperty(key);
        result = new ArrayList<>();
        for (String value: propertyValue.split("\n")) {
            result.add(value);
        }
        return result;
    }

    private String getField(String key) {
        return property.getProperty(key);
    }

    @Override
    public User getUserData() {
        User user = new User();
        FileInputStream fis;
        Reader reader = null;
        try {
            fis = new FileInputStream(fileName);
            reader = new InputStreamReader(fis, "UTF-8");
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.out.println("Файл " + fileName +" не найден");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            //TODO: check null
            property.load(reader);
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Ошибка при чтении файла " + fileName);
        }
        user.setFirstName(getField("firstName"));
        user.setSecondName(getField("secondName"));
        user.setLastName(getField("lastName"));
        user.setGoals(getListField("goals"));
        user.setWorkExperience(getListField("workExperience"));
        user.setEducation(getListField("education"));
        user.setAdditionalAducation(getListField("additionalEducation"));
        user.setSkills(getListField("skills"));
        user.setCodeSample(getListField("codeSample"));
        return user;
    }
}
