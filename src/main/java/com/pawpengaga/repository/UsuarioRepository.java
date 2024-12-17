package com.pawpengaga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawpengaga.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
