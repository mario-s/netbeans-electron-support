package io.atom.electron;

import java.awt.event.ActionEvent;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import org.netbeans.junit.NbTestCase;
import org.openide.loaders.DataObject;

/**
 *
 * @author spindizzy
 */
public class RunActionTest extends NbTestCase{
    
    private RunAction instance;
    
    public RunActionTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp(); 
        
        DataObject dataObject = mock(DataObject.class);
        
        instance = new RunAction(dataObject) {

            @Override
            String getFileDisplayName() {
                return "test.js";
            }
        };
    }

    /**
     * Test of actionPerformed method, of class RunAction.
     */
    @Test
    public void testActionPerformed() {
        ActionEvent ev = null;
        instance.actionPerformed(ev);
    }
    
}
