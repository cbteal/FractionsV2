
/**
 * The Fraction class represents a mathematical integer fraction. The methods 
 * available to this class are equals, isValidFraction, toReducedForm, and
 * getGreatestCommonDenominator. Instance variables include numerator and
 * denominator.
 * 
 * Connor Teal
 */
public class Fraction
{
    private int denom;
    private int num;

    public Fraction(){
        //no arg constructor
    }

    /**
     * Constructor for the Fraction class. Will construct the class with given
     * numerator and denominator.
     *
     * Takes two integers (num,denom)
     * No return
     */
    public Fraction(int num, int denom){
        if(isValidFraction(denom)){
            this.denom = denom;
        }
        else{
            System.out.println("You can't divide by zero. Crashing!");
            System.exit(-1);
        }
        this.setFraction(num,denom);
    }
   
    /**
     * equals method will compare a fraction to another fraction, determining if
     * they're equal. It compares their instance variables (numerator & 
     * denominator)
     * 
     * Takes Fraction object
     * Returns Boolean (True if equal)
     */
     public boolean equals(Fraction that){
         
        if(this.num == that.num && this.denom == that.denom){
            return true;
        }

        return false;
    }

    /**
     * isValidFraction makes sure that the denominator is non-zero.
     * 
     * Takes integer (denominator)
     * Returns boolean (true if non-zero)
     */
    private boolean isValidFraction(int denom){
        if(denom != 0){
            return true;
        }

        return false;
    }

    @Override
    public String toString(){
        return this.num + "/" + this.denom;
    }

    /**
     * Method used to set the numerator of a fraction.
     * 
     * Takes int
     * No return
     */
    public void setNum(int num){
        this.num = num;
    }

    /**
     * Method used to set the denominator of a fraction.
     * 
     * Takes int
     * No return
     */
    public void setDenom(int denom){
        this.denom = denom;
    }

    /**
     * Method used to get the numerator of a fraction.
     * 
     * No Args
     * Returns int numerator
     */
    public int getNum(){
        return this.num;
    }

    /**
     * Method used to get the denominator of a fraction.
     * 
     * No Args
     * Returns int denominator
     */
    public int getDenom(){
        return this.denom;
    }
    
    /**
     * Method used to transform the fraction into it's reduced form.
     * 
     * No args
     * Returns Fraction Object in reduced form
     */
    public Fraction toReducedForm(){
       int divisor = getGreatestCommonDenominator();
       return new Fraction(this.num / divisor, this.denom / divisor);
    }
    
    /**
     * Method for calculating the greatest common denominator of two numbers.
     * This uses the Euclidean Algorithm which can be found using google. I
     * specifically used https://www.math.rutgers.edu/~greenfie/gs2004/euclid.html
     * 
     * Takes two integers as input
     * Returns integer (greatest common denominator)
     */
    private int greatestCommonDenominator(int x, int y){
        if(y == 0){
            return x;
        }
        if(x == 0){
            return y;
        }
        
        int remainder = x % y;
        
        return greatestCommonDenominator(y, remainder);
    }
    
    /**
     * getGreatestCommonDenominator returns the greatest common denominator of a Fraction.
     * 
     * No Args
     * Returns greatestCommonDenominator
     */
    public int getGreatestCommonDenominator(){
        return greatestCommonDenominator(this.num,this.denom);
    }
    
    /**
     * setFraction serves the purpose of setting the numerator and denominator at the same time.
     * 
     * Two integer arguments (num,denom)
     * No return
     */
    public void setFraction(int num, int denom){
        int divisor = greatestCommonDenominator(num,denom);
        this.num = num / divisor;
        this.denom = denom / divisor;
        this.switchSigns();
    }
    
    /**
     * switchSigns is designed to check for two cases. One is that the denominator is
     * exclusively negative, and one that is when both numerator and denominator are 
     * negative. In either case it flips their signs so that the negative sign is in front
     * of the numerator, or they cancel out.
     * 
     * No args
     * No Returns
     */
    private void switchSigns(){
        if(this.num >= 0 && this.denom < 0){
            this.num *= -1;
            this.denom *= -1;
        }
        if(this.num < 0 && this.denom < 0){
            this.num *= -1;
            this.denom *= -1;
        }
    }
}
