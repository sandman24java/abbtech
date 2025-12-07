package LibService;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryService {
    private List<Book> books;
    private List<User> users;


    public LibraryService(List<Book> books, List<User> users) {
        this.books = books;
        this.users = users;
    }
    public double getAverageRating() {
        long count = books.stream().count();
        var sum_rating = books.stream().map(Book::getRating).reduce(0.0, (a, b) -> (a + b));
        return sum_rating / count;
    }
    public List<Book> getNewBooks() {
        return books.stream().filter(book -> book.getYear() > 2000)
                .filter(book -> book.isAvailable = true)
                .toList();
    }
    public Optional<Map.Entry<Book, Long>> getMostBorrowedBook() {
        var most_borrowed_books = users.stream().flatMap(user -> user.getBorrowRecords().stream())
                .collect(Collectors.groupingBy(BorrowRecord::getBook, Collectors.counting()));
        return most_borrowed_books.entrySet().stream()
                .max((a, b) -> a.getValue().compareTo(b.getValue()));
    }
    public Map<User,List<Book>> getDiffUserBorrowedBooks() {
         return users.stream()
                .filter(user -> user.getBorrowRecords().stream()
                        .anyMatch(record -> record.getReturnDate().isEmpty()))
                .collect(Collectors.toMap(
                        user -> new User(
                                user.getName(),
                                user.getAge(),
                                Collections.emptyList()
                        ),
                        user -> user.getBorrowRecords().stream()
                                .filter(r -> r.getReturnDate().isEmpty()).map(BorrowRecord::getBook)
                                .toList()
                ));

    }
    public List<Book> getBooksSortedByAuthor() {
        return books.stream().filter(book -> book.getYear() > 1950)
                .sorted(Comparator.comparing(Book::getAuthor)).toList();
    }

    public void analyzeLibrary() {
        System.out.println("The average rating of books is " + this.getAverageRating());
        System.out.println("Available books written after 2000:" + this.getNewBooks());
        System.out.println("Most borrowed book in library: " + this.getMostBorrowedBook());
        System.out.println("Persons borrowed books: " + this.getDiffUserBorrowedBooks());
        System.out.println("Books after 1950 sorted by Author: " + this.getBooksSortedByAuthor());
    };

    public String sortBooks() {
        List<Book> sorted_list = books.stream().sorted(
                        Comparator.comparing(Book::getRating).reversed()
                                .thenComparing(Book::getYear)
                                .thenComparing(Book::getTitle))
                .toList();
        return "sorted books: " + sorted_list;
    }



    public Optional<Book> findRecommendedBookForUser(User user) {
        if (user == null || user.getBorrowRecords().isEmpty()) {
            return Optional.empty();
        } else {
            var list_authors = user.getBorrowRecords().stream()
                    .map(BorrowRecord::getBook).map(Book::getAuthor).toList();
            var most_frequent = list_authors.stream()
                    .max(Comparator.comparingInt(e -> Collections.frequency(list_authors, e)));
            var recommended_one = books.stream().filter(book -> book.getAuthor()
                            .equals(most_frequent.get()))
                    .sorted(Comparator.comparing(Book::getRating).reversed()).findFirst().get();
            return books.stream()
                    .filter(book -> book.getTitle().equals(recommended_one.getTitle()))
                    .filter(Book::isAvailable).findFirst();
        }
    }

    public Set<String> uniqueAuthorsRead(){
        return users.stream().flatMap(user -> user.getBorrowRecords().stream())
                .map(r-> r.getBook().getAuthor())
                .collect(Collectors.toSet());
    }

    public Optional<Map.Entry<String, List<java.time.LocalDate>>> findTopReaderOfTheMonth(List<User> users, int month, int year) {
            return users.stream()
                    .flatMap(u -> u.getBorrowRecords().stream()
                            .map(r -> Map.entry(u.getName(), r.getBorrowDate())))
                    .filter(borrow ->borrow.getValue().getYear() == year &&
                            borrow.getValue().getMonthValue() == month)
                    .collect(Collectors.groupingBy(Map.Entry::getKey,
                            Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
                    .entrySet().stream().max(Comparator.comparingInt(entry -> entry.getValue().size()));

        }





    }
