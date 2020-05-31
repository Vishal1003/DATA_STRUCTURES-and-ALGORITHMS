package Dijkstra;

import java.util.*;

public class DijkstraUsingMinHeap {

	public static class Edge {
		int source;
		int destination;
		int cost;

		public Edge(int source, int destination, int cost) {
			this.source = source;
			this.destination = destination;
			this.cost = cost;
		}

	}

	public static class HeapNode {
		int vertex;
		int distance;
	}

	public static class Graph {
		int vertices;
		LinkedList<Edge>[] adj;

		public Graph(int vertices) {

			this.vertices = vertices;
			adj = new LinkedList[vertices];

			for (int i = 0; i < vertices; i++) {
				adj[i] = new LinkedList<Edge>();
			}
		}

		public void addEdge(int src, int dst, int cost) {
			Edge edge = new Edge(src, dst, cost);
			adj[src].addFirst(edge);

			edge = new Edge(dst, src, cost); // Non directed graphs
			adj[dst].addFirst(edge);
		}

		public void dijkstra(int srcVtx) {
			int infy = Integer.MAX_VALUE;
			boolean[] visited = new boolean[vertices];

			HeapNode[] heap = new HeapNode[vertices];
			for (int i = 0; i < vertices; i++) {
				heap[i] = new HeapNode();
				heap[i].vertex = i;
				heap[i].distance = infy;
			}

			heap[srcVtx].distance = 0;

			MinHeap minHeap = new MinHeap(vertices);
			for (int i = 0; i < vertices; i++) {
				minHeap.insert(heap[i]);
			}

			while (!minHeap.isEmpty()) {
				HeapNode extractedNode = minHeap.extractMin();

				int extractedVertex = extractedNode.vertex;
				visited[extractedVertex] = true;

				LinkedList<Edge> list = adj[extractedVertex];
				for (int i = 0; i < list.size(); i++) {
					Edge edge = list.get(i);
					int destination = edge.destination;

					if (visited[destination] == false) {

						int newKey = heap[extractedVertex].distance + edge.cost;
						int currentKey = heap[destination].distance;

						if (currentKey > newKey) {

							decreaseKey(minHeap, newKey, destination);
							heap[destination].distance = newKey;
						}
					}
				}
			}

			printDijkstra(heap, srcVtx);
		}

		public void decreaseKey(MinHeap minHeap, int newKey, int vertex) {

			int index = minHeap.indexes[vertex];

			HeapNode node = minHeap.mH[index];
			node.distance = newKey;
			minHeap.bubbleUp(index);
		}

		public void printDijkstra(HeapNode[] resultSet, int sourceVertex) {
			System.out.println("Dijkstra Algorithm: (Adjacency List + Min Heap)");
			System.out.println();
			for (int i = 0; i < vertices; i++) {
				System.out.println(
						"Source Vertex: " + sourceVertex + " to vertex " + +i + " distance: " + resultSet[i].distance);
			}
		}
	}

	static class MinHeap {
		int capacity;
		int currentSize;
		HeapNode[] mH;
		int[] indexes; // will be used to decrease the distance

		public MinHeap(int capacity) {
			this.capacity = capacity;
			mH = new HeapNode[capacity + 1];
			indexes = new int[capacity];
			mH[0] = new HeapNode();
			mH[0].distance = Integer.MIN_VALUE;
			mH[0].vertex = -1;
			currentSize = 0;
		}

		public void display() {
			for (int i = 0; i <= currentSize; i++) {
				System.out.println(" " + mH[i].vertex + "   distance   " + mH[i].distance);
			}
			System.out.println("________________________");
		}

		public void insert(HeapNode x) {
			currentSize++;
			int idx = currentSize;
			mH[idx] = x;
			indexes[x.vertex] = idx;
			bubbleUp(idx);
		}

		public void bubbleUp(int pos) {
			int parentIdx = pos / 2;
			int currentIdx = pos;
			while (currentIdx > 0 && mH[parentIdx].distance > mH[currentIdx].distance) {
				HeapNode currentNode = mH[currentIdx];
				HeapNode parentNode = mH[parentIdx];

				// swap the positions
				indexes[currentNode.vertex] = parentIdx;
				indexes[parentNode.vertex] = currentIdx;
				swap(currentIdx, parentIdx);
				currentIdx = parentIdx;
				parentIdx = parentIdx / 2;
			}
		}

		public HeapNode extractMin() {
			HeapNode min = mH[1];
			HeapNode lastNode = mH[currentSize];

			indexes[lastNode.vertex] = 1;
			mH[1] = lastNode;
			mH[currentSize] = null;
			sinkDown(1);
			currentSize--;
			return min;
		}

		public void sinkDown(int k) {
			int smallest = k;
			int leftChildIdx = 2 * k;
			int rightChildIdx = 2 * k + 1;
			if (leftChildIdx < heapSize() && mH[smallest].distance > mH[leftChildIdx].distance) {
				smallest = leftChildIdx;
			}
			if (rightChildIdx < heapSize() && mH[smallest].distance > mH[rightChildIdx].distance) {
				smallest = rightChildIdx;
			}
			if (smallest != k) {

				HeapNode smallestNode = mH[smallest];
				HeapNode kNode = mH[k];

				// swap the positions
				indexes[smallestNode.vertex] = k;
				indexes[kNode.vertex] = smallest;
				swap(k, smallest);
				sinkDown(smallest);
			}
		}

		public void swap(int a, int b) {
			HeapNode temp = mH[a];
			mH[a] = mH[b];
			mH[b] = temp;
		}

		public boolean isEmpty() {
			return currentSize == 0;
		}

		public int heapSize() {
			return currentSize;
		}
	}

	public static void main(String[] args) {
		int vertices = 6;
		Graph graph = new Graph(vertices);
		int sourceVertex = 0;
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(2, 3, 4);
		graph.addEdge(3, 4, 2);
		graph.addEdge(4, 5, 6);
		graph.dijkstra(sourceVertex);
	}

}
