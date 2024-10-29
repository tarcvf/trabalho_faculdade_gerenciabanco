package com.gerenciabanco;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Dimension;

public class deposito extends JPanel {

    @SuppressWarnings({ "unlikely-arg-type", "deprecation" })
    public deposito(){
    JTextField valor = new JTextField("",20);
    JPasswordField senha = new JPasswordField("",20);
    JLabel mensagem = new JLabel("<html><h1>Olá, qual valor deseja depositar?</h1><br/>alor a depositar:</html>");
    JButton submitButton = new JButton("depositar");
    Dimension d = new Dimension(400,25);
    senha.setMaximumSize(d);
    valor.setMaximumSize(d);
    this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    this.add(mensagem);
    this.add(valor);
    this.add(new JLabel("digite sua senha"));
    this.add(senha);
    this.add(submitButton);
    submitButton.addActionListener(lambda ->{
        if(senha.getText().equals(login.usuarioLogado.getSenha())){
            login.usuarioLogado.depositar(Float.parseFloat(valor.getText()));
        }else{
            System.out.println(senha.getPassword().equals(login.usuarioLogado.getSenha()));
            System.out.println(login.usuarioLogado.getSenha());
        }
    });

    }
}
