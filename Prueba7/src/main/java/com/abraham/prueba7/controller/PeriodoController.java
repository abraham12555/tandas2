package com.abraham.prueba7.controller;


import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.abraham.prueba7.data.Periodo;
import com.abraham.prueba7.model.PeriodoModel;

@Controller
public class PeriodoController {

   @RequestMapping(value = "/index", method = RequestMethod.GET)
   public String index() {
	   return "index";
   }
   
   @RequestMapping(value = "/redirect", method = RequestMethod.GET)
   public String redirect() {
     
      return "redirect:finalPage";
   }
   
   @RequestMapping(value = "/altaperiodo1", method = RequestMethod.POST)
   public String finalPage() {
     
      return "altaperiodo";
   }
   
   


   @RequestMapping(value = "/altaperiodo", method = RequestMethod.GET)
   public ModelAndView getdata() {
	   PeriodoModel p = new PeriodoModel ();
	     List<Periodo> list=p.getAll();  
	        return new ModelAndView("altaperiodo","list",list);  

	}
   
   

   
   @RequestMapping(value = "editar/{idperiodo}", method = RequestMethod.GET)
   public ModelAndView editContact(@PathVariable("idperiodo") int idperiodo) {
	   PeriodoModel model = new PeriodoModel();
	   Periodo p= new Periodo();
	   p.setIdperiodo(idperiodo);
	     List<Periodo> lst=model.edit(p);  

       return new ModelAndView("modificarperiodo","lst",lst);  
   }
   @RequestMapping(value="/actualizar",method = RequestMethod.POST)
   public String update(@ModelAttribute(value="Periodo") Periodo periodo) {

		 PeriodoModel model = new PeriodoModel();
    model.update(periodo);
	   return "redirect:altaperiodo";

   }
   
   
   

   @RequestMapping(value="borrar/{idperiodo}",method = RequestMethod.GET)  
   public String delete(@PathVariable("idperiodo") int idperiodo){  
	 Periodo p= new Periodo();
	 p.setIdperiodo(idperiodo);
	 PeriodoModel model = new PeriodoModel();
	 model.remove(p);
	   return "redirect:/altaperiodo";
   }  
   
   
   @RequestMapping(value = "/agregarperiodo", method = RequestMethod.POST) 
   public String addCountry(@ModelAttribute("periodo") Periodo periodo) 
   { 
	 
			 PeriodoModel model = new PeriodoModel();
          model.create(periodo);
        
   
   	   return "redirect:/altaperiodo";
   }
   
   
  
   
	   

   

	
}
