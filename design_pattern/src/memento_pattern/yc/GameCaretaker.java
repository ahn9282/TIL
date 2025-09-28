package memento_pattern.yc;

import java.util.ArrayList;
import java.util.List;

public class GameCaretaker {
    private List<GameMemento> mementoList = new ArrayList<>();

    public void add(GameMemento game) {
        mementoList.add(game);
    }

    public GameMemento get(int index) {
        return mementoList.get(index);
    }
}
