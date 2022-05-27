package com.ntt.prueba.adapter;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import com.ntt.prueba.mapper.GetParameterResponseExtractorDTOMapper;
import com.ntt.prueba.dto.GetParameterDBRequestAfiliadoDTO;
import com.ntt.prueba.dto.GetParameterDBResponseDTO;


@Repository
public class ConectorDBAdapter {



	private JdbcTemplate jdbcTemplate;
	
	@Value("${comandoinsert:null}")
	private String comandoinsert;
	
	@Value("${comandoselect:null}")
	private String comandoselect;
	
	@Autowired
	public ConectorDBAdapter( @Qualifier("jdbcTemplate") JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	public GetParameterDBResponseDTO getParameters(Map<String, String> requestHeader, @RequestBody GetParameterDBRequestAfiliadoDTO  request){

				Object[] obj = { request.getId() };
				return jdbcTemplate.query(comandoselect, obj,new GetParameterResponseExtractorDTOMapper());
    }
	
	public int insertParameters(Map<String, String> requestHeader, @RequestBody GetParameterDBRequestAfiliadoDTO request){
        Object[] obj = { request.getNombres(),request.getApellidos(), request.getEdad()}; 
		int result = jdbcTemplate.update(comandoinsert, obj);
		return result;
	}

	}


