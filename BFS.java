import java.util.LinkedList;
import java.util.Queue;

// https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FI51d1%2Fbtq2hDQLzXH%2FSkFfnHHH591QE3XpUKvLAk%2Fimg.png

public class BFS {

    /*
     * start : BFS를 시작할 노드 번호
     * 
     * 큐 메소드
     *  add(), offer() 값 추가
     *  poll() queue의 첫번째 값을 반환하고 제거
     *  remove() queue의 첫번째 값 제거
     *  clear() queue 초기화
     */
    public static String bfs(int start, int[][] graph, boolean[] visited) {
        // 탐색 순서를 출력하기 위한 용도
        StringBuilder sb = new StringBuilder();
        // BFS에 사용할 큐
        Queue<Integer> queue = new LinkedList<Integer>();

        // 큐에 BFS를 시작할 노드 번호를 넣어줌
        queue.offer(start);

        // 시작 노드 방문처리
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            int nodeIndex = queue.poll();
            sb.append(nodeIndex + " -> ");

            // 큐에서 꺼낸 노드와 연결된 노드들 체크
            // start가 1이면, 2, 3, 8 체크
            for (int i = 0; i < graph[nodeIndex].length; i++) {
                int temp = graph[nodeIndex][i];
                // 방문하지 않았으면 방문처리 후 큐에 넣기
                if(!visited[temp]) {
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
        }

        // 탐색순서 리턴
        return sb.toString();
    }

    public static void main(String args[]) {
        // 그래프를 2차원 배열로 표현
        // 1번 인덱스는 1번노드에 연결되어 있는 노드, 노드의 배열의 값은 연결된 노드
        int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};

        // 방문처리를 위한 배열
        boolean[] visited = new boolean[9];

        System.out.println(bfs(1, graph, visited));
    }
}