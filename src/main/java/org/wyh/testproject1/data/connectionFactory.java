package org.wyh.testproject1.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.sql.DataSource;
 
/**
 * 
 * @author Neil
 *
 */
public class connectionFactory
{
	private static connectionFactory connectionFactory = null;
	
	private final static Logger LOGGER = Logger.getLogger(connectionFactory.class.getName());
	
	public Connection getConnection()
	{
		Connection conn = null;

		try
		{
			String DATASOURCE_CONTEXT = "java:comp/env/jdbc/wyhMysql";
			InitialContext initialContext = new InitialContext();
			DataSource datasource = (DataSource)initialContext.lookup(DATASOURCE_CONTEXT);
			if (datasource != null) {
				conn = datasource.getConnection();
			}
			else {
				LOGGER.info("Cannot establish the JDBC connection by JNDI context.");
			}
		}
		catch (Exception ex)           
		{
			LOGGER.info(ex.getMessage());
			ex.printStackTrace();
		}

		return conn;
	}
	
	public Connection getDirectConnection() {
		Connection conn = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/galleria","galleria","galleria");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}


	public static connectionFactory getInstance()
	{
		if(connectionFactory==null)
		{
			connectionFactory = new connectionFactory();
		}
		return connectionFactory;
	}
}
