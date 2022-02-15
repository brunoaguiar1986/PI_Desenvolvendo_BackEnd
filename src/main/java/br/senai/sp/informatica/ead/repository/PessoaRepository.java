package br.senai.sp.informatica.ead.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.senai.sp.informatica.ead.model.Pessoa;

public interface PessoaRepository extends JpaRepositoryImplementation<Pessoa, Long>{

}
