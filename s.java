import java.awt.Component;
import java.awt.Point;

public class s extends Thread
{

    public final void run()
    {
        for(boolean flag = false; !flag;)
        {
            long l = b4.b6;
            boolean flag1 = false;
            b4.repaint();
            try
            {
                Thread.sleep(20L);
            }
            catch(InterruptedException _ex)
            {
                flag = true;
            }
            for(flag = flag || b4.b5 || b4.cc; !flag && l == b4.b6; flag = flag || b4.b5 || b4.cc)
                Thread.yield();

            b2.x += b3.x;
            b2.y += b3.y;
            if(b2.x - 5 <= 8 && b2.x >= 4 && Math.abs(b4.b7 - b2.y) < 30)
                b3.x = Math.abs(b3.x);
            if(b2.x + 5 >= p - 8 && b2.x <= p - 4 && Math.abs(b1 - b2.y) < 30)
                b3.x = -Math.abs(b3.x);
            if(b2.y - 5 <= 0 || b2.y + 5 >= o)
                b3.y = -b3.y;
            if(b2.x > p - 100)
                if(b2.y < b1)
                    b1 -= 2;
                else
                if(b2.y > b1)
                    b1 += 2;
            if(b2.x <= 0 && b3.x < 0)
            {
                b0++;
                bg();
            }
            if(b2.x >= p && b3.x > 0)
            {
                b_++;
                bg();
            }
        }

    }

    private final void bg()
    {
        b2 = new Point(p / 2, o / 2);
        if(Math.random() > 0.5D)
            b3 = new Point(-4, -4);
        else
            b3 = new Point(4, -4);
    }

    public s(MainCanvas t1, int i, int j)
    {
        b0 = 0;
        b_ = 0;
        b4 = t1;
        p = i;
        o = j;
        b1 = j / 2;
        bg();
    }

    public MainCanvas b4;
    public int p;
    public int o;
    public Point b3;
    public Point b2;
    public int b1;
    public int b0;
    public int b_;
}
