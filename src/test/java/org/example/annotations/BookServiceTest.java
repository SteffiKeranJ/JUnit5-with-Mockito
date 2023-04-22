package org.example.annotations;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;
    private EmailService emailService;

    @Test
    @DisplayName("Test with Mockito When-ThenReturn annotations")
    public void testBookServiceAnnotations() {

        Collection<Book> books = new ArrayList<>();
        Book book1 = new Book("1", "Mockito 101", 900, LocalDate.now());
        Book book2 = new Book("2", "JUnit 101", 500, LocalDate.now());

        books.add(book1);
        books.add(book2);

        when(bookRepository.findAll()).thenReturn(books);

        assertEquals(2, bookService.findBookCount());
    }

    @Test
    @DisplayName("Test with Mockito DoReturn-When annotations")
    public void testBookServiceAnnotationDoReturn() {

        Collection<Book> books = new ArrayList<>();
        Book book1 = new Book("1", "Mockito 101", 900, LocalDate.now());
        Book book2 = new Book("2", "JUnit 101", 500, LocalDate.now());

        books.add(book1);
        books.add(book2);

        doReturn(books).when(bookRepository).findAll();
        assertEquals(2, bookService.findBookCount());
    }

}