package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String, Integer> mymap = new HashMap<String, Integer>();
		System.out.println(mymap.size());
		System.out.println(mymap.put("a", 1));
		System.out.println(mymap.put("a", null));
		System.out.println(mymap.size());
		//System.out.println(mymap.merge("a", 100 -> new Integer()));
		
		
		System.out.println("----------------------------------------------");
		
		List<String> list = new LinkedList<>();
		System.out.println(list.add(null));
		System.out.println(list.add(null));
		
		
		
	}

}
