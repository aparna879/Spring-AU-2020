package Building;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;


public class Composite implements Component {

	String name;
	//List<Component> l = new LinkedList<>() ;
	HashMap<Component,Integer> map = new HashMap<Component,Integer>();
	
	public Composite(String name) {
		this.name = name;
	}
	public void add(Component c, int quantity) {
		map.put(c,quantity);
	}
	public void showDetails() {
		System.out.println(" Composite"+" "+name);

		for(Entry<Component, Integer> entry : map.entrySet() ) {
			System.out.print(entry.getValue());
			entry.getKey().showDetails();
			if(entry.getKey().getClass()== this.getClass())
				System.out.println(".........................");
		}
		
	}
	
}
