package project.java;

public class App {
    public static void main(String[] args) {
        String imagePath = "/image1.png";
        System.out.println(ImageCache.loadImage(imagePath));
        System.out.println(ImageCache.loadImage(imagePath));
        var bufferedImageWeakReference = ImageCache.getWeakReferenceBufferedImageByPath(imagePath);
        System.out.println(bufferedImageWeakReference.get());
        ImageCache.clear();
        //System.gc();
        System.out.println(bufferedImageWeakReference.get());

        //System.gc();
        //System.out.println(ImageCache.loadImage(imagePath));

    }
}
