// 재귀 형태로 구현
// 인접행렬 사용 

public class DFS_Recursion_Adjacency {

    public static String dfs(int nodeIndex, int[][] graph, boolean[] visited, StringBuilder sb) {
        // 방문 처리
        visited[nodeIndex] = true;

        sb.append(nodeIndex + " -> ");
        
        for (int j = 1; j < graph.length; j++) {
            // 인접한 노드가 방문한 적이 없다면 DFS 수행
            if (graph[nodeIndex][j] == 1 && !visited[j]) dfs(j, graph, visited, sb);
        }

        return sb.toString();
    }  
    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder();

        int[][] graph = {
            {}, 
            {0, 0, 1, 1, 0, 0, 0 ,0, 1}, 
            {0, 1, 0, 0, 0, 0, 1 ,0, 1},
            {0, 1, 0, 0, 0, 1, 0 ,0, 0},
            {0, 0, 0, 0, 0, 1, 0 ,1, 0},
            {0, 0, 0, 1, 1, 0, 0 ,1, 0},
            {0, 0, 1, 0, 0, 0, 0 ,0, 0},
            {0, 0, 0, 0, 1, 1, 0 ,0, 0},
            {0, 1, 1, 0, 0, 0, 0 ,0, 0}
        };
        // 방문 처리에 사용할 배열        
        boolean[] visited = new boolean[9];

        String temp = dfs(1, graph, visited, sb);

        System.out.println(temp);
    }
}

