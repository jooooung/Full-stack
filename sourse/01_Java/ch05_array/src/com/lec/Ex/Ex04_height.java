package com.lec.Ex;
//�迭�� �̿��Ͽ� �л���(����, ö��, �浿, ����, ����)�� Ű�� �Է¹ް�, ���ġ�� ���غ���.
//���� ū Ű�� ���� ���� Ű�� ��� ���ϱ�
import java.util.Scanner;

public class Ex04_height {
	public static void main(String[] args) {
		String[] arrName = {"����", "ö��", "�浿", "����", "����"};   //�̸� ���� ����
		int[] arrHeight = new int[arrName.length];    //Ű ���� ����
		Scanner sc = new Scanner(System.in);
		int totHeight = 0;
		// Ű �Է¹ޱ� -> totHeight�� ����
		for(int idx=0 ; idx<arrName.length ; idx++) {
			System.out.print(arrName[idx]+"�� Ű��? : ");
			arrHeight[idx] = sc.nextInt();
			totHeight += arrHeight[idx];  //����
		}
		for(int idx=0 ; idx<arrName.length ; idx++) {
			System.out.printf("%d��° %s�� Ű�� %d\n", idx,  arrName[idx], arrHeight[idx]);
		}
		System.out.println(arrName.length + "���� ���Ű��" + (double)totHeight/arrHeight.length);
		System.out.printf("%d���� ���Ű�� %.1f\n", arrName.length, (double)totHeight/arrHeight.length);
		sc.close();
		int maxIdx=0, maxHeight=0;  //������� ���ϱ� ���� ������(���� ������ �ʱ�ȭ)
		int minIdx=0, minHeight=9999;   //�ִܽ��� ���ϱ� ���� ������(ū������ �ʱ�ȭ)
		for(int idx=0 ; idx<arrName.length ; idx++) {
			if(arrHeight[idx] > maxHeight) {       //�����
				maxHeight = arrHeight[idx];
				maxIdx = idx;
			}//if
			if(arrHeight[idx] < minHeight) {		//�ִܽ�
				minHeight = arrHeight[idx];
				minIdx = idx;
			}
		}//for
		System.out.printf("���� ū �л� %s�� Ű�� %d\n", arrName[maxIdx], maxHeight);
		System.out.printf("���� ���� �л� %s�� Ű�� %d\n", arrName[minIdx], minHeight);
	}//main
}//clase