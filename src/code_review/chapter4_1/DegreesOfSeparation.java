package code_review.chapter4_1;

import edu.princeton.cs.algs4.StdIn;

public class DegreesOfSeparation {
    public static void main(String[] args) {
        //arg[0]表示输入流，arg[1]表示分隔符
        //arg[2]表示起点，arg[3]表示终点
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);

        Graph G = sg.G();
        //starting point
        String source = args[2];
        if (!sg.contains(source)) {
            System.out.println(source + " not in database.");
            return;
        }
        int s = sg.index(source);
        BreadthFirstPaths<Graph> bfs = new BreadthFirstPaths<>(G, s);
        while (!StdIn.isEmpty()) {
            //terminal point
            String sink = StdIn.readLine();
            if (sg.contains(sink)) {
                int t = sg.index(sink);
                if (bfs.hasPathTo(t))
                    for (int v : bfs.pathTo(t))
                        System.out.println("    " + sg.name(v));
                else System.out.println("not connected");
            } else System.out.println("Not in database");
        }
    }
}
