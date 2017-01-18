package com.abraham.prueba7.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.abraham.prueba7.data.Calendariopagos;
import com.abraham.prueba7.data.Involucrado;
import com.abraham.prueba7.data.Periodo;
import com.abraham.prueba7.data.Tanda;
import com.abraham.prueba7.model.CalendariopagosModel;
import com.abraham.prueba7.model.InvolucradoModel;
import com.abraham.prueba7.model.PeriodoModel;
import com.abraham.prueba7.model.TandaModel;

@Controller
public class TandaController {
	
	@RequestMapping(value = "/tanda", method = RequestMethod.GET)
		public ModelAndView getdataT() {
				//declara la lista de tanda
			     TandaModel t = new TandaModel ();
			     List<Tanda> list=t.getAll();  
			     
			    //declara la lista de periodos
			     PeriodoModel periodomodel = new PeriodoModel(); 
			     List<Periodo> lstperiodo=periodomodel.getAll();
			     
			    //guarda ambas listas en un mapa
			     Map<String, Object> modelmap = new HashMap<String, Object>();
			        modelmap.put("list", list);
			        modelmap.put("comboperiodo", lstperiodo);
			        

			        return new ModelAndView("altatanda","modelmap",modelmap); 

		}
	
	 @RequestMapping(value = "/agregartanda", method = RequestMethod.POST) 
	   public String addtanda(@ModelAttribute("tanda")  Tanda tanda) 
	   { 
		 
				 TandaModel model = new TandaModel();
		
			
				 model.create(tanda);
	   	   return "redirect:/tanda";
	   }
	 
	 @RequestMapping(value="borrartanda/{idtanda}",method = RequestMethod.GET)  
	   public String delete(@PathVariable("idtanda") int idtanda){  
		 Tanda p= new Tanda();
		 p.setIdtanda(idtanda);
		 TandaModel model = new TandaModel();
		 model.remove(p);
		   return "redirect:/tanda";
	   }
	 
	 @RequestMapping(value = "editartanda/{idtanda}", method = RequestMethod.GET)
	   public ModelAndView editContact(@PathVariable("idtanda") int idtanda) {
		   BigDecimal bd = new BigDecimal(idtanda);
		   
		   TandaModel model = new TandaModel();
		   Tanda t= new Tanda();
		   t.setIdtanda(idtanda);
		   List<Tanda> lst=model.edit(t);  
		     
		    PeriodoModel periodomodel = new PeriodoModel(); 
		    List<Periodo> lstperiodo=periodomodel.getAll();
		    
		    Map<String, Object> modelmap = new HashMap<String, Object>();
	        modelmap.put("lst", lst);
	        modelmap.put("comboperiodo", lstperiodo);
	

	       return new ModelAndView("modificartanda","modelmap",modelmap);  
	   }
	 
	   @RequestMapping(value="/actualizartanda",method = RequestMethod.POST)
	   public String update(@ModelAttribute(value="tanda") Tanda tanda) {

TandaModel model = new TandaModel();
	    model.update(tanda);
		   return "redirect:/tanda";

	   }
	   
	   
	   @RequestMapping(value="generarcalendario/{idtanda}",method = RequestMethod.GET)  
	   public String buscar(@PathVariable("idtanda") int idtanda){  
		 Tanda p= new Tanda();
		 p.setIdtanda(idtanda);
		 TandaModel model = new TandaModel();
		 model.crearcalendario(idtanda);
		   return "redirect:/tanda";
	   }
	   @RequestMapping(value="borrarcalendario/{idtanda}",method = RequestMethod.GET)  
	   public String borrarcalendario(@PathVariable("idtanda") int idtanda){  
		
		 TandaModel model = new TandaModel();
		 model.borrarcalendario(idtanda);
		   return "redirect:/tanda";
	   }
	   
	   
	   @RequestMapping(value="vercalendario/{idtanda}",method = RequestMethod.GET)  
	   public ModelAndView vercalendario(@PathVariable("idtanda") int idtanda){  
		CalendariopagosModel model = new CalendariopagosModel();
		     List<Calendariopagos> list=model.todoCalendariopagos(idtanda);  
		     InvolucradoModel model2 = new InvolucradoModel();
		     //List<Involucrado> listt=model2.involucradostanda(idtanda);
		     System.out.println("Soy 1 lista"+list);
		    // System.out.println("Soy 2 lista"+listt);

		     Map<String, Object> modelmap = new HashMap<String, Object>();
		        modelmap.put("list", list);
		      //  modelmap.put("listt", listt);
		
		        return new ModelAndView("vercalendario","modelmap",modelmap); 
	   }
	   
	   
	
	}