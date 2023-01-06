# Exception(예외)
1. 예외란
2. 예외처리의 필요성
3. 예외처리의 문법
4. 일반적으로 많이 보게 되는 예외들

# 1. 예외란
- 잘 돌아가는 프로그램도 여러가지 입력을 하다보면 에러가 생길수도 있다.  
  이러한 에러를 사전에 대비하는 것을 예외 처리라고 한다.

||문법에러|문법적으로 나타나는 에러|
|---|:---:|---|
|||논리에러: 프로그래머가 잘못 작성해서 이상한 결과가 나오는 경우|
|에|실행에러|시스템에러 : 프로그래머의 의지와 상관없이 나타나는 에러|
|러|실행시에러|예외사항 : 정상적으로 프로그램이 동작하는 과정에서 나타나는 에러  
|||프로그램 실행 중에 발생하는 예기치 않는 사건|

# 2. 예외처리의 필요성
- 프로그램이 어느 한 부분에서 예외가 발생하여도 멈추지 않고 동작되도록 하기 위해서이다.  
문제 하나의 발생으로 전체 프로세스가 정지되어버리면 손실이 너무 크기 때문이다

## ex. 연산자 예외
```
public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("원하는 첫번째 정수 i는 ? ");
		int i = scanner.nextInt();
		System.out.print("원하는 두번째 정수 j는 ? ");
		int j = scanner.nextInt();
		System.out.println("i="+i+"\tj="+j);
		
		System.out.println("i*j = "+ (i*j));
		System.out.println("i/j = "+ (i/j));
		System.out.println("i+j = "+ (i+j));
		System.out.println("i-j = "+ (i-j));
		scanner.close();
```
사용자한테 두 수를 입력 받는 프로그램이다.  
만약 나눗셈에서 사용자가 0을 입력하면 프로그램은 에러가 생겨버린다  
이러한 경우 나눗셈을 예외처리하여 나눗셈을 제외한 다른 일을 처리하게 해야 한다.

# 3. 예외처리 문법
## 1. try ~ catch
```
	try {
	    try블럭 ; 익셉션이 발생할 가능성이 있는 명령문들(문제가 발생할 수 있는 로직을 기술)

	}catch(익셉션타입 익셉션변수) {
	    그 익셉션을 처리하는 명령문(try블록안에서 문제가 발생했을 때 대처방안 기술);

	} finally {
	    익셉션 발생 여부와 상관없이 맨 마지막에 실행할 명령문;
	}
```
앞서 언급했던 나눗셈의 예외처리를 해보았다
try절에 나눗셈을 넣고 catch절에 예외처리를 해주었다
```
public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("원하는 첫번째 정수 i는 ? ");
		int i = scanner.nextInt();
		System.out.print("원하는 두번째 정수 j는 ? ");
		int j = scanner.nextInt();
		System.out.println("i="+i+"\tj="+j);
		
		System.out.println("i*j = "+ (i*j));
		try{
			System.out.println("i/j = "+ (i/j)); 
            //문제가 발생할 수 있는 로직을 try 처리		
        }catch (ArithmeticException e) {
			System.out.println(e.getMessage());//문제가 발생할 경우 처리하는 부분
			e.printStackTrace();//예외 메시지를 좀 더 자세히 볼 수 있다
			//문제가 발생하여도 catch로 처리하고 나머지 작업 계속 진행
		}
		System.out.println("i+j = "+ (i+j));
		System.out.println("i-j = "+ (i-j));
		scanner.close();
	}
```

## 2. throws
- try - catch 가 아닌 throws로도 예외처리를 할 수 있다
- 일처리 순서
ㄴ C 전반 - B 전반 - A 전반 - 예외처리 - B 후반 - C 후반
- A 후반에서 예외가 발생하여 실행하지 않고 B로 돌아간 것을 알 수 있다
### 결과
```
actionC 전반부
actionB 전반부
actionA 전반부
3
actionB 후반부
actionC 후반부
```
### throwEx
```
package com.lec.ex1_tryCatch;

public class ThrowsEx {
	public ThrowsEx() throws Exception{
		actionC();
	}

	private void actionC() throws IndexOutOfBoundsException{
		System.out.println("actionC 전반부");
		actionB();
		System.out.println("actionC 후반부");
	}

	private void actionB() throws IndexOutOfBoundsException{
		System.out.println("actionB 전반부");
		try {
			actionA();
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("actionB 후반부");
	}

	private void actionA() throws ArrayIndexOutOfBoundsException{  //예외가 발생되면 중단
		System.out.println("actionA 전반부");
		int[] arr = { 0, 1, 2 };
			System.out.println(arr[3]);			//이 부분에서 예외가 발생하여
		System.out.println("actionA 후반부");    // 그 다음은 실행 x
	}
}
```
### Main
```
package com.lec.ex1_tryCatch;

public class TestMain {
	public static void main(String[] args) {
		try {
			new ThrowsEx();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
```

# 4. 일반적으로 많이 보게 되는 예외들
## - 1. ArrayIndexOutOfBoundsException
- 배열을 사용시 존재하지 않는 index값을 호출하면 발생 합니다.
```
	int[] iArr = {0,1,2,3};
	System.out.println(iArr[4]);    // 배열에 없는 4를 호출하여 예외 발생
```
## - 2. NullPointerException
- 존재하지 않는 객체를 가리킬 때 발생 합니다
```
	String str = null;
	char c = str.charAt(0);		// 존재하지 않는 str.charAt(0)
```

## - 3. NumberFormatException
- 숫자로 변경할 수 없는 문자열을 변경하려고 함.
```
public static void main(String[] args) {
		String str = "aa";
		String str1 = "10     ";
		int i = 10;
		int j = Integer.parseInt(str)+i;
		j = Integer.parseInt(str1.trim())+i;
	}
```

# 계좌 출금 시 잔액 부족 예외
- 계좌를 개설하고 예금한 계좌 금액보다 큰 금액 출금 시 예외처리를 해보았다
## - Acount
- 데이터 : accountNo(String), ownerName(String), balance(long)
- 기능(메소드) : deposit(예금), withdraw(인출), infoPrint(정보출력)
```
public class Account {
	private String accountNo;
	private String ownerName;
	private long balance;
	public Account() {}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.println(ownerName + "님 계좌 개설 감사합니다. 잔액 : "+ balance);
	}
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName+"님 계좌 개설 감사합니다. 잔액 : "+balance);
	}
	public void deposite(long money) {//예금하기
		balance += money;
		System.out.println(money+"원 예금하여 잔액 : "+balance);
	}
	public void withdraw(long money) throws Exception {//잔액이 있을 경우에만 인출되게 하기
		if(balance>=money) {
			balance -= money;
			System.out.println(money+"원 인출하여 잔액 :" + balance);
		}else {
			throw new Exception("잔액이 부족하여 인출 불가합니다"); //에러 메세지
		}
	}
	public void infoPrint() {
		// "110-333-5555" 홍길동님 잔액 : 10원 출력
//		System.out.println("\""+accountNo+"\" "+ ownerName +"님 잔액 :" + balance + "원" );
		System.out.printf("\" %s \"%s님 잔액 : %d원\n", accountNo, ownerName, balance);
	}
	//setter : name      계좌번호, 잔액은 변경할 수 없게  이름은 변경 가능하게
	//getter 
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String infoString() {
		//return "\""+accountNo+"\" "+ ownerName +"님 잔액 :" + balance + "원";
		return String.format("\" %s \"%s님 잔액 : %d원\n", accountNo, ownerName, balance);
	}
}
```
## Main
- 계좌번호, 이름 입력하여 계좌 개설
- 입금 후 더 큰 금액 출금
```
public class AccountMain {
	public static void main(String[] args) {
		Account acc = new Account("111-111", "홍길동");
		acc.deposite(10000);
		try {
			acc.withdraw(19000);	// 예외부분을 try
		} catch (Exception e) {		// 예외 처리를 catch에 하였다
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
```
## 결과
```
홍길동님 계좌 개설 감사합니다. 잔액 : 0
10000원 예금하여 잔액 : 10000
잔액이 부족하여 인출 불가합니다  	// 예외 처리한 부분
```