package Test;

public enum EnumTest {
	SPRING("春天" , 2 ,4),
	SUMMER("夏天" , 5 , 7),
	FALL("秋天" , 8 , 10),
	WINTER("冬天" , 11 , 1);
	
	public final String name;
	public final int startMonth;
	public final int endMonth;
	
	private EnumTest(String n , int s , int e) {
		name = n;
		startMonth = s;
		endMonth = e;
	}
	
}
