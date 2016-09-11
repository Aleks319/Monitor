package Lesson4.Monitor;
import java.io.IOException;
import java.util.Scanner;
public class FileTest {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

        System.out.println("Input your file name with directory: ");
        String fn = sc.nextLine();
        Monitor m = new Monitor(fn, new FileEvent());
        try {
            m.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

