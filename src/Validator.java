import java.util.Scanner;
import java.util.InputMismatchException;

public class Validator {
	public static boolean confirm(Scanner sc) {
		System.out.println("Would you like to continue? (y/n)");
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
	public static String getNextCountry(Scanner sc) {
		System.out.println("Please enter a country name.");
		while (true) {
			String s = sc.nextLine();
			if (s.length() > 0) {
				return s;
			} else {
				System.out.println("Please enter a country name");
			}
		}
	}
	public static int getNextPopulation(Scanner sc, String name) {
		System.out.println("Please enter a population for " + name);
		while (true) {
			try {
				int i = sc.nextInt();
				sc.nextLine();
				return i;
			} catch (InputMismatchException e) {
				System.out.println("Please enter an integer.");
				sc.nextLine();
			}
		}
	}
	public static int getNextChoice(Scanner sc) {
		System.out.println("Please enter an option (1, 2, or 3)");
		while (true) {
			try {
				int i = sc.nextInt();
				sc.nextLine();
				if (i >= 1 && i <= 3) {
					return i;
				} else {
					System.out.println("Out of range. Please enter a number between 1 and 3.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter an integer.");
				sc.nextLine();
			}
		}
	}
}