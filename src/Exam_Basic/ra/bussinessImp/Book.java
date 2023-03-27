package Exam_Basic.ra.bussinessImp;

import Exam_Basic.ra.bussiness.IBook;

import java.util.List;
import java.util.Scanner;

public class Book implements IBook,Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;//gia nhap
    private float exportPrice;//gia ban
    private float interest;//loi nhuan
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public float getInterest() {
        return interest;
    }


    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhap ten sach: ");
        this.bookName = scanner.nextLine();
        System.out.println("Nhap tieu de: ");
        this.title = scanner.nextLine();
        System.out.println("Nhap so trang: ");
        this.numberOfPages = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap gia nhap sach: ");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhap gia ban sach: ");
        this.exportPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Lợi nhuận: ");
        System.out.println(interest = this.exportPrice - this.importPrice);
        System.out.println("Nhap trang thai sach: ");
        this.bookStatus =Boolean.parseBoolean(scanner.nextLine());


    }

    @Override
    public void displayData() {
        System.out.println("-----------------------{BOOK}-----------------------");
        System.out.printf("Mã sách: %d\n", bookId);
        System.out.printf("Tên sách: %s\n", bookName);
        System.out.printf("Mô tả sách: %s\n", title);
        System.out.printf("Giá bán sách: %.1f\n", exportPrice);
        System.out.printf("Giá nhập sách: %.1f\n", importPrice);
        System.out.printf("Lợi nhuận sách: %.1f\n", interest);
        System.out.printf("Trạng thái sách: %s\n", (bookStatus ? "bán" : "hết"));
        System.out.println("----------------------------------------------------");
    }

    @Override
    public int compareTo(Book o) {
        return (int) (o.getInterest()-this.interest);
    }
}
