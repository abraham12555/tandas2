package com.abraham.prueba7.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abraham.prueba7.data.Ejerce;
import com.abraham.prueba7.data.Perfil;
import com.abraham.prueba7.data.Usuario;
import com.abraham.prueba7.model.EjerceModel;
import com.abraham.prueba7.model.PerfilModel;
import com.abraham.prueba7.model.UsuarioModel;
@Controller
public class UsuarioController {
	

	  
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public ModelAndView getdata() {
	UsuarioModel p = new UsuarioModel();
	// List<Usuario> list = p.getAll();
	PerfilModel perfilmodel = new PerfilModel();
	EjerceModel ejlmodel = new EjerceModel();
	ejlmodel.todoEjerce();
	List<Ejerce> list =ejlmodel.todoEjerce();
	List<Perfil> lstperfil = perfilmodel.getAll();
	Map<String, Object> modelmap = new HashMap<String, Object>();
	modelmap.put("list", list);
	modelmap.put("comboperfil", lstperfil);

	return new ModelAndView("altausuario", "modelmap", modelmap);

	}
	   
	   
	   @RequestMapping(value = "/agregarusuario", method = RequestMethod.POST) 
	   public String addperfil(@ModelAttribute("usuario")  Usuario usuario, @RequestParam("idperfil") int idperfil) 
	   { 
		 System.out.println(usuario);
				 UsuarioModel model = new UsuarioModel();
model.create(usuario);
EjerceModel ejercemodel = new EjerceModel ();
Ejerce ejerce= new Ejerce();
ejerce.setUsuario(usuario);
Perfil perfil= new Perfil ();
perfil.setIdperfil(idperfil);
ejerce.setPerfil(perfil);

ejercemodel.create(ejerce);
	   	   return "redirect:/usuario";
	   }
	   
	   
	   @RequestMapping(value = "/guardarrol", method = RequestMethod.POST) 
	   public String addrol(@RequestParam("iduser") int iduser,
	            @RequestParam("idperfil") int idperfil) 
	   { 
		 
			
				 System.out.println("Hola soy el id user"+iduser);
				 System.out.println("hola soy el id perfil"+idperfil);
				 Perfil perfil = new Perfil();
				 perfil.setIdperfil(idperfil);
				 Usuario usuario = new Usuario();
				 usuario.setIduser(iduser);
				 Ejerce ejerce = new Ejerce();
				 ejerce.setPerfil(perfil);
				 ejerce.setUsuario(usuario);
				 EjerceModel ejercemodel=new EjerceModel();
				 

				 ejercemodel.create(ejerce);
	   	   return "redirect:/usuario";
	   }
	   

	   @RequestMapping(value="borrarusuario/{idejerce}",method = RequestMethod.GET)  
	   public String delete(@PathVariable("idejerce") int idejerce){  
	Ejerce ejerce = new Ejerce ();
	ejerce.setIdejerce(idejerce);
	EjerceModel ejercemodel = new EjerceModel();
	ejercemodel.remove(ejerce);

		   return "redirect:/usuario";
	   }
	   
	   @RequestMapping(value = "usuario/editarusuario/{iduser}", method = RequestMethod.GET)
	   public ModelAndView editContact(@PathVariable("iduser") int iduser) {
		   UsuarioModel model = new UsuarioModel();
		   Usuario p= new Usuario();
		   p.setIduser(iduser);
		     List<Usuario> lst=model.edit(p);  
		     Map<String, Object> modelmap = new HashMap<String, Object>();
		        modelmap.put("list", lst);

	       return new ModelAndView("modificarusuario","modelmap",modelmap);  
	   }
	   
	   @RequestMapping(value="/actualizarusuario",method = RequestMethod.POST)
	   public String update(@ModelAttribute(value="Usuario") Usuario usuario) {

UsuarioModel model = new UsuarioModel();
	    model.update(usuario);
		   return "redirect:usuario";

	   }
	   
	   
	   
	   @RequestMapping(value = "asignarrolusuario/{iduser}", method = RequestMethod.GET)
	   public ModelAndView asignarrol(@PathVariable("iduser") int iduser) {
		   UsuarioModel model = new UsuarioModel();
		   PerfilModel perfilmodel = new PerfilModel();
		   EjerceModel ejercemodel = new EjerceModel();
		   
		     List<Perfil> lstperfil=perfilmodel.getAll();
		     Usuario p= new Usuario();
		   p.setIduser(iduser);
		     List<Usuario> lst=model.edit(p);  
		     System.out.println(perfilmodel.getAll());



		     Map<String, Object> modelmap = new HashMap<String, Object>();
		        modelmap.put("list", lst);
		        modelmap.put("comboperfil", lstperfil);

	       return new ModelAndView("asignarrol","modelmap",modelmap);  
	   }
	   

}
