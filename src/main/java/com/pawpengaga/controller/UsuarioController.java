package com.pawpengaga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pawpengaga.model.Usuario;
import com.pawpengaga.model.UsuarioRequest;
import com.pawpengaga.service.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class UsuarioController {

  @Autowired
  private UsuarioService userService;

  @GetMapping("/registro")
  public String mostrarFormulario(Model model){
    model.addAttribute("usuarioRequest", new UsuarioRequest());
    return "registro";
  }

  // Recibimos el UsuarioRequest de arriba
  // @Valid llama automáticamente a @ControllerAdvise en el GlobalExceptionHandler
  @PostMapping("/registro")
  public String grabaUsuario(@Valid @ModelAttribute("usuarioRequest") UsuarioRequest request, Model model){
    Usuario user = userService.registrarUsuario(request);
    model.addAttribute("mensaje", "Usuario registrado! Bienvenid@: " + user.getNombre());
    return "resultado";
  }

}
