package com.abraham.prueba7.controller;

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
import com.abraham.prueba7.data.Pago;
import com.abraham.prueba7.model.CalendariopagosModel;
import com.abraham.prueba7.model.InvolucradoModel;
import com.abraham.prueba7.model.PagoModel;

@Controller
public class PagoController {

	
	
	 
	   @RequestMapping(value="pago/{idtanda}",method = RequestMethod.GET)  
	   public ModelAndView vercalendario(@PathVariable("idtanda") int idtanda){  
		   InvolucradoModel model = new InvolucradoModel();
		   CalendariopagosModel  model2= new CalendariopagosModel();
		  List<Involucrado> list= model.involucradosporTanda(idtanda);
		  List<Calendariopagos> list2= model2.todoCalendariopagos(idtanda);

		  System.out.println("Lista Involucrados"+list);

		  ModelAndView modelandview=new ModelAndView();
			 modelandview.addObject("idtanda", idtanda);
				Map<String, Object> modelmap = new HashMap<String, Object>();
				modelmap.put("list", list);
				modelmap.put("list2", list2);
			
		        return new ModelAndView("altapago2","modelmap",modelmap); 
	   }
	   

	@RequestMapping(value = "/agregarpago", method = RequestMethod.POST)
	public String addinvo(@ModelAttribute("pago") Pago pago) {
		PagoModel model = new PagoModel();
	
	
		System.out.println("fpago-->"+pago.getFpago());
		System.out.println("idcp-->"+pago.getCalendariopagos().getIdcp());
		System.out.println("idit-->"+pago.getInvolucrado().getIdit());
		model.create(pago);

		return "redirect:/welcome";
	}

	@RequestMapping(value = "editarpago/{idpago}", method = RequestMethod.GET)
	public ModelAndView editinvo(@PathVariable("idpago") int idpago) {
		PagoModel model = new PagoModel();
		Pago p = new Pago();
		p.setIdpago(idpago);
		List<Pago> listpa = model.edit(p);

		InvolucradoModel inv = new InvolucradoModel();
		PagoModel pa = new PagoModel();

		//List<Involucrado> list = inv.getAll();
		List<Calendariopagos> listcp = pa.getAllCP();

		Map<String, Object> modelmap = new HashMap<String, Object>();
		modelmap.put("list", listpa);
		//modelmap.put("comboinv", list);
		modelmap.put("combocp", listcp);

		return new ModelAndView("modificarpago", "modelmap", modelmap);

	}

	@RequestMapping(value = "/actualizarpa", method = RequestMethod.POST)
	public String updateinvo(@ModelAttribute(value = "Pago") Pago pago) {

		PagoModel model = new PagoModel();
		model.updateP(pago);
		return "redirect:pago";

	}

	@RequestMapping(value = "borrarpago/{idpago}", method = RequestMethod.GET)
	public String delete(@PathVariable("idpago") int idpago) {
		Pago p = new Pago();
		p.setIdpago(idpago);
		PagoModel model = new PagoModel();
		model.remove(p);
		return "redirect:/pago";
	}
	
	
	
	

	@RequestMapping(value = "verpagostanda/{idtanda}", method = RequestMethod.GET)
	public ModelAndView verpagostanda(@PathVariable("idtanda") int idtanda) {
		PagoModel model = new PagoModel();
		Pago p = new Pago();
	
		List<Pago> listpa = model.edit(p);

		InvolucradoModel inv = new InvolucradoModel();
		PagoModel pa = new PagoModel();

		//List<Involucrado> list = inv.getAll();
		List<Calendariopagos> listcp = pa.getAllCP();

		Map<String, Object> modelmap = new HashMap<String, Object>();
		modelmap.put("list", listpa);
		//modelmap.put("comboinv", list);
		modelmap.put("combocp", listcp);

		return new ModelAndView("modificarpago", "modelmap", modelmap);

	}


}
