package com.carolcaracol.api_curriculo_sb.service;

import com.carolcaracol.api_curriculo_sb.model.Trabalho;
import com.carolcaracol.api_curriculo_sb.repository.TrabalhoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TrabalhoService {
    @Autowired
    private TrabalhoRepositoy trabalhoRepository;

    public List<Trabalho> findAll(){
        return this.trabalhoRepository.findAll();
    }

    public Trabalho save(Trabalho trabalho){
        return this.trabalhoRepository.save(trabalho);
    }

    public Trabalho update(Long id, Trabalho trabalho){
        Optional<Trabalho> trabalhoToUpdate = this.trabalhoRepository.findById(id);

        if(trabalhoToUpdate.isPresent()){
            Trabalho existingTrabalho = trabalhoToUpdate.get();

            existingTrabalho.setCargo(trabalho.getCargo());
            existingTrabalho.setEmpresa(trabalho.getEmpresa());
            existingTrabalho.setEndereco(trabalho.getEndereco());

            return this.trabalhoRepository.save(existingTrabalho);
        }
        else{
            throw new RuntimeException("Trabalho não encontrado");
        }
    }

    public void delete(Long id){
        this.trabalhoRepository.deleteById(id);
    }
}
