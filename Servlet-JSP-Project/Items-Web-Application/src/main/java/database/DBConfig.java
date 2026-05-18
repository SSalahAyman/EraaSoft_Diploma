package database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConfig {
	
	public static Connection getConnection() throws NamingException, SQLException {

		Context ctx = new InitialContext();
		
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/item");

        return ds.getConnection();
    }
}

