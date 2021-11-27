package br.com.fateczl.ProjetoSpringSMS.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fateczl.ProjetoSpringSMS.model.Login;

@Component
public class LoginDao implements ILoginDao{
	
	@Autowired
	GenericDao gDao;
	
	@Override
	public Login validaLogin(Login p) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT Usuario, Senha FROM tbLogin WHERE Senha = ? and Usuario = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, p.getSenha());
		ps.setString(2, p.getUsuario());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			p.setUsuario(rs.getString("Usuario"));
			p.setSenha(rs.getString("Senha"));
		}
		rs.close();
		ps.close();
		c.close();
		
		System.out.println(p.toString() + "Foi essa merda");
		return p;
	}
}
