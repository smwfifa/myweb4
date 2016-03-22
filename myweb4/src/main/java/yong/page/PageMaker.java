package yong.page;

public class PageMaker {
	
	public static String goPage(String pagename, int total_cnt, int listSize, int pageSize, int cp){
		int page_cnt=total_cnt/(listSize)+1;
		if(total_cnt%listSize==0)page_cnt--;
		
		int group_num=cp/pageSize;
		if (cp%pageSize==0)group_num--;
	
		StringBuffer sb=new StringBuffer();
		
		if(group_num!=0){
			sb.append("<a href='");
			sb.append(pagename);
			sb.append("?cp=");
			int temp=(group_num-1)*pageSize+pageSize;
			sb.append(temp);
			sb.append("'>&lt;&lt;</a>");
		}
		
		for(int i=(group_num*pageSize)+1;i<=(group_num*pageSize)+pageSize;i++){
			sb.append("<a href='");
			sb.append(pagename);
			sb.append("?cp=");
			sb.append(i);
			sb.append("'>");
			sb.append(i);
			sb.append("</a>&nbsp;&nbsp");
			if(i==page_cnt)break;
		}
			
		if(group_num!=(page_cnt/pageSize-(page_cnt%pageSize==0?1:0))){
			sb.append("<a href='");
			sb.append(pagename);
			sb.append("?cp=");
			int temp=(group_num+1)*pageSize+1;
			sb.append(temp);
			sb.append("'>&gt;&gt;</a>");
		}
		
		return sb.toString();
	}	
}
