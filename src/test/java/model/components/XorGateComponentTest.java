package model.components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.cafebabe.model.editor.workspace.circuit.component.connection.Wire;
import org.cafebabe.model.editor.workspace.circuit.component.gate.NotGateComponent;
import org.cafebabe.model.editor.workspace.circuit.component.gate.XorGateComponent;
import org.cafebabe.model.editor.workspace.circuit.component.source.SignalSourceComponent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class XorGateComponentTest {

    private static Wire on, off;

    /* Package-Private */
    @BeforeAll
    static void setUp() {
        final SignalSourceComponent power = new SignalSourceComponent();
        final NotGateComponent not = new NotGateComponent();
        on = new Wire();
        off = new Wire();

        power.connectToPort(on, "output");
        not.connectToPort(on, "input");
        not.connectToPort(off, "output");
    }

    @Test
    void highInputsShouldGiveLowOutput() {
        XorGateComponent comp = new XorGateComponent();
        Wire res = new Wire();

        comp.connectToPort(on, "input1");
        comp.connectToPort(on, "input2");
        comp.connectToPort(res, "output");

        // XOR-Gate output should only be 1 when only one input is active
        assertTrue(comp.getPort("output").isLow());
        assertTrue(res.isLow());
    }

    @Test
    void lowInputsShouldGiveLowOutput() {
        XorGateComponent comp = new XorGateComponent();
        Wire res = new Wire();

        comp.connectToPort(off, "input1");
        comp.connectToPort(off, "input2");
        comp.connectToPort(res, "output");

        // XOR-Gate output should only be 1 when only one input is active
        assertTrue(res.isLow());
    }

    @Test
    void oneHighInputShouldGiveHighOutput() {
        XorGateComponent comp = new XorGateComponent();
        Wire res = new Wire();

        comp.connectToPort(on, "input1");
        comp.connectToPort(off, "input2");
        comp.connectToPort(res, "output");

        // XOR-Gate output should only be 1 when only one input is active
        assertTrue(res.isHigh());
    }

    @Test
    void oneHighInput2ShouldGiveHighOutput() {
        XorGateComponent comp = new XorGateComponent();
        Wire res = new Wire();

        comp.connectToPort(off, "input1");
        comp.connectToPort(on, "input2");
        comp.connectToPort(res, "output");

        // XOR-Gate output should only be 1 when only one input is active
        assertTrue(res.isHigh());
    }
}
