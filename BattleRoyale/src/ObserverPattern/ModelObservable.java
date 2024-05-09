package ObserverPattern;

public interface ModelObservable {
    public void attach(ModelObserver modelObserver);
    public void detach(ModelObserver modelObserver);
    public void notifyObservers();
}
