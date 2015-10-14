package io.atom.electron.cmd;

import io.atom.electron.glue.Preferences;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import static org.powermock.api.support.membermodification.MemberMatcher.field;

/**
 *
 * @author spindizzy
 */
@RunWith(MockitoJUnitRunner.class)
public class ElectronRunCommandFactoryTest {
    
    private ElectronRunCommandFactory classUnderTest;
    
    @Mock
    private Preferences preferences;
    
    @Before
    public void setUp() {
        classUnderTest = new ElectronRunCommandFactory(preferences);
    }
    
    /**
     * Test of createCommand method, of class ElectronRunCommandFactory.
     */
    @Test
    public void testCreateCommand_Win_PreferencesNull() throws IllegalArgumentException, IllegalAccessException {
        classUnderTest = new ElectronRunCommandFactory(null);
        field(ElectronRunCommandFactory.class, "isWin").set(classUnderTest, true);
        Command result = classUnderTest.createCommand();
        assertEquals(AbstractCommandFactory.CMD, result.getExecutable());
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
    
     /**
     * Test of createCommand method, of class ElectronRunCommandFactory.
     */
    @Test
    public void testCreateCommand_Executable() throws IllegalArgumentException, IllegalAccessException {
        field(ElectronRunCommandFactory.class, "isWin").set(classUnderTest, false);
        when(preferences.getExecutable()).thenReturn("test");
        Command result = classUnderTest.createCommand();
        assertEquals("test", result.getExecutable());
    }
    
}
