package model;

// This item model java class mapping to a table with name "Item" in my Oracle database
public class Item {
	
	// define the attributes for any item
	private Integer id;
	private String name;
	private double price;
	private Integer totalNumber;
	
	
	// define constructors that sued to build the object
	public Item() {
		
	}
	
	public Item(String name, double price , Integer totalNumber) {
		this.name = name;
		this.price = price;
		this.totalNumber = totalNumber;
	}
	
	public Item(Integer id, String name, double price , Integer totalNumber) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.totalNumber = totalNumber;
	}
	
		
	// define setters & getters for every attribute to can access it or set it with values to any specific object
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public Integer getTotalNumber() {
		return totalNumber;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}
}
