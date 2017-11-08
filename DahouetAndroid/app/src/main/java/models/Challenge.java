package models;

/**
 * Created by devrok on 08/11/17.
 */

public class Challenge {

    private int challenge_id;
    private String challenge_nom;

    public Challenge(int challenge_id, String challenge_nom) {
        this.challenge_id = challenge_id;
        this.challenge_nom = challenge_nom;
    }

    public int getChallenge_id() {
        return challenge_id;
    }

    public void setChallenge_id(int challenge_id) {
        this.challenge_id = challenge_id;
    }

    public String getChallenge_nom() {
        return challenge_nom;
    }

    public void setChallenge_nom(String challenge_nom) {
        this.challenge_nom = challenge_nom;
    }
}
