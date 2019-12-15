package jeu;

/**
 * Spécialisation de la classe Entite.
 * Le monstre peut juste attaquer.
 *
 * @see Entite
 */
public class Monstre extends Entite {
    private int x, y, numMap;

    public Monstre(String nom, int vie, int force, int x, int y, int numMap) {
        super(nom, vie, force);
        this.x = x;
        this.y = y;
        this.numMap = numMap;
    }

    int getNumMap() {
        return numMap;
    }

    /**
     * Méthode pour vérifier si c'est le bon monstre.
     *
     * @return retourne vrai si l'objet est bien un monstre
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Monstre)) {
            return false;
        }

        Monstre toTest = (Monstre) obj;
        return numMap == toTest.getNumMap();
    }

    @Override
    public int hashCode() {
        return x + y + numMap + getnom().hashCode();
    }

    /**
     * Méthode pour réduire la vie de l'entite qui a subit une attaque.
     *
     * @param action valeur des dégats a infliger .
     * @return retourne la vie de l'entite qui a subit l'action.
     */
    @Override
    public boolean subirAction(Action action) {
        this.vie -= action.degatDefenceur;
        return vie <= 0;
    }

    @Override
    public Action infligerAction() {
        return new Action(force, TypeAction.Attaquer);
    }

}


