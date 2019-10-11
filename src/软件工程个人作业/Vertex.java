package 软件工程个人作业;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    public final String name;
    public ArrayList<Vertex> neighbour=new ArrayList<Vertex>();
    public ArrayList<String> line=new ArrayList<String>();
    private int adjuDist;
    private Vertex parent;
	private boolean known=false;
    public int getAdjuDist() {
		return adjuDist;
	}
	public void setAdjuDist(int adjuDist) {
		this.adjuDist = adjuDist;
	}
	public Vertex getParent() {
		return parent;
	}
	public void setParent(Vertex parent) {
		this.parent = parent;
	}
	public boolean isKnown() {
		return known;
	}
	public void setKnown(boolean known) {
		this.known = known;
	}
    public Vertex(String name){
		this.name = name;
	}
    public String toName(){
		return name;
	}
}
