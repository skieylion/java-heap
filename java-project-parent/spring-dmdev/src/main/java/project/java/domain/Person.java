package project.java.domain;

import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
public class Person {
    List<Book> books;
    Address address;

    public Person(List<Book> books, Address address) {
        this.books = books;
        this.address = address;
    }

    Set<Medal> medals;

    public void setMedals(Set<Medal> medals) {
        this.medals = medals;
    }
}
