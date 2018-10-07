package TextEditor;

/**
 * Concrete command for deleting text.
 */
public class DeleteTextCommand implements Command {
    private TextBuffer tb;
    private char c;

    public DeleteTextCommand(TextBuffer tb, char c) {
        this.tb = tb;
        this.c = c;
    }

    @Override
    public void execute() {
        tb.deleteText(c);
    }

    @Override
    public void undo() {
        System.out.println("Undoing deletion of " + c);
        tb.insertText(c);
    }
}
