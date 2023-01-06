# ✨입출력이란
- Input/Output이라고 한다 
- Input : 파일 데이터를 읽는다. 키보드의 데이터를 읽는다. 네트워크상의 데이터를 읽는다(전송)
- Output :파일에 데이터를 쓴다. 모니터에 데이터를 쓴다(출력). 네트워크상에 데이터를 쓴다(전송)

# ✨Java에서의 파일입출력 API
- 1. InputStream : 1byte단위 입력 API. 이미지, 동영상 등의 데이터에 주로 사용
- 2. OutputStream : 1byte단위 출력 API. 이미지, 동영상 등의 데이터에 주로 사용
- 3. Reader : 2byte단위 입력 API. 문자열에 주로 사용
- 4. Writer : 2byte단위 출력 API. 문자열에 주로 사용
![](https://velog.velcdn.com/images/dkswndrnjs12/post/7d4982b5-4c86-4c6f-adef-ec3dc0d8289d/image.PNG)
- 5. DataInputStream / DataOutputStream
- 6. BufferedReader / BufferedWriter
- 7. PrintWriter

## InputStream 사용법
- InputStream(추상) 클래스를 상속받은 여러 가지 API 하위 클래스 중의 하나를 이용해서 객체를 만든다. 또는 다른 클래스의 메소드에서 반환(리턴)되는 타입 객체를 얻는다.
- read(), read(byte[]) 두 개의 메소드를 이용하여 데이터를 읽는다.
	- read() 1byte씩 읽는다. 속도가 느리다
	- read(byte[]) byte[]만큼씩 읽는다. 속도가 빠르다.
- 예외 처리와 무조건 close() 실행

## OutputStream 사용법
- OutputStream(추상) 클래스를 상속받은 여러가지 API 하위 클래스들 중의 하나를 이용해서 객체를 만든다. 또는 다른 클래스의 메소드에서 반환(리턴)되는 타입 객체를 얻는다.
- write()메소드를 이용해서 데이터를 읽으면 됩니다.
- write(int), write(byte[]), write(byte[], int, int)
- 예외 처리와 무조건 close() 실행

## 파일 읽고 쓰기
- 읽고, 쓰기를 동시에 – 파일 복사
- 파일을 읽고, 다른 파일에 쓰고, 결국은 파일 복사 입니다.
- 작업순서 : InputStream, OutputStream 준비 > is로 읽어들인 데이터를 os으로 씀 > 외부연결 close()함. 
- read() : read(), read(byte[]) 등 다양한 메소드 이용 가능
- write() : write(byte), write(byte[]), (write(byte[], int, int) 등 다양한 메소드 이용 가능
