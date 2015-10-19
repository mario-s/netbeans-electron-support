package org.netbeans.modules.atom.electron.actions;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import org.openide.util.Exceptions;

/**
 *
 * @author spindizzy
 */
class TaskObserver {

    void observe(final Future<Integer> task) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            while (!task.isDone()) {
                try {
                    task.get();
                } catch (InterruptedException | ExecutionException e) {
                    Exceptions.printStackTrace(e);
                } catch (CancellationException e) {
                    Logger.getLogger(getClass().getName()).info(e.toString());
                }
            }
        });
    }
}
