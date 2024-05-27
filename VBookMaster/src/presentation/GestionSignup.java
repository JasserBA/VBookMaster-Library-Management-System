package presentation;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import dao.GestionMemberImpJDBC;
import dao.IGestionMember;
import metier.Member;

public class GestionSignup extends JFrame {
    private JPanel pContainer = new JPanel();
    private JPanel pTitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pForm = new JPanel(new GridLayout(0, 2, 5, 5));
    private JPanel pSignup = new JPanel(); 
    private JPanel pMembered = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private JPanel pButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private JPanel pSignupSide1 = new JPanel(); 

    private JLabel lblTitle = new JLabel("SIGNUP");
    private JLabel lblCIN = new JLabel("Member ID");
    private JLabel lblUsername = new JLabel("Username");
    private JLabel lblBirthday = new JLabel("Birthday");
    private JLabel lblGender = new JLabel("Gender");
    private JLabel lblMemberType = new JLabel("Member Type");
    private JLabel lblPassword = new JLabel("Password");
    private JLabel lblConfirmPassword = new JLabel("Confirm Password");
    private JLabel lblMembered = new JLabel("Already a member? Login");
    private JLabel lblpic = new JLabel();

    private JTextField txtCIN = new JTextField(20);
    private JTextField txtUsername = new JTextField(20);
    private JTextField txtBirthday = new JTextField(20);
    
    private JPasswordField txtPassword = new JPasswordField(20);
    private JPasswordField txtConfirmPassword = new JPasswordField(20);
    
    private JComboBox<String> comboMemberType = new JComboBox<>(new String[]{"- Select -", "Student", "Guest", "Other"});
    
    private JButton btnSignup = new JButton("Signup");
    private JButton btnClear = new JButton("Clear");
    
    private JRadioButton btnM = new JRadioButton("Male");
    private JRadioButton btnF = new JRadioButton("Female");
    
    private ButtonGroup btnsRadio = new ButtonGroup();
    public GestionSignup() {
        initializeUI();
    }

    private void initializeUI() {
		ImageIcon iPic= new ImageIcon("assets/signup-pic.png");
		lblpic.setIcon(iPic);
		lblpic.setOpaque(false);
        pSignupSide1.add(lblpic);

    	btnClear.setBackground(Color.decode("#D7E1DE"));
    	btnSignup.setBackground(Color.decode("#2C3639"));
    	btnSignup.setForeground(Color.decode("#C2C8C6"));
        lblTitle.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 35));
        lblTitle.setForeground(Color.decode("#3F4E4F"));

        setLayout(new BorderLayout());

        pTitle.add(lblTitle);
        pSignup.setLayout(new BoxLayout(pSignup, BoxLayout.Y_AXIS));
        pSignup.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        pForm.add(lblCIN);
        pForm.add(txtCIN);
        pForm.add(lblUsername);
        pForm.add(txtUsername);
        pForm.add(lblBirthday);
        pForm.add(txtBirthday);
        txtBirthday.setText("YYYY-MM-DD"); // placeholder
        pForm.add(lblGender);
        btnsRadio.add(btnM);
        btnsRadio.add(btnF);
        JPanel pBtnRadio = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pBtnRadio.add(btnM);
        pBtnRadio.add(btnF);
        pForm.add(pBtnRadio);
        pForm.add(lblMemberType);
        pForm.add(comboMemberType);
        pForm.add(lblPassword);
        pForm.add(txtPassword);
        pForm.add(lblConfirmPassword);
        pForm.add(txtConfirmPassword);

        pSignup.add(pTitle);
        pSignup.add(pForm);

        pButtons.add(btnSignup);
        pButtons.add(btnClear);
        pSignup.add(pButtons);

        pMembered.add(lblMembered);
        pSignup.add(pMembered);
        lblMembered.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblMembered.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Window window = SwingUtilities.getWindowAncestor(lblMembered);
        		window.dispose(); 
                new GestionLogin().setVisible(true);
            }
        });
        
        pContainer.setBackground(Color.decode("#D7E1DE"));
        pContainer.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0)); // 20 pixels of padding

        pForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 20 pixels of padding
        pSignupSide1.setOpaque(false);
        pContainer.add(pSignupSide1);
        pContainer.add(pSignup);
        add(pContainer);

        setSize(1200, 850);
        setTitle("VBookMaster");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        btnClear.addActionListener(e -> clearFields());

        btnSignup.addActionListener(x -> signupAction());
        
    }

    private void signupAction() {
        String USERNAME = txtUsername.getText();
        String BIRTHDAY = txtBirthday.getText();
        String StringCIN = txtCIN.getText();
        int IntCIN = 0;

        String GENDER = "";
        if (btnM.isSelected())
            GENDER = "Male";
        else if (btnF.isSelected())
            GENDER = "Female";
        String MEMBERTYPE = (String) comboMemberType.getSelectedItem();
        String PASSWORD = new String(txtPassword.getPassword());
        String ConfPASSWORD = new String(txtConfirmPassword.getPassword());

        boolean fieldsAreEmpty = false;

        if (!StringCIN.isEmpty() && StringCIN.matches("[0-9]+")) {
            IntCIN = Integer.parseInt(StringCIN);
            txtCIN.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        } else if (!StringCIN.isEmpty() && !StringCIN.matches("[0-9]+")) {
            txtCIN.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            JOptionPane.showMessageDialog(this, "CIN must contain only numbers");
        } else if (StringCIN.isEmpty()) {
            txtCIN.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            fieldsAreEmpty = true;
        }

        if (USERNAME.isEmpty()) {
            txtUsername.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            fieldsAreEmpty = true;
        } else {
            txtUsername.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        if (BIRTHDAY.equals("YYYY-MM-DD")) {
            txtBirthday.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            fieldsAreEmpty = true;
        } else {
            txtBirthday.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        if (GENDER.equals("")) {
            btnM.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            btnF.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            fieldsAreEmpty = true;
        } else {
            btnM.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            btnF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        if (MEMBERTYPE.isEmpty() || MEMBERTYPE.equals("- Select -")) {
            comboMemberType.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            fieldsAreEmpty = true;
        } else {
            comboMemberType.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        if (PASSWORD.isEmpty()) {
            txtPassword.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            fieldsAreEmpty = true;
        } else {
            txtPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        if (ConfPASSWORD.isEmpty()) {
            txtConfirmPassword.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            fieldsAreEmpty = true;
        } else {
            txtConfirmPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        if (fieldsAreEmpty) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields correctly.");
        } else {
            IGestionMember gestion;
            try {
            	gestion = new GestionMemberImpJDBC();
                if (gestion.verifierCIN(IntCIN)) {
                    JOptionPane.showMessageDialog(this, "Member with this CIN already exists.");
                    txtCIN.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    return; // Stop if CIN alread exists
                }
                else{
                    txtCIN.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
                Member e = new Member(IntCIN, USERNAME, BIRTHDAY, GENDER, MEMBERTYPE, PASSWORD);
                gestion.ajouterMember(e);
                JOptionPane.showMessageDialog(this, "Member added successfully.");
                this.dispose(); 
                new GestionLogin().setVisible(true);
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(this, e1.getMessage());
            }
        }
    }

    private void clearFields() {
        txtCIN.setText("");
        txtUsername.setText("");
        txtBirthday.setText("YYYY-MM-DD");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        btnsRadio.clearSelection();
        comboMemberType.setSelectedIndex(0);
    }
}
