package daa;

import java.awt.*; // Imports all classes from the java.awt package for AWT components
import javax.swing.*; // Imports all classes from the javax.swing package for GUI components
import javax.swing.table.DefaultTableModel; // Imports the DefaultTableModel class for table models
import java.util.*; // Imports all classes from the java.util package for various utility classes
import java.util.Stack; // Imports the Stack class for stack data structure
import java.util.List; // Imports the List interface for list data structure
import java.util.ArrayList; // Imports the ArrayList class for dynamic array handling
import java.util.Arrays; // Imports the Arrays class for array manipulation utilities

public class BPOTable extends javax.swing.JFrame {

    private final Stack<JFrame> frameStack; // Stack to manage navigation of JFrame instances
    private DefaultTableModel tblModel; // Table model for managing data in a JTable
    private List<Applicant> applicants; // List to store Applicant objects

    public BPOTable(Stack<JFrame> frameStack) {
        this.frameStack = frameStack; // Assign the parameter to the instance variable
        initComponents(); // Initializes and sets up the components for the GUI
        
        setIconImage();
        setSize(1000, 700); // Set the size of the JFrame to 1000x700 pixels
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application when the JFrame is close
        setLocationRelativeTo(null); // Center the JFrame on the screen
        
        // Initialize the table model and set it to tblApplicants
        tblModel = (DefaultTableModel) tblApplicants.getModel();
        tblApplicants.setModel(tblModel);

        // Load applicants data from CSV on startup
        loadApplicantsFromCSV();

        // Populate table with applicants
        updateTable();
        updateDeleteComboBox();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblApplicants = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        sortButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        deleteComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OptiSort Solutions - Applicant Table");
        setResizable(false);

        tblApplicants.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblApplicants.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Experience", "Age", "City", "Student", "Education", "Typing Speed", "English Level"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblApplicants.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblApplicants.setOpaque(false);
        tblApplicants.setRowHeight(25);
        tblApplicants.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblApplicants.getTableHeader().setResizingAllowed(false);
        tblApplicants.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblApplicants);
        if (tblApplicants.getColumnModel().getColumnCount() > 0) {
            tblApplicants.getColumnModel().getColumn(0).setResizable(false);
            tblApplicants.getColumnModel().getColumn(1).setResizable(false);
            tblApplicants.getColumnModel().getColumn(2).setResizable(false);
            tblApplicants.getColumnModel().getColumn(3).setResizable(false);
            tblApplicants.getColumnModel().getColumn(4).setResizable(false);
            tblApplicants.getColumnModel().getColumn(5).setResizable(false);
            tblApplicants.getColumnModel().getColumn(6).setResizable(false);
            tblApplicants.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        backButton.setBackground(new java.awt.Color(33, 89, 129));
        backButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        sortButton.setBackground(new java.awt.Color(33, 89, 129));
        sortButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        sortButton.setForeground(new java.awt.Color(255, 255, 255));
        sortButton.setText("Sort Applicants");
        sortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(33, 89, 129));
        deleteButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete Applicant");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        deleteComboBox.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231)
                .addComponent(sortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(deleteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        frameStack.pop();
        JFrame previousFrame = frameStack.peek();
        this.setVisible(false);
        previousFrame.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void sortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortButtonActionPerformed
        List<Applicant> sortedApplicants = countingSort(applicants);

        // Clear and update the table with sorted applicants
        tblModel.setRowCount(0); // Clear existing rows

        for (Applicant applicant : sortedApplicants) {
        Object[] rowData = {
                applicant.getName(),
                applicant.getExperience(),
                applicant.getAge(),
                applicant.getCity(),
                applicant.getStudent(),
                applicant.getEducation(),
                applicant.getTypingSpeed(),
                applicant.getEnglishLevel()
            };
        tblModel.addRow(rowData);
        }
        tblApplicants.repaint();
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
        // increments the count at the
        //position corresponding to their experience 
        //The maxExperience - experience to sort in descending order.
        int[] count = new int[maxExperience + 1];
        // Count each applicant's experience (modified to count higher experience first)
        for (Applicant applicant : applicants) {
            count[maxExperience - applicant.getExperience()]++;
        }

        // cumulative counts
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

        // Convert array back to list and group applicants with the same experience
        List<Applicant> sortedList = new ArrayList<>(Arrays.asList(sortedApplicants));

        // Group and sort by typing speed and English proficiency
        List<Applicant> finalSortedList = new ArrayList<>();
        int start = 0;
        while (start < sortedList.size()) {
            int experience = sortedList.get(start).getExperience();
            int end = start;
            while (end < sortedList.size() && sortedList.get(end).getExperience() == experience) {
                end++;
            }
            // Sort this sublist using merge sort
            List<Applicant> sublist = sortedList.subList(start, end);
            finalSortedList.addAll(mergeSort(sublist)); // mergeSort is called here
            start = end;
        }
        return finalSortedList;
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
    }//GEN-LAST:event_sortButtonActionPerformed
     
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String selectedApplicantName = (String) deleteComboBox.getSelectedItem();
        try {
            System.out.println("Attempting to delete applicant: " + selectedApplicantName);
            BPOApplication.deleteApplicant(selectedApplicantName); // Call to BPOApplication to delete the applicant

            // Remove the applicant from the applicants list
            Iterator<Applicant> iterator = applicants.iterator();
            while (iterator.hasNext()) {
                Applicant applicant = iterator.next();
                if (applicant.getName().equals(selectedApplicantName)) {
                    iterator.remove();
                    break;
                }
            }

            // Refresh table and combo box after deletion
            refreshTable();
            updateDeleteComboBox();
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error deleting applicant: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error deleting applicant: " + e.getMessage(),
                    "Deletion Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadApplicantsFromCSV() {
        applicants = BPOApplication.getApplicants(); // Load applicants from CSV
        if (applicants == null) {
            applicants = new ArrayList<>(); // Initialize if null
        } else {
            for (Applicant applicant : applicants) {
                System.out.println("Loaded from CSV: " + applicant.getName());
            }
        }    
    }
    
    private void refreshTable() {
        tblModel.setRowCount(0); // Clear the existing table data

        // Populate table with applicants
        for (Applicant applicant : applicants) {
            Object[] rowData = {
                    applicant.getName(),
                    applicant.getExperience(),
                    applicant.getAge(),
                    applicant.getCity(),
                    applicant.getStudent(),
                    applicant.getEducation(),
                    applicant.getTypingSpeed(),
                    applicant.getEnglishLevel()
            };
            tblModel.addRow(rowData);
        }
        tblApplicants.repaint(); // Repaint the table to reflect changes
    }

    private void updateTable() {
        tblModel.setRowCount(0); // Clear existing rows

        for (Applicant applicant : applicants) {
            Object[] rowData = {
                    applicant.getName(),
                    applicant.getExperience(),
                    applicant.getAge(),
                    applicant.getCity(),
                    applicant.getStudent(),
                    applicant.getEducation(),
                    applicant.getTypingSpeed(),
                    applicant.getEnglishLevel()
            };
            tblModel.addRow(rowData);
        }
        tblApplicants.repaint(); // Repaint the table to reflect changes
    }

    private void updateDeleteComboBox() {
        deleteComboBox.removeAllItems(); // Clear existing items
        for (Applicant applicant : applicants) {
            deleteComboBox.addItem(applicant.getName()); // Add applicant names to the combo box
        }
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    // Function to set the title bar logo
    private void setIconImage() { 
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/Logo.png")));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> deleteComboBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sortButton;
    public static javax.swing.JTable tblApplicants;
    // End of variables declaration//GEN-END:variables
}