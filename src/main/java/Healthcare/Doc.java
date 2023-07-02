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
public class Doc extends Person {

    protected int IDdoc;
    protected String spe;
    protected String possplace;
    protected int prix;
    protected String pmail;
    protected int ptel;
    protected String exp;
    protected String form;

    public Doc(String fnam, String lnam, int Iddoc, String Specia, String location, int price, String email, int tele, String forma, String xp) {
        fname = fnam;
        lname = lnam;
        IDdoc = Iddoc;
        spe = Specia;
        possplace = location;
        prix = price;
        pmail = email;
        ptel = tele;
        form = forma;
        exp = xp;
    }

    public Doc(String prenom, String nom, String email, int tele, String password, String specia, String location, int price, String emailpro, int telepro, String xp, String forma) {
        fname = prenom;
        lname = nom;
        mail = email;
        tel = tele;
        setID(tel);
        mdp = password;
        spe = specia;
        possplace = location;
        prix = price;
        pmail = emailpro;
        ptel = telepro;
        setIDdoc(ptel);
        form = forma;
        exp = xp;
    }

    public Doc() {
        super();
    }

    public void setIDdoc(int ptel) {
        Random generator = new Random(ptel);
        IDdoc = (generator.nextInt() * 99999999) ^ 2;
    }

    public int getIDdoc() {
        return this.IDdoc;
    }

    public void setspe(String buffer) {
        spe = buffer;
    }

    public String getspe() {
        return this.spe;
    }

    public void setplace(String buffer) {
        possplace = buffer;
    }

    public String getplace() {
        return this.possplace;
    }

    public void setprix(int buffer) {
        prix = buffer;
    }

    public int getprix() {
        return this.prix;
    }

    public void setexp(String buffer) {
        exp = buffer;
    }

    public String getexp() {
        return this.exp;
    }

    public void setformation(String buffer) {
        form = buffer;
    }

    public String getformation() {
        return this.form;
    }

    public void setptel(int buffer) {
        ptel = buffer;
    }

    public int getptel() {
        return this.ptel;
    }

    public void setpmail(String buffer) {
        pmail = buffer;
    }

    public String getpmail() {
        return this.pmail;
    }
}
