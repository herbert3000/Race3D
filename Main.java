import java.applet.Applet;
import java.awt.*;
import java.io.PrintStream;
import java.net.URL;
import java.util.Vector;

public class Main extends Applet implements Runnable
{

    public final void bn()
    {
        if(d6.q())
            return;
        long l = d6.l();
        if(dq != -1L && l - 250L > dq)
        {
            d6.m(l - 250L - dq);
            l = d6.l();
        }
        d4.cl(l - dp);
        dq = l;
    }

    public final void update(Graphics g)
    {
        if(dk || !eb)
            if(bgImage == null)
            {
                g.setColor(getBackground());
                g.fillRect(0, 0, width, height);
                eb = true;
            } else
            {
                int imgWidth = bgImage.getWidth(this);
                int imgHeight = bgImage.getHeight(this);
                if(imgWidth <= 0 || imgHeight <= 0)
                {
                    eb = false;
                } else
                {
                    for(int x = 0; x < width; x += imgWidth)
                    {
                        for(int y = 0; y < height; y += imgHeight)
                            eb = g.drawImage(bgImage, x, y, this);

                    }

                }
            }
        if(cq != null)
        {
            Image image = cq.as();
            if(image != null)
            {
                if(dk)
                {
                    dx = (width >> 1) - (((i) (cq)).p >> 1);
                    dw = (height >> 1) - (((i) (cq)).o >> 1);
                    dk = false;
                }
                g.drawImage(image, dx, dw, this);
            }
        }
        _flddo = true;
    }

    public final void stop()
    {
        SoundHandler.closeStreams();
        if(d8 != null)
        {
            d8.dispose();
            d8 = null;
        }
        if(ef != null)
            d9.bm();
        if(!di && d9 != null)
            remove(d9);
        c4 = true;
        Thread.yield();
        if(ee != null && ee.isAlive())
            ee.stop();
        ee = null;
        d7 = null;
        di = false;
        SoundHandler.closeStreams();
    }

    public final void bh()
    {
        di = true;
        d0 = new z(d3, c0.bv("menuChooseTrack"), true);
        for(int l = 0; l < numTracks; l++)
            d0.bz("\"" + cm[l].str0 + "\"\n(" + cm[l].str1 + ")");

        d0.bz(c0.bv("menuBack"));
        dz = new z(d0, c0.bv("menuChooseCar"), true);
        Vector vector = c0.bu("carNames");
        for(int i1 = 0; i1 < vector.size(); i1++)
            dz.bz((String)vector.elementAt(i1));

        dz.bz(c0.bv("menuBack"));
        a6 = cn.a1();
        a5 = cn.a2();
        d7 = new r(cq, bq, a6, a5, bt, bs);
        d6 = new d();
        d4 = new ad(a5[0][0], 5);
        co = d9.bk();
        dy = (byte)cq.ar().ag(32, 32, 32);
        bp(-1, -1, true);
        ee = new Thread(null, this, "Race3d");
        System.gc();
        requestFocus();
        df = false;
        dh = false;
        d_ = d3;
        eb = false;
        repaint();
        if(!de)
            ee.start();
    }

    public final void start()
    {
        di = false;
        d8 = new ConsoleWindow(this, c0.bv("console"));
        cn = new o(a1);
        cq = new k(320, 240, 8);
        d9 = new MainCanvas(this, cq, cp, bt, bq, bs, cn, cm, a1);
        setLayout(new FlowLayout(0, (width - ((i) (cq)).p) / 2, (height - ((i) (cq)).o) / 2));
        add(d9);
        d9.requestFocus();
        ef = new Thread(d9);
        ef.start();
    }

    public final synchronized void run()
    {
        long l = 0L;
        _flddo = false;
        boolean flag = false;
        int i1 = 0;
        resetFps();
        d6.n();
        for(c4 = false; !c4;)
        {
            if(flag)
            {
                bp(-1, -1, true);
                flag = false;
            }
            ac ac1 = d4.cs();
            if(dl && ea != null)
            {
                ea.an(cq, 0, 0);
            } else
            {
                l = d6.l() - dp;
                if(d7 != null)
                    d7.bf(l);
                else
                    c4 = true;
                if(l < 7000L)
                {
                    if(l < 4000L)
                        ac1.et = a.f((double)((4000L - l) * 100L) / 4000D);
                    else
                        ac1.et = 0;
                    d7.bc();
                    if(l < 5000L)
                    {
                        eh.z();
                        eh.aa(5L - l / 1000L);
                        cp[1].aq(cq, ((i) (cq)).p / 2, ((i) (cq)).o / 2 - cp[1].ac / 2, eh, 1, cp[1].ad * 2, cp[1].ac * 2);
                    } else
                    {
                        cp[1].aq(cq, ((i) (cq)).p / 2, ((i) (cq)).o / 2 - cp[1].ac / 2, c0.bv("go"), 1, cp[1].ad * 2, cp[1].ac * 2);
                        d4.cn(1);
                    }
                }
                if(ac1.e9 != 0L && l - ac1.e9 < 2500L)
                    cp[1].aq(cq, ((i) (cq)).p / 2, ((i) (cq)).o / 2 - 40, c0.bv("messageLastLap"), 1);
                if(ac1.fa == 0L)
                {
                    cp[0].aq(cq, 1, 1, c0.bv("time"));
                    if(l >= 5000L)
                    {
                        eh.z();
                        cp[1].aq(cq, 2, 9, bs(l - 5000L));
                    } else
                    {
                        cp[1].aq(cq, 2, 9, "00:00:00");
                    }
                    cp[0].aq(cq, ((i) (cq)).p - 1, 1, c0.bv("lap"), 2);
                    eh.z().aa(ac1.ff).aa('/').aa(ds);
                    cp[1].aq(cq, ((i) (cq)).p, 9, eh, 2);
                    if(ac1.fe)
                        cp[1].aq(cq, ((i) (cq)).p / 2, ((i) (cq)).o / 2, c0.bv("messageWrongWay"), 1);
                    if(ac1.fc)
                        cp[0].aq(cq, ((i) (cq)).p - 1, 28, c0.bv("messageDisqualified"), 2);
                } else
                {
                    Vector vector = d4.cp();
                    if(!c6 && !dj)
                    {
                        c6 = true;
                        if(recordHighscore)
                            (new Thread(new HighScoreWriter(getAppletContext(), getCodeBase().toString(), cgi, target, username, d5.str0, (String)c0.bu("carNames").elementAt(d4.cr()), d4.cs().fa - 5000L))).start();
                    }
                    for(int k2 = 0; k2 < vector.size(); k2++)
                    {
                        Vector vector2 = c0.bu("places");
                        ac ac3 = (ac)vector.elementAt(k2);
                        eh.z();
                        if(ac3 == ac1)
                            eh.aa(">>>");
                        if(k2 < vector2.size())
                            eh.aa((String)vector2.elementAt(k2)).aa(" ");
                        else
                            eh.aa(k2 + 1).aa("th ");
                        bs(ac3.fa - 5000L);
                        if(ac3 == ac1)
                        {
                            eh.aa("<<<");
                            cp[1].aq(cq, ((i) (cq)).p / 2, k2 * 20 + 1, eh, 1);
                            if(!dj)
                                dd = true;
                        } else
                        {
                            cp[1].aq(cq, ((i) (cq)).p / 2, k2 * 20 + 1, eh, 1);
                        }
                    }

                    if(vector.size() == d4.cq())
                    {
                        ac ac2 = (ac)vector.lastElement();
                        if(l - ac2.fa > 4500L)
                            if(dj)
                                flag = true;
                            else
                                cp[0].aq(cq, ((i) (cq)).p / 2, ((i) (cq)).o - 12, c0.bv("messageStart"), 1);
                    }
                }
                eh.z().aa(ac1.cj(eg[dr]), 1);
                cp[1].aq(cq, ((i) (cq)).p, ((i) (cq)).o - 26, eh, 2);
                cp[0].aq(cq, ((i) (cq)).p, ((i) (cq)).o - 8, (String)c0.bu("speedNames").elementAt(dr), 2);
                if(dj)
                {
                    cp[1].aq(cq, ((i) (cq)).p / 2, ((i) (cq)).o - cp[1].ac * 2, c0.bv("messageDemo"), 1);
                    if(!df && !dm)
                        cp[0].aq(cq, ((i) (cq)).p / 2, ((i) (cq)).o - cp[1].ac, c0.bv("messageStart"), 1);
                }
                if(dm)
                {
                    long l3 = System.currentTimeMillis();
                    if(c9 == -1L)
                    {
                        c7 = 0;
                        c9 = l3;
                        db = ((float)c8 * 1000F) / (float)(l3 - millis);
                        dc = 0.0F;
                    } else
                    if(l3 - c9 >= 500L)
                    {
                        db = ((float)c8 * 1000F) / (float)(l3 - millis);
                        dc = ((float)c7 * 1000F) / (float)(l3 - c9);
                        c9 = l3;
                        c7 = 0;
                    }
                    if(dc > da)
                        da = dc;
                    cp[0].aq(cq, 1, ((i) (cq)).o - 24, eh.z().aa("FPS = ").aa(dc));
                    cp[0].aq(cq, 1, ((i) (cq)).o - 16, eh.z().aa("Avg FPS = ").aa(db));
                    cp[0].aq(cq, 1, ((i) (cq)).o - 8, eh.z().aa("Max FPS = ").aa(da));
                }
                if(ac1.fb)
                {
                    int l5;
                    cp[0].aq(cq, 1, 24, eh.z().aa("Z    = ").aa((double)(l5 = ((y) (ac1)).et) / 65536D));
                    cp[0].aq(cq, 1, 32, eh.z().aa("Tilt = ").aa(d7.bz));
                }
                if(df)
                {
                    byte abyte0[] = (byte[])((i) (cq)).aa;
                    int k3 = 0;
                    int i4 = ((i) (cq)).n;
                    for(int j4 = 0; j4 < ((i) (cq)).o; j4 += 2)
                    {
                        for(int k4 = 0; k4 < ((i) (cq)).p; k4 += 4)
                        {
                            abyte0[k3 + k4] = dy;
                            abyte0[k3 + k4 + 1] = dy;
                            abyte0[k3 + k4 + 2] = dy;
                            abyte0[k3 + k4 + i4] = dy;
                            abyte0[k3 + k4 + i4 + 2] = dy;
                            abyte0[k3 + k4 + i4 + 3] = dy;
                        }

                        k3 += i4 << 1;
                    }

                    int j1 = ((i) (cq)).p - 192 >> 1;
                    int k1 = ((i) (cq)).o - 144 >> 1;
                    co.an(cq, j1, k1);
                    if(dh)
                    {
                        int l1 = j1 + cp[0].ad * 2;
                        int l2 = (k1 + cp[0].ac * 2) - 2;
                        cp[0].aq(cq, l1, l2, c0.bv("help"));
                    } else
                    {
                        if(d_ == dz)
                        {
                            int l4 = d_.b8();
                            if(l4 < bs.length)
                            {
                                int ai[] = {
                                    1, 2, 3, 5, 7, 9, 11, 13, 14, 15, 
                                    16, 17, 18, 19, 21, 23, 25, 27, 29, 30
                                };
                                int i5 = (int)((System.currentTimeMillis() / 96L) % (long)ai.length);
                                i k5 = bs[d_.b8()][ai[i5] - 1];
                                k5.am(cq, (j1 + 192) - 100, (k1 + 72) - 22, 96, 40);
                            }
                        }
                        int i2 = j1 + 28;
                        int i3 = k1 + 28;
                        String s = d_.b6();
                        if(s.indexOf('\n') >= 0)
                            cp[0].aq(cq, i2, i3 - 22, s);
                        else
                            cp[1].aq(cq, i2, i3 - 22, s);
                        char c = '\177';
                        if(aa.e3)
                            c = '=';
                        for(int j5 = 0; j5 < d_.b5(); j5++)
                        {
                            if(j5 == d_.b8() - d_.b9())
                                cp[1].aq(cq, i2 - 16, i3 - 1, eh.z().aa(c));
                            String s1 = d_.cb(j5);
                            if(s1.indexOf('\n') >= 0)
                                cp[0].aq(cq, i2, i3 + 2, s1);
                            else
                                cp[1].aq(cq, i2, i3, s1);
                            i3 += cp[1].ac;
                        }

                    }
                }
            }
            cq.at();
            _flddo = false;
            repaint();
            int j2 = 0;
            do
            {
                Thread.yield();
                if(++j2 == 5)
                {
                    try
                    {
                        Thread.sleep(10L);
                    }
                    catch(InterruptedException _ex) { }
                    j2 = 0;
                }
            } while(dn && !_flddo);
            c8++;
            c7++;
            if(dj && !df && (aa.e4[2] || aa.e4[3] || aa.e4[0] || aa.e4[1]))
            {
                aa.e4[6] = false;
                aa.e4[2] = false;
                aa.e4[3] = false;
                aa.e4[0] = false;
                aa.e4[1] = false;
                aa.e4[12] = false;
                df = true;
                d_ = d3;
            }
            if(df)
            {
                if(aa.e3 && aa.e1 < 128 && aa.e1 > 32)
                {
                    int j3 = d_.b8();
                    aa.e3 = false;
                    aa.e2[j3] = (char)aa.e1;
                    d1.b2(j3, aa.e2[j3] + " " + c0.bu("keyNames").elementAt(j3));
                }
                if(aa.e4[2])
                {
                    aa.e4[2] = false;
                    if(!dh && !aa.e3)
                    {
                        d_.b3();
                        SoundHandler.playSound(0);
                    }
                }
                if(aa.e4[3])
                {
                    aa.e4[3] = false;
                    if(!dh && !aa.e3)
                    {
                        d_.b4();
                        SoundHandler.playSound(0);
                    }
                }
                if(aa.e4[12])
                {
                    aa.e4[12] = false;
                    if(d_.b7() == c0.bv("menuBack"))
                    {
                        if(aa.e3)
                            aa.e3 = false;
                        else
                        if(dh)
                        {
                            SoundHandler.playSound(1);
                            dh = false;
                        } else
                        {
                            SoundHandler.playSound(1);
                            d_ = d_.ca();
                            if(d_ == null)
                                df = false;
                        }
                    } else
                    if(d_.b7() == c0.bv("menuPlay"))
                        d_ = d0;
                    else
                    if(d_.b7() == c0.bv("menuDemo"))
                    {
                        df = false;
                        bp(-1, -1, true);
                    } else
                    if(d_.b7() == c0.bv("menuHelp"))
                        dh = dh ^ true;
                    else
                    if(d_.b7() == c0.bv("menuKeyboard"))
                        d_ = d1;
                    else
                    if(d_.b7() == c0.bv("menuOptions"))
                        d_ = d2;
                    else
                    if(d_.b7() == c0.bv("menuConsole"))
                        d8.show();
                    else
                    if(d_.b7().startsWith(c0.bv("menuSpeed")))
                    {
                        Vector vector1 = c0.bu("speedNames");
                        dr = (dr + 1) % vector1.size();
                        d_.b2(d_.b8(), c0.bv("menuSpeed") + ": " + vector1.elementAt(dr));
                    } else
                    if(d_.b7().startsWith(c0.bv("menuSound")))
                    {
                        boolean flag1 = SoundHandler.soundEnabled ^ true;
                        SoundHandler.setSoundEnabled(flag1);
                        d_.b2(d_.b8(), c0.bv("menuSound") + ": " + (flag1 ? stringOn : stringOff));
                    } else
                    if(d_ == d0)
                    {
                        i1 = d_.b8();
                        d_ = dz;
                    } else
                    if(d_ == dz)
                    {
                        df = false;
                        bp(i1, d_.b8(), false);
                    } else
                    if(d_ == d1)
                    {
                        aa.e1 = 128;
                        aa.e3 = true;
                    }
                    SoundHandler.playSound(1);
                }
            } else
            if(aa.e4[12] && !dj)
            {
                if(l < 4000L)
                    dp -= 4000L - l;
                if(!dd)
                    aa.e4[12] = false;
            }
            if(aa.e4[6] || aa.e4[12] && (dj || dd))
            {
                aa.e4[6] = false;
                aa.e4[2] = false;
                aa.e4[3] = false;
                aa.e4[0] = false;
                aa.e4[1] = false;
                aa.e4[12] = false;
                if(df)
                {
                    if(aa.e3)
                        aa.e3 = false;
                    else
                    if(dh)
                    {
                        SoundHandler.playSound(1);
                        dh = false;
                    } else
                    {
                        SoundHandler.playSound(1);
                        d_ = d_.ca();
                        if(d_ == null)
                            df = false;
                    }
                } else
                {
                    SoundHandler.playSound(1);
                    df = true;
                    d_ = d3;
                }
                d6.o(df & (dj ^ true));
                SoundHandler.a8(df & (dj ^ true));
            }
            if(aa.e4[11])
            {
                aa.e4[11] = false;
                d8.show();
                SoundHandler.playSound(1);
            }
            if(aa.e4[9])
            {
                aa.e4[9] = false;
                if(((i) (cq)).p < width)
                {
                    cq.aj(((i) (cq)).p + 64, ((i) (cq)).o + 48, false);
                    d7.be(cq);
                    System.gc();
                    dk = true;
                }
                SoundHandler.playSound(1);
            }
            if(aa.e4[10])
            {
                aa.e4[10] = false;
                if(((i) (cq)).p > 192)
                {
                    cq.aj(((i) (cq)).p - 64, ((i) (cq)).o - 48, false);
                    d7.be(cq);
                    System.gc();
                    dk = true;
                }
                SoundHandler.playSound(1);
            }
            if(aa.e4[7])
            {
                aa.e4[7] = false;
                if(ea == null)
                    ea = new i(((i) (cq)).p, ((i) (cq)).o, 8);
                cq.ao(ea, 0, 0);
            }
            if(aa.e4[8])
            {
                aa.e4[8] = false;
                if(ea != null)
                {
                    dl = dl ^ true;
                    d6.o(dl);
                    SoundHandler.a8(dl);
                }
            }
            if(ac1.fb)
            {
                if(aa.e4[4])
                    ac1.et += 0x10000;
                if(aa.e4[5])
                    ac1.et -= 0x10000;
                if(aa.e4[13])
                {
                    d7.bz += 0.01D;
                    d7.bc();
                    aa.e4[13] = false;
                    aa.e4[14] = false;
                }
                if(aa.e4[14])
                {
                    d7.bz -= 0.01D;
                    d7.bc();
                    aa.e4[13] = false;
                    aa.e4[14] = false;
                }
            }
            bn();
        }

        c4 = false;
        SoundHandler.closeStreams();
        SoundHandler.init();
    }

    public final void resetFps()
    {
        dc = 0.0F;
        db = 0.0F;
        da = 0.0F;
        millis = System.currentTimeMillis();
        c8 = 0;
        c7 = 0;
        c9 = -1L;
    }

    public final void paint(Graphics g)
    {
        eb = false;
        update(g);
    }

    public final void bp(int l, int i1, boolean flag)
    {
        dj = flag;
        if(l < 0)
            l = a.c(numTracks);
        d5 = cm[l];
        SoundHandler.closeStreams();
        d4.bp(d5, i1, flag);
        if(!de)
            SoundHandler.playSound(d4.cs(), true);
        d7.bd(d5, d4);
        dk = true;
        d6.o(false);
        dp = d6.l();
        dq = -1L;
        dd = false;
        c6 = false;
        for(int j1 = 0; j1 < 15; j1++)
            aa.e4[j1] = false;

    }

    public final boolean mouseDown(Event event, int l, int i1)
    {
        requestFocus();
        return true;
    }

    public final boolean keyUp(Event event, int l)
    {
        return aa.cc(l);
    }

    public final boolean keyDown(Event event, int l)
    {
        return aa.cd(l);
    }

    private void config() {
    	resize(Math.max(getWidth(), 320), Math.max(getHeight(), 240)); // resize to correct dimensions
    	numTracks = 8;
    }

    public final void init()
    {
    	config();
    	
        c0 = new v();
        System.out.println(getAppletInfo());
        SoundHandler.closeStreams();
        SoundHandler.init();
        bq();
        stringOn = c0.bv("on");
        stringOff = c0.bv("off");
        setBackground(bgColor);
        width = getSize().width;
        height = getSize().height;
        cp = new j[2];
        cp[0] = new j(' ', '_', 8, 8, 8);
        cp[1] = new j(' ', '\202', 12, 20, 8);
        bq = new i[2];
        bs = new i[5][30];
        bt = new i[10];
        cm = new m[numTracks];
        d3 = new z(c0.bv("gameName"));
        d3.bz(c0.bv("menuPlay"));
        d3.bz(c0.bv("menuDemo"));
        d3.bz(c0.bv("menuOptions"));
        d3.bz(c0.bv("menuHelp"));
        d3.bz(c0.bv("menuBack"));
        d2 = new z(d3, c0.bv("menuOptions"));
        d2.bz(c0.bv("menuSpeed") + ": " + c0.bu("speedNames").elementAt(dr));
        d2.bz(c0.bv("menuSound") + ": " + (SoundHandler.soundEnabled ? stringOn : stringOff));
        d2.bz(c0.bv("menuKeyboard"));
        d2.bz(c0.bv("menuConsole"));
        d2.bz(c0.bv("menuBack"));
        d1 = new z(d2, c0.bv("menuKeyboard"));
        Vector vector = c0.bu("keyNames");
        for(int l = 0; l < vector.size(); l++)
            d1.bz(aa.e2[l] + " " + vector.elementAt(l));

        d1.bz(c0.bv("menuBack"));
    }

    private final void bq()
    {
        String s = getParameter("bgcolor");
        if(s != null)
        {
            if(s.charAt(0) == '#')
                s = s.substring(1);
            try
            {
                bgColor = new Color(Integer.parseInt(s, 16));
            }
            catch(NumberFormatException _ex)
            {
                System.out.println("NumberFormatException: bgcolor");
            }
        }
        s = getParameter("bgimage");
        if(s != null)
            bgImage = getImage(getDocumentBase(), s);
        s = getParameter("numTracks");
        if(s != null)
            try
            {
                numTracks = Integer.parseInt(s);
            }
            catch(NumberFormatException _ex)
            {
                System.out.println("NumberFormatException: numTracks");
            }
        s = getParameter("playPong");
        if(s != null && !s.equals("1") && !s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("true"))
            playPong = false;
        s = getParameter("debug");
        if(s != null && (s.equals("1") || s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("true")))
        {
            boolean _tmp = true;
        }
        s = getParameter("showTimeLeftLoading");
        if(s != null && !s.equals("1") && !s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("true"))
            showTimeLeftLoading = false;
        s = getParameter("showLoadingInfo");
        if(s != null && !s.equals("1") && !s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("true"))
            showLoadingInfo = false;
        s = getParameter("recordHighscore");
        if(s != null && !s.equals("1") && !s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("true"))
            recordHighscore = false;
        s = getParameter("username");
        if(s != null)
            username = s;
        s = getParameter("zipFileName");
        if(s != null)
            zipFileName = s;
        s = getParameter("language");
        if(s != null)
            c0.bt(getCodeBase(), s);
        else
            c0.bt(getCodeBase(), "en-us.txt");
        s = getParameter("cgi");
        if(s != null)
            cgi = s;
        s = getParameter("target");
        if(s != null)
            target = s;
        s = getParameter("playSound");
        if(s != null && !s.equals("1") && !s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("true"))
            SoundHandler.setSoundEnabled(false);
    }

    public final String[][] getParameterInfo()
    {
        return params;
    }

    public final String getAppletInfo()
    {
        return "============================================\nrace3D 1.0.3 (May 4, 1999)\n  written by David Brackeen\n  (david@brackeen.com)\n\nSplash screen, billboard images, and vehicle\n  graphics by CMO and Plasma Artworx\n\nSpecial Thanks to:\n  Thorsten Mitschele, Ian Parberry,\n  Janice Headley, and my family.\n============================================\n";
    }

    public final boolean br(String s)
    {
        if(s.equalsIgnoreCase("free"))
        {
            boolean flag = d4.cs().fb;
            d4.cs().fb = flag ^ true;
            d8.drawText("Free movement now " + (flag ? stringOff : stringOn));
        } else
        if(s.equalsIgnoreCase("fps"))
        {
            dm = dm ^ true;
            d8.drawText("FPS display now " + (dm ? stringOn : stringOff));
            c9 = -1L;
        } else
        if(s.equalsIgnoreCase("resetfps"))
        {
            resetFps();
            d8.drawText("FPS reset");
        } else
        if(s.equalsIgnoreCase("commands"))
        {
            d8.drawText("fps - show/hide FPS display");
            d8.drawText("resetfps - reset FPS display");
        } else
        if(s.equalsIgnoreCase("end"))
        {
            ac ac1 = d4.cs();
            if(ac1.fp != 2)
            {
                ac1.fp = 2;
                ac1.fa = 0x493e0L + (long)(Math.random() * 300000D);
                d4.cp().addElement(ac1);
            }
        } else
        {
            return false;
        }
        return true;
    }

    private final f bs(long l)
    {
        long l1 = l / 60000L;
        long l2 = l / 1000L - l1 * 60L;
        long l3 = l / 10L - l1 * 6000L - l2 * 100L;
        eh.aa(l1, 2, '0').aa(':');
        eh.aa(l2, 2, '0').aa(':').aa(l3, 2, '0');
        return eh;
    }

    public Main()
    {
        ee = null;
        bgColor = Color.black;
        bgImage = null;
        eb = false;
        a6 = null;
        a5 = null;
        bt = null;
        bq = null;
        cp = null;
        cm = null;
        d5 = null;
        dy = 0;
        a1 = 4;
        numTracks = 1;
        dr = 0;
        dq = -1L;
        _flddo = false;
        dn = true;
        dm = false;
        dl = false;
        dk = true;
        dj = false;
        di = false;
        dh = false;
        de = false;
        Main _tmp = this;
        boolean _tmp1 = false;
        dd = false;
        c6 = false;
        recordHighscore = true;
        c4 = false;
        username = "guest";
        cgi = "writestat.cgi";
        target = "_blank";
        playPong = true;
        zipFileName = "pak.zip";
        showTimeLeftLoading = true;
        showLoadingInfo = true;
    }

    public static f eh = new f();
    public static final double eg[] = {
        3.6, 2.2369, 1.0
    };
    public Thread ef;
    public Thread ee;
    public Color bgColor;
    public Image bgImage;
    public boolean eb;
    public k cq;
    public i ea;
    public g a6[];
    public g a5[][][];
    public i bt[];
    public i bq[];
    public i bs[][];
    public j cp[];
    public i co;
    public o cn;
    public MainCanvas d9;
    public ConsoleWindow d8;
    public r d7;
    public d d6;
    public m cm[];
    public m d5;
    public ad d4;
    public z d3;
    public z d2;
    public z d1;
    public z d0;
    public z d_;
    public z dz;
    public byte dy;
    public int a1;
    public int dx;
    public int dw;
    public int width;
    public int height;
    public int numTracks;
    public static int ds = 3;
    public int dr;
    public long dq;
    public long dp;
    public volatile boolean _flddo;
    public boolean dn;
    public boolean dm;
    public boolean dl;
    public boolean dk;
    public boolean dj;
    public boolean di;
    public boolean dh;
    public static boolean df = true;
    public boolean de;
    public boolean dd;
    public float dc;
    public float db;
    public float da;
    public long millis;
    public long c9;
    public int c8;
    public int c7;
    public boolean c6;
    public boolean recordHighscore;
    public volatile boolean c4;
    public String username;
    public String cgi;
    public String target;
    public v c0;
    public String stringOn;
    public String stringOff;
    public boolean playPong;
    public String zipFileName;
    public boolean showTimeLeftLoading;
    public boolean showLoadingInfo;
    public static final String params[][] = {
        {
            "showTimeLeftLoading", "boolean", "Show the time remaining while loading the game. default is true."
        }, {
            "playPong", "boolean", "Play pong while loading the game. default is true"
        }, {
            "zipFileName", "String", "Name of the zip file. default is \"pak.zip\""
        }, {
            "language", "String", "The filename of the language.  Default is 'en-us.txt'"
        }, {
            "numTracks", "integer", "Number of tracks.  Default is 1"
        }, {
            "bgcolor", "hex-string", "Background color of applet.  Default is \"#000000\" (black)"
        }, {
            "bgimage", "string", "Background image of applet.  Default is none."
        }, {
            "debug", "boolean", "Debug. Default is \"false\"."
        }, {
            "playSound", "boolean", "Play sound. Default is \"true\"."
        }, {
            "recordHighScore", "boolean", "Record the highscore on the server. Default is \"true\""
        }, {
            "username", "string", "Username of player. Default is \"guest\"."
        }, {
            "cgi", "string", "CGI-file. Default is \"writestat.cgi\""
        }, {
            "target", "string", "Target frame to open the CGI-file. Default is \"_blank\"."
        }
    };

    static 
    {
        boolean _tmp = false;
    }
}
