package CollectionExample;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class CollectionExample1 {
	public static void main(String[] args) {
	List<String> arrayList = new ArrayList<String>();
	arrayList.add("PHP");
	arrayList.add("Python");
	arrayList.add("Java");
	arrayList.add("C++");
	//cach duyet ra man hinh bang for-each
	System.out.println();
	for(String monhoc:arrayList) {
		System.out.print(monhoc+",");
	}
	/*System.out.println("Cac phan tu cua ArrayList");
	System.out.println("\t"+arrayList);
	
	 
		
	
	Set<String> hashSet = new HashSet<String>();
	 hashSet.add("PHP");
     hashSet.add("Python");
     hashSet.add("Java");
     hashSet.add("Java");
     hashSet.add("C++");
     System.out.println("Cac phan tu Set");
     System.out.print("\t" + hashSet + "\n");
     
     Map<String, String> hashMap = new HashMap<String, String>();
     hashMap.put("Windows", "2000");
     hashMap.put("Windows", "XP");
     hashMap.put("Language2", "Java");
     hashMap.put("Language1", ".Net");
     System.out.println("Cac phan tu Map");
     System.out.print("\t" + hashMap);*/


	}
}
