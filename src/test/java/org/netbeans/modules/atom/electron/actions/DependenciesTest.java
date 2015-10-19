package org.netbeans.modules.atom.electron.actions;

import java.io.IOException;
import jdepend.framework.JDepend;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author spindizzy
 */
public class DependenciesTest {
    
    @Test
    public void testCycles() throws IOException {
        JDepend jdepend = new JDepend();
        jdepend.addDirectory("target/classes");

        jdepend.analyze();

        assertThat(jdepend.containsCycles(), is(false));
    }
}
