package br.com.cast.treinamento.service;

import java.util.List;

import br.com.cast.treinamento.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.treinamento.converter.CategoriaCursoConverter;
import br.com.cast.treinamento.exceptions.NotFoundException;
import br.com.cast.treinamento.model.CategoriaCurso;
import br.com.cast.treinamento.model.dto.CategoriaCursoDTO;
import br.com.cast.treinamento.repository.CategoriaCursoRepository;

@Service
public class CategoriaCursoService {

    @Autowired
    private CategoriaCursoConverter converter;

    @Autowired
    private CategoriaCursoRepository repository;

    public List<CategoriaCursoDTO> consultarTodos() {
        List<CategoriaCurso> lista = repository.findAll();
        if (lista.isEmpty()) {
            throw new NotFoundException("Nenhum registro retornado!");
        }

        return converter.toEntityToDto(lista);
    }

    public void inserir(CategoriaCursoDTO categoriaCurso) {
        if (repository.existsCategoriaCursoByDescricao(categoriaCurso.getDescricao())) {
            throw new BusinessException("Categoria do curso já cadastrada!");
        }

        repository.save(converter.toEntity(categoriaCurso));
    }

    public void alterar(CategoriaCursoDTO categoriaCurso) {
        if (!repository.existsById(categoriaCurso.getId())) {
            throw new NotFoundException("Categoria do curso não existe!");
        }

        if (repository.existsCategoriaCursoByDescricaoExceptId(categoriaCurso.getDescricao(), categoriaCurso.getId())) {
            throw new BusinessException("Categoria do curso já cadastrada!");
        }

        repository.save(converter.toEntity(categoriaCurso));
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Categoria do curso não existe!");
        }

        repository.deleteById(id);
    }

}
