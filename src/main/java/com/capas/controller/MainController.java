package com.capas.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import com.capas.dao.ContribuyenteDAO;
import com.capas.dao.ImportanciaDAO;
import com.capas.domain.Contribuyente;
import com.capas.domain.Importancia;
import com.capas.service.ContribuyenteService;
import com.capas.service.ImportanciaServiceImpl;
import com.capas.service.importanciaService;


@Controller
public class MainController {
	@Autowired
	private ContribuyenteService cService;
	@Autowired
	private importanciaService iService;
	
	@RequestMapping("/inicio")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		Contribuyente cont = new Contribuyente();
		Importancia impo = new Importancia();
		List<Importancia> importancias = null;
		
		try {
			importancias = iService.findAll();
			mav.addObject("importancia", importancias);
			mav.addObject("contribuyente", cont);
			mav.setViewName("index");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	

	@RequestMapping("/guardar")
	public ModelAndView guardar(@Valid @ModelAttribute Contribuyente cont ,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		Calendar c = Calendar.getInstance();
		String fecha = Integer.toString(c.get(Calendar.YEAR)) + "/" + Integer.toString(c.get(Calendar.MONTH)+1) + "/" + Integer.toString(c.get(Calendar.DATE));
		Date date = new Date();
		
		if(!result.hasErrors()) {
			
			try {
				date = new SimpleDateFormat("yyyy/MM/dd").parse(fecha);
				
			} catch(ParseException ef) {
				ef.printStackTrace();
			}
			cont.setFecha(date);
			cService.save(cont);
			mav.setViewName("exito");
		}
		else {
			Importancia impo = new Importancia();
			List<Importancia> importancias = null;
			
			try {
				importancias = iService.findAll();
				mav.addObject("importancia", importancias);
				mav.addObject("contribuyente", cont);
				mav.setViewName("index");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			mav.setViewName("index");
		}
		return mav;
		
	}
	
	
	@RequestMapping("/listado")
	public ModelAndView mostrar() {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("contribuyentes");
			List<Contribuyente> contribuyentes = null;
			try {
				contribuyentes = cService.findAll();
				mav.addObject("contri", contribuyentes);
						 
			} catch(Exception e){
				e.printStackTrace();
			}
			
		return mav;
	}

}
