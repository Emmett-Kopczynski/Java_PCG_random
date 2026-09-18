package rgen;

/**
 *
 */
public class LCG{
    

    /** TODO document
     *
     */
    enum IntType {
        I32, I64;
    }


    /** TODO document
     *
     */
    private int state32;
    

    /** TODO document
     *
     */
    private long state64;
    

    /** TODO  document
     *
     */
    private int coefficient;


    /** TODO  document
     *
     */
    private int added;


    /** TODO document
     *
     */
    private IntType type;
    






    /** TODO document
     *
     */
    public LCG(int seed){
        /* TODO add error handling to ensure a valid seed*/
        this.state32 = seed;
        this.added = 3; /* TODO change the added to something more sensible */
        this.type = IntType.I32;
    } /* TODO implement */

    /** TODO document
     *
     */
    public LCG(long seed){
        /* TODO add error handling to ensure a valid seed*/
        this.state64 = seed;
        this.added = 3; /* TODO change the added to something more sensible */
        this.type = IntType.I64;
    } /* TODO implement */

    /** TODO document
     *
     */
    public LCG(int seed, int added){
        /* TODO add error handling to ensure a valid seed*/
        this.state32 = seed;
        this.added = added;
        this.type = IntType.I32;
    } /* TODO implement */

    /** TODO document
     *
     */
    public LCG(long seed, int added){
        /* TODO add error handling to ensure a valid seed*/
        this.state64 = seed;
        this.added = added;
        this.type = IntType.I64;
    } /* TODO implement */
    
}
