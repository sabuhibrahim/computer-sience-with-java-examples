package com.cs.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;



public class Graph {
    private Map<Vertex, List<Vertex>> nodes;

    public Graph() {
        this.nodes = new HashMap<Vertex, List<Vertex>>();
    }

    private class Vertex {
        String label;
        private int hashCode;

        Vertex(String label) {
            this.label = label;
            this.hashCode = Objects.hash(label);
        }

        @Override
        public String toString() {
            return "[ Vertex ] " + this.label;
        }

        @Override
        public boolean equals(Object object) {
            if(this == object) return true;
            if(object == null) return false;
            if (getClass() != object.getClass()) return false;

            Vertex vertex = (Vertex) object;
            
            return this.label.equals(vertex.label);
        }

        @Override
        public int hashCode() {
            return this.hashCode;
        }
    }

    public void addVertex(String label) {
        nodes.putIfAbsent(new Vertex(label), new ArrayList<Vertex>());
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        nodes.values().stream().forEach(e -> e.remove(v));
        nodes.remove(new Vertex(label));
    }

    public void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        nodes.get(v1).add(v2);
        nodes.get(v2).add(v1);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = nodes.get(v1);
        List<Vertex> eV2 = nodes.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    public List<Vertex> getnodes(String label) {
        return nodes.get(new Vertex(label));
    }

    public Set<String> depthFirstTraversal(String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);

        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : getnodes(vertex)) {
                    stack.push(v.label);
                }
            }
        }

        return visited;
    }

    public Set<String> breadthFirstTraversal(String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : getnodes(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }

        return visited;
    }

    public String toString() {
        return "[ Graph ] " + nodes.toString();
    }
}
