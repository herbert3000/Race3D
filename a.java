import java.awt.Point;

public class a
{

    public static final i a(i j, int k)
    {
        boolean flag = false;
        Point point;
        Point point1;
        Point point2;
        switch(k)
        {
        case 3:
            flag = true;
            point = new Point(j.p - 1, 0);
            point1 = new Point(0, 1);
            point2 = new Point(-1, 0);
            break;

        case 2:
            point = new Point(j.p - 1, j.o - 1);
            point1 = new Point(-1, 0);
            point2 = new Point(0, -1);
            break;

        case 1:
            flag = true;
            point = new Point(0, j.o - 1);
            point1 = new Point(0, -1);
            point2 = new Point(1, 0);
            break;

        case 4:
            point = new Point(j.p - 1, 0);
            point1 = new Point(-1, 0);
            point2 = new Point(0, 1);
            break;

        case 5:
            point = new Point(0, j.o - 1);
            point1 = new Point(1, 0);
            point2 = new Point(0, -1);
            break;

        case 7:
            flag = true;
            point = new Point(j.p - 1, j.o - 1);
            point1 = new Point(0, -1);
            point2 = new Point(-1, 0);
            break;

        case 6:
            flag = true;
            point = new Point(0, 0);
            point1 = new Point(0, 1);
            point2 = new Point(1, 0);
            break;

        default:
            if(j instanceof g)
                return new g((g)j);
            else
                return new i(j);
        }
        Object obj;
        if(j instanceof g)
            obj = new g(((g)j).u, j.ab);
        else
        if(flag)
            obj = new i(j.o, j.p, j.ab);
        else
            obj = new i(j.p, j.o, j.ab);
        ((i) (obj)).ai(j.ak());
        int l = point.x;
        int i1 = point.y;
        int j1 = point1.x * ((i) (obj)).p;
        int k1 = point1.y * ((i) (obj)).p;
        int l1 = 0;
        if(((i) (obj)).aa instanceof byte[])
        {
            byte abyte0[] = (byte[])((i) (obj)).aa;
            byte abyte1[] = (byte[])j.aa;
            for(int i2 = 0; i2 < ((i) (obj)).o; i2++)
            {
                for(int k2 = 0; k2 < ((i) (obj)).p; k2++)
                {
                    abyte0[l1++] = abyte1[l + i1 * j.n];
                    l += point1.x;
                    i1 += point1.y;
                }

                l1 += ((i) (obj)).n - ((i) (obj)).p;
                l -= j1;
                i1 -= k1;
                l += point2.x;
                i1 += point2.y;
            }

        } else
        if(((i) (obj)).aa instanceof int[])
        {
            int ai[] = (int[])((i) (obj)).aa;
            int ai1[] = (int[])j.aa;
            for(int j2 = 0; j2 < ((i) (obj)).o; j2++)
            {
                for(int l2 = 0; l2 < ((i) (obj)).p; l2++)
                {
                    ai[l1++] = ai1[l + i1 * j.n];
                    l += point1.x;
                    i1 += point1.y;
                }

                l1 += ((i) (obj)).n - ((i) (obj)).p;
                l -= j1;
                i1 -= k1;
                l += point2.x;
                i1 += point2.y;
            }

        }
        return ((i) (obj));
    }

    public static final g b(i j, int k, int l, int i1)
    {
        g g1 = new g(i1, j.ab);
        j.an(g1, -k, -l);
        return g1;
    }

    public static final int c(int j, int k)
    {
        return c(k - j) + j;
    }

    public static final int c(int j)
    {
        int k = e(j) >> 16;
        if(k == j && k > 0)
            k = j - 1;
        return k;
    }

    public static final int d(double d1)
    {
        return (int)Math.round((d1 * 4096D) / 6.2831853071795862D) & 0xfff;
    }

    public static final int e(int j)
    {
        return f(Math.random() * (double)j);
    }

    public static final int f(double d1)
    {
        return (int)Math.round(d1 * 65536D);
    }

    public static int c[];
    public static int b[];
    public static int a[];

    static 
    {
        f(3.1415926535897931D);
        c = new int[4096];
        b = new int[4096];
        a = new int[4096];
        for(int j = 0; j < 4096; j++)
        {
        	double d = ((double)(j) * 2D * 3.1415926535897931D) / 4096D;
            c[j] = f(Math.cos(d));
            b[j] = f(Math.sin(d));
            a[j] = f(Math.tan(d));
        }

    }
}
