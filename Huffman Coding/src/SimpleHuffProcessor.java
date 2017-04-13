import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class SimpleHuffProcessor implements IHuffProcessor {
    
	private TreeMap<Integer, Integer> freqs;
	private int input;
	private int output;
	private int header;
	private int[] freqCount;
    private IHuffViewer myViewer;
    
    public int compress(InputStream in, OutputStream out, boolean force) throws IOException {
        throw new IOException("compress is not implemented");
        //return 0;
    }

    public int preprocessCompress(InputStream in, int headerFormat) throws IOException {
        BitInputStream bInput = new BitInputStream(in);
        input = 0;
        output = 0;
        header = headerFormat;
        freqs = new TreeMap<Integer, Integer>();
        freqCount = new int[IHuffConstants.ALPH_SIZE];
        while(())
    }

    public void setViewer(IHuffViewer viewer) {
        myViewer = viewer;
    }

    public int uncompress(InputStream in, OutputStream out) throws IOException {
        throw new IOException("uncompress not implemented");
        //return 0;
    }
    
    private void showString(String s){
        if(myViewer != null)
            myViewer.update(s);
    }
}
