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
import javax.swing.JPanel;

/**
 *
 * @author hecat
 */
 // is here for loogout button
public class OptionEast extends JPanel
{
    private Wall wall;
    private JButton login;
    OptionEast(Wall wa)
    {
        this.setBackground(new Color(146,177,229));
        wall=wa;
        this.setVisible(true);
        login= new JButton("LogOut");
        login.addActionListener(new LogoutListener());
        this.setLayout(new BorderLayout());
        add(login,BorderLayout.SOUTH);
    }
    private class LogoutListener implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
             wall.removeAll();
          wall.actual(new Logpage(wall,wall.getlog()));
         }
    }
}
