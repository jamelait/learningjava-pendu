import java.io.*;
import java.util.ArrayList;
/*
V  _  _  _  _  E je tape voiture, je n'ai aucune erreur
*/
class Pendu {
	
	protected String fichier = "fichier.txt";
	protected String motATrouver;
	protected char[] motSaisi;
	protected Dico dico;
	protected int nbEssais;
	protected ArrayList<Character> lettreSaisies;
	
	public Pendu() {
		try {
			dico = new Dico(fichier);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		lettreSaisies = new ArrayList<Character>();
	}
	
	public void reset() {
		try {
			motATrouver = dico.getMotAleatoire().toUpperCase();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		motSaisi = motATrouver.toCharArray();
		lettreSaisies.clear();
		masquerMot();
		nbEssais = 10;
	}

	public void masquerMot() {
	//  remplace tout les caracteres par des _ sauf la premiere et la derniere lettre
		for (int i = 1 ; i < motSaisi.length -1; i++) {
			motSaisi[i] = '_';
		}
		// on met la premiere lettre et la derniere dans la liste, mais s'il y a encore ces lettres dans le mot ?
		// lettreSaisies.add(motATrouver.charAt(0));
		// lettreSaisies.add(motATrouver.charAt(motATrouver.length() -1));
	}
	
	public boolean placerLettre(char c) {
	// remplace tout les _ par la lettre si elle se trouve dans le mot a trouver
	c = Character.toUpperCase(c);
	
		boolean replaced = false;
		for (int i = 0 ; i < motATrouver.length() ; i++) {
			if (motATrouver.charAt(i) == c) {
				motSaisi[i] = c;
				replaced = true;
			}
		}
		return replaced;
	}
	
	public boolean placerMot(String mot) {
	// si le mot est egal au mot a trouver, le motSaisi devient le mot a trouver
		boolean bonMot = false;
		if (motATrouver.equals(mot)) {
			motSaisi = mot.toCharArray();
			bonMot = true;
		}
		return bonMot;
	}
	
	public boolean estTrouve() {
	// teste si le mot a trouver est egal au mot saisi
		boolean trouve = true;
		int i = 0;
		
		while (trouve && i < motATrouver.length()) {
			if (motATrouver.charAt(i) != motSaisi[i]) {
				trouve = false;
			}
			i++;
		}
		
		return trouve;
	}
	
	public void afficherMotSaisi() {
	// affiche le tableau de lettres saisies avec des espaces entre les lettres
		for (int i = 0 ; i < motSaisi.length ; i++) {
			System.out.print(motSaisi[i] + "  ");
		}
		System.out.println("\n");
	}
	
	public void separation() {
		System.out.println();
		for (int i = 0 ; i < 100 ; i++)
			System.out.print("*");
		System.out.println();
	}
	
	public void jouer() {
		String choix;
		boolean bonneLettre;
		// tant que le mot n'est pas trouve que le nombre d'essais est superieur a 0
		// on affiche le nombre d'essais restants, le mot a completer, les lettres saisies
		// le joueur saisi une lettre ou un mot, si la longueur du mot est egal au mot a trouver,
		// le mot a completer devient le mot a trouver sinon on regarde si le mot a trouver 
		// contient la premiere lettre de la saisie
		// on retranche 1 au nombre d'essais si le mot saisi n'est pas le bon mot
		// et si la premiere lettre n'est pas dans le mot et si la lettre n'a pas deja ete saisie
		do {
			reset();
			do {
				separation();
				System.out.println("\n\nVous avez droit a " + nbEssais + " essais");
				System.out.println("\n\tMot a completer\n");
				afficherMotSaisi();
				System.out.println("Les lettres que vous avez deja saisies sont : " + lettreSaisies + "\n");
				String saisie = Console.readLine("Votre proposition : ").toUpperCase();
				
				if (saisie.length() == motATrouver.length()) {
					bonneLettre = placerMot(saisie);
				}
				else {
					// si la lettre est dans le mot et si la lettre n'est pas dans la liste des lettres saisies
					bonneLettre = placerLettre(saisie.charAt(0));
					if (bonneLettre && !lettreSaisies.contains(saisie.charAt(0)))
						lettreSaisies.add(saisie.charAt(0));
				}
				// si ce n'est ni le bon mot et si la premiere lettre de la saisie
				/// n'est pas dans le mot a trouver et si la lettre n'a pas deja etait saisie
				if (!bonneLettre && !lettreSaisies.contains(saisie.charAt(0))) {
					lettreSaisies.add(saisie.charAt(0));
					nbEssais--;
				}
				
			} while (!estTrouve() && nbEssais > 0);
			System.out.println();
			if (estTrouve()) {
				System.out.println("Felicitations, vous avez trouve le mot " + motATrouver + " !!!");
			}
			else {
				System.out.println("Dommage, vous avez perdu, le mot etait " + motATrouver + " !!!");
			}
			System.out.println();
			
			choix = Console.readLine("Tapez 0 pour arreter : ");
		} while(!choix.equals("0"));
	}
	
	public static void main(String[] args) {
		Pendu pendu = new Pendu();
		pendu.jouer();
	}
}
