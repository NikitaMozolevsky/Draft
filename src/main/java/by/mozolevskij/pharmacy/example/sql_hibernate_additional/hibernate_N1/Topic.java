package by.mozolevskij.pharmacy.example.sql_hibernate_additional.hibernate_N1;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String title;
    public Topic(String title){
        this.title=title;
    }
}