package br.com.fiap.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_BEM", uniqueConstraints = { @UniqueConstraint(name = "UK_BEM", columnNames = "ETIQUETA_BEM")})
public class Bem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SQ_BEM")
    @Column(name = "ID_BEM")
    private Long id;

    @Column(name = "NOME_BEM", nullable = false)
    private String nome;

    @ManyToOne(fetch =FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "ID_TDB",referencedColumnName = "ID_TDB",foreignKey = @ForeignKey(name = "FK_BEM_TDB"))
    private TipoDeBem tipo;

    @Column(name = "ETIQUETA_BEM", nullable = false)
    private String etiqueta;

    @ManyToOne(fetch =FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "ID_DPT",referencedColumnName = "ID_DPT",foreignKey = @ForeignKey(name = "FK_BEM_DPT"))
    private Departamento localizacao;

    @Column(name = "AQUISICAO_BEM")
    private LocalDate aquisicao;


    public Bem() {
    }

    public Bem(Long id, String nome, TipoDeBem tipo, String etiqueta, Departamento localizacao, LocalDate aquisicao) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.etiqueta = etiqueta;
        this.localizacao = localizacao;
        this.aquisicao = aquisicao;
    }

    public Long getId() {
        return id;
    }

    public Bem setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Bem setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public TipoDeBem getTipo() {
        return tipo;
    }

    public Bem setTipo(TipoDeBem tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public Bem setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
        return this;
    }

    public Departamento getLocalizacao() {
        return localizacao;
    }

    public Bem setLocalizacao(Departamento localizacao) {
        this.localizacao = localizacao;
        return this;
    }

    public LocalDate getAquisicao() {
        return aquisicao;
    }

    public Bem setAquisicao(LocalDate aquisicao) {
        this.aquisicao = aquisicao;
        return this;
    }

    @Override
    public String toString() {
        return "Bem{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", etiqueta='" + etiqueta + '\'' +
                ", localizacao=" + localizacao +
                ", aquisicao=" + aquisicao +
                '}';
    }
}
