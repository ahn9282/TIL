package command_pattern.yc;

public class Main1 {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        TextEditorInvoker invoker = new TextEditorInvoker();

        InsertTextCommand insertHello = new InsertTextCommand(editor, "Hello, ", 0);
        invoker.executeCommand(insertHello);

        InsertTextCommand insertWorld = new InsertTextCommand(editor, "World", 7);
        invoker.executeCommand(insertWorld);

        System.out.println("Current text : " + editor.getContent());
        invoker.undo();
        System.out.println("After undo : " + editor.getContent());
        invoker.redo();
        System.out.println("After redo : " + editor.getContent());

        DeleteTextCommand deleteCommand = new DeleteTextCommand(editor, 0, 7);
        invoker.executeCommand(deleteCommand);
        System.out.println("After delete : " + editor.getContent());
        invoker.undo();
        System.out.println("Final text : " + editor.getContent());
    }
}
