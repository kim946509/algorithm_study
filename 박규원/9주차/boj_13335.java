import java.io.*;
import java.util.*;

class Main {
    public static class Truck{
        int truck_idx;
        int truck_weight;
        int going_distance;

        public Truck(int truck_idx, int truck_weight, int going_distance){
            this.truck_idx = truck_idx;
            this.truck_weight = truck_weight;
            this.going_distance = going_distance;
        }

        public int getTruckIdx(){
            return this.truck_idx;
        }

        public int getTruckWeight(){
            return this.truck_weight;
        }
        
        public int getGoingDistance(){
            return this.going_distance;
        }

        public void setGoingDistance(int going_distance){
            this.going_distance = going_distance;
        }
    }

    public static Deque<Truck> truck = new ArrayDeque<>();
    public static Deque<Truck> bridge = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //트럭의 수
        int w = Integer.parseInt(st.nextToken()); //다리의 길이
        int l = Integer.parseInt(st.nextToken()); //다리의 최대 하중

        int total_time=0;

        st = new StringTokenizer(br.readLine()); //트럭들 입력받기

        for(int i=0;i<n;i++){
            truck.offer(new Truck(i, Integer.parseInt(st.nextToken()), 0));
        }

        while(!truck.isEmpty() || !bridge.isEmpty()){
            oneStep(w); //다리에 있는 차들이 이동
            Truck t;

            try{
                t = truck.poll();
                bridge.offer(new Truck(t.getTruckIdx(),t.getTruckWeight(), t.getGoingDistance()+1));
            }catch(Exception e){
                total_time++;
                continue;                
            }
            
            if(bridge.size() > w || getBridgeSum()>l) {
                truck.offerFirst(new Truck(t.getTruckIdx(),t.getTruckWeight(), t.getGoingDistance()));
                bridge.pollLast();
            }
            
            total_time++;
        }

        System.out.println(total_time);
    }

    public static int getBridgeSum(){
        int sum = 0;
        for(Truck t : bridge){
            sum+=t.getTruckWeight();
        }

        return sum;
    }

    public static void oneStep(int w){
        if(bridge.isEmpty()) return;

        for(Truck t : bridge){
            if(t.getGoingDistance()+1 > w){
                bridge.poll();
                continue;
            }
            t.setGoingDistance(t.getGoingDistance()+1);
        }
    }
}