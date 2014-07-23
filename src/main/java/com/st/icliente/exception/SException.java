package com.st.icliente.exception;

public class SException extends BaseException {

	private static final long serialVersionUID = -9017535946143533577L;

	public SException(String mensajeError, Throwable causaError,
			Integer codigoId, Throwable error) {
		super(mensajeError, causaError, codigoId, error);
	}

	public SException(String mensajeError, Throwable causaError,
			Integer codigoId, String origen, Throwable error) {
		super(mensajeError, causaError, origen, codigoId, error);

	}
}