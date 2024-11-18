package negocio.usuario;

import java.math.BigDecimal;

public class Usuario extends Pessoa{
    private TipoUsuario tipoUsuario;

    public Usuario(String nome, String cpf) {
        super(nome, cpf);
        tipoUsuario = TipoUsuario.NORMAL;
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    public Usuario(String cpf) {
        super(cpf);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public BigDecimal getSaldo() {
        return super.getSaldo();
    }

    @Override
    public void setSaldo(BigDecimal saldo) {
        super.setSaldo(saldo);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
}
