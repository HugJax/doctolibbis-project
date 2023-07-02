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
public class File {

    protected int IDfile;
    protected int IDperson;
    protected int age;
    protected double poids;
    protected double size;
    protected String Bgr;
    protected String description;

    public File(int IDpers, int agee, double poid, double taille, String sanguin, String descirpt) {
        IDperson = IDpers;
        setIDfile(IDperson);
        age = agee;
        poids = poid;
        size = taille;
        Bgr = sanguin;
        description = descirpt;
    }

    public File() {

    }

    private void setIDfile(int ID) {
        Random generator = new Random(ID);
        IDfile = (generator.nextInt() * 99999999) ^ 2;
    }

}
