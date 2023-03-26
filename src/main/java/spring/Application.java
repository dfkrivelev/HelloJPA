package spring;

/**
 * Java Prof. Homework #36
 *
 * @author Dzmitry Kryvialeu
 * @version 23.03 - 26.03
 */

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.domain.Person;
import spring.service.PersonService;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("spring");
        context.refresh();

        PersonService personService = (PersonService) context.getBean("personService");

        Person person = new Person("Petr", "Petrov");
        Person person1 = new Person("Mister", "Proper");
        Person person2 = new Person("Capi", "Bara");
        Person person3 = new Person("Crazy", "Frog");
//        personService.add(person);
//        personService.add(person1);
//        personService.add(person2);
//        personService.add(person3);

        Iterable<Person> persons = personService.findAll();
        System.out.println(persons);

//      personService.deleteById(16);
//        personService.update(17, "Inspector", "Gadget");
        personService.update(18, "CAAAAPI", "BAAARAAA");
    }
}
