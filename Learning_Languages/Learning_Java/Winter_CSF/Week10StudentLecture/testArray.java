public class testArray{
	

	public static void main(String[] args){
		
		Object o = new Long[0];
		System.out.println( o.getClass().isArray());
		System.out.println(o.getClass().getName());

		String[] tru = new String[0];
		System.out.println(tru.getClass().getName());
		
	}

}
