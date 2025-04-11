/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name:
 * Student ID:
 * Class:
 * Date/Time created:
 */

public class Room {
	
	private int number;
	private String type;
	private double price;

	public Room(int number, String type, double price) {
		this.number = number;
		this.type = type;
		this.price = price;
	}
	
	public int getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
