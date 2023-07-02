package Healthcare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class retrieveMySQL {

    Person nouvp = new Person();
    Doc nouvd = new Doc();
    File nouvf = new File();
    RDV nouvrdv = new RDV();
    Review nouvr = new Review();
    ArrayList<Doc> list = new ArrayList<>(100);
    ArrayList<Review> listcomment = new ArrayList<>(100);
    ArrayList<RDV> listrdvpatient = new ArrayList<>(100);
    ArrayList<RDV> listrdvdoctor = new ArrayList<>(100);

    public retrieveMySQL() {

    }

///
/// Set of the drifferent classes 
///
    public Person retrievePerson(String mail) {
        String query = "SELECT * FROM person WHERE mail = '" + mail + "'";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                nouvp.ID = rs.getInt(1);
                nouvp.fname = rs.getString(2);
                nouvp.lname = rs.getString(3);
                nouvp.mail = rs.getString(4);
                nouvp.tel = rs.getInt(5);
                nouvp.mdp = rs.getString(6);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return nouvp;
    }

    public Doc retrieveDoc(int ID) {
        String query = "SELECT * FROM doctor WHERE IDdoctor = " + ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                nouvd.IDdoc = rs.getInt(1);
                nouvd.ID = rs.getInt(2);
                nouvd.spe = rs.getString(3);
                nouvd.possplace = rs.getString(4);
                nouvd.prix = rs.getInt(5);
                nouvd.pmail = rs.getString(6);
                nouvd.ptel = rs.getInt(7);
                nouvd.form = rs.getString(8);
                nouvd.exp = rs.getString(9);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return nouvd;
    }

    public Doc retrieveDocfromperson(int ID) {
        String query = "SELECT * FROM doctor WHERE IDperson = " + ID;
        Doc nouv = new Doc();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                nouv.IDdoc = rs.getInt(1);
                nouv.ID = rs.getInt(2);
                nouv.spe = rs.getString(3);
                nouv.possplace = rs.getString(4);
                nouv.prix = rs.getInt(5);
                nouv.pmail = rs.getString(6);
                nouv.ptel = rs.getInt(7);
                nouv.form = rs.getString(8);
                nouv.exp = rs.getString(9);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return nouv;
    }

    // determine if the user is a doctor or not
    public Boolean isDoc(int ID) {
        Doc test = new Doc();
        test.IDdoc = 0;
        Boolean i = false;
        String query = "SELECT IDdoctor FROM doctor WHERE IDperson = " + ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                test.IDdoc = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        if (test.IDdoc != 0) {
            i = true;
        }
        return i;
    }

    public String retrievedoc(int ID) {
        String name = "erreur";
        String query = "SELECT FirstName, LastName FROM person, doctor WHERE doctor.IDdoctor=" + ID + " AND doctor.IDperson=person.IDperson";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                name = rs.getString(1) + " " + rs.getString(2);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return name;
    }

    public String retrievename(int ID) {
        String name = "erreur";
        String query = "SELECT FirstName, LastName FROM person WHERE IDperson=" + ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                name = rs.getString(1) + " " + rs.getString(2);
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return name;
    }

    public int retrieveIDdoc(int ID) {
        int iddoc = 0;
        String query = "SELECT IDdoctor FROM rdv WHERE IDrdv=" + ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                iddoc = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return iddoc;
    }

    public String retrievedocplace(int ID) {
        String place = "place non init";
        String query = "SELECT Place FROM doctor WHERE doctor.IDdoctor=" + ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                place = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return place;
    }

    public ArrayList<Doc> rechercheDoc(String search) {
        search = search + "%";
        String query = "SELECT * FROM person, doctor WHERE (doctor.Spe LIKE '" + search + "' AND person.IDperson=doctor.IDperson) "
                + "OR (doctor.Spe LIKE '%$" + search + "' AND person.IDperson=doctor.IDperson) "
                + "OR (doctor.Place LIKE '" + search + "' AND person.IDperson=doctor.IDperson) "
                + "OR (doctor.Place LIKE '%$" + search + "' AND person.IDperson=doctor.IDperson) "
                + "OR (person.FirstName LIKE '" + search + "' AND person.IDperson=doctor.IDperson) "
                + "OR (person.LastName LIKE '" + search + "' AND person.IDperson=doctor.IDperson)";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {

                list.add(new Doc(rs.getString(2), rs.getString(3), rs.getInt(7), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12), rs.getInt(13), rs.getString(14), rs.getString(15)));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return list;
    }

    public File recherchefile(int ID) {
        String query = "SELECT * FROM file WHERE IDperson=" + ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                nouvf.IDfile = rs.getInt(1);
                nouvf.IDperson = rs.getInt(2);
                nouvf.age = rs.getInt(3);
                nouvf.poids = rs.getDouble(4);
                nouvf.size = rs.getDouble(5);
                nouvf.Bgr = rs.getString(6);
                nouvf.description = rs.getString(7);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return nouvf;
    }

    public ArrayList<Review> recherchereview(int ID) {
        String query = "SELECT * FROM review WHERE IDdoctor=" + ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                listcomment.add(new Review(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return listcomment;
    }

    public Review searchreview(int ID) {
        String query = "SELECT * FROM review WHERE IDreview=" + ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                nouvr.IDreview = rs.getInt(1);
                nouvr.IDperson = rs.getInt(2);
                nouvr.IDdoctor = rs.getInt(3);
                nouvr.rate = rs.getInt(4);
                nouvr.review = rs.getString(5);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return nouvr;
    }

    public ArrayList<RDV> rechercherdvpatient(int ID) {  // get the list of appointment of the patient
        int an = java.time.LocalDateTime.now().getYear(), moi = java.time.LocalDateTime.now().getMonthValue(), jou = java.time.LocalDateTime.now().getDayOfMonth();
        String query = "SELECT * FROM rdv, person, doctor WHERE person.IDperson=" + ID + " AND person.IDperson=rdv.IDperson AND rdv.IDdoctor=doctor.IDdoctor AND (rdv.Year >" + an + " OR ( rdv.Year =" + an + " AND rdv.Month >" + moi + ") OR (rdv.Year =" + an + " AND rdv.Month =" + moi + " AND rdv.Day >=" + jou + "))";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                String hop = rs.getString(11) + " " + rs.getString(12);
                listrdvpatient.add(new RDV(rs.getInt(1), rs.getInt(2), retrievedoc(rs.getInt(2)), rs.getInt(3), hop, rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        new RDV().tricroissant(listrdvpatient);
        return listrdvpatient;
    }

    public RDV rechercherdv(int ID) {  // find a specific appointment
        String query = "SELECT * FROM rdv WHERE IDrdv=" + ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                nouvrdv = new RDV(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return nouvrdv;
    }

    public String[] rechercherdvdoctor(int ID, int annee, int mois, int jour) {  // get the possible hour for  an appointment according to the doctor's schedule
        String[] list = new String[]{"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"};
        int y = 0;
        String query = "SELECT rdv.Time FROM rdv, person, doctor WHERE doctor.IDdoctor=" + ID + " AND person.IDperson=rdv.IDperson AND rdv.IDdoctor=doctor.IDdoctor AND rdv.Year = " + annee + " AND rdv.Month = " + mois + " AND rdv.Day = " + jour;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                for (int i = 8; i < 21; i++) {
                    if (rs.getInt(1) == i) {
                        list[i - 8] = i + " not available";
                        System.out.println("valeur indisponible: " + i);
                    }
                    y++;
                }
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return list;
    }

    public int retrievedocrate(int ID) {   // get the rate of the doctor
        int rate = 0, i = 0;
        String query = "SELECT Rating FROM review WHERE review.IDdoctor=" + ID;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                i++;
                rate = rate + rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        if (i != 0) {
            rate = rate / i;
        }
        return rate;
    }

    public ArrayList<RDV> rdvSup(int ID) {   // get the deleted appointment
        ArrayList<RDV> rdvsup = new ArrayList<>();
        String query = "SELECT * FROM suprdv WHERE IDperson=" + ID + " AND Year =" + java.time.LocalDateTime.now().getYear() + " AND month >= " + java.time.LocalDateTime.now().getDayOfMonth() + " AND day >=" + (java.time.LocalDateTime.now().getDayOfMonth() - 5);
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                rdvsup.add(new RDV(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        new RDV().tricroissant(rdvsup);
        return rdvsup;
    }

    public ArrayList<RDV> rdvModif(int ID) {  //get appointments that have been modified
        ArrayList<RDV> rdvmodif = new ArrayList<>();
        String query = "SELECT * FROM suprdv,rdv WHERE rdv.IDperson=" + ID + " AND rdv.IDperson=suprdv.IDperson AND rdv.IDrdv=suprdv.IDsuprdv";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "inseeculondon");
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                rdvmodif.add(new RDV(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(start.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        new RDV().tricroissant(rdvmodif);
        return rdvmodif;
    }

}
