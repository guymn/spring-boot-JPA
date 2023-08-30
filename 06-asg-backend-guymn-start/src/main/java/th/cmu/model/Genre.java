package th.cmu.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany(mappedBy = "genres")
    private Set<Book> books;

    public Genre() {
    }

    public Genre(Long id, String title) {
        this.id = id;
        this.title = title;
        this.books = new HashSet<>();
    }

    public Genre(Long id, String title, Set<Book> books) {
        this.id = id;
        this.title = title;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void addBooks(Book book) {
        this.books.add(book);
        book.addGenres(this);
    }

}
