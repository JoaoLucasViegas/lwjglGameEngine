package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	private static final int FPS_LIMIT = 60;

	public static void attachDisplay(String titleText) {
		ContextAttribs attribs = new ContextAttribs(3, 2)
				.withForwardCompatible(true)
				.withProfileCore(true);

		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle(titleText);
		} catch (LWJGLException e) {
			throw new RuntimeException(e);
		}
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}

	public static void updateDisplay() {
		Display.sync(FPS_LIMIT);
		Display.update();
	}

	public static void detachDisplay() {
		Display.destroy();
	}

}
