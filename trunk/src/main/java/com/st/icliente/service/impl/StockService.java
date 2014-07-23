package com.st.icliente.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.st.icliente.dto.LookUpResultListWrapper;
import com.st.icliente.dto.Quote;
import com.st.icliente.dto.QuoteWrapper;
import com.st.icliente.enums.UrlPool;
import com.st.icliente.service.ISStock;

@Service
@Qualifier("stockService")
public class StockService implements ISStock {

	private Logger LOG = LoggerFactory.getLogger(StockService.class);
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public LookUpResultListWrapper lookupStock(String code) {
		LookUpResultListWrapper result = null;
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("input", code);
		ResponseEntity<LookUpResultListWrapper> responseEntity = null;
		try {
			responseEntity = restTemplate.getForEntity(
					UrlPool.URL_SYMBOL_LOOK_UP, LookUpResultListWrapper.class,
					vars);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			LOG.error(e.getMessage());
		}
		if (responseEntity == null) {
			LOG.debug("Problems... ");
		} else {
			LOG.debug("Something received... " + responseEntity.getStatusCode());
			result = responseEntity.getBody();
		}
		return result;
	}

	@Override
	public Quote quote(String symbol) {
		Quote result = null;
		QuoteWrapper wrapper = null;
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("symbol", symbol);
		ResponseEntity<QuoteWrapper> responseEntity = null;
		try {
			responseEntity = restTemplate.getForEntity(
					UrlPool.URL_SYMBOL_QUOTE, QuoteWrapper.class, vars);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			LOG.error(e.getMessage());
		}
		if (responseEntity == null) {
			LOG.debug("Problems... ");
		} else {
			LOG.debug("Something received... " + responseEntity.getStatusCode());
			wrapper = responseEntity.getBody();
			if (wrapper != null) {
				result = wrapper.getQuote();
			}
		}
		return result;

	}

}
