package org.netbeans.modules.atom.electron.actions;

import java.awt.event.ActionListener;
import javax.swing.Action;
import org.openide.loaders.DataObject;

/**
 * This class is a facade to perform the available actions.
 *
 * @author spindizzy
 */
public final class ElectronActionsPerformer {

    private ElectronActionsPerformer() {
    }

    public static void performRunAction(DataObject dao) {
        if (dao != null) {
            perform(new RunAction(dao));
        }
    }
    
    public static void performDebugAction(DataObject dao) {
        if(dao != null){
            perform(new DebugAction(dao));
        }
    }
    
    private static void perform(ActionListener action) {
        action.actionPerformed(null);
    }
}
