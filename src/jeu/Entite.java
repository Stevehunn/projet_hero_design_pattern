package jeu;

public abstract class Entite {
    protected int armure;
    //degat= force phisyqint - armure
    protected int force_physique;
    protected int degat;
    protected int vie = 100;
    private String nom;


    public Entite(String _nom, int _vie) {
        nom = _nom;
        vie = _vie;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public String getnom() {
        return nom;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int Vie) {
        this.vie = Vie;
    }

    public abstract void show(Entite e);

}



