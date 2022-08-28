# Lecture #01.6 - File I/O - Notes

In this lecture, we will discuss how to read a CSV file in Java using different methods. The data is multiplying with time; all such data is kept in these CSV files. There is a need to understand the techniques to read these files using Java. We will learn all such methods in this lecture. 

## Summary
In this lecture, we will learn different ways to read CSV file in Java. We can use any one of the three methods to read Java CSV file, such as...

* `Scanner` class
* `BufferedReader` class
* OpenCSV API

## What is CSV file?
* The CSV file stands for the Comma-Separated Values file. It is a simple plain-text file format that stores tabular data in columns in simple text forms, such as a spreadsheet or database, and splits it by a separator. The separator used to split the data usually is commas `,`.
* We can import files in the CSV format and export them using programs like Microsoft Office and Excel, which store data in tables. The CSV file uses a delimiter to identify and separate different data tokens in a file.
* The use of the CSV file format is when we move tabular data between programs that natively operate on incompatible formats.

## How to create a CSV File?
* We can create a CSV file in the following ways: using Microsoft Excel, Notepad++ editor, VS Code...
* Write some data into file separated by comma `,`, like the following:
    ```
    Mr. Raju, Dixit, 3603286012, Burdwan
    Mr. Joseph, Patil, 4645968519, Hoogly
    Mr. Andrew, Mukherjee, 9067215139, Burmingham
    Mr. Varun, Patel, 2503595381, Sindh
    Mr. Michael, Baldwin, 7631068844, Kentucky
    Mr. Emmanuel, Agarwal, 3538037535, Nice
    Mr. Sumeet, Patil, 6871075256, Aukland
    Mr. Pranab, Kulkarni, 7982264359, Hubli
    Mr. Rajeev, Singh, 3258837884, Patiala
    Mr. Sujay, Kapoor, 5127263160, Mumbai
    ```

## Ways to read CSV file in Java

There are the following three more common ways to read a CSV file in Java:

### Scanner
* The `Scanner` class of Java provides various methods by which we can read a CSV file. It provides a constructor that produces values scanned from the specified CSV file. This class also breaks the data in the form of tokens.
*  There is a delimiter pattern, which, by default, matches white space. Then, using different types of `next()` methods, we can convert the resulting tokens.
    ```
    public class CSVReaderDemo {
        public static void main(String[] args) throws Exception {
            // Parsing a CSV file into the constructor of Scanner class
            Scanner sc = new Scanner(new File("C:\\Users\\Dell\\Desktop\\csvDemo.csv"));
            
            // Setting comma as delimiter pattern
            sc.useDelimiter(",");
            
            while (sc.hasNext()) {
                System.out.print(sc.next());
            }
            
            // Closes the scanner
            sc.close();
        }
    }
    ```

### BufferedReader
* The `split()` method identifies the delimiter and split the rows into tokens.
    ```
    public class CSVReader {
        public static void main(String[] args) {
            String line = "";
            String splitBy = ",";
            
            try {
                // Parsing a CSV file into BufferedReader class constructor  
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Dell\\Desktop\\csvDemo.csv"));
                
                // Returns a Boolean value
                while ((line = br.readLine()) != null) {
                    // Use comma as separator
                    String[] employee = line.split(splitBy);
                    
                    System.out.println("First Name=" + employee[1] + ", Last Name=" + employee[2] + ", Contact=" + employee[3] + ", City= " + employee[4]);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    ```

### OpenCSV API
* OpenCSV API is a third party API. This API provides standard libraries to read various versions of the CSV file. The OpenCSV API also offers better control to handle the CSV files. This library can also read Tab-Delimited File or TDF file format.
* Its features include:
    * Reading Any number of values per line.
    * Avoiding commas in quoted elements.
    * Handling entries that span multiple lines.
* We use the `CSVReader` class to read a CSV file. The class `CSVReader` provides a constructor to parse a CSV file.
* Steps to read Java CSV file in Eclipse IDE:
    1. Create a class file with the name `CSVReaderDemo` and write the following code.
    2. Create a lib folder in the project.
    3. [Download opencsv-3.8.jar](https://repo1.maven.org/maven2/com/opencsv/opencsv/3.8/opencsv-3.8.jar)
    4. Copy the `opencsv-3.8.jar` and paste into the `lib` folder.
    5. Run the program.

    ```
    public class CSVReaderDemo {
        public static void main(String[] args) {
            try {
                // Parsing a CSV file into CSVReader class constructor  
                CSVReader reader = new CSVReader(new FileReader("C:\\Users\Dell\Desktop\csvDemo.csv"));
                
                String[] nextLine;

                // Reads one line at a time  
                while ((nextLine = reader.readNext()) != null) {
                    for (String token: nextLine) {
                        System.out.print(token);
                    }

                    System.out.print("\n");
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    ```