package org.example.stub;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BookServiceTest {

    @Test
    public void testStubService() {
        BookRepository bookRepository = new BookRepositoryStub();
        BookService bookService = new BookService(bookRepository);

        List<Book> newBooks = bookService.findNewBooksWithDiscount(10, 1);
        assertEquals(2, newBooks.size());
        assertAll(
            () -> assertEquals(900, newBooks.get(0).getPrice()),
            () -> assertEquals(180, newBooks.get(1).getPrice())
        );
    }

}