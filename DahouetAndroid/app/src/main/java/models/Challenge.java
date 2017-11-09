package models;

import java.util.Date;

/**
 * Created by devrok on 08/11/17.
 */

public class Challenge {

    private int challenge_id;
    private Date challenge_datedebut;
    private Date challenge_datefin;
    private String challenge_nom;

    public Challenge(int challenge_id, Date challenge_datedebut, Date challenge_datefin, String challenge_nom) {
        this.challenge_id = challenge_id;
        this.challenge_datedebut = challenge_datedebut;
        this.challenge_datefin = challenge_datefin;
        this.challenge_nom = challenge_nom;
    }

    public int getChallenge_id() {
        return challenge_id;
    }

    public void setChallenge_id(int challenge_id) {
        this.challenge_id = challenge_id;
    }

    public Date getChallenge_datedebut() {
        return challenge_datedebut;
    }

    public void setChallenge_datedebut(Date challenge_datedebut) {
        this.challenge_datedebut = challenge_datedebut;
    }

    public Date getChallenge_datefin() {
        return challenge_datefin;
    }

    public void setChallenge_datefin(Date challenge_datefin) {
        this.challenge_datefin = challenge_datefin;
    }

    public String getChallenge_nom() {
        return challenge_nom;
    }

    public void setChallenge_nom(String challenge_nom) {
        this.challenge_nom = challenge_nom;
    }

    @Override
    public String toString() {
        return challenge_nom;
    }
}
