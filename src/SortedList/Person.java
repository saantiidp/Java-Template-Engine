package SortedList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Clase Person
 * @author Carlos Riveira, carlos.riveira.ramos@estudiante.uam.es
 * @author Santiago de Prada, santiago.prada@estudiante.uam.es
 */

public class Person implements Comparator<Person>, Comparable<Person>{
	
	private String  name;
	private LocalDate birthDate;
	private ArrayList<Mascot> mascots = new ArrayList<>();
	
	/**
	 * Constructor de la clase Person
	 * @param name
	 * @param birthDate
	 */
	public Person(String name, LocalDate birthDate) {
		this.setName(name);
		this.setBirthDate(birthDate);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	@Override
	public int compare(Person arg0, Person arg1) {
		
		return arg0.name.compareTo(arg1.name);
	}

	/**
	 * Metodo que devuelve el nombre
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que permite cambiar el nombre
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo que devuelve la fecha de nacimiento
	 * @return
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * Metodo que permite cambiar la fecha de nacimiento
	 * @param birthDate
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	
	public ArrayList<Mascot> getMascots() {
		return this.mascots;
	}
	
	public void addMascots(Mascot ...m) {
		this.mascots.addAll(Arrays.asList(m));
	}
	
	/**
	 * Metodo toString de la clase Person
	 */
	public String toString() {
		return this.name + "( born: " + this.birthDate + ")";
	}
	 
	/**
	 * Metodo para obtener la edad de la persona
	 * @return
	 */
	public int getAge() {
		return LocalDate.now().getYear() - this.birthDate.getYear();
		 
	 }

	/**
	 * Metodo compareTo
	 * @return
	 */
	@Override
	public int compareTo(Person arg0) {
		if(this.name.compareTo(arg0.getName()) == 0) {
			if(this.getAge() > arg0.getAge())
				return 1;
			else if(this.getAge() < arg0.getAge())
				return -1;
			else
				return 0;
		}
		else
			return this.name.compareTo(arg0.getName());
	}
	
}
