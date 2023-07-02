/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Kalmuns
 */

 // Same as menu but with 2 more option onnly for doc .
public class MenuDoc extends Menu
{
    private JButton menudoc;
    MenuDoc(Wall wa)
    {
        super(wa);
        JButton menudoc= new JButton("Doctor Option");
        menudoc.addActionListener(new MenuDocListener());
        add(menudoc);
        revalidate();


    }
    private class MenuDocListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            wall.actual(new OptionDoc(wall.getID()));// 60 doit être remplacé par id utilisateur
        }

    }
}
