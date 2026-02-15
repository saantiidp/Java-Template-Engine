package Strategies;

import java.time.LocalDate;

/**
 * Clase TimeStamper implements Strategy<T>
 * @author Carlos Riveira, carlos.riveira.ramos@estudiante.uam.es
 * @author Santiago de Prada, santiago.prada@estudiante.uam.es
 */

public class TimeStamper<T> implements Strategy<T> {

	/**
	 * Metodo que añade la fecha a las cadenas de texto
	 * @param string
	 * @param t
	 * @return
	 */
	@Override
	public String textModifier(String string, T t) {
		return LocalDate.now() + "\n" + string;
	}

}
