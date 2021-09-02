public final class j extends i
{

    private final void ap(i k, int l, int i1, char ac1[], int j1, int k1, int l1, 
            int i2)
    {
        int j2 = 0;
        int k2 = 0;
        boolean flag = (ad == l1 && ac == i2) ^ true;
        if(flag)
        {
            j2 = (super.p * l1) / ad;
            k2 = (super.o * i2) / ac;
        }
        for(int l2 = j1; l2 < j1 + k1; l2++)
        {
            char c = ac1[l2];
            if(!ag && Character.isLowerCase(c))
                c = Character.toUpperCase(c);
            if(!ah && Character.isUpperCase(c))
                c = Character.toLowerCase(c);
            if(c >= af && c <= ae)
            {
                int i3 = (c - af) * l1;
                if(flag)
                    super.am(k, l - i3, i1, l, i1, l + l1, i1 + i2, j2, k2);
                else
                    super.an(k, l - i3, i1, l, i1, l + l1, i1 + i2);
            }
            l += l1;
        }

    }

    public final void aq(i k, int l, int i1, String s, int j1, int k1, int l1)
    {
        aq(k, l, i1, q.z().aa(s), j1, k1, l1);
    }

    public final void aq(i k, int l, int i1, String s, int j1)
    {
        aq(k, l, i1, s, j1, ad, ac);
    }

    public final void aq(i k, int l, int i1, String s)
    {
        aq(k, l, i1, s, 0, ad, ac);
    }

    public final void aq(i k, int l, int i1, f f1, int j1, int k1, int l1)
    {
        int i2 = 0;
        int l2 = l;
        int i3 = i1;
        do
        {
            int k2 = f1.x(10, i2);
            int j2;
            if(k2 == -1)
                j2 = f1.w() - i2;
            else
                j2 = k2 - i2;
            switch(j1)
            {
            case 1: // '\001'
                l2 = l - (j2 * k1) / 2;
                break;

            case 2: // '\002'
                l2 = l - j2 * k1;
                break;
            }
            ap(k, l2, i3, f1.y(), i2, j2, k1, l1);
            i3 += l1;
            i2 = k2 + 1;
        } while(i2 > 0);
    }

    public final void aq(i k, int l, int i1, f f1, int j1)
    {
        aq(k, l, i1, f1, j1, ad, ac);
    }

    public final void aq(i k, int l, int i1, f f1)
    {
        aq(k, l, i1, f1, 0, ad, ac);
    }

    public j(char c, char c1, int k, int l, int i1, boolean flag)
    {
        super(((c1 - c) + 1) * k, l, i1, ((c1 - c) + 1) * k, flag);
        ah = false;
        ag = false;
        af = c;
        ae = c1;
        ad = k;
        ac = l;
        if(c <= 'a' && c1 >= 'z')
            ag = true;
        if(c <= 'A' && c1 >= 'Z')
            ah = true;
    }

    public j(char c, char c1, int k, int l, int i1)
    {
        this(c, c1, k, l, i1, true);
    }

    public static f q = new f();
    public boolean ah;
    public boolean ag;
    public char af;
    public char ae;
    public int ad;
    public int ac;

}
