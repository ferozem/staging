/**Global Exception Handling using @ControllerAdvice
Add a class with annotation @ControllerAdvice and @RestController. This will make the class return a Rest Response.


@ControllerAdvice tells your spring application that this class will do the exception handling for your application. 
@RestController will make it a controller and let this class render the response.
Use @ExceptionHandler annotation to define the class of Exception it will catch. (A Base class will catch all the Inherited and extended classes) 
You can set the response status for exception using @ResponseStatus annotation.
 * 
 */
package com.jp.insurance.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

/**
 * @author Chandra Kanchapu
 *
 */
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice
@RestController  
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)   
    @ExceptionHandler(value = CustomerException.class)  
    public String handleCustomerException(CustomerException e){   
        return e.getMessage();   
    }  
  
	@ResponseStatus(HttpStatus.BAD_REQUEST)   
    @ExceptionHandler(value = AddressException.class)  
    public String handleAddressException(AddressException e){   
        return e.getMessage();   
    }  
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)   
    @ExceptionHandler(value = ClaimException.class)  
    public String handleClaimException(ClaimException e){   
        return e.getMessage();   
    } 
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)   
    @ExceptionHandler(value = EmployeeException.class)  
    public String handleEmployeeException(EmployeeException e){   
        return e.getMessage();   
    }  
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)   
    @ExceptionHandler(value = IDVException.class)  
    public String handleIDVException(IDVException e){   
        return e.getMessage();   
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)   
    @ExceptionHandler(value = IncidentException.class)  
    public String handleIncidentException(IncidentException e){   
        return e.getMessage();   
    } 
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)   
    @ExceptionHandler(value = PaymentException.class)  
    public String handlePaymentException(PaymentException e){   
        return e.getMessage();   
    }  
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)   
    @ExceptionHandler(value = NomineeException.class)  
    public String handleNomineeException(NomineeException e){   
        return e.getMessage();   
    }  
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)   
    @ExceptionHandler(value = PaymentRefException.class)  
    public String handlePaymentRefException(PaymentRefException e){   
        return e.getMessage();   
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)   
    @ExceptionHandler(value = PolicyException.class)  
    public String handlePolicyException(PolicyException e){   
        return e.getMessage();   
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)   
    @ExceptionHandler(value = ProductException.class)  
    public String handleProductException(ProductException e){   
        return e.getMessage();   
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)   
    @ExceptionHandler(value = ProjectException.class)  
    public String handleProjectException(ProjectException e){   
        return e.getMessage();   
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)   
    @ExceptionHandler(value = ReceiptException.class)  
    public String handleReceiptException(ReceiptException e){   
        return e.getMessage();   
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)   
    @ExceptionHandler(value = TicketException.class)  
    public String handleTicketException(TicketException e){   
        return e.getMessage();   
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)   
    @ExceptionHandler(value = VehicleException.class)  
    public String handleVehicleException(VehicleException e){   
        return e.getMessage();   
    }
	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "This should be application specific";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getMessage());
		ErrorResponse error = new ErrorResponse("Server Error  ",details);
		return new ResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintViolationException(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("ConstraintViolationException Error  ",details);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}