package LibService;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LibServiceTest {
    LibraryService my_service;
    static List <User> users;
    static List <Book> books;
    @BeforeAll
    public void setUp(){
        Book b1 = new Book("1984", "George Orwell", 1949, 4.9, true);
        Book b2 = new Book("Animal Farm", "George Orwell", 1945, 4.8, false);
        Book b3 = new Book("Clean Code", "Robert Martin", 2008, 4.7, true);
        Book b4 = new Book("Effective Java", "Joshua Bloch", 2018, 4.9, true);
        Book b5 = new Book("The Pragmatic Programmer", "Andy Hunt", 1999, 4.6, true);
        Book b6 = new Book("Java Concurrency in Practice", "Brian Goetz", 2006, 4.5, false);
        books = Arrays.asList(b1, b2, b3, b4, b5, b6);

        User u1 = new User("Aydin", 25, Arrays.asList(
                new BorrowRecord(b1, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 10)),
                new BorrowRecord(b3, LocalDate.of(2025, 10, 5), null),
                new BorrowRecord(b2,LocalDate.of(2025, 10, 5), LocalDate.of(2025, 10, 8))
        ));
        User u2 = new User("Leyla", 22, Arrays.asList(
                new BorrowRecord(b4, LocalDate.of(2025, 10, 2), LocalDate.of(2025, 10, 20)),
                new BorrowRecord(b6, LocalDate.of(2025, 10, 12), null)
        ));
        User u3 = new User("Murad", 28, Arrays.asList(
                new BorrowRecord(b5, LocalDate.of(2025, 9, 10), LocalDate.of(2025, 9, 25))
        ));
        users = Arrays.asList(u1, u2, u3);
        my_service = new LibraryService(books, users);
    }
    @Test
    public void testSortBooks(){
        String actual = my_service.sortBooks();
        List<Book> expectedList = Arrays.asList(
                new Book("1984", "George Orwell", 1949, 4.9, true),
                new Book("Effective Java", "Joshua Bloch", 2018, 4.9, true),
                new Book("Animal Farm", "George Orwell", 1945, 4.8, false),
                new Book("Clean Code", "Robert Martin", 2008, 4.7, true),
                new Book("The Pragmatic Programmer", "Andy Hunt", 1999, 4.6, true),
                new Book("Java Concurrency in Practice", "Brian Goetz", 2006, 4.5, false)
        );
        String expected = "sorted books: " + expectedList;
        Assertions.assertEquals(expected, actual,"Sorting is wrong");
    }
    @Test
    public void testGetAverageRating(){
        double actual = my_service.getAverageRating();
        double expected = 4.733333333333333;
        Assertions.assertEquals(expected,actual,"Average rating is wrong");
    }
    @Test
    public void testGetNewBooks(){
        List<Book> actual = my_service.getNewBooks();
        List<Book> expected = Arrays.asList(
                new Book("Clean Code", "Robert Martin", 2008, 4.7, true),
                new Book("Effective Java", "Joshua Bloch", 2018, 4.9, true),
                new Book("Java Concurrency in Practice", "Brian Goetz", 2006, 4.5, false)
                );
        Assertions.assertEquals(expected,actual,"List of books is wrong");

    }

    @Test
    public void testGetMostBorrowedBook(){
        Optional<Map.Entry<Book, Long>> actual  = my_service.getMostBorrowedBook();
        Book book = books.get(4);
        Map.Entry<Book,Long> mostBorrowed = Map.entry(book,1L);
        Optional <Map.Entry<Book,Long>> opt = Optional.of(mostBorrowed);
        Optional<Map.Entry<Book, Long>> expected = opt;
        Assertions.assertEquals(expected,actual,"Most Borrowed Book is wrong");

    }

    @Test
    public void testGetDiffUsersBorrowedBooks(){
        Map<User,List<Book>> actual =  my_service.getDiffUserBorrowedBooks();
        Map<User,List<Book>> mapOfExpectedElements = new LinkedHashMap<>();
        mapOfExpectedElements.put(new User("Aydin",25,Collections.EMPTY_LIST),Arrays.asList(books.get(2)));
        mapOfExpectedElements.put(new User("Leyla",22,Collections.EMPTY_LIST),Arrays.asList(books.get(5)));
        Map<User,List<Book>> expected =  mapOfExpectedElements;
        Assertions.assertEquals(actual,expected,"Wrong");

    }

    @Test
    public void testGetBooksSortedByAuthor(){
        System.out.println(users);
        List<Book> actual = my_service.getBooksSortedByAuthor();
        List<Book> expected = Arrays.asList(
                new Book("The Pragmatic Programmer", "Andy Hunt", 1999, 4.6, true),
                new Book("Java Concurrency in Practice", "Brian Goetz", 2006, 4.5, false),
                new Book("Effective Java", "Joshua Bloch", 2018, 4.9, true),
                new Book("Clean Code", "Robert Martin", 2008, 4.7, true));
        Assertions.assertEquals(expected,actual,"List of books is wrong");
    }
    @Test
    public void testUniqueAuthorsRead(){
        Set<String> actual = my_service.uniqueAuthorsRead();
        Set<String> expected = new HashSet<>(Arrays.asList("Andy Hunt", "Joshua Bloch", "Robert Martin","Brian Goetz","George Orwell"));
        Assertions.assertEquals(expected,actual,"Unique authors read is wrong");
    }

        public Stream<Arguments> valuesForRecommendedBook() {
            return Stream.of(
                    Arguments.of(users.get(1), books.get(3)),
                    Arguments.of(users.get(0), books.get(0))
            );
    }

    @ParameterizedTest
    @MethodSource("valuesForRecommendedBook")
    public void testFindRecommendedBookForUser(User user,Book expectedBook){
        Optional <Book> actual = my_service.findRecommendedBookForUser(user);
        Optional <Book> expected = Optional.of(expectedBook);
        Assertions.assertEquals(expected,actual,"Book is wrong");

    }

    public static Arguments[] valuesForTest() {
        return new Arguments[]{
               Arguments.of(users,10,2025,"Leyla"),
                Arguments.of(users,9,2025,"Aydin")
                };
    }

    @ParameterizedTest
    @MethodSource("valuesForTest")
    public void testFindReaderOfTheMonth(List<User> users, int month, int year,String expectedKey) {
        Optional<Map.Entry<String, List<java.time.LocalDate>>> actual = my_service.findTopReaderOfTheMonth(users,month,year);
        String actualKey = actual.get().getKey();
        Assertions.assertEquals(expectedKey,actualKey,"Wrong");

    }



}
