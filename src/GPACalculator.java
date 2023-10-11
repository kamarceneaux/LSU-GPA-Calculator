public class GPACalculator {
    public static void main(String[] args) {
        System.out.println(gradePoints("F-"));
    }


    public static double gradePoints(String grade){
        double gpa = 0.000;
        //This line of code determines if a grape
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
