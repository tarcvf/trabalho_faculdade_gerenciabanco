package com.gerenciabanco;
import java.awt.Dimension;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JPanel {
    public static usuario usuarioLogado = new usuario();

    public login(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JLabel("<html><h1>ja e cadastrado? entre!<br/></h1></html>"));
        JButton botcad = new JButton("entrar");

        botcad.addActionListener(n->cadUsuario());
        
        this.add(botcad);

    }
    @SuppressWarnings("deprecation")
    public usuario cadUsuario(){

        JFrame frame = new JFrame("entrar");
        JTextField cpf = new JTextField("",20);
        JPasswordField senha = new JPasswordField("",20);
        JButton cadButton = new JButton("login");
        JPanel tab = new JPanel();
        Dimension d = new Dimension(400,25);
        cpf.setMaximumSize(d);
        senha.setMaximumSize(d);
        tab.setLayout(new BoxLayout(tab, BoxLayout.Y_AXIS));
     
        tab.add(new JLabel("<html><h1>entre com seu cpf e senha</h1><br/>cpf<br></html>"));
        tab.add(cpf);
        tab.add(new JLabel("<html>senha<br></html>"));
        tab.add(senha);
        tab.add(cadButton);



      frame.setVisible(true);
      frame.setSize(300,300);
      frame.setResizable(false);
      frame.add( tab);
      

        cadButton.addActionListener(n-> {
            usuarioLogado.login(cpf.getText(), senha.getText());
            

        });

        return null;

    }

}
