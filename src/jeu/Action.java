package jeu;

/**
 * Classe qui récupère les paramètres pendant les tours de combat
 */

public class Action {
    protected int degatDefenceur;
    protected TypeAction typeAction;

    /**
     * Construteur de la classe Action
     * Permet de recupérer les paramètres du tour de jeu
     */
    public Action(int degatDefenceur, TypeAction typeAction) {
        this.degatDefenceur = degatDefenceur;
        this.typeAction = typeAction;
    }

    int getDegatDefenceur() {
        return degatDefenceur;
    }

    void setTypeAction(TypeAction typeAction) {
        this.typeAction = typeAction;
    }

    TypeAction getTypeAction() {
        return typeAction;
    }
}
