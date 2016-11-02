package by.tr.totalizator.tag;

import java.util.Iterator;
import java.util.List;

import by.tr.totalizator.entity.Match;

public class JSPListBean {
	private List<Match> list;
	private Iterator<Match> iterator;
	
	public JSPListBean(){
	}
	
	public JSPListBean(List<Match> list){
		this.list = list;
	}
	
	public String getSize(){
		iterator = list.iterator();
		return Integer.toString(list.size());
	}
	public Match getElement(){
		return (Match)iterator.next();
	}
}
