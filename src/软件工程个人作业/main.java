package 软件工程个人作业;
import java.util.ArrayList;
import java.util.List;

import 软件工程个人作业.inputmap;
public class main {
	private static ArrayList trimList(ArrayList list) {
		ArrayList list2 = new ArrayList();
		for (int i = list.size() - 1; i >= 0; i--) {
		Object o = list.get(i);
		if (list2.indexOf(o) == -1) {
		list2.add(0, o);
		}
		}
		return list2;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputname = "";
		String outputname = "";
		String place1="";
		String place2="";
		String line2=new String();
		List<line> line=new ArrayList<line>();
		ArrayList<Vertex> station=new ArrayList<Vertex>();
		int optSetting = 0;
		for (; optSetting < args.length; optSetting++) {
		if ("-map".equals(args[optSetting])) {
		inputname = args[++optSetting];
		inputmap a=new inputmap();
		List<String> map=a.inputmapname(inputname);
		for(int b=0;b<map.size();b++) {
			//向线路加入站点
			List<String> s=new ArrayList<String>();
			    String[] str;
				str = map.get(b).split("：");
				String[] sta;
				sta = str[1].split(" ");
				for(int st=0;st<sta.length;st++) {
					s.add(sta[st]);
				}
			    line li=new line(str[0],s);
			    line.add(li);
			    for(int st=0;st<sta.length;st++) {
		    	Vertex ve=new Vertex(sta[st]);
		    	int t=0;
		    	for(int op=0;op<station.size();op++) {
		    		if(station.get(op).name.equals(sta[st])) {
		    			t=1;
		    			break;
		    		}
		    	}
		    	if(t==0)station.add(ve);
		    }
			//加入站点

		}
		}
}
		optSetting = 0;
		for (; optSetting < args.length; optSetting++) {
		if ("-map".equals(args[optSetting])) {
		inputname = args[++optSetting];
		inputmap a=new inputmap();
		List<String> map=a.inputmapname(inputname);
		for(int b=0;b<map.size();b++) {
			//向线路加入站点
			List<String> s=new ArrayList<String>();
			    String[] str;
				str = map.get(b).split("：");
				String[] sta;
				sta = str[1].split(" ");
			    for(int st=0;st<sta.length;st++) {
		    	if(st==0) {
		    		int nu=0;
		    		for(int st1=0;st1<station.size();st1++) {
		    			if(station.get(st1).toName().equals(sta[st+1])) {
		    			nu=st1;
		    			break;
		    			}
		    		}
		    		for(int st1=0;st1<station.size();st1++) {
		    			if(station.get(st1).toName().equals(sta[st])) {
		    			station.get(st1).neighbour.add(station.get(nu));
		    			station.get(st1).line.add(str[0]);
		    			break;
		    			}
		    		}
		    	}
		    	else if(st==sta.length-1) {
		    		int nu=0;
		    		for(int st1=0;st1<station.size();st1++) {
		    			if(station.get(st1).toName().equals(sta[st-1])) {
		    			nu=st1;
		    			break;
		    			}
		    		}
		    		for(int st1=0;st1<station.size();st1++) {
		    			if(station.get(st1).toName().equals(sta[st])) {
		    			station.get(st1).neighbour.add(station.get(nu));
		    			station.get(st1).line.add(str[0]);
		    			break;
		    			}
		    		}
		    	}
		    	else{
		    		int nu1=0;
		    		int nu2=0;
		    		for(int st1=0;st1<station.size();st1++) {
		    			if(station.get(st1).toName().equals(sta[st-1])) {
		    			nu1=st1;
		    			break;
		    			}
		    		}
		    		for(int st1=0;st1<station.size();st1++) {
		    			if(station.get(st1).toName().equals(sta[st+1])) {
		    			nu2=st1;
		    			break;
		    			}
		    		}
		    		for(int st1=0;st1<station.size();st1++) {
		    			if(station.get(st1).toName().equals(sta[st])) {
		    			station.get(st1).neighbour.add(station.get(nu1));
		    			station.get(st1).neighbour.add(station.get(nu2));
		    			station.get(st1).line.add(str[0]);
		    			break;
		    			}
		    		}
		    	}
		    }
				}
		for(int st1=0;st1<station.size();st1++) {
			station.get(st1).line = trimList(station.get(st1).line);
			station.get(st1).neighbour = trimList(station.get(st1).neighbour);
		}
		}
		}
		optSetting = 0;
		for (; optSetting < args.length; optSetting++) {
		if ("-o".equals(args[optSetting])) {
			outputname = args[++optSetting];
		}
		}
		optSetting = 0;
		for (; optSetting < args.length; optSetting++) {
        if ("-a".equals(args[optSetting])) {
        String line1=args[++optSetting];
		line2 = args[optSetting]+":";
		for(int b=0;b<line.size();b++) {
			if(line1.equals(line.get(b).name)) {
				for(int b1=0;b1<line.get(b).station.size();b1++) {
					line2=line2+" "+line.get(b).station.get(b1);
				}
				break;
			}
		}
		outputmap a=new outputmap();
		a.output(line2, outputname);
		} 
}
		optSetting = 0;
		for (; optSetting < args.length; optSetting++) {
	    if ("-b".equals(args[optSetting])) {
			 place1 = args[++optSetting];
			 place2 = args[++optSetting];
			    Dijkstra dik=new Dijkstra();
			    ArrayList<Vertex> ar=new ArrayList<Vertex>();
			    ar=dik.dijkstraTravasal(station, place1, place2);
			    String pa=String.valueOf(ar.size())+"\r\n";
			    String xian="";
			    for(int num=0;num<ar.get(ar.size()-1).line.size();num++) {
			    	 for(int num1=0;num1<ar.get(ar.size()-2).line.size();num1++) {
			    		 if(ar.get(ar.size()-1).line.get(num).equals(ar.get(ar.size()-2).line.get(num1))) {
			    			 xian=ar.get(ar.size()-1).line.get(num);
			    			 break;
			    		 }
			    		 if(!xian.equals(""))break;
			    	 }
			    }
			    for(int num=ar.size()-1;num>=0;num--) {
			    	int y=0;
					pa=pa+ar.get(num).toName()+"\r\n";
					if(ar.get(num).line.size()>1&&num!=0&&num!=ar.size()-1){
						for(int num1=0;num1<ar.get(num-1).line.size();num1++) {
							for(int num2=0;num2<ar.get(num+1).line.size();num2++) {
								if(ar.get(num-1).line.get(num1).equals(ar.get(num+1).line.get(num2))) {
									y=1;
									break;
								}
								if(y==1)break;
							}
						}
						for(int num2=0;num2<ar.get(num-1).line.size();num2++) {
						if(ar.get(num-1).line.get(num2).equals(xian)) {
							break;
						}
						if(num2==ar.get(num-1).line.size()-1)y=0;
						}
						if(y==0) {
							String hua="";
							for(int num1=0;num1<ar.get(num).line.size();num1++) {
								for(int num2=0;num2<ar.get(num-1).line.size();num2++) {
									if(ar.get(num).line.get(num1).equals(ar.get(num-1).line.get(num2))) {
										hua=ar.get(num-1).line.get(num2);
										xian=hua;
										break;
									}
									if(y==1)break;
								}
							}
						pa=pa+hua+"\r\n";
						}
					}
			    }
			    outputmap a=new outputmap();
			    a.output(pa, outputname);
			}
}
		}
	}
