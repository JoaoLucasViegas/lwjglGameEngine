package engineTester;

import entities.Camera;
import entities.Entity;
import models.RawModel;
import models.TexturedModel;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		
		DisplayManager.attachDisplay("First Game Linux!");
		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);

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
		Entity cat = new Entity(texturedModel, new Vector3f(0, 0,-1), 0,0,0, 1);
		Camera camera = new Camera();

		while (!Display.isCloseRequested()) {
			cat.increasePosition(0, 0,-0.001f);
			camera.move();
			renderer.prepare();
			shader.start();
			shader.loadViewMatrix(camera);
			renderer.render(cat, shader);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.detachDisplay();
	}

}
