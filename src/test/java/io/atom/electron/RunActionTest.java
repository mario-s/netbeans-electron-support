package io.atom.electron;

import java.util.concurrent.Future;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.netbeans.junit.NbTestCase;
import org.openide.loaders.DataObject;

/**
 *
 * @author spindizzy
 */
public class RunActionTest extends NbTestCase {

    private RunAction instance;

    private TaskObserver taskObserver;

    public RunActionTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        taskObserver = mock(TaskObserver.class);

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
