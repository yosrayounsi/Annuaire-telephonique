import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConnexionUtilisateurGUI extends JFrame implements ActionListener {
	private Image img= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/p.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image img1= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/utili.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img2= new ImageIcon(ConnexionUtilisateurGUI.class.getResource("img/padlock.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);

    private static final String URL = "jdbc:mysql://localhost:3306/annuaire";
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "root";
    private JTextField txtNomUtilisateur;
    private JPasswordField txtMotDePasse;
    private JButton btnConnexion;
    private Principal pc;


    public ConnexionUtilisateurGUI() {
        super("Connexion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 450, 400);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
        contentPane.setBackground(new Color(0, 128, 128));
        contentPane.setLayout(null);
        JLabel label = new JLabel();
        label.setBounds(10, 47, 139, 33);
        contentPane.add(label);

        setContentPane(contentPane);
        setUndecorated(true);
        
        JLabel ab = new JLabel("");
        ab.setHorizontalAlignment(SwingConstants.CENTER);
        ab.setBounds(100, 50, 250, 110);
		ab.setIcon(new ImageIcon(img));

        contentPane.add(ab);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(100, 171, 250, 40);
        contentPane.add(panel);
        panel.setLayout(null);
        txtNomUtilisateur = new JTextField();
        txtNomUtilisateur.setFont(new Font("Arial", Font.PLAIN, 12));
        txtNomUtilisateur.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if(txtNomUtilisateur.getText().equals("Username")) {
        			txtNomUtilisateur.setText("");
				}
				else {
					txtNomUtilisateur.selectAll();
					}
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		if(txtNomUtilisateur.getText().equals("")) {
        			txtNomUtilisateur.setText("Username");
				}
        	}
        });
        txtNomUtilisateur.setBorder(null);
        txtNomUtilisateur.setText("Username");
        txtNomUtilisateur.setBounds(10, 11, 181, 20);
        panel.add(txtNomUtilisateur);
        
        JLabel s = new JLabel("");
        s.setBounds(216, 7, 46, 28);
        s.setIcon(new ImageIcon(img1));
        panel.add(s);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(100, 222, 250, 40);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        txtMotDePasse = new JPasswordField();
        txtMotDePasse.setFont(new Font("Arial", Font.PLAIN, 12));
        txtMotDePasse.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {if(txtMotDePasse.getText().equals("Password")) {
        		txtMotDePasse.setEchoChar('●');
        		txtMotDePasse.setText("");
			}
			else {
				txtMotDePasse.selectAll();
			}
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		if(txtMotDePasse.getText().equals("")) {
        			txtMotDePasse.setText("Password");
        			txtMotDePasse.setEchoChar((char)0);
				}
        	}
        });
       
        txtMotDePasse.setText("Password");
        txtMotDePasse.setBorder(null);
        txtMotDePasse.setBounds(10, 11, 185, 20);
        panel_1.add(txtMotDePasse);
        
        JLabel b = new JLabel("");
        b.setName("b");
        b.setBounds(215, 0, 59, 40);
        b.setIcon(new ImageIcon(img2));
        panel_1.add(b);
        btnConnexion = new JButton("LOG IN");
      
        btnConnexion.setBounds(100, 270, 250, 51);
        contentPane.add(btnConnexion);
        btnConnexion.setFont(new Font("Arial Nova Cond", Font.BOLD, 18));
        btnConnexion.setForeground(new Color(205, 133, 63));
        btnConnexion.setBackground(new Color(47, 79, 79));
        JLabel lx = new JLabel("X");
		lx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION)==0) {
					ConnexionUtilisateurGUI.this.dispose();}
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
		lx.setForeground(Color.WHITE);
		lx.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lx.setHorizontalAlignment(SwingConstants.CENTER);
		lx.setBounds(430, 0, 20, 20);
		contentPane.add(lx);
        btnConnexion.addActionListener(this);
        setVisible(true);
    }

    public static boolean seConnecter(String nomUtilisateur, String motDePasse) {
        try (Connection conn = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE)) {
            String sql = "SELECT * FROM utilisateurs WHERE nom_utilisateur = ? AND mot_de_passe = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomUtilisateur);
            stmt.setString(2, motDePasse);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConnexion) {
            String nomUtilisateur = txtNomUtilisateur.getText();
            String motDePasse = new String(txtMotDePasse.getPassword());
            if (seConnecter(nomUtilisateur, motDePasse)) {
            	Principal pc=new Principal();
            	pc.setVisible(true); 

            	dispose() ;
            } else {
                JOptionPane.showMessageDialog(this, "Nom d'utilisateur ou mot de passe incorrect");
            }
        }
    }

    public static void main(String[] args) {
        new ConnexionUtilisateurGUI();
    }
}
