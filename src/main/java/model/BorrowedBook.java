package model;

import java.sql.Date;

public class BorrowedBook {
    private int borrowId;
    private int userId;
    private int bookId;
    private Date borrowDate;
    private Date returnDate;
    private boolean returned;
    private User user;
    private Book book;

    // Constructors
    public BorrowedBook() {}

    public BorrowedBook(int borrowId, int userId, int bookId, Date borrowDate, Date returnDate, boolean returned) {
        this.borrowId = borrowId;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.returned = returned;
    }

    // Getters and Setters
    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    // Calculate days remaining until return deadline
    public int getDaysRemaining() {
        if (returned) {
            return 0;
        }

        long currentTime = System.currentTimeMillis();
        long returnTime = returnDate.getTime();
        long diffTime = returnTime - currentTime;

        return (int) (diffTime / (1000 * 60 * 60 * 24));
    }

    // Check if book is overdue
    public boolean isOverdue() {
        if (returned) {
            return false;
        }

        return getDaysRemaining() < 0;
    }

    @Override
    public String toString() {
        return "BorrowedBook{" +
                "borrowId=" + borrowId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", returned=" + returned +
                '}';
    }
}

