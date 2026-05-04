package br.unifap.ehr.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/**
 * Controller advice exception handlers
 * @author Thiago Pinheiro do Nascimento
 * @since 0.1
**/
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	/**
	 * Redirecting entity not persisted exception to 400 error page view
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@ExceptionHandler(exception = EntityNotPersistedException.class)
	public String handleEntityNotPersistedException(EntityNotPersistedException e) {
		return "errors/400";
	}
	
	/**
	 * Redirecting entity not found exception to 404 error page view
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@ExceptionHandler(exception = EntityNotFoundException.class)
	public String handleEntityNotFoundException(EntityNotFoundException e) {
		return "errors/404";
	}
	
	/**
	 * Redirecting entity in use exception to 409 error page view
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@ExceptionHandler(exception = EntityInUseException.class)
	public String handleEntityInUseException(EntityInUseException e) {
		return "errors/409";
	}
	
	/**
	 * Redirecting illegal argument exception to 400 error page view
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@ExceptionHandler(exception = IllegalArgumentException.class)
	public String handleIllegalArgumentException(IllegalArgumentException e) {
		return "errors/400";
	}
	
	/**
	 * Redirecting no resource found exception to 404 error page view
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@ExceptionHandler(exception = NoResourceFoundException.class)
	public String handleNoResourceFoundException(NoResourceFoundException e) {
		return "errors/404";
	}
	
	/**
	 * Redirecting no handler found exception to 404 error page view
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@ExceptionHandler(exception = NoHandlerFoundException.class)
	public String handleNoHandlerFoundException(NoHandlerFoundException e) {
		return "errors/404";
	}
	
	/**
	 * Redirecting exception to 500 error page view
	 * @author Thiago Pinheiro do Nascimento
	 * @since 0.1
	**/
	@ExceptionHandler(exception = Exception.class)
	public String handleUnCaught(Exception e) {
		return "errors/500";
	}
}