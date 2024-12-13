package daa;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class BPOMain {

    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BPOLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(() -> {
            Stack<JFrame> frameStack = new Stack<>();
            BPOLogin loginFrame = new BPOLogin(frameStack);
            frameStack.push(loginFrame);
            loginFrame.setVisible(true);

            // Read applicants from CSV and print them
            try (BufferedReader reader = new BufferedReader(new FileReader("src/data/applicants.csv"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Applicant applicant = Applicant.fromCSV(line);
                    if (applicant != null) {
                        System.out.println(applicant); // Print each applicant to verify parsing
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
