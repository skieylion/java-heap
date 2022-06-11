package project.java;

public class WoodToolkitFactory implements ToolkitFactory {
    @Override
    public Drill createDrill() {
        return new WoodDrill();
    }

    @Override
    public Saw createSaw() {
        return new WoodSaw();
    }
}
