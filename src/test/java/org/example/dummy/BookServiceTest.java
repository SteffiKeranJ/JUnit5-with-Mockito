package org.example.dummy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {

    @Test
    @DisplayName("Testing Book Service Class with Dummy Book Repository")
    public void TestBookService() {
        BookRepository bookRepository = new BookRepositoryTest();
        EmailService emailService = new EmailServiceTest();
        BookService bookService = new BookService(bookRepository, emailService);

        bookService.addBook(new Book("1", "Mockito 101", 900, LocalDate.now()));
        bookService.addBook(new Book("2", "JUnit 101", 500, LocalDate.now()));

        int expected = 2;
        int actual = bookService.findBookCount();
        assertEquals(expected, actual, "Should return the correct book count");
    }

    @Test
    @DisplayName("Testing with Mockito")
    public void testBookServiceMockito() {
        BookRepository bookRepository = mock(BookRepository.class);
        EmailService emailService = mock(EmailService.class);
        BookService bookService = new BookService(bookRepository, emailService);

        Collection<Book> books = new ArrayList<>();
        Book book1 = new Book("1", "Mockito 101", 900, LocalDate.now());
        Book book2 = new Book("2", "JUnit 101", 500, LocalDate.now());

        books.add(book1);
        books.add(book2);

        when(bookRepository.findAll()).thenReturn(books);

        assertEquals(2, bookService.findBookCount());
    }

}