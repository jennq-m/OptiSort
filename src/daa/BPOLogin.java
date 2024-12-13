package daa;

import java.awt.*; // Imports all classes from the java.awt package for AWT components
import javax.swing.*; // Imports all classes from the javax.swing package for GUI components
import java.util.Stack; // Imports the Stack class for stack data structure

public class BPOLogin extends javax.swing.JFrame {
    
    private final Stack<JFrame> frameStack; // Stack to manage the navigation of JFrame instances
    
    public BPOLogin(Stack<JFrame> frameStack) {  // Constructor for the BPOLogin class       
        this.frameStack = frameStack; // Assign the parameter to the instance variable
        initComponents(); // Initializes and sets up the components for the GUI
        
        setIconImage(); // Function call to set the title bar logo
        setSize(1000, 700); // Set the size of the JFrame to 1000x700 pixels
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application when the JFrame is close
        setLocationRelativeTo(null); // Center the JFrame on the screen
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        poster = new javax.swing.JLabel();
        staffNameLabel = new javax.swing.JLabel();
        staffNameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        welcomeLabel = new javax.swing.JLabel();
        welcomeLabel2 = new javax.swing.JLabel();
        contactLabel = new javax.swing.JLabel();
        smallLogo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        forgotPass = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OptiSort Solutions - Application System");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 700));

        poster.setBackground(new java.awt.Color(255, 255, 255));
        poster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Poster.png"))); // NOI18N

        staffNameLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        staffNameLabel.setText("Staff Name");

        staffNameField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        passwordLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        passwordLabel.setText("Password");

        passwordField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        loginButton.setBackground(new java.awt.Color(33, 89, 129));
        loginButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Log In");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        welcomeLabel.setFont(new java.awt.Font("Arial", 1, 38)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(33, 89, 129));
        welcomeLabel.setText("WELCOME BACK!");

        welcomeLabel2.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        welcomeLabel2.setText("Please log in to continue.");

        contactLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        contactLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contactLabel.setText("Need help? Contact support at support@optisort.com");

        smallLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/SmallLogo.png"))); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));

        forgotPass.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        forgotPass.setText("Forgot Password?");
        forgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotPassMouseExited(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setMinimumSize(new java.awt.Dimension(50, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(staffNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(staffNameField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addComponent(contactLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(welcomeLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(smallLogo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(forgotPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(poster)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(poster)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(smallLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(welcomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(welcomeLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(staffNameLabel)
                        .addGap(0, 0, 0)
                        .addComponent(staffNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(passwordLabel)
                        .addGap(0, 0, 0)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forgotPass)
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(contactLabel)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        
        String staffName = staffNameField.getText(); // Get the text from the staff name field
        BPOApplication application = new BPOApplication(frameStack); // Instantiate the BPOApplication class
        String password = new String(passwordField.getPassword()); // Get the password from the password field
        
        if (staffName.length() == 0) { // Check if there is any input in the staffNameField
            JOptionPane.showMessageDialog(this, "Please input a staff name.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if ("admin".equals(password)) { // Check if the password is "admin"
                frameStack.push(application);
                this.setVisible(false);
                application.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "The password you’ve entered is incorrect.", "Error", JOptionPane.ERROR_MESSAGE); // Show error message if password is incorrect
            }
        }           
    }//GEN-LAST:event_loginButtonActionPerformed

    private void forgotPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPassMouseClicked
         JOptionPane.showMessageDialog(this, "Password: admin", "Password", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_forgotPassMouseClicked

    private void forgotPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPassMouseEntered
        Font boldFont = new Font("Arial", Font.BOLD | Font.ITALIC, 14);
        forgotPass.setFont(boldFont);
    }//GEN-LAST:event_forgotPassMouseEntered

    private void forgotPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPassMouseExited
        Font italicFont = new Font("Arial", Font.ITALIC, 14);
        forgotPass.setFont(italicFont);
    }//GEN-LAST:event_forgotPassMouseExited
    
    // Method for setting the title bar's icon 
    private void setIconImage() { 
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/Logo.png")));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contactLabel;
    private javax.swing.JLabel forgotPass;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel poster;
    private javax.swing.JLabel smallLogo;
    private javax.swing.JTextField staffNameField;
    private javax.swing.JLabel staffNameLabel;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel welcomeLabel2;
    // End of variables declaration//GEN-END:variables
}