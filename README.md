### 사이트

- 프로그래머스 https://programmers.co.kr/
- 백준 https://www.acmicpc.net/
- 소프티어 https://softeer.ai/practice
- 문제 추천 https://github.com/tony9402/baekjoon/blob/main/picked.md

### 코딩 테스트 유형

- 구현
- BFS/DFS
- 그리디
- 정렬
- 다이나믹 프로그래밍
- 이진 탐색
- 최단 경로
- 그래프 이론
---
### 문법 등 정리

- Map Value 조작
```java
Map<String, Integer> map = new HashMap<>();

// ex) a : 2, b : 1

return map.values().stream()
    .map(count -> count + 1)        // value값에 1을 더해줌
    .reduce(1, (a, b) -> a * b);    // 1로 시작해서 값들을 전부 곱해줌
```
- `int[]` 배열을 `Integer[]`, `List<Integer>`로 변환
```java
int[] arr;

Integer[] boxedArr = Arrays.stream(arr)
    .boxed
    .toArray(Integer::new);
    
// collect를 쓰는 방식은 Java 11에서
// Java 16이상에서는 바로 toList() 가능
// ex) .boxed.toList(); -> 하지만, 이 경우에는 수정 불가능(add, remove)
List<Integer> boxedList = Arrays.stream(arr)
    .boxed
    .collect(Collectors.toList());
    
// 정렬
Arrays.sort(boxed, Collections.reverseOrder());
boxedList.sort(Collections.reverseOrder());
```

- `List<Integer> list`에서 subList를 뽑는 방법
```java
List<Integer> subList = list.stream()
        .filter(p -> p < K)
        .toList(); // 이건 자바 16 이상 -> 수정 불가능
        // .collect(Collectors.toList()); 이건 자바 11
```

- Map에서 Value값으로 정렬하는 방법
```java
Map<String, Integer> map = new HashMap<>();
// map.put..

List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

// 오름차순
list.sort(Comparator.comparingInt(Map.Entry::getValue));
// 내림차순
list.sort(Comparator.comparingInt(Map.Entry<String, Integer>::getValue).reversed();
```
- Set에서 교집합 구하는 방법
```java
Set<Integer> aSet = new HashSet<>(List.of(1, 2, 4));
Set<integer> bSet = new HashSet<>(List.of(2, 3, 4, 5, 6));

Set<Integer> intersection = new HashSet<>(aSet); // aSet을 변경하지 않고 복사해서 사용
intersection.retainAll(bSet); // {2, 4};

// 대칭 차집합을 구하려면 aSet size + bSet size - 2*intersection size
// 2를 곱한 이유는 교집합을 aSet, bSet에서 다 제거해줘야 함
```
- 조합 개수 구하는 방법
```java
BigInteger res = BigInteger.ONE;
// nCm = n * (n-1) * (n-2) * ... * (n-m+1) / (1 * 2 * 3 * ... * m)
for(int i=0; i<m; i++){
    res = BigInteger.multiply(BigInteger.valueOf(n - i));
    res = BigInteger.divide(BigInteger.valueOf(i + 1));
}
return res;
```
- MM:SS 형식 계산 방법
```java
String s = "23:10";
int s = toSec(s);
public static int toSec(String s){
    return Integer.parseInt(s.split(":")[0])*60 + Integer.parseInt(s.split(":")[1]);
}
```
- 소인수분해
```java
int N = 72;
for(int i=2; i*i<=N; i++){ // √N보다 작거나 같다
    while(N % i == 0){
        System.out.println(i);
        N /= i;
    }    
}
if(N > 1) System.out.println(N);
```

- kruskal 알고리즘
```java
static int find(int x){ // 그룹을 찾는다
    if(parent[x] == x) return x;
    return parent[x] = find(parent[x]);
}

static void union(int a, int b){
    a = find(a);
    b = find(b);
    if(a != b) parent[b] = a; // 사이클이 연결되어 있지 않으면 그룹으로 연결한다
}
```