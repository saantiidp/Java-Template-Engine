package Strategies;
import java.io.FileWriter; 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Clase FilePèrsister implements Strategy<T>
 * @author Carlos Riveira, carlos.riveira.ramos@estudiante.uam.es
 * @author Santiago de Prada, santiago.prada@estudiante.uam.es
 */

public class FilePersister<T> implements Strategy<T> {

	private Function<T, ?> funct;
	private List<String> list = new  ArrayList<>();
	
	/**
	 * Constructor de la clase FilePersister
	 * @param funct
	 */
	public FilePersister(Function<T, ?> funct) {
		this.funct = funct;
	}
	
	/**
	 * Metodo que permite imprimir las cadenas de texto en un fichero
	 * @param string
	 * @param t
	 * @return
	 */
	@Override
	public String textModifier(String string, T t) {
		
		FileWriter f = null;
		PrintWriter p = null;
		int tam = 0;
		
		if(list.contains(funct.apply(t)) == true) {
			for(String name: this.list) {
				if(name.equals(funct.apply(t))) {
					tam++;
				}
			}
		} else {
			list.add((String) funct.apply(t));
		}
		
		try {
			f = new FileWriter("./archv/" + funct.apply(t) + tam + ".txt");
			p = new PrintWriter(f);
			p.println(string);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != f) {
				try {
					f.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
			
		return string;
	}
}
