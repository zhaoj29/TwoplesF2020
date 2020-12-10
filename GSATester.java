import java.util.*;
public class GSATester{
	public static void main(String[] args){
		int[][] mpref1={{2,0,1},{2,1,0},{0,1,2}};
		int[][] wpref1={{1,2,0},{0,1,2},{1,0,2}};
		Gale_Shapley test=new Gale_Shapley(wpref1,mpref1,3);
		
		test.stableMarriage();
		System.out.println(test.toString());
		
	}
}