package jeu;

public abstract class Entite {
    //degat= force phisyqint - armure
    protected int force;
    protected int vie;
    private String nom;


    public Entite(String nom, int vie, int force) {
        this.nom = nom;
        this.vie = vie;
        this.force = force;
    }

    public String getnom() {
        return nom;
    }

    public int getVie() {
        return vie;
    }


    public abstract boolean subirAction(Action action);

    public abstract Action infligerAction();

    public abstract void show(Entite e);

}



