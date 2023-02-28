package entity.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.bike.StandardEBike;
import entity.db.CapStoneDB;
    /**
     * this is standardEbike class
     * @author NhatSang
     * @version 1.0
     */
public class StandardEBikeDataAccess {
	private static StandardEBikeDataAccess standardEBikeDataAccess;
    public static StandardEBikeDataAccess getBikeDataAccess() {
 	   if(standardEBikeDataAccess==null) {
 		  standardEBikeDataAccess= new StandardEBikeDataAccess();
 	   }
 	   return standardEBikeDataAccess;
    }
    /**
     * get StandardEbike in dock
     * @param dockId
     * @return list[StandardEbike]
     * @throws SQLException
     */
    public List getListEBikeInDock(String dockId) throws SQLException {
    	String sql="Select *from capstoneproject.standardebikes,capstoneproject.bikes where standardebikes.bikeId=bikes.bikeId   and dockId='"+dockId+"'";
		Statement stm = CapStoneDB.getConnection().createStatement();
		ResultSet res = stm.executeQuery(sql);
		List liststandardebike=new ArrayList<>();
	
			while(res.next()) {
				String bikeId=res.getString("bikeId");
				String barCode=res.getString("barCode");
		    	String rentalCode=res.getString("rentalCode");
		    	String linsencePlate=res.getString("linsencePlate");
		    	boolean status=res.getBoolean("status");
		    	String type=res.getString("type");
		    	double price=res.getDouble("price");
		    	int hourlyRate=res.getInt("hourlyRate");
		    	int batteryPercentage=res.getInt("batteryPercentage");
		    StandardEBike standardEBike=new StandardEBike(barCode, rentalCode, linsencePlate, bikeId,status,type,price,hourlyRate,batteryPercentage,dockId);
		    standardEBike.setImageURL(res.getString("imageURL"));
		        liststandardebike.add(standardEBike);
			}
			
		return liststandardebike;  	
    }
}
