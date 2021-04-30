package Model;

public class Customer extends MyExecuteQuary{
	private int ordernum;
	private String menu;
	private int price;
	private int quantity;
	
	public Customer() {
		super();
	}
	
	public void setOrdernum(int ordernum) {this.ordernum = ordernum;}
	public void setMenu(String menu) {this.menu = menu;}
	public void setPrice(int price) {this.price = price;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
	public int getOrdernum() {return ordernum;}
	public String getMenu() {return menu;}
	public int getPrice() {return price;}
	public int getQuantity() {return quantity;}
	
}
