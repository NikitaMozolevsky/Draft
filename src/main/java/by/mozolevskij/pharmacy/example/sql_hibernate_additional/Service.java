package by.mozolevskij.pharmacy.example.sql_hibernate_additional;

import by.mozolevskij.pharmacy.example.sql_hibernate_additional.enums.Mood;
import org.springframework.transaction.annotation.Transactional;

public class Service {
    private final PersonEntityRep personEntityRep;

    public Service(PersonEntityRep personEntityRep) {
        this.personEntityRep = personEntityRep;
    }

    @Transactional
    public void save(HibernateEntityPerson hibernateEntityPerson) {
        hibernateEntityPerson.setMood(Mood.ANGRY); //переведется в число 2
        personEntityRep.save(hibernateEntityPerson);
    }
}
