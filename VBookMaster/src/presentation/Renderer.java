package presentation;

import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Renderer extends DefaultTableCellRenderer {
    JLabel lbl = new JLabel();

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        
        String imagePath = (String) value;
        ImageIcon icon = new ImageIcon(imagePath);
        
        table.setRowHeight(200);

        lbl.setBorder(BorderFactory.createEmptyBorder());
        lbl.setIcon(icon);
        lbl.setOpaque(false);
        
        return lbl;
    }
}
