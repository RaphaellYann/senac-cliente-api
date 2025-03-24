package br.com.senac.entidades;

import jakarta.persistence.*;
import java.time.LocalDate;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 6bd64ce04bb77739a24f6a95c5e2a0416a729968

@Entity
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String documento;

<<<<<<< HEAD
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
=======
    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 100)
>>>>>>> 6bd64ce04bb77739a24f6a95c5e2a0416a729968
    private String sobrenome;

    @Column(nullable = false)
    private String email;

<<<<<<< HEAD
    private int idade;

    private String sexo;

    private LocalDate dataNascimento;

    private int ddd;

    private int telefone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> enderecos;

    // Getters e setters

=======
    @Column
    private int idade;

    @Column
    private String sexo;

    @Column
    private LocalDate dataNascimento;

    @Column
    private int ddd;

    @Column
    private int telefone;

    // Getters and Setters
>>>>>>> 6bd64ce04bb77739a24f6a95c5e2a0416a729968
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
<<<<<<< HEAD

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
=======
>>>>>>> 6bd64ce04bb77739a24f6a95c5e2a0416a729968
}
