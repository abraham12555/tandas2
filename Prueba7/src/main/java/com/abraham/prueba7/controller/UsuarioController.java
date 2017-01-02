package com.abraham.prueba7.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.abraham.prueba7.data.Perfil;
import com.abraham.prueba7.data.Usuario;
import com.abraham.prueba7.model.PerfilModel;
import com.abraham.prueba7.model.UsuarioModel;
@Controller
public class UsuarioController {
	

	  
	   @RequestMapping(value = "/usuario", method = RequestMethod.GET)
	   public ModelAndView getdata() {
		   UsuarioModel p = new UsuarioModel ();
		     List<Usuario> list=p.getAll();  
		        return new ModelAndView("altausuario","list",list);  

		}
	   
	   
	   @RequestMapping(value = "/agregarusuario", method = RequestMethod.POST) 
	   public String addperfil(@ModelAttribute("usuario") Usuario usuario) 
	   { 
		 
				 UsuarioModel model = new UsuarioModel();
	          model.create(usuario);
	        
	   
	   	   return "redirect:/usuario";
	   }
	   

	   @RequestMapping(value="borrarusuario/{idusuario}",method = RequestMethod.GET)  
	   public String delete(@PathVariable("idusuario") int idusuario){  
		 Usuario p= new Usuario();
p.setIduser(idusuario);		
UsuarioModel model = new UsuarioModel();
		 model.remove(p);
		   return "redirect:/usuario";
	   }
	   
	   @RequestMapping(value = "editarusuario/{iduser}", method = RequestMethod.GET)
	   public ModelAndView editContact(@PathVariable("iduser") int iduser) {
		   BigDecimal bd = new BigDecimal(iduser);
		   UsuarioModel model = new UsuarioModel();
		   Usuario p= new Usuario();
		   p.setIduser(iduser);
		     List<Usuario> lst=model.edit(p);  


	       return new ModelAndView("modificarusuario","lst",lst);  
	   }
	   
	   @RequestMapping(value="/actualizarusuario",method = RequestMethod.POST)
	   public String update(@ModelAttribute(value="Usuario") Usuario usuario) {

UsuarioModel model = new UsuarioModel();
	    model.update(usuario);
		   return "redirect:usuario";

	   }
	   
	   
	   
	   @RequestMapping(value = "asignarrolusuario/{iduser}", method = RequestMethod.GET)
	   public ModelAndView asignarrol(@PathVariable("iduser") int iduser) {
		   BigDecimal bd = new BigDecimal(iduser);
		   UsuarioModel model = new UsuarioModel();
		   Usuario p= new Usuario();
		   p.setIduser(iduser);
		     List<Usuario> lst=model.edit(p);  


	       return new ModelAndView("modificarusuario","lst",lst);  
	   }
	   

}
