import java.util.*;

public class TestSort {
	public static void main(String[] args){
		List<SortMe> arrayList= new ArrayList<SortMe>();
		arrayList.add(new SortMe(1,"sanju"));
		arrayList.add(new SortMe(1,"abcd"));
		arrayList.add(new SortMe(2,"xyz"));
		arrayList.add(new SortMe(2,"sanju"));
		arrayList.add(new SortMe(2,"tiger"));
		arrayList.add(new SortMe(null,"lion"));
		arrayList.add(new SortMe(3,"apple"));
		arrayList.add(new SortMe(3,null));
		arrayList.add(new SortMe(3,"yellow"));
		arrayList.add(new SortMe(4,"orange"));
		arrayList.add(new SortMe(null,null));
		arrayList.add(new SortMe(4,"flower"));
		arrayList.add(new SortMe(4,"zero"));
		System.out.println("Befor:");
		System.out.println(arrayList);
		Collections.sort(arrayList);
		System.out.println("After:");
		System.out.println(arrayList);
		
	}
}


