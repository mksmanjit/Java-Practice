

public class SortMe implements Comparable<SortMe>{
	Integer num;
	String str;
	public SortMe(Integer num,String str)
	{
		this.num=num;
		this.str=str;
	}

	public int compareTo(SortMe obj) {
		if (num != null) {
			if (obj.num == null)
				return 1;
			else {
				int x = num.compareTo(obj.num);
				if (x == 0) {
					return compareStringObject(obj);

				} else
					return x;
			}
		} else {
			if (obj.num == null)
				return compareStringObject(obj);
			else
				return -1;

		}
	}

	private int compareStringObject(SortMe obj) {
		if (str != null) {
			if (obj.str == null)
				return 1;
			else
				return str.compareTo(obj.str);
		} else {
			if (obj.str == null)
				return 0;
			else
				return -1;
		}
	}
	
	public String toString(){
		return num+" "+str;
	}
}
