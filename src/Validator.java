import java.util.Scanner;
import java.util.InputMismatchException;

public class Validator {
	public static boolean confirm(Scanner sc) {
		System.out.println("Would you like to enter another country? (y/n)");
		while (true) {
			String line = sc.nextLine().toLowerCase().trim();
			if (line.equals("y") || line.equals("yes")) {
				return true;
			} else if (line.equals("n") || line.equals("no")) {
				return false;
			} else {
				System.out.println("Please enter y/n.");
			}
		}
	}
}