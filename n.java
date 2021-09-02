import java.io.DataInputStream;
import java.io.InputStream;
import java.io.IOException;

public class n implements c
{

    public final void readFile(InputStream inputstream)
    {
		try {
			DataInputStream datainputstream;
			if(inputstream instanceof DataInputStream)
				datainputstream = (DataInputStream)inputstream;
			else
				datainputstream = new DataInputStream(inputstream);
			b0 = datainputstream.readByte();
			b1 = datainputstream.readByte();
			i0 = datainputstream.readInt();
		} catch (IOException e) {}
    }

    public n(byte byte0, byte byte1)
    {
        b0 = byte0;
        b1 = byte1;
        i0 = -1;
    }

    public n()
    {
        b0 = 0;
        b1 = 0;
        i0 = -1;
    }

    public byte b0;
    public byte b1;
    public int i0;
}
