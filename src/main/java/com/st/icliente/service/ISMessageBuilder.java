package com.st.icliente.service;

import com.ibtim.flexo.webservice.previa.IsExisteExpediente;
import com.st.icliente.exception.SException;

public interface ISMessageBuilder {

	IsExisteExpediente buildFindExpedient(String bancoId, Integer operacionId)
			throws SException;
}
