import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.stream.IntStream;

public class TestApp {

    private static final int BUFFER_SIZE = 5 * 1024 * 1024; // 5MB

    private ByteBuffer directBuffer;

    public void useMemory() throws IOException
    {
        allocateDirectBuffer();
    }

    private void allocateDirectBuffer()
    {

        directBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE);
        directBuffer.put("Using some off-heap memory in a direct buffer".getBytes());
    }

    public static void main(String[] args) throws Exception {

        IntStream
            .range(0, 100)
            .forEach(index -> {

                try {

                    new TestApp().useMemory();
                    Thread.sleep(2000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        Thread.sleep(1000000);
    }
}