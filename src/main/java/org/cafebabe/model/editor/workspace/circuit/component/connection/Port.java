package org.cafebabe.model.editor.workspace.circuit.component.connection;

import lombok.Getter;
import lombok.Setter;
import org.cafebabe.model.IModel;
import org.cafebabe.model.editor.util.IReadOnlyMovable;
import org.cafebabe.model.editor.workspace.circuit.component.position.Position;
import org.cafebabe.model.editor.workspace.circuit.component.position.TrackablePosition;
import org.cafebabe.model.util.EmptyEvent;
import org.cafebabe.model.util.IdGenerator;

/**
 The common logic for both input- and output ports.
 Ports represent connection points for wires.
 */
public abstract class Port extends LogicStateContainer implements IModel {
    @Getter @Setter private IReadOnlyMovable positionTracker =
            new TrackablePosition(new Position(0, 0));
    @Getter private final EmptyEvent onDestroy = new EmptyEvent();
    private boolean destructionPending;
    @Getter private final long id = IdGenerator.getNewId();

    /* Public */
    public abstract boolean isConnected();

    @Override
    public void destroy() {
        if (!this.destructionPending) {
            this.destructionPending = true;
            this.onDestroy.notifyListeners();
        }
    }
}
