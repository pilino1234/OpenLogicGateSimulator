package org.cafebabe.model.workspace;

import org.cafebabe.model.util.IReadOnlyMovable;

public interface IMovable extends IReadOnlyMovable {
    /* Public */
    void move(int targetX, int targetY);

    void translate(int deltaX, int deltaY);
}