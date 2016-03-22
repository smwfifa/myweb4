package yong.bbs.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class BbsDAOImple implements BbsDAO {

	private SqlSessionTemplate sqlMap;
	
	public BbsDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}

	public List<BbsDTO> bbsAllList(int listSize, int cp) {
		HashMap<String, Integer> temp = new HashMap<String, Integer>();
		temp.put("cp", cp);
		temp.put("listSize", listSize);
		List<BbsDTO> list = sqlMap.selectList("bbsAllList", temp);
		System.out.println(list.get(0).getIdx());
		return list;
	}

	public int getTotalCnt() {
		List<Integer> temp=sqlMap.selectList("getTotalCnt");
		int total_cnt=temp.get(0);
		return total_cnt;
	}

	public int bbsWrite(BbsDTO dto) {
		int result=sqlMap.insert("bbsWrite", dto);
		return result;
	}

	public List<BbsDTO> bbsContent(int idx) {
		sqlMap.update("readContent", idx);
		List<BbsDTO> content= sqlMap.selectList("bbsContent", idx);
		return content;
	}

}
