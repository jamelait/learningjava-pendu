import java.io.*;
import java.util.ArrayList;

class Dico {
	private File fichier;
	private FileReader fr;
	private BufferedReader br;
	private ArrayList<Integer> listeNumGeneres;
	
	public Dico(String nomfichier) throws FileNotFoundException {
		fichier = new File(nomfichier);
		fr = new FileReader(fichier);
		br = new BufferedReader(fr);
		listeNumGeneres = new ArrayList<Integer>();
		// placement d'un marqueur au tout debut du fichier
		try {
			br.mark((int)fichier.length());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String getMotAleatoire() throws IOException {
		String mot = null;
		int nbLignesFichier = 1453;
		int numAleatoire;
		int curseur = 0;
		
		// genere un numero aleatoire non trouve et l'ajoute a la liste de numeros generes
		do {
			numAleatoire = (int)(Math.random() * nbLignesFichier);
		} while(listeNumGeneres.contains(numAleatoire));
		listeNumGeneres.add(numAleatoire);
//System.out.println("\t\t"+numAleatoire);
		while (curseur <= numAleatoire) { // si curseur = numLigne alors c'est le mot voulu
			mot = br.readLine();
//System.out.println("\t"+mot);
			curseur++;
		}
System.out.println(curseur-1);

		br.reset();
		
		return mot;
	}
	
	public static void main(String args[]) throws IOException {
		Dico dico = new Dico("new.txt");
		for (int i = 0 ; i<5 ; i++)
		System.out.println(dico.getMotAleatoire()+"\n---------------------");
	}
}