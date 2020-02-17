import java.util.*;

public class FirstLab {
	public static void main(String[] args){
		Scanner N0 = new Scanner(System.in); 
		System.out.print("������!!!\n"+"������� N: "); //����� ������ �������
		int N = N0.nextInt();
		System.out.print("������� M: ");
		int M = N0.nextInt();
		int[][] arr = new int[N][M]; //������� ������
		randomArray(arr); //��������� ������ �������� � �������� ���
		sorting(arr); //�������� ����������
		N0.close();
	}
	
	static void randomArray(int[][] randArr){
		for(int i=0; i < randArr.length; i++)
			for(int j=0; j < randArr[i].length; j++)
				randArr[i][j] = (int)(10*Math.random());
		printArray(randArr); //�������� ������
	}
	
	static void printArray(int[][] ourArr){ //�������� ������
		System.out.println("��� ������:");
		for(int i=0; i < ourArr.length; i++){
			for(int j=0; j < ourArr[i].length; j++)
				System.out.print(ourArr[i][j] + " ");
		System.out.println();
		}
	}
	
	static void sorting(int[][] array){ //����� ����������
		int flag=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("1. ���������� ���������!");
		do{
			int x = sc.nextInt();
			switch(x){
				case 1: useMenu(array); //�������� ����
					flag++;
					break;
				default: System.out.println("�������� ��� �����!");
			}
		}while(flag==0);
		sc.close();
	}
	
	static void useMenu(int[][] ourArr){
		int flag =0;
		Scanner sc = new Scanner(System.in);
		int[][] arr1 = ourArr.clone();
		do{
			System.out.println("����:\n1) ������� �������������� ������ ������;");
			System.out.println("2) ���������� ������������ ��������� � ������;");
			System.out.println("3) ��������� ����� � ������, ������� ��������� ����� q;\n4) ����������� �������������� ������;");
			System.out.println("5) �����.");
			int x = sc.nextInt();
			switch(x){
				case 1: average(arr1); //�������� ������� ��� ���������� �������� ���������������
					break;
				case 2: sort2(arr1);
					break;
				case 3: 
					System.out.print("������� q: ");
					int q = sc.nextInt();
					sort3(arr1, q);
					break;
				case 4: printArray(ourArr);
					break;
				case 5: flag=1;
					System.out.println("����� �����������!");
					break;
				default: System.out.println("������ ������ � ���� ���!");
			}
		}while(flag==0);
		sc.close();
	}
	static void average(int[][] array){//������� ������� ��������
		double[] res = new double[array.length];
		int[][] pocketArr = new int[1][];
		double pocket=0;
		for(int i=0; i<array.length; i++){ //��������� ������� �������������� ����� � ������ ��� ������ � ������ �����������
			double averageElem = 0;
			for(int j=0; j < array[i].length; j++)
				averageElem += array[i][j];
			averageElem /= array[i].length;
			res[i] = averageElem;
		}	
		for(int k=0; k<array.length-1; k++){ //����� �����������
			for(int i=0; i<res.length-1; i++){
				if (res[i] > res[i+1]){
					pocket = res[i]; //������ ������� ���������� 
					res[i] = res[i+1];
					res[i+1] = pocket;
					pocketArr[0] = array[i]; //������ ������� ������ � �������
					array[i] = array[i+1];
					array[i+1] = pocketArr[0];
				}
			}
		}
		System.out.println("��� ������:  ���������:");
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[i].length; j++)
				System.out.print(array[i][j] + " ");
			System.out.printf("%8.2f", res[i]);
			System.out.println();
		}
		
	}
	
	static void sortArray(int[][] array, int[] result){
		int[][] pocketArr = new int[1][];
		int pocket=0;
		for(int k=0; k<array.length-1; k++){ //����� �����������
			for(int i=0; i<result.length-1; i++){
				if (result[i] > result[i+1]){
					pocket = result[i]; //������ ������� ���������� 
					result[i] = result[i+1];
					result[i+1] = pocket;
					pocketArr[0] = array[i]; //������ ������� ������ � �������
					array[i] = array[i+1];
					array[i+1] = pocketArr[0];
				}
			}
		}
		System.out.println("��� ������:  ���������:");
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[i].length; j++)
				System.out.print(array[i][j] + " ");
			System.out.println("\t" + result[i]);
		}
	}
	
	static void sort2(int[][] array){ //���������� ������������ ��������� � ������
		int[] amount = new int[array.length];
		
		for(int i=0; i < array.length; i++)
			for(int j=0; j < array[i].length-1; j++)
				if (array[i][j] < array[i][j+1])
					amount[i]++;
		
		sortArray(array, amount);
	}
	
	static void sort3(int[][] massive, int q){
		int[] amount = new int[massive.length];
		for(int i=0; i < massive.length; i++)
			for(int j=0; j < massive[i].length; j++)
					if(massive[i][j]%q == 0 && massive[i][j]!=0) amount[i]++;
		sortArray(massive, amount);
	}
}


