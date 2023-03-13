package by.mozolevskij.pharmacy.example.pattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class JavaDeveloperJobSite implements Observed {
    List<String>   vacancies   = new ArrayList<>();
    List<Observer> subscribers = new ArrayList<>();
    
    public void addVacancy(String vacancy) {
        vacancies.add(vacancy);
        notifyObserver();
    }

    public void removeVacancy(String vacancy) {
        vacancies.remove(vacancy);
        notifyObserver();
    }

    @Override
    public void addObserver(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : subscribers) {
            observer.handleEvent(vacancies);
        }
    }
}
