package observer_pattern.yc;


public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);

    void notifyObservers();
}
