package entity.dock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.db.CapStoneDB;


     /**
      * this is dock class
      * @author NhatSang
      * @version 1.0
      */
public class Dock {
     
	 private String dockId;
     private List listbike;
     private String name;
     private String address;
     private double area;
     private int number_of_available_bikes;
     private int number_of_docking_points;
     private String imageURL;
     public Dock() {
    	 super();
     }
     public Dock(String dockId, List listbike, String name, String address, double area, int number_of_available_bikes,
 			int number_of_docking_points) {
 		super();
 		this.dockId = dockId;
 		this.listbike = listbike;
 		this.name = name;
 		this.address = address;
 		this.area = area;
 		this.number_of_available_bikes = number_of_available_bikes;
 		this.number_of_docking_points = number_of_docking_points;
 	}
	public String getDockId() {
		return dockId;
	}

	public void setDockId(String dockId) {
		this.dockId = dockId;
	}

	public List getListbike() {
		return listbike;
	}

	public void setListbike(List listbike) {
		this.listbike = listbike;
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

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getNumber_of_available_bikes() {
		return number_of_available_bikes;
	}

	public void setNumber_of_available_bikes(int number_of_available_bikes) {
		this.number_of_available_bikes = number_of_available_bikes;
	}

	public int getNumber_of_docking_points() {
		return number_of_docking_points;
	}

	public void setNumber_of_docking_points(int number_of_docking_points) {
		this.number_of_docking_points = number_of_docking_points;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
}
