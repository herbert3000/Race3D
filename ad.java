import java.util.Vector;

public class ad
{

    public final void cl(long l)
    {
        for(int j = 0; j < f8; j++)
        {
            boolean flag = co(((y) (f7[j])).ev, ((y) (f7[j])).eu);
            if(f7[j] instanceof ae)
                ((ae)f7[j]).cw(l, flag);
            else
                f7[j].ch(l, aa.e4[2], aa.e4[3], aa.e4[0], aa.e4[1], flag);
            if(f7[j] == cs())
                switch(f7[j].fp)
                {
                default:
                    break;

                case 1: // '\001'
                    if(!flag && (f3 == null || f3.bb()))
                        f3 = SoundHandler.playSound(8, true);
                    else
                    if(flag && f3 != null && !f3.bb())
                        SoundHandler.stopSound(f3);
                    int k = Math.abs(f7[j].fr - f7[j].fq);
                    boolean flag1 = k > 0x38b333;
                    if(flag1 && (f4 == null || f4.bb()))
                        f4 = SoundHandler.playSound(9, true);
                    else
                    if(!flag1 && f4 != null && !f4.bb())
                        SoundHandler.stopSound(f4);
                    break;

                case 2: // '\002'
                    if(f3 != null && !f3.bb())
                        SoundHandler.stopSound(f3);
                    if(f4 != null && !f4.bb())
                        SoundHandler.stopSound(f4);
                    break;
                }
        }

        cu();
        cm(l);
    }

    private final void cm(long l)
    {
        for(int j = 0; j < f8; j++)
        {
            ac ac1 = f7[j];
            if(!ac1.fb)
            {
                int k = ((y) (ac1)).ev >> 22;
                int i1 = ((y) (ac1)).eu >> 22;
                if(k < 0 || i1 < 0 || k >= 32 || i1 >= 32)
                {
                    ac1.fo = -1;
                    ac _tmp = ac1;
                    long _tmp1 = l;
                } else
                {
                    n n1 = ac1.d5.aw(k, i1);
                    int j1 = n1.i0;
                    if(j1 == 0 && ac1.fc)
                    {
                        ac1.fn = 1;
                        ac1.fc = false;
                    }
                    if(j1 == ac1.fo - 1)
                        ac1.fe = true;
                    else
                    if(j1 != ac1.fo)
                    {
                        ac1.fe = false;
                        ac _tmp2 = ac1;
                        long _tmp3 = l;
                        ac1.fo = j1;
                    }
                    if(ac1.fo == ac1.fn || ac1.fo == (ac1.fn + 1) % (ac1.d5.int1 + 1) || ac1.fo == (ac1.fn + 2) % (ac1.d5.int1 + 1) || ac1.fo == (ac1.fn + 3) % (ac1.d5.int1 + 1) || ac1.fo == (ac1.fn + 4) % (ac1.d5.int1 + 1))
                    {
                        ac1.fc = false;
                        if(ac1.fo == 0)
                        {
                            ac1.ff++;
                            if(ac1 == cs())
                                SoundHandler.playSound(10);
                            if(ac1.ff == Main.ds)
                                ac1.e9 = ac1.e8;
                            else
                            if(ac1.ff > Main.ds)
                            {
                                if(ac1 == cs())
                                    SoundHandler.playSound(11);
                                ac1.fp = 2;
                                ac1.fa = ac1.e8;
                                f6.addElement(ac1);
                            }
                        }
                        ac1.fn = (ac1.fo + 1) % (ac1.d5.int1 + 1);
                    } else
                    if(ac1.fo > ac1.fn && ac1.fn > 0)
                        ac1.fc = true;
                }
            }
        }

    }

    public final void cn(int j)
    {
        for(int k = 0; k < f8; k++)
            f7[k].fp = j;

    }

    public final void bp(m m1, int j, boolean flag)
    {
        d5 = m1;
        f7 = new ac[f8];
        f6 = new Vector(f8);
        ad _tmp = this;
        new Vector(f8);
        int ai[] = new int[f8];
        int k = a.c(1, 4);
        if(j == -1)
            j = (int)(Math.random() * 6D) % 5;
        f2 = j;
        for(int l = 0; l < f8; l++)
            ai[l] = -1;

        ai[k] = j;
        for(int i1 = j + 1; i1 < j + f8; i1++)
        {
            int j1;
            do
                j1 = (int)(Math.random() * (double)(f8 + 1)) % f8;
            while(ai[j1] != -1);
            ai[j1] = i1 % 5;
        }

        int k1 = 1;
        for(int l1 = 0; l1 < f8; l1++)
            if(l1 == k)
            {
                if(flag)
                    f7[0] = new ae(m1, 0x370000, a.f(8.5D), l1, ai[l1]);
                else
                    f7[0] = new ac(m1, 0x370000, a.f(8.5D), l1, ai[l1]);
            } else
            {
                f7[k1++] = new ae(m1, a.f(50D + Math.random() * 4.5D), a.f(9D + Math.random() * 0.75D), l1, ai[l1]);
            }

        f7[0].et = 0x640000;
    }

    private final boolean co(int j, int k)
    {
        int l = j >> 22;
        int i1 = k >> 22;
        if(l < 0 || i1 < 0 || l >= 32 || i1 >= 32)
            return false;
        n n1 = d5.aw(l, i1);
        if(n1.b0 != 0)
        {
            byte abyte0[] = (byte[])f5[n1.b0].aa;
            if(abyte0[j >> 15 & 0x7f | (k >> 15 & 0x7f) << 7] != 0)
                return true;
        }
        return false;
    }

    public final Vector cp()
    {
        return f6;
    }

    public final int cq()
    {
        return f8;
    }

    public final int cr()
    {
        return f2;
    }

    public final ac cs()
    {
        return ct(0);
    }

    public final ac ct(int j)
    {
        return f7[j];
    }

    private final void cu()
    {
        for(int j = 0; j < f8; j++)
        {
            ac ac1 = f7[j];
            if(ac1.fp != 0)
            {
                for(int k = 0; k < f8; k++)
                {
                    ac ac2 = f7[k];
                    if(ac1 != ac2)
                    {
                        int l = ((y) (ac2)).ev - ((y) (ac1)).ev;
                        int i1 = ((y) (ac2)).eu - ((y) (ac1)).eu;
                        if(l < 0xccccc && i1 < 0xccccc)
                        {
                            int j3 = l;
                            double d = (double)j3 / 65536D;
                            int i3 = i1;
                            double d1 = (double)i3 / 65536D;
                            int j1 = a.f(Math.sqrt(d * d + d1 * d1));
                            if(j1 < 0xccccc)
                            {
                                int k1 = a.d(Math.atan2(i1, l));
                                int l1 = a.b[k1];
                                int i2 = a.c[k1];
                                long l2 = 0xccccc - j1 >> 1;
                                int j2 = (int)(l2 * (long)i2 >> 16);
                                int k2 = (int)(l2 * (long)l1 >> 16);
                                ac1.ev -= j2;
                                ac1.eu -= k2;
                                ac2.ev += j2;
                                ac2.eu += k2;
                            }
                        }
                    }
                }

            }
        }

    }

    public ad(i ai[], int j)
    {
        f5 = ai;
        f8 = j;
    }

    public int f8;
    public ac f7[];
    public Vector f6;
    public i f5[];
    public m d5;
    public AudioStream f4;
    public AudioStream f3;
    public int f2;
}
