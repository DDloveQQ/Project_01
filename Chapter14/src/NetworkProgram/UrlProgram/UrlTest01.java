package NetworkProgram.UrlProgram;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlTest01 {
    @Test
    public void test1() throws IOException{
        URL url = new URL("http://172.20.10.7:8080/examples");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//        urlConnection.setRequestProperty("User-Agent", "Mozilla/4.76");
        InputStream is = urlConnection.getInputStream();
        File file = new File("123.jpg");

        FileOutputStream fos = new FileOutputStream(file);

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        is.close();
        urlConnection.disconnect();
    }
}
