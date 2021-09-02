import java.io.*;
import java.util.Vector;
import sun.audio.AudioDevice;
import sun.audio.AudioPlayer;

@SuppressWarnings("restriction")
public class SoundHandler
{

	public static void closeStreams()
    {
        try
        {
            AudioDevice.device.closeStreams();
        }
        catch(Exception ex) { }
    }

	public static void stopSound(AudioStream audioStream)
    {
        try
        {
            AudioPlayer.player.stop(audioStream);
        }
        catch(Exception ex) { }
    }

    public static void setSoundEnabled(boolean flag)
    {
        soundEnabled = flag;
        if(!soundEnabled)
            closeStreams();
    }

    public static void init()
    {
        vector = new Vector<byte[]>();
        audioStreams = new Vector<AudioStream>();
    }

	public static AudioStream playSound(ac ac, boolean flag)
    {
        AudioStream audioStream = null;
        if(soundEnabled)
        {
            audioStream = new AudioStream(ac, vector, flag);
            try
            {
                AudioPlayer.player.start(audioStream);
                if(flag)
                    audioStreams.addElement(audioStream);
            }
            catch(Exception exception)
            {
                System.out.println(String.valueOf(String.valueOf(exception)));
                System.out.println("Error playing audio.");
                System.out.println("Sound is now off.");
                setSoundEnabled(false);
            }
        }
        return audioStream;
    }

	public static AudioStream playSound(int i, boolean flag)
    {
        AudioStream q1 = null;
        if(soundEnabled)
        {
            byte abyte0[] = (byte[])vector.elementAt(i);
            q1 = new AudioStream(abyte0, flag);
            try
            {
                AudioPlayer.player.start(q1);
                if(flag)
                    audioStreams.addElement(q1);
            }
            catch(Exception exception)
            {
                System.out.println(String.valueOf(String.valueOf(exception)));
                System.out.println("Error playing audio.");
                System.out.println("Sound is now off.");
                setSoundEnabled(false);
            }
        }
        return q1;
    }

    public static AudioStream playSound(int i)
    {
        return playSound(i, false);
    }

    public static void a8(boolean flag)
    {
        for(int i = 0; i < audioStreams.size(); i++)
            ((AudioStream)audioStreams.elementAt(i)).o(flag);

    }

    public static void readAudioFile(InputStream inputstream, int i)
    {
        byte abyte0[] = new byte[i - 28];
        try
        {
            inputstream.skip(28L);
            b.g(inputstream, abyte0);
        }
        catch(IOException _ex) { }
        vector.addElement(abyte0);
    }

    public static Vector<byte[]> vector;
    public static boolean soundEnabled = true;
    public static Vector<AudioStream> audioStreams;

    static 
    {
        init();
    }
}
