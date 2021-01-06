import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 06/Jan/2021 to Depth-First-Search
 */
public class dfs {

    static class Edge{
        int from, to, cost;

        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static long depthFirstSearch(int at, boolean visited[], Map<Integer, List<Edge>> graph){
        if(visited[at]){
            return 0L;
        }

        visited[at] = true;
        long count = 1;

        List<Edge> edges = graph.get(at);
        if(edges != null){
            for(Edge edge : edges){
                count = count + depthFirstSearch(edge.to, visited, graph);
            }
        }
        System.out.println(at);
        return count;
    }

    public static void main(String args[]){
        int numNodes = 5;

        Map<Integer, List<Edge>> graph = new HashMap<>();
        addDirectedEdge(graph, 0, 1, 4);
        addDirectedEdge(graph, 0, 2, 5);
        addDirectedEdge(graph, 1, 2, -2);
        addDirectedEdge(graph, 1, 3, 6);
        addDirectedEdge(graph, 2, 3, 1);
        addDirectedEdge(graph, 2, 2, 10);

        long nodeCount = depthFirstSearch(0, new boolean[numNodes], graph);
        System.out.println("DFS node count starting at node 0: " + nodeCount);
    }

    //Helper Method
    private static void addDirectedEdge(Map<Integer, List<Edge>> graph, int from, int to, int cost){
        List<Edge> list = graph.get(from);
        if(list == null){
            list = new ArrayList<Edge>();
            graph.put(from, list);
        }
        list.add(new Edge(from, to, cost));
    }

}
