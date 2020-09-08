package com.formation.epita;


import com.formation.epita.metier.exception.BibliothequeNontrouveException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionConfig {

//    @ExceptionHandler(BibliothequeNontrouveException.class)
////    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<String> methode1(BibliothequeNontrouveException ex){
//        System.out.println("je suis entrée dans le controller advice");
//        String message = ex.getMessage();
//        return  new ResponseEntity(message, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(BibliothequeNontrouveException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody  // necessaire lorsque la classe est de type @ControllerAdvice
    public String methode2(BibliothequeNontrouveException ex){
        System.out.println("je suis entrée dans le controller advice");
        return  ex.getMessage();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String methode3(MethodArgumentNotValidException ex){
        return ex.getMessage();
    }
    
//    @ExceptionHandler(ResponseStatusException.class)
//    public Error methode2(ResponseStatusException ex){
//        return new Error(ex.getMessage(),ex.getCause());
//    }
}
