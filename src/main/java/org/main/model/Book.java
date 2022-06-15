package org.main.model;


import java.io.Serializable;

public class Book implements Serializable {

    private Integer BookId;
    private String Title;
    private String Description;
    private Integer Year;
    private Integer AuthorId;

    public Book() {

    }

    public Book(Integer bookId, String title, String description, Integer year, Integer authorId) {
        this.BookId = bookId;
        this.Title = title;
        this.Description = description;
        this.Year = year;
        this.AuthorId = authorId;
    }

    public Integer getBookId() {
        return BookId;
    }

    public void setBookId(Integer bookId) {
        this.BookId = bookId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        this.Year = year;
    }

    public Integer getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(Integer authorId) {
        this.AuthorId = authorId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + BookId +
                ", title='" + Title + '\'' +
                ", description='" + Description + '\'' +
                ", year=" + Year +
                ", authorId=" + AuthorId +
                '}';
    }
}
