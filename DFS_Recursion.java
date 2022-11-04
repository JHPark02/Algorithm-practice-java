// 재귀 형태로 구현

public class DFS_Recursion {

    public static String dfs(int nodeIndex, int[][] graph, boolean[] visited, StringBuilder sb) {
        // 방문 처리
        visited[nodeIndex] = true;

        sb.append(nodeIndex + " -> ");
        
        for (int node : graph[nodeIndex]) {
            // 인접한 노드가 방문한 적이 없다면 DFS 수행
            if (!visited[node]) dfs(node, graph, visited, sb);
        }

        return sb.toString();
    }  
    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder();

        int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5},{1, 2}};
        // 방문 처리에 사용할 배열        
        boolean[] visited = new boolean[9];

        String temp = dfs(1, graph, visited, sb);
        String result = temp.substring(0, temp.length() - 3);

        System.out.println(result);
    }
}

