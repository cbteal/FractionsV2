
/**
 * This class is responsible for dealing with counting of Fraction
 * objects. It will store a fraction and count as instance variables. 
 * The public methods you'll be able to use include toString, equals
 * (that compares FractionCouters against their fraction instance 
 * variable), getFraction, and compareAndIncrement which will tell us
 * if a fraction matches our fraction counter.
 * 
 * Connor Teal
 */
public class FractionCounter
{
    private Fraction fraction; 
    private int count;  //stores number of times seen
    
    public FractionCounter(){
        this.count = 0;
        //no arg constructor
    }
    
    /**
     * Copy constructor. This constructor will create a new Counter
     * object that is identical to the input.
     * 
     * Takes Fraction Object
     * No Return
     */
    public FractionCounter(Fraction fraction){
        this.fraction = fraction;
    }

    /**
     * Method that will compare a fraction to the FractionCounter and 
     * increment the counter of the Object if the fractions are 
     * equivalent.
     * 
     * Takes a fraction as input.
     * Returns a boolean (true if match)
     */
    public boolean compareAndIncrement(Fraction fraction){
        if(this.fraction.equals(fraction)){
            count++;
            return true;
        }
        return false;
    }
    
    /**
     * Equals will compare two Fraction Counter Objects to check 
     * equivalence strictly on their fraction value.
     * 
     * Takes FractionCounter Object as input
     * Returns boolean (true if match)
     */
    public boolean equals(FractionCounter fc){
        if(this.getFraction() == fc.getFraction()){
            return true;
        }
        return false;
    }
    
    /**
     * To String method will return a string of the fraction variable
     * and count variable in the following format: 
     * "Num/Denom count: (count)"
     * 
     * Takes no input
     * Returns string
     */
    @Override
    public String toString(){
        return fraction.toString() + " count: " + count;
    }
    
    /**
     * getFraction() will return a copy of the fraction Object that
     * belongs to the Fraction Counter it's called by.
     * 
     * Takes no input
     * Returns fraction object
     */
    public Fraction getFraction(){
        return this.fraction;
    }
}
