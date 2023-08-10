package shaders;

public class StaticShader extends ShaderProgram {

    private static final String VERTEX_FILEPATH = "src/shaders/vertexShader.glsl";
    private static final String FRAGMENT_FILEPATH = "src/shaders/fragmentShader.glsl";

    public StaticShader() {
        super(VERTEX_FILEPATH, FRAGMENT_FILEPATH);
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
    }
}
