package com.st.icliente.service;

import com.st.icliente.dto.LookUpResultListWrapper;
import com.st.icliente.dto.Quote;

public interface ISStock {
	LookUpResultListWrapper lookupStock(String code);

	Quote quote(String symbol);
}
