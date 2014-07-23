/**
 * 
 */
package com.st.icliente.exception;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aspecto AOP para gesti�n de excepciones de servicio configurado mediante anotaciones
 * de org.aspectj.lang.annotation.
 * @author bcarrate
 */
@Aspect
public class SExceptionManagerAspect {

	private static final Logger logger = Logger.getLogger(SExceptionManagerAspect.class);
	
	/**
	 * Definici�n de Pointcut para todos los m�todos p�blicos del paquete <tt>com.ibtim.miproyecto.dao</tt>
	 * o cualquier subpaquete.
	 */
	@Pointcut("execution(* com.ibtim..servicios..*(..))")
	public void servicioMethod() { }

	/**
	 * <i>@AfterThrowing advice</i> para {@link #servicioMethod()}.
	 * @param exception la excepci�n recibida
	 * @param joinPoint contiene informaci�n sobre el origen de la excepci�n
	 * @throws BaseException que envuelve la excepci�n lanzada por el m�todo objetivo
	 */
	@AfterThrowing(
			pointcut = "com.ibtim.exception.SExceptionManagerAspect.servicioMethod()",
			throwing = "exception")
	public void afterThrowingServicioMethod(JoinPoint joinPoint, Exception exception) throws BaseException {
		throw createOrForwardException(exception, joinPoint);
	}
	
	/*
	 * Devuelve una BaseException (implementaci�n SException) que envuelva la excepci�n recibida si �sta
	 * no es BaseException; si la excepci�n recibida es BaseException, devuelve la excepci�n recibida. De
	 * esta manera se evita envolver innecesariamente las BaseException de capas inferiores.
	 * @param exception la excepci�n recibida
	 * @param joinPoint contiene informaci�n sobre el origen de la excepci�n
	 * @return la BaseException adecuada
	 */
	private BaseException createOrForwardException(Exception exception, JoinPoint joinPoint) {
		if (exception instanceof BaseException) {
			return (BaseException) exception;
		}
		
		String message = exception.getMessage();
		Throwable cause = exception.getCause();
		Integer codigoId = null;
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		String origen = className + "." + methodName + "()";
		
		StringBuffer sb = 	new StringBuffer().
				append("Excepcion de tipo [").append(exception.getClass().getName()).append("] ").
				append("en [").append(origen).append("]");
		logger.error(sb.toString());

		return new SException(message, cause, codigoId, origen, exception);
	}
	
}
