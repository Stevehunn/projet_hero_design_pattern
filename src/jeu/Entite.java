package jeu;

/**
 * Classe abstraite contenant l'interface commune aux monstres et aux héros.
 * On considère que les dégats sont égaux à la force phisyque - armure.
 */
public abstract class Entite {
    protected int force;
    protected int vie;
    private String nom;

    /**
     * Constructeur d'Entite.
     */
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


    /**
     * Méthode abstraite permettant de subir une action sur une entite.
     *
     * @return retourne vrai si l'entite a subit l'action.
     */
    public abstract boolean subirAction(Action action);

}



