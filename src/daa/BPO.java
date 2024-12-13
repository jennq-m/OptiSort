package daa; // Defines the package name 'daa'

import javax.imageio.ImageIO; // Imports the ImageIO class for reading and writing images
import javax.swing.*; // Imports all classes from the javax.swing package for GUI components
import javax.swing.table.DefaultTableModel; // Imports DefaultTableModel class for table data handling
import javax.swing.table.JTableHeader; // Imports JTableHeader class for table header handling
import java.awt.*; // Imports all classes from the java.awt package for AWT components
import java.awt.event.*; // Imports all classes from the java.awt.event package for event handling
import java.awt.event.ActionEvent; // Imports ActionEvent class for handling action events
import java.awt.event.ActionListener; // Imports ActionListener interface for receiving action events
import java.io.File; // Imports File class for file handling
import java.io.IOException; // Imports IOException class for handling IO exceptions
import java.util.ArrayList; // Imports ArrayList class for dynamic array handling
import java.util.Arrays; // Imports Arrays class for array manipulation
import java.util.List; // Imports List interface for list handling
import java.util.regex.Matcher; // Imports Matcher class for regex operations
import java.util.regex.Pattern; // Imports Pattern class for regex pattern handling


public class BPO extends JFrame { // Defines the BPO class which extends JFrame for creating a window

    private JTextField nameField; // Declares a text field for the name input
    private JTextField experienceField; // Declares a text field for the experience input
    private JTextField ageField; // Declares a text field for the age input
    private JTextField cityField; // Declares a text field for the city input
    private JTextField typingSpeedField; // Declares a text field for the typing speed input
    private JComboBox<String> studentComboBox; // Declares a combo box for selecting student status
    private JComboBox<String> educationComboBox; // Declares a combo box for selecting education level
    private JComboBox<String> englishLevelComboBox; // Declares a combo box for selecting English proficiency level
    private List<Applicant> applicants; // Declares a list to store applicant objects
    private JComboBox<String> deleteComboBox; // Declares a combo box for selecting an applicant to delete
    private DefaultTableModel tableModel; // Declares a table model for managing table data
    private JTable table; // Declares a table for displaying data
    private CardLayout cardLayout; // Declares a card layout for switching between different panels
    private JPanel mainPanel; // Declares the main panel to hold other components
    private JPasswordField passwordField; // Declares a password field for password input
    private JTextField staffNameField; // Declares a text field for staff name input


  public BPO() { // Constructor for the BPO class
    setUndecorated(true); // Remove the default title bar
    setSize(1000, 700); // Set the size of the JFrame to 1000x700 pixels
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application when the JFrame is closed
    setLocationRelativeTo(null); // Center the JFrame on the screen

    // Initialize applicants list
    applicants = new ArrayList<>(); // Create a new ArrayList to store applicants

    // Set custom icon for the JFrame
    try {
        // Provide path to your custom icon file here
        File iconFile = new File("C:\\Users\\ADMIN\\Pictures\\systemlogo.png"); // Path to the custom icon file
        Image iconImage = ImageIO.read(iconFile); // Read the image from the file
        setIconImage(iconImage); // Set the JFrame icon to the custom image
    } catch (IOException e) {
        e.printStackTrace(); // Print the stack trace if an IOException occurs
        System.err.println("Failed to load application icon: " + e.getMessage()); // Print an error message
    }

    cardLayout = new CardLayout(); // Initialize the CardLayout
    mainPanel = new JPanel(cardLayout); // Create the main panel with CardLayout

    JPanel loginPanel = createLoginPanel(); // Create the login panel
    JPanel mainMenuPanel = createMainMenuPanel(); // Create the main menu panel
    JPanel applicantsDetailsPanel = createApplicantsDetailsPanel(); // Create the applicants details panel

    mainPanel.add(loginPanel, "Login"); // Add the login panel to the main panel with the identifier "Login"
    mainPanel.add(mainMenuPanel, "MainMenu"); // Add the main menu panel to the main panel with the identifier "MainMenu"
    mainPanel.add(applicantsDetailsPanel, "ApplicantsDetails"); // Add the applicants details panel to the main panel with the identifier "ApplicantsDetails"

    add(mainPanel); // Add the main panel to the JFrame
    cardLayout.show(mainPanel, "Login"); // Show the login panel initially

    // Create custom title bar
    JPanel titleBar = createTitleBar(); // Create the custom title bar

    // Create main content panel
    JPanel contentPanel = new JPanel(new BorderLayout()); // Create the main content panel with BorderLayout
    contentPanel.add(titleBar, BorderLayout.NORTH); // Add the title bar to the top of the content panel
    contentPanel.add(mainPanel, BorderLayout.CENTER); // Add the main panel to the center of the content panel

    setContentPane(contentPanel); // Set the content pane of the JFrame to the content panel
}

    private JPanel createTitleBar() { // Method to create a custom title bar
    JPanel titleBar = new JPanel(); // Create a new JPanel for the title bar
    titleBar.setBackground(Color.WHITE); // Set the background color to white
    titleBar.setPreferredSize(new Dimension(getWidth(), 30)); // Set the preferred size of the title bar
    titleBar.setLayout(new BorderLayout()); // Use BorderLayout for the title bar

    // Add logo to the title bar
    JLabel logoLabel = new JLabel(); // Create a JLabel for the logo
    try {
        File iconFile = new File("C:\\Users\\ADMIN\\Pictures\\systemlogo.png"); // Path to the logo file
        Image iconImage = ImageIO.read(iconFile).getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Read and scale the image
        logoLabel.setIcon(new ImageIcon(iconImage)); // Set the icon of the JLabel
    } catch (IOException e) {
        e.printStackTrace(); // Print the stack trace if an IOException occurs
        System.err.println("Failed to load title bar logo: " + e.getMessage()); // Print an error message
    }
    titleBar.add(logoLabel, BorderLayout.WEST); // Add the logo label to the left side of the title bar

    JLabel titleLabel = new JLabel("BPO Company System"); // Create a JLabel for the title text
    titleLabel.setForeground(Color.BLACK); // Set the text color to black
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align the text
    titleBar.add(titleLabel, BorderLayout.CENTER); // Add the title label to the center of the title bar

    JButton closeButton = new JButton("X"); // Create a button for closing the window
    closeButton.setForeground(Color.WHITE); // Set the text color of the button to white
    closeButton.setBackground(Color.RED); // Set the background color of the button to red
    closeButton.setFocusPainted(false); // Disable focus painting
    closeButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Set an empty border for padding
    closeButton.addActionListener(e -> System.exit(0)); // Add an action listener to exit the application when clicked
    titleBar.add(closeButton, BorderLayout.EAST); // Add the close button to the right side of the title bar

    // Add mouse listeners for dragging the window
    MouseAdapter mouseAdapter = new MouseAdapter() {
        private int posX = 0, posY = 0; // Variables to store the initial mouse position

        @Override
        public void mousePressed(MouseEvent e) { // When the mouse is pressed
            posX = e.getX(); // Get the X position
            posY = e.getY(); // Get the Y position
        }

        @Override
        public void mouseDragged(MouseEvent e) { // When the mouse is dragged
            setLocation(e.getXOnScreen() - posX, e.getYOnScreen() - posY); // Move the window to the new position
        }
    };
    titleBar.addMouseListener(mouseAdapter); // Add the mouse listener to the title bar
    titleBar.addMouseMotionListener(mouseAdapter); // Add the mouse motion listener to the title bar

    return titleBar; // Return the custom title bar
}

private JPanel createLoginPanel() { // Method to create the login panel
    JPanel loginPanel = new JPanel(new GridBagLayout()) { // Create a new JPanel with GridBagLayout
        // Override paintComponent to set background image
        @Override
        protected void paintComponent(Graphics g) { // Override the paintComponent method
            super.paintComponent(g); // Call the superclass method
            // Load the image
            ImageIcon imageIcon = new ImageIcon("C:\\Users\\ADMIN\\Pictures\\Home.png"); // Load the background image
            Image image = imageIcon.getImage(); // Get the Image object from the ImageIcon
            // Draw the image at the specified location (0,0) with this panel's width and height
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this); // Draw the image on the panel
        }
    };

    // Existing code for loginPanel setup (labels, fields, button)
    GridBagConstraints gbc = new GridBagConstraints(); // Create GridBagConstraints for layout management
    gbc.insets = new Insets(10, 10, 10, 10); // Set insets for padding
    gbc.fill = GridBagConstraints.HORIZONTAL; // Set fill to horizontal

    JLabel staffNameLabel = new JLabel("Staff Name:"); // Create a label for staff name
    staffNameLabel.setForeground(Color.WHITE); // Set the text color to white
    staffNameLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font size to 18

    JTextField staffNameField = new JTextField(20); // Create a text field for staff name input

    JLabel passwordLabel = new JLabel("Password:"); // Create a label for password
    passwordLabel.setForeground(Color.WHITE); // Set the text color to white
    passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font size to 18

    JPasswordField passwordField = new JPasswordField(20); // Create a password field for password input

    JButton loginButton = new JButton("Log In"); // Create a button for login
    loginButton.setBackground(Color.decode("#FAFB63")); // Set the background color of the button
    loginButton.addActionListener(new ActionListener() { // Add an action listener to the button
        @Override
        public void actionPerformed(ActionEvent e) { // Define the action to be performed on button click
            String staffName = staffNameField.getText(); // Get the text from the staff name field
            String password = new String(passwordField.getPassword()); // Get the password from the password field
            if ("admin".equals(password)) { // Check if the password is "admin"
                cardLayout.show(mainPanel, "MainMenu"); // Show the main menu panel if password is correct
            } else {
                JOptionPane.showMessageDialog(BPO.this, "Incorrect password", "Error", JOptionPane.ERROR_MESSAGE); // Show error message if password is incorrect
            }
        }
    });

    gbc.gridx = 0; // Set the grid x position for the label
    gbc.gridy = 0; // Set the grid y position for the label
    loginPanel.add(staffNameLabel, gbc); // Add the staff name label to the panel
    gbc.gridx = 1; // Set the grid x position for the text field
    loginPanel.add(staffNameField, gbc); // Add the staff name text field to the panel

    gbc.gridx = 0; // Set the grid x position for the label
    gbc.gridy = 1; // Set the grid y position for the label
    loginPanel.add(passwordLabel, gbc); // Add the password label to the panel
    gbc.gridx = 1; // Set the grid x position for the password field
    loginPanel.add(passwordField, gbc); // Add the password field to the panel

    gbc.gridx = 1; // Set the grid x position for the button
    gbc.gridy = 2; // Set the grid y position for the button
    loginPanel.add(loginButton, gbc); // Add the login button to the panel

    return loginPanel; // Return the login panel
}


private JPanel createMainMenuPanel() {
    // Load the background image
    ImageIcon backgroundImageIcon = new ImageIcon("C:\\Users\\ADMIN\\Pictures\\greenpanel.png");
    Image backgroundImage = backgroundImageIcon.getImage();

    // Create and style the "Name" label and text field
    JLabel nameLabel = new JLabel("<html><b>Name:</b></html>");
    nameLabel.setForeground(Color.WHITE); // Set font color to white
    nameField = new JTextField(20);

    // Create and style the "Years of Experience" label and text field
    JLabel experienceLabel = new JLabel("<html><b>Years of Experience:</b></html>");
    experienceLabel.setForeground(Color.WHITE); // Set font color to white
    experienceField = new JTextField(5);

    // Create and style the "Age" label and text field
    JLabel ageLabel = new JLabel("<html><b>Age:</b></html>");
    ageLabel.setForeground(Color.WHITE); // Set font color to white
    ageField = new JTextField(5);

    // Create and style the "City of Residence" label and text field
    JLabel cityLabel = new JLabel("<html><b>City of Residence:</b></html>");
    cityLabel.setForeground(Color.WHITE); // Set font color to white
    cityField = new JTextField(20);

    // Create and style the "Are you currently a student?" label and combo box
    JLabel studentLabel = new JLabel("<html><b>Are you currently a student?</b></html>");
    studentLabel.setForeground(Color.WHITE); // Set font color to white
    String[] studentOptions = {"Yes", "No"};
    studentComboBox = new JComboBox<>(studentOptions);

    // Create and style the "Highest Educational Attainment" label and combo box
    JLabel educationLabel = new JLabel("<html><b>Highest Educational Attainment:</b></html>");
    educationLabel.setForeground(Color.WHITE); // Set font color to white
    String[] educationOptions = {"High School", "College", "Postgraduate"};
    educationComboBox = new JComboBox<>(educationOptions);

    // Create and style the "Typing Speed (WPM)" label and text field
    JLabel typingSpeedLabel = new JLabel("<html><b>Typing Speed (WPM):</b></html>");
    typingSpeedLabel.setForeground(Color.WHITE); // Set font color to white
    typingSpeedField = new JTextField(5);

    // Create and style the "English Proficiency" label and combo box
    JLabel englishLevelLabel = new JLabel("<html><b>English Proficiency:</b></html>");
    englishLevelLabel.setForeground(Color.WHITE); // Set font color to white
    String[] englishLevels = {"Beginner", "Intermediate", "Advanced", "Fluent"};
    englishLevelComboBox = new JComboBox<>(englishLevels);

    // Create and style the "Add Applicant" button
    JButton addButton = new JButton("Add Applicant");
    addButton.setBackground(Color.decode("#FAFB63")); // Set background color
    addButton.addActionListener(new AddButtonListener()); // Add action listener

    // Create and style the "View Applicants" button
    JButton viewButton = new JButton("View Applicants");
    viewButton.setBackground(Color.decode("#FAFB63")); // Set background color
    viewButton.addActionListener(e -> cardLayout.show(mainPanel, "ApplicantsDetails")); // Add action listener

    // Create and style the "Log Out" button
    JButton logoutButton = new JButton("Log Out");
    logoutButton.setBackground(Color.decode("#FAFB63")); // Set background color
    logoutButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int choice = JOptionPane.showConfirmDialog(BPO.this,
                    "Are you sure you want to log out and exit the application?",
                    "Confirm Log Out and Exit",
                    JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                // Perform logout action here if needed

                // Exit the application
                System.exit(0);
            }
            // If choice is NO_OPTION or user cancels, do nothing (stay logged in)
        }
    });

    // Set bold font for the buttons
    Font buttonFont = new Font("Arial", Font.BOLD, 14);
    addButton.setFont(buttonFont);
    viewButton.setFont(buttonFont);
    logoutButton.setFont(buttonFont);

    // Create the input panel and set its properties
    JPanel inputPanel = new JPanel();
    inputPanel.setOpaque(false); // Make inputPanel transparent
    inputPanel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10); // Set padding
    gbc.fill = GridBagConstraints.HORIZONTAL; // Set fill to horizontal

    // Set fonts for labels and fields
    Font labelFont = new Font("Arial", Font.BOLD, 16);
    Font fieldFont = new Font("Arial", Font.PLAIN, 14);

    nameLabel.setFont(labelFont);
    experienceLabel.setFont(labelFont);
    ageLabel.setFont(labelFont);
    cityLabel.setFont(labelFont);
    studentLabel.setFont(labelFont);
    educationLabel.setFont(labelFont);
    typingSpeedLabel.setFont(labelFont);
    englishLevelLabel.setFont(labelFont);

    nameField.setFont(fieldFont);
    experienceField.setFont(fieldFont);
    ageField.setFont(fieldFont);
    cityField.setFont(fieldFont);
    studentComboBox.setFont(fieldFont);
    educationComboBox.setFont(fieldFont);
    typingSpeedField.setFont(fieldFont);
    englishLevelComboBox.setFont(fieldFont);

    // Add components to input panel with GridBagLayout constraints
    gbc.gridx = 0;
    gbc.gridy = 0;
    inputPanel.add(nameLabel, gbc);
    gbc.gridx = 1;
    inputPanel.add(nameField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    inputPanel.add(experienceLabel, gbc);
    gbc.gridx = 1;
    inputPanel.add(experienceField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    inputPanel.add(ageLabel, gbc);
    gbc.gridx = 1;
    inputPanel.add(ageField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 3;
    inputPanel.add(cityLabel, gbc);
    gbc.gridx = 1;
    inputPanel.add(cityField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 4;
    inputPanel.add(studentLabel, gbc);
    gbc.gridx = 1;
    inputPanel.add(studentComboBox, gbc);

    gbc.gridx = 0;
    gbc.gridy = 5;
    inputPanel.add(educationLabel, gbc);
    gbc.gridx = 1;
    inputPanel.add(educationComboBox, gbc);

    gbc.gridx = 0;
    gbc.gridy = 6;
    inputPanel.add(typingSpeedLabel, gbc);
    gbc.gridx = 1;
    inputPanel.add(typingSpeedField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 7;
    inputPanel.add(englishLevelLabel, gbc);
    gbc.gridx = 1;
    inputPanel.add(englishLevelComboBox, gbc);

    // Add buttons to the input panel
    gbc.gridx = 0;
    gbc.gridy = 8;
    gbc.gridwidth = 2; // Span across two columns
    inputPanel.add(addButton, gbc);
    gbc.gridy = 9;
    inputPanel.add(viewButton, gbc);

    gbc.gridy = 10;
    inputPanel.add(logoutButton, gbc); // Add logoutButton at the end

    // Create the main menu panel with BorderLayout
    JPanel mainMenuPanel = new JPanel(new BorderLayout()) {
        // Override paintComponent to set background image
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image at the panel's bounds
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    };

    mainMenuPanel.add(inputPanel, BorderLayout.CENTER); // Add inputPanel to the center of mainMenuPanel

    return mainMenuPanel;
}


private JPanel createApplicantsDetailsPanel() {
    // Create table model with columns: Name, Experience, Age, City, Student, Education, Typing Speed, English Level
    tableModel = new DefaultTableModel(new Object[]{"Name", "Experience", "Age", "City", "Student", "Education", "Typing Speed", "English Level"}, 0);
    // Create table with the table model
    table = new JTable(tableModel);
    table.setBackground(Color.decode("#A1FFFA")); // Set background color for the table

    // Customize table header
    JTableHeader tableHeader = table.getTableHeader();
    tableHeader.setFont(new Font("Arial", Font.BOLD, 16)); // Set header font
    tableHeader.setBackground(Color.decode("#215981")); // Set header background color
    tableHeader.setForeground(Color.decode("#000000")); // Set header font color

    // Customize table rows
    table.setFont(new Font("Arial", Font.PLAIN, 14)); // Set row font
    table.setRowHeight(25); // Set row height

    // Add table to scroll pane
    JScrollPane scrollPane = new JScrollPane(table);

    // Create and customize the "Sort Applicants" button
    JButton sortButton = new JButton("Sort Applicants");
    sortButton.setPreferredSize(new Dimension(150, 25)); // Set button size
    sortButton.addActionListener(new SortButtonListener()); // Add action listener

    // Create and customize the delete combo box and button
    deleteComboBox = new JComboBox<>();
    JButton deleteButton = new JButton("Delete Applicant");
    deleteButton.setPreferredSize(new Dimension(150, 25)); // Set button size
    deleteButton.addActionListener(new DeleteButtonListener()); // Add action listener

    // Create and customize the "Main Menu" button
    JButton backButton = new JButton("Main Menu");
    backButton.setPreferredSize(new Dimension(150, 25)); // Set button size
    backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu")); // Add action listener

    // Set background color for buttons
    sortButton.setBackground(Color.decode("#FAFB63"));
    deleteButton.setBackground(Color.decode("#FAFB63"));
    backButton.setBackground(Color.decode("#FAFB63"));

    // Set font for buttons
    sortButton.setFont(new Font("Arial", Font.PLAIN, 14));
    deleteButton.setFont(new Font("Arial", Font.PLAIN, 14));
    backButton.setFont(new Font("Arial", Font.PLAIN, 14));

    // Create panel for buttons with FlowLayout
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Set layout with center alignment and spacing

    // Add buttons and combo box to the button panel
    buttonPanel.add(sortButton);
    buttonPanel.add(deleteButton);
    buttonPanel.add(deleteComboBox);
    buttonPanel.add(backButton);

    // Create the applicantsDetailsPanel with BorderLayout
    JPanel applicantsDetailsPanel = new JPanel(new BorderLayout()) {
        // Override paintComponent to set background color
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Set background color to black
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };

    // Add scroll pane (with table) to the center of the panel
    applicantsDetailsPanel.add(scrollPane, BorderLayout.CENTER);
    // Add button panel to the bottom of the panel
    applicantsDetailsPanel.add(buttonPanel, BorderLayout.SOUTH);

    // Return the complete panel
    return applicantsDetailsPanel;
}

private class AddButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
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
            JOptionPane.showMessageDialog(BPO.this, "Invalid name. Please enter letters only.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate years of experience field
        if (!Pattern.matches(experiencePattern, experienceStr) || experienceStr.isEmpty()) {
            JOptionPane.showMessageDialog(BPO.this, "Invalid years of experience. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate age field
        if (!Pattern.matches(agePattern, ageStr) || ageStr.isEmpty()) {
            JOptionPane.showMessageDialog(BPO.this, "Invalid age. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate city field
        if (!Pattern.matches(cityPattern, city) || city.isEmpty()) {
            JOptionPane.showMessageDialog(BPO.this, "Invalid city. Please enter letters only.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate typing speed field
        if (!Pattern.matches(typingSpeedPattern, typingSpeedStr) || typingSpeedStr.isEmpty()) {
            JOptionPane.showMessageDialog(BPO.this, "Invalid typing speed. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convert string inputs to appropriate types
        int experience = Integer.parseInt(experienceStr);
        int age = Integer.parseInt(ageStr);
        int typingSpeed = Integer.parseInt(typingSpeedStr);

        // Additional validation: Age should be at least 18 and Typing speed should be at least 30 WPM
        if (age < 18 && typingSpeed < 30) {
            JOptionPane.showMessageDialog(BPO.this, "Applicant rejected. Age should be at least 18 and Typing speed should be at least 30 WPM.", "Error", JOptionPane.ERROR_MESSAGE);
            clearMainMenuFields(); // Clear fields after validation
            return;
        }

        // Validate education level
        if ("High School".equals(education)) {
            JOptionPane.showMessageDialog(BPO.this, "Company does not accept high schoolers. Applicant rejected.", "Error", JOptionPane.ERROR_MESSAGE);
            clearMainMenuFields(); // Clear fields after validation
            return;
        }

        // Create Applicant object and add to list
        Applicant applicant = new Applicant(name, experience, age, city, student, education, typingSpeed, englishLevel);
        applicants.add(applicant); // Add applicant to list
        updateTable(); // Update table with new applicant
        updateDeleteComboBox(); // Update delete combo box with new applicant

        // Clear main menu fields after successful addition
        clearMainMenuFields();

        // Reset JComboBox components to their initial state
        educationComboBox.setSelectedIndex(0);
        englishLevelComboBox.setSelectedIndex(0);

        // Show success message
        JOptionPane.showMessageDialog(BPO.this, "Applicant added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Clear input fields in the main menu
    private void clearMainMenuFields() {
        nameField.setText("");
        experienceField.setText("");
        ageField.setText("");
        cityField.setText("");
        typingSpeedField.setText("");
    }
}

private class SortButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        applicants = mergeSort(applicants); // Sort applicants using merge sort
        updateTable(); // Update the table with sorted data
    }
}

private class DeleteButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedIndex = deleteComboBox.getSelectedIndex(); // Get the selected index from the combo box
        if (selectedIndex >= 0) { // Check if a valid selection is made
            applicants.remove(selectedIndex); // Remove the selected applicant from the list
            updateTable(); // Update the table after deletion
            updateDeleteComboBox(); // Update the delete combo box after deletion
        }
    }
}

private void updateTable() {
    tableModel.setRowCount(0); // Clear the existing table data
    // Loop through the list of applicants
    for (Applicant applicant : applicants) {
        // Add each applicant's details as a row in the table
        tableModel.addRow(new Object[]{
            applicant.getName(), 
            applicant.getExperience(), 
            applicant.getAge(), 
            applicant.getCity(), 
            applicant.getStudent(), 
            applicant.getEducation(), 
            applicant.getTypingSpeed(), 
            applicant.getEnglishLevel()
        });
    }
}

private void updateDeleteComboBox() {
    deleteComboBox.removeAllItems(); // Clear existing items in the delete combo box
    // Loop through the list of applicants
    for (Applicant applicant : applicants) {
        // Add each applicant's name to the delete combo box
        deleteComboBox.addItem(applicant.getName());
    }
}

public static List<Applicant> countingSort(List<Applicant> applicants) {
    int n = applicants.size(); // Get the number of applicants
    if (n <= 1) { // If there is one or no applicant, no need to sort
        return applicants;
    }

    // Find the maximum experience to determine the range of the counting array
    int maxExperience = applicants.stream()
        .mapToInt(Applicant::getExperience)
        .max()
        .orElse(0);

    // Initialize counting array
    int[] count = new int[maxExperience + 1];
    // Count each applicant's experience (modified to count higher experience first)
    for (Applicant applicant : applicants) {
        count[maxExperience - applicant.getExperience()]++;
    }

    // Modify count array to contain cumulative counts
    for (int i = 1; i <= maxExperience; i++) {
        count[i] += count[i - 1];
    }

    // Create output array
    Applicant[] sortedApplicants = new Applicant[n];
    // Place each applicant in the sorted position
    for (int i = n - 1; i >= 0; i--) {
        Applicant applicant = applicants.get(i);
        int index = count[maxExperience - applicant.getExperience()] - 1;
        sortedApplicants[index] = applicant; // Insert at calculated position
        count[maxExperience - applicant.getExperience()]--;
    }

    // Convert array back to list
    return new ArrayList<>(Arrays.asList(sortedApplicants));
}

private static int compareApplicants(Applicant a1, Applicant a2) {
    // Higher years of experience, higher rank
    if (a1.getExperience() != a2.getExperience()) {
        return Integer.compare(a2.getExperience(), a1.getExperience());
    }

    // If years of experience are the same, compare by typing speed
    if (a1.getTypingSpeed() != a2.getTypingSpeed()) {
        return Integer.compare(a2.getTypingSpeed(), a1.getTypingSpeed());
    }

    // If typing speed is also the same, compare by English level
    int englishLevelComparison = compareEnglishLevels(a1.getEnglishLevel(), a2.getEnglishLevel());
    if (englishLevelComparison != 0) {
        return englishLevelComparison; // Return the comparison result
    }

    // If English level is the same and typing speed is the same, prioritize non-students
    if (!a1.getStudent().equals(a2.getStudent())) {
        return a1.getStudent().equals("No") ? -1 : 1;
    }

    // If all criteria are the same, maintain the original order (stable sort)
    return 0;
}

private static int compareEnglishLevels(String level1, String level2) {
    // Define the ranking based on custom levels
    int rank1 = getEnglishLevelRank(level1);
    int rank2 = getEnglishLevelRank(level2);

    // Compare ranks
    return Integer.compare(rank2, rank1); // Higher rank first
}

private static int getEnglishLevelRank(String level) {
    // Assign ranks based on the custom mapping
    switch (level.toLowerCase()) {
        case "fluent":
            return 5;
        case "advanced":
            return 4;
        case "intermediate":
            return 3;
        case "beginner":
            return 2;
        default:
            return 0; // If level is unknown, lowest rank
    }
}


public static List<Applicant> mergeSort(List<Applicant> applicants) {
    // Base case: if the list has 1 or fewer elements, it is already sorted
    if (applicants.size() <= 1) {
        return applicants;
    }

    // Find the middle index of the list
    int mid = applicants.size() / 2;

    // Recursively sort the left half of the list
    List<Applicant> left = mergeSort(new ArrayList<>(applicants.subList(0, mid)));

    // Recursively sort the right half of the list
    List<Applicant> right = mergeSort(new ArrayList<>(applicants.subList(mid, applicants.size())));

    // Merge the sorted halves
    return merge(left, right);
}

private static List<Applicant> merge(List<Applicant> left, List<Applicant> right) {
    // Create a new list to hold the merged result
    List<Applicant> result = new ArrayList<>();

    // Indices to track the position in the left and right lists
    int leftIndex = 0, rightIndex = 0;

    // Merge elements from left and right lists in sorted order
    while (leftIndex < left.size() && rightIndex < right.size()) {
        // Compare applicants from the left and right lists
        if (compareApplicants(left.get(leftIndex), right.get(rightIndex)) <= 0) {
            // Add the smaller element to the result and increment the left index
            result.add(left.get(leftIndex++));
        } else {
            // Add the smaller element to the result and increment the right index
            result.add(right.get(rightIndex++));
        }
    }

    // Add any remaining elements from the left list to the result
    result.addAll(left.subList(leftIndex, left.size()));

    // Add any remaining elements from the right list to the result
    result.addAll(right.subList(rightIndex, right.size()));

    // Return the merged list
    return result;
}

public static void main(String[] args) {
    // Schedule a job for the event dispatch thread to create and show the BPO application GUI
    SwingUtilities.invokeLater(() -> {
        BPO bpoApp = new BPO();
        bpoApp.setVisible(true);
    });
}

class Applicant {
    // Fields for storing applicant details
    private String name;
    private int experience;
    private int age;
    private String city;
    private String student;
    private String education;
    private int typingSpeed;
    private String englishLevel;

    // Constructor to initialize an applicant object
    public Applicant(String name, int experience, int age, String city, String student, String education, int typingSpeed, String englishLevel) {
        this.name = name;
        this.experience = experience;
        this.age = age;
        this.city = city;
        this.student = student;
        this.education = education;
        this.typingSpeed = typingSpeed;
        this.englishLevel = englishLevel;
    }

    // Getter method for the name field
    public String getName() {
        return name;
    }

    // Getter method for the experience field
    public int getExperience() {
        return experience;
    }

    // Getter method for the age field
    public int getAge() {
        return age;
    }

    // Getter method for the city field
    public String getCity() {
        return city;
    }

    // Getter method for the student field
    public String getStudent() {
        return student;
    }

    // Getter method for the education field
    public String getEducation() {
        return education;
    }

    // Getter method for the typingSpeed field
    public int getTypingSpeed() {
        return typingSpeed;
    }

    // Getter method for the englishLevel field
    public String getEnglishLevel() {
        return englishLevel;
    }
}}