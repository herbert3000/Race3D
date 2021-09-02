import java.applet.Applet;
import java.awt.*;
import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@SuppressWarnings({ "unused", "serial", "deprecation" })
public class MainCanvas extends Canvas implements Runnable
{

	public final void update(Graphics g)
    {
        if(cg == null || cg.getWidth(this) != size().width || cg.getHeight(this) != size().height)
            cg = createImage(size().width, size().height);
        paint(cg.getGraphics());
        g.drawImage(cg, 0, 0, this);
    }

    private final void bh()
    {
        if(ci && ch)
            if(cr.playPong && !b5)
            {
                b5 = true;
                repaint();
            } else
            {
                cr.remove(this);
                cr.bh();
            }
    }

    public final void run()
    {
        cc = false;
        String s1 = System.getProperty("java.version");
        try
        {
            if(Float.valueOf(s1.substring(0, 3)).floatValue() < 1.1F)
                cc = true;
        }
        catch(NumberFormatException _ex)
        {
            cc = true;
        }
        if(cc)
        {
            repaint();
            Thread.yield();
        }
        h = System.currentTimeMillis();
        ZipInputStream zipinputstream = bi(cr.zipFileName);
        if(zipinputstream == null)
            return;
        (new u(this, cm)).start();
        b8 = new s(this, size().width, size().height - 60);
        b8.start();
        MediaTracker mediatracker = new MediaTracker(this);
        mediatracker.addImage(bp, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(InterruptedException _ex) { }
        a4.addElement("Palette");
        Thread.yield();
        if(b9)
            return;
        j(cq.ar(), zipinputstream, "race.lmp");
        cq.au();
        a4.addElement("Fonts");
        for(int i1 = 0; i1 < cp.length; i1++)
        {
            a4.setElementAt("Fonts [" + (i1 + 1) + " of " + cp.length + "]", a4.size() - 1);
            Thread.yield();
            if(b9)
                return;
            j(cp[i1], zipinputstream, "font" + i1 + ".raw");
        }

        a4.addElement("Backgrounds");
        for(int j1 = 0; j1 < bq.length; j1++)
        {
            a4.setElementAt("Backgrounds [" + (j1 + 1) + " of " + bq.length + "]", a4.size() - 1);
            Thread.yield();
            if(b9)
                return;
            bq[j1] = new i(1, 1, 8);
            j(bq[j1], zipinputstream, "background" + j1 + "_?.raw");
        }

        cn.ay(this, a4);
        a4.addElement("Base Textures");
        j(cn, zipinputstream, "all_textures1.raw");
        a4.addElement("Combo Textures");
        j(cn, zipinputstream, "all_textures2.raw");
        for(int k1 = 0; k1 < a1; k1++)
        {
            a4.addElement("Road Textures (1)");
            j(cn, zipinputstream, "road_texture1" + (char)(97 + k1) + ".raw");
            Thread.yield();
            if(b9)
                return;
        }

        a4.addElement("Sprites");
        for(int l1 = 0; l1 < bt.length; l1++)
        {
            a4.setElementAt("Sprites [" + (l1 + 1) + " of " + bt.length + "]", a4.size() - 1);
            bt[l1] = new i(1, 1, 8);
            j(bt[l1], zipinputstream, "sprite" + l1 + "_?.raw");
            Thread.yield();
            if(b9)
                return;
        }

        a4.addElement("Cars");
        int ai[] = {
            1, 2, 3, 3, 5, 5, 7, 7, 9, 9, 
            11, 11, 13, 14, 15, 16
        };
        int i2 = -1;
        for(int j2 = 0; j2 < 5; j2++)
        {
            a4.setElementAt("Cars [" + (j2 + 1) + " of " + bs.length + "]", a4.size() - 1);
            for(int k2 = 0; k2 < 16; k2++)
            {
                int i3 = ai[k2];
                if(i3 == i2)
                {
                    bs[j2][k2] = new i(bs[j2][i3 - 1]);
                } else
                {
                    bs[j2][k2] = new i(180, 80, 8, 180, true);
                    j(bs[j2][k2], zipinputstream, "car-" + (char)(97 + j2) + (i3 >= 10 ? "" : "0") + i3 + ".raw");
                }
                i2 = i3;
                Thread.yield();
                if(b9)
                    return;
            }

            for(int j3 = 16; j3 < 30; j3++)
                bs[j2][j3] = a.a(bs[j2][30 - j3], 4);

        }

        a4.addElement("Menu Image");
        co = new i(1, 1, 8, 1, true);
        j(co, zipinputstream, "menu_?.raw");
        a4.addElement("Sounds");
        for(int l2 = 0; l2 < ct.length; l2++)
        {
            a4.setElementAt("Sounds [" + (l2 + 1) + " of " + ct.length + "]", a4.size() - 1);
            j(null, zipinputstream, ct[l2] + ".au");
            Thread.yield();
            if(b9)
                return;
        }

        bl(zipinputstream);
        ci = true;
        repaint();
    }

    public final void paint(Graphics g)
    {
        if(!b5 && cr.playPong && !cc && b8 != null && b8.isAlive())
        {
            g.setColor(Color.black);
            g.fillRect(0, 0, size().width, size().height - 60);
            g.setColor(Color.green);
            g.fillOval(b8.b2.x - 5, b8.b2.y - 5, 10, 10);
            g.fillRect(1, b7 - 25, 8, 50);
            g.fillRect(size().width - 1 - 8, b8.b1 - 25, 8, 50);
            g.setFont(cf);
            g.drawString(String.valueOf(b8.b_), 10, 15);
            g.drawString(String.valueOf(b8.b0), size().width - 20, 15);
            g.setColor(Color.white);
            g.fillRect(0, size().height - 60, size().width - 1, 60);
            g.drawRect(0, 0, size().width - 1, size().height - 1);
        } else
        if(!cr.playPong || b5)
        {
            g.drawImage(bp, 0, 0, this);
        } else
        {
            g.setColor(Color.black);
            g.fillRect(0, 0, size().width, size().height - 60);
            g.setColor(Color.white);
            g.fillRect(0, size().height - 60, size().width - 1, 60);
            g.drawRect(0, 0, size().width - 1, size().height - 1);
        }
        if(cc)
        {
            int k1 = 0;
            g.setFont(cl);
            g.setColor(Color.white);
            g.drawString("Your browser appears to have an older", 5, k1 += 12);
            g.drawString("version of Java. (This game won't work!)", 5, k1 += 12);
            g.drawString("Try using Internet Explorer 4.0,", 5, k1 += 12);
            g.drawString("Netscape Navigator 4.0, or AOL 4.0, or better.", 5, k1 += 12);
        }
        String s1 = cr.c0.bv("messageLoading");
        Color color = Color.white;
        Color color1 = Color.black;
        boolean flag = false;
        int l1 = 0;
        int i1;
        int j1;
        if(ci && ch)
        {
            if(b5 || !cr.playPong)
            {
                s1 = cr.c0.bv("messageDoneLoading");
                l1 = 300;
                i1 = 5;
                j1 = 232;
                g.setFont(cf);
                if(ca)
                {
                    color = new Color(128, 128, 255);
                    color1 = Color.black;
                    flag = true;
                }
            } else
            {
                g.setFont(cf);
                s1 = cr.c0.bv("messageDoneLoading");
                l1 = 300;
                j1 = 200;
                i1 = 160 - cd.stringWidth(s1) / 2;
            }
        } else
        {
            double d = 0.0D;
            j1 = 200;
            if(ck != null)
            {
                d = ck.i();
                l1 = (int)((long)l1 + Math.round(2.5D * d));
            }
            if(cm != null)
                l1 += (50 * cj) / cm.length;
            g.setColor(Color.black);
            g.drawRect(10, 217, 301, 10);
            g.setColor(Color.red);
            g.fillRect(11, 218, l1, 9);
            i1 = 160 - cd.stringWidth(s1) / 2;
            color = Color.white;
            g.setFont(ce);
            g.setColor(Color.black);
            if(cr.showLoadingInfo && a4.size() > 0)
            {
                String s2 = (String)a4.lastElement();
                if(!s2.startsWith("Transform"))
                    s2 = cr.c0.bv("loading") + " " + s2;
                g.drawString(s2, 10, 237);
            }
            long l2 = System.currentTimeMillis() - h;
            if(cr.showTimeLeftLoading && h > 0L && l2 > 2000L && ch)
            {
                double d1 = d / (double)l2;
                long l3 = Math.round((100D - d) / d1);
                int i2 = (int)(l3 / 60L / 1000L);
                int j2 = (int)((l3 - (long)(i2 * 60 * 1000)) / 1000L);
                g.drawString(cr.c0.bv("timeLeft") + i2 + " " + cr.c0.bv("minutes") + ", " + j2 + " " + cr.c0.bv("seconds"), 10, 215);
            }
        }
        g.setFont(cf);
        g.setColor(color1);
        g.drawString(s1, i1 - 1, j1 - 1);
        g.drawString(s1, i1 + 1, j1 - 1);
        g.drawString(s1, i1 + 1, j1 + 1);
        g.drawString(s1, i1 - 1, j1 + 1);
        g.setColor(color);
        g.drawString(s1, i1, j1);
        if(flag)
        {
            j1 += cd.getDescent() / 2;
            g.setColor(color1);
            g.drawRect(i1, j1, cd.stringWidth(s1), 2);
            g.setColor(color);
            g.drawLine(i1 + 1, j1 + 1, (i1 + cd.stringWidth(s1)) - 1, j1 + 1);
        }
        b6++;
    }

    private final ZipInputStream bi(String s1)
    {
        ZipInputStream zipinputstream = null;
        for(boolean flag = false; !flag;)
        {
            flag = true;
            try
            {
                URL url = new URL(cr.getCodeBase(), s1);
                URLConnection urlconnection = url.openConnection();
                ck = new b(urlconnection.getInputStream(), urlconnection.getContentLength());
                //if(ck.h() - 79L == 0x67458L)
                    zipinputstream = new ZipInputStream(ck);
                //else
                //    zipinputstream = null;
            }
            catch(Exception exception)
            {
                flag = bj(s1, exception.toString());
            }
        }

        return zipinputstream;
    }

    private final boolean bj(String s1, String s2)
    {
        Frame frame = new Frame("Error - Try Again?");
        frame.resize(Toolkit.getDefaultToolkit().getScreenSize());
        MessageBox l1 = new MessageBox(frame, "There was an error reading the file \"" + s1 + "\".\n" + "[" + s2 + "]\n" + "\nTry again?", 2);
        return l1.getStatus() != 1;
    }

    public final boolean mouseMove(Event event, int i1, int j1)
    {
        b7 = j1;
        ca = true;
        return true;
    }

    public final boolean mouseExit(Event event, int i1, int j1)
    {
        ca = false;
        repaint();
        return true;
    }

    public final boolean mouseEnter(Event event, int i1, int j1)
    {
        b7 = j1;
        ca = true;
        repaint();
        return true;
    }

    public final boolean mouseDown(Event event, int i1, int j1)
    {
        bh();
        return true;
    }

    public final c j(c c1, ZipInputStream zipinputstream, String s1)
    {
        for(boolean flag = false; !flag;)
        {
            flag = true;
            try
            {
                if(zipinputstream == null)
                {
                    URL url = new URL(cr.getDocumentBase(), s1);
                    BufferedInputStream bufferedinputstream = new BufferedInputStream(url.openStream());
                    c1.readFile(bufferedinputstream);
                    bufferedinputstream.close();
                } else
                {
                    ZipEntry zipentry = zipinputstream.getNextEntry();
                    if(zipentry == null)
                        throw new Exception(String.valueOf(zipinputstream) + ": No more entries");
                    String s2 = zipentry.getName();
					
                    int i1 = s1.indexOf('?');
                    if(i1 != -1 && (c1 instanceof i) && s2.substring(0, i1).equals(s1.substring(0, i1)))
                    {
                        int j1 = s2.indexOf('x', i1);
                        int k1 = s2.indexOf('.', j1);
                        if(j1 != -1 && k1 != -1)
                        {
                            s1 = s2;
                            int l1 = Integer.parseInt(s2.substring(i1, j1));
                            int i2 = Integer.parseInt(s2.substring(j1 + 1, k1));
                            ((i)c1).aj(l1, i2, false);
                        }
                    }
                    if(!s2.equals(s1))
                        throw new Exception(String.valueOf(zipentry) + ": Requested entry '" + s1 + "' does not match actual entry '" + s2 + "'");
                    if(s2.endsWith(".au"))
                        SoundHandler.readAudioFile(zipinputstream, (int)zipentry.getSize());
                    else
                        c1.readFile(zipinputstream);
                }
            }
            catch(Exception exception)
            {
                flag = bj(s1, exception.toString());
            }
        }

        return c1;
    }

    public final boolean keyDown(Event event, int i1)
    {
        bh();
        return true;
    }

    public final i bk()
    {
        return co;
    }

    private final void bl(ZipInputStream zipinputstream)
    {
        try
        {
            zipinputstream.close();
        }
        catch(Exception _ex) { }
    }

    public final void bm()
    {
        b9 = true;
    }

    public MainCanvas(Main main, k k1, j aj[], i ai[], i ai1[], i ai2[][], o o1, 
            m am[], int i1)
    {
        cj = 0;
        ci = false;
        ch = false;
        cf = new Font("sans-serif", 1, 18);
        ce = new Font("sans-serif", 0, 10);
        cd = getFontMetrics(cf);
        a4 = new Vector();
        cc = false;
        ca = false;
        b9 = false;
        b7 = 100;
        h = 0L;
        b6 = 0L;
        b5 = false;
        cr = main;
        cq = k1;
        cp = aj;
        bt = ai;
        bq = ai1;
        bs = ai2;
        cn = o1;
        cm = am;
        a1 = i1;
        bp = main.getImage(main.getDocumentBase(), "splash.jpg");
        setBackground(Color.white);
        setForeground(Color.black);
        cl = new Font("Dialog", 0, 10);
        resize(((i) (k1)).p, ((i) (k1)).o);
    }

    public static final String ct[] = {
        "sound0", "sound1", "engine_up", "engine_down", "engine_hi", "engine_lo", "engine_start", "engine_stop", "off_road", "tires", 
        "lap", "finish"
    };
    public Main cr;
    public k cq;
    public j cp[];
    public i bt[];
    public i bq[];
    public i bs[][];
    public i co;
    public o cn;
    public m cm[];
    public int a1;
    public Font cl;
    public b ck;
    public volatile int cj;
    public volatile boolean ci;
    public volatile boolean ch;
    public Image cg;
    public Image bp;
    public Font cf;
    public Font ce;
    public FontMetrics cd;
    public Vector a4;
    public boolean cc;
    public boolean ca;
    public volatile boolean b9;
    public s b8;
    public int b7;
    public long h;
    public volatile long b6;
    public boolean b5;

}
