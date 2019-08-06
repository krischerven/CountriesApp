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
	@Override
	public String toString() {
		return String.format("Country{name=%s, pop=%d}", name, population);
	}
}