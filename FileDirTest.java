package Lesson4.Monitor;

import java.io.IOException;
import java.util.Scanner;

public class FileDirTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Input your directory: ");
        String fn = sc.nextLine();
        System.out.println("Input file extension: ");
        String ext = sc.nextLine();
        Monitor m = new Monitor(fn, new FileEvent());
        try {
            m.startDir(ext);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
