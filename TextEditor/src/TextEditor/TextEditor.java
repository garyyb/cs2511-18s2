package TextEditor;

/**
 * This is an example of the Command pattern for Tutorial Week 11.
 * The application simulates a text editor with operations for inserting and deleting characters,
 * with a global undo feature.
 *
 * This is the Client class. It is responsible for creating commands and passing them to the Invoker.
 */
public class TextEditor {
    public static void main(String[] args) {
        TextBuffer tb = new TextBuffer();
        Invoker inv = new Invoker();

        // Insert some text.
        Command[] inserts = {
                new InsertTextCommand(tb, 'a'),
                new InsertTextCommand(tb, 'b'),
                new InsertTextCommand(tb, 'c'),
        };

        inv.invoke(inserts[0]);
        inv.invoke(inserts[1]);
        inv.invoke(inserts[2]);

        // Try undoing an insert.
        inv.undo();

        // Try deleting a character.
        Command delete = new DeleteTextCommand(tb, 'b');
        inv.invoke(delete);

        // Try undoing that deletion.
        inv.undo();

        // Try undoing the rest of the inserts.
        inv.undo();
        inv.undo();

        // Try doing an extra undo.
        inv.undo();
    }
}
