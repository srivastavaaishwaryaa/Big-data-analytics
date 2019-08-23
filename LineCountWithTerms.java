import java.io.*;
class LineCountWithTerms{
    public static final String STR_HACKATHON="hackathon";
    public static final String STR_DEC="Dec";
    public static final String STR_CHICAGO="Chicago";
    public static final String STR_JAVA="Java";
    public static void main(String[] args){
        LineCountWithTerms lineCountWithTerms=new LineCountWithTerms();
        lineCountWithTerms.countLinesWithTerms();
    }

    void countLinesWithTerms(){
        String line = " ";
        int countLineWithHackathon = 0;
        int countLineWithDec = 0;
        int countLineWithChicago = 0;
        int countJava = 0;
        try {
            File file = new File("C:\\Users\\aishs\\Desktop\\hw2.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null) {
                if (line.contains(STR_HACKATHON)) {
                    countLineWithHackathon++;
                }
                if (line.contains(STR_DEC)) {
                    countLineWithDec++;
                }
                if (line.contains(STR_CHICAGO)) {
                    countLineWithChicago++;
                }
                if (line.contains(STR_JAVA)) {
                    countJava++;
                }
            }
            System.out.println("The number of lines with Hackathon " + countLineWithHackathon);
            System.out.println("The number of lines with Dec " + countLineWithDec);
            System.out.println("The number of lines with Chicago " + countLineWithChicago);
            System.out.println("The number of lines with Java " + countJava);
        } catch(IOException ioException)
        {
          System.out.println("System error");
        }
    }
}
