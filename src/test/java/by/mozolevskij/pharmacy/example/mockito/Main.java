package by.mozolevskij.pharmacy.example.mockito;

import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
/*
        пытаюсь создать mock для final класса или mock-экземпляр enum либо переопределить поведение final метода.

        файл test/resources/mockito-extensions/org.mockito.plugins.MockMaker и вписать в него строчку:

        mock-maker-inline*/

        DataService dataServiceMock = Mockito.mock(DataService.class); //Mock экземпляр нужного класса, заглушка

        DataService dataServiceSpy = Mockito.spy(DataService.class); //можно создавать на основе как класса, так и готового объекта

        DataService dataService = new DataService();
        dataServiceSpy = Mockito.spy(dataService);

        List<String> data = new ArrayList<>();
        data.add("dataItem");
        Mockito.when(dataService.getAllData()).thenReturn(data);
    }
}
