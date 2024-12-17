package com.pawpengaga.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Esto es una de esas cosas que jamás cambian

@ControllerAdvice // Maneja adveterncias de los controladores
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public String handleValidationException(MethodArgumentNotValidException e, Model model){
    model.addAttribute("errors", e.getBindingResult().getFieldErrors());
    return "registro";
  }

}
