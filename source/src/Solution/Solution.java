package Solution;

import java.util.HashMap;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import entity.db.CapStoneDB;

public class Solution {
       public Map<String,Object> atributes =new HashMap<String,Object>();
       
       
       
       public Map<String, Object>   createAtributes(String bikeId,String bikeType) throws SQLException {
    	   Statement stm =CapStoneDB.getConnection().createStatement();
           ResultSet resultSet = stm.executeQuery("(SELECT column_name FROM information_schema.columns WHERE table_name = 'bikes') union (SELECT column_name FROM information_schema.columns WHERE table_name = '"+bikeType+"')") ;
           Statement stm2 =CapStoneDB.getConnection().createStatement();
           ResultSet resultSet2 =stm2.executeQuery("Select *from bikes,"+bikeType+" where bikeId='"+bikeId+"'");
           resultSet2.next();
           while (resultSet.next()) {
               String columnName = resultSet.getString("column_name");
               atributes.put(columnName, resultSet2.getObject(columnName));
           }
           
           return atributes;

       }
       
       public static void main(String[] args) throws SQLException {
    	   Statement stm =CapStoneDB.getConnection().createStatement();
           ResultSet resultSet = stm.executeQuery("(SELECT column_name FROM information_schema.columns WHERE table_name = 'bikes') union (SELECT column_name FROM information_schema.columns WHERE table_name = 'standardebikes')") ;
		   
           while (resultSet.next()) {
               String columnName = resultSet.getString("column_name");
               System.out.println(columnName);
           }
       }
}
