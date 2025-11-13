//package hu.unideb.runner;
//
//import hu.unideb.model.Author;
//import hu.unideb.model.Book;
//import hu.unideb.repository.AuthorRepository;
//import hu.unideb.repository.BookRepository;
//import hu.unideb.util.BookUtils;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//
//
//import static hu.unideb.util.BookUtils.FAKER;
//
//@Component
//@AllArgsConstructor
//@Order(1)
//@Slf4j
//public class BookRunner implements CommandLineRunner {
//
//
//    private final BookRepository bookRepository;
//
//
//    private final BookUtils bookUtils = new BookUtils();
//
//
//    @Override
//    public void run(String... args) throws Exception {
////        for (int i = 0; i < 100; i++) {
////            final var book = bookRepository.save(Book.builder()
////                    .ISBN(bookUtils.getISBN())
////                    .title(FAKER.book().title())
////                    .publisher(FAKER.book().publisher())
////                    .price(bookUtils.getPrice())
////                    .build());
////
////
////            log.info(book.toString());
////        }
////
//    }
//}