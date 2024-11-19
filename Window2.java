package RetailStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class Window2 {

    private JFrame frame;
    private JTextField productIdField;
    private JTextArea displayArea;
    private ProductCatalog productCatalog;
    private JButton btnDisplayAll;

    public Window2(ProductCatalog catalog) {
        this.productCatalog = catalog;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("View Products");
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Label for Product ID
        JLabel lblProductId = new JLabel("Product ID:");
        lblProductId.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblProductId.setBounds(20, 20, 100, 25);
        frame.getContentPane().add(lblProductId);

        // Text field to enter Product ID
        productIdField = new JTextField();
        productIdField.setBounds(130, 20, 150, 25);
        frame.getContentPane().add(productIdField);

        // Button to search for a product
        JButton searchButton = new JButton("Search Product");
        searchButton.setBackground(new Color(255, 255, 200));
        searchButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
        searchButton.setBounds(300, 20, 150, 25);
        frame.getContentPane().add(searchButton);

        // Text area to display product details
        displayArea = new JTextArea();
        displayArea.setBounds(20, 60, 430, 250);
        displayArea.setEditable(false);
        frame.getContentPane().add(displayArea);

        // Button to display all products
        btnDisplayAll = new JButton("Display All");
        btnDisplayAll.setBackground(new Color(247, 227, 251));
        btnDisplayAll.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
        btnDisplayAll.setBounds(150, 320, 200, 25);
        frame.getContentPane().add(btnDisplayAll);

        // Action listener for searching a product by ID
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

        // Action listener for displaying all products in the catalog
        btnDisplayAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder allProducts = new StringBuilder();
                Collection<Product> products = productCatalog.getCatalog().values(); // Correctly get the values
                for (Product product : products) {  // Iterate over the collection
                    allProducts.append(product.toString()).append("\n------------\n");
                }
                if (allProducts.length() == 0) {
                    displayArea.setText("No products available.");
                } else {
                    displayArea.setText(allProducts.toString());
                }
            }
        });

        // Set the window visible
        frame.setVisible(true);
    }
}
