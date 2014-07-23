package com.st.icliente.dto;

import java.io.Serializable;

public class Greeting implements Serializable {
	private static final long serialVersionUID = 963981547724614700L;
	private long id;
	private String content;

	public Greeting() {
	}

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
