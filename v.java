import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Vector;

public class v
{

    public final boolean bt(URL url, String s)
    {
        URL url1;
        try
        {
            url1 = new URL(url, s);
        }
        catch(MalformedURLException malformedurlexception)
        {
            System.out.println(malformedurlexception);
            return false;
        }
        try
        {
            InputStream inputstream = url1.openStream();
            StreamTokenizer streamtokenizer = new StreamTokenizer(inputstream);
            streamtokenizer.slashSlashComments(true);
            streamtokenizer.slashStarComments(true);
            streamtokenizer.nextToken();
            while(streamtokenizer.ttype == -3) 
            {
                String s1 = streamtokenizer.sval;
                streamtokenizer.nextToken();
                if(streamtokenizer.ttype == 61)
                {
                    streamtokenizer.nextToken();
                    if(streamtokenizer.ttype == 123)
                    {
                        Vector vector = new Vector();
                        streamtokenizer.nextToken();
                        while(streamtokenizer.ttype == 34) 
                        {
                            vector.addElement(streamtokenizer.sval);
                            streamtokenizer.nextToken();
                        }
                        if(streamtokenizer.ttype != 125)
                            System.out.println(s + ": Expected '}' at line " + streamtokenizer.lineno());
                        else
                            streamtokenizer.nextToken();
                        ei.put(s1, vector);
                    } else
                    if(streamtokenizer.ttype == 34)
                    {
                        ei.put(s1, streamtokenizer.sval);
                        streamtokenizer.nextToken();
                    }
                } else
                {
                    System.out.println(s + ": Expected '=' at line " + streamtokenizer.lineno());
                }
            }
            inputstream.close();
        }
        catch(IOException ioexception)
        {
            System.out.println(ioexception);
            return false;
        }
        return true;
    }

    public final Vector bu(String s)
    {
        return (Vector)ei.get(s);
    }

    public final String bv(String s)
    {
        return (String)ei.get(s);
    }

    public v()
    {
        ei = new Hashtable();
    }

    public Hashtable ei;
}
