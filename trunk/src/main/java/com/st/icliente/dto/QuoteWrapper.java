package com.st.icliente.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class QuoteWrapper {
	@JsonProperty("Data")
	private Quote quote;

	public QuoteWrapper() {
		super();
	}

	public QuoteWrapper(Quote quote) {
		super();
		this.quote = quote;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

}
