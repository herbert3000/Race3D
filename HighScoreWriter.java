import java.applet.AppletContext;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class HighScoreWriter implements Runnable
{

    public final void run()
    {
        StringBuffer stringbuffer = new StringBuffer();
        URL url;
        try
        {
            url = new URL(em + c2 + "?" + "username=" + bw(c3) + "&" + "trackName=" + bw(el) + "&" + "carName=" + bw(ek) + "&" + "timeMillis=" + ej);
        }
        catch(MalformedURLException malformedurlexception)
        {
            System.out.println("HighScoreWriter: bad url: " + malformedurlexception);
            return;
        }
        try
        {
            BufferedInputStream bufferedinputstream = new BufferedInputStream(url.openStream());
            for(int i = bufferedinputstream.read(); i != -1; i = bufferedinputstream.read())
                stringbuffer.append((char)i);

            bufferedinputstream.close();
        }
        catch(IOException ioexception)
        {
            System.out.println("HighScoreWriter: io: " + ioexception);
            return;
        }
        Frame frame = new Frame("CGI results");
        frame.resize(Toolkit.getDefaultToolkit().getScreenSize());
        MessageBox l1 = new MessageBox(frame, stringbuffer.toString(), 0);
    }

    public final String bw(String s)
    {
        String s1 = "";
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if((Character.isLetterOrDigit(c) || c == ' ') && c < '\200')
            {
                s1 = s1 + c;
            } else
            {
                String s2 = Integer.toHexString(c);
                if(s2.length() == 1)
                    s2 = "0" + s2;
                s1 = s1 + "%" + s2;
            }
        }

        return s1.replace(' ', '+');
    }

    public HighScoreWriter(AppletContext appletcontext, String s, String s1, String s2, String s3, String s4, String s5, 
            long l1)
    {
        HighScoreWriter _tmp = this;
        AppletContext _tmp1 = appletcontext;
        em = s;
        c2 = s1;
        HighScoreWriter _tmp2 = this;
        String _tmp3 = s2;
        c3 = s3;
        el = s4;
        ek = s5;
        ej = l1;
    }

    public String em;
    public String c2;
    public String el;
    public String ek;
    public String c3;
    public long ej;
}
