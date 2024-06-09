package com.carolcaracol.api_curriculo_sb.controller;

import com.carolcaracol.api_curriculo_sb.model.Usuario;
import com.carolcaracol.api_curriculo_sb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return this.usuarioService.findAll();
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        return this.usuarioService.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable Long id){
        this.usuarioService.delete(id);
    }
}
