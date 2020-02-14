package br.com.cast.treinamento.model.request;

import br.com.cast.treinamento.model.dto.CategoriaCursoDTO;
import br.com.cast.treinamento.model.dto.CursoDTO;

import java.io.Serializable;

public class CursoRequest implements Serializable {
    private static final long serialVersionUID = -1755957098262031207L;

    private long id;

    private String nome;

    private int duracaoAnos;

    private boolean habitadoPCD;

    private long CategoriaId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoAnos() {
        return duracaoAnos;
    }

    public void setDuracaoAnos(int duracaoAnos) {
        this.duracaoAnos = duracaoAnos;
    }

    public boolean isHabitadoPCD() {
        return habitadoPCD;
    }

    public void setHabitadoPCD(boolean habitadoPCD) {
        this.habitadoPCD = habitadoPCD;
    }

    public long getCategoriaId() {
        return CategoriaId;
    }

    public void setCategoriaId(long categoriaId) {
        CategoriaId = categoriaId;
    }

    public CursoDTO toDto(){
        CursoDTO dto = new CursoDTO();
        dto.setId(getId());
        dto.setNome(getNome());
        dto.setDuracaoAnos(getDuracaoAnos());
        dto.setHabitadoPCD(isHabitadoPCD());
        dto.setCategoria(new CategoriaCursoDTO());
        dto.getCategoria().setId(getCategoriaId());

        return dto;
    }
}
