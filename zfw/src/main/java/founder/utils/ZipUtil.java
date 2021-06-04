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
    private static final int BUFFER_SIZE = 2 * 1024;

    public static void zip(String zipFileName, String sourceFileName) throws Exception {
        FileOutputStream fos = new FileOutputStream(new File(zipFileName));
        ZipOutputStream zout = null;
        try {
            File file = new File(sourceFileName);
            zout = new ZipOutputStream(fos);
            File[] listFiles = file.listFiles();
            for (File file1 : listFiles) {
                zipFile(file1, zout, file1.getName(), true);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zout != null) {
                try {
                    zout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void zipFile(File inputFile, ZipOutputStream outputstream, String name, boolean KeepDirStructure)
            throws IOException {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            if (inputFile.exists()) {
                if (inputFile.isFile()) {
                    // 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字
                    outputstream.putNextEntry(new ZipEntry(name));
                    // copy文件到zip输出流中
                    int len;
                    FileInputStream in = new FileInputStream(inputFile);
                    while ((len = in.read(buf)) != -1) {
                        outputstream.write(buf, 0, len);
                    }
                    // Complete the entry
                    outputstream.closeEntry();
                    in.close();
                } else {
                    File[] listFiles = inputFile.listFiles();
                    if (listFiles == null || listFiles.length == 0) {
                        // 需要保留原来的文件结构时,需要对空文件夹进行处理
                        if (KeepDirStructure) {
                            // 空文件夹的处理
                            outputstream.putNextEntry(new ZipEntry(name + "/"));
                            // 没有文件，不需要文件的copy
                            outputstream.closeEntry();
                        }
                    } else {
                        for (File file : listFiles) {
                            // 判断是否需要保留原来的文件结构
                            if (KeepDirStructure) {
                                // 注意：file.getName()前面需要带上父文件夹的名字加一斜杠,
                                // 不然最后压缩包中就不能保留原来的文件结构,即：所有文件都跑到压缩包根目录下了
                                zipFile(file, outputstream, name + "/" + file.getName(), KeepDirStructure);
                            } else {
                                zipFile(file, outputstream, file.getName(), KeepDirStructure);
                            }
                        }
                    }
                }
            } else {
                System.out.println("文件不存在");
            }
        } catch (IOException e) {
            throw e;
        }
    }
}
