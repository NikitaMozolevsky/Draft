package by.mozolevskij.pharmacy.example.sql_hibernate_additional;

import by.mozolevskij.pharmacy.example.sql_hibernate_additional.enums.Mood;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class HibernateEntityPerson {

    @Id
    private int id;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType./*Тип в БД*/ DATE) //спринг понимает что это дата, и конвертирует его в нужный тип
    @DateTimeFormat(pattern = "dd/MM/yyyy"/*MM - месяц, mm - минуты*/)
    //Спринг автоматически преобразует строку даты в дату по указанному паттрену
    private Date dateOfBirth;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @Enumerated(EnumType.ORDINAL/**Сохраняет в таблицу число, кторое указывает на Mood*/) //способность сохранять перечисление в таблицу
    private Mood mood;

    @Enumerated(EnumType.STRING/**Сохраняет в таблицу строку Mood*/) //способность сохранять перечисление в таблицу
    private Mood moodSecond;
}
