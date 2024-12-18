package com.pawpengaga.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidarRutValidator implements ConstraintValidator<ValidarRut, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    // boolean metodoClases = calculoDigitoVerificadorClases(value);
    boolean metodoPropio = myCalculoDigitoVerificador(value);

    return metodoPropio;

  }

  private boolean calculoDigitoVerificadorClases(String value){
        /* ************ METODO ESCRITO EN CLASES POR EL PROFESOR ************ */

        String[] run = value.split("-");

        String numeros = run[0];
        String digitoVerificador = run[1].toUpperCase();

        StringBuilder alreves = new StringBuilder(numeros); // Se usará el StringBuilder
        numeros = alreves.reverse().toString(); // Aqui se voltea

        String[] cadena = numeros.split("");
        int[] valores = {2,3,4,5,6,7,2,3};
        int contador = 0;

        for (int i = 0; i < cadena.length; i++) {
          contador += Integer.parseInt(cadena[i]) * valores[i];
        }
        // int verificador = (11 - (contador % 11));

        int resto = contador %11;
        if (resto >1){
          int verificador = 11 - resto;
          return Integer.parseInt(digitoVerificador) == verificador;
        } else {
          String verificador = "K";
          return digitoVerificador.equals(verificador);
        }
   
  }

  private boolean myCalculoDigitoVerificador(String rut){
    String[] rutDividido = rut.split("-");

    if (rutDividido.length > 0) {

      // Obtencion del arreglo
      int cont = 0;
      int[] calculador = new int[8];
      for (char val : rutDividido[0].toCharArray()) {
        if (val != '.') {
          calculador[cont] = Character.getNumericValue(val);
          cont++;
        }
      }

      // Inversion del arreglo
      cont = 0;
      int[] calculadorInverso = new int[8];
      for (int i =  calculador.length - 1; i >= 0; i--) {
        calculadorInverso[cont] = calculador[i];
        cont++;
      }

      // Calculo en base al arreglo
      int digiCal = 2;
      int resultadoSuma = 0;
      for (int i = 0; i < calculadorInverso.length; i++) {
        resultadoSuma += calculadorInverso[i] * digiCal;
        digiCal++;

        if (digiCal > 7) {
          digiCal = 2;
        }
      }

      // Ya no tengo mas nombres para mas tipos de calculo
      int pasocinco = Math.round(resultadoSuma / 11) * 11;
      int pasoseis = resultadoSuma - pasocinco;
      int pasosiete = 11 - pasoseis;

      // Los reales
      String comprobador = rutDividido[1]; 
      char verificador = 'x';
      
      // Asignacion verificadora
      if (pasosiete < 11 && pasosiete >= 0) {
        if (pasosiete == 11) {
          verificador = 0;
        } else if (pasosiete == 10) {
          verificador = 'k';
        } else {
          verificador =  Character.forDigit(pasosiete, 10);
        }
      }

      // Comprobacion booleana final
      if (comprobador.equalsIgnoreCase(String.valueOf(verificador))) {
        return true;
      }

    }

    return false;
  }

}
