package com.carolcaracol.api_curriculo_sb.service;

import com.carolcaracol.api_curriculo_sb.model.Usuario;
import com.carolcaracol.api_curriculo_sb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return this.usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id){
        return this.usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

    public Usuario update(Long id, Usuario usuario){
        Optional<Usuario> usuarioToUpdate = this.usuarioRepository.findById(id);

        if(usuarioToUpdate.isPresent()){
            Usuario existingUsuario = usuarioToUpdate.get();

            existingUsuario.setNome(usuario.getNome());
            existingUsuario.setBio(usuario.getBio());
            existingUsuario.setEmail(usuario.getEmail());
            existingUsuario.setGithub(usuario.getGithub());

            return this.usuarioRepository.save(existingUsuario);
        }
        else{
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public void delete(Long id){
        this.usuarioRepository.deleteById(id);
    }
}
