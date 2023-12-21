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

public class Home extends JFrame {
	
	
private Image img= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/p.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image img1= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/home.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img22= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/home.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	 private Image img10= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/retour.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
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
	public Home() {
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
		
		home.setBackground(new Color(255, 218, 185));
		home.setBounds(0, 140, 249, 40);
		menu.add(home);
		home.setLayout(null);
		
		JLabel hom = new JLabel("HOME");
		hom.setBackground(new Color(0, 0, 0));
		hom.setForeground(new Color(0, 0, 0));
		hom.setFont(new Font("Dialog", Font.BOLD, 14));
		hom.setBounds(76, 11, 163, 18);
		home.add(hom);
		
		JLabel h = new JLabel("");
		h.setBounds(37, 0, 40, 40);
		h.setIcon(new ImageIcon(img1));
		home.add(h);
		
		JPanel rechercher = new JPanel();
		rechercher.addMouseListener(new PanelButtonMouseAdapter(rechercher));
		rechercher.setBackground(new Color(255, 218, 185));
		rechercher.setLayout(null);
		rechercher.setBounds(0, 180, 249, 40);
		menu.add(rechercher);
		
		JPanel ajouter = new JPanel();
		ajouter.addMouseListener(new PanelButtonMouseAdapter(ajouter));
		ajouter.setBackground(new Color(255, 218, 185));
		ajouter.setLayout(null);
		ajouter.setBounds(0, 220, 249, 40);
		menu.add(ajouter);
		
		JPanel modifier = new JPanel();
		modifier.addMouseListener(new PanelButtonMouseAdapter(modifier));
		modifier.setBackground(new Color(255, 218, 185));
		modifier.setLayout(null);
		modifier.setBounds(0, 260, 249, 40);
		menu.add(modifier);
		
		JPanel supp = new JPanel();
		supp.addMouseListener(new PanelButtonMouseAdapter(supp));
		supp.setBackground(new Color(255, 218, 185));
		supp.setLayout(null);
		supp.setBounds(0, 300, 249, 40);
		menu.add(supp);
		
		JPanel signout = new JPanel();
		signout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Principal psc=new Principal();
				psc.setVisible(true); 

				dispose() ;
			}
		});
	
		signout.setBackground(new Color(255, 218, 185));
		signout.setLayout(null);
		signout.setBounds(0, 340, 249, 40);
		menu.add(signout);
		
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
		signout.add(aj_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Principal psc=new Principal();
				psc.setVisible(true); 

				dispose() ;
			}
		});
		lblNewLabel_1.setBounds(34, 0, 46, 40);
		signout.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(img10));
		
		JLabel exit = new JLabel("X");
		exit.setHorizontalAlignment(SwingConstants.CENTER);
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		exit.setBounds(787, 0, 20, 20);
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION)==0) {
					Home.this.dispose();}
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
		
		JLabel lbbb = new JLabel("");
		lbbb.setBounds(477, 0, 285, 147);
		contentPane.add(lbbb);
	      lbbb.setIcon(new ImageIcon(img22));
	      
	      JLabel lblNewLabel = new JLabel("WELCOME  HOME!");
	      lblNewLabel.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 18));
	      lblNewLabel.setBounds(406, 172, 415, 123);
	      contentPane.add(lblNewLabel);
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
