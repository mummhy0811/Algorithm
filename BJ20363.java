import java.util.*;
public class Main {
//INU코드페스티벌
//그리디 알고리즘
	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int x=scanner.nextInt(); //온기
		int y=scanner.nextInt(); //수분
		int s=x<y?x:y; //더 작은 거
		int ans=x+y+s/10;
		System.out.println(ans);
		scanner.close();
	}
}
