package com.st.icliente.service;

import com.st.icliente.exception.DAOException;
import com.st.icliente.exception.SException;

public interface ISWebServiceClient {

	Boolean findExpedient(String bancoId, Integer operacionId) throws SException, DAOException;

}
