package ru.java.courses.sport.team.football;

import java.util.Objects;

public class ScoringPlayer {

    String name;
    int score;
    boolean active;
    PlayerRole role;

    private ScoringPlayer() {

    }

    public ScoringPlayer(String name, PlayerRole role) {
        if(Utils.validateName(name) && role != null){
            this.name = name;
            this.role = role;
            this.active = true;
        } else {
            throw new IllegalArgumentException("Имя не может быть пустым или null");
        }
    }

    public String getName() {
        return this.name;
    }

    void setName(String name) {
        if(Utils.validateName(name)) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Имя не может быть пустым или null");
        }

    }

   public  int getGoals() {
        return score;
    }

    void setScore(int score) {
        this.score = score;
    }

    boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public PlayerRole getRole() {
        return role;
    }

    void setRole(PlayerRole role) {
        this.role = role;
    }

   public void score(){
        if(this.active){
            this.score+=1;
        } else {
            throw new IllegalArgumentException("Игрок не активен");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoringPlayer that = (ScoringPlayer) o;
        return score == that.score &&
                active == that.active &&
                name.equals(that.name) &&
                role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, active, role);
    }
}
