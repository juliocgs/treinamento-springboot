package br.com.cast.treinamento.model.dto;

import java.io.Serializable;

public class CursoDTO implements Serializable {
    private static final long serialVersionUID = 6135999033634436057L;

    private long id;

    private String nome;

    private int duracaoAnos;

    private boolean habitadoPCD;

    private boolean excluido;

    private CategoriaCursoDTO categoria;

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

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    public CategoriaCursoDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaCursoDTO categoria) {
        this.categoria = categoria;
    }
}
