import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;

final class Country {
	String name;
	int population;
	public Country(String _name, int _pop) {
		name = _name;
		population = _pop;
	}
	public String getName() {
		return name;
	}
	public void setName(String _name) {
		name = _name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int _pop) {
		population = _pop;
	}
	protected void save() {
		File file = Paths.get("countries.txt").toFile();
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream("countries.txt", true));
			out.println(name+"="+population);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		return String.format("Country{name=%s, pop=%d}", name, population);
	}
}