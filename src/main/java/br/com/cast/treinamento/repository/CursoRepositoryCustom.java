package br.com.cast.treinamento.repository;

import br.com.cast.treinamento.model.Curso;
import br.com.cast.treinamento.model.dto.PaginacaoDTO;
import br.com.cast.treinamento.model.request.CursoPaginadoRequest;
import org.springframework.data.domain.Page;

public interface CursoRepositoryCustom {

    public Page<Curso> consultarPorFiltro(PaginacaoDTO<CursoPaginadoRequest> filtro);
}
