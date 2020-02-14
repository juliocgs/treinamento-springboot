package br.com.cast.treinamento.repository;

import br.com.cast.treinamento.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>, CursoRepositoryCustom {
    @Query("select count(1) > 0 from Curso where nome = :nome and categoria.id = :categoriaId")
    boolean existsCursoByNomeByCategory(String nome, long categoriaId);

    @Query("select count(1) > 0 from Curso where nome = :nome and categoria.id = :categoriaId and id <> :id")
    boolean existsCursoByNomeAndByCategoryExceptId(String nome, long categoriaId, Long id);
}
