import java.awt.*;

public class MessageBox extends Dialog
{

    public final boolean handleEvent(Event event)
    {
        switch(event.id)
        {
        case 201: // Event.WINDOW_DESTROY
            status = -1;
            dispose();
            return true;
        }
        return super.handleEvent(event);
    }

    public final int getStatus()
    {
        return status;
    }

    public final boolean action(Event event, Object obj)
    {
        if(event.target == buttonOK)
        {
            status = 1;
            dispose();
            return true;
        }
        if(event.target == buttonCancel)
        {
            status = -1;
            dispose();
            return true;
        }
        if(event.target == buttonNo)
        {
            status = 0;
            dispose();
            return true;
        } else
        {
            return false;
        }
    }

    public MessageBox(Frame frame, String msg, int type)
    {
        super(frame, frame.getTitle(), true);
        buttonOK = new Button("      OK      ");
        buttonNo = new Button("No");
        buttonCancel = new Button("Cancel");
        GridBagLayout gridbaglayout = new GridBagLayout();
        GridBagConstraints gridbagconstraints = new GridBagConstraints();
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(0, 1));
        msg = msg + "\n\n";
        for(int j = 0; j < msg.length();)
        {
            int k = j;
            j = msg.indexOf('\n', j);
            if(j >= 0)
            {
                Label label = new Label(msg.substring(k, j));
                if(label.getText().length() == 0)
                    label.hide();
                panel.add(label);
                j++;
            }
        }

        Panel panel1 = new Panel();
        panel1.setLayout(new GridLayout(1, 0, 6, 6));
        panel1.add(buttonOK);
        if(type == 2 || type == 3)
        {
            buttonOK.setLabel("      Yes      ");
            panel1.add(buttonNo);
        }
        if(type == 1 || type == 3)
            panel1.add(buttonCancel);
        setLayout(gridbaglayout);
        gridbagconstraints.gridx = 0;
        gridbagconstraints.gridy = 0;
        gridbagconstraints.anchor = 18;
        gridbaglayout.setConstraints(panel, gridbagconstraints);
        add(panel);
        gridbagconstraints.gridy = 1;
        gridbagconstraints.anchor = 10;
        gridbaglayout.setConstraints(panel1, gridbagconstraints);
        add(panel1);
        pack();
        Dimension dimension = buttonOK.size();
        Dimension dimension1 = frame.size();
        Point point = frame.location();
        int i1 = size().width + dimension.width;
        int j1 = size().height + dimension.height;
        reshape(point.x + (dimension1.width / 2 - i1 / 2), point.y + (dimension1.height / 2 - j1 / 2), i1, j1);
        show();
    }

    public int status;
    public Button buttonOK;
    public Button buttonNo;
    public Button buttonCancel;
}
