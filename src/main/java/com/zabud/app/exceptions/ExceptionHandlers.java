package com.zabud.app.exceptions;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zabud.app.shared.dominio.dto.ErrorCode;



@RestControllerAdvice
/*
 * Es un inteceptor que se encarca de controlar las excepciones //que ocurren
 * dentro de la ejecucion de una peticion
 */

/*
 * Existen tres tipos de excepciones: Bases, Tecnicas, Negocio*
 */
public class ExceptionHandlers {
 	@ExceptionHandler(Exception.class)
 	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
 	public ErrorCode handlerException(Exception e) {
 		ErrorCode ec = new ErrorCode();
 		ec.setCode(this.getId());
 		ec.setMessage("ERROR NO CONTROLADO");
 		logError(ec, e);
		return ec;

	}

	@ExceptionHandler(CodeNoValidException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorCode CantidadItemNoValida(CodeNoValidException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCode(this.getId());
		ec.setMessage("ERROR NO CONTROLADO");
		logError(ec, e);
		return ec;

	}

	/*
	 * Este metodo genera un ID para poder usarlo como referencia en los codigo que
	 * se ven en el Logger
	 */
	public String getId() {
		return UUID.randomUUID().toString();
	}

	@ExceptionHandler(MarcaNoValidException.class) // Se maneja la excepcion de un tipo especifico, tambien se encarga
	// // de mandar el objeto como respuesta al servidor
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorCode NameNoValid(MarcaNoValidException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCode(this.getId());// El codigo se establece para poder identificar el erro dentro de la
		ec.setMessage(e.getMessage());// Este mensaje es el que está establecido en el super() dentro del contructor
										// de la clase Registro
		logError(ec, e);
		return ec;
	}

	@ExceptionHandler(ColorNoValidException.class) // Se maneja la excepcion de un tipo especifico, tambien se encarga
	// // de mandar el objeto como respuesta al servidor
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorCode CodigoNoValido(ColorNoValidException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCode(this.getId());// El codigo se establece para poder identificar el erro dentro de la
		ec.setMessage(e.getMessage());// Este mensaje es el que está establecido en el super() dentro del contructor
// de la clase Registro
		logError(ec, e);
		return ec;
	}

	@ExceptionHandler(RegistroNoEncontradoException.class) // Se maneja la excepcion de un tipo especifico, tambien se
	// encarga de mandar el objeto como respuesta al servidor
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorCode registroNoEncontrado(RegistroNoEncontradoException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCode(this.getId());// El codigo se establece para poder identificar el erro dentro de la
		ec.setMessage(e.getMessage());// Este mensaje es el que está establecido en el super() dentro del contructor
// de la clase Registro
		logError(ec, e);
		return ec;
	}


	@ExceptionHandler(ModeloNoValidException.class) // Se maneja la excepcion de un tipo especifico, tambien
	// se encarga de mandar el objeto como respuesta al
	// servidor
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode PrecioIngresadoNoValido(ModeloNoValidException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCode(this.getId());// El codigo se establece para poder identificar el erro dentro de la
		ec.setMessage(e.getMessage());// Este mensaje es el que está establecido en el super() dentro del contructor
// de la clase Registro
		logError(ec, e);
		return ec;
	}

	/*
	 * Esta variable es encargada de tomar el nombre de la clase donde sucede la
	 * excepcion
	 */
	private static final Logger LOG = Logger.getLogger(ExceptionHandlers.class.getName());

	/*
	 * Este metodo es encargado de recoger los diferentes mensajes generados por la
	 * excepcion e imprimirlos por la consola
	 */
	private void logError(ErrorCode ec, Exception e) {
		LOG.severe(ec.getCode());
		LOG.severe(ec.getMessage());
		LOG.severe(e.getMessage());
	}

}
