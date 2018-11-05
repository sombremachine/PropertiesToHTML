package bean;

import java.util.Collections;

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
        user.setWorkExperience(Collections.singletonList("workExperience"));
        user.setEducation(Collections.singletonList("education"));
        user.setAdditionalEducation(Collections.singletonList("additionalEducation"));
        user.setSkills(Collections.singletonList("skills"));
        user.setCodeSample(Collections.singletonList("codeSample"));
        user.setImgSrc("imgSrc");
        return user;
    }
}
