package org.example.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryStub implements BookRepository {
    @Override public List<Book> getNewBooks(int days) {
        List<Book> newBooks = new ArrayList<>();
        newBooks.add(new Book("1", "Mockito 101", 1000, LocalDate.now()));
        newBooks.add(new Book("2", "JUnit 101", 200, LocalDate.now()));

        return newBooks;
    }
}
