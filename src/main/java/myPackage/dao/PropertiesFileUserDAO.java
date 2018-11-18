package myPackage.dao;

import myPackage.bean.User;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PropertiesFileUserDAO implements UserDAO {
    private static final Logger log = Logger.getLogger(PropertiesFileUserDAO.class);
    private Properties property = new Properties();
    private String fileName;

    public PropertiesFileUserDAO(String fileName) {
        this.fileName = fileName;
    }

    private Map<String, Integer> getMapField(String key) {
        String propertyValue = property.getProperty(key);
        if (propertyValue != null) {
            return Stream.of(propertyValue.split("\n")).collect(HashMap<String, Integer>::new,
                    (m, c) -> {
                        String[] splitted = c.split(":");
                        m.put(splitted[0], (splitted.length > 1) ? Integer.parseInt(splitted[1]) : 0);
                    },
                    (m, u) -> {
                    })
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        } else {
            log.warn("Ключ " + key + " не найден в файле свойств " + fileName + ", поле оставлено пустым");
            return null;
        }
    }

    private List<String> getListField(String key) {
//        ArrayList<String> result = null;
        String propertyValue = property.getProperty(key);
        if (propertyValue != null) {
            return Arrays.asList(propertyValue.split("\n"));
        } else {
//            System.err.println("Ключ " + key + " не найден в файле свойств, поле оставлено пустым");
            log.warn("Ключ " + key + " не найден в файле свойств " + fileName + ", поле оставлено пустым");
            return null;
        }
//        return result;
    }

    private String getField(String key) {
        String propertyValue = property.getProperty(key);
        if (propertyValue == null) {
//            System.err.println("Ключ " + key + " не найден в файле свойств, поле оставлено пустым");
            log.warn("Ключ " + key + " не найден в файле свойств " + fileName + ", поле оставлено пустым");
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
            user.setWorkExperience(getMapField("workExperience"));
            user.setEducation(getListField("education"));
            user.setAdditionalEducation(getListField("additionalEducation"));
            user.setSkills(getListField("skills"));
            user.setCodeSample(getListField("codeSample"));
            user.setImgSrc(getField("imgSrc"));
        }
        return user;
    }
}
