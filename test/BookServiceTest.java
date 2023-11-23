import DZ4.book.Book;
import DZ4.book.BookRepository;
import DZ4.book.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    BookRepository bookRepository;


    @Test
    void findBookByIdTest(){
        Book book1 = new Book("1", "testTitle1", "testAuthor1");
        Book book2 = new Book("2", "testTitle2", "testAuthor2");
        Book book3 = new Book("3", "testTitle3", "testAuthor3");

        bookRepository = mock(BookRepository.class);
        when(bookRepository.findById("1")).thenReturn(book1);
        when(bookRepository.findById("2")).thenReturn(book2);
        when(bookRepository.findById("3")).thenReturn(book3);

        BookService bookService = new BookService(bookRepository);
        assertThat(bookService.findBookById("1")).isEqualTo(book1);
        assertThat(bookService.findBookById("2")).isEqualTo(book2);
        assertThat(bookService.findBookById("3")).isEqualTo(book3);
        verify(bookRepository, times(1)).findById("1");

    }



}
