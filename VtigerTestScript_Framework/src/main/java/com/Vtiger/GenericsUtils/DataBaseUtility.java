package com.Vtiger.GenericsUtils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * 
 * @author singh
 *
 */

public class DataBaseUtility {
	
		Connection con = null;
		ResultSet result = null;
		Driver driverref;
		/**
		 * 
		 * @throws Throwable
		 */
		public void connectToDB() throws Throwable 
		{
			DriverManager.registerDriver(driverref);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","root");
		}
		/**
		 * 
		 * @throws Throwable
		 */
		public void closeDB() throws Throwable {
			con.close();
		}
		/**
		 * 
		 * @param query
		 * @param columnindex
		 * @return
		 * @throws Throwable
		 */
		public String getDataFromDB(String query,int columnindex) throws Throwable {
			String value = null;
			result = con.createStatement().executeQuery(query);
			while(result.next()) {
				value = result.getString(columnindex);
			}
			return value;
			
		}
		/**
		 * 
		 * @param query
		 * @param columnName
		 * @param expData
		 * @return
		 * @throws Throwable
		 */
		
		public String getdataFromDB(String query,int columnName,String expData) throws Throwable {
			boolean flag = false;
			result = con.createStatement().executeQuery(query);
			while(result.next()) {
				if(result.getString(columnName).equalsIgnoreCase(expData)){
					flag = true;
					break;
				}
				if(flag) {
					System.out.println(expData+" "+"data verified in database");
					return expData;
				}
				else {
					System.out.println(expData+" "+"data not verified");
				}
			}
			return expData;
			
		}
		
	}



