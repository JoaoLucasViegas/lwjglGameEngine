package shaders;

import org.lwjgl.util.vector.Matrix4f;

public class StaticShader extends ShaderProgram {

    private static final String VERTEX_FILEPATH = "src/shaders/vertexShader.glsl";
    private static final String FRAGMENT_FILEPATH = "src/shaders/fragmentShader.glsl";
    private int location_transformationMatrix;

    public StaticShader() {
        super(VERTEX_FILEPATH, FRAGMENT_FILEPATH);
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
        super.bindAttribute(1, "textureCoords");
    }

    @Override
    protected void getAllUniformLocation() {
        location_transformationMatrix = super.getUniformLocation("transformationMatrix");
    }

    public void loadTransformationMatrix(Matrix4f matrix) {
        super.loadMatrix(location_transformationMatrix, matrix);
    }
}
