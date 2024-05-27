package presentation_Admin;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.*;

import TableModeles.MembersModele;
import dao.GestionMemberImpJDBC;
import dao.IGestionMember;
import metier.Member;
import presentation.GestionLogin;

public class ModifyMembers_Admin extends JFrame {
    private JPanel pContainer = new JPanel();
    private JPanel pTitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pHome_Admin = new JPanel(new GridLayout(0,2)); 
    private JPanel pSidebar = new JPanel(new GridLayout(2,0));
    private JPanel pTopInsideSidebar = new JPanel(new GridLayout(0,1)); 
    private JPanel pInfos = new JPanel(new BorderLayout()); 
    private JPanel pRightInsideInfo = new JPanel(new BorderLayout()); 
    private JPanel pGroupButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
    private JPanel pSearch = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    private JPanel pShowListMembers = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    private JPanel pShowListBooks = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    private JPanel pShowIinfosView = new JPanel();
    private JPanel pShowHistory= new JPanel();
    
    private JLabel lblTitle = new JLabel("ModifyMembers_Admin");
    private JTextField txtSearch =new JTextField(10);

    private JButton btnShowHistory = new JButton();
    private JButton btnShowListMembers = new JButton("");
    private JButton btnShowListBooks = new JButton("");
    private JButton btnLogout= new JButton("");
    private JButton btnUpdate = new JButton("More");
    private JPanel pLogout = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    
    private JButton btnAdd = new JButton("Add");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnSearch=new JButton("Search");

	MembersModele MModele=new MembersModele();
	private JTable tableau=new JTable(MModele);
	private JScrollPane jsp=new JScrollPane(tableau);
	private IGestionMember gestion;
	
	
	    private JPanel pForm = new JPanel(new GridLayout(0, 2, 5, 5));

	    private JLabel lblCIN = new JLabel("Member ID");
	    private JLabel lblUsername = new JLabel("Username");
	    private JLabel lblBirthday = new JLabel("Birthday");
	    private JLabel lblGender = new JLabel("Gender");
	    private JLabel lblMemberType = new JLabel("Member Type");
	    private JLabel lblPassword = new JLabel("Password");
	    
	    private JTextField txtCIN = new JTextField(20);
	    private JTextField txtUsername = new JTextField(20);
	    private JTextField txtBirthday = new JTextField(20);
	    
	    private JPasswordField txtPassword = new JPasswordField(20);
	    
	    private JComboBox<String> comboMemberType = new JComboBox<>(new String[]{"- Select -", "Student", "Guest", "Other"});
	       
	    private JRadioButton btnM = new JRadioButton("Male");
	    private JRadioButton btnF = new JRadioButton("Female");
	    
	    private ButtonGroup btnsRadio = new ButtonGroup();

    public ModifyMembers_Admin() {
        initializeUI();
    }

    private void initializeUI() {
        pContainer.setBackground(Color.decode("#D7E1DE"));
        btnLogout.setBackground(Color.decode("#C2C8C6"));
        btnAdd.setBackground(Color.decode("#3F4E4F"));
        btnAdd.setForeground(Color.decode("#D7E1DE"));
        btnDelete.setBackground(Color.decode("#F06E6E"));
        btnDelete.setForeground(Color.decode("#D7E1DE"));
        btnUpdate.setBackground(Color.decode("#C2C8C6"));
        btnSearch.setBackground(Color.decode("#3F4E4F"));
        btnSearch.setForeground(Color.decode("#D7E1DE"));
        btnShowListBooks.setBackground(Color.decode("#C2C8C6"));
        btnShowListMembers.setBackground(Color.decode("#C2C8C6"));
        pForm.setOpaque(false);
        pTitle.setOpaque(false);
        pHome_Admin.setOpaque(false);
        pTopInsideSidebar.setOpaque(false);
        pInfos.setOpaque(false);
        pRightInsideInfo.setOpaque(false);
        pGroupButtons.setOpaque(false);
        pSearch.setOpaque(false);
        pShowIinfosView.setOpaque(false);
        pLogout.setOpaque(false);
        pShowListBooks.setOpaque(false);
        pShowListMembers.setOpaque(false);
        pShowHistory.setOpaque(false);
        pSidebar.setBorder(BorderFactory.createEmptyBorder(100, 20, 20, 20)); 
        pSidebar.setBackground(Color.decode("#809B9D"));
        pLogout.setOpaque(false);
        pShowListMembers.setOpaque(false);
        pShowListBooks.setOpaque(false);
        
        ImageIcon iReturnSelect = new ImageIcon("assets/add.png");  
        ImageIcon iHome= new ImageIcon("assets/members.png");  
        ImageIcon iLogout= new ImageIcon("assets/Logout.png");  
        ImageIcon iHistory= new ImageIcon("assets/history.png");  

        btnShowListMembers.setBorder(BorderFactory.createEmptyBorder()); 
        btnShowListMembers.setIcon(iHome);
        btnShowListMembers.setOpaque(false);
        
        btnShowListBooks.setBorder(BorderFactory.createEmptyBorder()); 
        btnShowListBooks.setOpaque(false);
        btnShowListBooks.setIcon(iReturnSelect);
        
        btnShowHistory.setBorder(BorderFactory.createEmptyBorder()); 
        btnShowHistory.setOpaque(false);
        btnShowHistory.setIcon(iHistory);
        
        btnLogout.setBorder(BorderFactory.createEmptyBorder()); 
        btnLogout.setOpaque(false);
        btnLogout.setIcon(iLogout);
        btnShowHistory.setBackground(Color.decode("#C2C8C6"));
    	try {
	    	gestion=new GestionMemberImpJDBC();	
	        lblTitle.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 35));
	        lblTitle.setForeground(Color.decode("#F06E6E"));
	        pContainer.setLayout(new BorderLayout());
	        /*************************************************************************/

	        pGroupButtons.add(btnAdd);
	        pGroupButtons.add(btnDelete);
	        pGroupButtons.add(btnUpdate);
	        pRightInsideInfo.add(pGroupButtons,BorderLayout.CENTER);
	        /*************************************************************************/
	        pShowListMembers.add(btnShowListMembers);
	        pShowListBooks.add(btnShowListBooks);
	        pShowHistory.add(btnShowHistory);
	        pTopInsideSidebar.add(pShowListMembers);
	        pTopInsideSidebar.add(pShowListBooks);
	        pTopInsideSidebar.add(pShowHistory);
	        pSidebar.add(pTopInsideSidebar);
	        pLogout.add(btnLogout);
	        pSidebar.add(pLogout);
	        /*************************************************************************/

	        pTitle.add(lblTitle);
	        pHome_Admin.setLayout(new BoxLayout(pHome_Admin, BoxLayout.Y_AXIS)); 
	        pHome_Admin.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
	        pHome_Admin.add(pTitle);
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
	        JPanel pBtnRadio = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        pBtnRadio.add(btnM);
	        pBtnRadio.add(btnF);
	        pForm.add(pBtnRadio);
	        pForm.add(lblMemberType);
	        pForm.add(comboMemberType);
	        pForm.add(lblPassword);
	        pForm.add(txtPassword);
	        
	        pContainer.setBackground(Color.decode("#D7E1DE"));
	        
	        pForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 20 pixels of padding
	        pSearch.add(txtSearch);
	        pSearch.add(btnSearch);
	        pRightInsideInfo.add(pSearch, BorderLayout.WEST);
	        pRightInsideInfo.add(pForm,BorderLayout.NORTH);
	        add(pContainer);
	        pHome_Admin.add(pInfos);
	        pInfos.add(jsp, BorderLayout.WEST);
	        pInfos.add(pRightInsideInfo,BorderLayout.CENTER);
	        btnAdd.setVisible(false);
	        pForm.setVisible(false);
			btnSearch.addActionListener(e->{
				try {
			    	if (txtSearch.getText().equals("")) {
				        MModele.charger(gestion.listeDesMembers());
			    	}
					MModele.charger(gestion.rechercherParMC(txtSearch.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
	        btnUpdate.addActionListener(e->{
	        	if (pForm.isVisible()) {
	        		pForm.setVisible(false);
	        		btnAdd.setVisible(false);
	        		btnUpdate.setText("More");
	        	}
	        	else {
	        		btnAdd.setVisible(true);
	        		pForm.setVisible(true);
	        		btnUpdate.setText("Cancel");
	        	}
	        });
	        btnDelete.addActionListener(x->{
				
				int index=tableau.getSelectedRow();
				if(index==-1)
					JOptionPane.showMessageDialog(this,"selectionnez une ligne");
				else
				{
					int cin=(int)MModele.getValueAt(index, 1);
				int res=JOptionPane.showConfirmDialog(this, "voulez vous supprimer cet Member ?","conformation",JOptionPane.YES_NO_OPTION);
					if(res==0)
					{
						try {
							gestion.supprimerMember(cin);
							MModele.charger(gestion.listeDesMembers());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(this, e1.getMessage());
						}
					}
				}
	        });
			MModele.charger(gestion.listeDesMembers());
	
	        pContainer.add(pSidebar,BorderLayout.WEST);
	        
	        pContainer.add(pHome_Admin,BorderLayout.CENTER);
	        
	        btnAdd.addActionListener(e->{
	        	
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
	    	if(!(StringCIN.length()<=9))
        		JOptionPane.showMessageDialog(this, "ERROR, CIN length > 8 !!!");
	    	
	        if (fieldsAreEmpty) {
	            JOptionPane.showMessageDialog(this, "Please fill in all fields correctly.");
	        } else {
	            IGestionMember gestion;
	            try {
	            	gestion = new GestionMemberImpJDBC();
	                if (gestion.verifierCIN(IntCIN)) {
	                    JOptionPane.showMessageDialog(this, "Member with this CIN already exists.");
	                    txtCIN.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	                    return; // Stop execution if CIN already exists
	                }
	                else{
	                    txtCIN.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	                }
	                Member m = new Member(IntCIN, USERNAME, BIRTHDAY, GENDER, MEMBERTYPE, PASSWORD);
	                gestion.ajouterMember(m);
	                JOptionPane.showMessageDialog(this, "Member added successfully.");
					MModele.charger(gestion.listeDesMembers());
	            } catch (SQLException e1) {
	                JOptionPane.showMessageDialog(this, e1.getMessage());
	            }
	        }});
	        btnShowListMembers.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		Window window = SwingUtilities.getWindowAncestor(btnShowListBooks);
	        		window.dispose(); 
	                new ModifyMembers_Admin().setVisible(true);
	            }
	        });
	        btnShowListBooks.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		Window window = SwingUtilities.getWindowAncestor(btnShowListBooks);
	        		window.dispose(); 
	                new ModifyBooks_Admin().setVisible(true);
	            }
	        });
	        btnShowHistory.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		Window window = SwingUtilities.getWindowAncestor(btnShowHistory);
	        		window.dispose(); 
	                new History_Admin().setVisible(true);
	            }
	        });
	        btnLogout.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		Window window = SwingUtilities.getWindowAncestor(btnLogout);
	        		window.dispose(); 
	                new GestionLogin().setVisible(true);
	            }
	        });
	        setSize(1200, 850);
	        setTitle("VBookMaster");
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setVisible(true);
	        setResizable(false);
	        setLocationRelativeTo(null);       
	    }
	        
		catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
    }
}
