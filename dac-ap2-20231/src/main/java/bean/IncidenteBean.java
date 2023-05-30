package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.IncidenteDao;
import entidades.Incidente;
import util.MessageUtil;

@ManagedBean
@ViewScoped
public class IncidenteBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private Incidente incidente = new Incidente();
	
	private List<Incidente> list;
	
	private Date dataCadastro = new Date();
	
	private  String contarIncidente;
					
	public String salvar() {
		
		try {	
			incidente.setDataCadastro(dataCadastro);
			IncidenteDao.salvar(incidente);
			MessageUtil.sucesso("Sucesso: ", "Incidente salvo com sucesso!");
			incidente = new Incidente();
			
		} catch(Exception e) {
			MessageUtil.erro("Erro: ", "Erro ao salvar o Incidente!");
		}
		
		return null;
	}
	
	public String editar() {		
		IncidenteDao.editar(incidente);
		incidente = new Incidente();
		return null;
	}

	public void deletar() {		
		IncidenteDao.deletar(incidente);
		list = IncidenteDao.listarTodos();
	}
	
	public String listarPorId() {		
		IncidenteDao.listarPorId(incidente.getId());
		return null;
	}	
	
	public String listarTodos() {		
		IncidenteDao.listarTodos();
		return null;
	}	
		
	public Incidente getIncidente() {
		return incidente;
	}


	public void setIncidente(Incidente Incidente) {
		this.incidente = Incidente;
	}


	public List<Incidente> getList() {
		if (list == null) {
			list = IncidenteDao.listarTodos();
		}
		return list;
	}
		
	public void setList(List<Incidente> list) {
		this.list = list;
	}
	
	public String getContarIncidente() {
		if (list == null) {
			list = IncidenteDao.listarTodos();
		}
		return Integer.toString(list.size());
	}

	public void setContarIncidente(String contarIncidente) {
		this.contarIncidente = contarIncidente;
	}
	
	public String contarIncidente() {
		return contarIncidente;	
	}
}
