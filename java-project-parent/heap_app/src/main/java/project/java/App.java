package project.java;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class App {
    public static void main(String[] args) {
        var source = Paths.get("C:\\tmp\\abc.txt");
        var dest = Paths.get("C:\\tmp\\xyz");
        zip(source, dest);
    }

    public static void zip(Path source, Path dest) {
        long beginTime = System.currentTimeMillis();
        boolean var15 = false;

        String var5;
        long workTime;
        label76:
        {
            try {
                var15 = true;
                InputStream inputStream = Files.newInputStream(source);

                try {
                    zipStream(dest, inputStream);
                } catch (Throwable var17) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable var16) {
                            var17.addSuppressed(var16);
                        }
                    }

                    throw var17;
                }

                if (inputStream != null) {
                    inputStream.close();
                    var15 = false;
                } else {
                    var15 = false;
                }
                break label76;
            } catch (Exception var18) {
                log.error("Zip error", var18);
                var5 = "";
                var15 = false;
            } finally {
                if (var15) {
                }
            }

            workTime = System.currentTimeMillis() - beginTime;
            log.info("Файл {}, время сжатия {} ms", dest.toUri().toString(), workTime);
        }

        workTime = System.currentTimeMillis() - beginTime;
        log.info("Файл {}, время сжатия {} ms", dest.toUri().toString(), workTime);
    }

    private static void zipStream(Path dest, InputStream inputStream) throws IOException, NoSuchAlgorithmException {
        LZMACompressorOutputStream lzOut = new LZMACompressorOutputStream(new BufferedOutputStream(Files.newOutputStream(dest)));

        String var7;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] buffer = new byte[1024];

            while (true) {
                int length;
                if (-1 == (length = inputStream.read(buffer))) {
                    break;
                }

                lzOut.write(buffer, 0, length);
                messageDigest.update(buffer, 0, length);
            }
        } catch (Throwable var9) {
            try {
                lzOut.close();
            } catch (Throwable var8) {
                var9.addSuppressed(var8);
            }

            throw var9;
        }

        lzOut.close();
    }
}
