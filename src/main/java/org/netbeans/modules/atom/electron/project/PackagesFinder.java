package org.netbeans.modules.atom.electron.project;

import org.openide.filesystems.FileObject;

/**
 * The purpose of this is class is to search for the necessary elements for an
 * electron app.
 *
 * @author spindizzy
 */
final class PackagesFinder {

    private static final String SRC = "src/";
    private static final String PACKAGE = SRC + "package.json";
    private static final String MAIN = SRC + "main.js";
    private static final String INDEX = SRC + "index.html";

    private final FileObject projectDirectory;

    PackagesFinder(FileObject projectDirectory) {
        this.projectDirectory = projectDirectory;
    }

    FileObject getMainJs() {
        return projectDirectory.getFileObject(MAIN);
    }

    boolean hasPackage() {
        return projectDirectory.getFileObject(PACKAGE) != null;
    }

    boolean hasMainJs() {
        return getMainJs() != null;
    }

    boolean hasIndex() {
        return projectDirectory.getFileObject(INDEX) != null;
    }
}
