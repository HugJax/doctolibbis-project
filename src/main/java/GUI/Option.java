/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Healthcare.*;
import java.awt.Color;
import java.awt.Dimension;


/**
 *
 * @author Kalmuns
 */
 // display personal data and aloow to change them
public class Option extends JPanel
{
  protected int id;
  protected JLabel numero;
  protected JLabel mail;
  protected JLabel nom;
  protected JLabel password;
  protected JButton num;
  protected JButton mai;
  protected JButton name;
  protected JButton pass;
  Input buffer;
  Option moi;
        Option(int iD)
        {
            this.setBackground(new Color(146,177,229));
            moi=this;
            id=iD;// changer initialisation des jlabel link to bdd
            numero=new JLabel("Numero:");
            mail=new JLabel("Mail:");
            nom=new JLabel("Nom");
            password=new JLabel("Password");
            num = new JButton("Edit");
            mai= new JButton("Edit");
            name= new JButton("Edit");
            pass= new JButton("Edit");
            num.setSize(100, 100);
            num.addActionListener(new Num());
            mai.addActionListener(new Mai());
            name.addActionListener(new Name());
            pass.addActionListener(new Pass());
            this.setLayout(new GridLayout(4,2,0,0));
            add(nom);
            add(name);
            add(mail);
            add(mai);
            add(numero);
            add(num);
            add(password);
            add(pass);
            this.setVisible(true);
            this.getLayout().preferredLayoutSize(name);
            this.validate();

        }
        private class Num implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
            buffer= new Input(moi,3);

         }
    }
          private class Mai implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
            buffer= new Input(moi,2);

         }
    }
            private class Name implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
          buffer= new Input(moi,1);
         }
    }
            private class Pass implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
           buffer= new Input(moi,4);

         }
    }
            public void name()
            {
                String texte=buffer.gettext();
           nom.setText("Name: "+texte);
           revalidate();
            }
            public void num()
            {
                String texte=buffer.gettext();
           numero.setText("Numero: "+texte);
           revalidate();
            }
            public void mail()
            {
                 String texte=buffer.gettext();
           mail.setText("Mail: "+texte);
           revalidate();
            }
            public void pass()
            {
             String texte=buffer.gettext();
           password.setText("Password: "+texte);
           revalidate();
            }
            void place()
            {

            }
             void prix()
             {

             }
             void mailpro()
             {

             }
             void numpro(){

             }




}
