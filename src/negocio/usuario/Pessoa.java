package negocio.usuario;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Pessoa {
    private String nome;
    private final String cpf;
    private BigDecimal saldo;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        saldo = new BigDecimal(0);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Usuario) o;
        return Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public String toString() {
        return nome+" - "+cpf+"\nSALDO: "+saldo;
    }
}
