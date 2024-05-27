package presentation;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;

import TableModeles.BooksModele;
import TableModeles.HistoryAddedModele;
import TableModeles.ReturnBooksModele;
import daoBooks.GestionBookImpJDBC;
import daoBooks.IGestionBook;
import daoHistory.GestionAddedImpJDBC;
import daoHistory.GestionReturnedImpJDBC;
import daoHistory.IGestionAdded;
import daoHistory.IGestionReturned;
import daoReturnBooks.GestionReturnBookImpJDBC;
import daoReturnBooks.IGestionReturnBook;
import metierBook.Book;
import metierHistory.History;

public class ReturnBooks extends JFrame {
	
    public String receiveMessage(String messageUsername) {
        return messageUsername;
    }
    private JPanel pContainer = new JPanel();
    private JPanel pTitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pHome_Admin = new JPanel(new GridLayout(0,2)); 
    private JPanel pSidebar = new JPanel(new GridLayout(2,0));
    private JPanel pTopInsideSidebar = new JPanel(new GridLayout(0,1)); 

    private JPanel pInfos = new JPanel(new BorderLayout()); 
    private JPanel pRightInsideInfo = new JPanel(new BorderLayout()); 
    private JPanel pSearch = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    private JPanel pView = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pExport= new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
    private JPanel pShowExplorebooks = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    private JPanel pShowReturnBooks = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    private JPanel pLogout = new JPanel(new FlowLayout(FlowLayout.CENTER)); 

    private JTextField txtSearch =new JTextField(10);
    
    private JLabel lblTitle= new JLabel("RETURN BOOKS");
    
    private JButton btnShowExploreBooks = new JButton("");
    private JButton btnShowListBooks = new JButton("");
    private JButton btnLogout= new JButton("");
    private JButton btnSearch=new JButton("Search");
    private JButton btnReturn=new JButton("Return");
    private JButton btnExport=new JButton("Export");
    
    HistoryAddedModele HReturnedModele=new HistoryAddedModele();
    ReturnBooksModele RBModele=new ReturnBooksModele();
    BooksModele BModele=new BooksModele();

	private JTable tableau=new JTable(RBModele);
	private JScrollPane jsp=new JScrollPane(tableau);
	private IGestionReturnBook gestion2;

    public ReturnBooks(int IntCIN) {
        initializeUI(IntCIN);
    }

    private void initializeUI(int IntCIN) {
        pContainer.setBackground(Color.decode("#D7E1DE"));
        btnSearch.setBackground(Color.decode("#3F4E4F"));
        btnSearch.setForeground(Color.decode("#D7E1DE"));
        btnReturn.setBackground(Color.decode("#3F4E4F"));
        btnReturn.setForeground(Color.decode("#D7E1DE"));        
        btnExport.setBackground(Color.decode("#C2C8C6"));
        btnExport.setForeground(Color.decode("#3F4E4F"));
        pSidebar.setBorder(BorderFactory.createEmptyBorder(100, 20, 20, 20)); 
        pSidebar.setBackground(Color.decode("#809B9D"));
        btnLogout.setBackground(Color.decode("#C2C8C6"));
        btnShowListBooks.setBackground(Color.decode("#C2C8C6"));
        btnShowListBooks.setBackground(Color.decode("#C2C8C6"));  
        
        ImageIcon iReturnSelect = new ImageIcon("assets/return-selected.png");  
        ImageIcon iHome= new ImageIcon("assets/Home.png");  
        ImageIcon iLogout= new ImageIcon("assets/Logout.png");  

        // Set the icon on the button
        btnShowExploreBooks.setBorder(BorderFactory.createEmptyBorder()); 
        btnShowExploreBooks.setIcon(iHome);
        btnShowExploreBooks.setOpaque(false);
        
        btnShowListBooks.setBorder(BorderFactory.createEmptyBorder()); 
        btnShowListBooks.setOpaque(false);
        btnShowListBooks.setIcon(iReturnSelect);
        
        btnLogout.setBorder(BorderFactory.createEmptyBorder()); 
        btnLogout.setOpaque(false);
        btnLogout.setIcon(iLogout);

        btnShowExploreBooks.setBackground(Color.decode("#C2C8C6"));
        pShowExplorebooks.setOpaque(false);
        pShowReturnBooks.setOpaque(false);
        pTopInsideSidebar.setOpaque(false);
        pLogout.setOpaque(false);
    	try {
	    	gestion2=new GestionReturnBookImpJDBC();	
	        pContainer.setLayout(new BorderLayout());
	        /*************************************************************************/
	        pShowExplorebooks.add(btnShowExploreBooks);
	        pShowReturnBooks.add(btnShowListBooks);
	        /*************************************************************************/
	        pTopInsideSidebar.add(pShowExplorebooks);
	        pTopInsideSidebar.add(pShowReturnBooks);
	        pSidebar.add(pTopInsideSidebar);
	        pLogout.add(btnLogout);
	        pSidebar.add(pLogout);
	        /**************************************************************************/
	        lblTitle.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 35));
	        lblTitle.setForeground(Color.decode("#3F4E4F"));
	        lblTitle.setForeground(Color.decode("#C2C8C6"));
	        lblTitle.setBackground(Color.decode("#3F4E4F"));
	        lblTitle.setOpaque(true);

	        pTitle.add(lblTitle);
	        pHome_Admin.setLayout(new BoxLayout(pHome_Admin, BoxLayout.Y_AXIS)); 
	        pHome_Admin.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	        pHome_Admin.add(pTitle);
	        
	        pContainer.setBackground(Color.decode("#D7E1DE"));
	        pContainer.add(pSidebar,BorderLayout.WEST);

	        pSearch.add(txtSearch);
	        pSearch.add(btnSearch);
	        pView.add(btnReturn);
	        pExport.add(btnExport);
	        pRightInsideInfo.add(pSearch, BorderLayout.WEST);
	        pRightInsideInfo.add(pView, BorderLayout.CENTER);
	        pRightInsideInfo.add(pExport, BorderLayout.EAST);
	        add(pContainer);
	        pHome_Admin.add(pInfos);
	        pInfos.add(jsp, BorderLayout.WEST);
	        pInfos.add(pRightInsideInfo,BorderLayout.CENTER);
	        
			btnSearch.addActionListener(e->{
				try {
			    	if (txtSearch.getText().equals("")) {
			    		RBModele.charger(gestion2.listeDesBooks());
			    	}
					RBModele.charger(gestion2.rechercherParMC(txtSearch.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			  btnReturn.addActionListener(e->{
		            try {
			            IGestionBook gestion;
						int index = tableau.getSelectedRow();
				        if (index != -1) {
				            Object value2 = RBModele.getValueAt(index, 1);
				            Object value3 = RBModele.getValueAt(index, 2);
				            Object value4 = RBModele.getValueAt(index, 3);
				            Object value5 = RBModele.getValueAt(index, 4);
				            Object value6 = RBModele.getValueAt(index, 5);
				            Object value7 = RBModele.getValueAt(index, 6);
				            int iValue2=(int) value2;
				            String iValue3=(String) value3;
				            String iValue4=(String) value4;
				            String iValue5=(String) value5;
				            String iValue6=(String) value6;
				            String iValue7=(String) value7;
				            gestion = new GestionBookImpJDBC();
				            
				            Book m = new Book(iValue2, iValue3, iValue4, iValue5, iValue6, iValue7);
				            gestion.ajouterBook(m);
				            JOptionPane.showMessageDialog(this, "Book return successfully.");
				            RBModele.charger(gestion2.listeDesBooks());
							/*delete*/
							int BookID=(int)RBModele.getValueAt(index, 1);
							try {
								gestion2.supprimerBook(BookID);
					            /*PAUSE listADDED*/

					            /* history*/				            
					            IGestionReturned gestionReturned;
					            gestionReturned = new GestionReturnedImpJDBC();
					            History m2 = new History(iValue2, IntCIN, iValue5, iValue6);
					            gestionReturned.ajouterHistory(m2);
					            HReturnedModele.charger(gestionReturned.listeHistory());
					            /*CONTINUE listADDED*/
								RBModele.charger(gestion2.listeDesBooks());
								BModele.charger(gestion.listeDesBooks());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(this, e1.getMessage());
							}
				        }else {
							JOptionPane.showMessageDialog(this, "NO ROW SELECTED !!");
				        } 

		            } catch (SQLException e1) {
		                JOptionPane.showMessageDialog(this, e1.getMessage());
		            }
		            

		        });	       
			     tableau.getColumnModel().getColumn(5).setCellRenderer(new Renderer());
			     tableau.getColumnModel().getColumn(5).setPreferredWidth(180);
			RBModele.charger(gestion2.listeDesBooks());
			gestion2.trierBookParNom();
	        pContainer.add(pSidebar,BorderLayout.WEST);

	        pContainer.add(pHome_Admin,BorderLayout.CENTER);
	        
	        btnLogout.addActionListener(e->{
	        		Window window = SwingUtilities.getWindowAncestor(btnLogout);
	        		window.dispose(); 
	                new GestionLogin().setVisible(true);
	        });
	        btnShowExploreBooks.addActionListener(e->{
	        		Window window = SwingUtilities.getWindowAncestor(btnShowListBooks);
	        		window.dispose(); 
	                new GestionBooks("EXPLORE BOOKS",IntCIN).setVisible(true);
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

