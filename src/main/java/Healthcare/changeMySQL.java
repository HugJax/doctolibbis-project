package Healthcare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class changeMySQL {

    addMySQL addd = new addMySQL();

    public void updateDoc(Doc change) {
        String sql = "UPDATE doctor SET MailPro= '" + change.pmail + "', TelPro= '" + change.ptel + "', Place= '" + change.possplace + "', Prix= '" + change.prix + "'  WHERE IDdoctor=" + change.IDdoc;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void updatename(Person change) {
        String sql = "UPDATE person SET FirstName= '" + change.fname + "' WHERE IDperson=" + change.ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        sql = "UPDATE person SET LastName= '" + change.lname + "' WHERE IDperson=" + change.ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void updatemail(Person change) {
        String sql = "UPDATE person SET Mail= '" + change.mail + "' WHERE IDperson=" + change.ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void updatetel(Person change) {
        String sql = "UPDATE person SET Tel= '" + change.tel + "' WHERE IDperson=" + change.ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void updatepassword(Person change) {
        String sql = "UPDATE person SET Password= '" + change.mdp + "' WHERE IDperson=" + change.ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void updaterdv(RDV change) {
        String sql = "DELETE FROM rdv WHERE IDrdv=" + change.IDrdv;
        deleterdv(change.IDrdv);
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        addd.addRDV(change);
    }

    public void deleterdv(int ID) {
        RDV sup = new retrieveMySQL().rechercherdv(ID);
        String sql = "INSERT INTO suprdv(IDsuprdv, Daterdv, NameDoc, NamePatient, Year, month, day, IDperson) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, ID);
            pst.setString(2, sup.getDateSup());
            pst.setString(3, new retrieveMySQL().retrievedoc(sup.getIDdoc()));
            pst.setString(4, new retrieveMySQL().retrievename(sup.getIDpers()));
            pst.setInt(5, java.time.LocalDateTime.now().getYear());
            pst.setInt(6, java.time.LocalDateTime.now().getMonthValue());
            pst.setInt(7, java.time.LocalDateTime.now().getDayOfMonth());
            pst.setInt(8, sup.getIDpers());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        sql = "DELETE FROM rdv WHERE IDrdv=" + ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
