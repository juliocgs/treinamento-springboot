package br.com.cast.treinamento.converter;

import br.com.cast.treinamento.model.CategoriaCurso;
import br.com.cast.treinamento.model.Curso;
import br.com.cast.treinamento.model.dto.CursoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CursoConverter {

    @Autowired
    private CategoriaCursoConverter categoriaCursoConverter;

    public List<CursoDTO> toListEntityToListDto(List<Curso> lista) {
        List<CursoDTO> retorno = new ArrayList<CursoDTO>();
        lista.forEach(item -> {
            retorno.add(this.toDto(item));
        });

        return retorno;
    }

    public Curso toEntity(CursoDTO dto){
        Curso entidade = new Curso();
        entidade.setId(dto.getId());
        entidade.setNome(dto.getNome());
        entidade.setDuracaoAnos(dto.getDuracaoAnos());
        entidade.setExcluido(dto.isExcluido());
        entidade.setHabitadoPCD(dto.isHabitadoPCD());
        entidade.setCategoria(categoriaCursoConverter.toEntity(dto.getCategoria()));

        return entidade;
    }

    public CursoDTO toDto(Curso entidade){
        CursoDTO dto = new CursoDTO();
        dto.setId(entidade.getId());
        dto.setNome(entidade.getNome());
        dto.setDuracaoAnos(entidade.getDuracaoAnos());
        dto.setExcluido(entidade.isExcluido());
        dto.setHabitadoPCD(entidade.isHabitadoPCD());
        dto.setCategoria(categoriaCursoConverter.toDto(entidade.getCategoria()));

        return dto;
    }
}
