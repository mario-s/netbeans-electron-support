package org.netbeans.modules.atom.electron.project;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openide.util.Lookup;

/**
 *
 * @author spindizzy
 */
@RunWith(MockitoJUnitRunner.class)
public class ElectronActionsProviderTest {
    
    private ElectronActionsProvider classUnderTest;
    
    @Mock
    private ElectronProject project;
    
    @Before
    public void setUp() {
        classUnderTest = new ElectronActionsProvider(project);
    }

    /**
     * Test of getSupportedActions method, of class ElectronActionsProvider.
     */
    @Test
    public void testGetSupportedActions() {
        String[] result = classUnderTest.getSupportedActions();
        assertTrue(result.length > 0);
    }

    /**
     * Test of invokeAction method, of class ElectronActionsProvider.
     */
    @Test
    public void testInvokeAction() {
        String command = "";
        Lookup context = null;
        classUnderTest.invokeAction(command, context);
    }

    /**
     * Test of isActionEnabled method, of class ElectronActionsProvider.
     */
    @Test
    public void testIsActionEnabled() {
        String command = "";
        Lookup context = null;
        assertTrue(classUnderTest.isActionEnabled(command, context));

    }
    
}
