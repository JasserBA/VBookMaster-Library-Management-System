package presentation_Admin;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.*;

import daoHistory.GestionAddedImpJDBC;
import daoHistory.GestionReturnedImpJDBC;
import daoHistory.IGestionAdded;
import daoHistory.IGestionReturned;
import presentation.GestionLogin;
import presentation.Renderer;
import TableModeles.HistoryAddedModele;

public class History_Admin extends JFrame {
    private JPanel pContainer = new JPanel();
    private JPanel pTitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pHome_Admin = new JPanel(new GridLayout(0,2)); 
    private JPanel pSidebar = new JPanel(new GridLayout(2,0));
    private JPanel pTopInsideSidebar = new JPanel(new GridLayout(0,1)); 
    private JPanel pInfos = new JPanel(new BorderLayout()); 
    private JPanel pAdded = new JPanel(new BorderLayout()); 
    private JPanel pReturned = new JPanel(new BorderLayout()); 
    private JPanel pRightInsideInfo = new JPanel(new BorderLayout()); 
    private JPanel pShowListMembers = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    private JPanel pShowIinfosView = new JPanel();
    private JPanel pShowHistory= new JPanel();
    private JPanel pLogout = new JPanel(new FlowLayout(FlowLayout.CENTER)); 

    private JLabel lblTTitle = new JLabel("History_Admin");
    private JLabel lblTitleAdded = new JLabel("~~~~ Books-Added ~~~~");
    private JLabel lblTitleReturned = new JLabel("~~~~ Books-Returned ~~~~");
    
    private JButton btnShowListMembers = new JButton();
    private JButton btnShowListBooks = new JButton();
    private JButton btnShowHistory = new JButton();
    private JButton btnLogout= new JButton();

	HistoryAddedModele HAddedModele=new HistoryAddedModele();
	private JTable tableau=new JTable(HAddedModele);
	private JScrollPane jsp=new JScrollPane(tableau);
	private IGestionAdded gestion;

	HistoryAddedModele HReturnedModele=new HistoryAddedModele();
	private JTable tableauReturn=new JTable(HReturnedModele);
	private JScrollPane jspReturn=new JScrollPane(tableauReturn);
	private IGestionReturned gestionReturn;
	
	    private JPanel pForm = new JPanel(new GridLayout(0, 2, 5, 5));

	    public History_Admin() {
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
        pShowIinfosView.setOpaque(false);
        pLogout.setOpaque(false);
        pLogout.setOpaque(false);
        pShowListMembers.setOpaque(false);
        pSidebar.setBorder(BorderFactory.createEmptyBorder(100, 20, 20, 20)); 
        pSidebar.setBackground(Color.decode("#809B9D"));
        
        ImageIcon iReturnSelect = new ImageIcon("assets/add.png");  
        ImageIcon iHome= new ImageIcon("assets/members.png");  
        ImageIcon iLogout= new ImageIcon("assets/Logout.png");  
        ImageIcon iHistory= new ImageIcon("assets/history-selected.png");  

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

    	try {
    		
	    	gestion=new GestionAddedImpJDBC();	
	    	gestionReturn=new GestionReturnedImpJDBC();	

	        pContainer.setBackground(Color.decode("#D7E1DE"));
	        btnLogout.setBackground(Color.decode("#C2C8C6"));
	        btnShowListBooks.setBackground(Color.decode("#C2C8C6"));
	        btnShowListMembers.setBackground(Color.decode("#C2C8C6"));
	        btnShowHistory.setBackground(Color.decode("#C2C8C6"));
	        pShowListMembers.setOpaque(false);
	        pForm.setOpaque(false);
	        pTitle.setOpaque(false);
	        pHome_Admin.setOpaque(false);
	        pTopInsideSidebar.setOpaque(false);
	        pInfos.setOpaque(false);
	        pRightInsideInfo.setOpaque(false);
	        pShowIinfosView.setOpaque(false);
	        pLogout.setOpaque(false);
	        pShowHistory.setOpaque(false);
	        lblTTitle.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 35));
	        lblTTitle.setForeground(Color.decode("#F06E6E"));
	        lblTitleAdded.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 25));
	        lblTitleAdded.setForeground(Color.decode("#3F4E4F"));	        
	        lblTitleReturned.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 25));
	        lblTitleReturned.setForeground(Color.decode("#3F4E4F"));
	        pContainer.setLayout(new BorderLayout());
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
	        pAdded.add(lblTitleAdded, BorderLayout.NORTH);
	        pAdded.add(jsp, BorderLayout.CENTER);
	        
	        pReturned.add(lblTitleReturned, BorderLayout.NORTH);
	        pReturned.add(jspReturn, BorderLayout.CENTER);
	        
	        pContainer.setBackground(Color.decode("#D7E1DE"));
	        
	        pForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	        add(pContainer);
	        pInfos.add(pAdded, BorderLayout.NORTH);
	        pInfos.add(pReturned, BorderLayout.CENTER);
	        pHome_Admin.add(pInfos);
	        pForm.setVisible(false);
	        
		     tableau.getColumnModel().getColumn(4).setCellRenderer(new Renderer());
		     tableau.getColumnModel().getColumn(4).setPreferredWidth(180);
		     
		     tableauReturn.getColumnModel().getColumn(4).setCellRenderer(new Renderer());
		     tableauReturn.getColumnModel().getColumn(4).setPreferredWidth(180);
		     
	        HAddedModele.charger(gestion.listeHistory());
	        HReturnedModele.charger(gestionReturn.listeHistory());
	        
	        pContainer.add(pSidebar,BorderLayout.WEST);
	        
	        pContainer.add(pHome_Admin,BorderLayout.CENTER);
	        
	       
	        btnLogout.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		Window window = SwingUtilities.getWindowAncestor(btnLogout);
	        		window.dispose();  
	                new GestionLogin().setVisible(true);
	            }
	        });
	        
	        btnShowListBooks.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		Window window = SwingUtilities.getWindowAncestor(btnShowListMembers);
	        		window.dispose();  
	                new ModifyBooks_Admin().setVisible(true);
	            }
	        });
	        
	        btnShowHistory.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		Window window = SwingUtilities.getWindowAncestor(btnShowListMembers);
	        		window.dispose();  
	                new History_Admin().setVisible(true);
	            }
	        });

	        btnShowListMembers.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		Window window = SwingUtilities.getWindowAncestor(btnShowListMembers);
	        		window.dispose();  
	                new ModifyMembers_Admin().setVisible(true);
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
