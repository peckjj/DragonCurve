import java.util.Iterator;

public class DragonCurveDriver {
	public static int defIterations = 16;
	
	public static final int WIDTH  = 1000;
	public static final int HEIGHT = 1000;
	
	public static final double SIZE = 5;
	
	public static double startX = 3 * WIDTH / 4;
	public static double startY = 3 * HEIGHT / 4;
	public static double lastX;
	public static double lastY;
	public static double newX = startX;
	public static double newY = startY;

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
		
		StdDraw.setCanvasSize(WIDTH, HEIGHT);
		StdDraw.setXscale(0, WIDTH);
		StdDraw.setYscale(0, HEIGHT);
		StdDraw.clear(StdDraw.WHITE);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(.002);
		Iterator<Integer> c = curve.iterator();
		while (c.hasNext())
		{
			drawNext(c.next());
		}
		StdDraw.show();
	}
	
	public static void drawNext(int direction)
	{
		lastX = newX;
		lastY = newY;
		switch (direction)
		{
			case 0: newX += SIZE;
					break;
			case 1: newY += SIZE;
					break;
			case 2: newX -= SIZE;
					break;
			default: newY -= SIZE;
					 break;
		}
		StdDraw.line(lastX, lastY, newX, newY);
	}

}
