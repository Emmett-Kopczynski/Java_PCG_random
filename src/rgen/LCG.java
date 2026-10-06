package rgen;

/** TODO document
 *
 */
public class LCG extends RandGen{
    
    /* Variable Fields */

    /** TODO document
     *
     */
    protected long increment;


    /** TODO document
     *
     */
    protected long coeficcient;
    



    /* Constructors */

    /** TODO document 
     *
     */
    private LCG(int seed){
        super(seed);
        this.coeficcient = 690069; /* taken from wikipedia's LCG page */
        this.increment = 1; /* taken from wikipedia's LCG page */
    }


    /** TODO document 
     *
     */
    private LCG(long seed){
        super(seed);
        this.coeficcient = 6364136223846793005l; /* taken from wikipedia's LCG page */
        this.increment = 825366247; /* taken from wikipedia's LCG page */
    }


    /** TODO document
     *
     */
    private LCG(){
        super();
        this.coeficcient = 6364136223846793005l; /* taken from wikipedia's LCG page */
        this.increment = 1; /* taken from wikipedia's LCG page */
    }


    /** TODO document 
     *
     */
    public static LCG makeLCG(){
        return new LCG();
    }


    /** TODO document
     *
     */
    public static LCG makeLCG32(int seed){
        return new LCG(seed);
    }


    /** TODO document
     *
     */
    public static LCG makeLCG64(long seed){
        return new LCG(seed);
    }
    




    /* getters and setters */

    @Override
    public void stepForward(){
        if(super.bitcount == IntType.I32){
            super.state32 = (((int)this.coeficcient) * super.state32) + ((int)this.increment);
        } else{
            super.state64 = (this.coeficcient * super.state64) + this.increment;
        }
    }


   
} /* TODO implement */
