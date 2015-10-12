package io.atom.electron;

import java.util.concurrent.Future;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;
import org.openide.loaders.DataObject;

/**
 *
 * @author spindizzy
 */
@RunWith(MockitoJUnitRunner.class)
public class RunActionTest{

    private RunAction instance;

    @Mock
    private TaskObserver taskObserver;

    @Before
    public void setUp() throws Exception {

        instance = new RunAction(mock(DataObject.class)) {

            @Override
            String getFileDisplayName() {
                return "test.js";
            }

            @Override
            TaskObserver createObserver() {
                return taskObserver;
            }

        };
    }

    /**
     * Test of actionPerformed method, of class RunAction.
     */
    @Test
    public void testActionPerformed() {
        instance.actionPerformed(null);
        verify(taskObserver).observe(any(Future.class));
    }

}
