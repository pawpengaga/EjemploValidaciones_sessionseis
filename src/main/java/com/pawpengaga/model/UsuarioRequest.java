package com.pawpengaga.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

// Esto usa setter y getter...

@Data
public class UsuarioRequest {

  // Creamos una solicitud de usuario, este nombre está definido por CONVENCIÓN
  // Los nombres aqui deben corresponder en forma y orden con los atributos del modelo

  @NotBlank(message = "El nombre no puede estar vacio...")
  private String nombre;

  @NotBlank(message = "La contraseña no puede estar vacia")
  // Hacer una anotación personalizada con el método de cálculo del dígito verificador
  @Size(min = 6, max = 20, message = "La contraseña debe tener entre 6 y 20 caracteres")
  @Pattern(regexp = "^(\\d{1,3}(?:\\.\\d{1,3}){2}-[\\dkK])$", message = "La contraseña debe estar formateada como un RUT Chileno... CAMBIAR LUEGO")
  private String clave; // Si quisieramos hacer validaciones en base a una expresión regular se debería hacer en una clase a parte...
  
  @NotBlank(message = "El correo no puede estar vacio...")
  @Email(message = "El correo debe ser válido")
  private String correo;

}
