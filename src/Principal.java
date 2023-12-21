import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Principal extends JFrame {
	
private Image img= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/p.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image img1= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/home.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img2= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/rech.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img3= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/ajouter.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img4= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/modifier.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img5= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/supp.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img6= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/signout.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 807, 418);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel menu = new JPanel();
		menu.setBackground(new Color(255, 240, 245));
		menu.setBounds(0, 0, 249, 418);
		contentPane.add(menu);
		menu.setLayout(null);
		
		JLabel mu = new JLabel("");
		mu.setHorizontalAlignment(SwingConstants.CENTER);
		mu.setBounds(10, 11, 229, 126);
		mu.setIcon(new ImageIcon(img));
		menu.add(mu);
		
		JPanel home = new JPanel();
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home home= new Home();
				home.setVisible(true); 

				dispose() ;
				
			}
		});
		
		home.setBackground(new Color(255, 218, 185));
		home.setBounds(0, 140, 249, 40);
		menu.add(home);
		home.setLayout(null);
		
		JLabel hom = new JLabel("HOME");
		hom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home home= new Home();
				home.setVisible(true); 

				dispose() ;
			}
		});
		hom.setBackground(new Color(0, 0, 0));
		hom.setForeground(new Color(0, 0, 0));
		hom.setFont(new Font("Dialog", Font.BOLD, 14));
		hom.setBounds(76, 11, 163, 18);
		home.add(hom);
		
		JLabel h = new JLabel("");
		h.setBounds(20, 0, 40, 40);
		h.setIcon(new ImageIcon(img1));
		home.add(h);
		
		JPanel rechercher = new JPanel();
		rechercher.addMouseListener(new PanelButtonMouseAdapter(rechercher));
		rechercher.setBackground(new Color(255, 218, 185));
		rechercher.setLayout(null);
		rechercher.setBounds(0, 180, 249, 40);
		menu.add(rechercher);
		
		JLabel rech = new JLabel("RECHERCHER");
		rech.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Rechee k= new Rechee();
				k.setVisible(true); 

				dispose() ;
			}
		});
		rech.setBounds(76, 11, 163, 18);
		rechercher.add(rech);
		rech.setForeground(Color.WHITE);
		rech.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel r = new JLabel("");
		r.setBounds(20, 0, 40, 40);
		r.setIcon(new ImageIcon(img2));
		rechercher.add(r);
		
		JPanel ajouter = new JPanel();
		ajouter.addMouseListener(new PanelButtonMouseAdapter(ajouter));
		ajouter.setBackground(new Color(255, 218, 185));
		ajouter.setLayout(null);
		ajouter.setBounds(0, 220, 249, 40);
		menu.add(ajouter);
		
		JLabel aj = new JLabel("AJOUTER");
		aj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ajout g=new Ajout();
				g.setVisible(true); 

				dispose() ;
			}
		});
		aj.setForeground(Color.WHITE);
		aj.setFont(new Font("Dialog", Font.BOLD, 14));
		aj.setBounds(76, 11, 163, 18);
		ajouter.add(aj);
		
		JLabel a = new JLabel("");
		a.setBounds(20, 0, 40, 40);
		a.setIcon(new ImageIcon(img3));
		ajouter.add(a);
		
		JPanel modifier = new JPanel();
		modifier.addMouseListener(new PanelButtonMouseAdapter(modifier));
		modifier.setBackground(new Color(255, 218, 185));
		modifier.setLayout(null);
		modifier.setBounds(0, 260, 249, 40);
		menu.add(modifier);
		
		JLabel mod = new JLabel("MODIFIER");
		mod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Modifier bv=new Modifier();
				bv.setVisible(true); 

				dispose() ;
			}
		});
		mod.setForeground(Color.WHITE);
		mod.setFont(new Font("Dialog", Font.BOLD, 14));
		mod.setBounds(76, 11, 163, 18);
		modifier.add(mod);
		
		JLabel m = new JLabel("");
		m.setBounds(20, 0, 40, 40);
		m.setIcon(new ImageIcon(img4));
		modifier.add(m);
		
		JPanel supp = new JPanel();
		supp.addMouseListener(new PanelButtonMouseAdapter(supp));
		supp.setBackground(new Color(255, 218, 185));
		supp.setLayout(null);
		supp.setBounds(0, 300, 249, 40);
		menu.add(supp);
		
		JLabel sup = new JLabel("SUPPRIMER");
		sup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Supp sp=new Supp();
				sp.setVisible(true); 

				dispose() ;
			}
		});
		sup.setForeground(Color.WHITE);
		sup.setFont(new Font("Dialog", Font.BOLD, 14));
		sup.setBounds(76, 11, 163, 18);
		
		supp.add(sup);
		
		JLabel s = new JLabel("");
		s.setBounds(20, 0, 40, 40);
		s.setIcon(new ImageIcon(img5));
		supp.add(s);
		
		JPanel signout = new JPanel();
		signout.addMouseListener(new PanelButtonMouseAdapter(signout) {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure to sign out?")==0) {
					ConnexionUtilisateurGUI conn=new ConnexionUtilisateurGUI();
					conn.setVisible(true);
					Principal.this.dispose();
					
				}
			}
		});
		signout.setBackground(new Color(255, 218, 185));
		signout.setLayout(null);
		signout.setBounds(0, 340, 249, 40);
		menu.add(signout);
		
		JLabel sign = new JLabel("SIGN OUT");
		sign.setForeground(Color.WHITE);
		sign.setFont(new Font("Dialog", Font.BOLD, 14));
		sign.setBounds(76, 11, 163, 18);
		signout.add(sign);
		
		JLabel si = new JLabel("");
		si.setBounds(20, 0, 40, 40);
		si.setIcon(new ImageIcon(img6));
		signout.add(si);
		
		JLabel exit = new JLabel("X");
		exit.setHorizontalAlignment(SwingConstants.CENTER);
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		exit.setBounds(787, 0, 20, 20);
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION)==0) {
					Principal.this.dispose();}
				}
			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setForeground(Color.RED);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exit.setForeground(Color.WHITE);
				
			}
		});
		contentPane.add(exit);
	}
	public void menuClicked(JPanel panel) {
	}
	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112,128,144));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(47,79,79));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60,179,113));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112,128,144));
		}
			
		
		
		
		@Override
		public void mouseClicked(MouseEvent e) {
			Ajout g=new Ajout();
			g.setVisible(true); 

			dispose() ;
			
		}
	}
}
