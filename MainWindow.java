package RetailStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class MainWindow {

    private JFrame frame;
    private ProductCatalog productCatalog;
    private ShoppingCart shoppingCart;
    private List<Order> orderHistory;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainWindow window = new MainWindow();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public MainWindow() {
        productCatalog = new ProductCatalog();
        shoppingCart = new ShoppingCart();
        orderHistory = new ArrayList<>();
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Retail Store Management");
        frame.getContentPane().setBackground(new Color(249, 254, 226));
        frame.setBounds(100, 100, 615, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblLogo = new JLabel("");
        lblLogo.setBounds(271, 0, 56, 50);
        frame.getContentPane().add(lblLogo);

        try {
            ImageIcon icon = new ImageIcon(MainWindow.class.getResource("/images/logo.png"));
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
            lblLogo.setIcon(new ImageIcon(scaledImg));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton btnManageProducts = new JButton("Manage Products");
        btnManageProducts.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
        frame.getContentPane().add(btnManageProducts);
        btnManageProducts.setBounds(393, 93, 200, 100);
        btnManageProducts.setBackground(new Color(247, 213, 218));

        JButton btnViewProducts = new JButton("View Products");
        btnViewProducts.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
        frame.getContentPane().add(btnViewProducts);
        btnViewProducts.setBounds(393, 204, 200, 100);
        btnViewProducts.setBackground(new Color(217, 211, 248));

        JButton btnProductCatalog = new JButton("Product Catalog");
        btnProductCatalog.setBackground(new Color(208, 231, 184));
        btnProductCatalog.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        frame.getContentPane().add(btnProductCatalog);
        btnProductCatalog.setBounds(10, 93, 200, 100);

        JLabel lblNewLabel = new JLabel("SEE PRODUCTS");
        lblNewLabel.setForeground(new Color(65, 135, 126));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        lblNewLabel.setBounds(10, 24, 200, 50);
        frame.getContentPane().add(lblNewLabel);

        JButton btnViewPurchaseHistory = new JButton("Order History");
        btnViewPurchaseHistory.setBackground(new Color(182, 233, 232));
        btnViewPurchaseHistory.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        btnViewPurchaseHistory.setBounds(10, 204, 200, 100);
        frame.getContentPane().add(btnViewPurchaseHistory);

        JLabel lblManageProducts = new JLabel("MANAGE PRODUCTS");
        lblManageProducts.setHorizontalAlignment(SwingConstants.CENTER);
        lblManageProducts.setForeground(new Color(65, 135, 126));
        lblManageProducts.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
        lblManageProducts.setBounds(393, 24, 200, 50);
        frame.getContentPane().add(lblManageProducts);

        btnProductCatalog.addActionListener(e -> {
            ProductCatalogView catalogView = new ProductCatalogView(productCatalog, shoppingCart, new OrderQueue(), orderHistory);
            catalogView.display();
        });

        btnViewProducts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Window2(productCatalog);
            }
        });

        btnManageProducts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Window1(productCatalog);
            }
        });

        btnViewPurchaseHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrderHistoryView orderHistoryView = new OrderHistoryView(orderHistory);
                orderHistoryView.display();
            }
        });
    }
}
