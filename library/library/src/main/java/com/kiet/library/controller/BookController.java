
package com.kiet.library.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kiet.library.model.Book;
import com.kiet.library.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    // Constructor injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 1. GET all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // 2. GET book by ID
    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(
            @PathVariable int bookId) {

        Book book = bookService.getBookById(bookId);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Book not found"));
        }

        return ResponseEntity.ok(book);
    }

    // 3. POST add a new book
    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {

        // Check duplicate ID
        if (bookService.getBookById(book.getBookId()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("message", "Book ID already exists"));
        }

        Book savedBook = bookService.addBook(book);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedBook);
    }

    // 4. PUT update a book
    @PutMapping("/{bookId}")
    public ResponseEntity<?> updateBook(
            @PathVariable int bookId,
            @RequestBody Book updatedBook) {

        Book book = bookService.updateBook(bookId, updatedBook);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Book not found"));
        }

        return ResponseEntity.ok(book);
    }

    // 5. DELETE a book
    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(
            @PathVariable int bookId) {

        boolean deleted = bookService.deleteBook(bookId);

        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Book not found"));
        }

        return ResponseEntity.ok(
                Map.of("message", "Book deleted successfully"));
    }

    // 6. Search by category using @RequestParam
    @GetMapping("/search")
    public ResponseEntity<?> searchByCategory(
            @RequestParam String category) {

        List<Book> result =
                bookService.searchByCategory(category);

        if (result.isEmpty()) {
            return ResponseEntity.ok(
                    Map.of("message",
                            "No books found in this category"));
        }

        return ResponseEntity.ok(result);
    }

    // 7. Filter by publication year using @RequestParam
    @GetMapping("/published")
    public ResponseEntity<?> findPublishedFromYear(
            @RequestParam int fromYear) {

        List<Book> result =
                bookService.findPublishedFromYear(fromYear);

        if (result.isEmpty()) {
            return ResponseEntity.ok(
                    Map.of("message",
                            "No books found for this year"));
        }

        return ResponseEntity.ok(result);
    }
}

