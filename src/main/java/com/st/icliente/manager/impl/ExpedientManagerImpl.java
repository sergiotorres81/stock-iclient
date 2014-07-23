package com.st.icliente.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.ibtim.flexo.webservice.previa.IsExisteExpediente;
import com.ibtim.flexo.webservice.previa.IsExisteExpedienteResponse;
import com.st.icliente.exception.DAOException;
import com.st.icliente.manager.ExpedientManager;

@Component
@Qualifier("expedientManagerImpl")
public class ExpedientManagerImpl implements ExpedientManager {

	@Autowired
	private WebServiceTemplate webServiceTemplate;

	@Override
	public Boolean findExpedient(IsExisteExpediente existeExpediente)
			throws DAOException {

		IsExisteExpedienteResponse existeExpedienteResponse = (IsExisteExpedienteResponse) webServiceTemplate
				.marshalSendAndReceive(existeExpediente);
		return existeExpedienteResponse.getIsExisteExpedienteReturn()
				.getValue();
	}
}
