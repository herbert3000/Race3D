// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JAX

import java.io.*;

public class i
    implements c
{

    public final void ai(boolean flag)
    {
        if(flag)
            z = 1;
        else
            z = 0;
    }

    public void aj(int k, int l, boolean flag)
    {
        int i1 = k * l;
        Object ai1;
        if(ab == 8)
            ai1 = new byte[i1];
        else
            ai1 = new int[i1];
        if(flag)
        {
            int j1 = 0;
            int k1 = 0;
            for(int l1 = 0; l1 < o; l1++)
            {
                System.arraycopy(aa, j1, ai1, k1, p);
                j1 += n;
                k1 += p;
            }

        }
        aa = ai1;
        n = k;
        p = k;
        o = l;
    }

    public final void readFile(InputStream inputstream)
    {
		try {
			Object obj = null;
			int k = p * o;
			DataInputStream datainputstream = new DataInputStream(inputstream);
			switch(ab)
			{
			case 8: // '\b'
				b.g(datainputstream, (byte[])aa);
				break;

			case 15: // '\017'
			case 16: // '\020'
				byte abyte0[] = new byte[k * 2];
				b.g(datainputstream, abyte0);
				for(int l = 0; l < k; l++)
					((int[])aa)[l] = abyte0[l * 2] << 8 | abyte0[l * 2 + 1];

				abyte0 = null;
				break;

			case 24: // '\030'
				byte abyte1[] = new byte[k * 3];
				b.g(datainputstream, abyte1);
				for(int i1 = 0; i1 < k; i1++)
					((int[])aa)[i1] = abyte1[i1 * 3] << 16 | abyte1[i1 * 3 + 1] << 8 | abyte1[i1 * 3 + 2];

				abyte1 = null;
				break;

			default:
				System.out.println(ab + "-bit RAW file support not implemented");
				break;
			}
		} catch (IOException e) {}
    }

    public final boolean ak()
    {
        return z == 1;
    }

    public final void al(i k, int l, int i1, int j1, int k1, boolean flag)
    {
        if(j1 <= 0 || k1 <= 0)
            return;
        if(!flag)
        {
            for(int l1 = 0; l1 < k1; l1++)
            {
                System.arraycopy(aa, i1, k.aa, l, j1);
                i1 += n;
                l += k.n;
            }

        } else
        if(aa instanceof byte[])
        {
            byte abyte0[] = (byte[])aa;
            byte abyte1[] = (byte[])k.aa;
            for(int i2 = 0; i2 < k1; i2++)
            {
                for(int j2 = 0; j2 < j1; j2++)
                {
                    byte byte0 = abyte0[i1];
                    if(byte0 != 0)
                        abyte1[l] = byte0;
                    l++;
                    i1++;
                }

                i1 += n - j1;
                l += k.n - j1;
            }

        }
    }

    public final void am(i k, int l, int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2)
    {
        if(j2 <= 0 || k2 <= 0)
            return;
        int l2 = j2;
        int i3 = k2;
        int j3 = 0;
        int k3 = 0;
        int j4 = (p << 16) / j2;
        int k4 = (o << 16) / k2;
        boolean flag = false;
        int i5 = 0;
        if(j1 < 0)
            j1 = 0;
        if(k1 < 0)
            k1 = 0;
        if(l1 > k.p)
            l1 = k.p;
        if(i2 > k.o)
            i2 = k.o;
        if(l < j1)
        {
            l2 -= j1 - l;
            j3 += j1 - l;
            l = j1;
        }
        if(i1 < k1)
        {
            i3 -= k1 - i1;
            k3 += k1 - i1;
            i1 = k1;
        }
        if(l2 > 0 && l + l2 > l1)
            l2 = l1 - l;
        if(i3 > 0 && i1 + i3 > i2)
            i3 = i2 - i1;
        if(l2 <= 0 || i3 <= 0)
            return;
        int i4 = l + i1 * k.n;
        i5 = k3 * k4;
        int j5 = j3 * j4;
        if(aa instanceof byte[])
        {
            byte abyte0[] = (byte[])aa;
            byte abyte1[] = (byte[])k.aa;
            for(int k5 = 0; k5 < i3; k5++)
            {
                int l4 = j5;
                int l3 = (i5 >> 16) * n;
                for(int l5 = 0; l5 < l2; l5++)
                {
                    byte byte0 = abyte0[l3 + (l4 >> 16)];
                    if(byte0 != 0)
                        abyte1[i4 + l5] = byte0;
                    l4 += j4;
                }

                i4 += k.n;
                i5 += k4;
            }

        }
    }

    public final void am(i k, int l, int i1, int j1, int k1)
    {
        am(k, l, i1, 0, 0, k.p, k.o, j1, k1);
    }

    public final void an(i k, int l, int i1, int j1, int k1, int l1, int i2)
    {
        int j2 = p;
        int k2 = o;
        int l2 = 0;
        if(j1 < 0)
            j1 = 0;
        if(k1 < 0)
            k1 = 0;
        if(l1 > k.p)
            l1 = k.p;
        if(i2 > k.o)
            i2 = k.o;
        if(l < j1)
        {
            j2 -= j1 - l;
            l2 += j1 - l;
            l = j1;
        }
        if(i1 < k1)
        {
            k2 -= k1 - i1;
            l2 += (k1 - i1) * n;
            i1 = k1;
        }
        if(j2 > 0 && l + j2 > l1)
            j2 = l1 - l;
        if(k2 > 0 && i1 + k2 > i2)
            k2 = i2 - i1;
        int i3 = l + i1 * k.n;
        al(k, i3, l2, j2, k2, ak());
    }

    public final void an(i k, int l, int i1)
    {
        an(k, l, i1, 0, 0, k.p, k.o);
    }

    public final void ao(i k, int l, int i1)
    {
        al(k, l + i1 * k.n, 0, p, o, ak());
    }

    public i(i k)
    {
        this(k.p, k.o, k.ab, k.n, k.ak());
        k.al(this, 0, 0, p, o, ak());
    }

    public i(int k, int l, int i1, int j1, boolean flag)
    {
        aa = null;
        z = 0;
        if(j1 < k)
            j1 = k;
        p = k;
        o = l;
        ab = i1;
        n = j1;
        if(flag)
            z = 1;
        else
            z = 0;
        int k1 = j1 * l;
        if(i1 == 8)
            aa = new byte[k1];
        else
            aa = new int[k1];
    }

    public i(int k, int l, int i1)
    {
        this(k, l, i1, k, false);
    }

    public int p;
    public int n;
    public int o;
    public int ab;
    public Object aa;
    public int z;
}
