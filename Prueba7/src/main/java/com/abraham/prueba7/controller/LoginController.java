package com.abraham.prueba7.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Sistema de tandas");
		model.addObject("message", "Pagina de bienvenida!");
		model.setViewName("index");
		return model;

	}
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hola " + user.getName()
			+ ", No tienes permisos para ver esta pagina!");
		} else {
			model.addObject("msg",
			"No tienes permisos para ver esta pagin!");
		}

		model.setViewName("403");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Pagina de administrador");
		model.addObject("message", "es una pagina protegida!");
		model.setViewName("admin");

		return model;

	}

	//Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Usuario o Contraseña incorrectos!");
		}

		if (logout != null) {
			model.addObject("msg", "Haz salido sin problemas.");
		}
		model.setViewName("login");

		return model;

	}
}
