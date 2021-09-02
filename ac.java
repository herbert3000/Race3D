import java.awt.Point;

public class ac extends y
{

    public final void ch(long l, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        fg = flag1;
        fh = flag4;
        if(l == e8)
            return;
        if(fb)
        {
            if(flag2)
                super.b_(super.es - 64);
            if(flag3)
                super.b_(super.es + 64);
            if(flag)
            {
                super.ev += 10 * super.eq;
                super.eu += 10 * super.ep;
            }
            if(flag1)
            {
                super.ev -= 8 * super.eq;
                super.eu -= 8 * super.ep;
            }
            return;
        }
        if(fp != 1 && fp != 2)
        {
            e8 = l;
            return;
        }
        if(fp == 2)
        {
            flag2 = false;
            flag3 = false;
            flag = false;
            flag1 = true;
        }
        if(fl)
        {
            flag = false;
            fl = false;
        }
        long l1 = l - e8;
        if(l1 > 250L)
            l1 = 250L;
        long l2 = a.f((double)l1 / 1000D);
        e8 = l;
        f1 += (int)((long)fw * l2 >> 16);
        if(f1 > f0)
            f1 = f0;
        if(f1 > f_)
            if(flag4)
                f1 += (int)((long)(-fv * 2) * l2 >> 16);
            else
                f1 += (int)((long)(-fv * 3) * l2 >> 16);
        if(f1 < 0)
            f1 = 0;
        if(flag1)
            fw = -(fv << 1);
        else
        if(flag)
        {
            if(f1 < fu)
                fw = fv;
            else
            if(f1 < ft)
                fw = fv >> 2;
            else
                fw = fv >> 5;
        } else
        {
            fw = -(int)((double)fv * 1.5D);
        }
        if(f1 == 0 && fw < 0)
            fw = 0;
        int i = (int)(0x510000L * l2 >> 16);
        if(flag2)
        {
            fr += i;
            if(fr > 0x3a0000)
                fr = 0x3a0000;
        } else
        {
            fr -= i * 3;
            if(fr < 0x20000)
                fr = 0;
        }
        if(flag3)
        {
            fq += i;
            if(fq > 0x3a0000)
                fq = 0x3a0000;
        } else
        {
            fq -= i * 3;
            if(fq < 0x20000)
                fq = 0;
        }
        if(fr > 0 && f1 < f0 >> 2)
            fr = (int)(((long)fr * (long)f1) / (long)(f0 >> 2));
        if(fq > 0 && f1 < f0 >> 2)
            fq = (int)(((long)fq * (long)f1) / (long)(f0 >> 2));
        f_ = f0;
        if(!flag4)
        {
            f_ /= 3;
        } else
        {
            int j = Math.abs(fr - fq);
            if(j > 0x40000)
            {
                long l3 = ((long)j << 16) / 0x3a0000L;
                f_ = (int)((long)f_ - ((long)f_ * l3 >> 18));
            }
        }
        int k = (int)((long)(fq - fr) * l2 >> 12);
        super.b_(super.es + (k >> 16));
        long l4 = (long)f1 * l2 * 5L >> 16;
        super.ev += (int)(l4 * (long)super.eq >> 16);
        super.eu += (int)(l4 * (long)super.ep >> 16);
    }

    public void a6(m m1, int i)
    {
        d5 = m1;
        i = (i + 5) % 6;
        int j = 16;
        int k = 18;
        super.ev = 0;
        super.eu = 0x200000;
        if(i == 0 || i == 5)
            k = -k;
        if(i == 1 || i == 4)
            k = 0;
        if(i < 3)
            j = -j;
        if(i == 3 || i == 5)
            k = (int)((double)k / 1.5D);
        if((m1.int0 & 1) != 0)
        {
            int l = k;
            int i1 = super.eu;
            k = m1.int0 != 1 ? -j : j;
            j = l;
            super.eu = super.ev;
            super.ev = i1;
        }
        if(m1.int0 > 1)
            j = -j;
        super.ev += m1.point.x * 64 + 32 + j << 16;
        super.eu += m1.point.y * 64 + 32 + k << 16;
        super.et = 0;
        super.b_(m1.int0 * 4096 >> 2);
        f1 = 0;
        fw = 0;
        fr = 0;
        fq = 0;
        fp = 0;
        fo = 0;
        ac _tmp = this;
        long _tmp1 = 0L;
        ac _tmp2 = this;
        byte _tmp3 = 6;
        fn = 1;
        ff = 1;
        fb = false;
        fe = false;
        fc = false;
        fa = 0L;
        e9 = 0L;
        fl = false;
    }

    public final int ci()
    {
        return (f1 * 100) / f0;
    }

    public final double cj(double d)
    {
        int i = f1;
        return ((double)i / 65536D) * d;
    }

    public final int ck(int i)
    {
        int j = (f1 * 4) / f0;
        if(j > 3)
            j = 3;
        if(fi == 7 && i != fj)
            return -1;
        if(j == 0 && f1 == 0 || fi == 6)
            fi = 5;
        else
        if(j == 0 && fw > 0 && i != fj)
            fi = 2;
        else
        if(j < fk && j < 2 && i != fj)
            fi = 3;
        else
        if(i != fj)
            if(fi == 3 || fi == 5)
                fi = 5;
            else
                fi = 4;
        if((fi == 3 || fi == 5) && j > fk)
            fi = 4;
        if(!fh)
            fi = 5;
        if(fi != 5 && fg)
            fi = 3;
        if(i == 0)
            fi = 6;
        if(fp == 2)
            if(f1 == 0)
                fi = 7;
            else
            if(fi == 3 && i != fj)
                fi = 5;
            else
                fi = 3;
        fk = j;
        fj = i;
        return fi;
    }

    public ac(m m1, int i, int j, int k, int l)
    {
        ac _tmp = this;
        boolean _tmp1 = false;
        fl = false;
        fk = 0;
        fj = 0;
        fi = 5;
        fh = true;
        fg = false;
        f0 = i;
        f_ = i;
        fv = j;
        fu = i - (i >> 4);
        ft = i - (i >> 6);
        super.er = -(l + 1);
        a6(m1, k);
    }

    public int f1;
    public int f0;
    public int f_;
    public int fw;
    public int fv;
    public int fu;
    public int ft;
    public int fr;
    public int fq;
    public int fp;
    public int fo;
    public int fn;
    public m d5;
    public boolean fl;
    public int fk;
    public int fj;
    public int fi;
    public boolean fh;
    public boolean fg;
    public int ff;
    public boolean fe;
    public boolean fc;
    public boolean fb;
    public long fa;
    public long e9;
    public long e8;
}
