public class u extends Thread
{

    public final void run()
    {
        for(int i = 0; i < cm.length; i++)
        {
            cm[i] = new m();
            b4.j(cm[i], null, "tracks/track" + i + ".ser.gz");
            cm[i].int0 = 4 - cm[i].int0 & 3;
            b4.cj++;
            Thread.yield();
            if(b4.b9)
                return;
        }

        b4.ch = true;
    }

    public u(MainCanvas t1, m am[])
    {
        cm = am;
        b4 = t1;
    }

    public m cm[];
    public MainCanvas b4;
}
