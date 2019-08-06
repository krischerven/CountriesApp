import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;

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
						showCountries(countries);
					}
					break;
				}
				case 2: {
					String name = Validator.getNextCountry(sc).trim();
					Country c = new Country(name, Validator.getNextPopulation(sc, name));
					saveCountry(c);
					System.out.println("Added a new country (" + c.getName() + ")");
					countries = CountriesTextFile.getCountriesList();
					showCountries(countries);
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

	private static void saveCountry(Country country) {
		File file = Paths.get("countries.txt").toFile();
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream("countries.txt", true));
			out.println(country.getName()+"="+country.getPopulation());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void showCountries(ArrayList<Country> countries) {
		String display = "\n";
		for (int i = 0; i < countries.size(); ++i) {
			display += ((i+1) + ". " + countries.get(i).toString() + "\n");
		}
		System.out.println(display);
	}
	
}