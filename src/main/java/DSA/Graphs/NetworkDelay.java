package DSA.Graphs;

import java.util.*;

public class NetworkDelay {

    public int networkDelayTime(int[][] times, int n, int k) {

        // Build adjacency list
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            map.computeIfAbsent(time[0], x -> new ArrayList<>()).add(time);
        }

        // Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // PriorityQueue: {node, current distance}
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[]{k, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0], d = cur[1];

            if (d > dist[node]) continue; // stale entry, skip

            if (map.containsKey(node)) {
                for (int[] edge : map.get(node)) {
                    int nei = edge[1], w = edge[2];
                    int newDist = dist[node] + w;
                    if (newDist < dist[nei]) {
                        dist[nei] = newDist;
                        q.offer(new int[]{nei, newDist});
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }

    public static void main(String[] args){
        NetworkDelay n = new NetworkDelay();
        int[][] times = new int[][] {{1,2,1},{2,3,2},{1,3,4}};

        n.networkDelayTime(times, 3, 1);
    }
}
