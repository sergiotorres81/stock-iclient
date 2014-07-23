package com.st.icliente.manager;

import com.ibtim.flexo.webservice.previa.IsExisteExpediente;
import com.st.icliente.exception.DAOException;

public interface ExpedientManager {

	Boolean findExpedient(IsExisteExpediente existeExpediente) throws DAOException;

}
