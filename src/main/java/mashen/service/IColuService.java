package mashen.service;

import java.util.List;

import mashen.model.Colu;

public interface IColuService {
	public void addColu(Colu colu);
	
	public void deleteColu(int id);
	
	public void updateColu(Colu colu);
	
	public List<Colu> selectAll();
	
	public Colu selectById(int id);
	
}
