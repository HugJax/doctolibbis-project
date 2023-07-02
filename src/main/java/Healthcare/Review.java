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
public class Review {

    protected int IDreview;
    protected int IDperson;
    protected int IDdoctor;
    protected int rate;
    protected String review;

    public Review() {

    }

    public Review(int IDdoc, int IDpers, int note, String comment) {
        IDdoctor = IDdoc;
        IDperson = IDpers;
        setIDReview(IDdoctor + IDperson);
        rate = note;
        review = comment;
    }

    public Review(int IDreview, int IDdoc, int IDpers, int note, String comment) {
        IDdoctor = IDdoc;
        IDperson = IDpers;
        setIDReview(IDdoctor + IDperson);
        rate = note;
        review = comment;
    }

    private void setIDReview(int ID) {
        Random generator = new Random(ID);
        IDreview = (generator.nextInt() * 99999999) ^ 2;
    }

    public int getIDreview() {
        return this.IDreview;
    }

    public int getIDperson() {
        return this.IDperson;
    }

    public int getIDdoctor() {
        return this.IDdoctor;
    }

    public String getreview() {
        return this.review;
    }

    public int getrate() {
        return this.rate;
    }

}
