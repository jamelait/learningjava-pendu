masquerMot(String mot) {
	
	char[] tabMot = mot.toCharArray(); // transformer le string en tableau de char

	// voir pendu.java pour le remplacement des caracteres par _

	
	for (int i = 1 ; i < tabMot.length -1; i++) {
	// on remplace tout les caracteres par des _ sauf la premiere et la derniere lettre
		tabMot[i] = '_';
	}
	
	public ... placerLettre(char c) {
	// remplace tout les _ par la lettre si elle se trouve dans le mot a trouver
		for (int i = 0 ; i < mot.length() ; i++) {
			if (motATrouver.charAt(i) == c) {
				tabMot[i] = c;
			}
		}
	}
	
	/*------------*/
	
	label.setText(Arrays.toString(tabMot));