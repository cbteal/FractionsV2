
/**
 * The FractionProcessor class is responsible for processing the String that
 * Scanner pulls from the text file. It will break the string into components
 * and convert from String to integers, which will be ready to use as inputs
 * for the Fraction class.
 * 
 * Connor Teal
 * 
 */
public class FractionProcessor
{
    private String inputFraction;
    private int num;
    private int denom;

    public FractionProcessor(){
        this.inputFraction = "";
    }

    public FractionProcessor(String inputFraction){
        this.inputFraction = inputFraction;
        this.deconstructFractionString();
    }

    /**
     * Private deconstructFractionString method will split a string in format "num/denom"
     * then convert each from string to integers and store them in the local
     * variables of the Fraction Processor Class.
     * 
     * No Args
     * No Return
     */
    private void deconstructFractionString(){
        String[] values = this.inputFraction.split("/");
        try{
            this.num = Integer.parseInt(values[0]);
            this.denom = Integer.parseInt(values[1]);
        }catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
            System.out.println("Error: Fraction inputs must be in form Num/Denom.");
            System.exit(-1);
        }
    }

    /**
     * Getter method for returning the num value of a FractionProcessor
     * 
     * No Args
     * Returns int (Numerator)
     */
    public int getNum(){
        return this.num;
    }

    /**
     * Getter method for returning the denom value of a FractionProcessor
     * 
     * No Args
     * Returns int (Denominator)
     */
    public int getDenom(){
        return this.denom;
    }
}
