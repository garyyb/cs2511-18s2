package TextEditor;

import java.util.Stack;

/**
 * The Invoker class is responsible for executing given commands.
 * It is also responsible for storing a stack of past commands, so that it may undo them.
 */
public class Invoker {
    private final Stack<Command> history = new Stack<>();

    public void invoke(final Command cmd) {
        cmd.execute();
        this.history.push(cmd);
    }

    public void undo() {
        if (history.empty()) {
            System.out.println("No more items to undo");
            return;
        }

        Command cmdToUndo = history.pop();
        cmdToUndo.undo();

        // Or just history.pop().undo(); will do.
    }
}
