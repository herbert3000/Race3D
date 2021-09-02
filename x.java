import java.util.Vector;

public final class x
{

    public final void bx(y y1)
    {
        for(int i = 0; i < en.size(); i++)
            by(i).b1(y1);

        for(int j = 0; j < en.size() - 1; j++)
        {
            y y2 = by(j + 1);
            int k;
            for(k = j; k >= 0 && y2.eo > by(k).eo; k--);
            if(k != j)
            {
                en.removeElementAt(j + 1);
                en.insertElementAt(y2, k + 1);
            }
        }

    }

    public final void a6()
    {
        en.removeAllElements();
    }

    public final int h()
    {
        return en.size();
    }

    public final y by(int i)
    {
        return (y)en.elementAt(i);
    }

    public final void bz(Vector vector)
    {
        if(vector != null)
        {
            for(int i = 0; i < vector.size(); i++)
                bz((y)vector.elementAt(i));

        }
    }

    public final void bz(y y1)
    {
        if(!en.contains(y1))
            en.addElement(y1);
    }

    public x()
    {
        en = new Vector(100, 100);
    }

    public Vector en;
}
