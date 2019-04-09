import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PenduGraphique extends Pendu implements KeyListener,ActionListener {

	final static String REP = "./images/";

	private JFrame fenetre;
	private JPanel panelPrincipal;
	private JPanel panelGauche;
	private JLabel labelMotATrouver;
	private JLabel labelLettreSaisies;
	private JLabel labelImage;
	
	boolean bon;
	char c;
	JLabel s = new JLabel("  -  -");

	public PenduGraphique() {
		// Allocation memoire
		fenetre = new JFrame("Pendu");
		panelPrincipal = new JPanel(new BorderLayout());
		panelGauche = new JPanel();
		labelMotATrouver = new JLabel();
		labelLettreSaisies = new JLabel();
		labelImage = new JLabel();
		
		// configuration du panelGauche
		Dimension espace = new Dimension(0,20);
		panelGauche.setLayout(new BoxLayout(panelGauche,BoxLayout.Y_AXIS));
		panelGauche.add(new JLabel("MOT A TROUVER"));
		panelGauche.add(Box.createRigidArea(espace));
		panelGauche.add(labelMotATrouver);
		panelGauche.add(Box.createRigidArea(espace));
		panelGauche.add(new JLabel("LETTRES DEJA SAISIES"));
		panelGauche.add(Box.createRigidArea(espace));
		panelGauche.add(labelLettreSaisies);
		
		// police des label
		labelLettreSaisies.setForeground(Color.RED);
		labelLettreSaisies.setFont(new Font("Gras",Font.BOLD,15)); 
		labelMotATrouver.setFont(new Font("Grand",Font.BOLD,16));
		
		// rassemblement dans le panelPrincipal
		panelPrincipal.add(panelGauche, BorderLayout.WEST);
		panelPrincipal.add(labelImage, BorderLayout.EAST);
		panelPrincipal.add(new JLabel("Tapez vos lettres au clavier."), BorderLayout.SOUTH);
		panelPrincipal.add(s, BorderLayout.NORTH);
		
		// configuration de la fenetre
		fenetre.setContentPane(panelPrincipal);
		fenetre.addKeyListener(this);
		fenetre.setSize(750,470);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		
		// ajout du listener
		// panelPrincipal.addKeyListener(this);
		// panelPrincipal.requestFocusInWindow();
		
		// genere un mot et met a jour l'image et le texte
		reset();
		changerImage();
		actualiserTexte();
	}
	
	public void changerImage() {
		labelImage.setIcon(new ImageIcon(REP + nbEssais + ".jpg"));
	}
	
	public void actualiserTexte() {
		labelMotATrouver.setText(Arrays.toString(motSaisi));
		labelLettreSaisies.setText(lettreSaisies.toString());
	}
	
	public void keyPressed(KeyEvent evt) {}
	public void keyReleased(KeyEvent evt) {}  

	public void keyTyped(KeyEvent evt) {
		s.setText("  -  "+evt.getKeyChar()+" -");
		if (Character.isLetter(evt.getKeyChar())) {
			c = Character.toUpperCase(evt.getKeyChar());
			bon = placerLettre(c);
			if (!bon && !lettreSaisies.contains(c)) {
				nbEssais--;
				lettreSaisies.add(c);
			}
			
			actualiserTexte();
			changerImage();
System.out.println("nbEssais = " +nbEssais);
			if (estTrouve() || nbEssais == 1) partieFinie();
		}
	}
	
	public void actionPerformed(ActionEvent e) {}
	
	public void partieFinie() {
		JOptionPane jop = new JOptionPane();
		if (estTrouve()) {
			jop.showMessageDialog(null, "Vous avez trouvé le mot : " + motATrouver, "Bravo !", JOptionPane.INFORMATION_MESSAGE);	
		}
		else {
			jop.showMessageDialog(null, "Perdu, le mot etait : " + motATrouver, "Dommage !", JOptionPane.INFORMATION_MESSAGE);	
		}
		reset();
	}
	
	public void reset() {
		super.reset();
		actualiserTexte();
		changerImage();
	}
	
	public static void main(String[] args) {
		new PenduGraphique();
	}
}