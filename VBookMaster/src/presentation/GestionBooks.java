package presentation;
import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import TableModeles.BooksModele;
import TableModeles.HistoryAddedModele;
import TableModeles.MembersModele;
import TableModeles.ReturnBooksModele;
import daoBooks.GestionBookImpJDBC;
import daoBooks.IGestionBook;
import daoHistory.GestionAddedImpJDBC;
import daoHistory.IGestionAdded;
import daoReturnBooks.GestionReturnBookImpJDBC;
import daoReturnBooks.IGestionReturnBook;
import metierBook.Book;
import metierHistory.History;

public class GestionBooks extends JFrame {
	
    public String receiveMessage(String messageUsername) {
        return messageUsername;
    }
    HistoryAddedModele HAddModele=new HistoryAddedModele();
	MembersModele MModele=new MembersModele();

    private JPanel pContainer = new JPanel();
    private JPanel pTitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pHome_Admin = new JPanel(new GridLayout(0,2)); 
    private JPanel pSidebar = new JPanel(new GridLayout(2,0));
    private JPanel pTopInsideSidebar = new JPanel(new GridLayout(0,1)); 

    private JPanel pInfos = new JPanel(new BorderLayout()); 
    private JPanel pRightInsideInfo = new JPanel(new BorderLayout()); 
    private JPanel pSearch = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    private JPanel pView = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pAdd = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pShowExplorebooks = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    private JPanel pShowReturnBooks = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    private JPanel pLogout = new JPanel(new FlowLayout(FlowLayout.CENTER)); 

    private JTextField txtSearch =new JTextField(10);

    private JLabel lblTitleView = new JLabel();
    private JLabel lblPublisherView = new JLabel();
    private JLabel lblCategoryView = new JLabel();
    private JLabel lblCoverPathView = new JLabel();
    
    private JButton btnShowExploreBooks = new JButton("");
    private JButton btnShowListBooks = new JButton("");
    private JButton btnLogout= new JButton("");
    private JButton btnSearch=new JButton("Search");
    private JButton btnView=new JButton("View");
    private JButton btnAdd=new JButton("Add");

	BooksModele BModele=new BooksModele();
	ReturnBooksModele RBModele=new ReturnBooksModele();
	private JTable tableau=new JTable(BModele);
	private JScrollPane jsp=new JScrollPane(tableau);
	private IGestionBook gestion;
	private IGestionReturnBook gestion2;

    public GestionBooks(String username,int IntCIN) {
        JLabel lblTitle = new JLabel();
        if(username.equals("EXPLORE BOOKS")||username.equals(null))
        	lblTitle.setText(username);
        else lblTitle.setText(username+", Enjoy your reading journey!");;
        initializeUI(lblTitle,IntCIN);
    }

    private void initializeUI(JLabel lbltitle, int IntCIN) {
        pContainer.setBackground(Color.decode("#D7E1DE"));
        btnSearch.setBackground(Color.decode("#3F4E4F"));
        btnSearch.setForeground(Color.decode("#D7E1DE"));
        btnView.setBackground(Color.decode("#3F4E4F"));
        btnView.setForeground(Color.decode("#D7E1DE"));
        btnAdd.setBackground(Color.decode("#3F4E4F"));
        btnAdd.setForeground(Color.decode("#D7E1DE"));
        pSidebar.setBorder(BorderFactory.createEmptyBorder(100, 20, 20, 0)); 
        btnLogout.setBackground(Color.decode("#C2C8C6"));
        btnShowListBooks.setBackground(Color.decode("#C2C8C6"));
        btnShowListBooks.setBackground(Color.decode("#C2C8C6"));        
        btnShowExploreBooks.setBackground(Color.decode("#C2C8C6"));
        btnShowExploreBooks.setBackground(Color.decode("#C2C8C6"));
        pSidebar.setBorder(BorderFactory.createEmptyBorder(100, 20, 20, 20)); 
        pSidebar.setBackground(Color.decode("#809B9D"));
        pShowExplorebooks.setOpaque(false);
        pShowReturnBooks.setOpaque(false);
        btnShowExploreBooks.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon iReturnSelect = new ImageIcon("assets/return.png");  
        ImageIcon iHome= new ImageIcon("assets/Home-selected.png");  
        ImageIcon iLogout= new ImageIcon("assets/Logout.png");  

        btnShowExploreBooks.setBorder(BorderFactory.createEmptyBorder()); 
        btnShowExploreBooks.setIcon(iHome);
        btnShowExploreBooks.setOpaque(false);
        
        btnShowListBooks.setBorder(BorderFactory.createEmptyBorder()); 
        btnShowListBooks.setOpaque(false);
        btnShowListBooks.setIcon(iReturnSelect);
        
        btnLogout.setBorder(BorderFactory.createEmptyBorder()); 
        btnLogout.setOpaque(false);
        btnLogout.setIcon(iLogout);
    	try {
	    	gestion=new GestionBookImpJDBC();
	    	gestion2=new GestionReturnBookImpJDBC();	

	    	lbltitle.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 35));
	    	lbltitle.setForeground(Color.decode("#3F4E4F"));
	        pContainer.setLayout(new BorderLayout());
	        /*************************************************************************/
	        pShowExplorebooks.add(btnShowExploreBooks);
	        pShowReturnBooks.add(btnShowListBooks);
	        /*************************************************************************/
	        pTopInsideSidebar.add(pShowExplorebooks);
	        pTopInsideSidebar.add(pShowReturnBooks);
	        pSidebar.add(pTopInsideSidebar);
	        pTopInsideSidebar.setOpaque(false);
	        pLogout.add(btnLogout);
	        pLogout.setOpaque(false);
	        pSidebar.add(pLogout);
	        /**************************************************************************/

	        lbltitle.setForeground(Color.decode("#C2C8C6"));
	        lbltitle.setBackground(Color.decode("#3F4E4F"));
	        lbltitle.setOpaque(true);

	        pTitle.add(lbltitle);
	        pHome_Admin.setLayout(new BoxLayout(pHome_Admin, BoxLayout.Y_AXIS)); 
	        pHome_Admin.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	        pHome_Admin.add(pTitle);
	        
	        pContainer.setBackground(Color.decode("#D7E1DE"));
	        pContainer.add(pSidebar,BorderLayout.WEST);

	        pSearch.add(txtSearch);
	        pSearch.add(btnSearch);
	        pView.add(btnView);
	        pAdd.add(btnAdd);

	        pRightInsideInfo.add(pSearch, BorderLayout.WEST);
	        pRightInsideInfo.add(pView, BorderLayout.CENTER);
	        pRightInsideInfo.add(pAdd, BorderLayout.AFTER_LINE_ENDS);

	        add(pContainer);
	        pHome_Admin.add(pInfos);
	        pInfos.add(jsp, BorderLayout.WEST);
	        pInfos.add(pRightInsideInfo,BorderLayout.CENTER);
	        
	        lblTitleView.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 35));
	        lblTitleView.setForeground(Color.decode("#3F4E4F"));
	        
	        lblPublisherView.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0)); 
	        lblPublisherView.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 15));
	        lblPublisherView.setForeground(Color.decode("#3F4E4F"));

	        lblCategoryView.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0)); 
	    	lblCategoryView.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 15));

	    	lblCoverPathView.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0)); 
	    	lblCoverPathView.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 25));

			btnSearch.addActionListener(e->{
				try {
					BModele.charger(gestion.rechercherParMC(txtSearch.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			btnView.addActionListener(e->{
				int index = tableau.getSelectedRow();
		        if (index != -1) {
		            Object value3 = BModele.getValueAt(index, 2);
		            Object value4 = BModele.getValueAt(index, 3);
		            Object value5 = BModele.getValueAt(index, 4);
		            Object value6 = BModele.getValueAt(index, 5);
		            lblTitleView.setText((String) value3);
			        lblPublisherView.setText((String) value4);
			        lblCategoryView.setText((String) value5);
			        //lblCoverPathView.setText((String) value6);
			        ImageIcon image= new ImageIcon((String) value6);  
			        lblCoverPathView.setBorder(BorderFactory.createEmptyBorder()); 
			        lblCoverPathView.setOpaque(false);
		            lblCoverPathView.setIcon(image);
		        }else {
					JOptionPane.showMessageDialog(this, "NO ROW SELECTED !!");
		        }
			});
		     btnAdd.addActionListener(e->{
			            try {
				            IGestionBook gestion;
				            IGestionReturnBook gestion2;

				            //IGestionMember gestionM;

							int index = tableau.getSelectedRow();
					        if (index != -1) {
					            Object value2 = BModele.getValueAt(index, 1);
					            Object value3 = BModele.getValueAt(index, 2);
					            Object value4 = BModele.getValueAt(index, 3);
					            Object value5 = BModele.getValueAt(index, 4);
					            Object value6 = BModele.getValueAt(index, 5);
					            Object value7 = BModele.getValueAt(index, 6);
					            int iValue2=(int) value2;
					            String iValue3=(String) value3;
					            String iValue4=(String) value4;
					            String iValue5=(String) value5;
					            String iValue6=(String) value6;
					            String iValue7=(String) value7;
					            gestion2 = new GestionReturnBookImpJDBC();
					            gestion = new GestionBookImpJDBC();
					            Book m = new Book(iValue2, iValue3, iValue4, iValue5, iValue6, iValue7);
					            gestion.supprimerBook(iValue2);

					            gestion2.ajouterBook(m);
					            /*PAUSE BOOK list*/

					            /* history*/				            
					            IGestionAdded gestionAdded;
					            gestionAdded = new GestionAddedImpJDBC();
					            History m2 = new History(iValue2, IntCIN, iValue5, iValue6);
					            gestionAdded.ajouterHistory(m2);
					            HAddModele.charger(gestionAdded.listeHistory());
					            
					            /*CONTINUE BOOK list*/
					            JOptionPane.showMessageDialog(this, "Book added successfully.");
					            RBModele.charger(gestion2.listeDesBooks());
					            BModele.charger(gestion.listeDesBooks());
					            
					        }else {
								JOptionPane.showMessageDialog(this, "NO ROW SELECTED !!");
					        } 

			            } catch (SQLException e1) {
			                JOptionPane.showMessageDialog(this, e1.getMessage());
			            }
			        });	   
		     tableau.getColumnModel().getColumn(5).setCellRenderer(new Renderer());
		     tableau.getColumnModel().getColumn(5).setPreferredWidth(180);
			BModele.charger(gestion.listeDesBooks());
			gestion.trierBookParNom();
			gestion2.trierBookParNom();

	        pContainer.add(pSidebar,BorderLayout.WEST);

	        pContainer.add(pHome_Admin,BorderLayout.CENTER);

	        btnLogout.addActionListener(e->{
	        		Window window = SwingUtilities.getWindowAncestor(btnLogout);
	        		window.dispose(); 
	                new GestionLogin().setVisible(true);
	        });
	        btnShowListBooks.addActionListener(e->{
	        		Window window = SwingUtilities.getWindowAncestor(btnShowListBooks);
	        		window.dispose(); 
	                new ReturnBooks(IntCIN).setVisible(true);
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

