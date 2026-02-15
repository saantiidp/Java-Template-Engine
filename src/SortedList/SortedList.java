package SortedList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Clase Person
 * @author Carlos Riveira, carlos.riveira.ramos@estudiante.uam.es
 * @author Santiago de Prada, santiago.prada@estudiante.uam.es
 */

public class SortedList<T extends Comparator<T>> extends ArrayList<T>{
	
	ArrayList<Comparator<? super T>> comparators = new ArrayList<>();
	
	/**
	 * Constructor de la clase SortedList
	 * @param lista
	 */
	public SortedList(List<T> lista) {
		for(T e: lista) {
			this.add(e);
		}
		this.sort();
	}
	
	/**
	 * Metodo que ordena la lista
	 */
	public void sort() {
		ArrayList<? super T> aux = new ArrayList<>();
		
		while (this.isEmpty() == false) {
			T menor = this.get(0);
			
			for(T e: this) {
				if (e.compare(e, menor) == 0) {
					for(Comparator<? super T> c: this.comparators) {
						if (c.compare(e, menor) == 0) {
							
						} 
						else if(c.compare(e, menor) > 0) {
							break;
						} else {
							menor = e;
							break;
						}
						
					}
				} 
				else if(e.compare(e, menor) < 0) {
					menor = e;
				}	
			}
			aux.add(menor);
			this.remove(menor);
		}
		
		for(Object elementos: aux) {
			this.add((T) elementos);
		}
	}
	
	/**
	 * Metodo que permite añadir nuevos criterios de ordenación
	 * @param comparator
	 */
	public void addCriterion(Comparator<? super T> comparator) {
		this.comparators.add(comparator);
		this.sort();	
	}
	
	


}
