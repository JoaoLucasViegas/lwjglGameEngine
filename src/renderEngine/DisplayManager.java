package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

public class DisplayManager {
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	private static final int STARTING_POINT_SCREEN = 0;
	private static final int FPS_LIMIT = 240;

	public static void attachDisplay(String titleText) {
		ContextAttribs attrib = new ContextAttribs(3, 2)
				.withForwardCompatible(true)
				.withProfileCore(true);

		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attrib);
			Display.setTitle(titleText);
		} catch (LWJGLException e) {
			throw new RuntimeException(e);
		}
		GL11.glViewport(STARTING_POINT_SCREEN, STARTING_POINT_SCREEN, WIDTH, HEIGHT);
	}

	public static void updateDisplay() {
		Display.sync(FPS_LIMIT);
		Display.update();
	}

	public static void detachDisplay() {
		Display.destroy();
	}

}
