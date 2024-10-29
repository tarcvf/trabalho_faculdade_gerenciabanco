package com.gerenciabanco;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
public class Main {
    

    
    public static void main(String[] args) throws Exception {
        db d = new db();
        JFrame frame =  new JFrame();
        JTabbedPane abas = new JTabbedPane();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        abas.setVisible(true);
        frame.add(abas);
        cadastro cadastro = new cadastro();
        login login = new login();
        deposito deposito = new deposito();
        saque saque = new saque();
        abas.add(login,"login");
        abas.add(cadastro,"cadastro");
        abas.add(deposito,"deposito");
        abas.add(saque,"saque");
        frame.setSize(420, 420);
    }
}
