package by.mozolevskij.pharmacy.example.pattern.behavioral.observer;

import java.util.List;

public interface Observer {
    void handleEvent(List<String> vacancies);
}
