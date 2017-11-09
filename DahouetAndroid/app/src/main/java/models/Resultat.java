package models;

/**
 * Created by devrok on 08/11/17.
 */

public class Resultat {


    private float resultat_tempsreel;
    private float resultat_tempscompose;
    private int placement;
    private int voilier_numVoile;

    public Resultat( float resultat_tempsreel, float resultat_tempscompose, int placement, int voilier_numVoile) {

        this.resultat_tempsreel = resultat_tempsreel;
        this.resultat_tempscompose = resultat_tempscompose;
        this.placement = placement;
        this.voilier_numVoile = voilier_numVoile;
    }


    public float getResultat_tempsreel() {
        return resultat_tempsreel;
    }

    public void setResultat_tempsreel(float resultat_tempsreel) {
        this.resultat_tempsreel = resultat_tempsreel;
    }

    public float getResultat_tempscompose() {
        return resultat_tempscompose;
    }

    public void setResultat_tempscompose(float resultat_tempscompose) {
        this.resultat_tempscompose = resultat_tempscompose;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public int getVoilier_numVoile() {
        return voilier_numVoile;
    }

    public void setVoilier_numVoile(int voilier_numVoile) {
        this.voilier_numVoile = voilier_numVoile;
    }

    @Override
    public String toString() {
        return "Resultat de la Regate                           " +
                " resultat du tempsreel = " + resultat_tempsreel +
                "                       resultat du tempscompose= " + resultat_tempscompose +
                " placement = " + placement +
                " Numéro de voile = " + voilier_numVoile
                ;
    }
}
