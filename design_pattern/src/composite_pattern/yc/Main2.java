package composite_pattern.yc;

import java.awt.*;

public class Main2 {
    public static void main(String[] args) {
        Button submitBtn = new Button("Submit");
        Button cancelBtn = new Button("Cancel");
        TextBox usernameField = new TextBox("Username");

        Panel formPanel = new Panel("Form");
        formPanel.add(submitBtn);
        formPanel.add(cancelBtn);
        formPanel.add(usernameField);

        Window mainWindow = new Window("Main");
        mainWindow.add(formPanel);
        mainWindow.render();

        System.out.println();

        formPanel.remove(cancelBtn);
        mainWindow.render();
    }
}
