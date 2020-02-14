package br.com.cast.treinamento.service;

import br.com.cast.treinamento.converter.CursoConverter;
import br.com.cast.treinamento.exceptions.BusinessException;
import br.com.cast.treinamento.exceptions.NotFoundException;
import br.com.cast.treinamento.model.Curso;
import br.com.cast.treinamento.model.Log;
import br.com.cast.treinamento.model.dto.CursoDTO;
import br.com.cast.treinamento.model.dto.PaginacaoDTO;
import br.com.cast.treinamento.model.request.CursoPaginadoRequest;
import br.com.cast.treinamento.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoConverter converter;

    @Autowired
    private CursoRepository repository;

    @Autowired
    private LogService logService;

    public List<CursoDTO> consultarTodos() {
        List<Curso> lista = repository.findAll();

        if (lista.isEmpty()) {
            throw new NotFoundException("Nenhum registro encontrado!");
        }

        return converter.toListEntityToListDto(lista);
    }

    public Page<CursoDTO> consultarPaginado(PaginacaoDTO<CursoPaginadoRequest> filtro) {
        Page<Curso> lista = repository.consultarPorFiltro(filtro);

        if (!lista.hasContent()) {
            throw new NotFoundException("Nenhum registro encontrado!");
        }

        return new PageImpl<CursoDTO>(converter.toListEntityToListDto(lista.getContent()));
    }

    public void inserir(CursoDTO curso) {
        if (repository.existsCursoByNomeByCategory(curso.getNome(), curso.getCategoria().getId())) {
            throw new BusinessException("Curso já cadastrado!");
        }

        validarDuracaoCurso(curso.getDuracaoAnos());

        Curso entidade = converter.toEntity(curso);
        entidade.setExcluido(false);

        entidade = repository.save(entidade);
        logService.log(entidade, SecurityContextHolder.getContext().getAuthentication().getName(), Log.INSERIR);
    }

    public void alterar(CursoDTO curso) {
        if (!repository.existsById(curso.getId())) {
            throw new NotFoundException("Curso não existe!");
        }

        if (repository.existsCursoByNomeAndByCategoryExceptId(curso.getNome(), curso.getCategoria().getId(), curso.getId())) {
            throw new BusinessException("Curso já cadastrado!");
        }

        validarDuracaoCurso(curso.getDuracaoAnos());

        Curso entidade = converter.toEntity(curso);
        entidade.setExcluido(false);

        repository.save(entidade);
        logService.log(entidade, SecurityContextHolder.getContext().getAuthentication().getName(), Log.ALTERAR);
    }

    public void excluir(long id) {
        Optional<Curso> curso = repository.findById(id);

        if (!curso.isPresent()) {
            throw new NotFoundException("Curso não existe!");
        }

        curso.get().setExcluido(true);
        repository.save(curso.get());
        logService.log(curso.get(), SecurityContextHolder.getContext().getAuthentication().getName(), Log.EXCLUIR);
    }

    private void validarDuracaoCurso(int duracao) {
        if (duracao > 4) {
            throw new BusinessException("Curso não pode ter duração superior a 4 anos!");
        }
    }
}
