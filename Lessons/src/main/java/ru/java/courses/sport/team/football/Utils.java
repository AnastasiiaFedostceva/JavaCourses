package ru.java.courses.sport.team.football;

class Utils {

    private Utils(){

    }

    public static boolean validateName(String name){
        if(name == null) return false;
        if(name.isEmpty()) return false;
        return true;
    }
}
