import java.util.*;
public class Gale_Shapley{
	
	//USER INPUTS	
	//list of preferences for each man + woman
	int[][] wPref; 
	int[][] mPref;
	int N; //number of free men + women
	
	//make sure to initialize
	int freeMen; //number of men who are free	
	boolean[] isManFree;	 //all free at beginning
	int[] mNext; //index of who to propose to next for each man
	int[] wEngaged; //who the woman is engaged to. if not engaged, use -1 
	
	
	//constructors
	public Gale_Shapley(int[][] wPref, int[][] mPref, int num){
		this.wPref=wPref;
		this.mPref=mPref;
		this.N=num;
		this.freeMen=num;
		this.isManFree=new boolean[num];
		Arrays.fill(this.isManFree,true);
		this.mNext=new int[num];
		this.wEngaged=new int[num];
		Arrays.fill(wEngaged,-1);
	}
	
	//uses default N
	/*public Gale_Shapley(int[][] wPref, int[][] mPref){
		this.wPref=wPref;
		this.mPref=mPref; 
	}*/
	
	
	//implements the stable matching algorithm
	public void stableMarriage(){
		int w=0;
		int m=0;
		
		while (freeMen>0){ //there exists a free man who still has to propose to a woman
			
			//find free man
			for(int i=0; i<isManFree.length; i++){
				if(isManFree[i]){
					m=i;
					break;
				}
			}
			//figure out w (woman the man has not proposed to yet)
			w=mPref[m][mNext[m]];
			if (wEngaged[w]==-1){ //if woman is free
					//man will propose and (m,w) will become engaged
					wEngaged[w]=m;
					isManFree[m]=false;
					freeMen-=1;
				}
			else{ //if some other pair (m2,w) exists,
				int m2=wEngaged[w]; //who w is currently engaged to
				int idxM=0;
				int idxM2=0;
				for(int i=0; i<wPref[w].length;i++){
					if(wPref[w][i]==m){
						idxM=i;
					}
					else if((wPref[w][i])==m2){
						idxM2=i;
					}
				}
				if (idxM<idxM2) { //if index of m < index of m2 w/in wPref[w]
					//m2 becomes free
					isManFree[m2]=true;
					isManFree[m]=false;
					wEngaged[w]=m;
				}
			}
			mNext[m]+=1;
			
			
		}
	}
	
	public String toString(){
		return Arrays.toString(wEngaged);
	}	
	
}

