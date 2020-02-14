package br.com.cast.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cast.treinamento.model.CategoriaCurso;

@Repository
public interface CategoriaCursoRepository extends JpaRepository<CategoriaCurso, Long> {
    boolean existsCategoriaCursoByDescricao(String descricao);

    @Query("select count(1) > 0 from CategoriaCurso where descricao = :descricao and id <> :id")
    boolean existsCategoriaCursoByDescricaoExceptId(String descricao, Long id);
}
