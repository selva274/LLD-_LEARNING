import java.util.Stack;

class TextEditor{
    private String text;
    public void setText(String text){
        this.text=text;
    }
    public String getText(){
        return this.text;
    }
    public Memento save(){
        return new Memento(this.text);
    }

    public void restore(Memento memento){
        this.text=memento.getText();
    }
}

class Memento{
    private final String text;
    public Memento(String text){
        this.text=text;
    }
    public String getText(){
        return this.text;
    }
}

class TextEditorHistory{
    private Stack<Memento> history=new Stack<>();
    public void push(Memento memento){
        history.push(memento);
    }
    public Memento pop(){
        if(!history.isEmpty()){
            return history.pop();
        }
        return null;
    }
}
class Mementos {
    public static void main(String[] args) {
        TextEditor editor=new TextEditor();
        TextEditorHistory history=new TextEditorHistory();

        editor.setText("hello");
        System.out.println("current text "+editor.getText());
        history.push(editor.save());

         editor.setText("world");
        System.out.println("current text "+editor.getText());
        history.push(editor.save());

          editor.setText("welcome");
        // System.out.println("current text "+editor.getText());
        history.push(editor.save());
        System.out.println("current text "+editor.getText());


        Memento prev=history.pop();
        System.out.println("current text "+editor.getText());

        prev=history.pop();
        editor.restore(prev);

        System.out.println("current text "+editor.getText());

        prev=history.pop();
        editor.restore(prev);

        System.out.println("current text "+editor.getText());

        

    }
}
