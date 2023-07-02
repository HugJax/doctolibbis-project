/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Healthcare.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 931701723
 */
 // add doc in bdd
public class RegisterDoc extends Register
{
            protected JTextField numpro;
            protected JTextField maipro;
            protected JTextField pla;
            protected JTextField price;
            protected JTextField form;
            protected JTextField exp;
            protected JTextField specia;
            protected JLabel numeropro;
            protected JLabel mailpro;
            protected JLabel specialisation;
            protected JLabel place;
            protected JLabel prix;
            protected JLabel formation;
            protected JLabel experience;
            protected Doc doc=new Doc();



    RegisterDoc()
    {

        super();
            this.remove(ok);
        this.setLayout(new GridLayout(12,2,0,0));
            this.setTitle("Register");
            numeropro=new JLabel("Professional number:");
            mailpro=new JLabel("Professional e-mail:");
            place=new JLabel("Location: ");
            prix=new JLabel("Price: ");
            experience= new JLabel("Experience: ");
            formation= new JLabel("Formation: ");
            specialisation=new JLabel("Specialize: ");
            numpro=new JTextField(10);
            specia= new JTextField(10);
            maipro=new JTextField(20);
            pla=new JTextField(20);
            price=new JTextField(15);
            exp= new JTextField(20);
            form = new JTextField(20);
            add(numeropro);
            add(numpro);
            add(mailpro);
            add(maipro);
            add(place);
            add(pla);
            add(prix);
            add(price);
            add(formation);
            add(form);
            add(experience);
            add(exp);
            add(specialisation);
            add(specia);
            ActionListener[] buff;
            buff=ok.getActionListeners();
            ok.removeActionListener(buff[0]);
            ok.addActionListener(new RegisterDocListener());
            add(ok);

            revalidate();
    }
     private class RegisterDocListener implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {

             if(nullcheck(numpro)||nullcheck(maipro)||nullcheck(pla)||nullcheck(price)||nullcheck(form)||nullcheck(exp)||isnotdigit(price)||isnotdigit(numpro))
             {
              ErrorInput r=new ErrorInput();
             }
             else
             {
             String str=n.getText();
             String[] splited=str.split("\\s+");
             doc.setfname(splited[0]);
             doc.setlname(splited[1]);
             doc.setmail(mai.getText());
             doc.settel(Integer.parseInt(num.getText()));
             doc.setmdp(pass.getText());
             doc.setID(Integer.parseInt(num.getText()));
             doc.setplace(pla.getText());
             doc.setpmail(maipro.getText());
             doc.setprix(Integer.parseInt(price.getText()));
             doc.setptel(Integer.parseInt(numpro.getText()));
             doc.setIDdoc(Integer.parseInt(numpro.getText()));
             doc.setexp(exp.getText());
             doc.setspe(specia.getText());
             doc.setformation(form.getText());
             new addMySQL().addDoctor(doc);
             }
         }
     }
}
