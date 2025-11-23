public class Book {
    private String title;
    private String author;
    private  String isbn;
    protected static int totalCopies =1;
    protected static int availableCopies =1;
    {
        System.out.println("New book created!");
    }
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    public void borrowBook(){
        if (availableCopies >0){
            availableCopies--;
            System.out.println("Book borrowed successfully.");
        }
        else{
            System.out.println("Book Not Available.");
        }

    }
    public void returnBook(){
        if (availableCopies <totalCopies){
            availableCopies++;
            System.out.println("Book returned successfully.");
        }
        else{
            System.out.println("All copies are already in the library.");
        }
    }
    public void printInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available Copies: " + availableCopies);
        System.out.println("Total Copies: " + totalCopies);
    }
    public static void libraryRules(){
        System.out.println("Max 3 books can be borrowed per person.");
    }
    public final void bookType(){
        System.out.println("This is a regular book.");
    }
}
