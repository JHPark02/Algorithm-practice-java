// Stack 사용 구현
// 1 -> 8 -> 3 -> 5 -> 7 -> 4 -> 2 -> 6

import java.util.Stack;

public class DFS_Stack {

    public static void main(String args[]) {
        // 스택 선언
        Stack<Integer> stack = new Stack<>();

        int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};

        boolean[] visited = new boolean[9];

        // 시작 노드를 스택에 넣어줌
        stack.push(1);

        // 시작 노드 방문처리
        visited[1] = true;

        StringBuilder sb = new StringBuilder();

        // 스택이 비어있지 않으면 계속 반복
        while(!stack.isEmpty()) {
            // 스택에서 하나를 꺼냄
            int nodeIndex = stack.pop();

            sb.append(nodeIndex + " -> ");

            // 꺼낸 노드와 인접한 노드 찾기
            for (int LinkedNode : graph[nodeIndex]) {
                // 인접한 노드를 방문하지 않았을 경우에 스택에 넣고 방문처리
                if (!visited[LinkedNode]) {
                    stack.push(LinkedNode);
                    visited[LinkedNode] = true;
                }
            }
        }
        System.out.println(sb);
    }
}

