package th.cmu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import th.cmu.model.Author;
import th.cmu.model.Book;
import th.cmu.model.Genre;
import th.cmu.model.User;
import th.cmu.repository.AuthorRepository;
import th.cmu.repository.BookRepository;
import th.cmu.repository.GenreRepository;
import th.cmu.repository.UserRepositoty;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        Object dataSource = context.getBean("dataSource");
        System.out.println(dataSource);
    }

    @Bean
    CommandLineRunner commandLineRunner(AuthorRepository authorRepository, BookRepository bookRepository,
            GenreRepository genreRepository, UserRepositoty userRepositoty) {
        return args -> {
            Author author = new Author(null, "Mark Heckler");
            Genre genre1 = new Genre(null, "Action");
            Genre genre2 = new Genre(null, "Comedy");
            Book book1 = new Book(null, "Up and Running", 328, new Author(null, "sss"));
            Book book2 = new Book(null, "Fly man", 347, new Author(null, "sss"));
            User user = new User(null, "guyman", "zxcv");

            authorRepository.save(author);
            genreRepository.save(genre1);
            genreRepository.save(genre2);

            bookRepository.save(book1);
            bookRepository.save(book2);

            userRepositoty.save(user);
        };
    }

}