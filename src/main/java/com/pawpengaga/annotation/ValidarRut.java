package com.pawpengaga.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD}) // Esta anotación busca validar es un campo!
@Retention(RetentionPolicy.RUNTIME) // Esto se aplica en tiempo de ejecución
@Constraint(validatedBy = {ValidarRutValidator.class})
public @interface ValidarRut {

  // VAMOS A CREAR NUESTRA PRIMER ANOTACION QUE EMOCIÓN
  String message() default "El RUT no es válido";

  Class<?>[] groups() default { }; // Como estamos validando un campo esto queda en blanco

  Class<? extends Payload>[] payload() default { };


}
