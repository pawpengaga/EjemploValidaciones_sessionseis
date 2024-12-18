package com.pawpengaga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawpengaga.model.Usuario;
import com.pawpengaga.model.UsuarioRequest;
import com.pawpengaga.repository.UsuarioRepository;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository userRepo;

  // Ahora registramos dentro de UsuarioRequest

  /*
   * Ahora registramos siempre pasando los datos por lo declarado en request
   */
  public Usuario registrarUsuario(UsuarioRequest request){
    
    Usuario user = new Usuario();
    user.setNombre(request.getNombre());
    user.setClave(request.getClave());
    user.setCorreo(request.getCorreo());
    user.setRut(request.getRut());

    return userRepo.save(user);

  }

}
