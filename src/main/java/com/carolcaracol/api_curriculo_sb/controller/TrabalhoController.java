package com.carolcaracol.api_curriculo_sb.controller;

import com.carolcaracol.api_curriculo_sb.model.Trabalho;
import com.carolcaracol.api_curriculo_sb.model.Usuario;
import com.carolcaracol.api_curriculo_sb.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {
    @Autowired
    private TrabalhoService trabalhoService;

    @GetMapping
    public List<Trabalho> listarTrabalhos(){
        return this.trabalhoService.findAll();
    }

    @PostMapping
    public Trabalho criarTrabalho(@RequestBody Trabalho usuario){
        return this.trabalhoService.save(usuario);
    }

    @PutMapping("/{id}")
    public Trabalho atualizarTrabalho(@PathVariable Long id, @RequestBody Trabalho trabalho){
        return this.trabalhoService.update(id, trabalho);
    }

    @DeleteMapping("/{id}")
    public void excluirTrabalho(@PathVariable Long id){
        this.trabalhoService.delete(id);
    }
}
