package AntonioSisinni213634.MyListUtil;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ListUtil_Test {
	private static ArrayList<Integer> list;
	private static ArrayList<Integer> listControllo;

	@BeforeClass
	public static void starting() {
		list = new ArrayList<>();
		listControllo = new ArrayList<>();
		
		System.out.println("Start test on ListUtil " + DateTime.now().toLocalDate());
		System.out.println("=============================================");
	}

	@AfterClass
	public static void closing() {
		System.out.println("=============================================");
		System.out.println("End test on ListUtil   " + DateTime.now().toLocalDate());
	}

	@Before
	public void setting() {
		System.out.println("--------------[Start " + DateTime.now().toLocalDate() + "]-------------");
	}
	
	@After
	public void resetting() {
		list.clear();
		listControllo.clear();
		System.out.println("--------------[End   " + DateTime.now().toLocalDate() + "]-------------\n");
	}
	
	@Test
	public void ordinamentoCrescente_corretto() {
		list.add(96);
		list.add(6);
		list.add(67);
		list.add(39);
		
		listControllo.add(6);
		listControllo.add(39);
		listControllo.add(67);
		listControllo.add(96);
		
		list = ListUtil.getInstance().reorder(list, ListUtil.Ascendente);
		
		assertArrayEquals(list.toArray(), listControllo.toArray());
	}
	
	@Test
	public void ordinamentoDecrescente_corretto() {
		list.add(96);
		list.add(6);
		list.add(67);
		list.add(39);
		
		listControllo.add(96);
		listControllo.add(67);
		listControllo.add(39);
		listControllo.add(6);
		
		list = ListUtil.getInstance().reorder(list, ListUtil.Dicendente);
		
		assertArrayEquals(list.toArray(), listControllo.toArray());
	}
	
	@Test(timeout = 10)
	public void test_Performance() {
		for(int i = 0; i < 50; ++i)
			list.add(i);
		
		list = ListUtil.getInstance().reorder(list, ListUtil.Dicendente);
	}
	
	@Test
	public void test_modificaVuoto() {
		list = ListUtil.getInstance().reorder(list, ListUtil.Ascendente);
		list = ListUtil.getInstance().reorder(list, ListUtil.Dicendente);
		
		if(list.size() != 0)
			assert(false);
	}
	
	@Test
	public void test_erroreCreazioneIstanza() {
		if(ListUtil.getInstance() == null)
			assert(false);
	}
	
}
