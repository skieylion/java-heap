package project.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Editor editor = new Editor();
        editor.init();
    }
}

class Editor {
    public JTextArea textField;
    public String clipboard;

    public void init() {
        JFrame frame = new JFrame("Text editor (type & use buttons, Luke!)");
        JPanel content = new JPanel();frame.setContentPane(content);frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        textField = new JTextArea();textField.setLineWrap(true);
        content.add(textField);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));JButton ctrlC = new JButton("Ctrl+C");JButton ctrlV = new JButton("Ctrl+V");

        Editor editor = this;
        ctrlC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CopyCommand(editor).execute();
            }
        });

        ctrlV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PasteCommand(editor).execute();
            }
        });

        buttons.add(ctrlC);buttons.add(ctrlV);

        content.add(buttons);
        frame.setSize(450, 200);frame.setLocationRelativeTo(null);frame.setVisible(true);
    }
}

abstract class Command {
    public final Editor editor;

    Command(Editor editor) {
        this.editor = editor;
    }

    public abstract void execute();
}

class PasteCommand extends Command {

    PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public void execute() {
        System.out.println("PASTE");
        if (editor.clipboard == null || editor.clipboard.isEmpty()) return;
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
    }
}

class CopyCommand extends Command {

    CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public void execute() {
        System.out.println("COPY");
        editor.clipboard = editor.textField.getSelectedText();
    }
}



