package com.ntt.prueba.mapper;
import com.ntt.prueba.dto.GetParameterDBRequestAfiliadoDTO;
import com.ntt.prueba.exp.GetDatosRequestAfiliadoDTO;



public class GetParameterDBRequestAfilidadoDTOMapper {


		
		
		public GetParameterDBRequestAfiliadoDTO getObject(GetDatosRequestAfiliadoDTO request) {
			return GetParameterDBRequestAfiliadoDTO.builder().id(request.getId()).nombres(request.getNombres())
					.apellidos(request.getApellidos()).edad(request.getEdad()
					).build();
		}
}
