package io.atom.electron;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;
import org.openide.awt.HtmlBrowser;
import org.openide.loaders.DataObject;

/**
 *
 * @author spindizzy
 */
@RunWith(MockitoJUnitRunner.class)
public class DebugActionTest {

    private DebugAction instance;

    @Mock
    private RunAction delegate;
    
    @Mock
    private HtmlBrowser.Impl browserImpl;


    @Before
    public void setUp() {

        instance = new DebugAction(mock(DataObject.class)) {

            @Override
            AbstractElectronAction createRunAction() {
                return delegate;
            }

            @Override
            HtmlBrowser.Impl createBrowser() {
                return browserImpl;
            }

            @Override
            void launchInspector() {
            }
        };
    }

    /**
     * Test of actionPerformed method, of class RunAction.
     */
    @Test
    public void testActionPerformed() {
        instance.actionPerformed(null);
        verify(delegate).actionPerformed(null);
//        verify(browserImpl).setURL(any(URL.class));
    }

}
