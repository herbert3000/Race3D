public class aa
{

    public static boolean cc(int i)
    {
        if(!Main.df)
            switch(ce(i, false))
            {
            case 1004: 
                e4[2] = false;
                break;

            case 1005: 
                e4[3] = false;
                break;

            case 1006: 
                e4[0] = false;
                break;

            case 1007: 
                e4[1] = false;
                break;

            case 1002: 
                e4[4] = false;
                break;

            case 1003: 
                e4[5] = false;
                break;
            }
        return true;
    }

    public static boolean cd(int i)
    {
        switch(ce(i, true))
        {
        case 10: // '\n'
        case 32: // ' '
            e4[12] = true;
            break;

        case 96: // '`'
        case 126: // '~'
            e4[11] = true;
            break;

        case 43: // '+'
        case 61: // '='
            e4[9] = true;
            break;

        case 45: // '-'
            e4[10] = true;
            break;

        case 1016: 
            e4[7] = true;
            break;

        case 1017: 
            e4[8] = true;
            break;

        case 27: // '\033'
        case 1008: 
            e4[6] = true;
            break;

        case 1004: 
            e4[2] = true;
            e4[3] = false;
            break;

        case 1005: 
            e4[3] = true;
            e4[2] = false;
            break;

        case 1006: 
            e4[0] = true;
            e4[1] = false;
            break;

        case 1007: 
            e4[1] = true;
            e4[0] = false;
            break;

        case 1002: 
            e4[4] = true;
            e4[5] = false;
            break;

        case 1003: 
            e4[5] = true;
            e4[4] = false;
            break;

        case 1000: 
            e4[13] = true;
            e4[14] = false;
            break;

        case 1001: 
            e4[14] = true;
            e4[13] = false;
            break;
        }
        return true;
    }

    private static int ce(int i, boolean flag)
    {
        if(i > 127)
            return i;
        i = Character.toUpperCase((char)i);
        if(flag)
        {
            e1 = i;
            if(e3)
                return i;
        }
        if(i == e2[0])
            i = 1004;
        if(i == e2[1])
            i = 1005;
        if(i == e2[2])
            i = 1006;
        if(i == e2[3])
            i = 1007;
        return i;
    }

    public static volatile boolean e4[];
    public static volatile boolean e3 = false;
    public static char e2[] = {
        'I', 'K', 'J', 'L'
    };
    public static volatile int e1;

    static 
    {
        e4 = new boolean[15];
        for(int i = 0; i < 15; i++)
            e4[i] = false;

    }
}
