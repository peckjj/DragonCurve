import java.awt.Font;
import java.util.Iterator;
import java.util.Random;

public class DragonCurveDriver {
	public static int defIterations = 15;
	
	public static int WIDTH;
	public static int HEIGHT;;
	
	public static Random random;
	
	public static double sizeX;
	public static double sizeY;
	public static double size;
	
	public static double startX;
	public static double startY;
	public static double lastX;
	public static double lastY;
	public static double newX;
	public static double newY;
	public static void main(String[] args) {
		
		DragonCurve curve;
		
		if (args.length > 0)
		{
			curve = new DragonCurve(Integer.parseInt(args[0]));
		}
		else
		{
			curve = new DragonCurve(defIterations);
		}
		if (args.length == 3)
                {
			WIDTH = Integer.parseInt(args[1]);
			HEIGHT = Integer.parseInt(args[2]);
		}
		else
		{
			WIDTH = 1800;
			HEIGHT = 1800;
		}
		random = new Random();
		sizeX = WIDTH / curve.getXRange();
		sizeY = HEIGHT / curve.getYRange();
		size = Math.min(sizeX, sizeY);
		startY = HEIGHT - (sizeY * curve.getMaxUps());
		startX = WIDTH - (sizeX * curve.getMaxRights());
		newY = startY;
		newX = startX;
		
		StdDraw.setCanvasSize(WIDTH, HEIGHT);
		StdDraw.setXscale(0, WIDTH);
		StdDraw.setYscale(0, HEIGHT);
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.setPenRadius(.003);
		StdDraw.enableDoubleBuffering();
		Iterator<Integer> c = curve.iterator();
		StdDraw.setPenColor(StdDraw.WHITE);
		while (c.hasNext())
		{
			//StdDraw.setPenColor(random.nextInt(256), random.nextInt(256), random.nextInt(256));
			drawNext(c.next());
		}
		StdDraw.setFont(new Font("Times New Roman", Font.BOLD, 50));
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.text(200, HEIGHT - 100, "Iterations: " + curve.getIterations());
		StdDraw.show();
	}
	
	public static void drawNext(int direction)
	{
		lastX = newX;
		lastY = newY;
		switch (direction)
		{
			case 0: newX += sizeX;
					break;
			case 1: newY += sizeY;
					break;
			case 2: newX -= sizeX;
					break;
			default: newY -= sizeY;
					 break;
		}
		StdDraw.line(lastX, lastY, newX, newY);
	}

}
