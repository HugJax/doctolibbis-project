package Healthcare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class addMySQL {

///
/// Add the information of each classe inside the database
///
    public void addPerson(Person nouvp) {
        String sql = "INSERT INTO person(IDperson, FirstName, LastName, Mail, Tel, Password) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, nouvp.ID);
            pst.setString(2, nouvp.fname);
            pst.setString(3, nouvp.lname);
            pst.setString(4, nouvp.mail);
            pst.setInt(5, nouvp.tel);
            pst.setString(6, nouvp.mdp);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void addDoctor(Doc nouvd) {
        String sql = "INSERT INTO person(IDperson, FirstName, LastName, Mail, Tel, Password) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, nouvd.ID);
            pst.setString(2, nouvd.fname);
            pst.setString(3, nouvd.lname);
            pst.setString(4, nouvd.mail);
            pst.setInt(5, nouvd.tel);
            pst.setString(6, nouvd.mdp);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        sql = "INSERT INTO doctor(IDdoctor, IDperson, Spe, Place, Prix, MailPro, TelPro, Formation, Exp) VALUES(?, (SELECT IDperson from person WHERE IDperson = " + nouvd.getID() + " ), ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, nouvd.IDdoc);
            pst.setString(2, nouvd.spe);
            pst.setString(3, nouvd.possplace);
            pst.setInt(4, nouvd.prix);
            pst.setString(5, nouvd.pmail);
            pst.setInt(6, nouvd.ptel);
            pst.setString(7, nouvd.form);
            pst.setString(8, nouvd.exp);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void addRDV(RDV nouvrd) {
        String sql = "INSERT INTO rdv(IDrdv, IDdoctor, IDperson, Motive, Time, Place, Year, Month, Day) VALUES(?, (SELECT IDdoctor from doctor WHERE IDdoctor = " + nouvrd.IDdoctor + " ), (SELECT IDperson from person WHERE IDperson = " + nouvrd.IDperson + " ), ?, ?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, nouvrd.IDrdv);
            pst.setString(2, nouvrd.motive);
            pst.setInt(3, nouvrd.time);
            pst.setString(4, nouvrd.place);
            pst.setInt(5, nouvrd.year);
            pst.setInt(6, nouvrd.month);
            pst.setInt(7, nouvrd.day);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
