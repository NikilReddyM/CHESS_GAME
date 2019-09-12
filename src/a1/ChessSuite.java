package a1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import junit.framework.JUnit4TestAdapter;

@RunWith (Suite.class)
@Suite.SuiteClasses ({ KingTest.class,KnightTest.class,QueenTest.class,PawnTest.class,RookTest.class,BishopTest.class,ChessBoardTest.class})

public class ChessSuite {

    public static void main (String[] args)
    {
        junit.textui.TestRunner.run (suite());
    }

    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter (ChessSuite.class);
    }

}
