/**
 * The ObjectList class is a class that allows the storage of various Java
 * Objects in a List ADT. The list is dynamic in size, it stores data like
 * an array. The included methods such as getIndex allow random access to
 * the list.
 * 
 * Connor Teal
 */
public class ObjectList{
    
    private Object[] myFractions;;
    private int numElements = 0;
    
    public ObjectList(){
        myFractions = new Object[100];
    }
    
    /**
     * add method will append a new Object to our List of objects.
     * 
     * Takes Object
     * No return
     */
    public void add(Object n){
        if(numElements > myFractions.length){
            this.myFractions = resizeObjectList(this.myFractions);
        }
        this.myFractions[numElements++] = n;
    }
    
    /**
     * toString will print the objects in the list, seperated by a new line.
     * 
     * No args
     * Returns String
     */
    @Override
    public String toString(){
        String retval = "";
        for(int i = 0; i < numElements; i++){
            retval += this.getIndex(i).toString() + "\n";
        }
        return retval;
    }
    
    /**
     * length returns the number of elements in our list
     * 
     * No args
     * Returns integer (number of elements)
     */
    public int length(){
        return this.numElements;
    }
    
    /**
     * getIndex will return the object (Fraction Counter) at the desired
     * index in the List.
     * 
     * Takes integer (index)
     * Returns FractionCounter
     */
    public FractionCounter getIndex(int target){
        return (FractionCounter)myFractions[target];
    }
    
    /**
     * contains checks to see if a given fraction is contained in the list
     * of Fraction Counters.
     * 
     * Takes Fraction (target)
     * Returns Boolean (True if contains)
     */
    public boolean contains(Fraction target){
        for(int i = 0; i < this.length(); i++){
            FractionCounter temp = (FractionCounter)myFractions[i];
            if(temp.getFraction().equals(target)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * resizeObjectList will double the size of the array used to store objects.
     * 
     * Takes Object Array
     * Returns Object Array (Twice as large)
     */
    private Object[] resizeObjectList(Object[] input){
        Object[] temp = new Object[input.length * 2];
        for(int i = 0; i < this.length(); i++){
            myFractions[i] = temp[i];
        }
        
        return temp;
    }
}
