package ics321;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {

	public static void main(String[] args){
		   Connection connection = null;
	       try
	       {
	    	   String url = "jdbc:mysql://76.88.178.79:3306/ics321";
	           Class.forName ("com.mysql.jdbc.Driver");
	           connection = DriverManager.getConnection (url,"ics321","321");
	    	   // String url = "jdbc:mysql://192.254.189.7:3306/vpawid_321project";
	           // connection = DriverManager.getConnection (url,"vpawid_test","ics321");
	           System.out.println ("Database connection established");
	           
	           PreparedStatement statement = connection.prepareStatement("select * from champion_stats");
	       
	           ResultSet result = statement.executeQuery();
	           while(result.next()){
	        	   System.out.println(result.getString(1) + " " + result.getString(2));
	           }
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();

	       }
	       finally
	       {
	           if (connection != null)
	           {
	               try
	               {
	            	   connection.close ();
	                   System.out.println ("Database connection terminated");
	               }
	               catch (Exception e) { /* ignore close errors */ }
	           }
	       }
	}

}
