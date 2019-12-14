package jeu;

public class Combat {
    private int numTours;
    private Entite hero;
    private Entite monstre;
    private boolean combatTermine;

    public Combat(String name, int rand0, int rand1, int rand2, int rand3) {
        this.hero = hero;
        this.monstre = monstre;
        numTours = 0;
        combatTermine = false;
    }

    private Action phaseJoueur() {
        return new Action();
    }

    private Action phaseMonstre() {
        return new Action();
    }

    public void run() {
        while (!combatTermine) {
            phaseJoueur();
            phaseMonstre();
        }
    }



        /*public static void main(String[] args) {
            hero.getVie(hero);
            monstre.getVie(monstre);
            while (fini = true) {
                if (tourDeJeu() == "Tour du hero") {

                    System.out.println("Que voulez-vous faire ? \n Attaquer = 1 \n Utiliser un Objet = 2 \n Fuite = 3 \n ");
                    Scanner scan = new Scanner(System.in);
                    int choixJ = scan.nextInt();
                    scan.close();
                    //show(hero);
                    option(choixJ);
                }
                if (fini != true && tourDeJeu() == "Tour du monstre") {
                    option(1);
                    //show(hero);
                }
            }

        }

        //méthode pour déterminer le tour de jeu
        public static String tourDeJeu() {
            if (numTour == 0) {
                numTour += 1;
                return "Tour du hero";
            } else return "Tour du monstre";
        }

        //Méthode pour afficher les différentes options de combat pour le hero
        public static void option(int choixJ) {
            switch (choixJ) {
                case 1:
                    //Cas ou le joueur choisit attaquer le monstre
                    System.out.println("Attaquer \n");
                    int dégat;
                    show(hero);
                    showM(monstre);
                    dégat = Monstre.force_physique;
                    int vie;
                    vie = monstre.getVie(monstre) - dégat;
                    monstre.setVie(monstre, vie);
                    showM(monstre);
                    if (monstre.getVie(monstre) == 0 || hero.getVie(hero) == 0)
                        fini = true;
                    break;

                case 2:
                    //Cas ou le joueur choisit d'utiliser un objet

		/*System.out.println("Objet \n Fonction non implémenté, vous attaquerez donc par défaut");
		option(1);
		*/
        /*

                    System.out.println("Objet \n Ouverture de l'inventaire");
                    int id;
                    for (id = 0; id < 20; id++) {
                        Inventaire.recupererInventaire(Inventaire.recupererIntInventaire(id));
                    }
                    break;

                case 3:
                    //Cas ou le joueur fuit le combat
                    System.out.println("Fuite");
                    //soin(hero);
                    fini = true;
                    break;

            }
        }


        //Méthode pour redonner toute sa vie au hero
        public static void soin(Entite e) {
            e.setVie(hero, 100);
            System.out.println("Votre vie a était restauré");

        }

        //Méthode pour afficher le personnage
        public static void show(Entite e) {
            System.out.println("==============================");
            System.out.println("Nom de personnage:               	" + e.getnom(e));
            System.out.println("==============================");
            System.out.println("Vie de personnage:               	" + e.getVie(e));
            System.out.println("==============================");
            System.out.println("Armure de personnage:             " + armure);
            System.out.println("==============================");
            System.out.println("force_physique de personnage:     " + force_physique);
            System.out.println("==============================");
            System.out.println("degat de personnage:              " + (force_physique - armure));

        }

        //Méthode pour afficher le monstre
        public static void showM(Monstre monstre) {
            System.out.println("==============================");
            System.out.println("Vie du monstre:					 " + monstre.getVie(hero));
            System.out.println("==============================");
            System.out.println("force physique du monstre: 		 " + monstre.getforce());
            System.out.println("==============================");
            System.out.println("degat du monstre: 				 " + monstre.getDegat() + "\n");

        }

    }*/
}


