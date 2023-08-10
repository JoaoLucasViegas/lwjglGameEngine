package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import models.RawModel;
import renderEngine.Renderer;
import shaders.StaticShader;

public class MainGameLoop {

	public static void main(String[] args) {
		
		DisplayManager.attachDisplay("FirstGameLinux!");
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();
		
		float[] vertx = {
				-0.5f, 0.5f, 0f, //v0
				-0.5f, -0.5f, 0f, //v1
				0.5f, -0.5f, 0f, //v2
				0.5f, 0.5f, 0f //v3
		};
		int[] indx = {
				0,1,3, //TOP-LEFT CORNER
				3,1,2 //BOTTOM-RIGHT CORNER
		};
		RawModel model = loader.loadToVAO(vertx, indx);

		while (!Display.isCloseRequested()) {
			renderer.prepare();
			shader.start();
			renderer.render(model);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.detachDisplay();
	}

}
