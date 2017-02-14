import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * FractionsV2Driver combines the fractions classes that were created to solve
 * the homework problem. It is also where the Scanner will be declared so that
 * we can feed the classes data to store and process.
 * 
 * Connor Teal
 */
public class FractionsV2Driver
{
    public static void main(String[] args){
	String path = "../";
        String fileName = "fractions.txt";
        //String fileName = "testemptyfile.txt";
        //String fileName = "testNegs.txt";
        //String fileName = "testHugeFile.txt";
        //String fileName = "testFormat.txt";
        File inputFile = new File(path + fileName);
        Scanner input = null;

        try{
            input = new Scanner(inputFile);
        }
        catch(FileNotFoundException e){
            System.out.println("The file couldn't be found. Closing!");
            System.exit(-1);
        }

        ObjectList fractionList = new ObjectList();
        
        //If handed an empty file close the program
        if(input.hasNext() == false){
            System.out.println("You entered an empty file. Closing!");
            System.exit(-1);
        }
        
        //While the text isn't empty -- reduce, count, and populate
        while(input.hasNext()){
            FractionProcessor fp = new FractionProcessor(input.next());
            Fraction fraction = new Fraction(fp.getNum(), fp.getDenom()).toReducedForm();

            if(fractionList.contains(fraction) == false){
                fractionList.add(new FractionCounter(fraction));
            }
            for(int i = 0; i < fractionList.length(); i++){
                fractionList.getIndex(i).compareAndIncrement(fraction);
            }
        }

        //Prints the fractions to Console
        System.out.print(fractionList.toString());
    }
}
