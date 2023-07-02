/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author hecat
 */

 /// Accueil=> first page when you log
 // regroup display jpanel.
public class Accueil extends JPanel

{
    private Wall wall;
   Accueil(Wall wa)
    {
        this.setBackground(new Color(146,177,229));
        wall=wa;
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        add(new ImagePanel("C:\\Users\\hecat\\Documents\\Cours\\Programming\\Projet\\Healthcare\\src\\main\\java\\GUI\\arnold].jpg"),BorderLayout.CENTER);
        add(new ActuGrid(wall),BorderLayout.EAST);

        this.validate();
    }
}
