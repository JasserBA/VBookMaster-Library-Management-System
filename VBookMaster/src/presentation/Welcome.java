package presentation;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import presentation_Admin.ModifyMembers_Admin;

public class Welcome extends JFrame {
    private JPanel pContainer = new JPanel(new BorderLayout());
    private JPanel pTitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pHome_Users = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pWelcomeMsg = new JPanel(new BorderLayout()); 
    private JPanel pBtn = new JPanel(new FlowLayout(FlowLayout.CENTER));

    private JLabel lbldesTitle = new JLabel("Welcome to VBooksMaster !");

    private JButton btnGetIn = new JButton("Get in");
    public Welcome(String username, int IntCIN) {
        JLabel lblTitle = new JLabel("Hi " + username + "!");
        initializeUI(lblTitle,username,IntCIN);
    }

    private void initializeUI(JLabel lbltitle,String username, int IntCIN) {
        try {
            lbltitle.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 35));
            lbltitle.setForeground(Color.decode("#3F4E4F"));
            lbltitle.setBackground(Color.decode("#D7E1DE"));
            lbltitle.setOpaque(true);

            pTitle.add(lbltitle);
            pContainer.setBackground(Color.decode("#D7E1DE"));
            pContainer.setBorder(BorderFactory.createEmptyBorder(150, 150,150, 150));  
            lbldesTitle.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 35));
            lbldesTitle.setForeground(Color.decode("#3F4E4F"));
            btnGetIn.setBackground(Color.decode("#3F4E4F"));
            btnGetIn.setForeground(Color.decode("#D7E1DE"));
            btnGetIn.setBorder(BorderFactory.createEmptyBorder(10,20, 10,20));

            pWelcomeMsg.add(lbldesTitle,BorderLayout.NORTH);
            pBtn.add(btnGetIn,BorderLayout.SOUTH);
            pWelcomeMsg.add(pBtn);
            pHome_Users.add(lbltitle);
            pWelcomeMsg.setBorder(BorderFactory.createEmptyBorder(200, 0,0,0));  
            pHome_Users.setBorder(BorderFactory.createEmptyBorder(50,50, 0,0));  
            pBtn.setBorder(BorderFactory.createEmptyBorder(20,0, 0,0));
            pContainer.add(pHome_Users,BorderLayout.WEST);

            pContainer.add(pWelcomeMsg,BorderLayout.CENTER);
            
            add(pContainer);
            btnGetIn.addActionListener(e->{
        		Window window = SwingUtilities.getWindowAncestor(btnGetIn);
        		window.dispose();
                new GestionBooks(username,IntCIN).setVisible(true);
            });
            setSize(1200, 850);
            setTitle("Welcome");
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setVisible(true);
            setResizable(false);
            setLocationRelativeTo(null);       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
