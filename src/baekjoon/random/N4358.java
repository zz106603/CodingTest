package baekjoon.random;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class N4358 {
    /*
        각 종이 전체에서 몇 %를 차지하는지 구해야 함
        한 줄에 하나의 종(이름은 <30 입력에는 최대 10,000, 최대 1,000,000그루의 나무가 주어짐

        이름을 사전 순으로 출력, 비율을 백분률로 소수점 4째자리까지 반올림

        **여기서 중요한 부분

        - 현재 TreeMap을 사용해서 Key값이 자동으로 정렬되도록 문제를 해결함
        - Key값이 아니라 Value값이라면?

        Map<String, Integer> map = new HashMap<>();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // 오름차순
        list.sort(Comparator.compareingInt(Map.Entry::getValue));
        // 내림차순
        list.sort(Comparator.compareingInt(Map.Entry<String, Integer>::getValue).reversed());

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> treeMap = new TreeMap<>();
        int total = 0;

        String input;
        while((input = br.readLine()) != null && !input.isEmpty()){
            treeMap.put(input, treeMap.getOrDefault(input, 0) + 1);
            total++;
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : treeMap.entrySet()){
            double percentage = (double)entry.getValue() / total * 100;
            sb.append(entry.getKey())
                    .append(" ")
                    .append(String.format("%.4f", percentage))
                    .append("\n");
        }

        System.out.println(sb.toString());

        // Value값으로 내림차순 연습
        List<Map.Entry<String, Integer>> list = new ArrayList<>(treeMap.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry<String, Integer>::getValue).reversed());

        System.out.println();
        for(Map.Entry<String, Integer> entry : list){
            double percent = (double)entry.getValue() / total * 100;
            System.out.println(entry.getKey() + " " + String.format("%.4f", percent));
        }
    }
}
