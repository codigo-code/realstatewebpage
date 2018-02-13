package com.example.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.FormularioAlta;
import com.example.model.Persona;
import com.example.model.RealStateForm;

@Controller
@Scope("request")
public class RealStateRegForm {

	
	final static Logger logger = Logger.getLogger(RealStateRegForm.class);
	
	@RequestMapping(value="/RealStateForm")
	public String getForm(@ModelAttribute RealStateForm realStateForm, BindingResult bindingResult,Model model){
		try {
			
			Path path = Paths.get(realStateForm.getReference());
			
			String b64 = Base64.getEncoder().encodeToString(Files.readAllBytes(path));
			
			logger.info(b64);
			
			if(bindingResult.hasErrors()){
				logger.error("Contiene errores el formulario");
				//return "error";
			}
			
			
			
		} catch (Exception e) {
			
			logger.error("aca---->: " + e.getMessage());
		}
		
		return "RealStateForm";
	}

	
	@RequestMapping(value="/persona")
	public String formPersona(@ModelAttribute Persona persona, BindingResult bd, Model model){
		logger.info("asdasd");
		return "persona";
	}
	
	
	@RequestMapping(value="/formularioAlta")
	public String formRealState(@ModelAttribute FormularioAlta formularioAlta, BindingResult bd, Model model){
		logger.info("asdasd");
		return "formularioAlta";
	}
	
	
}
