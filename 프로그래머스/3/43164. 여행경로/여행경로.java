import java.util.*;

public class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(String[] ticket : tickets){
            String from = ticket[0];
            String to = ticket[1];

            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        Deque<String> stack = new ArrayDeque<>();
        LinkedList<String> route = new LinkedList<>();

        stack.push("ICN");

        while(!stack.isEmpty()){
            String curr = stack.peek();

            PriorityQueue<String> next = graph.get(curr);

            if(next != null && !next.isEmpty()){
                stack.push(next.poll());
            }else{
                route.addFirst(stack.pop());
            }
        }

        return route.toArray(new String[0]);
    }
}
