package TextEditor;

/**
 * Defines an unknown command. In our application, we wish for commands to be undone,
 * so we include a undo() method.
 */
public interface Command {
    void execute();
    void undo();
}
