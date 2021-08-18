package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // Intializing the class field
    public static final int OUT = -1;
    public static final int IN = 1;
    public static final int CLOSED = 0;

    private int mSwing;

    //Class construtor to set the intial swing condition
    public Gate(){
        mSwing=CLOSED;
    }

    //Method to set the swing direction
    public boolean open(int direction){
        boolean value= true;
        if(direction == 1 || direction == -1) {
            setSwing(direction);
        }
        else{
            value=false;
        }
        return value;
    }

    //helper method to set the swing value
    public boolean setSwing(int direction){
        boolean value= true;
        if(direction==-1){
            mSwing=OUT;
        }
        else if(direction==1){
            mSwing=IN;
        }
        else if(direction==0){
            mSwing=CLOSED;
        }
        else {
            value=false;
        }
        return value;
    }

    //method to return the swing direction
    public int getSwingDirection(){
        return mSwing;
    }

    //method to control the movement of the snails
    public int thru(int count){
        if (mSwing==-1)
            return -count;
        if (mSwing==1)
            return count;
        return 0;
    }

    //method to return the string
    public String toString() {
        // for a gate that is closed
        if (mSwing == 0) {
            return "This gate is closed";
        }

        // for a gate that has opened to swing IN
        if (mSwing == 1)
            return "This gate is open and swings to enter the pen only";

        // for a gate that been opened swing OUT
        if (mSwing==-1)
            return "This gate is open and swings to exit the pen only";

        // for a gate that has a swing value other than IN, OUT, or CLOSED
        return "This gate has an invalid swing direction";
    }

    //method to close the swing direction i.e. gate
    public void close(){
        mSwing=0;
    }

}
