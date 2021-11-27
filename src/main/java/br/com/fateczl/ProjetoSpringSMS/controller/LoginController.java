package br.com.fateczl.ProjetoSpringSMS.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.fateczl.ProjetoSpringSMS.model.Login;
import br.com.fateczl.ProjetoSpringSMS.persistence.LoginDao;

@Controller
public class LoginController {

	@Autowired
	LoginDao lDao;
	
	//GET
	/*@RequestMapping(name = "login", value = "/login", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		
		Login login = new Login();
		String erro = "";
		try {
			login = lDao.validaLogin(login);
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("listaPratos", login);
			model.addAttribute("erro", erro);
		}
		
		return new ModelAndView("Login");
	}*/
	
	//POST
		@RequestMapping(name = "login", value = "/login", method = RequestMethod.POST)
		public ModelAndView op(@RequestParam Map<String, String> allRequestParam, 
				ModelMap model) {
			
			String username = allRequestParam.get("username");
			String password = allRequestParam.get("password");
		
			Login login = new Login();
			
			login.setUsuario(username);
			login.setUsuario(password);
			
			try {
				lDao.validaLogin(login);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			
			return new ModelAndView("Login");
		}
}
