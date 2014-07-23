package com.st.icliente.exception;

import java.io.Serializable;

/**
 * Excepci�n gen�rica del Sistema Gestor de Procesos
 * 
 * @version 1.0
 * @author Daniel Cort�s Fern�ndez
 */
public abstract class BaseException extends Exception implements Serializable {
	
	private static final long serialVersionUID = 6726836518574684425L;
	private String mensajeError;
	private Throwable causaError;
	private Integer codigoId;
	private String origen;

	/**
	 * Constructor de la clase. Crea una excepci�n con el mensaje asociado que
	 * recibe como par�metro.
	 * 
	 * @param String -
	 *            Message
	 */
	protected BaseException(String mensajeError, Throwable causaError, String origen, Integer codigoId, Throwable error) {
		super(error);
		this.mensajeError = mensajeError;
		this.causaError = causaError;
		this.origen = origen;
		this.codigoId = codigoId;

	}
	
	protected BaseException(String mensajeError, Throwable causaError, Integer codigoId, Throwable error) {
		super(error);
		this.mensajeError = mensajeError;
		this.causaError = causaError;
		this.codigoId = codigoId;

	}

	/**
	 * Devuelve el codigo asociado con la excepci�n.
	 * 
	 * @return String - codigoError
	 */
	public Integer getCodigoId() {
		return this.codigoId;
	}

	/**
	 * Devuelve el mensaje asociado con la excepci�n.
	 * 
	 * @return String -
	 */
	public String getMensaje() {
		if(this.getCausaError() == null) {
			return this.mensajeError;
		}
		return this.mensajeError + this.getCausaError();
	}

	/**
	 * Devuelve el Metodo donde se lanz� la exception
	 * 
	 * @return String - causaError
	 */
	public Throwable getCausaError() {
		return causaError;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getOrigen() {
		return origen;
	}
	
	/**
	 * Devuelve una cadena representativa del error sucedido
	 * 
	 * @return Una cadena representativa del error sucedido
	 */
	@Override
	public String toString() {
		return getMessage() != null ? "mensaje=" + getMessage() : " ";
	}
	
}
