package yong.emp.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class EmpDAOImple implements EmpDAO {

	private SqlSessionTemplate sqlMap;
	
	
	public EmpDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}


	public int empAdd(EmpDTO dto) {
		int result=sqlMap.insert("empInsert", dto);
		return result;
	}
	
	public int empDel(EmpDTO dto) {
		int result=sqlMap.delete("empDelete", dto);
		return result;
	}

	public List<EmpDTO> empAllList() {
		List<EmpDTO> list=sqlMap.selectList("empAllList");
		return list;
	}


	public List<EmpDTO> empSearch(String name) {
		System.out.println(name);
		List<EmpDTO> list=sqlMap.selectList("empSearch", name);
		return list;
	}
	
	public List<EmpDTO> empUpdate(int idx) {
		List<EmpDTO> list=sqlMap.selectList("empUpdate", idx);
		return list;
	}


	public int empUpdate_ok(EmpDTO dto) {
		System.out.println(dto.getEmail());
		int result=sqlMap.update("empUpdate_ok", dto);
		return result;
	}
}
