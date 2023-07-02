/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author 931701723
 */
 // display error jframe when called.
public class ErrorInput extends JFrame
{
    private JLabel error;
    private JButton ok;
    ErrorInput()
    {
        this.setBackground(new Color(146,177,229));
        this.setSize(200,75);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.setTitle("ERROR");
        error= new JLabel ("Your Input is not Valid please try again");

        ok =new JButton (" Understood");
        this.setLayout(new BorderLayout());
        add(error,BorderLayout.NORTH);
        add(ok,BorderLayout.SOUTH);
         ok.addActionListener(new Under());
         this.validate();
    }
     private class Under implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
         dispose(); //Add changement dans bdd

         }
    }
}
