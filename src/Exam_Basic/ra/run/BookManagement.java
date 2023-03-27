package Exam_Basic.ra.run;

import Exam_Basic.ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> listBook = new ArrayList<>();

        while (true) {
            System.out.println("**********************************{JAVA-HACKATHON-05-BASIC-MENU}**********************************");
            System.out.println("1. Nhập số sách và nhập thông tin sách ");
            System.out.println("2. Hiển thị thông tin các sách");
            System.out.println("3. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi trạng thái của sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.println("**************************************************************************************************");
            System.out.println("Lựa chọn menu: ");
            int choseMenu = Integer.parseInt(scanner.nextLine());
            switch (choseMenu) {
                case 1:
                    creatBook(listBook, scanner);
                    break;
                case 2:
                    showBook(listBook);
                    break;
                case 3:
                    sortByInterest(listBook);
                    break;
                case 4:
                    deleteBook(listBook, scanner);
                    break;
                case 5:
                    searchBook(listBook,scanner);
                    break;
                case 6:
                    changeStatus(listBook,scanner);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Không có lựa chọn");

            }
        }
    }

    private static void changeStatus(List<Book> listBook, Scanner scanner) {
        showBook(listBook);
        System.out.println("Nhập mã sách cần thay đổi trạng thái");
        int idChange = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập trạng thái thay đổi");
        boolean newStatus = Boolean.parseBoolean(scanner.nextLine());
        listBook.get(idChange - 1).setBookStatus(newStatus);
    }

    private static void searchBook(List<Book> listBook, Scanner scanner) {
        List<Book> listSearch = new ArrayList<>();
        System.out.println("Nhập tên sách cần tìm kiếm");
        String searchName = scanner.nextLine();
        for (Book book: listBook) {
            if (book.getBookName().contains(searchName)){
                listSearch.add(book);
            }
        }
        showBook(listSearch);
    }

    private static void deleteBook(List<Book> listBook, Scanner scanner) {
        Book book = new Book();
        showBook(listBook);
        System.out.println("Nhập mã sách cần xóa");
        int idDel = Integer.parseInt(scanner.nextLine());
        listBook.remove(idDel);
    }

    private static void sortByInterest(List<Book> listBook) {
        Collections.sort(listBook);

    }

    private static void showBook(List<Book> listBook) {
        for (Book book : listBook) {
            book.displayData();
        }
    }

    private static void creatBook(List<Book> list, Scanner scanner) {
        System.out.println("Bạn muốn thêm bao nhiêu quyển sách: ");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập sách thứ: " + (i + 1));
            Book newBook = new Book();
            newBook.inputData(scanner);
            if (list.size() == 0) {
                newBook.setBookId(1);
            } else {
                newBook.setBookId((list.get(list.size() - 1).getBookId() + 1));
            }
            list.add(newBook);
        }
        System.out.println("Thêm thành công!");
    }
}


