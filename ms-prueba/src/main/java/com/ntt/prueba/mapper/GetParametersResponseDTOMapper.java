package com.ntt.prueba.mapper;

import com.ntt.prueba.dto.GetParameterDBResponseDTO;
import com.ntt.prueba.exp.GetDatosResponseDTO;
import com.ntt.prueba.exp.ParameterDTO;

import java.util.ArrayList;
import java.util.List;


public class GetParametersResponseDTOMapper {

	public GetDatosResponseDTO getObject(GetParameterDBResponseDTO responseDB) {
		List<ParameterDTO> parameters = new ArrayList<>();
		responseDB.getParameters().stream().forEach(e -> {
			parameters.add(ParameterDTO.builder().id(e.getId()).nombres(e.getNombres()).apellidos(e.getApellidos())
					.edad(e.getEdad()).build());
		});

		return GetDatosResponseDTO.builder().parameters(parameters).build();
	}

}
