package LibService;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int year;
    private double rating;
    boolean isAvailable;

    public Book(String title, String author, int year, double rating,boolean isAvailable) {
       this.title = title;
       this.author = author;
       this.year = year;
       this.rating = rating;
       this.isAvailable = isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return year == book.year
                && Double.compare(book.rating, rating) == 0
                && Objects.equals(title, book.title)
                && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, rating);
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    @Override
    public String toString() {
        return  this.title+ " AUTHOR " + this.author
                + " YEAR " + this.year+  " RATING " + this.rating ;
    }
}
