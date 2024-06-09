package com.carolcaracol.api_curriculo_sb.controller;

import com.carolcaracol.api_curriculo_sb.model.Formacao;
import com.carolcaracol.api_curriculo_sb.model.Usuario;
import com.carolcaracol.api_curriculo_sb.service.FormacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formacoes")
public class FormacaoController {
    @Autowired
    private FormacaoService formacaoService;

    @GetMapping
    public List<Formacao> listarFormacoes(){
        return this.formacaoService.findAll();
    }

    @PostMapping
    public Formacao criarFormacao(@RequestBody Formacao formacao){
        return this.formacaoService.save(formacao);
    }

    @PutMapping("/{id}")
    public Formacao atualizarFormacao(@PathVariable Long id, @RequestBody Formacao formacao){
        return this.formacaoService.update(id, formacao);
    }

    @DeleteMapping("/{id}")
    public void excluirFormacao(@PathVariable Long id){
        this.formacaoService.delete(id);
    }
}
