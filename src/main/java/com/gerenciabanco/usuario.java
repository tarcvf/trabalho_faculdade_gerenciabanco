package com.gerenciabanco;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class usuario {
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }

    public float getSaldo() {
        try {
            recuperarSaldo();
            return saldo;
        } catch (Exception e) {
            return saldo;
        }
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public usuario logarUsuario(){
        return this;
    }
    public String nome;
    public String senha;
    public float saldo;
    public String cpf;
    public String getCpf() {
        return this.cpf;
    }
    public void setCpf(String string) {
        this.cpf = string;
    }

    public void setSenha(String password) {
     this.senha = password;
    }

public void cadastrarUsuário(){
    try {
        db bancoDb = new db();
        bancoDb.alterar("INSERT INTO Usuarios (nome, cpf, senha, saldo) VALUES ('"+this.getNome()+"', '"+this.getCpf()+"', '"+this.getSenha()+"', 10.00);\n" );
        JOptionPane.showMessageDialog(null, "usuário cadastrado com sucesso");
        bancoDb.fecharConexao();
    } catch (ClassNotFoundException e) {
        
        e.printStackTrace();
    }
    
}
 public void login(String cpfs, String senhas) {
        try {
            db bancoDb = new db();
            ResultSet rs = bancoDb.consultar("SELECT nome, senha, cpf, saldo \n" +
                                             "FROM Usuarios \n" +
                                             "WHERE cpf = '" + cpfs + "' AND senha = '" + senhas + "';");
            
            if (rs.next()) { // Verifica se há resultados
                this.setNome(rs.getString("nome"));
                this.setCpf(rs.getString("cpf"));
                this.setSenha(rs.getString("senha"));
                this.setSaldo(rs.getFloat("saldo"));                
                JOptionPane.showMessageDialog(null, "Usuário "+this.getNome()+" logado com sucesso!");
            
            } else {
                JOptionPane.showMessageDialog(null, "Nome ou senha incorretos");
            }
            bancoDb.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    

}
public void recuperarSaldo() { 
    try { 
        db bancoDb = new db();
         ResultSet rs = bancoDb.consultar("SELECT saldo FROM Usuarios WHERE cpf = '" + this.getCpf() + "';");

            System.out.println(rs.getFloat("saldo"));
            this.setSaldo(rs.getFloat("saldo"));  
             bancoDb.fecharConexao();
            }catch(Exception e){
                System.out.println(e.getLocalizedMessage());
            }
            }

public void depositar(float valor) {
    try {
        db bancoDb = new db();
        bancoDb.alterar("UPDATE Usuarios SET saldo = saldo + " + valor + " WHERE cpf = '" + this.getCpf() + "';");
        JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso");
        bancoDb.fecharConexao();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
public void sacar(float valor) {
    try {
        if (valor > this.getSaldo()) {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
            return;
        }

        db bancoDb = new db();
        bancoDb.alterar("UPDATE Usuarios SET saldo = saldo - " + valor + " WHERE cpf = '" + this.getCpf() + "';");
        JOptionPane.showMessageDialog(null, "Saque realizado com sucesso");
        bancoDb.fecharConexao();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}


}