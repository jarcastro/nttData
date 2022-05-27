

package com.ntt.prueba.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class GetParameterDBRequestAfiliadoDTO {
	private int id;
	private String nombres;
	private String apellidos;
	private int edad;
}
