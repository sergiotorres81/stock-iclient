package com.st.icliente.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.st.icliente.exception.DAOException;
import com.st.icliente.exception.SException;
import com.st.icliente.manager.ExpedientManager;
import com.st.icliente.service.ISMessageBuilder;
import com.st.icliente.service.ISWebServiceClient;

@Service
@Qualifier("webServiceClientService")
public class WebServiceClientService implements ISWebServiceClient {

	@Autowired
	@Qualifier("expedientManagerImpl")
	private ExpedientManager expedienteManagerImpl;
	@Autowired
	@Qualifier("messageBuilderService")
	private ISMessageBuilder messageBuilderService;

	public Boolean findExpedient(String bancoId, Integer operacionId)
			throws SException, DAOException {
		return expedienteManagerImpl.findExpedient(messageBuilderService
				.buildFindExpedient(bancoId, operacionId));
	}

}
