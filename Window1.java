package RetailStore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

public class Window1 {

    private JFrame frame;
    private JTextField productIdField, nameField, descriptionField, priceField, stockField;
    private ProductCatalog productCatalog;

    public Window1(ProductCatalog catalog) {
        this.productCatalog = catalog;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Manage Products");
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblProductId = new JLabel("Product ID:");
        lblProductId.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblProductId.setBounds(41, 94, 106, 25);
        frame.getContentPane().add(lblProductId);

        productIdField = new JTextField();
        productIdField.setBounds(170, 97, 308, 25);
        frame.getContentPane().add(productIdField);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
        lblName.setBounds(60, 133, 87, 25);
        frame.getContentPane().add(lblName);

        nameField = new JTextField();
        nameField.setBounds(170, 133, 308, 25);
        frame.getContentPane().add(nameField);

        JLabel lblDescription = new JLabel("Description:");
        lblDescription.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblDescription.setBounds(26, 169, 121, 25);
        frame.getContentPane().add(lblDescription);

        descriptionField = new JTextField();
        descriptionField.setBounds(170, 169, 308, 25);
        frame.getContentPane().add(descriptionField);

        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
        lblPrice.setBounds(60, 205, 100, 25);
        frame.getContentPane().add(lblPrice);

        priceField = new JTextField();
        priceField.setBounds(170, 205, 308, 25);
        frame.getContentPane().add(priceField);

        JLabel lblStock = new JLabel("Stock:");
        lblStock.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
        lblStock.setBounds(60, 246, 100, 25);
        frame.getContentPane().add(lblStock);

        stockField = new JTextField();
        stockField.setBounds(170, 246, 308, 25);
        frame.getContentPane().add(stockField);

        JButton addButton = new JButton("Add");
        addButton.setBackground(new Color(251, 251, 242));
        addButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
        addButton.setForeground(new Color(158, 250, 198));
        addButton.setBounds(10, 310, 150, 30);
        frame.getContentPane().add(addButton);

        JButton removeButton = new JButton("Remove");
        removeButton.setBackground(new Color(251, 251, 242));
        removeButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
        removeButton.setForeground(new Color(252, 165, 165));
        removeButton.setBounds(170, 310, 150, 30);
        frame.getContentPane().add(removeButton);

        JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(251, 251, 242));
        updateButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
        updateButton.setForeground(new Color(252, 235, 182));
        updateButton.setBounds(328, 310, 150, 30);
        frame.getContentPane().add(updateButton);
        
        JLabel lblNewLabel_1 = new JLabel("RmanageR");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(113, 189, 132));
        lblNewLabel_1.setFont(new Font("Lucida Sans", Font.BOLD, 30));
        lblNewLabel_1.setBounds(151, 36, 188, 34);
        frame.getContentPane().add(lblNewLabel_1);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productId = productIdField.getText();
                String name = nameField.getText();
                String description = descriptionField.getText();
                double price = Double.parseDouble(priceField.getText());
                int stock = Integer.parseInt(stockField.getText());
                productCatalog.addProduct(new Product(productId, name, description, price, stock));
                JOptionPane.showMessageDialog(frame, "Product Added!");
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productId = productIdField.getText();
                productCatalog.removeProduct(productId);
                JOptionPane.showMessageDialog(frame, "Product Removed!");
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productId = productIdField.getText();
                String name = nameField.getText();
                String description = descriptionField.getText();
                double price = Double.parseDouble(priceField.getText());
                int stock = Integer.parseInt(stockField.getText());
                productCatalog.updateProduct(productId, new Product(productId, name, description, price, stock));
                JOptionPane.showMessageDialog(frame, "Product Updated!");
            }
        });

        frame.setVisible(true);
    }
}
