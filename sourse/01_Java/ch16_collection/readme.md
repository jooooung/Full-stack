# ✨Collection이란
- 쉽게 말해서 자료구조, 다수의 데이터 즉 데이터그룹을 의미한다.
- 다수의 데이터를 쉽게 처리할 수 있는 방법(메소드)를 제공하는 API

# ✨자바에서 제공되는 Collection 자료구조들
||Collection||
|--|--|--|
|**List(순서, 중복 허용)**|**Set(순서X, 중복X)**|**Map(key, value)**|
|ArrayList|HashSet|HashMap|
|Vector|TreeSet|Properties|
|LinkedList|||

![](https://velog.velcdn.com/images/dkswndrnjs12/post/8df1a172-21f2-4bbc-82e0-ffd0f18fa329/image.PNG)


## List계열 Collection(자주 쓰이는 것들)
### ArrayList 
- 배열과 매우 비슷. 인덱스가 존재하며 데이터는 중복을 허용. 인덱스가 가장 중요
```
add(객체)
add(index, 객체)
set(index, 객체)
get(index)
size()
remove(index)
remove(객체)
contains(객체) 주어진 객체가 저장되어 있는지 여부를 boolean 값으로 반환
isEmpty()
clear()
```
### LinkedList
- ArrayList와 거의 비슷하다.
- 읽어오는 시간은 빠르나 데이터 추가, 삭제가 오래 걸린다
- 차적으로 데이터를 추가/삭제할 경우 ArrayList가 빠르고 비순차적으로 데이터를 추가/삭제하는 경우 LinkedList가 빠르다. 
- 접근시간도 ArrayList가 빠르다

## Map 계열 Collection
- Map계열의 자료구조는 인덱스 대신 키 값으로 데이터를 액세스
- 인덱스 X, key와 값만 있다. key는 유니크해야 한다


## Set 계열 Collection
- Set계열 자료구조에서는 데이터의 순서가 없다(인덱스 X).   
하지만 중복된 데이터 X.
- 중복된 데이터의 의미는 hashcode()값이 같거나 equal()메소드의 결과값에 의해 해석
