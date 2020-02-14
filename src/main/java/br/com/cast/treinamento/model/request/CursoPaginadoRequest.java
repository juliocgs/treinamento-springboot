package br.com.cast.treinamento.model.request;

import java.io.Serializable;

public class CursoPaginadoRequest implements Serializable {
    private static final long serialVersionUID = -1755957098262031207L;

    private String nome;

    private Integer duracaoAnos;

    private Boolean habitadoPCD;

    private Boolean excluido;

    private Long CategoriaId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDuracaoAnos() {
        return duracaoAnos;
    }

    public void setDuracaoAnos(Integer duracaoAnos) {
        this.duracaoAnos = duracaoAnos;
    }

    public Boolean getHabitadoPCD() {
        return habitadoPCD;
    }

    public void setHabitadoPCD(Boolean habitadoPCD) {
        this.habitadoPCD = habitadoPCD;
    }

    public Boolean getExcluido() {
        return excluido;
    }

    public void setExcluido(Boolean excluido) {
        this.excluido = excluido;
    }

    public Long getCategoriaId() {
        return CategoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        CategoriaId = categoriaId;
    }
}
