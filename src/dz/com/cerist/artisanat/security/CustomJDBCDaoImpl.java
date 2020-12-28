package dz.com.cerist.artisanat.security;

import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class CustomJDBCDaoImpl extends JdbcDaoImpl {
	public CustomJDBCDaoImpl(){
		super();
	}
}