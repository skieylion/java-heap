package project.java;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Stack;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Notebook notebook=new Notebook("");
        CaretakerHistory caretakerHistory=new CaretakerHistory();
        notebook.setText("some text");
        caretakerHistory.push(notebook.save());
        notebook.setText("other text");
        caretakerHistory.push(notebook.save());

        notebook.restore(caretakerHistory.pop());
        System.out.println(notebook.getText());
        notebook.restore(caretakerHistory.pop());
        System.out.println(notebook.getText());

    }
}

interface Memento {
    String getText();
}

@AllArgsConstructor
@Data
class Notebook implements Memento {
    private String text;

    public Memento save() {
        return new Notebook(text);
    }

    public void restore(Memento memento) {
        setText(memento.getText());
    }
}

class CaretakerHistory {
    private final Stack<Memento> mementoStack=new Stack<>();
    public void push(Memento memento){
        mementoStack.push(memento);
    }
    public Memento pop(){
        return mementoStack.pop();
    }
}

