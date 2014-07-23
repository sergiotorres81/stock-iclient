package com.st.icliente.dto;

public class ShareInfoDto {

	private String name;
	private String code;
	private Double value;

	public ShareInfoDto(String name, String code, Double value) {
		super();
		this.name = name;
		this.code = code;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
