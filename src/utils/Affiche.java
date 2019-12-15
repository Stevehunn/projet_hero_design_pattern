package utils;

/**
 * Classe qui affiche l'inventaire
 *
 * @see Inventaire
 */
public class Affiche extends Inventaire {
	public int id;

	public Affiche(int id) {
		super(id);
		this.id = id;

	}

	public static void main(String[] args) {

		Affiche(0);

	}

	protected static void Affiche(int id) {
		Object[][] tab = recupererInventaire(recupererIntInventaire(id));

		new Table(tab).setVisible(true);

	}

}
