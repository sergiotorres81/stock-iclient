package com.st.icliente.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibtim.flexo.webservice.previa.IsExisteExpediente;
import com.ibtim.flexo.webservice.previa.ObjectFactory;
import com.ibtim.flexo.webservice.previa.ReqType;
import com.st.icliente.exception.SException;
import com.st.icliente.service.ISMessageBuilder;

@Service("messageBuilderService")
public class MessageBuilderService implements ISMessageBuilder {

	@Autowired
	private ObjectFactory objectFactory;

	@Override
	public IsExisteExpediente buildFindExpedient(String bancoId,
			Integer operacionId) throws SException {
		IsExisteExpediente existeExpediente = objectFactory
				.createIsExisteExpediente();
		ReqType reqType = objectFactory.createReqType();
		reqType.setOperacionId(operacionId);
		reqType.setBancoId(bancoId);
		existeExpediente.setReq(reqType);
		return existeExpediente;
	}

}
