import DZ4.book.Book;
import DZ4.book.BookRepository;
import DZ4.book.BookService;
import DZ4.book.InMemoryBookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.ARRAY;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    InMemoryBookRepository inMemoryBookRepository;

    @BeforeEach
    void setUp(){
        inMemoryBookRepository = mock(InMemoryBookRepository.class);
    }


    @Test
    void findBookByIdTest(){
        Book book1 = new Book("1", "Book1", "Author1");
        Book book2 = new Book("2", "Book2", "Author2");
        BookService bookService = new BookService(inMemoryBookRepository);

        when(inMemoryBookRepository.findById("1")).thenReturn(book1);
        when(inMemoryBookRepository.findById("2")).thenReturn(book2);

        assertThat(bookService.findBookById("1")).isEqualTo(book1);
        assertThat(bookService.findBookById("2")).isEqualTo(book2);
        verify(inMemoryBookRepository, times(1)).findById("1");
    }

    @Test
    void findAllBooksTest(){

        Book book1 = new Book("1", "Book1", "Author1");
        Book book2 = new Book("2", "Book2", "Author2");
        BookService bookService = new BookService(inMemoryBookRepository);

        when(inMemoryBookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        assertThat(bookService.findAllBooks()).isEqualTo(Arrays.asList(book1, book2));
        verify(inMemoryBookRepository, times(1)).findAll();
    }

}
