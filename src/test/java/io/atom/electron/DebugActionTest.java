package io.atom.electron;

import java.net.URL;
import java.util.List;
import java.util.concurrent.Future;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.netbeans.junit.NbTestCase;
import org.openide.awt.HtmlBrowser;
import org.openide.loaders.DataObject;

/**
 *
 * @author spindizzy
 */
public class DebugActionTest extends NbTestCase {

    private DebugAction instance;

    private RunAction delegate;
    
    private HtmlBrowser.Impl browserImpl;

    public DebugActionTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        delegate = mock(RunAction.class);
        
        browserImpl = mock(HtmlBrowser.Impl.class);

        instance = new DebugAction(mock(DataObject.class)) {

            @Override
            AbstractElectronAction createRunAction() {
                return delegate;
            }

            @Override
            HtmlBrowser.Impl createBrowser() {
                return browserImpl;
            }
            
            
        };
    }

    /**
     * Test of actionPerformed method, of class RunAction.
     */
    @Test
    public void testActionPerformed() {
        instance.actionPerformed(null);
        verify(browserImpl).setURL(any(URL.class));
        verify(delegate).addProcessArguments(any(List.class));
        verify(delegate).actionPerformed(null);
    }

}
