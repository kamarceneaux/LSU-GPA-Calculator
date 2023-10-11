import java.util.Scanner;

public class GPACalculator {
    public static void main(String[] args) {
        // Initial Variables
        double GPA = 0.00;
        double totalQPoints = 0;
        int totalCreditHours = 0;
        boolean runningProgram = true;

        Scanner inputScanner = new Scanner(System.in);

        //Description Method
        System.out.println("Enter your class, followed by many credit hours it is. Please enter \"Done\" when finished.");

        while (runningProgram){
            String userGrade = inputScanner.nextLine().toUpperCase();

            if(userGrade.equals("DONE")){
                runningProgram = false;
            }else{
                String[] splitInput = userGrade.split(" ");

                //Ensure that input format is somewhat valid.
                if(splitInput.length != 2){
                    System.out.println("Input is not valid. Try again or enter \"done\" to exit the program.");
                }else{
                    double gradePoint = gradePoints(splitInput[0]);
                    int creditHours = Integer.parseInt(splitInput[1]);

                    //REMEMBER: if the value of gradePoint is negative one than the grade input was not interpreted.
                    if(gradePoint != -1){
                        totalQPoints += gradePoint * creditHours;
                        totalCreditHours += creditHours;
                    }else{
                        System.out.println("Input was not interpreted. Try again or enter \"done\" to exit the program.");
                    }
                }

            }
        }

        inputScanner.close();

    }

    /**
     * gradePoints returns the grade point of a singular class period (without considering the credit hours) as
     * a double.
     *
     * @param grade should be a String containing a valid letter grade and plus (+) or minus (-), if applicable.
     * @return a <code>Integer</code> containing the grade point of a class (in the 4.0 Scale) <em>BUT</em> the method
     * could return <code>-1</code>, if the formatting of the original grade passed in is invalid.
     *
     */
    public static double gradePoints(String grade){
        double gpa = 0.000;
        //This line of code determines if a grade is in the right format
        if(grade.length() > 0 && grade.length() < 3){
            // Return a gradePoint based on a score
            if (grade.length() == 1){
                gpa = wholeGradeInformation(grade);
            }

            /*
             * This loop checks to make sure that if you pass in a invalid grade such as "G", "W", or etc. That the
             * input doesn't go through this if block below. This block checks to see if a grade has a "+" or "-" to
             * determine how much to drop or increase the score according the LSU Plus/Minus grade chart.
             * */
            if(!(grade.length() == 1) || gpa == -1 ){
                gpa = wholeGradeInformation(grade.substring(0,1).toUpperCase());
                if(grade.contains("+") && grade.toUpperCase().charAt(0) != 'F'){
                    gpa += 0.3;
                }
                if(grade.contains("-") && grade.toUpperCase().charAt(0) != 'F'){
                    gpa -= 0.3;
                }
            }
            return gpa;
        }
        return -1;
    }

    /**
     * This function will return the value before the decimal for a person's GPA
     * @param grade a character containing a letter grade (e.g 'A')
     * @return a <code>Integer</code> containing the whole number form of a grade.
     */
    private static int wholeGradeInformation(String grade){
        switch (grade) {
            case "A": return 4;
            case "B": return 3;
            case "C": return 2;
            case "D": return 1;
            case "F": return 0;
            default: return -1;
        }
    }
}
