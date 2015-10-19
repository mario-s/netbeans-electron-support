package org.netbeans.modules.atom.electron.project;

import java.beans.PropertyChangeListener;
import javax.swing.Icon;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import org.netbeans.api.project.Project;
import org.openide.filesystems.FileObject;

/**
 *
 * @author spindizzy
 */
@RunWith(MockitoJUnitRunner.class)
public class ElectronProjectInformationTest {
    private static final String TEST = "test";
    
    private ElectronProjectInformation classUnderTest;
    
    @Mock
    private Project project;
    
    @Mock
    private FileObject fileObject;
    
    @Before
    public void setUp() {
        classUnderTest = new ElectronProjectInformation(project);
        when(project.getProjectDirectory()).thenReturn(fileObject);
    }

    /**
     * Test of getName method, of class ElectronProjectInformation.
     */
    @Test
    public void testGetName() {
        when(fileObject.getName()).thenReturn(TEST);
        String result = classUnderTest.getName();
        assertEquals(TEST, result);
    }
    

}
