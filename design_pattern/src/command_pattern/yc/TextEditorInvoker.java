package command_pattern.yc;

import java.util.Stack;

public class TextEditorInvoker {
    private Stack<Command2> undoStack = new Stack<>();
    private Stack<Command2> redoStack = new Stack<>();

    public void executeCommand(Command2 command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }
    public void undo(){
        if(!undoStack.isEmpty()){
            Command2 command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo(){
        if(!redoStack.isEmpty()){
            Command2 command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }
}
