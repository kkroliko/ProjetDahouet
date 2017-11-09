package models;

/**
 * Created by devrok on 08/11/17.
 */

public class Regate {

    private int regate_id;
    private String regate_nom;
    private float regate_distance;

    public Regate(int regate_id, String regate_nom, float regate_distance) {
        this.regate_id = regate_id;
        this.regate_nom = regate_nom;
        this.regate_distance = regate_distance;
    }

    public int getRegate_id() {
        return regate_id;
    }

    public void setRegate_id(int regate_id) {
        this.regate_id = regate_id;
    }

    public String getRegate_nom() {
        return regate_nom;
    }

    public void setRegate_nom(String regate_nom) {
        this.regate_nom = regate_nom;
    }

    public float getRegate_distance() {
        return regate_distance;
    }

    public void setRegate_distance(float regate_distance) {
        this.regate_distance = regate_distance;

    }

    @Override
    public String toString() {

        return regate_nom;
    }
}
