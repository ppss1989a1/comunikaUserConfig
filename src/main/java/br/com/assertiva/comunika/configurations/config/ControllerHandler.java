package br.com.assertiva.comunika.configurations.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ResponseStatusException;

import br.com.assertiva.comunika.configurations.controller.DTO.ErrorDTO;

@RestControllerAdvice
public class ControllerHandler  {
	
	@Autowired
	private MessageSource messageSource;
		
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorDTO> handle(MethodArgumentNotValidException ex){
		 List<ErrorDTO> dto = new ArrayList<ErrorDTO>();
		 List<FieldError> fieldError =   ex.getBindingResult().getFieldErrors();
			fieldError.forEach(e -> {
				String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
				ErrorDTO erro = new ErrorDTO(e.getField(), mensagem);
				dto.add(erro);
			});
			
			return dto;
	}
	
    @ExceptionHandler(TypeMismatchException.class)
    public Throwable handleTypeMismatchException(TypeMismatchException e)   {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor inválido!!! e="+e.getValue());
    }
    
 }
