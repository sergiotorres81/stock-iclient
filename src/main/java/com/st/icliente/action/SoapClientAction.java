package com.st.icliente.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.st.icliente.enums.SpringScope;
import com.st.icliente.service.ISWebServiceClient;

@Component("soapClientAction")
@Scope(SpringScope.REQUEST)
public class SoapClientAction {

	private Logger LOG = LoggerFactory.getLogger(SoapClientAction.class);
	private Boolean messageIsExisteExpediente;
	private Integer operacionId;
	private String bancoId;
	@Autowired
	@Qualifier("webServiceClientService")
	private ISWebServiceClient webServiceClient;

	public void listenerExpedientExist() {
		try {
			setMessageIsExisteExpediente(webServiceClient.findExpedient(
					bancoId, operacionId));
		} catch (Exception e) {
			LOG.error("ERROR. Error al encontrar el expediente");
		}
	}

	public Boolean getMessageIsExisteExpediente() {
		return messageIsExisteExpediente;
	}

	public void setMessageIsExisteExpediente(Boolean messageIsExisteExpediente) {
		this.messageIsExisteExpediente = messageIsExisteExpediente;
	}

	public Integer getOperacionId() {
		return operacionId;
	}

	public void setOperacionId(Integer operacionId) {
		this.operacionId = operacionId;
	}

	public String getBancoId() {
		return bancoId;
	}

	public void setBancoId(String bancoId) {
		this.bancoId = bancoId;
	}

}
