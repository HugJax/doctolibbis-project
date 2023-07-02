/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import Healthcare.*;
import java.awt.Color;


/**
 *
 * @author Kalmuns
 */
 // Input for Option.
public class Input extends JFrame
{
    private JTextField text;
    private JButton validate;
    private Option option;
    private int prepross;
    private String texte="Value non initialize";
    Input(Option in, int pre)
    {
        this.setBackground(new Color(146,177,229));
        option=in;
        prepross=pre;
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        text= new JTextField (100);
        this.setVisible(true);
        setSize(200, 100);
      //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        add(text,BorderLayout.CENTER);
        validate= new JButton("OK");
        validate.addActionListener(new Validate());
        add(validate,BorderLayout.SOUTH);
    }
      private class Validate implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
             texte=text.getText();
             if (texte.isBlank())
             {
                 ErrorInput q= new ErrorInput();
             }
             else
             {
             if ( prepross==1)
             {
                 option.name();
             }
             if ( prepross==3)
             {
                 if(isdigit(text))
                 {
                 option.num();
                 }
                 else
                 {
                      ErrorInput q= new ErrorInput();
                 }

             }
             if ( prepross==2)
             {
                 option.mail();
             }

             if ( prepross==4)
             {
                 option.pass();
             }
             if ( prepross==5)
             {
                 option.place();
             }
             if ( prepross==6)
             {
                    if(isdigit(text))
                 {
                 option.numpro();
                 }
                 else
                 {
                      ErrorInput q= new ErrorInput();
                 }
             }
             if ( prepross==7)
             {
                 option.mailpro();
             }
             if ( prepross==8)
             {
                    if(isdigit(text))
                 {
                 option.prix();
                 }
                 else
                 {
                      ErrorInput q= new ErrorInput();
                 }
             }
             }
//            setEnabled(false);
//            setVisible(false);
//            setAlwaysOnTop(false);
              dispose();
         }
    }
        public String gettext()
               {
                   return texte;
               }
      protected boolean isdigit(JTextField s)
  {
      boolean verif=true;
      String a=s.getText();
      for(int i=0;i<a.length();i++)
      {
          if(!Character.isDigit(a.charAt(i)))
          {
              verif=false;
          }

          }
      return verif;
  }
}
