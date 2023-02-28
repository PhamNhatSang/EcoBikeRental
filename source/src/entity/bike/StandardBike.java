package entity.bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.BlobFromLocator;

import entity.db.CapStoneDB;
import entity.dock.Dock;
    /**
     * this is StandardBike
     * @author NhatSang
     * @version 1.0
     */
public class StandardBike extends Bike{
     /**
      * StandardBike constructor
      * @param barCode
      * @param rentalCode
      * @param linsencePlate
      * @param bikeId
      * @param status
      * @param type
      * @param price
      * @param dockId
      * @throws SQLException
      */
	public StandardBike(String barCode, String rentalCode, String linsencePlate, String bikeId, boolean status, String type,double price,String dockId) throws SQLException {
		super(barCode,rentalCode,linsencePlate,bikeId,status,type,price,dockId);
	}
	public StandardBike() {
		super();
	} 
}
