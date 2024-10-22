package RetailStore;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;

public class MainWindow {

    private JFrame frame;
    private ProductCatalog productCatalog;

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
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(251, 251, 242));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnOpenWindow1 = new JButton("Manage Products");
        btnOpenWindow1.setBackground(new Color(247, 213, 218));
        btnOpenWindow1.setBounds(50, 204, 150, 50);
        btnOpenWindow1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Window1(productCatalog); 
            }
        });
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(btnOpenWindow1);

        JButton btnOpenWindow2 = new JButton("View Products");
        btnOpenWindow2.setBackground(new Color(217, 211, 248));
        btnOpenWindow2.setBounds(250, 204, 150, 50);
        btnOpenWindow2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Window2(productCatalog); 
            }
        });
        frame.getContentPane().add(btnOpenWindow2);

        JLabel lblLogo = new JLabel("");
        lblLogo.setBounds(200, 20, 50, 50);
        frame.getContentPane().add(lblLogo);

        try {
            ImageIcon icon = new ImageIcon(MainWindow.class.getResource("/images/logo.png"));
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
            lblLogo.setIcon(new ImageIcon(scaledImg));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblNewLabel = new JLabel("RmanageR alpha 1.0");
        lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 10));
        lblNewLabel.setBounds(10, 11, 100, 24);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("RmanageR");
        lblNewLabel_1.setForeground(new Color(113, 189, 132));
        lblNewLabel_1.setFont(new Font("Lucida Sans", Font.BOLD, 30));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(124, 108, 188, 34);
        frame.getContentPane().add(lblNewLabel_1);
    }
}
