package br.com.cast.treinamento.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.cast.treinamento.model.CategoriaCurso;
import br.com.cast.treinamento.model.dto.CategoriaCursoDTO;

@Component
public class CategoriaCursoConverter {


    public List<CategoriaCursoDTO> toEntityToDto(List<CategoriaCurso> lista) {
        List<CategoriaCursoDTO> listaRetorno = new ArrayList<CategoriaCursoDTO>();
        lista.forEach(item -> {
            listaRetorno.add(this.toDto(item));
        });

        return listaRetorno;
    }

    public CategoriaCurso toEntity(CategoriaCursoDTO dto) {
    	CategoriaCurso entidade = new CategoriaCurso();
    	entidade.setId(dto.getId());
    	entidade.setDescricao(dto.getDescricao());

    	return entidade;
    }

	public CategoriaCursoDTO toDto(CategoriaCurso entidade) {
		CategoriaCursoDTO dto = new CategoriaCursoDTO();
		dto.setId(entidade.getId());
		dto.setDescricao(entidade.getDescricao());

		return dto;
	}
}
