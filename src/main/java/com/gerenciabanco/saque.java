package com.gerenciabanco;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JOptionPane;
public class saque extends JPanel {
  @SuppressWarnings({ "unlikely-arg-type", "deprecation" })
  public saque(){
    JTextField valor = new JTextField("",20);
    JPasswordField senha = new JPasswordField("",20);
    JLabel mensagem = new JLabel("<html><h1>Olá, qual valor deseja sacar?</h1><br/>alor a sacar:</html>");
    JButton submitButton = new JButton("sacar");
    Dimension d = new Dimension(400,25);
    JButton versaldo = new JButton("ver saldo");
    versaldo.addActionListener(lambda ->{
      JOptionPane.showMessageDialog(this, "seu saldo e:"+login.usuarioLogado.getSaldo());
    });
    senha.setMaximumSize(d);
    valor.setMaximumSize(d);
    this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    this.add(mensagem);
    this.add(valor);
    this.add(new JLabel("digite sua senha"));
    this.add(senha);
    this.add(submitButton);
    this.add( versaldo);
    submitButton.addActionListener(lambda ->{
      if(senha.getText().equals(login.usuarioLogado.getSenha())){
          login.usuarioLogado.sacar(Float.parseFloat(valor.getText()));
      }else{
        System.out.println(senha.getPassword().equals(login.usuarioLogado.getSenha()));
        System.out.println(login.usuarioLogado.getSenha());
      }
  });

    }
}
