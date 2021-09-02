import java.awt.image.*;
import java.util.Vector;

public final class ImageProducer2 implements ImageProducer
{

    public final void startProduction(ImageConsumer imageconsumer)
    {
        addConsumer(imageconsumer);
    }

    private final void r(ImageConsumer imageconsumer)
    {
        if(obj instanceof byte[])
            imageconsumer.setPixels(0, 0, width, height, colorModel, (byte[])obj, 0, scansize);
        else
            imageconsumer.setPixels(0, 0, width, height, colorModel, (int[])obj, 0, scansize);
        imageconsumer.imageComplete(2);
    }

    public final synchronized void s(ColorModel colormodel)
    {
        colorModel = colormodel;
        for(int i = 0; i < vector.size(); i++)
        {
            ImageConsumer imageconsumer = (ImageConsumer)vector.elementAt(i);
            try
            {
                imageconsumer.setColorModel(colorModel);
                r(imageconsumer);
            }
            catch(Exception _ex)
            {
                imageconsumer.imageComplete(1);
            }
        }

    }

    public final void requestTopDownLeftRightResend(ImageConsumer imageconsumer)
    {
    }

    public final synchronized void removeConsumer(ImageConsumer imageconsumer)
    {
        vector.removeElement(imageconsumer);
    }

    public final synchronized void t()
    {
        for(int i = 0; i < vector.size(); i++)
            r((ImageConsumer)vector.elementAt(i));

    }

    public final synchronized boolean isConsumer(ImageConsumer imageconsumer)
    {
        return vector.contains(imageconsumer);
    }

    public final synchronized void addConsumer(ImageConsumer imageconsumer)
    {
        if(imageconsumer != null && !isConsumer(imageconsumer))
        {
            vector.addElement(imageconsumer);
            try
            {
                imageconsumer.setDimensions(width, height);
                imageconsumer.setColorModel(colorModel);
                imageconsumer.setHints(6);
                r(imageconsumer);
            }
            catch(Exception _ex)
            {
                imageconsumer.imageComplete(1);
            }
        }
    }

    public ImageProducer2(int width, int height, int scansize, ColorModel colorModel, Object obj)
    {
        this.width = width;
        this.height = height;
        this.scansize = scansize;
        this.colorModel = colorModel;
        this.obj = obj;
        this.vector = new Vector();
    }

    public int width;
    public int height;
    public int scansize;
    public ColorModel colorModel;
    public Object obj;
    public Vector vector;
}
