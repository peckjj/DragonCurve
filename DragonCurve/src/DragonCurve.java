import java.util.ArrayList;
import java.util.Iterator;

public class DragonCurve {
	
	private ArrayList<Integer> curve;
	
	public DragonCurve(int iterations)
	{
		// Iterations at 0 is a straight line going right.
		curve = new ArrayList<Integer>();
		curve.add(0);
		
		iterate(iterations);
	}
	
	private void iterate(int iterations)
	{
		for (int i = 0; i < iterations; i++)
		{
			for (int j = curve.size() - 1; j >= 0; j--)
			{
				curve.add((curve.get(j) + 1) % 4);
			}
		}
	}
	
	public int get(int index)
	{
		return curve.get(index);
	}
	
	public String toString()
	{
		String result = "{";
		for (int i = 0; i < curve.size() - 1; i++)
		{
			result += decode(get(i)) + ", ";
		}
		result += decode(get(curve.size() - 1)) + "}";
		return result;
	}
	
	private String decode(int code)
	{
		String result;
		
		switch (code) {
		
		case 0: result = "right";
				break;
		case 1: result = "up";
				break;
		case 2: result = "left";
				break;
		default: result = "down";
				 break;
		}
		return result;
	}
	
	public Iterator<Integer> iterator()
	{
		return curve.iterator();
	}
}
