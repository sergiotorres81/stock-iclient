package com.st.icliente.exception;

public class DAOException extends BaseException {

	private static final long serialVersionUID = 4568220902668366058L;

	public DAOException(String mensajeError, Throwable causaError, Integer codigoId, String origen, Throwable error) {
		super(mensajeError, causaError, origen, codigoId, error);
	}	
}
