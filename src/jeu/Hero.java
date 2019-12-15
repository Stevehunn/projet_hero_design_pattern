package jeu;

import utils.Inventaire;


public class Hero extends Entite {
    private int armure;
    private Inventaire inventaire;
    private int choix;

    public Hero(String nom, int vie, int force, int armure) {
        super(nom, vie, force);
        this.armure = armure;
    }

    void setChoix(int choix) {
        this.choix = choix;
    }

    @Override
    public boolean subirAction(Action action) {
        this.vie -= action.degatDefenceur - armure;
        return vie <= 0;
    }

    @Override
    public Action infligerAction() {
        TypeAction typeAction = TypeAction.values()[choix];
        if (typeAction == TypeAction.Attaquer)
            return new Action(force, typeAction);
        else if (typeAction == TypeAction.Objet) {
            return new Action(0, typeAction);    // TODO gestion inventaire
        } else if (typeAction == TypeAction.Fuite) {
            return new Action(0, typeAction);   // TODO gestion de la fuite
        }
        return null;
    }
}
