package programmers.stackAndQueue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class N42583 {

    public static void main(String[] args) throws IOException {
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Truck> wTruck = new LinkedList<>();
        Queue<Truck> mTruck = new LinkedList<>();

        for(int truck : truck_weights){
            wTruck.add(new Truck(truck));
        }

        int answer = 0;
        int curWeight = 0;

        while(!wTruck.isEmpty() || !mTruck.isEmpty()){
            answer++;

            if(mTruck.isEmpty()){
                Truck t = wTruck.poll();
                curWeight += t.getWeight();
                mTruck.add(t);
                continue;
            }

            for(Truck t : mTruck){
                t.moving();
            }

            if(mTruck.peek().getMove() > bridge_length){
                Truck t = mTruck.poll();
                curWeight -= t.getWeight();
            }

            if(!wTruck.isEmpty() && (curWeight + wTruck.peek().getWeight()) <= weight){
                Truck t = wTruck.poll();
                curWeight += t.getWeight();
                mTruck.add(t);
            }
        }

        return answer;
    }
}

class Truck{
    int weight;
    int move;

    public Truck(int weight){
        this.weight = weight;
        this.move = 1;
    }

    public int getWeight(){
        return this.weight;
    }

    public int getMove(){
        return this.move;
    }

    public void moving(){
        move++;
    }
}