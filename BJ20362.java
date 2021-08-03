import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ20362 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		String infor=scanner.nextLine();
		StringTokenizer token=new StringTokenizer(infor);
		int n=Integer.parseInt(token.nextToken());

		String winner=token.nextToken();
		String name[]=new String[n];
		String chat[]=new String[n];
		int ansnum=0;
		int people=0;
		for(int i=0;i<n;i++) {
			String str=scanner.nextLine();
			StringTokenizer strToken = new StringTokenizer(str);
			name[i]=strToken.nextToken();
			chat[i]=strToken.nextToken();
			if(name[i].equals(winner)) { //정답자 나오면 번호 저장
				ansnum=i;
			}
		}
		for(int i=0;i<n;i++) {
			if(name[i].equals(winner)) { //정답자일경우
				break;
			}
			if(chat[i].equals(chat[ansnum])) {
				//System.out.println(name[i]+" "+chat[i]);
				people++; //억울한 사람 수 증가
			}
		}
		System.out.println(people);
		scanner.close();
	}

}
