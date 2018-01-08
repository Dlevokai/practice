import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CTCI_8_2_RobotGraph {

    class Point{
        private int r;
        private int c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (r != point.r) return false;
            return c == point.c;
        }

        @Override
        public int hashCode() {
            int result = r;
            result = 31 * result + c;
            return result;
        }
    }

    List getPath(Boolean[][] graph){
        List<Point> path = new ArrayList<>();
        if(isPath(0, 0, path, graph, new HashSet<Point>())){
            Collections.reverse(path);
            return path;
        } else{
            return null;
        }
    }

    private boolean isPath(int r, int c, List<Point> path, Boolean[][] graph, HashSet<Point> dontGo) {

        if(r == graph.length || c == graph[0].length || !graph[r][c] || dontGo.contains(new Point(r,c))){
            return false;
        }

        if(r == graph.length -1 && c == graph[0].length-1){
            return true;
        }

        boolean down = isPath(r+1, c, path, graph, dontGo);
        if(down){
            path.add(new Point(r+1, c));
            return true;
        } else{
            dontGo.add(new Point(r+1, c));
        }

        boolean right = isPath(r, c+1, path, graph, dontGo);
        if(right){
            path.add(new Point(r, c+1));
            return true;
        }else{
            dontGo.add(new Point(r, c+1));
        }
        return false;
    }

    @Test
    public void testGraph(){
        Boolean[][] graph = new Boolean[3][3];
        graph[0][0] = true;
        graph[1][0] = false;
        graph[2][0] = true;
        graph[0][1] = true;
        graph[1][1] = false;
        graph[2][1] = true;
        graph[0][2] = true;
        graph[1][2] = true;
        graph[2][2] = true;

        List<Point> ans = getPath(graph);


    }
}
