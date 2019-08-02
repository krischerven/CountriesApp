import java.util.ArrayList;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class CountriesTextFile {
	public static ArrayList<Country> getCountriesList() {
		ArrayList<Country> countries = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("countries.txt"));
			try {
				String line = br.readLine();
				while (line != null && !line.strip().equals("")) {
					String[] split = line.split("=");
					countries.add(new Country(split[0], Integer.parseInt(split[1])));
					line = br.readLine();
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Warning: countries.txt was not found on disk.");
		}
		return countries;
	}
}