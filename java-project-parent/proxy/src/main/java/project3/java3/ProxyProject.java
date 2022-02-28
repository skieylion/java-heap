package project3.java3;

public class ProxyProject implements Project {

    private final String url;
    private RealProject project;

    public ProxyProject(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        if (project == null) {
            project = new RealProject(url);
        }
        project.run();
    }
}
