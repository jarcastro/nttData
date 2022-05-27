package com.ntt.prueba.exp;

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
public class ParameterDTO {

	private int id;

	private String nombres;

	private String apellidos;

	private int edad;




}
