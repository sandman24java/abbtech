package LibraryManagement;

public interface BookFilter {
    boolean filter(Library<?>.Book book);
}
