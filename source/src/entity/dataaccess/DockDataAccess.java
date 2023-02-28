package entity.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.bike.Bike;
import entity.db.CapStoneDB;
import entity.dock.Dock;
       /**
        * this is DockDataAccess class
        * @author NhatSang
        * @version 1.0
        */
public class DockDataAccess {
	   private static DockDataAccess dockDataAccess;
       public static DockDataAccess getDockDataAccess() {
    	      if(dockDataAccess==null) {
    	    	  dockDataAccess= new DockDataAccess();
    	      }
    	      return dockDataAccess;
       }
       /**
        * get list dock
        * @return list[Dock]
        * @throws SQLException
        */
       public List getListDock() throws SQLException {
    	   String sql = "SELECT * FROM docks";
           Statement stm = CapStoneDB.getConnection().createStatement();
           ResultSet res = stm.executeQuery(sql);
           ArrayList listDocks = new ArrayList<>();
           while(res.next()) {
          	 Dock dock=new Dock();
          	 dock.setAddress(res.getString("address"));
          	 dock.setArea(res.getDouble("area"));
          	 dock.setDockId(res.getString("dockId"));
          	 dock.setImageURL(res.getString("imageURL"));
          	 dock.setName(res.getString("name"));
          	 dock.setNumber_of_available_bikes(res.getInt("number_of_available_bikes"));
          	 dock.setNumber_of_docking_points(res.getInt("number_of_docking_points"));
          	 listDocks.add(dock);
           }
           return listDocks;   	   
       }
       /**
        * get dock by dockId
        * @param dockId
        * @return Dock
        * @throws SQLException
        */
       public Dock getDockById(String dockId) throws SQLException{
      	 String sql ="Select * from docks where dockId='"+dockId+"'";
      	 Statement stm =CapStoneDB.getConnection().createStatement();
      	 ResultSet res = stm.executeQuery(sql);
      	 while(res.next()) {
      	     Dock dock=new Dock();
      	     dock.setAddress(res.getString("address"));
             	 dock.setArea(res.getDouble("area"));
             	 dock.setDockId(res.getString("dockId"));
             	 dock.setImageURL(res.getString("imageURL"));
             	 dock.setName(res.getString("name"));
             	 dock.setNumber_of_available_bikes(res.getInt("number_of_available_bikes"));
             	 dock.setNumber_of_docking_points(res.getInt("number_of_docking_points"));
             	 return dock;
      	        
      	 }
      	 return null;
       }
       /**
        * get all bike in dockId
        * @param dockId
        * @return list[Bike]
        * @throws SQLException
        */
       public List getAllBikeInDock(String dockId) throws SQLException {
    	 List listbike=new ArrayList<>();
       	listbike.addAll(StandardBikeDataAccess.getBikeDataAccess().getListBikeInDock(dockId));
       	listbike.addAll(StandardEBikeDataAccess.getBikeDataAccess().getListEBikeInDock(dockId));
       	listbike.addAll(TwinBikeDataAccess.getTwinBikeDataAccess().getListTwinBikeInDock(dockId));
       	return listbike;
       }
       /**
        * get bike infor in dock
        * @param bikeId
        * @param dockId
        * @return Bike
        * @throws SQLException
        */
       public Bike getBikeInfor(String bikeId,String dockId) throws SQLException {
    	      List listbike= getAllBikeInDock(dockId);
    	      for(Object obj:listbike) {
 				 Bike bike=(Bike) obj;
 				 if(bike.getBikeId().equals(bikeId)) {
 					 return bike;
 				 }
 			 }
    	      return null;
       }
       
}
