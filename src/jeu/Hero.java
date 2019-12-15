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
        this.vie -= action.regenLanceur;
        this.vie -= action.degatDefenceur - armure;
        return vie <= 0;
    }

    @Override
    public Action infligerAction() {
        return new Action(1, force, TypeAction.values()[choix]);
    }

    @Override
    public void show(Entite e) {

    }
}
