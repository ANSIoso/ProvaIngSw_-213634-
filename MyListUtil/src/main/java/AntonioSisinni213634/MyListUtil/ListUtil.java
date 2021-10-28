package AntonioSisinni213634.MyListUtil;

import java.util.ArrayList;

public class ListUtil {
	private static ListUtil instance = null;

	public static final int Ascendente = 0;
	public static final int Dicendente = 1;

	private ListUtil() {
	}

	static public ListUtil getInstance() {
		if (instance == null)
			instance = new ListUtil();

		return instance;
	}

	public ArrayList<Integer> reorder(ArrayList<Integer> list, int ord){
		boolean movement = true;
		
		while(movement) {
			movement = false;
			for(int i = 0; i < list.size()-1; ++i) {
				if(list.get(i) > list.get(i+1) && ord == Ascendente) {
					int app = list.get(i);
					
					list.set(i  , list.get(i+1));
					list.set(i+1, app		   );
					
					movement = true;
				}
				
				if(list.get(i) < list.get(i+1) && ord == Dicendente) {
					int app = list.get(i);
					
					list.set(i  , list.get(i+1));
					list.set(i+1, app		   );
					
					movement = true;
				}
			}
		}
		
		return list;
	}
}
