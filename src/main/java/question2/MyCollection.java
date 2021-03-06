package question2;

/**
 * Please implement Dynamic Array Interface
 * 
 * @author
 *
 */
public class MyCollection implements DynamicArray {
	// Uncomment commented section

	/**
	 * You can declare local/global variables as per your requirement
	 */
	@SuppressWarnings("unused")
	private String[] numArray;
	private int counter = 0;

	public MyCollection(int arraySize) {
		numArray = new String[arraySize];
	}

	public int search(String searchingNum) {
		// TODO Auto-generated method stub
		for (int i = 0; i < numArray.length; i++) {
			if (searchingNum.equals(numArray[i]))
				return i;
		}
		return -1;
	}

	public boolean add(String numberToAdd) {
		// TODO Auto-generated method stub
		if (search(numberToAdd) == -1) {
			if (getCount() == 0) {
				numArray[0] = numberToAdd;
				counter++;
				return true;
			} else if (getCount() < numArray.length) {
				numArray[getCount()] = numberToAdd;
				counter++;
				return true;
			}

			else{
				System.out.println("array is full creating new array");
				System.out.println(numArray.length);
				doubleCapacity();
				System.out.println(numArray.length+"  "+getCount());
				numArray[getCount()] = numberToAdd;
				counter++;
				return true;

			}

		} else {
			return false;
		}

	}

	public void doubleCapacity() {
		// TODO Auto-generated method stub
		String[] temp = new String[numArray.length * 2];
		for (int i = 0; i < getCount(); i++) {
			temp[i] = numArray[i];
		}
		numArray = temp;

	}

	public boolean remove(String numberToRemove) {
		// TODO Auto-generated method stub
		int index = search(numberToRemove);
		if (index != -1) {
			for (int i = index; i < (getCount() - 1); i++) {
				numArray[i] = numArray[i + 1];
			}
			numArray[getCount() - 1] = null;
			return true;
		}
		return false;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		// int count=0;
		// while(!numArray[count].equals(null)) {count++;}
		return this.counter;
	}

	public String[] rotate(int n) {
		// TODO Auto-generated method stub
		String[] temp = new String[numArray.length];
		int i = 0;
		for (i = 0; i < (getCount() - n); i++) {
			temp[i] = numArray[i + n];
		}
		for (int j = 0; j < n; j++, i++) {
			temp[i] = numArray[j];
		}
		numArray=temp;
		return temp;
	}

	public String toString() {
		String str = "{";
		int count = getCount();
		for (int i = 0; i < count; i++) {
			if (i == 0)
				str +=numArray[i];
			else if(i==(getCount()-1))
				str+=", "+numArray[i];
			else
				str += ", " + numArray[i];
		}

		return str+"}";
	}

}
