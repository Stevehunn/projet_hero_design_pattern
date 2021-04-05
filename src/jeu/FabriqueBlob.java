package jeu;

public class FabriqueBlob extends FabriqueMonstre {
    @Override
    protected Monstre fabriquerMonstre() {
        return new Monstre("Blob", 50, 5, 0, 0, 0);
    }
}
