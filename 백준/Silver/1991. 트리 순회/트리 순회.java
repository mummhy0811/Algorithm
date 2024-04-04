import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        String symbol;
        Node left;
        Node right;
        public Node(String s){
            this.symbol=s;
        }

        void setLeft(Node l){
            this.left=l;
        }
        void setRight(Node r){
            this.right=r;
        }
    }
    static void preOrder(Node n) throws IOException {
        bw.write(n.symbol+"");
        if(n.left!=null) preOrder(n.left);
        if(n.right!=null) preOrder(n.right);
    }
    static void inOrder(Node n) throws IOException {
        if(n.left!=null) inOrder(n.left);
        bw.write(n.symbol+"");
        if(n.right!=null) inOrder(n.right);
    }
    static void postOrder(Node n) throws IOException {
        if(n.left!=null) postOrder(n.left);
        if(n.right!=null) postOrder(n.right);
        bw.write(n.symbol+"");
    }
    static TreeMap<String, Node> tree;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        int n = Integer.parseInt(br.readLine());
        tree = new TreeMap<>();
        tree.put("A", new Node("A"));
        do{
            st = new StringTokenizer(br.readLine());
            String p = st.nextToken();;
            String l = st.nextToken();
            String r = st.nextToken();
            Node root = tree.get(p);

            if(!l.equals(".")) {
                Node node = new Node(l);
                tree.put(l, node);
                root.setLeft(node);
            }
            if(!r.equals(".")) {
                Node node = new Node(r);
                tree.put(r, node);
                assert root != null;
                root.setRight(node);
            }
            n--;
        }while(n>0);
        preOrder(tree.get("A"));
        bw.write("\n");
        inOrder(tree.get("A"));
        bw.write("\n");
        postOrder(tree.get("A"));
        bw.flush();
        bw.close();
    }
}