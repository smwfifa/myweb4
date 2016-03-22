package yong.emp.model;

import java.util.List;

public interface EmpDAO {
	
	public int empAdd(EmpDTO dto);
	public int empDel(EmpDTO dto);
	public List<EmpDTO> empAllList();
	public List<EmpDTO> empSearch(String name);
	public List<EmpDTO> empUpdate(int idx);
	public int empUpdate_ok(EmpDTO dto);
}
