package SmartLibrarySystem;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryService {
    private List<Book> books;
    private List<User> users;

    public LibraryService(List<Book> books, List<User> users) {
        this.books = books;
        this.users = users;
    }

    public void sortBooks() {
        var sorted_list = books.stream().sorted(
                        Comparator.comparing(Book::getRating).reversed()
                                .thenComparing(Book::getYear)
                                .thenComparing(Book::getTitle))
                .toList();
        System.out.println("sorted books: " + sorted_list);
    }

    public void analyzeLibrary() {
        long count = books.stream().count();
        var sum_rating = books.stream().map(Book::getRating).reduce(0.0, (a, b) -> (a + b));
        var average_rating = sum_rating / count;
        System.out.println("The average rating of books is " + average_rating);
        var new_books = books.stream().filter(book -> book.getYear() > 2000)
                .filter(book -> book.isAvailable = true)
                .toList();
        System.out.println("Available books written after 2000:" + new_books);
        var most_borrowed_books = users.stream().flatMap(user -> user.getBorrowRecords().stream())
                .collect(Collectors.groupingBy(BorrowRecord::getBook, Collectors.counting()));
        var most_borrowed_book = most_borrowed_books.entrySet().stream()
                .max((a, b) -> a.getValue().compareTo(b.getValue()));
        System.out.println("Most borrowed book in library: " + most_borrowed_book);

        var myyy_list = users.stream().collect(Collectors.toMap(
                user -> user.getName(),
                user-> user.getBorrowRecords().stream().filter(s-> s.getReturnDate().isEmpty()).toList()));
        System.out.println("Persons borrowed books: " + myyy_list);

        var books_sorted = books.stream().filter(book -> book.getYear() > 1950)
                .sorted(Comparator.comparing(Book::getAuthor)).toList();
        System.out.println("Books after 1950 sorted by Author: " + books_sorted);
    }

    ;

    public void findRecommendedBookForUser(User user) {
        if (user.getBorrowRecords().isEmpty()) {
            Optional<List<BorrowRecord>> optionalBorrowRecords = Optional.ofNullable(user.getBorrowRecords());
            System.out.println(optionalBorrowRecords);
        } else {
            if (user != null && user.getBorrowRecords().size() > 0) {
                var list_authors = user.getBorrowRecords().stream()
                        .map(BorrowRecord::getBook).map(Book::getAuthor).toList();
                var most_frequent = list_authors.stream()
                        .max(Comparator.comparingInt(e -> Collections.frequency(list_authors, e)));
                var recommended_one = books.stream().filter(book ->book.getAuthor()
                        .equals(most_frequent.get()))
                        .sorted(Comparator.comparing(Book::getRating).reversed()).findFirst().get();
                var optional_result = books.stream()
                        .filter(book -> book.getTitle().equals(recommended_one.getTitle()))
                        .filter(Book::isAvailable).findFirst();
                optional_result
                        .ifPresentOrElse(b-> System.out.println("Recommended Book: " + b),
                                () -> System.out.println("No recommended Book"));
            }
        }
    }
    public void uniqueAuthorsRead(){
        Set<String> unique_authors = users.stream().flatMap(user -> user.getBorrowRecords().stream())
                .map(r-> r.getBook().getAuthor())
                .collect(Collectors.toSet());
        System.out.println(unique_authors);
    }
    public void findTopReaderOfTheMonth(List<User> users, int month,int year) {
            var list_of_users = users.stream()
                    .flatMap(u -> u.getBorrowRecords().stream()
                            .map(r -> Map.entry(u.getName(), r.getBorrowDate())))
                    .filter(borrow ->borrow.getValue().getYear() == year &&
                            borrow.getValue().getMonthValue() == month)
                    .collect(Collectors.groupingBy(Map.Entry::getKey,
                            Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
                    .entrySet().stream().max(Comparator.comparingInt(entry -> entry.getValue().size()));;
        }





    }
