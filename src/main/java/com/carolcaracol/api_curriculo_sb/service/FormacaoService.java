package com.carolcaracol.api_curriculo_sb.service;

import com.carolcaracol.api_curriculo_sb.model.Formacao;
import com.carolcaracol.api_curriculo_sb.repository.FormacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FormacaoService {
    @Autowired
    private FormacaoRepository formacaoRepository;

    public List<Formacao> findAll(){
        return this.formacaoRepository.findAll();
    }

    public Formacao save(Formacao formacao){
        return this.formacaoRepository.save(formacao);
    }

    public Formacao update(Long id, Formacao formacao){
        Optional<Formacao> formacaoToUpdate = this.formacaoRepository.findById(id);

        if(formacaoToUpdate.isPresent()){
            Formacao existingFormacao = formacaoToUpdate.get();

            existingFormacao.setInstituicao(formacao.getInstituicao());
            existingFormacao.setGrau(formacao.getGrau());
            existingFormacao.setCurso(formacao.getCurso());

            return this.formacaoRepository.save(existingFormacao);
        }
        else{
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public void delete(Long id){
        this.formacaoRepository.deleteById(id);
    }
}
