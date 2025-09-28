package command_pattern.yc;

public class InsertTextCommand implements Command2 {
    private TextEditor editor;
    private String text;
    private int position;

    public InsertTextCommand(TextEditor editor, String text, int position) {
        this.editor = editor;
        this.text = text;
        this.position = position;
    }

    @Override
    public void execute() {
        editor.insertText(text, position);
    }

    @Override
    public void undo() {
        editor.deleteText(position, text.length());
    }
}
