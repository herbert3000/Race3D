import java.util.Vector;

public class z
{

    public final void b2(int i, String s)
    {
        if(!ey)
            e_.setElementAt(s, i);
    }

    public final void b3()
    {
        if(!ey)
        {
            ez = ((ez + e_.size()) - 1) % e_.size();
        } else
        {
            ez--;
            if(ez < 0)
                ez = 0;
            ew = ez - e0 / 2;
            if(ew < 0)
                ew = 0;
            if(ew > e_.size() - e0)
                ew = e_.size() - e0;
        }
    }

    public final void b4()
    {
        if(!ey)
        {
            ez = (ez + 1) % e_.size();
        } else
        {
            ez++;
            if(ez >= e_.size())
                ez = e_.size() - 1;
            ew = ez - e0 / 2;
            if(ew < 0)
                ew = 0;
            if(ew > e_.size() - e0)
                ew = e_.size() - e0;
        }
    }

    public final int b5()
    {
        if(ey)
            return e0;
        else
            return e_.size();
    }

    public final String b6()
    {
        return ay;
    }

    public final String b7()
    {
        return (String)e_.elementAt(ez);
    }

    public final int b8()
    {
        return ez;
    }

    public final int b9()
    {
        return ew;
    }

    public final z ca()
    {
        return b4;
    }

    public final String cb(int i)
    {
        if(!ey)
            return (String)e_.elementAt(i);
        if(i == e0 - 1 && e_.size() - ew > e0)
            return "\202";
        if(i == 0 && ew > 0)
            return "\201";
        else
            return (String)e_.elementAt(ew + i);
    }

    public final void bz(String s)
    {
        e_.addElement(s);
    }

    public z(String s)
    {
        this(null, s);
    }

    public z(z z1, String s, boolean flag)
    {
        e0 = 5;
        ew = 0;
        b4 = z1;
        ay = s;
        ey = flag;
        e_ = new Vector();
        ez = 0;
    }

    public z(z z1, String s)
    {
        this(z1, s, false);
    }

    public int e0;
    public Vector e_;
    public int ez;
    public z b4;
    public String ay;
    public boolean ey;
    public int ew;
}
