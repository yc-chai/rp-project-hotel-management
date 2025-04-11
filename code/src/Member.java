/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Chai Yong Chen
 * Student ID: 21007175
 * Class: W65L
 * Date/Time created: Thursday 20-01-2022 21:17
 */

/**
 * @author 21007175
 *
 */
public class Member {
	
	private int id;
	private String name;
	private char tier;
	
	public Member(int id, String name) {
		this.id = id;
		this.name = name;
		this.tier = 'B';
	}
	
	public Member(int id, String name, char tier) {
		this.id = id;
		this.name = name;
		this.tier = tier;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public char getTier() {
		return tier;
	}

}
