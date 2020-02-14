package br.com.cast.treinamento.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_log", schema = "treinamento")
public class Log implements Serializable {
    private static final long serialVersionUID = 3715173504492223707L;

    public final static String INSERIR = "INSERIR";
    public final static String ALTERAR = "ALTERAR";
    public final static String EXCLUIR = "EXCLUIR";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURSO_ID")
    private Curso curso;

    @JoinColumn(name = "ACAO")
    private String acao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Log() {
    }

    public Log(String usuario, Date data, Curso curso, String acao) {
        this.usuario = usuario;
        this.data = data;
        this.curso = curso;
        this.acao = acao;
    }
}
