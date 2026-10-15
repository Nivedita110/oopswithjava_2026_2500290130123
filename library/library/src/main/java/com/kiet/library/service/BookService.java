
package com.kiet.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kiet.library.model.Book;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    // Constructor: Add 5 sample books
    public BookService() {
        books.add(new Book(201, "Effective Java",
                "Joshua Bloch", "Programming", 2018, true));

        books.add(new Book(202, "Clean Code",
                "Robert C. Martin", "Programming", 2008, true));

        books.add(new Book(203, "The Alchemist",
                "Paulo Coelho", "Fiction", 1988, false));

        books.add(new Book(204, "Introduction to Algorithms",
                "Thomas H. Cormen", "Education", 2022, true));

        books.add(new Book(205, "Head First Java",
                "Kathy Sierra", "Programming", 2021, true));
    }

    // 1. Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // 2. Get book by ID
    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    // 3. Add a new book
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    // 4. Update an existing book
    public Book updateBook(int bookId, Book updatedBook) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setCategory(updatedBook.getCategory());
                book.setPublicationYear(
                        updatedBook.getPublicationYear());
                book.setAvailable(updatedBook.isAvailable());

                return book;
            }
        }
        return null;
    }

    // 5. Delete a book
    public boolean deleteBook(int bookId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == bookId) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    // 6. Search books by category
    public List<Book> searchByCategory(String category) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }
        return result;
    }

    // 7. Find books published from a specified year
    public List<Book> findPublishedFromYear(int fromYear) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getPublicationYear() >= fromYear) {
                result.add(book);
            }
        }
        return result;
    }
}

