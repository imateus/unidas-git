package br.com.unidas.bean;

import static br.com.unidas.util.Utils.addDetailMessage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.unidas.entity.Usuario;
import br.com.unidas.model.Filter;
import br.com.unidas.service.UsuarioService;
import br.com.unidas.template.exception.BusinessException;

@Named
@ViewScoped
public class UsuarioListMB implements Serializable {
    
	private static final long serialVersionUID = 1L;

	private UsuarioService service = new UsuarioService();
    
    Integer id;

    LazyDataModel<Usuario> usuarios;

    Filter<Usuario> filter = new Filter<>(new Usuario());

    List<Usuario> selectedUsuarios; //Usuarios selected in checkbox column

    List<Usuario> filteredValue;// datatable filteredValue attribute (column filters)
    
    @PostConstruct
    public void initDataModel() {
    	usuarios = new LazyDataModel<Usuario>() {
            @Override
            public List<Usuario> load(int first, int pageSize,
                                  String sortField, SortOrder sortOrder,
                                  Map<String, Object> filters) {
                br.com.unidas.model.SortOrder order = null;
                if (sortOrder != null) {
                    order = sortOrder.equals(SortOrder.ASCENDING) ? br.com.unidas.model.SortOrder.ASCENDING
                            : sortOrder.equals(SortOrder.DESCENDING) ? br.com.unidas.model.SortOrder.DESCENDING
                            : br.com.unidas.model.SortOrder.UNSORTED;
                }
                filter.setFirst(first).setPageSize(pageSize)
                        .setSortField(sortField).setSortOrder(order)
                        .setParams(filters);
                List<Usuario> list = service.paginate(filter);
                setRowCount((int) service.count(filter));
                return list;
            }

            @Override
            public int getRowCount() {
                return super.getRowCount();
            }

            @Override
            public Usuario getRowData(String key) {
                return service.findById(new Integer(key));
            }
        };
    }

    public void clear() {
        filter = new Filter<Usuario>(new Usuario());
    }

    public List<String> completeModel(String query) {
        /*List<String> result = service.getModels(query);*/
        return null;
    }

    public void findUsuarioById(Integer id) {
        if (id == null) {
            throw new BusinessException("Provide Usuario ID to load");
        }
        selectedUsuarios.add(service.findById(id));
    }

    public void delete() {
        int numUsuarios = 0;
        for (Usuario selectedUsuario : selectedUsuarios) {
            numUsuarios++;
            /*service.remove(selectedUsuario);*/
        }
        selectedUsuarios.clear();
        addDetailMessage(numUsuarios + " Usuarios deleted successfully!");
    }

    public List<Usuario> getSelectedUsuarios() {
        return selectedUsuarios;
    }

    public List<Usuario> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<Usuario> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public void setSelectedUsuarios(List<Usuario> selectedUsuarios) {
        this.selectedUsuarios = selectedUsuarios;
    }

    public LazyDataModel<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(LazyDataModel<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Filter<Usuario> getFilter() {
        return filter;
    }

    public void setFilter(Filter<Usuario> filter) {
        this.filter = filter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
