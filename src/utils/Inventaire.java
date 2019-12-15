package utils;

public class Inventaire extends Connect {
	public int id;

	public Inventaire(int id) {
		this.id = id;
		recupererInventaire(recupererIntInventaire(id));

	}

	public static String[] recupererIntInventaire(int iDperso) {
		String a = "Select * from inventaire where id_personnage=";
		a = a + Integer.toString(iDperso);

		String[] tab = Connect(a);

		return tab;

	}

	public static Object[][] recupererInventaire(String[] tableau) {
		Object inventaire[][] = new Object[3][4];

		String objet1 = tableau[3];
		String objet2 = tableau[4];
		String objet3 = tableau[5];

		try {

			String requete1 = "SELECT nom_objet,image,pv,pm FROM objets inner join stats_objets on objets.id_stats=stats_objets.id_stats where id_objet=" + objet1;
			String requete2 = "SELECT nom_objet,image,pv,pm FROM objets inner join stats_objets on objets.id_stats=stats_objets.id_stats where id_objet=" + objet2;
			String requete3 = "SELECT nom_objet,image,pv,pm FROM objets inner join stats_objets on objets.id_stats=stats_objets.id_stats where id_objet=" + objet3;

			Object[] a = Connect(requete1);
			Object[] b = Connect(requete2);
			Object[] c = Connect(requete3);

			for (int j = 0; j < 4; j++) {

				inventaire[0][j] = a[j + 1];
				inventaire[1][j] = b[j + 1];
				inventaire[2][j] = c[j + 1];


			}


		} catch (Exception e) {
			e.printStackTrace();

		}

		return inventaire;

	}


}
