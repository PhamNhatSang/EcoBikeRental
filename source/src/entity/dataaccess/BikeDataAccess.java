package entity.dataaccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.bike.Bike;
import entity.db.CapStoneDB;
       /**
        * this is BikeDataAccess class
        * @author NhatSang
        * @version 1.0
        */
public class BikeDataAccess {
	   private static BikeDataAccess bikeDataAccess;
       public static BikeDataAccess getBikeDataAccess() {
    	   if(bikeDataAccess==null) {
    		   return new BikeDataAccess();
    	   }
    	   return bikeDataAccess;
       }
       /**
        * get list bike
        * @return list[Bike]
        * @throws SQLException
        */
       public  List getListBike() throws SQLException{
       	String sql = "SELECT * FROM bikes ";
           Statement stm = CapStoneDB.getConnection().createStatement();
           ResultSet res = stm.executeQuery(sql);
           List listBike= new ArrayList<>();
           while(res.next()) {
           	Bike bike=new Bike();
           	bike.setBikeId(res.getString("bikeId"));
           	bike.setBarCode(res.getString("barCode"));
           	bike.setImageURL(res.getString("imageURL"));
           	bike.setLinsencePlate(res.getString("linsencePlate"));
           	bike.setRentalCode(res.getString("rentalCode"));
           	bike.setStatus(res.getBoolean("status"));
           	bike.setType(res.getString("type"));
           	bike.setDockId(res.getString("dockId"));
           	bike.setPrice(res.getDouble("price"));
           	listBike.add(bike);
           }
           return listBike;
       }
       /**
        * update status  and dockId of bike 
        * @param bikeId
        * @param status
        * @param dockId
        * @throws SQLException
        */
       public void updateStatus(String bikeId,Boolean status,String dockId) throws SQLException {
    	   String sql = "update  bikes set status="+status+", dockId='"+dockId+"' where bikeId='"+bikeId+"'";
		   Statement stm = CapStoneDB.getConnection().createStatement();
		   Statement stm2 = CapStoneDB.getConnection().createStatement();
		   stm.execute(sql);
		   String sql2="select  number_of_available_bikes , number_of_docking_points from docks where dockId='"+dockId+"'";
		   ResultSet res = stm2.executeQuery(sql2);
		   String sql3="Select dockId from bikes where bikeId='"+bikeId+"'";
		   
		   ResultSet res2=stm.executeQuery(sql3);
		     while(res2.next()) {
		    	  if(res2.getString("dockId").equals(dockId)) {
		    		  while(res.next()) {
				        	int  number_of_available_bikes=res.getInt("number_of_available_bikes");
				        	int  number_of_docking_points=res.getInt("number_of_docking_points");
				        	 if(status==true) {
				        		 number_of_available_bikes++;
				        		 number_of_docking_points--;
				        		 String updateQueryString="update docks set number_of_available_bikes = "+number_of_available_bikes+", number_of_docking_points = "+ number_of_docking_points+" where dockId='"+dockId+"'";
				        		 stm.execute(updateQueryString);
							 }else {
								 number_of_available_bikes--;
				        		 number_of_docking_points++;
				        		 String updateQueryString="update docks set number_of_available_bikes = "+number_of_available_bikes+", number_of_docking_points = "+ number_of_docking_points+" where dockId='"+dockId+"'";
				        		 stm.execute(updateQueryString);
							 }
							 
				        	break;
				        } 
		    	  }else {
		    		  while(res.next()) {
				        	int  number_of_available_bikes=res.getInt("number_of_available_bikes");
				        	int  number_of_docking_points=res.getInt("number_of_docking_points");
				        	 if(status==true) {
				        		 number_of_available_bikes++;
				        		 number_of_docking_points--;
				        		 String updateQueryString="update docks set number_of_available_bikes = "+number_of_available_bikes+", number_of_docking_points = "+ number_of_docking_points+" where dockId='"+dockId+"'";
				        		 stm.execute(updateQueryString);
							 }
				        	break;
				        }
		    	  }
		    	  break;
		     }
			
		   
       }
       
}
