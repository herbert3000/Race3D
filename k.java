import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.DirectColorModel;

public final class k extends i
{

    public final void aj(int j, int l, boolean flag)
    {
        super.aj(j, l, flag);
        if(super.aa instanceof byte[])
            imageProducer = new ImageProducer2(super.p, super.o, super.n, aj.af(), super.aa);
        else
            imageProducer = new ImageProducer2(super.p, super.o, super.n, aj.af(), super.aa);
        image = Toolkit.getDefaultToolkit().createImage(imageProducer);
    }

    public final h ar()
    {
        return aj;
    }

    public final Image as()
    {
        return image;
    }

    public final void at()
    {
        if(imageProducer != null)
            imageProducer.t();
    }

    public final void au()
    {
        if(aj != null)
        {
            aj.ah();
            if(imageProducer != null)
                imageProducer.s(aj.af());
        }
    }

    public k(int j, int l, int i1, int j1)
    {
        super(j, l, i1, j1, false);
        imageProducer = null;
        aj = null;
        image = null;
        if(j1 < j)
            j1 = j;
        super.p = j;
        super.o = l;
        super.ab = i1;
        super.n = j1;
        if(i1 == 8)
        {
            super.aa = new byte[j1 * l];
            aj = new h();
            imageProducer = new ImageProducer2(j, l, j1, aj.af(), super.aa);
            for(int k1 = 0; k1 < 256; k1++)
                aj.ab(k1, (k1 >> 5 & 7) * 32, (k1 >> 2 & 7) * 32, (k1 & 3) * 64);

            au();
        } else
        if(i1 == 15)
        {
            super.aa = new int[j1 * l];
            DirectColorModel directcolormodel = new DirectColorModel(16, 31744, 992, 31);
            imageProducer = new ImageProducer2(j, l, j1, directcolormodel, super.aa);
        } else
        if(i1 == 16)
        {
            super.aa = new int[j1 * l];
            DirectColorModel directcolormodel1 = new DirectColorModel(16, 63488, 2016, 31);
            imageProducer = new ImageProducer2(j, l, j1, directcolormodel1, super.aa);
        } else
        if(i1 == 24)
        {
            super.aa = new int[j1 * l];
            DirectColorModel directcolormodel2 = new DirectColorModel(24, 0xff0000, 65280, 255);
            imageProducer = new ImageProducer2(j, l, j1, directcolormodel2, super.aa);
        }
        image = Toolkit.getDefaultToolkit().createImage(imageProducer);
    }

    public k(int j, int l, int i1)
    {
        this(j, l, i1, j);
    }

    public ImageProducer2 imageProducer;
    public h aj;
    public Image image;
}
