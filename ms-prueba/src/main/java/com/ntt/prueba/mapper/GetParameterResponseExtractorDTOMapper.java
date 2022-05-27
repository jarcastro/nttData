package com.ntt.prueba.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.ntt.prueba.dto.GetParameterDBResponseDTO;
import com.ntt.prueba.dto.ParameterDBDTO;


public class GetParameterResponseExtractorDTOMapper implements ResultSetExtractor<GetParameterDBResponseDTO> {

	@Override
	public GetParameterDBResponseDTO extractData(ResultSet rs) throws SQLException, DataAccessException {

		GetParameterDBResponseDTO response = new GetParameterDBResponseDTO();

		boolean firstRow = true;
		ParameterDBDTO row = null;
		List<ParameterDBDTO> results = new ArrayList<>();

		while (rs.next()) {

			if (rs.getString("id") != null) {
				row = new ParameterDBDTO();
				row.setId(Integer.parseInt(rs.getString("id")));
				row.setNombres(rs.getString("nombres"));
				row.setApellidos(rs.getString("apellidos"));
				row.setEdad(Integer.parseInt(rs.getString("edad")));
				results.add(row);
			}
		}

		response.setParameters(results);

		return response;
	}

}
