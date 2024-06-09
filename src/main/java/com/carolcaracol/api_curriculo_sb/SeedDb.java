package com.carolcaracol.api_curriculo_sb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SeedDb {
    @Autowired
    JdbcTemplate template;

    @Autowired
    public SeedDb(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("insert into Usuarios (nome, bio, email, github) values (?, ?, ?, ?)", new Object[]{"Carol Costa", "Estudante apaixonada pelo mundo tech. Atualmente, estou cursando Administração de Empresas na UPE e Sistemas para Internet na Unicap, pelo programa Embarque Digital", "anacarolalvescosta@gmail.com", "https://github.com/carolcaracol"});
        jdbcTemplate.update("insert into Trabalhos (cargo, empresa, endereco) values (?, ?, ?)", new Object[]{"Estagiária", "Banco do Nordeste do Brasil", "Recife - PE"});
        jdbcTemplate.update("insert into Trabalhos (cargo, empresa, endereco) values (?, ?, ?)", new Object[]{"iOS Developer Student", "Apple Developer Academy | UFPE", "Recife - PE"});
        jdbcTemplate.update("insert into Formacoes (instituicao, grau, curso) values (?, ?, ?)", new Object[]{"ETE Cícero Dias", "Técnico", "Multimídia"});
        jdbcTemplate.update("insert into Formacoes (instituicao, grau, curso) values (?, ?, ?)", new Object[]{"Universidade de Pernambuco", "Bacharelado", "Administração"});
        jdbcTemplate.update("insert into Formacoes (instituicao, grau, curso) values (?, ?, ?)", new Object[]{"Universidade Católica de Pernambuco", "Tecnólogo", "Sistemas para Internet"});

    }
}
