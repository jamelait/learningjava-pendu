import java.io.*;
/*
objet File pour representer le fichier, FileReader pour lire, BufferedReader pour optimiser la lecture
Tete la premiere - Java : page 454
MODIFIE POUR LIRE UNE LIGNE ALEATOIRE
*/
class LireLigneAleatoire {
	public static String motAleatoire() {
	// renvoit un mot aleatoire
		String mot = null;
		try {
			File fichier = new File("MonTexte.txt");
			FileReader fr = new FileReader(fichier);
			BufferedReader br = new BufferedReader(fr);

			int numAleatoire;
			int curseur = 0;
			
			numAleatoire = (int)(Math.random() * 5);
System.out.println(numAleatoire);
			while (curseur <= numAleatoire) { // si curseur = numLigne alors c'est le mot voulu
				mot = br.readLine();
					System.out.println(mot);
				curseur++;
			}
			br.close();
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return mot;
	}
	
	public static void main(String args[]) {
		String mot=motAleatoire();
		System.out.println("\n"+mot);
	}
}