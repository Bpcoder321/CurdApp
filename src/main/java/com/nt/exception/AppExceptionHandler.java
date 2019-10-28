package com.nt.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class AppExceptionHandler {
	@ExceptionHandler(value=NullPointerException.class )
   public String handleNullPointerException(Model model) {
	     model.addAttribute("errorMsg","some problems occurs please "
	     		                       + "try after some moments");
	      return "errorpage";	
   }
	@ExceptionHandler(value=NoIdFoundException.class)
	public  String handleNoBookFoundException() {
		  return "customError";
	}
}
