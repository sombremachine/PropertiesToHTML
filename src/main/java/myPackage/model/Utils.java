package myPackage.model;

import myPackage.bean.User;

import java.util.*;

public class Utils {

    public static <T> List<T> mergeLists(List<T> l1, List<T> l2) {
        List<T> result = new ArrayList<>();
        if (l1 != null) {
            result.addAll(l1);
        }
        if (l2 != null) {
            result.addAll(l2);
        }
        return result;
    }

    public static User mergeUsers(User u1, User u2) {
        User result = new User();
        if ((u1 != null) && (u2 != null)) {
            result.setFirstName(u1.getFirstName() == null ? u2.getFirstName() : u1.getFirstName());
            result.setSecondName(u1.getSecondName() == null ? u2.getSecondName() : u1.getSecondName());
            result.setLastName(u1.getLastName() == null ? u2.getLastName() : u1.getLastName());
            result.setBirthDate(u1.getBirthDate() == null ? u2.getBirthDate() : u1.getBirthDate());
            result.setImgSrc(u1.getImgSrc() == null ? u2.getImgSrc() : u1.getImgSrc());

            result.setCodeSample(mergeLists(u1.getCodeSample(), u2.getCodeSample()));
            result.setSkills(mergeLists(u1.getSkills(), u2.getSkills()));
            result.setPhone(mergeLists(u1.getPhone(), u2.getPhone()));
            result.setEmail(mergeLists(u1.getEmail(), u2.getEmail()));
            result.setGoals(mergeLists(u1.getGoals(), u2.getGoals()));
            result.setEducation(mergeLists(u1.getEducation(), u2.getEducation()));
            result.setAdditionalEducation(mergeLists(u1.getAdditionalEducation(), u2.getAdditionalEducation()));

            Map<String, Integer> workExperience = new LinkedHashMap<>();
            if (u1.getWorkExperience() != null) {
                workExperience.putAll(u1.getWorkExperience());
            }
            if (u2.getWorkExperience() != null) {
                workExperience.putAll(u2.getWorkExperience());
            }
            result.setWorkExperience(workExperience);
        } else {
            if (u1 != null) {
                return u1;
            }
            if (u2 != null) {
                return u2;
            }
        }
        return result;
    }
}
