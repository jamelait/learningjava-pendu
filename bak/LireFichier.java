import java.io.*;
/*
objet File pour representer le fichier, FileReader pour lire, BufferedReader pour optimiser la lecture
Tete la premiere - Java : page 454
*/
class LireFichier {
	public static void main (String[] args) {
		try {
			File monFichier = new File("MonTexte.txt");
			FileReader fr = new FileReader(monFichier);
			
			BufferedReader br = new BufferedReader(fr);
			
			String ligne = null;
			
			while ((ligne = br.readLine()) != null) {
				System.out.println(ligne);
			}
			br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}