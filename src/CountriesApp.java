import java.util.Scanner;
import java.util.ArrayList;

public class CountriesApp {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		ArrayList<Country> countries = CountriesTextFile.getCountriesList();
		boolean quit = false;
		do {
			System.out.println("What would you like to do? \n1. Display all saved countries\n2. Add a country\n3. Quit");
			int choice = Validator.getNextChoice(sc);
			switch (choice) {
				case 1: {
					if (countries.isEmpty()) {
						System.out.println("Nothing to display; countries.txt was empty.");
					} else {
						String display = "\n";
						for (int i = 0; i < countries.size(); ++i) {
							display += ((i+1) + ". " + countries.get(i).toString() + "\n");
						}
						System.out.println(display);
					}
					break;
				}
				case 2: {
					final String name = Validator.getNextCountry(sc).trim();
					final int population = Validator.getNextPopulation(sc, name);
					final Country c = new Country(name, population);
					System.out.println("Added a new country (" + c.getName() + ")");
					c.save();
					countries = CountriesTextFile.getCountriesList();
					break;
				}
				case 3: {
					quit = true;
					break;
				}
			}
		} while (!quit && Validator.confirm(sc));
		System.out.println("Goodbye.");
	}
}