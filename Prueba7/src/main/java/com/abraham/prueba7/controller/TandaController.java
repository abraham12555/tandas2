package com.abraham.prueba7.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abraham.prueba7.data.Perfil;
import com.abraham.prueba7.data.Periodo;
import com.abraham.prueba7.data.Tanda;
import com.abraham.prueba7.data.Usuario;
import com.abraham.prueba7.model.EjerceModel;
import com.abraham.prueba7.model.PerfilModel;
import com.abraham.prueba7.model.PeriodoModel;
import com.abraham.prueba7.model.TandaModel;
import com.abraham.prueba7.model.UsuarioModel;
@Controller
public class TandaController {

	
	@RequestMapping(value = "/tanda", method = RequestMethod.GET)
	public ModelAndView getdata() {
	// List<Usuario> list = p.getAll();
	TandaModel tandamodel = new TandaModel();
	PeriodoModel periodomodel = new PeriodoModel();
	List<Periodo> listperiodo = periodomodel.getAll();

	List<Tanda> list =tandamodel.todasTandas();
	Map<String, Object> modelmap = new HashMap<String, Object>();
	modelmap.put("list", list);
	modelmap.put("listperiodo", listperiodo);


	return new ModelAndView("altatanda", "modelmap", modelmap);

	}
	
	
	   @RequestMapping(value = "/agregartanda", method = RequestMethod.GET) 
	   public String addtanda(@ModelAttribute("tanda")  Tanda tanda, @RequestParam("idperiodo") int idperiodo,@RequestParam("finicio") String finicio,@RequestParam("ffinal") String ffinal, HttpServletRequest request, BindingResult errors) throws ParseException 
	   { 
		    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
	          String strFecha1 = finicio;
	          String strFecha2 = ffinal;

	          Date fecha1 = null;
	          Date fecha2 = null;


	              fecha1 = formatoDelTexto.parse(strFecha1);
	              fecha2 = formatoDelTexto.parse(strFecha2);

		   
TandaModel tandamodel= new TandaModel();
Periodo periodo = new Periodo ();

periodo.setIdperiodo(idperiodo);
tanda.setPeriodo(periodo);
tanda.setFinicio(fecha1);
tanda.setFfinal(fecha2);

tandamodel.create(tanda);

	   	   return "redirect:/tanda";
	   }
	   
	   
	   
	   @RequestMapping(value = "agregarinvolucrados/{idtanda}", method = RequestMethod.GET)
	   public ModelAndView asignarrol(@PathVariable("idtanda") int idtanda) {
		   UsuarioModel usuariomodel = new UsuarioModel();
		     Usuario p= new Usuario();

Tanda tanda = new Tanda();
tanda.setIdtanda(idtanda);
TandaModel tandamodel= new TandaModel();

		     List<Usuario> listusuarios=usuariomodel.getAll();
		     List<Tanda> listtanda= tandamodel.edit(tanda);



		     Map<String, Object> modelmap = new HashMap<String, Object>();
		        modelmap.put("listusuarios", listusuarios);
		        modelmap.put("listtanda", listtanda);

	       return new ModelAndView("llenartanda","modelmap",modelmap);  
	   }
	   
	   
	   
	
	
	
}
