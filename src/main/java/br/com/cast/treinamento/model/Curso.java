package br.com.cast.treinamento.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_curso", schema = "treinamento")
public class Curso implements Serializable {
    private static final long serialVersionUID = -3481731965679349901L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DURACAO_ANOS")
    private int duracaoAnos;

    @Column(name = "HABILITADO_PCD", columnDefinition = "TINYINT(1)")
    private boolean habitadoPCD;

    @Column(name = "EXCLUIDO", columnDefinition = "TINYINT(1)")
    private boolean excluido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORIA_ID")
    private CategoriaCurso categoria;

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

    public CategoriaCurso getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaCurso categoria) {
        this.categoria = categoria;
    }
}
