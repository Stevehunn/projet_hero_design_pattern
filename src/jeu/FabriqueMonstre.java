package jeu;

public abstract class FabriqueMonstre {
    protected abstract Monstre fabriquerMonstre();

    public Monstre obtenirMonstre() {
        return fabriquerMonstre();
    }
}
