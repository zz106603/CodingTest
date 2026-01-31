package musinsa.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N20006 {
    static class Player{
        int level;
        String name;
        Player(int level, String name){
            this.level = level;
            this.name = name;
        }
    }
    static class Room{
        int baseLevel;
        List<Player> players = new ArrayList<>();
        Room(int baseLevel){
            this.baseLevel = baseLevel;
        }

        boolean canEnter(Player p, int m){
            if(players.size() >= m) return false;
            return p.level >= baseLevel - 10 && p.level <= baseLevel + 10;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            1. 입장 신청 시 매칭 가능한 방이 없으면 새로운 방을 생성하고 입장시킴.
            이때 해당 방에는 처음 입장한 플레이어의 레벨을 기준으로 -10부터 +10까지 입장 가능
            2. 입장 가능한 방이 있다면 입장시킨 후 방의 정원이 모두 찰 때까지 대기
            - 이때 입장이 가능한 방이 여러 개라면 먼저 생성된 방에 입장
            3. 방의 정원이 모두 차면 게임을 시작

            플레이어의 수 p
            플레이어의 닉네임 n
            플레이어의 레벨 l
            방 한개의 정원 m

            p, m
            l, n
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for(int i=0; i<p; i++){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            Player player = new Player(level, name);

            boolean match = false;
            for(Room room : rooms){
                if(room.canEnter(player, m)){
                    room.players.add(player);
                    match = true;
                    break;
                }
            }

            if(!match) {
                Room newRoom = new Room(player.level);
                newRoom.players.add(player);
                rooms.add(newRoom);
            }
        }

        for(Room r : rooms){
            if(r.players.size() == m) bw.write("Started!\n");
            else bw.write("Waiting!\n");

            List<Player> res = r.players;
            res.sort((a, b) -> a.name.compareTo(b.name));
            for(Player player : res){
                bw.write(player.level + " " + player.name + "\n");
            }

        }

        bw.close();

    }
}
