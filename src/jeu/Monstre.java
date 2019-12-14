package jeu;

public class Monstre extends Entite {
    private int Force;
    private int Degat;

    private int Vie;

    public Monstre(String nom, int vie, int _Force, int _Degat) {
        super(nom, vie);
        Force = _Force;
        Degat = _Degat;

    }

    public void setForce(int Force) {
        this.Force = Force;
    }

    public int getforce() {
        return Force;
    }

    public int getDegat() {
        return Degat;
    }

    public void setDegat(int Degat) {
        this.Degat = Degat;
    }

    @Override
    public void show(Entite e) {

    }
}


