package presentation_Admin;
import java.awt.*;
import java.io.File;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import daoBooks.GestionBookImpJDBC;
import daoBooks.IGestionBook;
import metierBook.Book;
import presentation.GestionLogin;
import presentation.Renderer;
import TableModeles.BooksModele;

public class ModifyBooks_Admin extends JFrame {
    private JPanel pContainer = new JPanel();
    private JPanel pTitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pHome_Admin = new JPanel(new GridLayout(0,2)); 
    private JPanel pSidebar = new JPanel(new GridLayout(2,0));
    private JPanel pTopInsideSidebar = new JPanel(new GridLayout(0,1)); 
    private JPanel pInfos = new JPanel(new BorderLayout()); 
    private JPanel pRightInsideInfo = new JPanel(new BorderLayout()); 
    private JPanel pGroupButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
    private JPanel pSearch = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    private JPanel pImage = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    private JPanel pShowListMembers = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    private JPanel pShowIinfosView = new JPanel();
    private JPanel pLogout = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    private JPanel pShowHistory= new JPanel();

    private JLabel lblTTitle = new JLabel("ModifyBooks_Admin");
    private JTextField txtSearch =new JTextField(10);

    private JButton btnShowListMembers = new JButton("");
    private JButton btnShowListBooks = new JButton("");
    private JButton btnShowHistory = new JButton();
    private JButton btnLogout= new JButton("");
    private JButton btnUpdate = new JButton("More");

    private JButton btnAdd = new JButton("Add");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnSearch=new JButton("Search");

	BooksModele BModele=new BooksModele();
	private JTable tableau=new JTable(BModele);
	private JScrollPane jsp=new JScrollPane(tableau);
	private IGestionBook gestion;

	
	    private JPanel pForm = new JPanel(new GridLayout(0, 2, 5, 5));

	    private JLabel lblBookID = new JLabel("Book ID");
	    private JLabel lblTitle = new JLabel("Title");
	    private JLabel lblPublisher = new JLabel("Publisher");
	    private JLabel lblCategory = new JLabel("Book Type");
	    private JLabel lblCoverPath = new JLabel("Cover Path");
	    private JLabel lblpdfPath = new JLabel("PDF Path");

	    private JTextField txtBookID = new JTextField(20);
	    private JTextField txtTitle = new JTextField(20);
	    private JTextField txtPublisher = new JTextField(20);
	    private JTextField txtCoverPath = new JTextField(20);
	    private JTextField txtpdfPath = new JTextField(20);
	    private JButton btnUploadCover = new JButton("Upload Cover");
	    private JButton btnUploadPdf = new JButton("Upload pdf");
	    private JComboBox<String> comboCategory = new JComboBox<>(new String[]{"- Select -","Fiction","Non-fiction","Mystery/Thriller","Science Fiction/Fantasy","Romance","Biography/Autobiography","History","Self-help","Adventure","Poetry"});

	    public ModifyBooks_Admin() {
        initializeUI();
    }

    private void initializeUI() {
        setBackground(Color.decode("#D7E1DE"));
        pForm.setOpaque(false);
        pTitle.setOpaque(false);
        pHome_Admin.setOpaque(false);
        pTopInsideSidebar.setOpaque(false);
        pInfos.setOpaque(false);
        pRightInsideInfo.setOpaque(false);
        pGroupButtons.setOpaque(false);
        pSearch.setOpaque(false);
        pImage.setOpaque(false);
        pShowIinfosView.setOpaque(false);
        pLogout.setOpaque(false);
        pLogout.setOpaque(false);
        pShowListMembers.setOpaque(false);
        pSidebar.setBorder(BorderFactory.createEmptyBorder(100, 20, 20, 20)); 
        pSidebar.setBackground(Color.decode("#809B9D"));
        
        ImageIcon iReturnSelect = new ImageIcon("assets/add-selected.png");  
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
	    	gestion=new GestionBookImpJDBC();	

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
	        btnUploadCover.setBackground(Color.decode("#809B9D"));
	        btnUploadCover.setBorder(BorderFactory.createLineBorder(Color.decode("#3F4E4F"),3));
	        btnUploadPdf.setBackground(Color.decode("#809B9D"));
	        btnUploadPdf.setBorder(BorderFactory.createLineBorder(Color.decode("#3F4E4F"),3));
  
	        pShowListMembers.setOpaque(false);
	        pForm.setOpaque(false);
	        pTitle.setOpaque(false);
	        pHome_Admin.setOpaque(false);
	        pTopInsideSidebar.setOpaque(false);
	        pInfos.setOpaque(false);
	        pRightInsideInfo.setOpaque(false);
	        pGroupButtons.setOpaque(false);
	        pSearch.setOpaque(false);
	        pShowIinfosView.setOpaque(false);
	        pShowHistory.setOpaque(false);
	        pLogout.setOpaque(false);
	        lblTTitle.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 35));
	        lblTTitle.setForeground(Color.decode("#F06E6E"));
	        pContainer.setLayout(new BorderLayout());
	        
	        /*************************************************************************/
	        pGroupButtons.add(btnAdd);
	        pGroupButtons.add(btnDelete);
	        pGroupButtons.add(btnUpdate);
	        pRightInsideInfo.add(pGroupButtons,BorderLayout.CENTER);
	        /*************************************************************************/
	        pShowListMembers.add(btnShowListMembers);
	        pShowIinfosView.add(btnShowListBooks);
	        pShowHistory.add(btnShowHistory);
	        pLogout.add(btnLogout);
	        pLogout.setOpaque(false);
	        pTopInsideSidebar.add(pShowListMembers);
	        pTopInsideSidebar.setOpaque(false);
	        pTopInsideSidebar.add(pShowIinfosView);
	        pTopInsideSidebar.add(pShowHistory);
	        pSidebar.add(pTopInsideSidebar);
	        pSidebar.add(pLogout);
	        /*************************************************************************/

	        
	        pTitle.add(lblTTitle);
	        pHome_Admin.setLayout(new BoxLayout(pHome_Admin, BoxLayout.Y_AXIS)); 
	        pHome_Admin.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
	        pHome_Admin.add(pTitle);
	        pForm.add(lblBookID);
	        pForm.add(txtBookID);
	        pForm.add(lblTitle);
	        pForm.add(txtTitle);
	        pForm.add(lblPublisher);
	        pForm.add(txtPublisher);
	        pForm.add(lblCoverPath);
	        pForm.add(txtCoverPath);	        
	        pForm.add(lblpdfPath);
	        pForm.add(txtpdfPath);
	        pForm.add(lblCategory);
	        pForm.add(comboCategory);
	        pForm.add(btnUploadCover);
	        pForm.add(btnUploadPdf);
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
	        pInfos.add(pImage,BorderLayout.SOUTH);
	        btnAdd.setVisible(false);
	        pForm.setVisible(false);
	        
	    	if (txtSearch.getText().equals("")) {
		        BModele.charger(gestion.listeDesBooks());
	    	}
	    	btnSearch.addActionListener(e->{
				try {
					if(txtSearch.getText().isEmpty()) 
				        BModele.charger(gestion.listeDesBooks());
					BModele.charger(gestion.rechercherParMC(txtSearch.getText()));
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
				/*delete*/
				int index=tableau.getSelectedRow();
				if(index==-1)
					JOptionPane.showMessageDialog(this,"selectionnez une ligne");
				else
				{
					int BookID=(int)BModele.getValueAt(index, 1);
					int res=JOptionPane.showConfirmDialog(this, "voulez vous supprimer cet Book ?","conformation",JOptionPane.YES_NO_OPTION);
					if(res==0)
					{
						try {
							gestion.supprimerBook(BookID);
							BModele.charger(gestion.listeDesBooks());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(this, e1.getMessage());
						}
					}
				}
	        });
	        tableau.getColumnModel().getColumn(5).setCellRenderer(new Renderer());
	        tableau.getColumnModel().getColumn(5).setPreferredWidth(180);
	        BModele.charger(gestion.listeDesBooks());
	        
	        pContainer.add(pSidebar,BorderLayout.WEST);
	        gestion.trierBookParNom();
	        
	        pContainer.add(pHome_Admin,BorderLayout.CENTER);
	        
	        btnAdd.addActionListener(e->{
        	int IntBookID = 0;
        	String StringBookID = txtBookID.getText();
	        String Title = txtTitle.getText();
	        String Publisher = txtPublisher.getText();
	        String CoverPath = txtCoverPath.getText();
	        String pdfPath = txtpdfPath.getText();

	        String Category = (String) comboCategory.getSelectedItem();

	        boolean fieldsAreEmpty = false;

	        if (!StringBookID.isEmpty() && StringBookID.matches("[0-9]+")) {
	            IntBookID = Integer.parseInt(StringBookID);
	            txtBookID.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        } else if (!StringBookID.isEmpty() && !StringBookID.matches("[0-9]+")) {
	            txtBookID.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	            JOptionPane.showMessageDialog(this, "BookID must contain only numbers");
	        } else if (StringBookID.isEmpty()) {
	            txtBookID.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	            fieldsAreEmpty = true;
	        }
	        if (Title.isEmpty()) {
	            txtTitle.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	            fieldsAreEmpty = true;
	        } else {
	            txtTitle.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        }
	        if (Publisher.isEmpty()) {
	            txtPublisher.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	            fieldsAreEmpty = true;
	        } else {
	            txtPublisher.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        }
	        if (CoverPath.isEmpty()) {
	        	txtCoverPath.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
	            txtCoverPath.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
	            fieldsAreEmpty = true;
	        } else {
	        	txtCoverPath.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        	txtCoverPath.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        }
	        if (CoverPath.isEmpty()) {
	        	txtpdfPath.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
	        	txtpdfPath.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
	            fieldsAreEmpty = true;
	        } else {
	        	txtpdfPath.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        	txtpdfPath.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        }
	        if (Category.isEmpty() || Category.equals("- Select -")) {
	            comboCategory.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	            fieldsAreEmpty = true;
	        } else {
	            comboCategory.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        }
	    	if(!(StringBookID.length()<=9))
        		JOptionPane.showMessageDialog(this, "ERROR, BookID length > 8 !!!");
	    	
	        if (fieldsAreEmpty) {
	            JOptionPane.showMessageDialog(this, "Please fill in all fields correctly.");
	        } else {
	            IGestionBook gestion;
	            try {
	            	gestion = new GestionBookImpJDBC();
	                if (gestion.verifierBookID(IntBookID)) {
	                    JOptionPane.showMessageDialog(this, "Book with this BookID already exists.");
	                    txtBookID.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	                    return; // Stop if BookID already exists
	                }
	                else{
	                    txtBookID.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	                }
	                Book m = new Book(IntBookID, Title, Publisher, Category, CoverPath, pdfPath);
	                gestion.ajouterBook(m);
	                JOptionPane.showMessageDialog(this, "Book added successfully.");
	                BModele.charger(gestion.listeDesBooks());
                    pImage.setVisible(false);

	            } catch (SQLException e1) {
	                JOptionPane.showMessageDialog(this, e1.getMessage());
	            }
	        }});
	        btnLogout.addActionListener(e->{
	        		Window window = SwingUtilities.getWindowAncestor(btnLogout);
	        		window.dispose();
	                new GestionLogin().setVisible(true);
	        });
	        btnShowListMembers.addActionListener(e->{
	        		Window window = SwingUtilities.getWindowAncestor(btnShowListMembers);
	        		window.dispose();
	                new ModifyMembers_Admin().setVisible(true);
	        });
	        btnUploadCover.addActionListener(e -> {
	            JFileChooser chooser = new JFileChooser();
	            chooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));
	            int returnVal = chooser.showOpenDialog(null);
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                File f = chooser.getSelectedFile();
	                if (f != null) {
	                    ImageIcon iconCoverReview = new ImageIcon(f.getAbsolutePath());
	                    txtCoverPath.setText(f.getAbsolutePath());
	                    JLabel lblIcon = new JLabel(iconCoverReview);              
	                    pImage.add(lblIcon, BorderLayout.NORTH);
	                    pImage.revalidate();
	                    pImage.setVisible(true);      
	                }
	            } else {
	                JOptionPane.showMessageDialog(this, "No File chosen!!");
	            }
	        });
 
		    
		    btnUploadPdf.addActionListener(e -> {
		    	JFileChooser chooser = new JFileChooser();
		    	chooser.setFileFilter(new FileNameExtensionFilter("PDF files", "pdf"));
		    	chooser.showOpenDialog(null);
		    	File f = chooser.getSelectedFile();
		    	if (f != null) {
		    		txtpdfPath.setText(f.getAbsolutePath()); 
		    		// System.out.println(f.getAbsolutePath()); 
		    	} else {
		    		System.out.println("No file selected.");
		    	}
		    });
		    
	        btnShowHistory.addActionListener(e->{
	        		Window window = SwingUtilities.getWindowAncestor(btnShowListMembers);
	        		window.dispose();
	                new History_Admin().setVisible(true);
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
