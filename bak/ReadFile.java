import java.io.*;

public class ReadFile {
	public static void main(String[] args){
		String chaine="";
		String fichier ="fichiertexte.txt";
		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				System.out.println(ligne);
				chaine+=ligne+"\n";
			}
			br.close(); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}

	}
}