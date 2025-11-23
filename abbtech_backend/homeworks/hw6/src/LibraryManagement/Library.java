package LibraryManagement;

import java.util.ArrayList;
import java.util.List;

public class Library <T extends Library.Section> {
    private String name;
    private List<T> sections = new ArrayList<>();
    void addSection(T section) {
        sections.add(section);
    };
    void displayAllSections() {
        for  (T section : sections) {
            System.out.println(section.getName());
        }
    };
    void filterBooks(BookFilter filter) {
        for   (T section : sections) {
            for (Library<?>.Book book : section.getBooks()){
                if (filter.filter(book) == true){
                    System.out.println(book);
                }

            }
        }
        };

    public class Book {
        private String title;
        private String author;
        private int year;
        public Book(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }
        public String toString() {
            return "Book {title=" + title + ", author=" + author + ", year=" + year + "}";
        }
        public String getTitle() {
            return title;
        }
        public String getAuthor() {
            return author;
        }
        public int getYear() {
            return year;
        }
    }








    public static class Section {
        private String name;
        private List<Library<?>.Book> books = new ArrayList<>();


        public Section(String name) {
            this.name = name;
        }
        public Object getName() {
            return name;
        }
        public List<Library<?>.Book> getBooks() {
            return books;
        }



        public void addBook(Library<?>.Book book_name){
            books.add(book_name);
        };
        public void displayAllBooks() {
            System.out.println(books);
        }
    }

}
