package models;

import java.io.Serializable;

public class ListResult implements Serializable {

	/**
	 * @author Alican Balik
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int roomId;
	private int count;
	private String roomName;
	private int price;
	private int capacity;
	private String name;
	private String address;
	private int rank;
	
	public ListResult() {};
	
	public ListResult(int roomId, int count, String roomName, int price, int capacity, String name, String address, int rank) {
		super();
		this.roomId = roomId;
		this.count = count;
		this.roomName = roomName;
		this.price = price;
		this.capacity = capacity;
		this.name = name;
		this.address = address;
		this.rank = rank;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	

}
