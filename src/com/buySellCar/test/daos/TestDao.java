package com.buySellCar.test.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;





import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.buySellCar.common.utils.CommonUtils;
import com.buySellCar.common.utils.JNDIDataBaseController;
import com.buySellCar.test.dtos.TestDto;

public class TestDao {

	
	private Logger logger = LogManager.getLogger(this.getClass().getName()); 
	
	public TestDto getTestData() {
		// TODO Auto-generated method stub
		TestDto td = new TestDto();
		
		PreparedStatement statement=null;
		Connection conn=null;
		
		
		
		
		
		try {
			
				conn= new JNDIDataBaseController().getConnection();
				
			
			
			String selectionSqlStr =CommonUtils.getProperty("GET_TEST_DATA");  
			
			
			
            
            statement = conn.prepareStatement(selectionSqlStr);
            
            	
            
            
            logger.debug("Getting the test data with statement : "+statement.toString());
            
            
            ResultSet rs = statement.executeQuery();
            
            
           
            
            if(rs.next()){
            	 td.setColId(rs.getInt("id"));
            	 td.setValue(rs.getString("k"));
            }
            
           
            rs.close();
            
		} catch (NamingException ex) {
        	logger.error("Namming exception when trying get test data",ex);
        } catch (IOException ex) {
			// TODO Auto-generated catch block
        	logger.error("SQLException when trying get test data !",ex);
		}catch(Exception ex){
			logger.error("SQLException when trying get test data !",ex);
		}finally{
        	
            	try {
            	if(statement!=null && !statement.isClosed()){
            		
    					statement.close();
    				
            	}
            		
            	} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				logger.error("cannot close the statement !!",e);
    			}
            	
            	
            	try {
            	if(conn !=null && !conn.isClosed()){
            		
    					conn.close();
    				
            		
            		
            	}
            	
            	} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				logger.error("cannot close the connection !!",e);
    			}
    		
        
        }
		
		
		
		return td;
	}

}
