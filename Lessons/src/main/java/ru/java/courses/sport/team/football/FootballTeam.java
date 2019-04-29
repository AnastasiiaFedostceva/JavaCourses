package ru.java.courses.sport.team.football;

import java.util.ArrayList;
import java.util.List;

public class FootballTeam {
    private String name;
    private Coach coach;
    private List<ScoringPlayer> players;

    private FootballTeam(){

    };

    public FootballTeam (String name){
        if(Utils.validateName(name)) {
            this.name = name;
            this.players = new ArrayList<>();
        }
        else {
            throw new IllegalArgumentException("Имя не может быть пустым или null");
        }

    }

    void setName (String name){
        if(Utils.validateName(name)) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Имя не может быть пустым или null");
        }

    }
    public String getName() {
        return name;
    }

    public void setCoach (Coach coach) {
        this.coach = coach;
    }
    public Coach getCoach() {
        return coach;
    }

    void setPlayer (ScoringPlayer player) {
        this.players.add(player);
    }

    public List<ScoringPlayer> getPlayers() {
        return this.players;
    }

    //функция удаления игрока из команды
    public ScoringPlayer removePlayer(ScoringPlayer player){
        for (int i=0; i < players.size(); i++){
            ScoringPlayer current = players.get(i);
            if (current.equals(player)){
                players.remove(i);
                return current;
            }
        }
        return null;
    }
//добавление игрока в команду
public void addPlayers (ScoringPlayer... players) {
    for (int i = 0; i < players.length; i++) {
        if (getMaxPlayersCount() + 1 <= 20) {
            this.players.add(players[i]);
        } else {
            throw new IllegalArgumentException("Невозможно добавить нового игрока");
        }
    }
}

    public void addPlayer(ScoringPlayer player) {
        addPlayers(player);
    }

//получение количества игроков в команде
public int getMaxPlayersCount(){
        return players.size();
    }

    //получение голов
public int getScore (){
        int sum = 0;
    for (int i=0; i < players.size(); i++) {
        ScoringPlayer current = players.get(i);
        sum+=current.getGoals();
    }
    return sum;
}



}


