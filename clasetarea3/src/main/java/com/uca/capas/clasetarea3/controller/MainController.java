package com.uca.capas.clasetarea3.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	

	@RequestMapping("/ingresar")
	public ModelAndView index()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("commons/ingresar");
		return mav;
	}
	
	
	@RequestMapping("/proceso")
	public ModelAndView index(@RequestParam String nombres,@RequestParam String apellidos, @RequestParam String lugar, @RequestParam String cole , @RequestParam String tels, @RequestParam String cels,@RequestParam String fecha) throws Exception 
    
	{		 	    		
        
		ModelAndView mav = new ModelAndView();
		ModelAndView mav2 = new ModelAndView();		
        String year = fecha.substring(0,4);        
        int anio = Integer.parseInt(year);                
        
		List<String> lista = new ArrayList<>();
		
		if(anio >= 2003 && nombres.length()>=1 && nombres.length()<=25 &&apellidos.length() >= 1 && apellidos.length()<=25 && lugar.length() >= 1 && lugar.length()<=25 && cole.length() >= 1 && cole.length()<=100 && tels.length() ==8 && cels.length()==8)
		{
			mav.addObject("name", nombres);
			mav.addObject("lastname",apellidos);
			mav.addObject("start",fecha);
			mav.addObject("place", lugar);
			mav.addObject("hs",cole);			
			mav.addObject("telephone", tels);
			mav.addObject("cellphone", cels);
			mav.setViewName("commons/resultado");
			return mav;
		}
		
		if(anio <= 2002)
		{
			lista.add("La fecha de nacimiento no puede ser menor al 1 de enero de 2003");
		}
		if(nombres.length() <= 1)
		{
			lista.add("El campo Nombres no puede ser menor a 1 caracter");
		}
		if( nombres.length()>=26)
		{
			lista.add("El campo Nombres no puede ser mayor a 25 caracteres");
		}
		if(apellidos.length() <= 1 )
		{
			lista.add("El campo Apellidos no puede ser menor a 1 caracter");
		}
		if( apellidos.length()>=26)
		{
			lista.add("El campo Apellidos no puede ser mayor a 25 caracteres");
		}
		if(lugar.length() <= 1)
		{
			lista.add("El campo Lugar de Nacimiento no puede ser menor a 1 caracter");
		}
		if(lugar.length()>=26)
		{
			lista.add("El campo Lugar de Nacimiento no puede ser mayor a 25 caracteres");
		}
		if(cole.length() <= 1 )
		{
			lista.add("El campo Instituto o Colegio de procedencia no puede ser menor a 1 caracter");
		}
		if( cole.length()>=100)
		{
			lista.add("El campo Instituto o Colegio de procedencia no puede ser mayor a 100 caracteres");
		}
		if(tels.length()!= 8)
		{
			lista.add("El campo Teléfono debe tener 8 números");
		}
		if(cels.length()!= 8)
		{
			lista.add("El campo Celular debe tener 8 números");
		}
		
		
			mav2.addObject("errores",lista);			
			mav2.setViewName("commons/error");
			return mav2;
		
	}
}
