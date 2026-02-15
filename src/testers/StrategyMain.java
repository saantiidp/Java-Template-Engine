package testers;

import java.util.Map;  
import SortedList.*;
import Strategies.FilePersister;
import Strategies.TimeStamper;
import Strategies.UpperCaser;
import Template.Template;

// add package declarations and imports

public class StrategyMain {

	public static void main(String[] args) {
		Template<Person> simpleLetter = IteratedTemplateMain.createLetterTemplate();
		IteratedTemplateMain.addDataObjects(simpleLetter);
		
		simpleLetter.withOptions(new TimeStamper<>(), 
								 new UpperCaser<>(),
								 new FilePersister<Person>(p -> p.getName()));
		
		System.out.println(writeResult(simpleLetter.emit()));
	}

	private static String writeResult(Map<Person, String> emit) {
		String res = "";
		for (Person p : emit.keySet())
			res+=emit.get(p)+"\n-----------------------------------------------------\n";
		return res;
	}

}
