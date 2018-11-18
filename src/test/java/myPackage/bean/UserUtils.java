package myPackage.bean;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserUtils {
    public static User getTestUser(){
        User user = new User();
        user.setFirstName("firstName");
        user.setSecondName("secondName");
        user.setLastName("lastName");
        user.setBirthDate("birthDate");
        user.setPhone(Collections.singletonList("phone"));
        user.setEmail(Collections.singletonList("email"));
        user.setGoals(Collections.singletonList("goals"));
        Map<String,Integer> exp = new LinkedHashMap<>();
        exp.put("aaa",10);
        exp.put("bbb",20);
        exp.put("ccc",30);
        user.setWorkExperience(exp);
        user.setEducation(Collections.singletonList("education"));
        user.setAdditionalEducation(Collections.singletonList("additionalEducation"));
        user.setSkills(Collections.singletonList("skills"));
        user.setCodeSample(Collections.singletonList("codeSample"));
        user.setImgSrc("imgSrc");
        return user;
    }
}
