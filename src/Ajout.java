import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ajout extends JFrame implements ActionListener{

	private JPanel contentPane;
	 private Image img10= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/retour.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img3= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/ajouter.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	 JLabel labelnom = new JLabel("Nom : ");
	    JTextField fnom = new JTextField(20);
	    JLabel labeltel = new JLabel("Téléphone : ");
	    JTextField ftel = new JTextField(20);
	    JButton bu = new JButton("Ajouter");
	    JTextField fville=new JTextField(20);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajout frame = new Ajout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ajout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 807, 418);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelnom = new JLabel("NOM:");
		labelnom.setFont(new Font("Times New Roman", Font.BOLD, 16));
		labelnom.setBounds(259, 145, 67, 20);
		contentPane.add(labelnom);
		
		fnom = new JTextField();
		fnom.setBounds(340, 139, 285, 35);
		contentPane.add(fnom);
		fnom.setColumns(10);
		
		ftel = new JTextField();
		ftel.setColumns(10);
		ftel.setBounds(340, 185, 285, 35);
		contentPane.add(ftel);
		
		JButton bu = new JButton("AJOUTER");
		bu.setForeground(new Color(255, 99, 71));
		bu.setFont(new Font("Tahoma", Font.BOLD, 16));
		bu.setBounds(445, 291, 112, 30);
		contentPane.add(bu);
		
		JLabel lblNewLabel = new JLabel("AJOUTER UN CONTACT A VOTRE ANNUAIRE!");
		lblNewLabel.setForeground(new Color(205, 133, 63));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(325, 11, 405, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lx = new JLabel("X");
		lx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION)==0) {
					Ajout.this.dispose();}
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
		contentPane.add(lx);
		
		JPanel menu = new JPanel();
		menu.setLayout(null);
		menu.setBackground(new Color(245, 222, 179));
		menu.setBounds(0, 0, 249, 418);
		contentPane.add(menu);
		
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
		
		JPanel ajouter_1 = new JPanel();
		ajouter_1.setLayout(null);
		ajouter_1.setBackground(new Color(255, 239, 213));
		ajouter_1.setBounds(0, 220, 249, 40);
		menu.add(ajouter_1);
		
		JLabel aj_1 = new JLabel("AJOUTER");
		aj_1.setForeground(new Color(0, 0, 0));
		aj_1.setFont(new Font("Dialog", Font.BOLD, 14));
		aj_1.setBounds(76, 11, 163, 18);
		ajouter_1.add(aj_1);
		
		JLabel a = new JLabel("");
		a.setBounds(28, -16, 46, 67);
		a.setIcon(new ImageIcon(img3));
		ajouter_1.add(a);
		
		JPanel modifier_1 = new JPanel();
		modifier_1.setLayout(null);
		modifier_1.setBackground(new Color(245, 222, 179));
		modifier_1.setBounds(0, 260, 249, 40);
		menu.add(modifier_1);
		
		JLabel m_1 = new JLabel("");
		m_1.setBounds(20, 0, 40, 40);
		modifier_1.add(m_1);
		
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
		
		JPanel ajouter_1_1 = new JPanel();
		ajouter_1_1.setLayout(null);
		ajouter_1_1.setBackground(new Color(255, 239, 213));
		ajouter_1_1.setBounds(0, 0, 249, 40);
		signout_1.add(ajouter_1_1);
		
		JLabel aj_1_1 = new JLabel("RETOUR");
		aj_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Principal psc=new Principal();
				psc.setVisible(true); 

				dispose() ;
			}
		});
		aj_1_1.setForeground(Color.BLACK);
		aj_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		aj_1_1.setBounds(76, 11, 163, 18);
		ajouter_1_1.add(aj_1_1);
		
		JLabel a_1 = new JLabel("");
		a_1.setBounds(10, -12, 46, 67);
		ajouter_1_1.add(a_1);
		
		JLabel ll = new JLabel("");
		ll.setBounds(20, 0, 46, 40);
		ajouter_1_1.add(ll);
		ll.setIcon(new ImageIcon(img10));
		
		JLabel bv = new JLabel("");
		bv.setHorizontalAlignment(SwingConstants.CENTER);
		bv.setBounds(244, 0, 118, 75);
		bv.setIcon(new ImageIcon(img3));
		contentPane.add(bv);
		
		JLabel lblNum = new JLabel("NUM:");
		lblNum.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNum.setBounds(259, 195, 67, 20);
		contentPane.add(lblNum);
		
		fville = new JTextField();
		fville.setColumns(10);
		fville.setBounds(340, 228, 285, 35);
		contentPane.add(fville);
		
		JLabel lblVille = new JLabel("VILLE:");
		lblVille.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblVille.setBounds(259, 238, 67, 20);
		contentPane.add(lblVille);
	     bu.addActionListener(this);

	        
	        setVisible(true);
	}

			public void actionPerformed(ActionEvent e) {
				 String nom = fnom.getText();
			        String telephone = ftel.getText();
			        String ville=fville.getText();
			        try {
						ajouterContact(nom, telephone,ville);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
	
	  public void ajouterContact(String nom, String telephone,String ville) throws UnknownHostException,IOException {
			Socket Client= new Socket("192.168.1.10",1026);
			String var="ajout";
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
			String s=in.readUTF();
			System.out.println(s);
	        Client.close();
}
}