package br.com.fateczl.ProjetoSpringSMS.persistence;

import java.sql.SQLException;

import br.com.fateczl.ProjetoSpringSMS.model.Login;

public interface ILoginDao {

	public Login validaLogin(Login L) throws SQLException, ClassNotFoundException;

}
