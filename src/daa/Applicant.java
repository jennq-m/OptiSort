package daa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Applicant {

    private final String name;
    private final int experience;
    private final int age;
    private final String city;
    private final String student;
    private final String education;
    private final int typingSpeed;
    private final String englishLevel;

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
    
    
    // Convert input applicant data into CSV format
    public String toCSV() {
        return String.join(",", 
                            name, 
                            String.valueOf(experience), 
                            String.valueOf(age), 
                            city, 
                            student, 
                            education, 
                            String.valueOf(typingSpeed), 
                            englishLevel);
    }

  
  public static Applicant fromCSV(String csvLine) {
    // Assuming headers are present and the first line might contain them
    if (csvLine.startsWith("Name,Experience,Age,City,Student,Education,Typing Speed,English Level")) {
        return null; // Skip the header line
    }

    List<String> values = parseCSVLine(csvLine);

    if (values.size() != 8) {
        throw new IllegalArgumentException("CSV line does not contain 8 values");
    }

    // Parse each value from the CSV line
    String name = values.get(0).trim();
    int experience = Integer.parseInt(values.get(1).trim());
    int age = Integer.parseInt(values.get(2).trim());
    String city = values.get(3).trim();
    String student = values.get(4).trim();
    String education = values.get(5).trim();
    int typingSpeed = Integer.parseInt(values.get(6).trim());
    String englishLevel = values.get(7).trim();

    return new Applicant(name, experience, age, city, student, education, typingSpeed, englishLevel);
}

private static List<String> parseCSVLine(String line) {
    List<String> values = new ArrayList<>();
    StringBuilder currentValue = new StringBuilder();
    boolean inQuotes = false;

    for (char c : line.toCharArray()) {
        if (c == '\"') {
            inQuotes = !inQuotes;
        } else if (c == ',' && !inQuotes) {
            values.add(currentValue.toString());
            currentValue.setLength(0);
        } else {
            currentValue.append(c);
        }
    }

    // Add the last value
    values.add(currentValue.toString());

    return values;
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
    
    // Method to delete an applicant's data from the CSV file
public static void deleteApplicant(String nameToDelete) throws IOException {
    File inputFile = new File("src/data/applicants.csv");
    File tempFile = new File("temp.csv");

    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

    String currentLine;
    boolean found = false;

    while ((currentLine = reader.readLine()) != null) {
        String[] parts = currentLine.split(",");
        String name = parts[0].trim(); // Trim any leading or trailing whitespace

        // Check if the current line contains the name of the applicant to delete
        if (name.equalsIgnoreCase(nameToDelete.trim())) { // Case-insensitive comparison
            found = true;
            continue; // Skip writing this line to the temp file (effectively deleting it)
        }
        writer.write(currentLine + System.getProperty("line.separator"));
    }

    writer.close();
    reader.close();

    if (!found) {
        throw new IllegalArgumentException("Applicant with name '" + nameToDelete + "' not found.");
    }

    // Rename the temporary file back to the original file
    if (!inputFile.delete()) {
        throw new IOException("Could not delete original file.");
    }
    if (!tempFile.renameTo(inputFile)) {
        throw new IOException("Could not rename temporary file.");
    }
}

    @Override
    public String toString() {
        return "Applicant{name='" + name + "', experience=" + experience + ", age=" + age + ", city='" + city + "', student='" + student + "', education='" + education + "', typingSpeed=" + typingSpeed + ", englishLevel='" + englishLevel + "'}";
    }
    
}