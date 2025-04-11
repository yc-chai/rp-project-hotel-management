/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Chai Yong Chen
 * Student ID: 21007175
 * Class: W65L
 * Date/Time created: Thursday 20-01-2022 21:23
 */

/**
 * @author 21007175
 *
 */
public class Reservation {
	
	private int id;
	private String arrivalDate;
	private String departureDate;
	private int roomNumber;
	private int memberID;
	private double paidAmount;
	private String status;

	public Reservation(int id, String arrivalDate, String departureDate,
						int roomNumber, int memberID, double paidAmount) {
		this.id = id;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.roomNumber = roomNumber;
		this.memberID = memberID;
		this.paidAmount = paidAmount;
		this.status = "confirmed";
	}
	
	public int getId() {
		return id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}
	
	public int getMemberID() {
		return memberID;
	}
	
	public double getPaidAmount() {
		return paidAmount;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
