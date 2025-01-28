package Practice.Graphs;
import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Edge>> graph = new HashMap();

        for(int i=0; i<equations.size(); i++){
            List<String> l = equations.get(i);
            String u = l.get(0);
            String v = l.get(1);

            List<Edge> edges = graph.computeIfAbsent(u, key -> new ArrayList<>());
            edges.add(new Edge(u,v,values[i]));


        }
        return new double[]{1.0};
    }

    class Edge{
        String u;
        String v;
        double val;
        Edge(String u, String v,double val){
            this.u = u;
            this.v = v;
            this.val = val;
        }
    }
}
