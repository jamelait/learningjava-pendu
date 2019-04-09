masquerMot(String mot) {
	
	char[] tabMot = mot.toCharArray(); // transformer le string en tableau de char

	// voir pendu.java pour le remplacement des caracteres par _

	
	for (int i = 1 ; i < tabMot.length -1; i++) {
	// on remplace tout les caracteres par des _ sauf la premiere et la derniere lettre
		tabMot[i] = '_';
	}
	
	/*------------*/
	
	public ... placerLettre(char c) {
	// remplace tout les _ par la lettre si elle se trouve dans le mot a trouver
		for (int i = 0 ; i < motATrouver.length() ; i++) {
			if (motATrouver.charAt(i) == c) {
				tabMot[i] = c;
			}
		}
	}
	
	/*------------*/
	
	label.setText(Arrays.toString(tabMot));
	
		/*------------*/

	public boolean estTrouve() {
	// teste si le mot a trouver est egal au mot saisi
		boolean trouve = true;
		
		for (int i = 0 ; i < motATrouver.length() ; i++) {
			if (motATrouver.charAt(i) != tabMot[i]) {
				trouve = false;
			}
		}
		// ou
		int i = 0;
		while (trouve && i < motATrouver.length()) {
			if (motATrouver.charAt(i) != tabMot[i]) {
				trouve = false;
			}
			i++
		}
	}
	
	
	public boolean placerMot(String mot) {
	// si le mot est egal au mot a trouver, le motSaisi devient le mot a trouver
		boolean trouve = true;
		int i = 0;
		while (trouve && i < motATrouver.length()) {
			if (mot.charAt(i) != motATrouver.charAt(i)) {
				trouve = false;
			}
			i++;
		}
		if (trouve) {
			motSaisi = mot.toCharArray();
		}
		return trouve;
	}