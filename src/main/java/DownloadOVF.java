import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.ReadableByteChannel;

public class DownloadOVF {

    public static void main(String args[]) throws Exception {
//        URL ovaURL = new URL("http://centos.excellmedia.net/8.4.2105/isos/x86_64/CentOS-8.4.2105-x86_64-boot.iso");
//        System.out.println(System.currentTimeMillis());
//        FileUtils.copyURLToFile(ovaURL,new File("C:\\StorageCentral\\"+ FilenameUtils.getName(ovaURL.getPath())));
//        System.out.println(System.currentTimeMillis());
         Thread thread = new Thread(){
             public void run(){
                 try {
                     new DownloadOVF().downloadOva();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
        };
         Thread secThread = new Thread(){
             public void run(){
                 try {
                     new DownloadOVF().downloadOva();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
        };
         thread.start();
        secThread.start();



    }

    public void downloadOva() throws Exception{
        URL ovaUrl = new URL("http://centos.excellmedia.net/8.4.2105/isos/x86_64/CentOS-8.4.2105-x86_64-boot.iso");
        HttpURLConnection httpConnection = (HttpURLConnection) ovaUrl.openConnection();
        // httpConnection.setRequestMethod("HEAD");
        // long fileSize = httpConnection.getContentLengthLong();
        File outputFile = new File("C:\\StorageCentral\\" + FilenameUtils.getName(ovaUrl.getPath()));
        FileOutputStream fos;
        long existingFileSize =0;
        if (outputFile.exists()) {
            existingFileSize = outputFile.length();
            //if (existingFileSize < fileSize) {
            httpConnection.setRequestProperty(
                    "Range",
                    "bytes=" + existingFileSize + "-"
            );
            //}
            fos = new FileOutputStream(outputFile, true);
        } else {
            fos = new FileOutputStream(outputFile);
        }
        ReadableByteChannel inputChannel = Channels.newChannel(httpConnection.getInputStream());
        FileChannel outputChannel = fos.getChannel();
        System.out.println("Before lock");
        FileLock lock = outputChannel.lock();
        System.out.println("After lock");

        try {
            outputChannel.transferFrom(inputChannel, existingFileSize, Long.MAX_VALUE);
        } catch (Exception e) {
            throw e;
        } finally {
            httpConnection.disconnect();
            outputChannel.close();
            inputChannel.close();
            if (fos != null) {
                fos.flush();
                fos.close();
            }
        }
    }
}
