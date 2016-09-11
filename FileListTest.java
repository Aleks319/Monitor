package Lesson4.Monitor;
import java.io.IOException;

public class FileListTest {
    public static void main(String[] args) {
        String[] fileList  = {"D:\\Java\\Курсы PROG\\OOP\\Monitor\\test1\\file.txt",
                              "D:\\Java\\Курсы PROG\\OOP\\Monitor\\test1\\file1.txt",
                              "D:\\Java\\Курсы PROG\\OOP\\Monitor\\test1\\file2.txt",
                              "D:\\Java\\Курсы PROG\\OOP\\Monitor\\test1\\file3.txt",
                              "D:\\Java\\Курсы PROG\\OOP\\Monitor\\test1\\file4.txt",
                              "D:\\Java\\Курсы PROG\\OOP\\Monitor\\test1\\file5.txt",
                              "D:\\Java\\Курсы PROG\\OOP\\Monitor\\test1\\file6.txt",
                              "D:\\Java\\Курсы PROG\\OOP\\Monitor\\test1\\file7.txt"};

        Monitor m = new Monitor(fileList, new FileEvent());



        try {
            m.startList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}