package Template;

import java.util.ArrayList; 
import java.util.Collection;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import SortedList.Mascot;
import SortedList.Person;
import SortedList.SortedList;
import Strategies.FilePersister;
import Strategies.Strategy;
import Strategies.TimeStamper;
import Strategies.UpperCaser;

/**
 * Clase Template
 * 
 * @author Carlos Riveira, carlos.riveira.ramos@estudiante.uam.es
 * @author Santiago de Prada, santiago.prada@estudiante.uam.es
 */

public class Template<T extends Comparator<T>> {
	private SortedList<T> objetos = new SortedList<T>(new ArrayList<>());
	private Map<ArrayList<Integer>, String> map = new HashMap<>();
	private List<Function<T, ?>> lambdas = new ArrayList<>();
	private Map<String, Predicate<T>> condiciones = new HashMap<>();
	private List<Strategy<T>> strategies = new ArrayList<>();

	/**
	 * Constructor de la clase Template
	 */
	public Template() {
		
	}

	/**
	 * Constructor que se va llamando sobre la marcha de la clase Template
	 * 
	 * @param string
	 * @param lambdas
	 */

	public Template<T> add(String string, Function<T, ?>... lambdas) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(this.lambdas.size());
		list.add(Arrays.asList(lambdas).size());

		this.map.put(list, string);
		this.lambdas.addAll(Arrays.asList(lambdas));
		return this;

	}

	/**
	 * Metodo que inserta los objetos sobre los que se quiere generar plantillas
	 * @param objects
	 */

	public Template<T> addObjects(T... objects) {
		objetos.addAll(Arrays.asList(objects));
		return this;
	}

	/**
	 * Metodo que genera el mapa con las cadenas de texto pedidas
	 * 
	 * @return
	 */
	public Map<T, String> emit() {
		Map<T, String> mapa = new TreeMap<T, String>();
		String aux;
		
		for (T objeto : objetos) {
			String changed = emit(objeto);
			for(Strategy<T> s: this.strategies) {
				aux = s.textModifier(changed, objeto);
				changed = aux;
			}
			
			mapa.put(objeto, changed);
		}

		return mapa;
	}

	/**
	 * Metodo emit para un objeto especifico
	 * 
	 * @param objeto
	 * @return
	 */
	public String emit(T objeto) {
		String textoEmitir = "";
		String salida = "";
		int i = 0;

		for (Entry<ArrayList<Integer>, String> entry : this.map.entrySet()) {
			textoEmitir = entry.getValue();
			if (!this.condiciones.containsKey(textoEmitir) || this.condiciones.get(textoEmitir).test(objeto)) {
				for (i = 0; i < entry.getKey().get(1); i++) {
					textoEmitir = textoEmitir.replaceFirst("##",
							"" + this.lambdas.get(entry.getKey().get(0) + i).apply(objeto));
				}
				salida += textoEmitir + "\n";
			}
		}
		return salida;
	}

	/**
	 * Metodo que ordena el array de objetos con un criterio
	 * 
	 * @param criteria
	 */
	public void withSortingCriteria(Comparator<? super T> criteria) {
		objetos.addCriterion(criteria);
	}
	
	/**
	 * Metodo que añade una strategia de modificacion de cadenas
	 * @param tm
	 */
	public void withOptions(Strategy<T> ... tm) {
		this.strategies.addAll(Arrays.asList(tm));
	}

	/**
	 * Metodo que añade añade unas cadenas de texto al string en caso de que se cumpla una condicion especifica
	 * @param condicion
	 * @param texto
	 * @param lambdas
	 * @return
	 */
	public Template<T> addWhen(Predicate<T> condicion, String texto, Function<T, ?>... lambdas) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(this.lambdas.size());
		list.add(Arrays.asList(lambdas).size());

		this.map.put(list, texto);
		this.lambdas.addAll(Arrays.asList(lambdas));
		this.condiciones.put(texto, condicion);
		return this;
	}

	public <R> Template<T> addforEach(Function<T, ArrayList<R>> lambda, String huecos, Function<R, ?>... ls) {
		List<Function<R, ?>> l = Arrays.asList(ls);
		
		

		return this;
	}

}
