import java.io.*;

public class Lecteur {
	public static void main(String args[]) throws IOException {
	int c;
	FileReader dico = null;
	try {
		new FileReader("dico.txt") ; // ouvre le fichier dictionnaire.txt en lecture
	}
	catch(FileNotFoundException exc) {
		System.out.println(exc);
	}
	
	try {
	c=dico.read();
	while (c != -1) {
		System.out.print(c + " - ");
		c=dico.read();
	}

	}
	catch (IOException e){
		System.out.println("attention");
	}
}
}
