package org.netbeans.modules.atom.electron.project;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.isNotNull;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.NodeList;
import org.openide.filesystems.FileObject;
import org.openide.util.Lookup;

/**
 *
 * @author spindizzy
 */
@RunWith(MockitoJUnitRunner.class)
public class SourceNodeFactoryTest {

    private SourceNodeFactory classUnderTest;

    @Mock
    private Project project;
    
    @Mock
    private Lookup lookup;
    
    @Mock
    private ElectronProject electronProject;
    
    @Mock
    private FileObject fileObject;

    @Before
    public void setUp() {
        classUnderTest = new SourceNodeFactory();
        when(project.getLookup()).thenReturn(lookup);
    }

    /**
     * Test of createNodes method, of class SourceNodeFactory.
     */
    @Test(expected = AssertionError.class)
    public void testCreateNodes_ProjectNotPresent() {
        classUnderTest.createNodes(project);
    }

     /**
     * Test of createNodes method, of class SourceNodeFactory.
     */
    @Test
    public void testCreateNodes_ProjecttPresent() {
        when(lookup.lookup(ElectronProject.class)).thenReturn(electronProject);
        when(electronProject.getProjectDirectory()).thenReturn(fileObject);
        NodeList result = classUnderTest.createNodes(project);
        assertNotNull(result.keys());
    }
    
}
