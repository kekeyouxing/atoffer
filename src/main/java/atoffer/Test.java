package atoffer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Test{

	class TestStream extends InputStream{
		InputStream is;
		private int pos;
		private int count;
		byte[] buf; 
		public TestStream(InputStream input, int maxSize) {
			this.is = input;
			buf = new byte[maxSize];
		}
		@Override
		public int read() throws IOException {
			
	        if (pos >= count) {
	            fill();
	            if (pos >= count)
	                return -1;
	        }
	        return buf[pos++] & 0xff;
			
		}
		
	    protected void fill()
	            throws IOException {
	            pos = 0;
	            count = 0;
	            int nRead = is.read(buf, 0, buf.length);
	            System.out.println(is);
	            if (nRead > 0) {
	                count = nRead;
	            }
	        }
		
	}
	public static void main(String[] args) throws IOException {
		Test test = new Test();
		
		String str = "abcdefghi";
		InputStream s = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
		InputStream s1 = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
		TestStream input = test.new TestStream(s,2048);
		TestStream input2 = test.new TestStream(s,2048);
		input.read();
		input2.read();
		
	}
}
