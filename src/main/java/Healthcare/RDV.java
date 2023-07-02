/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Healthcare;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author 931701723
 */
public class RDV {

    protected int IDrdv;
    protected int IDdoctor;
    protected String doctor;
    protected int IDperson;
    protected String patient;
    protected String motive;
    protected int year;
    protected int month;
    protected int day;
    protected int time;
    protected int[] datet;//nonne date
    protected int date;
    protected String daterdv;
    protected String place;
    protected int[] supprime=new int[3];

    public RDV() {

    }

    public RDV(int IDsup, String datrdv, String doc, String pers, int ann, int moi, int jour) {
        IDrdv = IDsup;
        daterdv = datrdv;
        supprime[2] = ann;
        supprime[1] = moi;
        supprime[0] = jour;
        doctor = doc;
        patient = pers;
    }

    public RDV(int IDdoc, int IDpers, String reason, int temps, int[] quand, String ou) {
        IDdoctor = IDdoc;
        IDperson = IDpers;
        motive = reason;
        time = temps;
        year = quand[2];
        month = quand[1];
        day = quand[0];
        place = ou;
        setIDRDV(IDdoctor + IDperson + time + year + month + day);
        date = 10000 * year + 100 * month + day;
    }

    public RDV(int IDrd, int IDdoc, String doc, int IDpers, String pers, String reason, int temps, String ou, int annee, int mois, int jour) {
        IDdoctor = IDdoc;
        doctor = doc;
        IDperson = IDpers;
        patient = pers;
        IDrdv = IDrd;
        motive = reason;
        time = temps;
        year = annee;
        month = mois;
        day = jour;
        place = ou;
        date = 10000 * year + 100 * month + day;
    }

    public RDV(int idrdv, int iddoc, int idpers, String reason, int temps, String ou, int annee, int mois, int jour) {
        IDdoctor = iddoc;
        IDperson = idpers;
        IDrdv = idrdv;
        motive = reason;
        time = temps;
        year = annee;
        month = mois;
        day = jour;
        place = ou;
        date = 10000 * year + 100 * month + day;
    }

    // function get/set for appointments
    
    private void setIDRDV(int ID) {
        Random generator = new Random(ID);
        IDrdv = (generator.nextInt() * 99999999) ^ 2;
    }

    public int getID() {
        return IDrdv;
    }

    public int getIDdoc() {
        return IDdoctor;
    }

    public int getDate() {
        return date;
    }

    public int getIDpers() {
        return IDperson;
    }

    public String getperson() {
        return patient;
    }

    public String getdoctor() {
        return doctor;
    }

    public String getreason() {
        return motive;
    }

    public int getyear() {
        return year;
    }

    public int getmonth() {
        return month;
    }

    public int getday() {
        return day;
    }

    public int gettime() {
        return time;
    }

    public String getplace() {
        return place;
    }

    public String getDateSup() {
        String dat = java.time.LocalDateTime.now().getYear() + "/" + java.time.LocalDateTime.now().getMonthValue() + "/" + java.time.LocalDateTime.now().getDayOfMonth();
        return dat;
    }
    
    // function to sort the appointments by the date

    public void tricroissant(ArrayList<RDV> de) {
        Collections.sort(de, new TRI());
    }

    public void tridecroissant(ArrayList<RDV> de) {
        Collections.sort(de, new TRIINVERSE());
    }

    public class TRI implements Comparator<RDV> {

        @Override
        public int compare(RDV o1, RDV o2) {
            int a = o1.date;
            int b = o2.date;
            return a - b; //To change body of generated methods, choose Tools | Templates.
        }

    }

    public class TRIINVERSE implements Comparator<RDV> {

        @Override
        public int compare(RDV o1, RDV o2) {
            int a = o1.date;
            int b = o2.date;
            return b - a; //To change body of generated methods, choose Tools | Templates.
        }

    }

}
