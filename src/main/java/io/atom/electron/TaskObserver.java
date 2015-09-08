package io.atom.electron;

import java.awt.event.ActionListener;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import javax.swing.Icon;
import org.openide.ErrorManager;
import org.openide.awt.NotificationDisplayer;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;

/**
 *
 * @author spindizzy
 */
class TaskObserver {
    private static final String ELECTRON_ICON = "io/atom/electron/atom_24x24.png";
    
    private static final String EXC = "exc";

    private ActionListener listener;

    TaskObserver(ActionListener listener) {
        this.listener = listener;
    }

    void observe(final Future<Integer> task) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            while (!task.isDone()) {
                try {
                    task.get();
                } catch (InterruptedException | ExecutionException e) {
                    notifyException(e);
                } catch (CancellationException e) {
                    Logger.getLogger(getClass().getName()).info(e.toString());
                }
            }
        });
    }

    private void notifyException(Exception e) {
        String msg = NbBundle.getMessage(getClass(), EXC);
        Icon icon = ImageUtilities.loadImageIcon(ELECTRON_ICON, true);
        NotificationDisplayer noti = NotificationDisplayer.getDefault();
        noti.notify(msg, icon, e.getLocalizedMessage(), listener,
                NotificationDisplayer.Priority.HIGH, NotificationDisplayer.Category.ERROR);
        ErrorManager.getDefault().notify(e);
    }
}
