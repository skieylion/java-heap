package project.java;

public class MetalToolkitFactory implements ToolkitFactory {
    @Override
    public Drill createDrill() {
        return new MetalDrill();
    }

    @Override
    public Saw createSaw() {
        return new MetalSaw();
    }
}
