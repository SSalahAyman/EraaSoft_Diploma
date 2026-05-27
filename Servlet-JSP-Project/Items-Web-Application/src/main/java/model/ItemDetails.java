package model;

public class ItemDetails {
	
	private Integer id;
	private String description;
	private String color;
	private double weight;
	
	public ItemDetails() {
		
	}
	
	public ItemDetails(String description, String color, double weight) {
		this.description=description;
		this.color=color;
		this.weight=weight;
	}
	
	public ItemDetails(Integer id, String description, String color, double weight) {
		this.id=id;
		this.description=description;
		this.color=color;
		this.weight=weight;
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
}
