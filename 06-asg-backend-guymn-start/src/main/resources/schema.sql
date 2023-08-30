-- DROP TABLE IF EXISTS Book;
-- DROP TABLE IF EXISTS Genre;
-- DROP TABLE IF EXISTS GenreOfBook;
CREATE TABLE User(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255),
    pass VARCHAR(255)
);

CREATE TABLE Author (
    id INT PRIMARY KEY AUTO_INCREMENT,
    penname VARCHAR(255)
);

CREATE TABLE Book(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) ,
    pages INT,
    author_id INT,
    user_borrwed_id INT,
    FOREIGN KEY (author_id) REFERENCES Author(id),
    FOREIGN KEY (user_borrwed_id) REFERENCES User(id)
);

CREATE TABLE Genre(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255)
);

CREATE TABLE genres_on_books(
    id INT PRIMARY KEY AUTO_INCREMENT,
    genre_id INT,
    book_id INT,
    FOREIGN KEY (genre_id) REFERENCES Genre(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (book_id) REFERENCES Book(id) ON DELETE CASCADE ON UPDATE CASCADE,
    UNIQUE (genre_id, book_id)
);

