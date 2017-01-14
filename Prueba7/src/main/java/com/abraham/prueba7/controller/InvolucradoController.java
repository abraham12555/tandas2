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

import com.abraham.prueba7.data.Involucrado;
import com.abraham.prueba7.data.Tanda;
import com.abraham.prueba7.data.Usuario;
import com.abraham.prueba7.model.InvolucradoModel;
import com.abraham.prueba7.model.UsuarioModel;

@Controller
public class InvolucradoController {

	@RequestMapping(value = "/involucrado", method = RequestMethod.GET)
	public ModelAndView getdataIn() {
		InvolucradoModel invomodel = new InvolucradoModel();
		UsuarioModel usuariomodel = new UsuarioModel();

		List<Involucrado> list = invomodel.getAll();
		List<Tanda> lsttanda = invomodel.getAllTanda();
		List<Usuario> lstusuario = usuariomodel.getAll();

		Map<String, Object> modelmap = new HashMap<String, Object>();
		modelmap.put("list", list);
		modelmap.put("combotanda", lsttanda);
		modelmap.put("combousuario", lstusuario);

		return new ModelAndView("altainvolucrado", "modelmap", modelmap);

	}

	@RequestMapping(value = "/agregarinvo", method = RequestMethod.POST)
	public String addinvo(@ModelAttribute("involucrado") Involucrado involucrado) {
		InvolucradoModel model = new InvolucradoModel();
		model.create(involucrado);
		System.out.println("usuario tabla Involucrado -->");
		return "redirect:/involucrado";
	}

	@RequestMapping(value = "editarinvolu/{idit}", method = RequestMethod.GET)
	public ModelAndView editinvo(@PathVariable("idit") int idit) {
		InvolucradoModel model = new InvolucradoModel();
		Involucrado p = new Involucrado();
		p.setIdit(idit);
		List<Involucrado> lst = model.edit(p);
		UsuarioModel usuariomodel = new UsuarioModel();

		List<Tanda> lsttanda = model.getAllTanda();
		List<Usuario> lstusuario = usuariomodel.getAll();
		Usuario u = new Usuario();
		Map<String, Object> modelmap = new HashMap<String, Object>();
		for (Involucrado c : lst) {
			u.setIduser(c.getUsuario().getIduser());
			List<Usuario> lstu = usuariomodel.edit(u);
			for (Usuario usu : lstu) {
				modelmap.put("nom", usu.getNombreu());
				modelmap.put("idu", usu.getIduser());
			}

		}

		modelmap.put("list", lst);
		modelmap.put("combotanda", lsttanda);
		modelmap.put("combousuario", lstusuario);

		return new ModelAndView("modificarinv", "modelmap", modelmap);
	}

	@RequestMapping(value = "/actualizarinv", method = RequestMethod.POST)
	public String updateinvo(@ModelAttribute(value = "Involucrado") Involucrado involucrado) {

		InvolucradoModel model = new InvolucradoModel();
		model.update(involucrado);
		return "redirect:involucrado";

	}

	@RequestMapping(value = "borrarinvolu/{idit}", method = RequestMethod.GET)
	public String delete(@PathVariable("idit") int idit) {
		Involucrado p = new Involucrado();
		p.setIdit(idit);
		InvolucradoModel model = new InvolucradoModel();
		model.remove(p);
		return "redirect:/involucrado";
	}

}
