package SortedList;

public class Mascot {
	private String species;
	private String name;
	
	public Mascot(String s, String n) {
		this.setSpecies(s);
		this.setName(n);
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
