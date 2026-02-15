package Strategies;

import SortedList.Person;

/**
 * Interfaz Strategy
 * @author Carlos Riveira, carlos.riveira.ramos@estudiante.uam.es
 * @author Santiago de Prada, santiago.prada@estudiante.uam.es
 */

public interface Strategy<T> {
	/**
	 * Metodo el cual modifica una cadena de texto
	 * @param string
	 * @param t
	 * @return
	 */
	public String textModifier(String string, T t);
}
