import java.util.ArrayList;
import java.util.Iterator;

public class DragonCurve {

	private ArrayList<Integer> curve;
	private int curXPosition;
	private int curYPosition;
	private int maxX;
	private int minX;
	private int maxY;
	private int minY;
	private int iterations;

	public DragonCurve(int iterations) {
		// Iterations at 0 is a straight line going right.
		curXPosition = 0;
		curYPosition = 0;
		this.iterations = iterations;
		maxY = Integer.MIN_VALUE;
		minY = Integer.MAX_VALUE;
		maxY = Integer.MIN_VALUE;
		minY = Integer.MAX_VALUE;
		curve = new ArrayList<Integer>();
		curve.add(update(0));

		iterate(iterations);
	}

	private void iterate(int iterations) {
		for (int i = 0; i < iterations; i++) {
			for (int j = curve.size() - 1; j >= 0; j--) {
				curve.add(update((curve.get(j) + 1) % 4));
			}
		}
	}

	private int update(int direction) {
		if (direction == 0) {
			curXPosition++;
		} else if (direction == 2){
			curXPosition--;
		} else if (direction == 1) {
			curYPosition++;
		} else
		{
			curYPosition--;
		}
		maxX = Math.max(maxX, curXPosition);
		minX = Math.min(minX, curXPosition);
		maxY = Math.max(maxY, curYPosition);
		minY = Math.min(minY, curYPosition);
		
		return direction;
	}

	public int get(int index) {
		return curve.get(index);
	}

	public String toString() {
		String result = "{";
		for (int i = 0; i < curve.size() - 1; i++) {
			result += decode(get(i)) + ", ";
		}
		result += decode(get(curve.size() - 1)) + "}";
		return result;
	}

	private String decode(int code) {
		String result;

		switch (code) {

		case 0:
			result = "right";
			break;
		case 1:
			result = "up";
			break;
		case 2:
			result = "left";
			break;
		default:
			result = "down";
			break;
		}
		return result;
	}

	public Iterator<Integer> iterator() {
		return curve.iterator();
	}

	public int getMaxUps() {
		return maxY;
	}

	public int getMaxDowns() {
		return minY;
	}

	public int getMaxLefts() {
		return minX;
	}

	public int getMaxRights() {
		return maxX;
	}

	public int getXRange() {
		return getMaxRights() - getMaxLefts();
	}

	public int getYRange() {
		return getMaxUps() - getMaxDowns();
	}
	
	public int getIterations()
	{
		return iterations;
	}
}
