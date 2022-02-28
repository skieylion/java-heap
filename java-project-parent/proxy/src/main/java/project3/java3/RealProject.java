package project3.java3;

public class RealProject implements Project {

    private final String url;

    public RealProject(String url) {
        this.url = url;
        System.out.println("Loading "+url+" ...");
    }

    @Override
    public void run() {
        System.out.println("Running "+url+" ...");
    }
}
