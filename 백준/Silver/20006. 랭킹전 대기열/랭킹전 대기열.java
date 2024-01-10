import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static List<Room> rooms = new ArrayList<>();
    public static int m;

    public static class Player implements Comparable<Player>{
        int level;
        String nickname;

        public Player(int l, String n){
            this.level = l;
            this.nickname = n;
        }

        @Override
        public int compareTo(Player p) {
            return this.nickname.compareTo(p.nickname);
        }
    }

    public static class Room{
        int level;
        List<Player> players;

        public Room(int level, Player p) {
            this.level = level;
            players = new ArrayList<>();
            addPlayer(p);
        }

        public void addPlayer(Player p){
            players.add(p);
        }
        private void printPlayers(){
            if(players.size()==m) System.out.println("Started!");
            else System.out.println("Waiting!");
            Collections.sort(players);
            players.forEach(player -> System.out.println(player.level +" "+player.nickname));
        }

        public boolean canEnter(int level){
            return Math.abs(this.level-level)<=10 && players.size()<m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0;i<p;i++){
            st = new StringTokenizer(br.readLine());
            Player player = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
            enterOrCreateRoom(player);
        }
        rooms.forEach(Room::printPlayers);
    }
    public static void enterOrCreateRoom(Player p){
        for (Room room : rooms) {
            if (room.canEnter(p.level)) {
                room.addPlayer(p);
                return;
            }
        }
        rooms.add(new Room(p.level, p));
    }
}