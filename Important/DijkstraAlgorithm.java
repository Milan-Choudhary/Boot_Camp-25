package Important;

import java.util.*;

public class DijkstraAlgorithm {

    // Represents (node, currentDistance)
    static class NodeDistance {
        int node;
        int distance;

        NodeDistance(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {

        int numberOfVertices = 3;

        int[][] edges = {
                {0, 1, 1},
                {1, 2, 3},
                {0, 2, 6}
        };

        int sourceNode = 2;

        // Adjacency List: graph[u] = list of (v, weight)
        List<List<NodeDistance>> graph = new ArrayList<>();

        for (int i = 0; i < numberOfVertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            graph.get(from).add(new NodeDistance(to, weight));
            graph.get(to).add(new NodeDistance(from, weight)); // undirected
        }

        // Distance array: shortest distance from sourceNode to every node
        int[] shortestDistance = new int[numberOfVertices];
        Arrays.fill(shortestDistance, Integer.MAX_VALUE);
        shortestDistance[sourceNode] = 0;

        // Min-Heap based on distance
        PriorityQueue<NodeDistance> minHeap =
                new PriorityQueue<>((a, b) -> a.distance - b.distance);

        minHeap.add(new NodeDistance(sourceNode, 0));

        // Dijkstra's Algorithm
        while (!minHeap.isEmpty()) {

            NodeDistance current = minHeap.poll();
            int currentNode = current.node;
            int currentDistance = current.distance;

            // Skip outdated entries
            if (currentDistance > shortestDistance[currentNode]) {
                continue;
            }

            // Explore neighbors
            for (NodeDistance neighbor : graph.get(currentNode)) {

                int adjacentNode = neighbor.node;
                int edgeWeight = neighbor.distance;

                int newDistance = shortestDistance[currentNode] + edgeWeight;

                if (newDistance < shortestDistance[adjacentNode]) {
                    shortestDistance[adjacentNode] = newDistance;
                    minHeap.add(new NodeDistance(adjacentNode, newDistance));
                }
            }
        }

        // Output result
        System.out.println("Shortest distances from source node " + sourceNode + ":");
        for (int node = 0; node < numberOfVertices; node++) {
            System.out.println("Node " + node + " -> " + shortestDistance[node]);
        }
    }
}
