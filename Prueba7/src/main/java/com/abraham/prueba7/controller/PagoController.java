package com.abraham.prueba7.controller;

import java.util.ArrayList;
import java.util.Calendar;
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
import com.abraham.prueba7.data.Tanda;
import com.abraham.prueba7.model.CalendariopagosModel;
import com.abraham.prueba7.model.InvolucradoModel;
import com.abraham.prueba7.model.PagoModel;
import com.abraham.prueba7.model.TandaModel;

@Controller
public class PagoController {

	
	
	 
	   @RequestMapping(value="pago/{idtanda}",method = RequestMethod.GET)  
	   public ModelAndView vercalendario(@PathVariable("idtanda") int idtanda){  
		   InvolucradoModel model = new InvolucradoModel();
		   CalendariopagosModel  model2= new CalendariopagosModel();
			TandaModel tandamodel =new TandaModel();
			 Tanda tanda= new Tanda();
			 tanda.setIdtanda(idtanda);
	        List<Tanda> listtanda= tandamodel.edit(tanda);
	        
	        
		  List<Involucrado> list= model.involucradosporTanda(idtanda);
		  List<Calendariopagos> list2= model2.todoCalendariopagos(idtanda);

		  System.out.println("Lista Involucrados"+list);

		  ModelAndView modelandview=new ModelAndView();
			 modelandview.addObject("idtanda", idtanda);
				Map<String, Object> modelmap = new HashMap<String, Object>();
				modelmap.put("listtanda", listtanda);
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
		Map<String, Object> modelmap = new HashMap<String, Object>();

	    List <Pago> lista=model.obtenerpago(idtanda);
	    List<Pago> lista2 =model.obtenerpago(idtanda);
	    List<Double> list3 = new ArrayList<Double>();
		for (Pago c : lista2) {
			
			System.out.println("Numero de pago en controller" + c.getCalendariopagos().getPagon());
			
			//System.out.println("idpago " + c.getIdpago());
		
			System.out.println("idit-> Numero de pago en controller " + c.getInvolucrado().getUsuario().getNombreu()+c.getInvolucrado().getUsuario().getApu()+c.getInvolucrado().getUsuario().getAmu());

			System.out.println("Fecha inicio Numero de pago en controller"  + c.getCalendariopagos().getFip());
			System.out.println("Fecha final Numero de pago en controller" + c.getCalendariopagos().getFfp());
			System.out.println("Fecha en que pago Numero de pago en controller" + c.getFpago());
			   
            Calendar calendar1 = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar1.setTime(c.getCalendariopagos().getFfp());
            calendar2.setTime(c.getFpago());
            long milsecs1= calendar1.getTimeInMillis();
            long milsecs2 = calendar2.getTimeInMillis();
            long diff2 =  milsecs1-milsecs2;
            long dsecs = diff2 / 1000;
            long dminutes = diff2 / (60 * 1000);
            long dhours = diff2 / (60 * 60 * 1000);
           double ddays = diff2 / (24 * 60 * 60 * 1000);

            System.out.println("Diferencia dias ="+ddays);
    	
    		 list3.add(ddays);
		}

		
		InvolucradoModel inv = new InvolucradoModel();
		PagoModel pa = new PagoModel();
		
		//List<Involucrado> list = inv.getAll();
		List<Calendariopagos> listcp = pa.getAllCP();
		//modelmap.put("list", listpa);
		//modelmap.put("comboinv", list);
		modelmap.put("combocp", listcp);
		modelmap.put("lista", lista);
		modelmap.put("lista2", lista2);
        modelmap.put("lista3", list3);
		return new ModelAndView("verlista", "modelmap", modelmap);

	}


}
