package by.mozolevskij.pharmacy.example.sql_hibernate_additional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonEntityRep extends JpaRepository<HibernateEntityPerson, Integer> {
}
