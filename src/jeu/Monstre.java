package jeu;

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


