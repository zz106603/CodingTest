package programmers.random;

public class N84512 {

    static int answer = 0;
    static boolean found = false;
    static String[] alp = {"A", "E", "I", "O", "U"};

    public static void main(String[] args) {
        String word = "AAAAE";

        permute(word, "");

        System.out.println(answer);
    }

    public static void permute(String word, String current){
        // 정답을 찾았으면 그 이후의 재귀는 필요없기 때문에 바로 return
        if(found) return;

        if(!current.isEmpty()){
            answer++;
            if(word.equals(current)){
                found = true;
                return;
            }
        }

        for(String a : alp){
            if(current.length() < 5){
                permute(word, current + a);
            }
        }
    }
}
