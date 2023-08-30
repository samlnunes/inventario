package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_TIPO_BEM", uniqueConstraints = { @UniqueConstraint(name = "UK_TDB", columnNames = "NOME_TDB")})
public class TipoDeBem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TDB")
    @Column(name = "ID_TDB")
    private Long id;

    @Column(name = "NOME_TDB", nullable = false)
    private String nome;

    public TipoDeBem() {
    }

    public TipoDeBem(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public TipoDeBem setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoDeBem setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return "TipoDeBem{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
