package org.example.verification;

import java.util.Collection;

public interface BookRepository {

    void save(Book book);

    Collection<Book> findAll();
}
