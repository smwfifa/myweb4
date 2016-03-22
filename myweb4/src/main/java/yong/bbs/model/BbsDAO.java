package yong.bbs.model;

import java.util.List;

public interface BbsDAO {
	public List<BbsDTO> bbsAllList(int listSize, int cp);
	public int getTotalCnt();
	public int bbsWrite(BbsDTO dto);
	public List<BbsDTO> bbsContent(int idx);
}
