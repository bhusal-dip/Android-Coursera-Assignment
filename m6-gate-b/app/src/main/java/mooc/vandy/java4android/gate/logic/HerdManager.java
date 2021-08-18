package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mWestGate;

    /**
     * The output Gate object.
     */
    private Gate mEastGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    public static final int HERD = 24;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    void simulateHerd(Random random) {

        int nSnailsInsidePen = HERD;
        int r = 0;
        Gate gate = null;
        mOut.println((String) "There are currently " + nSnailsInsidePen + " snails in the pen and " + (HERD - nSnailsInsidePen) + " snails in the pasture");

        for (int i = 1; i <= 10; i++) {
            int nSnailsOutsidePen = HERD - nSnailsInsidePen;
            if (nSnailsInsidePen == HERD) {
                gate = mEastGate;
                //nSnailsInsidePen += mEastGate.thru(1 + random.nextInt(nSnailsInsidePen - 1));
            } else if (nSnailsOutsidePen == HERD) {
                gate = mWestGate;
                //nSnailsInsidePen += mWestGate.thru(1 + random.nextInt(nSnailsOutsidePen - 1));
            } else {
                //if (random.nextInt(2) != 0)
                if (random.nextBoolean()!=true)
                    gate = mWestGate;
                else
                    gate = mEastGate;
            }
            int nNumberSnails = 1;
            if (gate.getSwingDirection() == Gate.IN) {
                if (nSnailsOutsidePen > 1)
                    nNumberSnails = 1 + random.nextInt(nSnailsOutsidePen );
            } else if (gate.getSwingDirection() == Gate.OUT) {
                if (nSnailsInsidePen > 1)
                    nNumberSnails = 1 + random.nextInt(nSnailsInsidePen );
            }
            nSnailsInsidePen += gate.thru(nNumberSnails);
                /*
                {
                r = 0;
                if (nSnailsOutsidePen > 1) {
                    r = random.nextInt(nSnailsOutsidePen);
                } else if (nSnailsOutsidePen == 1) {
                    r = 1;
                }
                if (r > 0) {
                    nSnailsInsidePen += mWestGate.thru(r);
                }
                }
                */
            //}
            mOut.println((String) "There are currently " + nSnailsInsidePen + " snails in the pen and " + (HERD - nSnailsInsidePen) + " snails in the pasture");
            // TODO -- Fill your code in here
        }
    }
}