/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Healthcare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hecat
 */
public class showMySQL {
    
    
void showPerson()
{
    String query = "SELECT * FROM Person";
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {

            System.out.print(rs.getInt(1)); // IDperson
            System.out.print(": ");
            System.out.print(rs.getString(2)); // First name
            System.out.print(" ");
            System.out.print(rs.getString(3)); // Last name
            System.out.print(" - ");
            System.out.print(rs.getString(4)); // e-mail adress
            System.out.print(" - ");
            System.out.print(rs.getInt(5)); // telephone number
            System.out.print(" : ");
            System.out.println(rs.getString(6)); // password
        }



    } catch (SQLException ex) {

        Logger lgr = Logger.getLogger(start.class.getName());
        lgr.log(Level.SEVERE, ex.getMessage(), ex);
    } 
}

void showDoctor()
{
    String query = "SELECT * FROM doctor";
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {

            System.out.print(rs.getInt(1)); // IDdoctor
            System.out.print("/");
            System.out.println(rs.getInt(2)); // IDperson
            System.out.print(" - Specialisation= ");
            System.out.println(rs.getString(3)); // Specialisation
            System.out.print(" - Place= ");
            System.out.println(rs.getString(4)); // Place to practice
            System.out.print(" - Price= ");
            System.out.println(rs.getString(5)); // Price for an hour
            System.out.print(" - e-mail pro= ");
            System.out.println(rs.getString(6)); // e-mail adress professionnal
            System.out.print(" - tel pro= ");
            System.out.println(rs.getInt(7)); // telephone number professionnal
            System.out.print(" - Formation= ");
            System.out.println(rs.getString(6)); // formation
            System.out.print(" - Experience= ");
            System.out.println(rs.getString(7)); // experience
        }



    } catch (SQLException ex) {

        Logger lgr = Logger.getLogger(start.class.getName());
        lgr.log(Level.SEVERE, ex.getMessage(), ex);
    } 
}
    
void showFile()
{
    String query = "SELECT * FROM file";
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {

            System.out.print(rs.getInt(1)); // IDfile
            System.out.print("/");
            System.out.println(rs.getInt(2)); // IDperson
            System.out.print(" - Age= ");
            System.out.println(rs.getInt(3)); // Age
            System.out.print(" - Weight= ");
            System.out.println(rs.getDouble(4)); // Weight
            System.out.print(" - Size= ");
            System.out.println(rs.getDouble(5)); // Size
            System.out.print(" - Blood group= ");
            System.out.println(rs.getString(6)); // blood group
            System.out.print(" - Description= ");
            System.out.println(rs.getString(7)); // description
        }



    } catch (SQLException ex) {

        Logger lgr = Logger.getLogger(start.class.getName());
        lgr.log(Level.SEVERE, ex.getMessage(), ex);
    } 
}
    
void showRDV()
{
    String query = "SELECT * FROM rdv";
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {

            System.out.print(rs.getInt(1)); // IDrdv
            System.out.print("/");
            System.out.print(rs.getInt(2)); // IDdoctor
            System.out.print("/");
            System.out.println(rs.getInt(3)); // IDperson
            System.out.print(" - Motive= ");
            System.out.println(rs.getString(4)); // Motivation of the meeting
            System.out.print(" - Time= ");
            System.out.println(rs.getInt(5)); // Time of meeting
            System.out.print(" - Date= ");
            System.out.println(rs.getInt(6)); // Date of meeting
            System.out.print(" - Place= ");
            System.out.println(rs.getString(7)); // Where it is happenning
        }



    } catch (SQLException ex) {

        Logger lgr = Logger.getLogger(start.class.getName());
        lgr.log(Level.SEVERE, ex.getMessage(), ex);
    } 
}

void showreview()
{
    String query = "SELECT * FROM review";
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {

            System.out.print(rs.getInt(1)); // IDreview
            System.out.print("/");
            System.out.print(rs.getInt(2)); // IDperson
            System.out.print("/");
            System.out.println(rs.getString(3)); // IDdoctor
            System.out.print(" - Rate= ");
            System.out.println(rs.getString(4)); // Rate
            System.out.print(" - Comment= ");
            System.out.println(rs.getString(5)); // Comment
        }



    } catch (SQLException ex) {

        Logger lgr = Logger.getLogger(start.class.getName());
        lgr.log(Level.SEVERE, ex.getMessage(), ex);
    } 
}


}
