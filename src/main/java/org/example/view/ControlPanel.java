package org.example.view;

import org.example.controller.Controller;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ControlPanel extends JPanel {
    private final DefaultTableModel tableModel;

    public ControlPanel() {
        setLayout(new BorderLayout());

        setBorder(new CompoundBorder(
                new TitledBorder(new LineBorder(new Color(60, 63, 65), 2), "Details Panel"),
                new EmptyBorder(10, 10, 10, 10)
        ));
        // Table Model (6 Rows, Non-Editable)
        String[] columnNames = {"Parameter", "Value"};
        Object[][] data = {
                {"Total Resources", "0"},
                {"Total Producers", "0"},
                {"Total Consumers", "0"},
                {"Started At", "0"},
                {"Synchronized", "Default"},
                {"Stock Control", "Default"},
                {"Threads #", "Swing only"}
        };

        tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Disable editing
            }
        };

        JTable leftTable = new JTable(tableModel);
        styleTable(leftTable); // 🔥 Apply custom styles

        JScrollPane leftScrollPane = new JScrollPane(leftTable);
        leftScrollPane.setBorder(new LineBorder(new Color(150, 150, 150), 1));
        add(leftScrollPane, BorderLayout.CENTER);

        // Buttons for the left panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 5, 5)); // 2x2 grid for buttons
        buttonPanel.setPreferredSize(new Dimension(200, 100)); // Fixed height
        buttonPanel.add(new ButtonPlay());
        buttonPanel.add(new ButtonStop());
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void updateRow() {
        tableModel.setValueAt(Controller.getInstance().getModel().getTotalResources(), 0, 1);
        tableModel.setValueAt(Controller.getInstance().getModel().getProducers().size(), 1, 1);
        tableModel.setValueAt(Controller.getInstance().getModel().getConsumers().size(), 2, 1);
        tableModel.setValueAt(Controller.getInstance().getModel().toString(), 3, 1);
        tableModel.setValueAt(Controller.getInstance().getModel().isSynchronize() ? "Yes" : "No", 4, 1);
       // tableModel.setValueAt(Controller.getInstance().getModel().isSynchronize() ? "Yes" : "No", 4, 1);
        int x = Controller.getInstance().getModel().getThreadConsumer().size() + Controller.getInstance().getModel().getThreadProducers().size();
        tableModel.setValueAt(x, 6, 1);
    }

    private void styleTable(JTable table) {
        table.setRowHeight(25);

        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(60, 63, 65));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setSelectionBackground(new Color(184, 207, 229));
        table.setGridColor(new Color(200, 200, 200));

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE);
                ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER);
                return c;
            }
        };

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }
}
