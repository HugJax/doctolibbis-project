/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Healthcare.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/**
 *
 * @author 931701723
 */
public class Register extends JFrame
{
  protected JTextField num;
  protected JTextField mai;
  protected JTextField n;
  protected JTextField pass;
  protected JLabel numero;
  protected JLabel mail;
  protected JLabel nom;
  protected JLabel password;
  protected JButton ok;
  protected Person pers=new Person();
  
  Register()
  {
            this.setSize(300, 600);
            this.setTitle("Register");
            numero=new JLabel("Number:");
            mail=new JLabel("Mail:");
            nom=new JLabel("Name");
            password=new JLabel("Password");
            num=new JTextField(10);
            mai=new JTextField(20);
            n=new JTextField(20);
            pass=new JTextField(15);
            this.setLayout(new GridLayout(5,2,0,0));
            add(nom);
            add(n);
            add(num);
            add(mail);
            add(mai);
            add(numero);
            add(num);
            add(password);
            add(pass);
            ok=new JButton("OK");
            ok.addActionListener(new RegisterListenner());
            add(ok);
            this.setVisible(true);
            validate();
  }
  
  private class RegisterListenner implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
             if(nullcheck(num)||nullcheck(mai)||nullcheck(n)||nullcheck(pass)||isnotdigit(num))
             {
              ErrorInput r=   new ErrorInput();
             }
            else
             {
             String str=n.getText();
             
             String[] splited= str.split("\\s+");
             
             if(Pattern.compile("\\s").matcher(n.getText()).find()==false)
             {
                  pers.setfname("Lord ");
             pers.setlname(n.getText());
             }
             else
             {
                 pers.setfname(splited[0]);
             pers.setlname(splited[1]);
             }
             pers.setmail(mai.getText());
             pers.settel(Integer.parseInt(num.getText()));
             pers.setmdp(pass.getText());
             pers.setID(pers.gettel());
             //new addMySQL().setPerson(pers);
             new addMySQL().addPerson(pers);
             }
         }        
    }
  protected boolean nullcheck(JTextField a)  
  {
      
      return a.getText().isBlank();
  }
  protected boolean isnotdigit(JTextField s)
  {
      boolean verif=false;
      String a=s.getText();
      for(int i=0;i<a.length();i++)
      {
          if(!Character.isDigit(a.charAt(i)))
          {
              verif=true;
          }
         
          }
      return verif;
  }
      
     
}
  
  

