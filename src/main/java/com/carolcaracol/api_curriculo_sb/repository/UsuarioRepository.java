package com.carolcaracol.api_curriculo_sb.repository;

import com.carolcaracol.api_curriculo_sb.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
