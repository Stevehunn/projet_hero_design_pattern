package jeu;

public class Enigme {
    private String nomEnigme;
    private int difficulte;
    private String[] contenue;

    //public String choixEnigme()
    {
        //partie avec base de données
    }

    public Enigme(String _nomEnigme, int _difficulte, String[] _contenue) {
        nomEnigme = _nomEnigme;
        difficulte = _difficulte;
        contenue = _contenue;
    }

    public void setDifficulte() {
        this.difficulte = difficulte;
    }

    public double getDifficulte() {
        return difficulte;
    }

    public String getNom() {
        return nomEnigme;
    }

    public int choixDifficulte() {

        difficulte = (int) (Math.random() * 4); //difficulte compris entre 0 et 3 compris
        return difficulte;
    }

}


