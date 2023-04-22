package org.example.annotations;

import java.util.Collection;

public interface BookRepository {

    void save(Book book);

    Collection<Book> findAll();
}
