package memento_pattern.yc;

public class GameMemento {
    private String level;
    private int score;

    public GameMemento(String level, int score) {
        this.level = level;
        this.score = score;
    }

    public String getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }
}
