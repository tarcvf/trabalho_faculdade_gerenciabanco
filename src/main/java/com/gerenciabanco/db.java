package com.gerenciabanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db {
    private Connection con;

    // Construtor para inicializar a conexão
    public db() throws ClassNotFoundException {
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            con = DriverManager.getConnection("jdbc:sqlite:D:\\testdb.db");
            con.setAutoCommit(false); // Desativa o auto-commit
            criarTabela();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    // Método para criar a tabela se não existir
    private void criarTabela() {
        try (Statement statement = con.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS Usuarios ("
                       + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                       + "nome VARCHAR(100) NOT NULL, "
                       + "cpf CHAR(11) UNIQUE NOT NULL, "
                       + "senha VARCHAR(50) NOT NULL, "
                       + "saldo DECIMAL(10, 2) DEFAULT 0.00"
                       + ");";
            statement.executeUpdate(sql);
            con.commit(); // Faz o commit da criação da tabela
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            try {
                con.rollback(); // Reverte as alterações em caso de erro
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Método para realizar alterações no banco de dados
    public void alterar(String consulta) {
        try (Statement statement = con.createStatement()) {
            int rowCount = statement.executeUpdate(consulta);
            con.commit(); // Faz o commit da alteração
            System.out.printf("Sucesso, %d linhas afetadas\n", rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback(); // Reverte as alterações em caso de erro
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Método para consultar o banco de dados
    public ResultSet consultar(String consulta) {
        try {
            PreparedStatement stm = con.prepareStatement(consulta);
            return stm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para fechar a conexão
    public void fecharConexao() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
