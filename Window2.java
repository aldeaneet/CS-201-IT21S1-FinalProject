package RetailStore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

public class Window2 {

    private JFrame frame;
    private JTextField productIdField;
    private JTextArea displayArea;
    private ProductCatalog productCatalog;

    public Window2(ProductCatalog catalog) {
        this.productCatalog = catalog;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("View Products");
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblProductId = new JLabel("Product ID:");
        lblProductId.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblProductId.setBounds(20, 20, 100, 25);
        frame.getContentPane().add(lblProductId);

        productIdField = new JTextField();
        productIdField.setBounds(130, 20, 150, 25);
        frame.getContentPane().add(productIdField);

        JButton searchButton = new JButton("Search Product");
        searchButton.setBackground(new Color(255, 255, 200));
        searchButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
        searchButton.setBounds(300, 20, 150, 25);
        frame.getContentPane().add(searchButton);

        displayArea = new JTextArea();
        displayArea.setBounds(20, 60, 430, 250);
        displayArea.setEditable(false);
        frame.getContentPane().add(displayArea);

        JButton viewAllButton = new JButton("Display All");
        viewAllButton.setBackground(new Color(247, 227, 251));
        viewAllButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
        viewAllButton.setBounds(150, 320, 200, 25);
        frame.getContentPane().add(viewAllButton);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productId = productIdField.getText();
                Product product = productCatalog.getProduct(productId);
                if (product != null) {
                    displayArea.setText(product.toString());
                } else {
                    displayArea.setText("Product not found.");
                }
            }
        });

        viewAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder allProducts = new StringBuilder();
                for (Product product : productCatalog.getCatalog().values()) {
                    allProducts.append(product.toString()).append("\n------------\n");
                }
                displayArea.setText(allProducts.toString());
            }
        });

        frame.setVisible(true);
    }
}
