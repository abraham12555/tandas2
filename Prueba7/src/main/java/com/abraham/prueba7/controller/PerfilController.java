package com.abraham.prueba7.controller;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.abraham.prueba7.data.Perfil;
import com.abraham.prueba7.data.Periodo;
import com.abraham.prueba7.model.PerfilModel;
import com.abraham.prueba7.model.PeriodoModel;

@Controller
public class PerfilController {
	
	  
	   @RequestMapping(value = "/perfil", method = RequestMethod.GET)
	   public ModelAndView getdata() {
		   PerfilModel p = new PerfilModel ();
		     List<Perfil> list=p.getAll();  
		        return new ModelAndView("altaperfil","list",list);  

		}
	   
	   
	   @RequestMapping(value = "/agregarperfil", method = RequestMethod.POST) 
	   public String addperfil(@ModelAttribute("perfil") Perfil perfil) 
	   { 
		 
				 PerfilModel model = new PerfilModel();
	          model.create(perfil);
	        
	   
	   	   return "redirect:/perfil";
	   }
	   

	   @RequestMapping(value="borrarperfil/{idperfil}",method = RequestMethod.GET)  
	   public String delete(@PathVariable("idperfil") int idperfil){  
		 Perfil p= new Perfil();
		 p.setIdperfil(idperfil);
		 PerfilModel model = new PerfilModel();
		 model.remove(p);
		   return "redirect:/perfil";
	   }
	   
	   @RequestMapping(value = "editarperfil/{idperfil}", method = RequestMethod.GET)
	   public ModelAndView editContact(@PathVariable("idperfil") int idperfil) {
		   BigDecimal bd = new BigDecimal(idperfil);
		   PerfilModel model = new PerfilModel();
		   Perfil p= new Perfil();
		   p.setIdperfil(idperfil);
		     List<Perfil> lst=model.edit(p);  


	       return new ModelAndView("modificarperfil","lst",lst);  
	   }
	   @RequestMapping(value="/actualizarperfil",method = RequestMethod.POST)
	   public String update(@ModelAttribute(value="Perfil") Perfil perfil) {

PerfilModel model = new PerfilModel();
	    model.update(perfil);
		   return "redirect:perfil";

	   }
	   
	   
	   

}
