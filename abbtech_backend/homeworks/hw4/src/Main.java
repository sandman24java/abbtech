public class Main {
    public static void main(String[] args){
        Book new_book = new Book("The night in Lisbon","Erich Maria Remarque","9780449912430");
        new_book.printInfo();
        new_book.borrowBook();
        new_book.returnBook();
        new_book.libraryRules();
        new_book.bookType();
    }
}
