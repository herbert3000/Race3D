import java.io.PrintStream;

public class ae extends ac
{

    public final void a6(m m1, int i)
    {
        super.a6(m1, i);
        gf = false;
        fg = false;
        ge = false;
        gd = false;
        ga = -1;
        f9 = -1;
    }

    public final void cv(int i, int j)
    {
        int k = 0;
        for(int l = -3; l <= 3; l++)
        {
            for(int i1 = -3; i1 <= 3; i1++)
            {
                int k1 = i + l;
                int i2 = j + i1;
                if(k1 >= 0 && k1 < 32 && i2 >= 0 && i2 < 32 && super.d5.aw(k1, i2).i0 == (super.fn + 2) % (super.d5.int1 + 1))
                {
                    if(k == 1)
                    {
                        gc = (gc + (double)k1) / 2D;
                        gb = (gb + (double)i2) / 2D;
                        return;
                    }
                    gc = k1;
                    gb = i2;
                    k = 1;
                }
            }

        }

        if(k >= 1)
            return;
        System.out.println("Lost AI Car");
        for(int j1 = 0; j1 < 32; j1++)
        {
            for(int l1 = 0; l1 < 32; l1++)
                if(super.d5.aw(j1, l1).i0 == (super.fn + 2) % (super.d5.int1 + 1))
                {
                    if(k == 1)
                    {
                        gc = (gc + (double)j1) / 2D;
                        gb = (gb + (double)l1) / 2D;
                        return;
                    }
                    gc = j1;
                    gb = l1;
                    k = 1;
                }

        }

    }

    public final void cw(long l, boolean flag)
    {
        int i = super.ev >> 22;
        int j = super.eu >> 22;
        if(i != ga || j != f9)
        {
            cv(i, j);
            ga = i;
            f9 = j;
        }
        int k = a.f(gc * 64D + 32D);
        int i1 = a.f(gb * 64D + 32D);
        double d;
        int j1;
        for(d = Math.atan2(i1 - super.eu, k - super.ev) - ((double)(j1 = super.es) * 2D * 3.1415926535897931D) / 4096D; d > 3.1415926535897931D; d -= 6.2831853071795862D);
        for(; d < -3.1415926535897931D; d += 6.2831853071795862D);
        gf = true;
        fg = false;
        if(super.f1 > super.f0 >> 2)
        {
            if(Math.abs(d) > 0.52359877559829882D)
                gf = false;
            if(flag && Math.abs(d) > 0.78539816339744828D)
                fg = true;
        }
        ge = false;
        gd = false;
        if(d < -0.087266462599716474D)
            ge = true;
        if(d > 0.087266462599716474D)
            gd = true;
        super.ch(l, gf, fg, ge, gd, flag);
    }

    public ae(m m1, int i, int j, int k, int l)
    {
        super(m1, i, j, k, l);
    }

    public boolean gf;
    public boolean fg;
    public boolean ge;
    public boolean gd;
    public double gc;
    public double gb;
    public int ga;
    public int f9;
}
