# 메소드
- 메소드란? 작업을 수행하기 위한 명령문의 집합
메소드의 작성 예시
```
접근제한자 [static] 리턴type 메소드명([매개변수1, 매개변수2,..]){ 
//return이 없을 경우 리턴type은 void
	처리할 프로세스들
	[return 리턴값;]
}
```
1. 매개변수 없는 메소드  
() 안에 매개변수가 없는 ```printCh``` 메소드
```
   private static void printCh(){
	for(int cnt=1 ; cnt<=20 ; cnt++)
		System.out.print('*');
	System.out.println();
    }
}
```

2. 매개변수 있는 메소드  
```char ch, int i```를 매개변수로 갖는 ```printCh``` 메소드
```
static void printCh(char ch, int i){
		for(int cnt=1 ; cnt<=i ; cnt++)
			System.out.print(ch);
		System.out.println();
    }
```
3. Return값을 갖는 함수  
```result``` 를 ```return```값으로 갖는다
```
static int abs(int in){
		int result = (in<0)? -in : in;
		return result;
	}
```