/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JLabel;
import Healthcare.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Kalmuns
 */
 // same as option but for doc information available only for doc
public class OptionDoc extends Option
{
    Doc temp;
    OptionDoc(int ids)
    {
        super(ids);
        System.out.println(ids);
        temp=new retrieveMySQL().retrieveDocfromperson(ids);
            numero.setText("Professional number: "+temp.getptel());
            mail.setText("Professional Mail: "+temp.getpmail());
            nom.setText("Location: "+temp.getplace());
            password.setText("Price: "+temp.getprix()+"£ per hour");
            num.setSize(100, 100);
            ActionListener[] test;
            test=num.getActionListeners();
            num.removeActionListener(test[0]);
            test=mai.getActionListeners();
            mai.removeActionListener(test[0]);
            test=name.getActionListeners();
            name.removeActionListener(test[0]);
            test=pass.getActionListeners();
            pass.removeActionListener(test[0]);
            num.addActionListener(new NumPro());
            mai.addActionListener(new Mai());
            name.addActionListener(new Place());
            pass.addActionListener(new Prix());
    }

    private class Place implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
          buffer= new Input(moi,5); //Add changement dans bdd
         }
    }
            private class Prix implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
            buffer= new Input(moi,8); //Add changement dans bdd

         }
    }
            private class NumPro implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
            buffer= new Input(moi,6); //Add changement dans bdd

         }
    }
          private class Mai implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
           buffer= new Input(moi,7); //Add changement dans bdd

         }
    }

    public void place()
    {

        String texte=buffer.gettext();
           nom.setText(texte);
           temp.setplace(nom.getText());
           new changeMySQL().updateDoc(temp);
           revalidate();
    }
            public void prix()
         {

           String texte=buffer.gettext();
           password.setText(texte);
           temp.setprix( Integer.parseInt(password.getText()));
           new changeMySQL().updateDoc(temp);
           revalidate();
         }

      public void numpro()
      {

           String texte=buffer.gettext();
           numero.setText(texte);
           temp.setptel(Integer.parseInt(numero.getText()));
           new changeMySQL().updateDoc(temp);
           revalidate();

         }

        public void mailpro()
         {

           String texte=buffer.gettext();
           mail.setText(texte);
           temp.setpmail(mail.getText());
           new changeMySQL().updateDoc(temp);
           revalidate();
         }


}
