package Strategies;

/**
 * Clase UpperCaser implements Strategy<T>
 * @author Carlos Riveira, carlos.riveira.ramos@estudiante.uam.es
 * @author Santiago de Prada, santiago.prada@estudiante.uam.es
 */

public class UpperCaser<T> implements Strategy<T>{

	/**
	 * Metodo que convierte los caracteres a mayuscula de cada cadena de texto
	 * @param string
	 * @param t
	 * @return
	 */
	@Override
	public String textModifier(String string, T t) {
		return string.toUpperCase();
	}

}
