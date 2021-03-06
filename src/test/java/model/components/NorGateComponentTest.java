package model.components;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.cafebabe.model.editor.workspace.circuit.component.connection.Wire;
import org.cafebabe.model.editor.workspace.circuit.component.gate.NorGateComponent;
import org.cafebabe.model.editor.workspace.circuit.component.source.SignalSourceComponent;
import org.junit.jupiter.api.Test;

class NorGateComponentTest {


    /* Package-Private */
    @Test
    void intendedUseTest() {
        SignalSourceComponent power1 = new SignalSourceComponent();
        SignalSourceComponent power2 = new SignalSourceComponent();
        Wire in1 = new Wire();
        Wire in2 = new Wire();
        Wire out = new Wire();
        NorGateComponent comp = new NorGateComponent();

        // Connect wires to power source
        power1.connectToPort(in1, "output");
        power2.connectToPort(in2, "output");

        comp.connectToPort(out, "output");

        // NOR-Gate output should be 0 when either inputs are on
        comp.connectToPort(in1, "input1");
        assertFalse(out.isHigh());
        comp.connectToPort(in2, "input2");
        assertFalse(out.isHigh());

    }

}
