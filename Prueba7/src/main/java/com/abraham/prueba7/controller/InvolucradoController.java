package com.abraham.prueba7.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.abraham.prueba7.data.Involucrado;
import com.abraham.prueba7.data.Pago;
import com.abraham.prueba7.data.Tanda;
import com.abraham.prueba7.data.Usuario;
import com.abraham.prueba7.model.InvolucradoModel;
import com.abraham.prueba7.model.TandaModel;
import com.abraham.prueba7.model.UsuarioModel;

@Controller
public class InvolucradoController {

	@RequestMapping(value="involucrado/{idtanda}",method = RequestMethod.GET)  
	public ModelAndView getdataIn(@PathVariable("idtanda") int idtanda) {
		   List<Integer> list3 = new ArrayList<Integer>();
		
		InvolucradoModel invomodel = new InvolucradoModel();
		UsuarioModel usuariomodel = new UsuarioModel();
		TandaModel tandamodel =new TandaModel();
		

		List<Involucrado> list = invomodel.involucradosporTanda(idtanda);
		List<Usuario> lstusuario = usuariomodel.getAll();
		
		ModelAndView model=new ModelAndView();
		 model.addObject("idtanda", idtanda);
		 Tanda tanda= new Tanda();
		 tanda.setIdtanda(idtanda);
        List<Tanda> listtanda= tandamodel.edit(tanda);
		Map<String, Object> modelmap = new HashMap<String, Object>();

        for (Tanda c : listtanda) {
        	int ddays = (int) (c.getMonto()*c.getNpagos());
        	System.out.println("monto ya multiplicado"+ddays);
        	modelmap.put("list3", ddays);
        }
		modelmap.put("listtanda", listtanda);
		modelmap.put("list", list);
		modelmap.put("combousuario", lstusuario);
		

		
		return new ModelAndView("altainvolucrado", "modelmap", modelmap);

	}

	@RequestMapping(value = "/agregarinvo", method = RequestMethod.POST)
	public String addinvo(@ModelAttribute("involucrado") Involucrado involucrado) {
		int a=0;
		InvolucradoModel model = new InvolucradoModel();
		//hacermetodo para validar
		List<Involucrado> verifica=model.verificar(involucrado.getUsuario().getIduser());
		System.out.println("Elegiste el usuario con id"+involucrado.getUsuario().getIduser());
		
		if(verifica.isEmpty()){
			System.out.println("Vacio libre ///////////////////////");
			a=1;
			
		}
		for (Involucrado c : verifica) {
			
			System.out.println("Datos en el controller"+c.getIdit()+ c.getUsuario().getNombreu() + c.getAdeudo());
		if(c.getAdeudo()==0){
			System.out.println("No tiene adeudo");
			a=1;
		}else{
			System.out.println("tiene adeudo");
		}
	
		}
		if(a==1){
			int idtanda=involucrado.getTanda().getIdtanda();
			model.create(involucrado); 
			return "redirect:involucrado/"+idtanda+"";
		}
	
		return "a";
		
	}

	@RequestMapping(value = "editarinvolu/{idit}/{idtanda}", method = RequestMethod.GET)
	public ModelAndView editinvo(@PathVariable("idit") int idit,@PathVariable("idtanda") int idtanda) {
		InvolucradoModel model = new InvolucradoModel();
		//Involucrado p = new Involucrado();
		
		List<Involucrado> lst = model.edit(idit);
		UsuarioModel usuariomodel = new UsuarioModel();

		//List<Tanda> lsttanda = model.getAllTanda();
		List<Usuario> lstusuario = usuariomodel.getAll();
		//Usuario u = new Usuario();
		Map<String, Object> modelmap = new HashMap<String, Object>();
	
		ModelAndView modelandview=new ModelAndView();
		 modelandview.addObject("idtanda", idtanda);
		modelmap.put("list", lst);
		//modelmap.put("combotanda", lsttanda);
		modelmap.put("combousuario", lstusuario);

		return new ModelAndView("modificarinv", "modelmap", modelmap);
	}

	@RequestMapping(value = "/actualizarinv", method = RequestMethod.POST)
	public String updateinvo(@ModelAttribute(value = "Involucrado") Involucrado involucrado) {

		InvolucradoModel model = new InvolucradoModel();
		model.update(involucrado);
		return "redirect:involucrado";

	}

	@RequestMapping(value = "borrarinvolu/{idit}/{idtanda}", method = RequestMethod.GET)
	public String delete(@PathVariable("idit") int idit,@PathVariable("idtanda") int idtanda) {
		Involucrado p = new Involucrado();
		p.setIdit(idit);
		InvolucradoModel model = new InvolucradoModel();
		model.remove(p);
	
		return "redirect:involucrado/"+idtanda+"";

	}

}
