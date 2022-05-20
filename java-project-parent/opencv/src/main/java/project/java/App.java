package project.java;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.opencv.videoio.Videoio.CAP_PROP_FPS;
import static org.opencv.videoio.Videoio.CAP_PROP_POS_MSEC;

/**
 * Hello world!
 */
public class App {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println(Core.VERSION);
    }

    public static void main(String[] args) {


//        JFrame f=new JFrame();//creating instance of JFrame
//
//        JButton b=new JButton("click");//creating instance of JButton
//        b.setBounds(130,100,100, 40);//x axis, y axis, width, height
//
//        f.add(b);//adding button in JFrame
//
//        f.setSize(400,500);//400 width and 500 height
//        f.setLayout(null);//using no layout managers
//        f.setVisible(true);//making the frame visible


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @lombok.SneakyThrows
            public void run() {
                String folder = "D:\\work\\test";
                VideoCapture capture = new VideoCapture(folder + "\\test.mp4");
                double fps = capture.get(CAP_PROP_FPS);
                System.out.println(capture.isOpened());

                Set<Integer> msPosList = new HashSet<>();

                int index = 0;
                while (capture.grab()) {
                    int msPos = (int) Math.round(capture.get(CAP_PROP_POS_MSEC) / 1000);
                    if (msPos % 5 == 0 && !msPosList.contains(msPos)) {
                        msPosList.add(msPos);
                        Mat frame = new Mat();
                        capture.read(frame);
                        MatOfByte buff = new MatOfByte();
                        Imgcodecs.imencode(".png", frame, buff);
                        byte[] data = buff.toArray();
                        try (FileOutputStream fileOutputStream = new FileOutputStream(folder + "\\" + (++index) + ".png")) {
                            fileOutputStream.write(data);
                            fileOutputStream.close();
                        }
                        System.out.println(msPos);
                    }
                }
            }
        });

        //capture.release();
       // System.out.println("Hello World!");
    }
}
