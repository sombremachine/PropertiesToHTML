package view;

import bean.User;

public class ViewToConsole implements View {
    @Override
    public void update(User user) {
        System.out.println("ФИО:");
        System.out.print(user.getLastName() + " ");
        System.out.print(user.getFirstName() + " ");
        System.out.println(user.getSecondName());
        System.out.println("Цель:");
        for (String value: user.getGoals()){
            System.out.println(" - " + value);
        }
        System.out.println("Опыт:");
        for (String value: user.getWorkExperience()){
            System.out.println(" - " + value);
        }
        System.out.println("Образование:");
        for (String value: user.getEducation()){
            System.out.println(" - " + value);
        }
        System.out.println("Доп. образование:");
        for (String value: user.getAdditionalAducation()){
            System.out.println(" - " + value);
        }
        System.out.println("Навыки:");
        for (String value: user.getSkills()){
            System.out.println(" - " + value);
        }
        System.out.println("Пример кода:");
        for (String value: user.getCodeSample()){
            System.out.println(" - " + value);
        }
    }
}
