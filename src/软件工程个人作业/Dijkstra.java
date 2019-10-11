package 软件工程个人作业;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import 软件工程个人作业.Vertex;



public class Dijkstra {
	 public void setRoot(Vertex v)
	    {
	        v.setParent(null);
	        v.setAdjuDist(0);   
	    }
	public ArrayList<Vertex> dijkstraTravasal(ArrayList<Vertex> station,String vertex1,String vertex2) {
		String g=vertex2;
		ArrayList<Vertex> path = new ArrayList<Vertex>();
		Vertex v1=new Vertex(vertex1);
		Vertex v2=new Vertex(vertex2);
	    for(int b=0;b<station.size();b++) {
    	if(station.get(b).name.equals(vertex1)) {
    		v1=station.get(b);
    	}
    }
	    for(int b=0;b<station.size();b++) {
	    	if(station.get(b).name.equals(vertex2)) {
	    		v2=station.get(b);
	    	}
	    }
	 setRoot(v1);
	 updateChildren(v1);
		path.add(v2);
	 int shortest_length = v2.getAdjuDist();
	  while((v2.getParent()!=null)&&(!v2.toName().equals(v1.toName())))
      {
		  path.add(v2.getParent());
          v2 = v2.getParent();
      }
     return path;
	}
	 private void updateChildren(Vertex v)
	    {
		 if (v==null) {
	            return;
	        }
		 if(v.neighbour==null||v.neighbour.size()==0) {
			 return;
		 }
		 List<Vertex> childrenList = new LinkedList<Vertex>();
		 for(int a=0;a<v.neighbour.size();a++){
			if(v.getParent()==null||!v.getParent().equals(v.neighbour.get(a))) {
			 Vertex childVertex=v.neighbour.get(a);
			 if(!childVertex.isKnown())
	            {
	                childVertex.setKnown(true);
	                childVertex.setAdjuDist(v.getAdjuDist()+1);
	                childVertex.setParent(v);
	                childrenList.add(childVertex);
	            }
			 int nowDist = v.getAdjuDist()+1;
			 if(nowDist>=childVertex.getAdjuDist())
	            {
	                continue;
	            }
			 else {
	                childVertex.setAdjuDist(nowDist);
	                childVertex.setParent(v);
	                childrenList.add(childVertex);
			 }
			 }
			
		 }
		 for(Vertex vc:childrenList)
	        {
	            updateChildren(vc);
	        }
	    }
}
