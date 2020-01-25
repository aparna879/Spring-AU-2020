package Building;

public class Main {

	public static void main(String[] args) {
		System.out.println("............SCHOOL BUILDING CONSTRUCTION.........................");
		System.out.println();
		Leaf wall = new Leaf("Wall");
		Leaf Rfloor = new Leaf("RoomFloor");
		Leaf ceil = new Leaf("Ceiling");
		Leaf door = new Leaf("Door");
		Leaf window = new Leaf("Windows");
		Leaf corridor = new Leaf("Corridor");
		Leaf washroom = new Leaf("Washroom");
		Leaf lift = new Leaf("Lift");
		Leaf terrace = new Leaf("Terrace");
		
		Composite building = new Composite("Building");
		Composite Bfloor = new Composite("BuildingFloor");
		Composite room = new Composite("Room");
		
		room.add(wall, 4);
		room.add(Rfloor, 1);
		room.add(ceil, 1);
		room.add(door, 1);
		room.add(window, 2);
		

		Bfloor.add(room, 10);
		Bfloor.add(corridor, 2);
		Bfloor.add(washroom, 4);


		building.add(Bfloor, 10);
		building.add(lift, 20);
		building.add(terrace, 1);
		
		building.showDetails();		
		
	}

}
