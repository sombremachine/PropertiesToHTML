package main.java.bean;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String firstName;
    private String secondName;
    private String lastName;
    private String birthDate;
    private String imgSrc;
    private List<String> phone;
    private List<String> email;
    private List<String> goals;
    private List<String> workExperience;
    private List<String> education;
    private List<String> additionalEducation;
    private List<String> skills;
    private List<String> codeSample;

    public User() {
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getGoals() {
        return goals;
    }

    public void setGoals(List<String> goals) {
        this.goals = goals;
    }

    public List<String> getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(List<String> workExperience) {
        this.workExperience = workExperience;
    }

    public List<String> getEducation() {
        return education;
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }

    public List<String> getAdditionalEducation() {
        return additionalEducation;
    }

    public void setAdditionalEducation(List<String> additionalAducation) {
        this.additionalEducation = additionalAducation;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getCodeSample() {
        return codeSample;
    }

    public void setCodeSample(List<String> codeSample) {
        this.codeSample = codeSample;
    }
}
