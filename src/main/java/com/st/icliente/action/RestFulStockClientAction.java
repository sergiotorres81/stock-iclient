package com.st.icliente.action;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.st.icliente.dto.LookUpResultListWrapper;
import com.st.icliente.enums.SpringScope;

@Component("restFulStockClientAction")
@Scope(SpringScope.REQUEST)
public class RestFulStockClientAction {

	private Logger LOG = LoggerFactory
			.getLogger(RestFulStockClientAction.class);
	private String stockName;
	private LookUpResultListWrapper stockSymbolList;
	private RestTemplate restTemplate = new RestTemplate();

	public void lookUpStockInformation() {

		LOG.debug("Sending rest message... ");
		String url = "http://dev.markitondemand.com/Api/v2/Lookup/json?input={input}";
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("input", stockName);
		ResponseEntity<LookUpResultListWrapper> responseEntity = null;
		try {
			responseEntity = restTemplate.getForEntity(url,
					LookUpResultListWrapper.class, vars);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			LOG.error(e.getMessage());
		}
		if (responseEntity == null) {
			LOG.debug("Problems... ");
		} else {
			LOG.debug("Something received... " + responseEntity.getStatusCode());
			stockSymbolList = responseEntity.getBody();
		}
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public LookUpResultListWrapper getStockSymbolList() {
		return stockSymbolList;
	}

	public void setStockSymbolList(LookUpResultListWrapper stockSymbolList) {
		this.stockSymbolList = stockSymbolList;
	}

}
