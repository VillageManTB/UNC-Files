package graph;


import minBinHeap.MinBinaryHeap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {
    private Map<String, Vertex> _vertices;
    private List<List<String>> _data;


    public Graph(String fileName) {
        _vertices = new HashMap<>();
        createGraph(fileName);
    }
    public Graph() {
        _vertices = new HashMap<>();
    }


    public double calculateWeight(int distance, int traffic, int scenery, int attractions) {
        return (double) traffic + scenery*(distance) + attractions;
    }

    public Map<String, Double> dijkstra(Vertex start) {
        Map<String, Double> newMap = new HashMap();
        newMap.put(start.getLabel(),0.0);
        MinBinaryHeap<Vertex, Double> PQueue = new MinBinaryHeap<>();
        PQueue.enqueue(start, 0.0);
        List known = new LinkedList();
        while (PQueue.size() != 0) {
            String value = PQueue.getMinValue().getLabel();
            Vertex value2 = PQueue.getMinValue();
            double distance = PQueue.getMinValue().getDistanceFromSource();
            PQueue.dequeue();
            if (known.contains(value)) {
                continue;
            } else {
                known.add(value);
                newMap.put(value, distance);
                List<Edge> outbound_edges = value2.getEdges();
                for (int i=0; i<outbound_edges.size(); i++) {
                    if (outbound_edges.get(i).getDestination().getDistanceFromSource() == 0.0) {
                        outbound_edges.get(i).getDestination().setDistanceFromSource(Double.MAX_VALUE);
                    }
                    String part = outbound_edges.get(i).getDestination().getLabel();
                    if (!known.contains(outbound_edges.get(i).getDestination().getLabel())) {
                        if (outbound_edges.get(i).getDestination().getDistanceFromSource() > (distance + outbound_edges.get(i).getWeight())) {
                            outbound_edges.get(i).getDestination().setDistanceFromSource(distance + outbound_edges.get(i).getWeight());
                            PQueue.enqueue(outbound_edges.get(i).getDestination(),distance + outbound_edges.get(i).getWeight());
                        } else {
                            PQueue.enqueue(outbound_edges.get(i).getDestination(), outbound_edges.get(i).getWeight());
                        }
                    }
                }
            }
        }
        return newMap;
    }

    // Do not edit anything below

    /*
    reads through each entry in csv and calls readLine to create edges and vertices.
     */
    public void createGraph(String fileName) {
        readCSV(fileName);
        for(List<String> list: _data) {
            readLine(list.get(0), list.get(1), Integer.parseInt(list.get(2)), Integer.parseInt(list.get(3))
                    , Integer.parseInt(list.get(4)), Integer.parseInt(list.get(5)));
        }
    }
    /*
    reads through each line of csv and puts data into an ArrayList
     */
    public void readCSV(String fileName) {
        _data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String header = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                _data.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    converts one entry of data into vertices and edges
     */
    public void readLine(String src, String dest, int distance, int traffic, int scenery, int attractions) {
        // find source and destination nodes, if they don't exist, create them
        Vertex source = _vertices.get(src);
        if(source == null)
            source = new VertexImpl(src);
        Vertex destination = _vertices.get(dest);
        if(destination == null)
            destination = new VertexImpl(dest);

        // calculate weight of edge
        double weight = calculateWeight(distance, traffic, scenery, attractions);

        //create edge
        Edge e = new EdgeImpl(source, destination, weight);
        source.addEdge(e);

        //add reverse direction edge
        e = new EdgeImpl(destination, source, weight);
        destination.addEdge(e);

        //add to graph
        _vertices.put(src, source);
        _vertices.put(dest, destination);

    }

    public Map<String, Vertex> getVertices() {
        return _vertices;
    }





}
