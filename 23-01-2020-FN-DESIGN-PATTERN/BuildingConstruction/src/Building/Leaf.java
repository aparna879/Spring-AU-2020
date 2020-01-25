package Building;

public class Leaf implements Component{
	
	
	private String name;
	
	public Leaf(String name) {
		super();
		this.name = name;
	}
	public void showDetails() {
		System.out.println(" Name: "+name);
	}

}
