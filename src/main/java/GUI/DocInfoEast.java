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
import javax.swing.*;

/**
 *
 * @author 931701723
 */
 // is  a part of doc info
public class DocInfoEast extends JPanel
{
        private int iddoc;
        private Wall wall;
        private JButton button;
        public DocInfoEast(Wall wa, int id)
        {
            this.setBackground(new Color(146,177,229));
            this.setVisible(true);
            wall=wa;
            iddoc=id;
            this.setLayout(new BorderLayout());
              button= new JButton("Book an Appoitment");
            button.setSize(25, 10);
            button.addActionListener(new AddRDVListener());
            add(button,BorderLayout.SOUTH);
            this.validate();
        }
                       private class AddRDVListener implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
            InputJMA q=  new  InputJMA(wall,iddoc);
         }

    }
}
