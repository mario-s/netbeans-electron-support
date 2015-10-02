package io.atom.electron.cmd;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.powermock.api.support.membermodification.MemberMatcher.field;

/**
 *
 * @author spindizzy
 */
public class ElectronRunCommandFactoryTest {
    
    private ElectronRunCommandFactory classUnderTest;
    
    @Before
    public void setUp() {
        classUnderTest = new ElectronRunCommandFactory();
    }
    

    /**
     * Test of createCommand method, of class ElectronRunCommandFactory.
     */
    @Test
    public void testCreateCommand_Win() throws IllegalArgumentException, IllegalAccessException {
        field(ElectronRunCommandFactory.class, "isWin").set(classUnderTest, true);
        Command result = classUnderTest.createCommand();
        assertEquals(AbstractCommandFactory.CMD, result.getExecutable());
    }
    
    /**
     * Test of createCommand method, of class ElectronRunCommandFactory.
     */
    @Test
    public void testCreateCommand_NotWin() throws IllegalArgumentException, IllegalAccessException {
        field(ElectronRunCommandFactory.class, "isWin").set(classUnderTest, false);
        Command result = classUnderTest.createCommand();
        assertEquals(ElectronRunCommandFactory.ELECTRON, result.getExecutable());
    }
    
}
