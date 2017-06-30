package mashen.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mashen.dao.ColuDao;
import mashen.model.Colu;

@Service("coluService")
public class ColuService implements IColuService {
	@Resource(name="coluDao")
	private ColuDao coluDao;
	
	public void addColu(Colu colu) {
		coluDao.add(colu);
	}

	public void deleteColu(int id) {
		coluDao.delete(id);
	}

	public void updateColu(Colu colu) {
		coluDao.update(colu);
	}

	public List<Colu> selectAll() {
		return coluDao.selectAll();
	}

	public Colu selectById(int id) {
		return coluDao.select(id);
	}

}
