package org.netbeans.modules.atom.electron.project;

import java.util.List;
import javax.swing.event.ChangeListener;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import org.openide.filesystems.FileObject;
import org.openide.nodes.Node;

/**
 *
 * @author spindizzy
 */
@RunWith(MockitoJUnitRunner.class)
public class SourceNodeListTest {
    
    private SourceNodeList classUnderTest;
    
    @Mock
    private ElectronProject project;
    
    @Mock
    private FileObject projectDir;
    
    @Before
    public void setUp() {
        classUnderTest = new SourceNodeList(project);
        when(project.getProjectDirectory()).thenReturn(projectDir);
    }

    /**
     * Test of keys method, of class SourceNodeList.
     */
    @Test
    public void testKeys_NoChildren() {
        when(projectDir.getFileObject(SourceNodeList.SRC)).thenReturn(projectDir);
        when(projectDir.getChildren()).thenReturn(new FileObject[]{projectDir});
        List<Node> result = classUnderTest.keys();
        Node root = result.iterator().next();
        assertEquals(0, root.getChildren().getNodes().length);
    }

}
