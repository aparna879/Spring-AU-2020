package cart1;

import java.util.*;


public class main extends cart {

public main(customer user) {
		super(user);
	}
	
	public static void main(String[] args) {
		
		item item1 = new item(1, "Pen", 100,10);
		item item2 = new item(2, "pencil", 70, 5);
		item item3 = new item(3, "book", 10, 200);
		item item4 = new item(4, "Juice", 20, 100);
		item item5 = new item(5, "Bread", 25, 30);
		item item6 = new item(6, "chips", 150, 20);
		item item7 = new item(7, "kukure", 2, 30);
		item item8 = new item(8, "soap",1, 100);
		item item9= new item(9, "brush", 1, 40);
		item item10 = new item(10, "bag", 5, 1000);
		
		itemarray.add(item1);
		itemarray.add(item2);
		itemarray.add(item3);
		itemarray.add(item4);
		itemarray.add(item5);
		itemarray.add(item6);
		itemarray.add(item7);
		itemarray.add(item8);
		itemarray.add(item9);
		itemarray.add(item10);
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your details: ");
		System.out.println("CUSTOMER Id: ");
		int id = input.nextInt();
		System.out.println("CUSTOMER Name: ");
		String name = input.nextLine();
		
		input.nextLine();
	
		customer newcustomer = new customer(id,name);
		 cart c = new cart(newcustomer);

		String ch1 = "Y";
		int ch;
		do {
			System.out.println("Please enter your choice: ");
			System.out.println("1. View Available Items");
			System.out.println("2. Add Item to Cart");
			System.out.println("3. Remove Item From Cart");
			System.out.println("4. View Cart");
			System.out.println("5. Place Order");
			System.out.println("6. Cancel Order");
			
			ch = input.nextInt();
			input.nextLine();
		
			switch(ch) {
			
				case 1: c.ViewItems();
						break;
						
				case 2: System.out.println("Enter Item id: ");
						int i_id = input.nextInt();
						input.nextLine();
						item i = c.getItemFromList(i_id);
						if(i!=null) {
							c.AddtoCart(i);
							c.Cartview();
						}
						else System.out.println("Item is not available");
						break;
						
				case 3: System.out.println("Enter Item id: ");
						int i_id2 = input.nextInt();
						input.nextLine();
						item i2 = c.getItemFromList(i_id2);
						if(i2!=null) c.RemoveFromCart(i2);
						else System.out.println("Item can not be removed");
						c.Cartview();
						break;
				
				case 4: c.Cartview();
						break;
						
				case 5: c.placeOrder();
						break;
						
				case 6: //c.cancelOrder();
						System.out.println("Order Cancelled. Your Cart is empty now.");
						break;
						
				default: System.out.println("Enter valid choice");
				
			}
		System.out.println("Do you want to continue? (Y/N): ");
		ch1 = input.nextLine();
		}while(ch1.equals("Y")||ch1.equals("y"));
		
		System.out.println("FINISHED");
	}
}
