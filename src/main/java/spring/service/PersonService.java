package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.domain.Person;
import spring.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public void add(Person person) {
        personRepository.save(person);
    }

    public void deleteById(Integer id) {
        if (id != null) {
            personRepository.deleteById(id);
        }
    }

    public void update(Integer id, String newFirstName, String newLastName) {
        for (Person persons : personRepository.findAll()) {
            if (persons.getId() == id) {
                persons.setFirstname(newFirstName);
                persons.setLastname(newLastName);
                personRepository.save(persons);
            }
        }
    }
}