package TextEditor;

/**
 * Concrete command for inserting text.
 */
public class InsertTextCommand implements Command {
    private TextBuffer tb;
    private char c;

    public InsertTextCommand(TextBuffer tb, char c) {
        this.tb = tb;
        this.c = c;
    }

    @Override
    public void execute() {
        tb.insertText(c);
    }

    @Override
    public void undo() {
        System.out.println("Undoing insertion of " + c);
        tb.deleteText(c);
    }
}
