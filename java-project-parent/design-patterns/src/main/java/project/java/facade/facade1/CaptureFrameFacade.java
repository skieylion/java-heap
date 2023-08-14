package project.java.facade.facade1;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class CaptureFrameFacade {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void createImages(int timeStep, String pathFrom, String pathTo, String ext) {
        VideoCapture videoCapture = new VideoCapture(pathFrom);
        double frameRate = videoCapture.get(Videoio.CAP_PROP_FPS);
        int frameSkip = (int) (timeStep * frameRate);
        int frameCount = 0;
        Mat frame = new Mat();
        while (videoCapture.read(frame)) {
            if (frameCount % frameSkip == 0) {
                Imgcodecs.imwrite(String.format("%s_%d.%s", pathTo, frameCount, ext), frame);
            }
            frameCount++;
        }
        videoCapture.release();
    }
}
