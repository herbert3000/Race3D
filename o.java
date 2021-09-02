import java.awt.Component;
import java.io.InputStream;
import java.util.Vector;

public class o
    implements c
{

    private final void ax(int k, int l, int i1, int j1, int k1)
    {
        if((i1 & 7) == 0)
        {
            a4.setElementAt("Transforming " + a2 + " [" + ((i1 + 1) - 12) + " of " + 59 + "]", a4.size() - 1);
            Thread.yield();
        }
        a5[k][l][i1] = (g)a.a(a5[k][l][j1], k1);
    }

    public final void ay(Component component, Vector vector)
    {
        o _tmp = this;
        Component _tmp1 = component;
        a4 = vector;
    }

    private final void az(InputStream inputstream, int k, int l)
    {
        String s = (String)a4.lastElement();
        a4.removeElementAt(a4.size() - 1);
        a2 = s + "[" + (128 >> l) + "]";
        a4.addElement(a2);
        j(inputstream, 2, 6, 7 - l, a5[k][l], 0);
        a4.addElement(a2);
        int ai[] = new int[7];
        ai[0] = 1;
        ai[1] = 2;
        ai[2] = 3;
        ai[3] = 4;
        ai[4] = 5;
        ai[5] = 6;
        ai[6] = 7;
        for(int i1 = 12; i1 < 71; i1++)
        {
            ax(k, l, i1, a7[i1 - 12][0], ai[a7[i1 - 12][1]]);
            Thread.yield();
        }

    }

    private final void a_(InputStream inputstream)
    {
        a2 = (String)a4.elementAt(a4.size() - 1);
        g ag[] = new g[24];
        j(inputstream, 6, 4, 6, ag, 0);
        Thread.yield();
        a4.addElement(a2);
        int k = 5;
        for(int l = 0; l < 24; l++)
        {
            a4.setElementAt("Transforming " + a2 + " [" + (l + 1) * 4 + " of " + 96 + "]", a4.size() - 1);
            Thread.yield();
            a6[k++] = (g)a.a(ag[l], 0);
            Thread.yield();
            a6[k++] = (g)a.a(ag[l], 1);
            Thread.yield();
            a6[k++] = (g)a.a(ag[l], 2);
            Thread.yield();
            a6[k++] = (g)a.a(ag[l], 3);
            Thread.yield();
        }

    }

    private final void a0(InputStream inputstream)
    {
        a2 = (String)a4.elementAt(a4.size() - 1);
        j(inputstream, 5, 1, 6, a6, 0);
        Thread.yield();
    }

    private final i j(InputStream inputstream, int k, int l, int i1, g ag[], int j1)
    {
        i k1 = new i((1 << i1) * k, (1 << i1) * l, 8);
        a4.setElementAt(a2, a4.size() - 1);
        Thread.yield();
        k1.readFile(inputstream);
        for(int l1 = 0; l1 < l; l1++)
        {
            for(int i2 = 0; i2 < k; i2++)
            {
                ag[i2 + l1 * k + j1] = a.b(k1, (1 << i1) * i2, (1 << i1) * l1, i1);
                Thread.yield();
            }

        }

        return k1;
    }

    public final void readFile(InputStream inputstream)
    {
        if(a3 == 0)
            a0(inputstream);
        else
        if(a3 == 1)
            a_(inputstream);
        else
        if(a3 >= 2 && a3 < 2 + a1)
            az(inputstream, 0, a3 - 2);
        else
            a3 = -1;
        a3++;
    }

    public final g[] a1()
    {
        return a6;
    }

    public final g[][][] a2()
    {
        return a5;
    }

    public o(int k)
    {
        a4 = new Vector();
        a3 = 0;
        a1 = k;
        a6 = new g[101];
        a5 = new g[1][k][71];
    }

    public static final int a7[][] = {
        {
            1, 3
        }, {
            1, 0
        }, {
            1, 6
        }, {
            2, 5
        }, {
            3, 5
        }, {
            5, 5
        }, {
            2, 0
        }, {
            3, 0
        }, {
            4, 0
        }, {
            5, 0
        }, {
            2, 3
        }, {
            3, 3
        }, {
            5, 3
        }, {
            2, 2
        }, {
            3, 2
        }, {
            4, 2
        }, {
            5, 2
        }, {
            2, 4
        }, {
            3, 4
        }, {
            5, 4
        }, {
            2, 1
        }, {
            3, 1
        }, {
            4, 1
        }, {
            5, 1
        }, {
            2, 6
        }, {
            3, 6
        }, {
            5, 6
        }, {
            10, 5
        }, {
            6, 3
        }, {
            7, 3
        }, {
            8, 3
        }, {
            9, 3
        }, {
            10, 4
        }, {
            6, 4
        }, {
            7, 4
        }, {
            8, 4
        }, {
            9, 4
        }, {
            10, 3
        }, {
            6, 1
        }, {
            7, 1
        }, {
            8, 1
        }, {
            9, 1
        }, {
            6, 2
        }, {
            7, 2
        }, {
            8, 2
        }, {
            9, 2
        }, {
            6, 6
        }, {
            7, 6
        }, {
            8, 6
        }, {
            9, 6
        }, {
            6, 5
        }, {
            7, 5
        }, {
            8, 5
        }, {
            9, 5
        }, {
            6, 0
        }, {
            7, 0
        }, {
            8, 0
        }, {
            9, 0
        }, {
            11, 0
        }
    };
    public g a6[];
    public g a5[][][];
    public Vector a4;
    public int a3;
    public String a2;
    public int a1;

}
