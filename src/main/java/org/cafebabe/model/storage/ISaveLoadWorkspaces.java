package org.cafebabe.model.storage;

import org.cafebabe.model.editor.workspace.Workspace;

public interface ISaveLoadWorkspaces {
    void saveWorkspace(Workspace workspace, String location);
    Workspace loadWorkspace(String location);
}
