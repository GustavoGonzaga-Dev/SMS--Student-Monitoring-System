package br.com.fateczl.ProjetoSpringSMS.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class GenericDao {
		
	 private Connection c;
	 
	 public Connection getConnection() throws ClassNotFoundException, SQLException {
		 Class.forName("net.sourceforge.jtds.jdbc.Driver");
	     c = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=bdSMS;namedPipe=true","usuario","senha");
	     //System.out.println("Conexao ok");
	     return c;
	 }
}
