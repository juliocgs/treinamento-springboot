package br.com.cast.treinamento.repository;

import br.com.cast.treinamento.model.Curso;
import br.com.cast.treinamento.model.dto.PaginacaoDTO;
import br.com.cast.treinamento.model.request.CursoPaginadoRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;

public class CursoRepositoryCustomImpl implements CursoRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public Page<Curso> consultarPorFiltro(PaginacaoDTO<CursoPaginadoRequest> filtro) {
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT c FROM Curso c ");
        sb.append(" WHERE 1 = 1 ");

        if (!StringUtils.isEmpty(filtro.getFilter().getNome())) {
            sb.append(" AND c.nome LIKE :nome ");
            parametros.put("nome", "%" + filtro.getFilter().getNome() + "%");
        }

        if (filtro.getFilter().getDuracaoAnos() != null) {
            sb.append(" AND c.duracaoAnos = :duracao ");
            parametros.put("duracao", filtro.getFilter().getDuracaoAnos());
        }

        if (filtro.getFilter().getHabitadoPCD() != null) {
            sb.append(" AND c.habitadoPCD = :habitadoPCD ");
            parametros.put("habitadoPCD", filtro.getFilter().getHabitadoPCD());
        }

        if (filtro.getFilter().getExcluido() != null) {
            sb.append(" AND c.excluido = :excluido ");
            parametros.put("excluido", filtro.getFilter().getExcluido());
        }

        if (filtro.getFilter().getCategoriaId() != null) {
            sb.append(" AND c.categoria.id = :categoriaId ");
            parametros.put("categoriaId", filtro.getFilter().getCategoriaId());
        }

        Query query = entityManager.createQuery(sb.toString());
        parametros.forEach(query::setParameter);
        query.setFirstResult(filtro.getNumeroPagina() * filtro.getQuantidadePorPagina());
        query.setMaxResults(filtro.getQuantidadePorPagina());

        return new PageImpl<Curso>(query.getResultList());

    }
}
