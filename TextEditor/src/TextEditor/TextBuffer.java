package TextEditor;

/**
 * The Receiver class. In an actual implementation, it would store the lines and characters in the file.
 */
public class TextBuffer {
    public void insertText(char c) {
        System.out.println("Inserting " + c);
    }

    public void deleteText(char c) {
        System.out.println("Removing " + c);
    }
}
