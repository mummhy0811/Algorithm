import java.io.*;
import java.util.*;
class IntStack {
    private int[] arr;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public IntStack() {
        arr = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(int element) {
        ensureCapacity();
        arr[size++] = element;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[--size];
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, size * 2);
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        List<Integer>[] arr = new ArrayList[n+1];

        for(int i=0;i<=n;i++) arr[i]=new ArrayList<>();

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            arr[num1].add(num2);
            arr[num2].add(num1);
        }
        for(int i=0;i<=n;i++) Collections.sort(arr[i]);


        //DFS
        boolean[] checkVisit = new boolean[n+1];
        dfs(v, arr, checkVisit, bw);
        bw.write("\n");
        bfs(v, arr, checkVisit, bw);

        bw.flush();
        bw.close();
    }
    private static void dfs(int v, List<Integer>[] arr, boolean[] checkVisit, BufferedWriter bw) throws IOException {
        IntStack stack = new IntStack();

        stack.add(v);
        checkVisit[v]=true;
        bw.write(v + " ");

        while (!stack.isEmpty()) {
            int now = stack.peek();
            boolean found = false;

            for (int node : arr[now]) {
                if (!checkVisit[node]) {
                    stack.add(node);
                    bw.write(node + " ");
                    checkVisit[node] = true;
                    found = true;
                    break;
                }
            }

            if (!found) stack.pop();
        }
    }

    private static void bfs(int v, List<Integer>[] arr, boolean[] checkVisit, BufferedWriter bw) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        int now;
        Arrays.fill(checkVisit, false);
        queue.add(v);
        checkVisit[v]=true;
        while(!queue.isEmpty()){
            now = queue.poll();
            bw.write(now+" ");
            for (int node2 : arr[now]) {
                if (!checkVisit[node2]) {
                    queue.add(node2);
                    checkVisit[node2]=true;
                }
            }
        }
    }
}