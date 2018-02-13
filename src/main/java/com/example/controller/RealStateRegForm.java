package com.example.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.FormularioAlta;
import com.example.model.Persona;
import com.example.model.RealStateForm;
import com.google.gson.Gson;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

@Controller
@Scope("request")
public class RealStateRegForm {

	final static Logger logger = Logger.getLogger(RealStateRegForm.class);

	@RequestMapping(value = "/RealStateForm")
	public String getForm(@ModelAttribute RealStateForm realStateForm, BindingResult bindingResult, Model model) {
		try {

			if (bindingResult.hasErrors()) {
				logger.error("Contiene errores el formulario");
				// return "error";
			}

			if (realStateForm.getStatus().length() > 0) {
				System.out.println(realStateForm.getStatus());
				Gson gson = new Gson();
				String json = gson.toJson(realStateForm);
				if (createQR(json)) {
					return "redirect:qrGenerator";
				}
			}

		} catch (Exception e) {

			logger.error("aca---->: " + e.getMessage());
		}

		return "RealStateForm";
	}

	@RequestMapping(value = "/persona")
	public String formPersona(@ModelAttribute Persona persona, BindingResult bd, Model model) {
		logger.info("asdasd");
		return "persona";
	}

	private boolean createQR(String json) {

		ByteArrayOutputStream bout = QRCode.from(json).withSize(250, 250).to(ImageType.PNG).stream();

		try {
			OutputStream out = new FileOutputStream("src/main/resources/qr/qr-core.png");
			bout.writeTo(out);
			out.flush();
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@RequestMapping(value = "/formularioAlta")
	public String formRealState(@ModelAttribute FormularioAlta formularioAlta, BindingResult bd, Model model) {
		logger.info("asdasd");
		return "formularioAlta";
	}

	@ResponseBody
	@RequestMapping(value = "/qrGenerator")
	public ResponseEntity<byte[]> getQR() {
		try {
			InputStream in = new FileInputStream(new File("src/main/resources/qr/qr-core.png"));

			HttpHeaders header = new HttpHeaders();
			header.set("Content-Type", "image/png");
			
			return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), header, HttpStatus.OK);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
