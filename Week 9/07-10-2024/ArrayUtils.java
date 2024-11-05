package AssignmentOct07_Singleton;

/*
1. Make constructor private
2. Create a static method for object creation
3. In above method create object only if not already created
4. use static member to find object already created
 */

//Singleton = can create one and only one object

public class ArrayUtils {
	private int array[];

	private static ArrayUtils obj = null;

	// constructor
	private ArrayUtils(int array[]) {
		this.array = array;
	}

	public static ArrayUtils getInstance(int array[]) {

		if (obj == null) {
			obj = new ArrayUtils(array);
		}
		return obj;
	}

	public int min() {
		int min_val = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min_val) {
				min_val = array[i];
			}
		}

		return min_val;
	}

	// max

	// avg

	// etc...

}
