
public class LoopFlow {
	public static void main(String[] args) {
		int terminator = 0;
		for(int i = 0;i < 10 && terminator < 10;i++) {
			System.out.println(i);
			terminator++;
			if(terminator < 10)
				continue;
		}
		int i = 0;
		terminator = 0;
		while(i < 10 && terminator < 10) {
			System.out.println(i);
			terminator++;
			if(terminator < 10)
				continue;
			i++;
		}
	}
}
