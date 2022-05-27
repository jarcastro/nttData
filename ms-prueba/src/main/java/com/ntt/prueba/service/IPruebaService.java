package com.ntt.prueba.service;

import java.util.Map;
import com.ntt.prueba.exp.GetDatosRequestAfiliadoDTO;
import com.ntt.prueba.exp.GetDatosResponseDTO;


public interface IPruebaService {

	public GetDatosResponseDTO getDatos(Map<String, String> requestHeader , GetDatosRequestAfiliadoDTO request);
	public int insertDatos(Map<String, String> requestHeader , GetDatosRequestAfiliadoDTO request);


}
