package rgen;

import java.time.LocalDateTime;

/** The RandGen Abstract class is a blueprint for building a Random Number Generator <br />
 * Supports having a 32 or 64 bit state, and has a wide variety of functions to generate with
 *
 */
public abstract class RandGen{
   
    
    /* VARIABLE FIELDS */

    /** IntType : an enum used to store how many bits are in the state used by a random number generator <br />
     * States : <br />
     * - I32 : denotes a 32 bit number <br />
     * - I64 : denotes a 64 bit number
     *
     */
    protected enum IntType {
        I32, I64;
    }


    /** state32 : the state of the psudo-random number generator 
     * if the state is 32 bits
     */
    protected int state32;


    /** state64 : the state of the psudo-random number generator
     * if the state is 64 bits
     */
    protected long state64;
    
    
    /** bitcount : stores whether the psudo-random number generator is
     * using a 32 bit state or a 64 bit state with an IntType enum
     */
    protected IntType bitcount;
    


    

    /* CONSTRUCTORS */

    /** RandGen : constructor for the RandGen class if you want to use a 32 bit state
     *
     * @param seed : type int : the 32 bit seed
     */
    public RandGen(int seed){
        this.bitcount = IntType.I32;
        this.setSeed32(seed);
    }
    

    /** RandGen : constructor for the RandGen class if you want to use a 64 bit state
     *
     * @param seed : type long : the 64 bit seed
     */
    public RandGen(long seed){
        this.bitcount = IntType.I64;
        this.setSeed64(seed);
    }


    /** RandGen : constructor for the RandGen class, seeds with the current time
     * and defaults to a 64 bit state
     */
    public RandGen(){
        this.bitcount = IntType.I64;
        timeSeed();
    }

    



    /* GETTERS AND SETTERS */
    
    /** setSeed32 : seeds the generator with the given int, more predictable that setSeed64(long) if on a 64 bit generator
     *
     * @param seed : type int : the int that will seed the generator
     */
    public void setSeed32(int seed){
        if(this.bitcount == IntType.I64){
            setSeed64((long) seed);
            return;
        }
        this.state32 = seed;
    }


    /** setSeed64 : seeds the generator with the given long, less secure than setSeed32(int) if on a 32 bit generator
     *
     * @param seed : type long : the long that will seed the generator
     */
    public void setSeed64(long seed){
        if(this.bitcount == IntType.I32){
            if(seed > Integer.MAX_VALUE) {seed %= Integer.MAX_VALUE;}
            setSeed32((int)seed); 
            return;
        }
        this.state64 = seed;
    }

    
    /** timeSeed : seeds the generator with the current time, works on 32 bit and 64 bit generators
     */
    public void timeSeed(){
        try{
            if(this.bitcount == IntType.I32){
                this.timeSeed32();
            } else {
                this.timeSeed64();
            }
        }
        catch(Exception e){ /* should never occur, like it should be impossible */
            System.err.println("[ERROR] :: Generator Remains Unseeded");
        }
    }


    /** timeSeed32 : seeds the generator with an int based on the current time
     *
     * @throws IllegalCallerException if called on a 64 bit state generator
     */
    protected void timeSeed32() throws IllegalCallerException {
        if(this.bitcount != IntType.I32) {
            throw new IllegalCallerException("called timeSeed32 on a " + this.getBitCount() + " bit state generator");
        }
        this.state32 = LocalDateTime.now().getNano();
    } 


    /** timeSeed64 : seeds the generator with a long based on the current time
     *
     * @throws IllegalCallerException if called on a 32 bit state generator
     */
    protected void timeSeed64() throws IllegalCallerException {
        if(this.bitcount != IntType.I64) { 
            throw new IllegalCallerException("Called timeSeed64 on a " + this.getBitCount() + " bit state generator");
        }
        this.state64 = System.currentTimeMillis();
    }


    /** getBitCount : returns the amount of bits used to store the  
     * internal state of the Pseudo-Random Number Generator
     *
     *
     * @return the amount of bits in the internal state as an integer, either 32 or 64
     */
    public int getBitCount(){
        if(this.bitcount == IntType.I32){
            return 32;
        } else {
            return 64;
        }
    }


    /** stepForward : makes the psudorandom number generator take 1 step foreward 
     */
    protected abstract void stepForward();





    /* Basic Gen Functions */

    /** genBool : generates a random boolean, either true or false
     *
     * @return a random boolean, either true or false 
     */
    public boolean genBool(){
        return false;
    } /* TODO implement */

    
    /** genInt : generates a random integer between Integer.MIN_VALUE and Integer.MAX_VALUE 
     *
     * @return an integer between Integer.MIN_VALUE and Interer.MAX_VALUE
     */
    public int genInt(){
        if(this.bitcount == IntType.I32){
            this.stepForward();
            return state32;
        } else {
            this.stepForward();
            return (int)(state64 >> 32);
        }
    }


    /** genLong : generates a random long between Long.MIN_VALUE and Long.MAX_VALUE
     *
     * @return a long between Long.MIN_VALUE and Long.MAX_VALUE
     */
    public long genLong(){
        return -1;
    } /* TODO implement */


    /** genChar : returns an ascii character at Random
     *
     * @return an ascii character between 32 (' ') and 126 ('~') inclusive
     */
    public char genChar(){
        return 'o';
    } /* TODO implement */

    
    /** genDouble : returns a double between 0.0 and 1.0 inclusive
     *
     * @return a double between 0.0 and 1.0 inclusive
     */ 
    public double genDouble(){
        return -1.0;
    } /* TODO implement */


    /** genFloat : returns a float between 0.0 and 1.0 inclusive
     *
     * @return a float between 0.0 and 1.0 inclusive
     */
    public float genFloat(){
        return -1.0f;
    } /* TODO implement */





    /* Bounded Gen Functions */
    
    /** boundedIntGen : returns an integer between a and b inclusive
     *
     * @param a : type int : the lowest number that could be returned
     *
     * @param b : type int : the largest number that could be returned
     *
     * @return an integer between a and b inclusive
     */
    public int boundedIntGen(int a, int b){
        return -1;
    } /* TODO implement */

    
    /** boundedLongGen : returns a long between a and b inclusive
     *
     * @param a : type long : the lowest long that could be returned
     *
     * @param b : type long : the largest long that could be returned
     *
     * @return a long between a and b inclusive
     *
     */
    public long boundedLongGen(long a, long b){
        return -1;
    } /* TODO implement */


    /** boundedDoubleGen : returns a double between a and b inclusive
     *
     * @param a : type double : the lowest double that could be returned
     *
     * @param b : type double : the largeset double that could be returned
     *
     * @return a double between a and b inclusive
     *
     */
     public double boundedDoubleGen(double a, double b){
         return -1.0;
     } /* TODO implement */


    /** boundedFloatGen : returns a float between a and b inclusive
     *
     * @param a : type float : the lowest float that could be returned
     *
     * @param b : type float : the largest float that could be returned
     *
     * @return a float between a and b inclusive
     *
     */
    public float boundedFloatGen(float a, float b){
        return -1.0f;
    } /* TODO implement */


} 
