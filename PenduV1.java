class PenduV1 {
/*********************************************** PROCEDURE DICO**********************************************/
	public static String dico() {
	// renvoit un mot aleatoire
		String liste[]; // liste de mot
		char t[]; // mot a renvoyer
		int n; // indice aleatoire
		int i; // compteur
		liste = new String[51];
		liste[0] = "CLAQUE";
		liste[1] = "IMPRIMANTE";
		liste[2] = "PANDA";
		liste[3] = "ANTICONSTITUTIONNELLEMENT";
		liste[4] = "JEU";
		liste[5] = "LIVRE";
		liste[6] = "MANGA";
		liste[7] = "ARMOIRE";
		liste[8] = "LIT";
		liste[9] = "SEJOUR";
		liste[10] = "CUISINE";
		liste[11] = "CORBEILLE";
		liste[12] = "PROGRAMME";
		liste[13] = "MAISON";
		liste[14] = "BLEU";
		liste[15] = "AVION";
		liste[16] = "XYLOPHONE";
		liste[17] = "ABEILLE";
		liste[18] = "IMMEUBLE";
		liste[19] = "GOURDIN";
		liste[20] = "NEIGE";
		liste[21] = "ZERO";
		liste[22] = "VOITURE";
		liste[23] = "APOCALYPSE";
		liste[24] = "BONJOUR";
		liste[25] = "SALUT";
		liste[26] = "COMMENT";
		liste[27] = "HEIN";
		liste[28] = "MAIS";
		liste[29] = "CONSTITUTION";
		liste[30] = "HISTOIRE";
		liste[31] = "ALPHABET";
		liste[32] = "INCOMPREHENSIBLE";
		liste[33] = "COMIQUE";
		liste[34] = "HUMOUR";
		liste[35] = "LION";
		liste[36] = "TIGRE";
		liste[37] = "AUTRUCHE";
		liste[38] = "GRENOUILLE";
		liste[39] = "CHAT";
		liste[40] = "CHIEN";
		liste[41] = "POULE";
		liste[42] = "COQ";
		liste[43] = "TELEVISION";
		liste[44] = "RADIO";
		liste[45] = "MOTO";
		liste[46] = "VELOMOTEUR";
		liste[47] = "AVIATION";
		liste[48] = "HISTORIQUE";
		liste[49] = "INTERNET";
		liste[50] = "PROGRAMME";
// on genere un indice aleatoire
		n =  (int)(Math.random() * liste.length);
// on choisit un mot dans la liste selon l'indice et on le renvoit
		return liste[n];
	}
/************************************ PROCEDURE MAIN***********************************/

	public static void main(String args[]) {

		boolean gagne = false; // true quand le mot entier est trouve
		boolean trouve; // true quand la lettre est trouve
		int essais = 7; // on a le droit a 7 essais
		int ltrouve; // nombre de lettres trouvees
		int i; // indice et compteur
		char lettre; // saisie du joueur
		String lettre1 ; // saisie du joueur
		String motAtrouve = dico(); // mot aleatoire
		char mot[]; // tableau contenant les caracteres du mot aleatoire
		char saisie[]; // tableau contenant les lettres saisies par le joueur
		
		mot = new char[motAtrouve.length()];
// on remplit le tableau avec les caracteres du mot aleatoire
		for (i = 0 ; i < mot.length ; i++) {
			mot[i] = motAtrouve.charAt(i);
		}
		saisie = new char[motAtrouve.length()];
// la premiere lettre est donne au joueur
		saisie[0] = mot[0];
// la premiere lettre du mot a trouve est remplacee par ! car elle se trouve maintenant dans le tableau saisie
		mot[0] = '!';
// on ne garde que la premiere lettre du mot a trouver, le reste est remplace par _
		for (i = 1 ; i < mot.length ; i++) {
			saisie[i] = '_';
		}

// le jeu commence et continue tant que le mot n'est pas trouve est que le nombre d'essais restant est > a 0	
		while (!gagne && essais != 0) {
			System.out.println("\t\t\nIl reste "+essais+" essais.\n");
// on affiche le contenu du tableau saisie
			for (i = 0 ; i < mot.length ; i++) {
				System.out.print(" "+saisie[i]);
			}
// on force le joueur a taper au moins une lettre
			do {
			lettre1 = Console.readLine("\nLettre : ").toUpperCase();
			} while (lettre1.length() == 0);
			lettre = lettre1.charAt(0);
			
// on regarde si la lettre est dans le mot, ne prend pas en compte si la lettre y est deux fois
			i = 1;
			trouve = false;
			while (i < mot.length && !trouve) {
				if (mot[i] == lettre) {
					saisie[i] = lettre;
					mot[i] = '!';
					trouve = true;
				}
				i++;
			}
// si la lettre n'est pas dans le mot on retranche 1 au nombre d'essais restant
			if (saisie[i-1] != lettre) {
				essais = essais - 1;
			}
// on compte le nombre de lettre trouvees
			ltrouve = 0 ;
			for (i = 0 ; i < mot.length ; i++) {
				if (mot[i] == '!') {
					ltrouve = ltrouve + 1;
				}
			}
// si on a trouve autant de lettre que le mot contient de lettre alors on a gagne
			if (ltrouve == mot.length) {
				gagne = true;
			}
		}
		System.out.println();
// on regarde si on a gagne
		if (gagne) {
			for (i = 0 ; i < mot.length ; i++) {
				System.out.print(" "+saisie[i]);
			}
			System.out.println("\n\nBravo. Vous avez trouve le mot.");
		}
		else {
			System.out.println("Vous avez perdu, le mot etait : " + motAtrouve);
		}
	}
}
// finit le mercredi 25 decembre 2008