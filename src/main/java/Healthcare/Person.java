/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Healthcare;

import java.util.Random;

/**
 *
 * @author 931701723
 */
public class Person {

    protected int ID;
    protected String fname;
    protected String lname;
    protected String mail;
    protected int tel;
    protected String mdp;

    public Person() {

    }

    public Person(String prenom, String nom, String email, int tele, String password) {
        fname = prenom;
        lname = nom;
        mail = email;
        tel = tele;
        setID(tel);
        mdp = password;
    }

    public void setID(int tel) {
        Random generator = new Random(tel);
        ID = (generator.nextInt() * 99999999) ^ 2;
    }

    public int getID() {
        return this.ID;
    }

    public void setfname(String buffer) {
        fname = buffer;
    }

    public String getfname() {
        return this.fname;
    }

    public void setlname(String buffer) {
        lname = buffer;
    }

    public String getlname() {
        return this.lname;
    }

    public void setmail(String buffer) {
        mail = buffer;
    }

    public String getmail() {
        return this.mail;
    }

    public void settel(int buffer) {
        tel = buffer;
    }

    public int gettel() {
        return this.tel;
    }

    public void setmdp(String buffer) {
        mdp = buffer;
    }

    public String getmdp() {
        return this.mdp;
    }
}
