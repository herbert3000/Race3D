import java.awt.Point;
import java.util.Vector;

public class r
{

    public final void bc()
    {
        if(bv != null && ((y) (bv)).et > 0)
        {
            double d = (bz * (double)(100 - (((y) (bv)).et >> 16))) / 100D;
            bi = (int)(d * (double)br.o);
        } else
        {
            bi = (int)(bz * (double)br.o);
        }
        if(bi > br.o / 2)
        {
            bm = 0;
            bl = (bi - br.o / 2) + 1;
        } else
        {
            bm = (br.o / 2 - bi) * br.n;
            bl = 1;
        }
        bk = br.o / 2 + bi + 1;
    }

    public final void bd(m m1, ad ad1)
    {
        bx = m1;
        int j = m1.point.x;
        int k = m1.point.y;
        y y1 = new y();
        y1.ev = (j << 22) + 0x200000;
        y1.eu = (k << 22) + 0x200000;
        if((m1.int0 & 1) == 0)
            y1.eu += 0x200000;
        else
            y1.ev += 0x200000;
        y1.et = 0;
        y1.b_(m1.int0 * 1024);
        bo.a6();
        bo.bz(m1.vector);
        bo.bz(y1);
        for(int l = 0; l < ad1.cq(); l++)
            bo.bz(ad1.ct(l));

        bv = ad1.cs();
        be(br);
        bu = a5[m1.int3 % a5.length];
    }

    public final void be(i j)
    {
        br = j;
        bn = (byte[])j.aa;
        bj = a.f((double)(j.p / 2) / Math.tan(by / 2D));
        bc();
        if(bx != null)
        {
            i k = bq[bx.int2 % bq.length];
            float f = (float)(j.o / 2) / (float)k.o;
            int l = Math.round((float)k.p * f);
            bp = new i(l, j.o / 2, j.ab);
            k.am(bp, 0, 0, bp.p, bp.o);
        }
    }

    public final void bf(long l)
    {
        Object obj = null;
        Object obj1 = null;
        g g1 = null;
        if(bv.fa != 0L && l >= bv.fa)
        {
            long l2 = l - bv.fa;
            if(l2 > 2000L)
                bw.b_(bv.b0() + 2048);
            else
                bw.b_(bv.b0() + (int)((4096L * l2) / 4000L));
            bw.ev = ((y) (bv)).ev - bw.eq * 48;
            bw.eu = ((y) (bv)).eu - bw.ep * 48;
            bw.et = ((y) (bv)).et + 0x120000;
            if(bz != 0.09D)
            {
                bz = 0.09D;
                bc();
            }
        } else
        if((bv instanceof ae) && bv.ff == 2)
        {
            byte byte1;
            if(((y) (bv)).ev >> 22 < 16)
                byte1 = 8;
            else
                byte1 = 24;
            byte byte2;
            if(((y) (bv)).eu >> 22 < 16)
                byte2 = 8;
            else
                byte2 = 24;
            bw.ev = byte1 * 64 << 16;
            bw.eu = byte2 * 64 << 16;
            bw.et = 0x640000;
            bw.b_(a.d(Math.atan2(((y) (bv)).eu - bw.eu, ((y) (bv)).ev - bw.ev)));
            if(bz != 0.09D)
            {
                bz = 0.09D;
                bc();
            }
        } else
        {
            bw.b_(bv.b0());
            bw.ev = ((y) (bv)).ev - bw.eq * 48;
            bw.eu = ((y) (bv)).eu - bw.ep * 48;
            bw.et = ((y) (bv)).et + 0x120000;
            if(!bv.fh)
            {
                int k2 = (int)(l << 5 & 4095L);
                int j3 = bv.ci();
                if(j3 > 40)
                    j3 = 40;
                int k9;
                bz = 0.09D + (0.09D * (double)j3 * ((double)(k9 = a.b[k2]) / 65536D)) / 600D;
                bc();
            } else
            if(bz != 0.09D)
            {
                bz = 0.09D;
                bc();
            }
        }
        int i3 = (int)((float)(-bw.b0()) * (((float)bp.p * 2.0F) / 4096F));
        i3 %= bp.p;
        bp.an(br, i3, -bi);
        bp.an(br, i3 + bp.p, -bi);
        long l3 = bw.et;
        long l4 = bj;
        long l5 = (long)br.p << 15;
        long l6 = l4 * (long)bw.eq + l5 * (long)bw.ep >> 16;
        long l7 = l4 * (long)bw.ep - l5 * (long)bw.eq >> 16;
        int i5 = bm;
        for(int j5 = bl; j5 < bk; j5++)
        {
            long l8 = l3 / (long)j5;
            int k3 = (int)(l8 * l6 >> 16) + bw.ev;
            int i4 = (int)(l8 * l7 >> 16) + bw.eu;
            int j4 = (int)(-l8 * (long)bw.ep >> 16);
            int k4 = (int)(l8 * (long)bw.eq >> 16);
            int i6 = 0;
            for(int j6 = 0; j6 < a5.length - 1; j6++)
                if(l8 > 1L << 15 + j6)
                    i6 = j6 + 1;

            int k1 = -1;
            int l1 = -1;
            n n2 = bx.ar;
            byte abyte0[] = null;
            byte abyte1[] = null;
            for(int k6 = 0; k6 < br.p; k6++)
            {
                boolean flag = false;
                int j = k3 >> 22;
                int k = i4 >> 22;
                int i1 = j & 0x1f;
                int j1 = k & 0x1f;
                n n1;
                if(k1 == j && l1 == k)
                {
                    n1 = n2;
                    flag = true;
                } else
                {
                    if(j != i1 || k != j1)
                        n1 = bx.ar;
                    else
                        n1 = bx.aw[j | k << 5];
                    k1 = j;
                    l1 = k;
                    n2 = n1;
                }
                byte byte0 = 0;
                if(n1.b0 != 0)
                {
                    if(!flag || abyte0 == null)
                    {
                        g1 = bu[i6][n1.b0];
                        abyte0 = (byte[])((i) (g1)).aa;
                    }
                    int i2 = k3 >> 15 + i6 & g1.t | (i4 >> 15 + i6 & g1.t) << g1.u;
                    byte0 = abyte0[i2];
                } else
                {
                    abyte0 = null;
                    g1 = null;
                }
                if(byte0 == 0)
                {
                    if(!flag || abyte1 == null)
                        abyte1 = (byte[])((i) (a6[n1.b1])).aa;
                    int j2 = k3 >> 16 & 0x3f | (i4 >> 16 & 0x3f) << 6;
                    byte0 = abyte1[j2];
                } else
                {
                    abyte1 = null;
                }
                bn[i5++] = byte0;
                k3 += j4;
                i4 += k4;
            }

            i5 += br.n - br.p;
        }

        bo.bx(bw);
        boolean flag1 = false;
        for(int k5 = 0; !flag1 && k5 < bo.h(); k5++)
        {
            y y1 = bo.by(k5);
            if(y1.eo <= 0)
            {
                flag1 = true;
            } else
            {
                long l9 = y1.ev - bw.ev;
                long l10 = y1.eu - bw.eu;
                long l11 = -l9 * (long)bw.ep + l10 * (long)bw.eq >> 16;
                long l12 = ((long)bj << 16) / (long)y1.eo;
                i i7;
                int j7;
                int k7;
                if(y1.er < 0)
                {
                    int i8 = (bw.b0() - y1.b0()) + 2048;
                    if(y1 instanceof ac)
                        if(y1 == bv)
                        {
                            i8 += ((ac)y1).fr >> 14;
                            i8 -= ((ac)y1).fq >> 14;
                        } else
                        {
                            i8 += ((ac)y1).fr >> 15;
                            i8 -= ((ac)y1).fq >> 15;
                        }
                    i8 = -i8;
                    i8 = (i8 + 68 & 0xfff) * 30 >> 12;
                    i7 = bs[-1 - y1.er][i8];
                    j7 = (i7.p * 7) / 40;
                    k7 = (i7.o * 7) / 40;
                } else
                {
                    i7 = bt[y1.er];
                    j7 = i7.p >> 1;
                    k7 = i7.o >> 1;
                }
                int j8 = (int)(l12 * (long)j7 >> 16) + 1;
                int k8 = (int)(l12 * (long)k7 >> 16) + 1;
                int i9 = (int)(l12 * l11 >> 32) + (br.p - j8 >> 1);
                int j9 = ((int)(l12 * (long)bw.et >> 32) + (br.o >> 1)) - k8;
                if(y1 instanceof ac)
                    j9 += k8 >> 2;
                i7.am(br, i9, j9 - bi, j8, k8);
            }
        }

    }

    public r(i j, i ai[], g ag[], g ag1[][][], i ai1[], i ai2[][])
    {
        bz = 0.09D;
        bn = null;
        bi = 16;
        r _tmp = this;
        new Vector();
        bq = ai;
        a6 = ag;
        a5 = ag1;
        bt = ai1;
        bs = ai2;
        bo = new x();
        bw = new y();
        be(j);
    }

    public double bz;
    public static final double by;
    public m bx;
    public y bw;
    public ac bv;
    public g a6[];
    public g a5[][][];
    public g bu[][];
    public i bt[];
    public i bs[][];
    public i br;
    public i bq[];
    public i bp;
    public x bo;
    public byte bn[];
    public int bm;
    public int bl;
    public int bk;
    public int bj;
    public int bi;

    static 
    {
        double d = 60D;
        by = (d * 2D * 3.1415926535897931D) / 360D;
    }
}
