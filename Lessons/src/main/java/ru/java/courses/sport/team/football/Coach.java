package ru.java.courses.sport.team.football;

public class Coach {
    private int experience;
    private String name;

    private Coach() {

    }

    //создаем конструктор
    public Coach (String name) {
        if(Utils.validateName(name)) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Имя не может быть пустым или null");
        }
    }
//создаем геттеры и сеттеры для действий с полями объекта Coach
    void setName (String name){
        if (Utils.validateName(name)) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Имя не может быть пустым или null");
        }
    }
    public void setExperience (int experience){
        this.experience = experience;
    }
    public String getName() {
        return name;
    }
    public int getExperience () {
        return experience;
    }
}
