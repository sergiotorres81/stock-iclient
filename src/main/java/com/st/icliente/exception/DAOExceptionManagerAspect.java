/**
 * 
 */
package com.st.icliente.exception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aspecto AOP para gesti�n de excepciones de DAO configurado mediante
 * anotaciones de org.aspectj.lang.annotation.
 * 
 * @author bcarrate
 */
@Aspect
public class DAOExceptionManagerAspect {

	/**
	 * Definici�n de Pointcut para todos los m�todos p�blicos del paquete
	 * <tt>com.ibtim.miproyecto.dao</tt> o cualquier subpaquete.
	 */
	@Pointcut("execution(* com.st.icliente..dao..*(..)) "
			+ "	&& (execution(* tx*(..)) " + "			|| execution(* save*(..)) "
			+ "			|| execution(* update*(..))"
			+ "			|| execution(* delete*(..)))")
	public void daoTxMethod() {
	}

	@Pointcut("execution(* com.st.icliente..dao..*(..)) "
			+ "	&& !(execution(* tx*(..)) " + "			|| execution(* save*(..)) "
			+ "			|| execution(* update*(..))"
			+ "			|| execution(* delete*(..)))")
	public void daoNoTxMethod() {
	}

	/**
	 * <i>@AfterThrowing advice</i> para {@link #daoMethod()}.
	 * 
	 * @param exception
	 *            la excepci�n recibida
	 * @param joinPoint
	 *            contiene informaci�n sobre el origen de la excepci�n
	 * @throws BaseException
	 *             que envuelve la excepci�n lanzada por el m�todo objetivo
	 */
	@AfterThrowing(pointcut = "com.st.icliente.DAOExceptionManagerAspect.daoTxMethod()", throwing = "exception")
	public void afterThrowingDaoMethod(JoinPoint joinPoint, Exception exception)
			throws BaseException {
		throw createException(exception, joinPoint);
	}

	/*
	 * Siempre lanza una BaseException (implementaci�n DAOException) que
	 * envuelve la excepci�n recibida.
	 * 
	 * @param exception la excepci�n recibida
	 * 
	 * @param joinPoint contiene informaci�n sobre el origen de la excepci�n
	 * 
	 * @return una BaseException que envuelve la excepci�n recibida
	 */
	private BaseException createException(Exception exception,
			JoinPoint joinPoint) {
		String message = exception.getMessage();
		Throwable cause = exception.getCause();
		Integer codigoId = null;
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		String origen = className + "." + methodName + "()";

		return new DAOException(message, cause, codigoId, origen, exception);
	}

}
