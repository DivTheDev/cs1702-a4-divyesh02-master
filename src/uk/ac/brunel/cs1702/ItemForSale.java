package uk.ac.brunel.cs1702;

public class ItemForSale {
    private String name;
	private int numberOfDaysToSellIn; 
    private int price; 
    
    public ItemForSale(String name, int days, int price) {
		this.setName(name);
		this.setNumberOfDaysToSellIn(days);
		this.setPrice(price);
	}
    
	/* Generated getter and setter code */
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfDaysToSellIn() {
		return numberOfDaysToSellIn;
	}
	public void setNumberOfDaysToSellIn(int days) {
		this.numberOfDaysToSellIn = days;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
