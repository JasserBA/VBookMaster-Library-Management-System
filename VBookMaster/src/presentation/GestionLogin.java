package presentation;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import dao.GestionMemberImpJDBC;
import dao.IGestionMember;
import presentation_Admin.ModifyMembers_Admin;

public class GestionLogin extends JFrame {
    private JPanel pContainer = new JPanel();
    private JPanel pTitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pForm = new JPanel(new GridLayout(0, 2, 5, 5));
    private JPanel pLogin = new JPanel(); 
    private JPanel pLoginSide1 = new JPanel(); 
    private JPanel pMembered = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    private JPanel pButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private JLabel lblTitle = new JLabel("LOGIN");
    private JLabel lblCIN = new JLabel("Member ID");
    private JLabel lblPassword = new JLabel("Password");
    private JLabel lblMembered = new JLabel("New here? Signup");
    private JTextField txtCIN = new JTextField(20);
    private JPasswordField txtPassword = new JPasswordField(20);
    private JButton btnLogin = new JButton("Login");
    private JButton btnClear = new JButton("Clear");
    
    private JLabel lblpic = new JLabel();

    public GestionLogin() {
        initializeUI();
    }

    private void initializeUI() {
    	  ImageIcon iPic= new ImageIcon("assets/login-pic.png");
          lblpic.setIcon(iPic);
          lblpic.setOpaque(false);
          
    	btnClear.setBackground(Color.decode("#D7E1DE"));
    	btnLogin.setBackground(Color.decode("#2C3639"));
    	btnLogin.setForeground(Color.decode("#C2C8C6"));
        lblTitle.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 35));
        lblTitle.setForeground(Color.decode("#3F4E4F"));
        setLayout(new BorderLayout());

        pTitle.add(lblTitle);
        pLogin.setLayout(new BoxLayout(pLogin, BoxLayout.Y_AXIS));
        pLogin.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 20 pixels of padding

        pForm.add(lblCIN);
        pForm.add(txtCIN);
        pForm.add(lblPassword);
        pForm.add(txtPassword);

        pLogin.add(pTitle);
        pLogin.add(pForm);

        pButtons.add(btnLogin);
        pButtons.add(btnClear);
        pLogin.add(pButtons);

        pMembered.add(lblMembered);
        pLogin.add(pMembered);
        pLoginSide1.add(lblpic);
        lblMembered.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblMembered.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Window window = SwingUtilities.getWindowAncestor(lblMembered);
        		window.dispose(); // Close the current window
                new GestionSignup().setVisible(true);
            }
        });
        
        pContainer.setBackground(Color.decode("#D7E1DE"));
        pContainer.setBorder(BorderFactory.createEmptyBorder(200, 0, 0, 0)); // 20 pixels of padding

        pForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 20 pixels of padding
        pLoginSide1.setOpaque(false);
        pContainer.add(pLoginSide1);
        pContainer.add(pLogin);
        add(pContainer);

        setSize(1200, 850);
        setTitle("VBookMaster");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        btnClear.addActionListener(e -> clearFields());

        btnLogin.addActionListener(x -> LoginAction());
        txtCIN.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!(Character.isDigit(c)))
		                e.consume();			
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
    }

    private void LoginAction() {
        String StringCIN = txtCIN.getText();
        int IntCIN = 0;
        String PASSWORD = new String(txtPassword.getPassword());

        boolean fieldsAreEmpty = false;

        if (!StringCIN.isEmpty() && StringCIN.matches("[0-9]+")) {
            IntCIN = Integer.parseInt(StringCIN);
            txtCIN.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        } else if (!StringCIN.isEmpty() && !StringCIN.matches("[0-9]+")) {
            txtCIN.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            JOptionPane.showMessageDialog(this, "CIN must contain only numbers");
            return; // Stop execution if CIN is invalid
        } else if (StringCIN.isEmpty()) {
            txtCIN.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            fieldsAreEmpty = true;
        }

        if (PASSWORD.isEmpty()) {
            txtPassword.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            fieldsAreEmpty = true;
        } else {
            txtPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        if (fieldsAreEmpty) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields correctly.");
        } else {
            IGestionMember gestion;
            try {
            	gestion = new GestionMemberImpJDBC();
                int loginResult = gestion.verifierLogin(IntCIN, PASSWORD);
                switch (loginResult) {
                	case 2:
	                    JOptionPane.showMessageDialog(null, "error CIN length > 8 !!", "Error", JOptionPane.ERROR_MESSAGE);

                        txtCIN.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                        break;             
                    case 1:
                        String username = gestion.getUsername(IntCIN);
                        JOptionPane.showMessageDialog(this, "Login successfully.");
                        dispose(); // Close the current
                        if (username.equals("admin")&&PASSWORD.equals("admin"))
                        	new ModifyMembers_Admin().setVisible(true);
                        else
                        	new Welcome(username,Integer.parseInt(StringCIN)).setVisible(true);
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Password incorrect!!", "Error", JOptionPane.ERROR_MESSAGE);

                        txtPassword.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                        break;
                    case -1:
                        JOptionPane.showMessageDialog(this, "Member with this CIN does not exist.");
                        txtCIN.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                        break;
                }
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(this, e1.getMessage());
            }
        }
    }

    private void clearFields() {
        txtCIN.setText("");
        txtPassword.setText("");
    }
}
