// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JAX


public final class g extends i
{

    public g(g g1)
    {
        this(g1.u, ((i) (g1)).ab);
        super.al(this, 0, 0, super.p, super.o, super.ak());
    }

    public g(int j, int k)
    {
        super(1 << j, 1 << j, k);
        u = j;
        t = (1 << j) - 1;
    }

    public int u;
    public int t;
}
