package by.mozolevskij.pharmacy.example.pattern.observer;

import java.util.List;

public interface Observer {
    void handleEvent(List<String> vacancies);
}
