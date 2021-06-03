/**
 * @ClassName ys
 * @Description TODO
 * @Author yins
 * @Date 2021-06-03
 * @Version 1.0
 **/
package founder.utils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {
    public static void zip(String zipFileName,String sourceFileName) throws Exception
    {
        FileOutputStream fos = null;
        ZipOutputStream zout = null;
        try {
            File file = new File(sourceFileName);
            File[] files = file.listFiles();
            for(File f1 : files){
                fos = new FileOutputStream(new File(zipFileName));
                // 压缩流
                zout = new ZipOutputStream(fos);

                zipFile(f1,zout);

                zout.closeEntry();
                zout.close();
                fos.close();
                System.out.println("success");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void zipFile(File inputFile, ZipOutputStream outputstream)
            throws IOException {
        try {
            if (inputFile.exists()) {
                if (inputFile.isFile()) {
                    FileInputStream inStream = new FileInputStream(inputFile);
                    BufferedInputStream bInStream = new BufferedInputStream(
                            inStream);

                    String outFileName = inputFile.getName();
                    ZipEntry entry = new ZipEntry(outFileName);
                    entry.setTime(System.currentTimeMillis());
                    outputstream.putNextEntry(entry);

                    final int MAX_BYTE = 10 * 1024 * 1024; // 最大的流为10M
                    long streamTotal = 0; // 接受流的容量
                    int streamNum = 0; // 流需要分开的数量
                    int leaveByte = 0; // 文件剩下的字符数
                    byte[] inOutbyte; // byte数组接受文件的数据

                    streamTotal = bInStream.available(); // 通过available方法取得流的最大字符数
                    streamNum = (int) Math.floor(streamTotal / MAX_BYTE); // 取得流文件需要分开的数量
                    leaveByte = (int) streamTotal % MAX_BYTE; // 分开文件之后,剩余的数量

                    if (streamNum > 0) {
                        for (int j = 0; j < streamNum; ++j) {
                            inOutbyte = new byte[MAX_BYTE];
                            // 读入流,保存在byte数组
                            bInStream.read(inOutbyte, 0, MAX_BYTE);
                            outputstream.write(inOutbyte, 0, MAX_BYTE); // 写出流
                        }
                    }
                    // 写出剩下的流数据
                    inOutbyte = new byte[leaveByte];
                    bInStream.read(inOutbyte, 0, leaveByte);
                    outputstream.write(inOutbyte);
                    outputstream.closeEntry(); // Closes the current ZIP entry
                    // and positions the stream for
                    // writing the next entry
                    bInStream.close(); // 关闭
                    inStream.close();
                }
            } else {
                System.out.println("文件不存在");
            }
        } catch (IOException e) {
            throw e;
        }
    }
}
