import java.util.ArrayList;
import java.util.Random;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Chai Yong Chen
 * Student ID: 21007175
 * Class: W65L
 * Date/Time Last modified: Thursday 27-01-2022 11:00
 */

public class HotelManagement {
	
	public static void main(String[] args) {
		
		// Room
		Room[] roomArr = new Room[7];
		roomArr[0] = new Room(101, "Premier", 638.0);
		roomArr[1] = new Room(102, "Deluxe", 858.0);
		roomArr[2] = new Room(201, "Premier", 718.8);
		roomArr[3] = new Room(202, "Deluxe", 938.8);
		roomArr[4] = new Room(301, "Family", 1058.88);
		roomArr[5] = new Room(302, "Family", 1058.88);
		
		// Administrator
		Admin admin = new Admin(1, "jay_chew", "654abc");
		
		// Member
		ArrayList<Member> memberList = new ArrayList<Member>();
		memberList.add(new Member(1001, "Jack"));
		memberList.add(new Member(1002, "Mary", 'G'));
		memberList.add(new Member(1003, "Tim", 'G'));
		memberList.add(new Member(1004, "Jim", 'S'));
		
		// Reservation
		ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
		reservationList.add(new Reservation(1, "09/12/2021", "11/12/2021", 101, 1002, 1276.0));
		reservationList.add(new Reservation(2, "31/12/2021", "01/01/2022", 202, 1004, 938.8));
		reservationList.add(new Reservation(3, "11/02/2022", "12/02/2022", 302, 1004, 1058.88));
		reservationList.add(new Reservation(4, "24/12/2021", "26/12/2021", 102, 1003, 1716.0));

		while(true) {
			Helper.line(30, "=");
			System.out.println("HOTEL MANAGEMENT - LOGIN");
			Helper.line(30, "=");
			
			String username = Helper.readString("Enter username > ");
			String password = Helper.readString("Enter password > ");
			
			boolean isAdmin = HotelManagement.login(admin, username, password);
			
			if(isAdmin == false) {
				System.out.println("Your username or password was incorrect. Try again!");
			}
			
			while(isAdmin) {
				HotelManagement.showMenu();
				int option = Helper.readInt("Enter option > ");
				
				if(option == 1) {
					
					String roomDetailsInString = HotelManagement.getRoomDetails(roomArr);
					System.out.println(roomDetailsInString);
					
				} else if (option == 2) {
					
					String type = Helper.readString("Enter room type > ");
					double percentage = Helper.readDouble("Enter the percentage > ");
					boolean isUpdated = HotelManagement.updateRoomPrice(roomArr, type, percentage);
					if(isUpdated) {
						String roomDetailsInString = HotelManagement.getRoomDetails(roomArr);
						System.out.println(roomDetailsInString);
					} else {
						System.out.println("Failed to update. Check the room type or the percentage entered.");
					}
					
				} else if (option == 3) {
					
					String name = Helper.readString("Enter member name > ");
					char tier = Helper.readChar("Enter member tier > ");
					boolean isAdded = HotelManagement.addMember(memberList, name, tier);
					if(isAdded) {
						System.out.println("New member added.");
					} else {
						System.out.println("Failed to add. Check the name and tier entered.");
					}
					
				} else if (option == 4) {
					
					int memberID = Helper.readInt("Enter member ID > ");
					int roomNumber = Helper.readInt("Enter room number > ");
					String arrivalDate = Helper.readString("Enter arrival date (DD/MM/YYYY) > ");
					boolean isCancelled = HotelManagement.cancelReservation(reservationList, memberID, roomNumber, arrivalDate);
					if(isCancelled) {
						System.out.println("The reservation has been cancelled successfully.");
					} else {
						System.out.println("Failed to cancel. The reservation may not exist or have been cancelled.");
					}
					
				} else if (option == 5) {
					
					int year = Helper.readInt("Enter the year > ");
					double revenue = HotelManagement.getRevenueByYear(reservationList, year);
					if(revenue == -1) {
						System.out.println("The year entered is invalid.");
					} else {
						System.out.println(String.format("The total revenue for Year %s is %.2f", year, revenue));
					}
					
				} else if (option == 6) {
					
					int winnerID = HotelManagement.generateWinner(memberList);
					System.out.println("The winner is Member " + winnerID);
					
				} else if (option == 7) {
					isAdmin = false;
					System.out.println("See you!");
					
				} else {
					System.out.println("Invalid option!");
				}
			}
		}
	}

	
	public static boolean login(Admin admin, String username, String password) {

		// TODO complete the code here
		if ( admin.getUsername().equals(username) &&
				admin.getPassword().equals(password) ) {
			return true;
		} else {
			return false;
		}

	}
	
	
	public static void showMenu() {
		
		Helper.line(30, "=");
		System.out.println("MENU");
		Helper.line(30, "=");
		System.out.println("1. View all rooms");
		System.out.println("2. Update room price");
		System.out.println("3. Add a new member");
		System.out.println("4. Cancel reservation for a member");
		System.out.println("5. Calculate revenue by year");
		System.out.println("6. Conduct lucky draw");
		System.out.println("7. Log out");
	}
	
	
	public static String getRoomDetails(Room[] roomArr) {
		
		String output = "";
		output += String.format("%-10s %-10s %-10s\n", "NUMBER", "TYPE", "PRICE");
		
		// TODO complete the code here
		for ( int i=0; i<roomArr.length; i++) {
			
			if ( roomArr[i] != null ) {
				output += String.format("%-10d %-10s %-10.2f\n",
										roomArr[i].getNumber(),
										roomArr[i].getType(),
										roomArr[i].getPrice());
				
			}
			
		}

		return output;
	}


	public static boolean updateRoomPrice(Room[] roomArr, String type, double percentage) {
		
		// TODO complete the code here
		boolean isUpdated = false;
		
		for ( int i=0; i<roomArr.length; i++) {
			
			if ( roomArr[i] != null &&
					roomArr[i].getType().equalsIgnoreCase(type) &&
					percentage > -100) {
				
				roomArr[i].setPrice( roomArr[i].getPrice() / 100 * ( 100 + percentage ) );
				isUpdated = true;
			}
			
		}
		
		if (isUpdated) {
			return true;
		} else {
			return false;
		}

	}
	

	public static boolean addMember(ArrayList<Member> memberList, String name, char tier) {
		
		// TODO complete the code here
		int memberID = memberList.size();
		
		if ( !name.isEmpty() && tier == ' ') {
			
			memberID += 1001;
			memberList.add(new Member(memberID, name));
			return true;
			
		} else if (!name.isEmpty() && (tier == 'G' || tier == 'S')) {
			
			memberID += 1001;
			memberList.add(new Member(memberID, name, tier));
			return true;
			
		} else {	
			return false;
			
		}
	}


	public static boolean cancelReservation(ArrayList<Reservation> reservationList, int memberID, int roomNumber, String arrivalDate) {
		
		// TODO complete the code here
		boolean isCancelled = false;
		
		for ( int i=0; i<reservationList.size(); i++) {
			
			if ( reservationList.get(i).getMemberID() == memberID
					&& reservationList.get(i).getRoomNumber() == roomNumber 
					&& reservationList.get(i).getArrivalDate().equals(arrivalDate) 
					&& reservationList.get(i).getStatus().equals("confirmed") ) {
				
				reservationList.get(i).setStatus("cancelled");
				isCancelled = true;
				break;
				
			}
		}
		
		return isCancelled;

	}


	public static double getRevenueByYear(ArrayList<Reservation> reservationList, int year) {
		
		// TODO complete the code here
		boolean listFound = false;
		double total = 0;
		
		for (int i=0; i<reservationList.size(); i++) {
			
			// .substring(int beginIndex, int endIndex)
			//return the substring starting from the specified index 
			String departureYear = reservationList.get(i).getDepartureDate().substring(6);
			
			// Integer.parseInt(String)
			// return an Integer instance
			if ( Integer.parseInt(departureYear) == year) {
				
				total += reservationList.get(i).getPaidAmount();
				listFound = true;
				
			}
		}
			
		if (listFound) {
			return total;
		} else {
			return -1;
		}	

	}
	

	public static int generateWinner(ArrayList<Member> memberList) {
		
		// TODO complete the code here
		Random rand = new Random();
		int int_random = rand.nextInt(memberList.size());
		boolean correctTier = false;
		
		while ( !correctTier ) {
			
			if (memberList.get(int_random).getTier() == 'B') {
				int_random = rand.nextInt(memberList.size());
				
			} else {
				correctTier = true;
			}
			
		}
		
		return memberList.get(int_random).getId();
	}
}
