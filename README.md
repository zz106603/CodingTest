### 사이트

- 프로그래머스 https://programmers.co.kr/
- 백준 https://www.acmicpc.net/
- 소프티어 https://softeer.ai/practice

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
    
List<Integer> boxedList = Arrays.stream(arr)
    .boxed
    .collect(Collectors.toList());
    
// 정렬
Arrays.sort(boxed, Collections.reverseOrder());
boxedList.sort(Collections.reverseOrder());
```

