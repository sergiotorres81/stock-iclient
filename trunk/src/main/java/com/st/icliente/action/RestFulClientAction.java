package com.st.icliente.action;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.st.icliente.dto.Greeting;
import com.st.icliente.dto.LookUpResultListWrapper;
import com.st.icliente.dto.LookupResult;
import com.st.icliente.enums.SpringScope;

@Component("restFulClientAction")
@Scope(SpringScope.REQUEST)
public class RestFulClientAction {

	private Logger LOG = LoggerFactory.getLogger(RestFulClientAction.class);

	private RestTemplate restTemplate = new RestTemplate();
	private String client;
	private String clientResponse;
	private String body;

	public void sendPerson() {
		LOG.debug("Sending rest message... ");
		ResponseExtractor<?> responseExtractor = null;
		Object o = null;
		try {
			o = restTemplate.execute(
					"http://localhost:19090/RestService/person/" + client,
					HttpMethod.GET, null, responseExtractor, client);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			LOG.error(e.getMessage());
		}

		LOG.debug("Something received... " + o != null ? o.toString() : "null");
	}

	public void sendGreeting() {
		LOG.debug("Sending rest message... ");
		String url = "http://localhost:19090/RestService/greeting/{name}";
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("name", client);
		ResponseEntity<Greeting> responseEntity = null;
		try {
			responseEntity = restTemplate.getForEntity(url, Greeting.class,
					vars);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			LOG.error(e.getMessage());
		}
		if (responseEntity == null) {
			LOG.debug("Problems... ");
			clientResponse = "no response";
		} else {
			LOG.debug("Something received... " + responseEntity.getStatusCode());
			LOG.debug(responseEntity.getBody().getContent());
			clientResponse = responseEntity.getBody().getContent();
		}
	}

	public void lookUpStockInformation() {

		LOG.debug("Sending rest message... ");
		String url = "http://dev.markitondemand.com/Api/v2/Lookup/json?input={input}";
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("input", "Google");
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
			clientResponse = "no response";
		} else {
			LOG.debug("Something received... " + responseEntity.getStatusCode());

			LookUpResultListWrapper listWrapper = responseEntity.getBody();
			StringBuffer buf = new StringBuffer();
			for (LookupResult result : listWrapper) {
				buf.append(" SYMBOL :  ");
				buf.append(result.getSymbol());
				buf.append(" --- ");
			}
			body = buf.toString();
		}
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getClientResponse() {
		return clientResponse;
	}

	public void setClientResponse(String clientResponse) {
		this.clientResponse = clientResponse;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
