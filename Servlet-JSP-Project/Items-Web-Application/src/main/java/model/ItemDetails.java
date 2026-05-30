package model;

public class ItemDetails {
	
	private Integer id;
	private String description;
	private String color;
	private double weight;
	private String brand;
	private Integer itemId;
	
	public ItemDetails() {
		
	}
	
	public ItemDetails(Integer itemId ,String description, String color, double weight,String brand) {
		this.itemId=itemId;
		this.description=description;
		this.color=color;
		this.weight=weight;
		this.brand=brand;
	}
	
	public ItemDetails(Integer itemId , String description, String color, double weight , String brand , Integer id ) {
		this(itemId,description,color,weight,brand);
		this.id=id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public Integer getItemId() {
	    return itemId;
	}

	public void setItemId(Integer itemId) {
	    this.itemId = itemId;
	}
}
