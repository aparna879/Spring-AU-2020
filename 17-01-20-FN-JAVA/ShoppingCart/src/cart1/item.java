package cart1;
import java.util.*;

public class item {
	private int item_id;
	private String item_name;
	private int item_qnt;
	private int item_rate;

	public item(int id, String name, int qnt, int rate) {
		this.item_id = id;
		this.item_name = name;
		this.item_qnt = qnt;
		this.item_rate = rate;
	}

	public int getItemId() {
		return this.item_id;
	}
	
	public String getItemName() {
		return this.item_name;
	}
	
	public int getQty() {
		return this.item_qnt;
	}
	
	public int getItemRate() {
		return this.item_rate;
	}
	
	public void setId(int id) {
		this.item_id = id;
	}
	public void setName(String name) {
		this.item_name = name;
	}
	
	public void setQty(int qty) {
		this.item_qnt = qty;
	}
	
	public void setItemRate(int rate) {
		this.item_rate = rate;
	}

	public boolean isAvail(){
		if(this.item_qnt > 0) return true;
		else return false;
	}
}