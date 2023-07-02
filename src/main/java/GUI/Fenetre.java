/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import guiv0.pkg1.Menu;
//import guiv0.pkg1.Wall;
import javax.swing.*;
import Healthcare.*;
import java.awt.Color;


/**
 *
 * @author Kalmuns
 */
 /// Contains all main Jpanel.
public class Fenetre extends JFrame
{

        private Wall wall;
        private Menu menu;
        public Fenetre()
        {
            this.setBackground(new Color(146,177,229));
            setTitle("Doctolib");
            setSize(1080, 720);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            wall= new Wall();

          // menu= new Menu(wall);
            add(wall);

            this.validate();

        }
}
