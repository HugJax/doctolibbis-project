/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;
import Healthcare.*;
import java.awt.Color;

/**
 *
 * @author Kalmuns
 */
 // regroup grid an search
public class Doctors extends JPanel
{
    private JTextField searchfield;
    private JButton search;
    private Wall wall;

    Doctors(Wall wa)
    {
        this.setBackground(new Color(146,177,229));
        wall=wa;
        searchfield= new JTextField(30);
        this.setLayout(new BorderLayout());
       // add(searchfield,BorderLayout.NORTH);
        search= new JButton("Search");

        search.addActionListener(new Search());
        //add(search,BorderLayout.EAST);
        add(new InitSearchField(searchfield,search),BorderLayout.NORTH);

        this.validate();
        setVisible(true);

    }
     private class Search implements ActionListener
    {
      public void actionPerformed(ActionEvent e)
      {
          System.out.println("search event");
          add(new DoctorGrid(wall,searchfield.getText()),BorderLayout.CENTER);
          //add(new DoctorGridButton(wall,searchfield.getText()),BorderLayout.EAST);
          revalidate();
      }

    }
     private class InitSearchField extends JPanel
     {
           private JTextField searchfield;
           private JButton search;
           InitSearchField(JTextField bufferfield, JButton bufferbutton)
           {
               this.setBackground(new Color(146,177,229));
               search=bufferbutton;
               searchfield=bufferfield;
               add(searchfield);
               add(search);
           }
     }
}


