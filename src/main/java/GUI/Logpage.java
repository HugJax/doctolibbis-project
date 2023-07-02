/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
//import guiv0.pkg1.Wall;

import java.awt.Component;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import Healthcare.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kalmuns
 */
 // log page display and check.
public class Logpage extends JPanel {

    private JTextField user;
    private JPasswordField pass;
    private JLabel use;
    private JLabel pas;
    private JButton login;
    private int[] idpers;
    private Wall wa;
    private Person machin = new Person();
    private retrieveMySQL yolo = new retrieveMySQL();
    private int[] bufferlogin;
    private int[] remembertest;
    private JButton register;
    private JButton registerdoc;

    public Logpage(Wall a, int[] log) {
//    bufferlogin=log;
//    bufferlogin[0]=5;
        wa = a;
        this.setBackground(new Color(146,177,229));
        use = new JLabel("Username");
        pas = new JLabel("Password");
        user = new JTextField(10);
        pass = new JPasswordField(10);
        register=new JButton("Register");
        registerdoc=new JButton("Register as adoc");
        register.addActionListener(new RegisterDocListener());
        registerdoc.addActionListener(new RegisterListener());
        login = new JButton("Login");
        getuserpass();
        idpers = log;
        remembertest = new int[1];
        remembertest[0] = 2;
        System.out.println("test remember "+remembertest[0]);
        add(new RememberPass(remembertest));
        machin = yolo.retrievePerson(user.getText());
        // machin.getID()
//    if(machin.getmdp()==pass.getText())
//    {
//        //et là on peut se connecter
//    }

        //add(new ImagePanel("C:\\Users\\hecat\\Documents\\Cours\\Programming\\Projet\\Healthcare\\src\\main\\java\\GUI\\login.png"));
        //login.addActionListener()
        //this.setLayout(new BoxLayout());
        add(use);
        add(user);
        add(pas);
        add(pass);
        add(login);
        add(register);
        add(registerdoc);
         add(new ImagePanel("C:\\Users\\hecat\\Documents\\Cours\\Programming\\Projet\\Healthcare\\src\\main\\java\\GUI\\login.png"));
        // this.getClass().getResource("C:\\Users\\931701723\\Documents\\NetBeansProjects\\Guiv0.1\\src\\guiv0\\pkg1");

        String usertest = user.getText();
        System.out.println(usertest);

        login.addActionListener(new Login());
        //add(new ImagePanel("D://Kalmuns//Programmation//Guiv0.1//src//guiv0//pkg1/arnold].jpg"));

        setVisible(true);
        this.validate();

    }

    private class Login implements ActionListener {

        public void actionPerformed(ActionEvent e) {
//       machin=yolo.retrievePerson(user.getText());// q tester sur pc bdd;
//
//     bufferlogin[0]=   machin.getID();
            //       if(pass.getText().equals(new retrieveMySQL().retrievePerson(user.getText()).getmdp()))
            //   {
//        //et là on peut se connecter
            // idpers[0]=Integer.parseInt(user.getText());
            System.out.println("test remember "+remembertest[0]);
            if (remembertest[0] == 1) {
                rememberMe(user.getText(), String.valueOf(pass.getPassword()) );
            }
            System.out.println("RETURN id logpage" + idpers[0]);
            idpers[0] = new retrieveMySQL().retrievePerson(user.getText()).getID();
            System.out.println("RETURN id logpage" + idpers[0]);
            if (yolo.isDoc(yolo.retrievePerson(user.getText()).getID()) == true) {
                System.out.println("doc here log");
                wa.setmenudoc();
                wa.actual(new Accueil(wa));
            } else {
                wa.setmenu();
                wa.actual(new Accueil(wa));

            }
            //}
        }
    }
    private class RegisterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

       Register q=      new RegisterDoc();
        }
    }
        private class RegisterDocListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
         Register q=      new Register();
        }
    }

    private void rememberMe(String user, String pass) {
        String sql = "UPDATE checkbox SET user= '" + user + "', password= '" + pass + "'";
        System.out.println("check si on est dedans");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(sql)) {

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
    }

    private void getuserpass() {
        String query = "SELECT * FROM checkbox";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                if (rs.getString(2) != null) {
                    user.setText(rs.getString(2));
                }
                if (rs.getString(3) != null) {
                    pass.setText(rs.getString(3));
                }
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

}
