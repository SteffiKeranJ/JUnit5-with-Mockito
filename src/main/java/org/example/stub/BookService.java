package org.example.stub;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findNewBooksWithDiscount(int discount, int days) {
        List<Book> newBooks = bookRepository.getNewBooks(days);

        for (Book book : newBooks) {
            int price = book.getPrice();
            int discountedPrice = price - (price * discount / 100);
            book.setPrice(discountedPrice);
        }
        return newBooks;
    }

}
