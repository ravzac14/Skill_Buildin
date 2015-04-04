//Zack Raver, ravzac14, 1/16/14
//Programming Lab 4

public class SierpinskiTree {
	static int base = 7;

	static String triangles(int n, int d, int l){
		String result = "";

		for (int i=1;i<=base; i+=2){
			for (int k=0; k<=l; k++){
				result += " ";
			}
			for (int k=0; k<n; k++){
				for (int j=0; j<d; j++){
					result += " ";
				}
				for (int j=0; j<(base - i)/2; j++){
					result += " ";
				}
				for (int j=0; j<(i); j++){
					result += "*";
				}

				result += " ";

				for (int j=0; j<(base-i)/2; j++){
					result += " ";
				}
				for (int j=0; j<d; j++){
					result += " ";
				}
			}
			result += "\n";
		}
		return result;
	}

	static String trunkBase(int n, int t){
		String trunk = "";
		for (int i = 1; i<=n; i++){
			for (int k=1; k<=t; k++){
				trunk += " ";
			}
			for (int j=0; j<=n; j++){
				trunk += "*";
			}
			trunk += "\n";
		}
		return trunk;
	}

	static String bareString(){
		String bareString = "";
		bareString += triangles(1,0,12);
		bareString += triangles(2,0,8);
		bareString += triangles(2,4,0);
		bareString += triangles(4,0,0);
		bareString += trunkBase(8,12);
		return bareString;
	}

	public static void main(String[] args){
		System.out.println(bareString());
	}
}
