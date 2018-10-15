package com.github.adminfaces.starter.service;

import static com.github.adminfaces.template.util.Assert.has;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.github.adminfaces.starter.dao.UsuarioDAO;
import com.github.adminfaces.starter.entity.Usuario;
import com.github.adminfaces.starter.entity.Usuario;
import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.infra.model.SortOrder;

public class UsuarioService {
	
	private List<Usuario> allUsuarios;

	private EmailService emailService = new EmailService();
	
	public UsuarioService() {
		allUsuarios = this.listAll(); 
	}
	
	private UsuarioDAO dao = new UsuarioDAO();
	
	public Usuario validadeEmailOrPass(String email, String pass) throws SQLException {
		return dao.validadeEmailOrPass(email, pass);
	}
	
	public List<Usuario> listAll() {
		return dao.listAll();
	}
	
	public Usuario findById(Integer id){
		return dao.findById(id);
	}
	
	public void saveOrUpdate(Usuario usuario) {
		dao.save(usuario);
	}
	
	public void delete(Usuario usuario) {
		dao.delete(usuario);
	}
	
    public List<Usuario> paginate(Filter<Usuario> filter) {
        List<Usuario> pagedUsuarios = new ArrayList<>();
        if(has(filter.getSortOrder()) && !SortOrder.UNSORTED.equals(filter.getSortOrder())) {
                pagedUsuarios = allUsuarios.stream().
                    sorted((c1, c2) -> {
                        if (filter.getSortOrder().isAscending()) {
                            return c1.getId().compareTo(c2.getId());
                        } else {
                            return c2.getId().compareTo(c1.getId());
                        }
                    })
                    .collect(Collectors.toList());
            }

        int page = filter.getFirst() + filter.getPageSize();
        if (filter.getParams().isEmpty()) {
            pagedUsuarios = pagedUsuarios.subList(filter.getFirst(), page > allUsuarios.size() ? allUsuarios.size() : page);
            return pagedUsuarios;
        }

        List<Predicate<Usuario>> predicates = configFilter(filter);

        List<Usuario> pagedList = allUsuarios.stream().filter(predicates
                .stream().reduce(Predicate::or).orElse(t -> true))
                .collect(Collectors.toList());

        if (page < pagedList.size()) {
            pagedList = pagedList.subList(filter.getFirst(), page);
        }

        if (has(filter.getSortField())) {
            pagedList = pagedList.stream().
                    sorted((c1, c2) -> {
                        boolean asc = SortOrder.ASCENDING.equals(filter.getSortOrder());
                        if (asc) {
                            return c1.getId().compareTo(c2.getId());
                        } else {
                            return c2.getId().compareTo(c1.getId());
                        }
                    })
                    .collect(Collectors.toList());
        }
        return pagedList;
    }
    
    private List<Predicate<Usuario>> configFilter(Filter<Usuario> filter) {
        List<Predicate<Usuario>> predicates = new ArrayList<>();
        if (filter.hasParam("id")) {
            Predicate<Usuario> idPredicate = (Usuario c) -> c.getId().equals(filter.getParam("id"));
            predicates.add(idPredicate);
        }

/*        if (filter.hasParam("minPrice") && filter.hasParam("maxPrice")) {
            Predicate<Usuario> minMaxPricePredicate = (Usuario c) -> c.getPrice()
                    >= Double.valueOf((String) filter.getParam("minPrice")) && c.getPrice()
                    <= Double.valueOf((String) filter.getParam("maxPrice"));
            predicates.add(minMaxPricePredicate);
        } else if (filter.hasParam("minPrice")) {
            Predicate<Usuario> minPricePredicate = (Usuario c) -> c.getPrice()
                    >= Double.valueOf((String) filter.getParam("minPrice"));
            predicates.add(minPricePredicate);
        } else if (filter.hasParam("maxPrice")) {
            Predicate<Usuario> maxPricePredicate = (Usuario c) -> c.getPrice()
                    <= Double.valueOf((String) filter.getParam("maxPrice"));
            predicates.add(maxPricePredicate);
        }*/

        if (has(filter.getEntity())) {
            Usuario filterEntity = filter.getEntity();

            if (has(filterEntity.getNome())) {
                Predicate<Usuario> namePredicate = (Usuario c) -> c.getNome().toLowerCase().contains(filterEntity.getNome().toLowerCase());
                predicates.add(namePredicate);
            }
        }
        return predicates;
    }
    
    public long count(Filter<Usuario> filter) {
        return allUsuarios.stream()
                .filter(configFilter(filter).stream()
                        .reduce(Predicate::or).orElse(t -> true))
                .count();
    }
    
    public String recuperarSenha(String email) {
    	
    	Usuario usuario = dao.findByEmail(email);
    	
    	if(usuario != null) {
    		emailService.enviarEmail(usuario);
    	}else {
    		return "Email não cadastrado!";
    	}    	
		return "Senha enviada com sucesso!";    	
    }
}
