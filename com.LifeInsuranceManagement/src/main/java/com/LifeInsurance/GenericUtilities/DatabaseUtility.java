package com.LifeInsurance.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con=null;
	
	public void connectToDB() throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstants.DBURL, IPathConstants.DBUSERNAME, IPathConstants.DBPASSWORD);
		}
	
	public String executeQueryAndGetData(String query,int columnIndex,String expData) throws Throwable {
                  ResultSet result = con.createStatement().executeQuery(query);
		           boolean flag=false;
		           while(result.next())
		           {
		            String data = result.getString(columnIndex);
		            System.out.println(data);
		            if(data.equalsIgnoreCase(expData))
		            {
		            	flag=true;
		            	break;
		            }
		           }
		           if(flag) {
		        	   System.out.println(expData+"project is created");
		        	   return expData;
		           }
		           else {
		        	   System.out.println("project is not created ");
		        	   return "";
		           }
	}
	public void closeDB() throws Throwable {
		con.close();
	}

}
