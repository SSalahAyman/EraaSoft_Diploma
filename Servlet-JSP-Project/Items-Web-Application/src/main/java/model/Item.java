package model;

// This item model java class mapping to a table with name "Item" in my Oracle database
public class Item {
	
	// define the attributes for any item
	private Integer id;
	private String name;
	private Double price;
	private Integer totalNumber;
	private Integer userId;
	private boolean hasDetails;
	
	// define constructors that used to build the object
	public Item() {
		
	}
	
	public Item(String name, Double price , Integer totalNumber) {
		this.name = name;
		this.price = price;
		this.totalNumber = totalNumber;
	}
	
	public Item(Integer id, String name, Double price , Integer totalNumber) {
		this(name,price,totalNumber);
		this.id = id;
	}
	
		
	// define setters & getters for every attribute to can access it or set it with values to any specific object
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Double getPrice() {
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
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}
	public boolean isHasDetails() {
		return hasDetails;
	}
	public void setHasDetails(boolean hasDetails) {
		this.hasDetails = hasDetails;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
