package com.gerenciabanco;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class cadastro extends JPanel {
    
    public cadastro(){
        this.add(new JLabel("<html><h1>ainda não tem conta? cadastre-se!</h1></html>"));
        JButton botcad = new JButton("cadastrar usuário");
        botcad.addActionListener(n->cadUsuario());
        this.add(botcad);
    }
    @SuppressWarnings("deprecation")
    public usuario cadUsuario(){

        JFrame frame = new JFrame("cadastrar usuário");
        JTextField nome = new JTextField("",20);
        JTextField cpf = new JTextField("",20);
        JPasswordField senha = new JPasswordField("",20);
        JPasswordField confsenha = new JPasswordField("",20);
        JButton cadButton = new JButton("cadastrar");
        JPanel tab = new JPanel();
        Dimension d = new Dimension(400,25);
        cpf.setMaximumSize(d);
        nome.setMaximumSize(d);
        senha.setMaximumSize(d);
        confsenha.setMaximumSize(d);
        tab.setLayout(new BoxLayout(tab, BoxLayout.Y_AXIS));
     
        tab.add(new JLabel("<html><h1>cadastre-se</h1>nome completo<br></html>"));
        tab.add(nome);
        tab.add(new JLabel("<html>cpf<br></html>"));
        tab.add(cpf);
        tab.add(new JLabel("<html>senha<br></html>"));
        tab.add(senha);
        tab.add(new JLabel("<html>confirmar senha<br></html>"));
        tab.add(confsenha);
        tab.add(cadButton);



      frame.setVisible(true);
      frame.setSize(300,300);
      frame.setResizable(false);
      frame.add( tab);
      

        cadButton.addActionListener(n-> {
            String s1 = confsenha.getText();
            String s2 = senha.getText();
            System.out.println(s1+"\n"+s2);
            if(s1.equals(s2)){
                usuario us = new usuario();
                us.setCpf(cpf.getText());
                us.setNome(nome.getText());
                us.setSenha(String.valueOf(senha.getPassword()));
                us.cadastrarUsuário();
               

               

            }else{JOptionPane.showMessageDialog(this, "as senhas não condizem");}
        });

        return null;

    }

}
