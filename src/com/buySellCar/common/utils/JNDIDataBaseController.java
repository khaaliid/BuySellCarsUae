package com.buySellCar.common.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JNDIDataBaseController {
	
	private String lookupString;
	
	
	public JNDIDataBaseController() throws IOException{
		lookupString=CommonUtils.getProperty("JNDI_LOOKUP_STRING");
	}
	public JNDIDataBaseController(String dbLookupString) {
		// TODO Auto-generated constructor stub
		lookupString=dbLookupString;
	}
	
	public Connection getConnection() throws SQLException, NamingException{
		Connection conn=null;
		Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:comp/env");
        DataSource ds = (DataSource) envContext.lookup(lookupString);
       conn = ds.getConnection();
        
        return conn;
	}

}
