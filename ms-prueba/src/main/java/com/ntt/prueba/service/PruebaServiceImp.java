package com.ntt.prueba.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ntt.prueba.dto.GetParameterDBRequestAfiliadoDTO;
import com.ntt.prueba.adapter.ConectorDBAdapter;
import com.ntt.prueba.mapper.GetParameterDBRequestAfilidadoDTOMapper;
import com.ntt.prueba.mapper.GetParametersResponseDTOMapper;
import com.ntt.prueba.dto.GetParameterDBResponseDTO;
import com.ntt.prueba.exp.GetDatosRequestAfiliadoDTO;
import com.ntt.prueba.exp.GetDatosResponseDTO;


@Service
public class PruebaServiceImp implements IPruebaService {
	
	ConectorDBAdapter conectorDBAdapter;

	@Autowired
	public PruebaServiceImp(ConectorDBAdapter conectorDBAdapter) {
		this.conectorDBAdapter = conectorDBAdapter;
	}

			@Override
			public GetDatosResponseDTO getDatos(Map<String, String> requestHeader, GetDatosRequestAfiliadoDTO request){
				GetParameterDBRequestAfiliadoDTO requestDB=new GetParameterDBRequestAfilidadoDTOMapper().getObject(request);
				GetParameterDBResponseDTO responseDB=conectorDBAdapter.getParameters(requestHeader, requestDB);
				return new GetParametersResponseDTOMapper().getObject(responseDB);
			}

			@Override
			public int insertDatos(Map<String, String> requestHeader, GetDatosRequestAfiliadoDTO request){
				GetParameterDBRequestAfiliadoDTO requestDB=new GetParameterDBRequestAfilidadoDTOMapper().getObject(request);
				return conectorDBAdapter.insertParameters(requestHeader, requestDB);
			}

}
