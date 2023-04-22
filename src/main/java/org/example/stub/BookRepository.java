package org.example.stub;

import java.util.List;

public interface BookRepository {
    List<Book> getNewBooks(int days);
}
