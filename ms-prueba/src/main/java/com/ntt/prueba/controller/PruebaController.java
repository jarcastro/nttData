
package com.ntt.prueba.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ntt.prueba.exp.GetDatosRequestAfiliadoDTO;
import com.ntt.prueba.exp.GetDatosResponseDTO;
import com.ntt.prueba.service.IPruebaService;



@RestController
@RequestMapping(value = "/prueba")
public class PruebaController{

	private IPruebaService service;

	@Autowired 
	public PruebaController(IPruebaService service)
	{
		this.service = service;
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(path = "insertDatos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity insertDatos(@RequestHeader Map<String, String> requestHeader,
			@RequestBody GetDatosRequestAfiliadoDTO request){
	                 int row;	
					 row = service.insertDatos(requestHeader, request);
					 return new ResponseEntity<Integer>(row, HttpStatus.OK);
	}
	
	
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping(path = "getDatos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getDatos(@RequestHeader Map<String, String> requestHeader,
			@RequestBody GetDatosRequestAfiliadoDTO request){					
	                 GetDatosResponseDTO gg = null;	
					 gg = service.getDatos(requestHeader, request);
					 return new ResponseEntity<String>(gg.toString(),HttpStatus.OK);
	}
	
	

}
