import java.awt.*;

public class ConsoleWindow extends Frame
{

    public final void show()
    {
        super.show();
        textField.requestFocus();
    }

    public final void drawText(String s)
    {
        textArea.appendText(s + newLine);
    }

    public final boolean keyDown(Event event, int i)
    {
        if(i == 96 || i == 126 || i == 27)
        {
            hide();
            return true;
        } else
        {
            return false;
        }
    }

    public final void hide()
    {
        super.hide();
        if(main instanceof Component)
            ((Component)main).requestFocus();
    }

    private final void drawHelpMessage()
    {
        drawText("====================================");
        drawText("help     - Shows this message");
        drawText("commands - Shows list of available");
        drawText("           commands");
        drawText("clear    - Clears console window");
        drawText("hide     - Hides console window");
        drawText("====================================");
    }

    public final boolean handleEvent(Event event)
    {
        switch(event.id)
        {
        case 201: // Event.WINDOW_DESTROY
            hide();
            return true;
        }
        return super.handleEvent(event);
    }

    public final boolean action(Event event, Object obj)
    {
        if(event.target == textField)
        {
            String s = textField.getText();
            drawText("]" + s);
            textField.setText("");
            if(s.equalsIgnoreCase("clear"))
                textArea.setText("");
            else
            if(s.equalsIgnoreCase("help") || s.equals("?"))
                drawHelpMessage();
            else
            if(s.equalsIgnoreCase("hide"))
                hide();
            else
            if(!main.br(s))
                drawText("Unknown command (try 'help')");
        }
        return true;
    }

    public ConsoleWindow(Main main, String s)
    {
        super(s);
        this.main = main;
        newLine = System.getProperty("line.separator");
        font = new Font("Courier", 0, 12);
        textField = new TextField(40);
        textArea = new TextArea("", 8, 40);
        textArea.setFont(font);
        textArea.setEditable(false);
        drawHelpMessage();
        setLayout(new BorderLayout());
        add("South", textField);
        add("Center", textArea);
        pack();
    }

    public TextField textField;
    public TextArea textArea;
    public String newLine;
    public Font font;
    public Main main;
}
