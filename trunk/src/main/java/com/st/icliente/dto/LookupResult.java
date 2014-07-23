package com.st.icliente.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class LookupResult implements Serializable {
	private static final long serialVersionUID = -9130852353708036084L;
	@JsonProperty("Symbol")
	private String symbol;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Exchange")
	private String exchange;

	public LookupResult() {
		super();
	}

	public LookupResult(String symbol, String name, String exchange) {
		super();
		this.symbol = symbol;
		this.name = name;
		this.exchange = exchange;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

}
