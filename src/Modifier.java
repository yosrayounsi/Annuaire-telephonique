import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.*;

public class Modifier extends JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/annuaire";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    
    private JTextField nomField = new JTextField(20);
    private JTextField telephoneField = new JTextField(20);
    private JTextField villeField = new JTextField(20);
    private Image img4= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/modifier.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
    private Image img10= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/retour.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
    private Image img5= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/modifier.png")).getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH);
    public Modifier() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 807, 418);
		setUndecorated(true);
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(null);
        nomField.setBounds(256, 125, 268, 40);
        panel.add(nomField);
        telephoneField.setBounds(256, 219, 268, 40);
        panel.add(telephoneField);
        JLabel lblVille = new JLabel("VILLE:");
        lblVille.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblVille.setBounds(256, 259, 388, 71);
        panel.add(lblVille);
        villeField.setBounds(256, 316, 268, 40);
        panel.add(villeField);
        JButton updateButton = new JButton("Modifier");
        updateButton.setForeground(Color.BLACK);
        updateButton.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
        updateButton.setBounds(641, 219, 114, 32);
        panel.add(updateButton);
        getContentPane().add(panel);
        
        JPanel menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(new Color(245, 222, 179));
        menu.setBounds(0, 0, 249, 418);
        panel.add(menu);
        
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
        
        JPanel ajouter_1_1_1 = new JPanel();
        ajouter_1_1_1.setLayout(null);
        ajouter_1_1_1.setBackground(new Color(255, 239, 213));
        ajouter_1_1_1.setBounds(0, 0, 249, 40);
        signout_1.add(ajouter_1_1_1);
        
        JLabel aj_1_1_1 = new JLabel("RETOUR");
        aj_1_1_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Principal psc=new Principal();
				psc.setVisible(true); 

				dispose() ;
        	}
        });
        aj_1_1_1.setForeground(Color.BLACK);
        aj_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
        aj_1_1_1.setBounds(86, 11, 163, 18);
        ajouter_1_1_1.add(aj_1_1_1);
        
        JLabel m77 = new JLabel("");
        m77.setBounds(45, 0, 56, 40);
        ajouter_1_1_1.add(m77);
        m77.setIcon(new ImageIcon(img10));
        
        JPanel ajouter_1_1 = new JPanel();
        ajouter_1_1.setBounds(0, 260, 249, 40);
        menu.add(ajouter_1_1);
        ajouter_1_1.setLayout(null);
        ajouter_1_1.setBackground(new Color(255, 239, 213));
        
        JLabel aj_1_1 = new JLabel("MODIFIER");
        aj_1_1.setForeground(Color.BLACK);
        aj_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
        aj_1_1.setBounds(86, 11, 163, 18);
        ajouter_1_1.add(aj_1_1);
        
        JLabel m = new JLabel("");
        m.setBounds(45, 0, 56, 40);
    	m.setIcon(new ImageIcon(img4));
        ajouter_1_1.add(m);
        
        JLabel m_1 = new JLabel("");
        m_1.setBounds(350, 367, 40, 40);
        panel.add(m_1);
        
        JLabel lblModifierUnContact = new JLabel("MODIFIER UN CONTACT DE VOTRE ANNUAIRE!");
        lblModifierUnContact.setHorizontalAlignment(SwingConstants.CENTER);
        lblModifierUnContact.setForeground(new Color(205, 133, 63));
        lblModifierUnContact.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblModifierUnContact.setBounds(350, 11, 405, 58);
        panel.add(lblModifierUnContact);
        
        JLabel lx = new JLabel("X");
		lx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION)==0) {
					Modifier.this.dispose();}
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
		lx.setForeground(new Color(0, 0, 0));
		lx.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lx.setHorizontalAlignment(SwingConstants.CENTER);
		lx.setBounds(787, 0, 20, 20);
		panel.add(lx);
		
		JLabel b = new JLabel("");
		b.setBounds(269, 11, 71, 58);
		b.setIcon(new ImageIcon(img5));
		panel.add(b);
		
		JLabel lblTelephone = new JLabel("TELEPHONE:");
		lblTelephone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelephone.setBounds(256, 158, 388, 71);
		panel.add(lblTelephone);
		
		JLabel lblNom = new JLabel("NOM:");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom.setBounds(256, 63, 388, 71);
		panel.add(lblNom);
        
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                
                String telephone = telephoneField.getText();
                String ville = villeField.getText();
                try {
					updateContact(nom, telephone, ville);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
    }
    
    private void updateContact(String nom, String telephone, String ville)throws UnknownHostException,IOException {
		Socket Client= new Socket("192.168.1.10",1026);
		String var ="modifier";
		String nomClient=nom;
		String nomClient2=telephone;
		String nomClient3=ville;
		DataOutputStream out=new DataOutputStream(Client.getOutputStream());
		out.writeUTF(var);
		out.writeUTF(nomClient);
		out.writeUTF(nomClient2);
		out.writeUTF(nomClient3);
		
		DataInputStream in=new DataInputStream(Client.getInputStream());
		String s1=in.readUTF();
		System.out.println(s1);
        /*try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "UPDATE telephone SET telephone = '" + telephone + "', ville = '" + ville + "' " +
                "WHERE nom = '" + nom + "'";
            int rows = stmt.executeUpdate(sql);
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Contact modifié avec succès");
            } else {
                JOptionPane.showMessageDialog(this, "Aucun contact correspondant trouvé");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de la modification du contact : " + ex.getMessage());
        }*/
    	
    }
    
    public static void main(String[] args) {
        Modifier frame = new Modifier();
        frame.setVisible(true);
    }
}

