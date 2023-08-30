# 06-asg-backend-guymn
06-asg-backend-guymn created by GitHub Classroom

This assignment is made in the form of a library.
Domain Model
 1.User : User is a person who wants to enter the library to rent books. The User model has the information below.
        private Long id;   //id is primary key
        private String username;   //username is the username from which the user will log in.
        private String pass;   //pass is the password from which the user will log in.
    
 2.Author : Author is a person who write books that has in library. The Author model has the information below.
        private Long id;    //id is primary key
        private String penname;    //penname is a name a writer uses instead of their own.
        
 3.Book : Book is books that has in library. The Book model has the information below.
        private Long id;    //id is primary key.
        private String title;    //title is the name og book.
        private int pages;    //pages is the number of pages of the book.
        private Author author;    //author is the author that write this book. 
                                  //Relationship is @ManyToOne. A book can only have an author, But an author can have multiple books.
        private User user;    //user is the user who borrowed this book. The user is null if no one borrows the book. 
                              //Relationship is @ManyToOne. A book can only have an user who borrow, But an user can have multiple books.
        private Set<Genre> genres;   //genres are genre of this book.
                                      //Relationship is @ManyToMany. genre and book can have multiple of each.

 4.genre
        private Long id;   //id is primary key.
        private String title    //title is the name of genre.
        private Set<Book> books;     //books are book that have this genre.
                                     //Relationship is @ManyToMany. genre and book can have multiple of each.
