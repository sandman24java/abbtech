package LibService;

import java.time.LocalDate;
import java.util.Optional;

public class BorrowRecord {
    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;


    public BorrowRecord(Book book, LocalDate borrowDate, LocalDate returnDate) {
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    public int getYearfromDate(){
        return borrowDate.getYear();
    }
    public int getMonthfromDate(){
        return borrowDate.getMonthValue();
    }
    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
    public Optional<LocalDate> getReturnDate() {
        return Optional.ofNullable(returnDate);
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public String toString() {
        if (this.returnDate == null){
            return " BOOK " + this.book + " BORROWDATE " +
                    this.borrowDate;

        }
        return "BOOK " + this.book + " BORROW DATE " +
                this.borrowDate + " RETURN DATE " + this.returnDate;
    }
}
