import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class Rechee extends JFrame implements ActionListener {
	 private static final String DB_URL = "jdbc:mysql://localhost:3306/annuaire";
	    private static final String DB_USER = "root";
	    private static final String DB_PASSWORD = "root";
    private Connection conn;
    private JTextField nomField, villeField;
    private JTextArea resultArea;
    private Image img2= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/rech.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
    private Image img9= new ImageIcon(Rechee.class.getResource("img/rech.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
    private Image img10= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/retour.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
    
    public Rechee(){
        

        getContentPane().setLayout(null);
        

        JLabel nomLabel = new JLabel("PAR NOM:");
        nomLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        nomLabel.setBounds(327, 86, 75, 20);
        getContentPane().add(nomLabel);

        nomField = new JTextField();
        nomField.setBounds(286, 115, 150, 20);
        getContentPane().add(nomField);

        JLabel villeLabel = new JLabel("PAR VILLE:");
        villeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        villeLabel.setBounds(673, 87, 75, 20);
        getContentPane().add(villeLabel);

        villeField = new JTextField();
        villeField.setBounds(636, 115, 150, 20);
        getContentPane().add(villeField);

        JButton rechercheButton = new JButton("RECHERCHER");
        rechercheButton.setBounds(461, 146, 147, 23);
        rechercheButton.addActionListener(this);
        getContentPane().add(rechercheButton);

        resultArea = new JTextArea();
        resultArea.setFont(new Font("Sitka Small",Font.BOLD|Font.ITALIC,17));
        resultArea.setBounds(249, 180, 558, 238);
        resultArea.setEditable(false);
        getContentPane().add(resultArea);
        
        JPanel menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(new Color(245, 222, 179));
        menu.setBounds(0, 0, 249, 418);
        getContentPane().add(menu);
        
        JPanel home_1 = new JPanel();
        home_1.setLayout(null);
        home_1.setBackground(new Color(245, 222, 179));
        home_1.setBounds(0, 140, 249, 40);
        menu.add(home_1);
        
        JPanel rechercher_1 = new JPanel();
        rechercher_1.setLayout(null);
        rechercher_1.setBackground(new Color(245, 222, 179));
        rechercher_1.setBounds(0, 180, 249, 40);
        menu.add(rechercher_1);
        
        JPanel ajouter_1_1_1 = new JPanel();
        ajouter_1_1_1.setLayout(null);
        ajouter_1_1_1.setBackground(new Color(255, 239, 213));
        ajouter_1_1_1.setBounds(0, 0, 249, 40);
        rechercher_1.add(ajouter_1_1_1);
        
        JLabel aj_1_1_1 = new JLabel("RECHERCHER");
        aj_1_1_1.setForeground(Color.BLACK);
        aj_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
        aj_1_1_1.setBounds(86, 11, 163, 18);
        ajouter_1_1_1.add(aj_1_1_1);
        
        JLabel m_1 = new JLabel("");
        m_1.setBounds(70, 0, 31, 40);
        ajouter_1_1_1.add(m_1);
        
        JLabel z = new JLabel("");
        z.setBounds(48, 0, 53, 40);
        z.setIcon(new ImageIcon(img2));
        ajouter_1_1_1.add(z);
        
        JPanel supp_1 = new JPanel();
        supp_1.setLayout(null);
        supp_1.setBackground(new Color(245, 222, 179));
        supp_1.setBounds(0, 300, 249, 40);
        menu.add(supp_1);
        
        JPanel signout_1 = new JPanel();
        signout_1.setLayout(null);
        signout_1.setBackground(new Color(245, 222, 179));
        signout_1.setBounds(0, 340, 249, 40);
        menu.add(signout_1);
        
        JPanel ajouter_1_1_1_1 = new JPanel();
        ajouter_1_1_1_1.setLayout(null);
        ajouter_1_1_1_1.setBackground(new Color(255, 239, 213));
        ajouter_1_1_1_1.setBounds(0, 0, 249, 40);
        signout_1.add(ajouter_1_1_1_1);
        
        JLabel aj_1_1_1_1 = new JLabel("RETOUR");
        aj_1_1_1_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Principal psc=new Principal();
				psc.setVisible(true); 

				dispose() ;
        	}
        });
        aj_1_1_1_1.setForeground(Color.BLACK);
        aj_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
        aj_1_1_1_1.setBounds(86, 11, 163, 18);
        ajouter_1_1_1_1.add(aj_1_1_1_1);
        
        JLabel imggg = new JLabel("");
        imggg.setBounds(46, 0, 70, 40);
        ajouter_1_1_1_1.add(imggg);
        imggg.setIcon(new ImageIcon(img10));
        
        JPanel supp_1_1 = new JPanel();
        supp_1_1.setLayout(null);
        supp_1_1.setBackground(new Color(245, 222, 179));
        supp_1_1.setBounds(0, 261, 249, 40);
        menu.add(supp_1_1);
        
        JLabel lblRecherUnContact = new JLabel("RECHERCHER UN CONTACT DANS VOTRE ANNUAIRE!");
        lblRecherUnContact.setHorizontalAlignment(SwingConstants.CENTER);
        lblRecherUnContact.setForeground(new Color(205, 133, 63));
        lblRecherUnContact.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblRecherUnContact.setBounds(327, 0, 449, 58);
        getContentPane().add(lblRecherUnContact);
        
        JLabel lx = new JLabel("X");
        lx.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if(JOptionPane.showConfirmDialog(null, "Are you sure to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION)==0) {
					Rechee.this.dispose();}
        	}
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		lx.setForeground(Color.RED);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
				lx.setForeground(Color.WHITE);

        	}
        });
        lx.setHorizontalAlignment(SwingConstants.CENTER);
        lx.setForeground(Color.BLACK);
        lx.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lx.setBounds(786, 0, 20, 20);
        getContentPane().add(lx);
        
        JLabel c = new JLabel("");
        c.setBounds(249, 0, 75, 47);
        c.setIcon(new ImageIcon(img9));
        getContentPane().add(c);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 807, 418);
		setUndecorated(true);
        setVisible(true);
    }

    //public void close() throws SQLException {
       // conn.close();
    //}

    public void rechercheContact(String nom, String ville) throws  UnknownHostException,IOException {
    	try {
    		resultArea.setText("");
            // Se connecter au serveur sur le port 1234
            Socket socket = new Socket("192.168.1.10", 1026);
            
            // Envoyer la requête SELECT au serveur
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            String var="rechercher";
            DataOutputStream out=new DataOutputStream(socket.getOutputStream());
    		out.writeUTF(var);
            //output.println(var);
            output.println(nom);
            output.println(ville);
            
            // Recevoir les résultats de la requête SELECT du serveur
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String result;
            while ((result = input.readLine()) != null) {
                System.out.println(result);
                resultArea.append(result+"\n");
            }
            
            // Fermer les flux et la socket
            input.close();
            output.close();
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        String nom = nomField.getText();
        String ville = villeField.getText();
        try {
            rechercheContact(nom, ville);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        Rechee annuaire = new Rechee();
    }
}
