package daa;

import java.awt.*; // Imports all classes from the java.awt package for AWT components
import javax.swing.*; // Imports all classes from the javax.swing package for GUI components
import java.util.Stack; // Imports the Stack class for stack data structure
import java.util.ArrayList; // Imports the ArrayList class for dynamic array handling
import java.util.regex.Pattern; // Imports the Pattern class for regular expression handling
import java.io.BufferedReader; // Imports the BufferedReader class for reading text from input stream
import java.io.BufferedWriter; // Imports the BufferedWriter class for writing text to output stream
import java.io.FileReader; // Imports the FileReader class for reading character files
import java.io.FileWriter; // Imports the FileWriter class for writing character files
import java.io.IOException; // Imports the IOException class for handling input/output exceptions


public class BPOApplication extends javax.swing.JFrame {

    private final Stack<JFrame> frameStack; // Stack to manage the navigation of JFrame instances
    private static ArrayList<Applicant> arrApplicants; // ArrayList to store Applicant objects
    private static final String CSV_FILE = "src/data/applicants.csv"; // Path to the CSV file containing applicant data

    
    public BPOApplication(Stack<JFrame> frameStack) {
        this.frameStack = frameStack; // Assign the parameter to the instance variable 
        arrApplicants = readApplicantsFromCSV(); // Initialize ArrayList and read data from CSV
        initComponents(); // Initializes and sets up the components for the GUI
        
        setIconImage(); // Function call to set the title bar logo
        setSize(1000, 700); // Set the size of the JFrame to 1000x700 pixels
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application when the JFrame is close
        setLocationRelativeTo(null); // Center the JFrame on the screen            
    }
// Method to check if the name already exists in the list
    private boolean isDuplicateName(String name) {
        for (Applicant applicant : arrApplicants) {
            if (applicant.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        applicationFormLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        experienceLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        experienceField = new javax.swing.JTextField();
        ageField = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        studentLabel = new javax.swing.JLabel();
        studentComboBox = new javax.swing.JComboBox<>();
        educationLabel = new javax.swing.JLabel();
        educationComboBox = new javax.swing.JComboBox<>();
        typingSpeedLabel = new javax.swing.JLabel();
        typingSpeedField = new javax.swing.JTextField();
        englishLevelLabel = new javax.swing.JLabel();
        englishLevelComboBox = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OptiSort Solutions - Application System");
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(33, 89, 129));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon.png"))); // NOI18N

        welcome.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 255, 255));
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome.setText("WELCOME, USER!");

        logOutButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        logOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logOutIcon.png"))); // NOI18N
        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(icon)
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(icon)
                .addGap(34, 34, 34)
                .addComponent(welcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        applicationFormLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        applicationFormLabel.setForeground(new java.awt.Color(33, 89, 129));
        applicationFormLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/SmallLogo.png"))); // NOI18N
        applicationFormLabel.setText("OptiSort Application Form");

        nameLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        nameLabel.setText("Name");

        experienceLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        experienceLabel.setText("Years of Experience");

        ageLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ageLabel.setText("Age");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Fill out the following fields.");

        nameField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        experienceField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        ageField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        cityLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cityLabel.setText("City of Residence");

        cityField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        studentLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        studentLabel.setText("Are you currently a student?");

        studentComboBox.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        studentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        studentComboBox.setPreferredSize(new java.awt.Dimension(64, 28));

        educationLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        educationLabel.setText("Highest Level of Education");

        educationComboBox.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        educationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "High School Diploma", "Bachelor's Degree", "Master's Degree", "Some High School" }));
        educationComboBox.setPreferredSize(new java.awt.Dimension(64, 28));

        typingSpeedLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        typingSpeedLabel.setText("Typing Speed (WPM)");

        typingSpeedField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        englishLevelLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        englishLevelLabel.setText("English Proficiency");

        englishLevelComboBox.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        englishLevelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beginner ", "Intermediate", "Advanced", "Fluent" }));
        englishLevelComboBox.setPreferredSize(new java.awt.Dimension(64, 28));

        addButton.setBackground(new java.awt.Color(33, 89, 129));
        addButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add Applicant");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        viewButton.setBackground(new java.awt.Color(33, 89, 129));
        viewButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        viewButton.setForeground(new java.awt.Color(255, 255, 255));
        viewButton.setText("View Applicants");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(33, 89, 129));
        jSeparator3.setForeground(new java.awt.Color(33, 89, 129));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cityLabel)
                                    .addComponent(nameLabel)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(nameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(experienceField, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(experienceLabel))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(ageLabel)
                                                .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(312, 312, 312)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(educationLabel)
                                            .addComponent(educationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(englishLevelLabel)
                                            .addComponent(englishLevelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(129, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(studentLabel)
                                        .addComponent(studentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(typingSpeedLabel)
                                        .addComponent(typingSpeedField, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(312, 312, 312)
                                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator3)
                                .addGap(129, 129, 129))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(applicationFormLabel))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(applicationFormLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(experienceLabel)
                            .addComponent(ageLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(experienceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cityLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(studentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(studentLabel)
                                    .addComponent(educationLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(educationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(typingSpeedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typingSpeedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(englishLevelLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(englishLevelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        BPOLogin login = new BPOLogin(frameStack); // Instantiate the BPOApplication class
        int choice = JOptionPane.showConfirmDialog(BPOApplication.this,
                    "Are you sure you want to log out?",
                    "Confirm Log Out",
                    JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            frameStack.pop();
            JFrame previousFrame = frameStack.peek();
            this.setVisible(false);
            previousFrame.setVisible(true);
        }
        // If choice is NO_OPTION or user cancels, do nothing (stay logged in)   
    }//GEN-LAST:event_logOutButtonActionPerformed
      
    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        BPOTable tableFrame = new BPOTable(frameStack);
        frameStack.push(tableFrame);
        tableFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_viewButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // Retrieve values from input fields
        String name = nameField.getText();
        String experienceStr = experienceField.getText();
        String ageStr = ageField.getText();
        String city = cityField.getText();
        String student = (String) studentComboBox.getSelectedItem();
        String education = (String) educationComboBox.getSelectedItem();
        String typingSpeedStr = typingSpeedField.getText();
        String englishLevel = (String) englishLevelComboBox.getSelectedItem();

        // Define validation patterns
        String namePattern = "^[A-Za-z ]+$";
        String experiencePattern = "^\\d+$";
        String agePattern = "^\\d+$";
        String cityPattern = "^[A-Za-z ]+$";
        String typingSpeedPattern = "^\\d+$";
        
        // Validate name field
        if (!Pattern.matches(namePattern, name) || name.isEmpty()) {
            JOptionPane.showMessageDialog(BPOApplication.this, "Invalid name. Please enter letters only.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Check for duplicate name
        if (isDuplicateName(name)) {
            JOptionPane.showMessageDialog(BPOApplication.this, "Applicant already registered. No duplicates allowed.", "Error", JOptionPane.ERROR_MESSAGE);
            return;}

        // Validate years of experience field
        if (!Pattern.matches(experiencePattern, experienceStr) || experienceStr.isEmpty()) {
            JOptionPane.showMessageDialog(BPOApplication.this, "Invalid years of experience. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate age field
        if (!Pattern.matches(agePattern, ageStr) || ageStr.isEmpty()) {
            JOptionPane.showMessageDialog(BPOApplication.this, "Invalid age. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate city field
        if (!Pattern.matches(cityPattern, city) || city.isEmpty()) {
            JOptionPane.showMessageDialog(BPOApplication.this, "Invalid city. Please enter letters only.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate typing speed field
        if (!Pattern.matches(typingSpeedPattern, typingSpeedStr) || typingSpeedStr.isEmpty()) {
            JOptionPane.showMessageDialog(BPOApplication.this, "Invalid typing speed. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convert string inputs to appropriate types
        int experience = Integer.parseInt(experienceStr);
        int age = Integer.parseInt(ageStr);
        int typingSpeed = Integer.parseInt(typingSpeedStr);

        // Valid age: The applicant should be at least 18 years old
        if (age < 18) {
            JOptionPane.showMessageDialog(BPOApplication.this, "Applicant rejected! Age should be at least 18 years old.", "Error", JOptionPane.ERROR_MESSAGE);
            clearApplicationForm(); // Clear fields after validation
            return;
        }

        // Valid typing speed: The applicant's typing speed should be at least 30 WPM
        if (typingSpeed < 30) {
            JOptionPane.showMessageDialog(BPOApplication.this, "Applicant rejected! Typing speed should be at least 30 WPM.", "Error", JOptionPane.ERROR_MESSAGE);
            clearApplicationForm(); // Clear fields after validation
            return;
        }

        // Create Applicant object and add to list
        Applicant applicant = new Applicant(name, experience, age, city, student, education, typingSpeed, englishLevel);
        arrApplicants.add(applicant);
        
        // Write to CSV for data persistence
        writeApplicantsToCSV();
        
        clearApplicationForm();
        educationComboBox.setSelectedIndex(0);
        englishLevelComboBox.setSelectedIndex(0);

        // Show success message
        JOptionPane.showMessageDialog(BPOApplication.this, "Applicant added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_addButtonActionPerformed
    
    // Static method to remove an applicant by name
    static void removeApplicant(String selectedName) {
        for (int i = 0; i < arrApplicants.size(); i++) {
            Applicant applicant = arrApplicants.get(i);
            if (applicant.getName().equals(selectedName)) {
                arrApplicants.remove(i);
                // Update CSV file after removal
                writeApplicantsToCSV();
                JOptionPane.showMessageDialog(null, "Applicant removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Applicant not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Static method to delete an applicant by name (similar functionality)
    public static void deleteApplicant(String selectedApplicantName) {
        for (int i = 0; i < arrApplicants.size(); i++) {
            Applicant applicant = arrApplicants.get(i);
            if (applicant.getName().equals(selectedApplicantName)) {
                arrApplicants.remove(i);
                // Update CSV file after deletion
                writeApplicantsToCSV();
                JOptionPane.showMessageDialog(null, "Applicant deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Applicant not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    // Clear input fields in the main menu
    private void clearApplicationForm() {
        nameField.setText("");
        experienceField.setText("");
        ageField.setText("");
        cityField.setText("");
        typingSpeedField.setText("");
        educationComboBox.setSelectedIndex(0);
        englishLevelComboBox.setSelectedIndex(0);
    }
    
    // Method for setting the title bar's icon    
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/Logo.png")));
    }
    
    // Method for writing data into the CSV file
    private static void writeApplicantsToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE))) {
            for (Applicant applicant : arrApplicants) {
                writer.write(applicant.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Method for fetching data from the CSV file
    private ArrayList<Applicant> readApplicantsFromCSV() {
        arrApplicants = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String strLine;
            while ((strLine = reader.readLine()) != null) {
                arrApplicants.add(Applicant.fromCSV(strLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrApplicants;
    }

    // Getter for applicants array list
    public static ArrayList<Applicant> getApplicants() {
        return arrApplicants;
    }
    
    // Getter for the array list's size
    public static int getApplicantCount() {
        return arrApplicants.size();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField ageField;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JLabel applicationFormLabel;
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JComboBox<String> educationComboBox;
    private javax.swing.JLabel educationLabel;
    private javax.swing.JComboBox<String> englishLevelComboBox;
    private javax.swing.JLabel englishLevelLabel;
    private javax.swing.JTextField experienceField;
    private javax.swing.JLabel experienceLabel;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton logOutButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JComboBox<String> studentComboBox;
    private javax.swing.JLabel studentLabel;
    private javax.swing.JTextField typingSpeedField;
    private javax.swing.JLabel typingSpeedLabel;
    private javax.swing.JButton viewButton;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}