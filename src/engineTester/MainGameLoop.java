package engineTester;

import models.RawModel;
import models.TexturedModel;
import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		
		DisplayManager.attachDisplay("First Game Linux!");
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();
		
		float[] vertx = {
				-0.5f, 0.5f, 0f, //v0
				-0.5f, -0.5f, 0f, //v1
				0.5f, -0.5f, 0f, //v=2
				0.5f, 0.5f, 0f //v3
		};
		int[] idx = {
				0,1,3, //TOP-LEFT CORNER
				3,1,2 //BOTTOM-RIGHT CORNER
		};
		float[] indices = {
			0,0,
			0,1,
			1,1,
			1,0
		};

		RawModel model = loader.loadToVAO(vertx, indices, idx);
		ModelTexture texture = new ModelTexture(loader.loadTexture("supfella"));
		TexturedModel texturedModel = new TexturedModel(model, texture);

		while (!Display.isCloseRequested()) {
			renderer.prepare();
			shader.start();
			renderer.render(texturedModel);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.detachDisplay();
	}

}
