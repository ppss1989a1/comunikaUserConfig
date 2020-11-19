package br.com.assertiva.comunika.configurations.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.assertiva.comunika.configurations.domain.Blacklist;
import br.com.assertiva.comunika.configurations.domain.CostCenter;

@Repository
public class CostCenterConfigurationsRepository {

	
    @Autowired
    NamedParameterJdbcTemplate template;
        
    public int createCenterCost(CostCenter c) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO public.centrocusto");
        sql.append("(user_id, nome )");                                 
        sql.append("  values                                                          ");
        sql.append(" (:user_id, :nome)");
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("user_id", c.getUserId());
        map.addValue("nome", c.getName());
        return template.update(sql.toString(), map);

    }
    
    
	public List<CostCenter> loadbyId(int id) {
        String sql = "SELECT * from public.centrocusto where ID ="+id;
        return template.query(sql, (rs, rowNum) -> new CostCenter( 
            		 rs.getInt("user_id"), 
            		 rs.getString("nome")));	
	}

	  

	
	public int delete(int id) {
		  final String DELETE_QUERY = "delete from public.centrocusto where id = :id";
		    SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
		    int status = template.update(DELETE_QUERY, namedParameters);
		    extracted(status);
			return status;
	}

	public int update(int id, CostCenter c) {
		  final String UPDATE_QUERY = "UPDATE public.centrocusto SET user_id=:user_id , nome=:nome "
		  		+ " WHERE id=:id";
		            MapSqlParameterSource map = new MapSqlParameterSource();
			         	map.addValue("id", id);
				        map.addValue("user_id", c.getUserId());
				        map.addValue("nome", c.getName());
		    int status = template.update(UPDATE_QUERY, map); 
		    return extracted(status);
		  }


	private int extracted(int id) {
		if(id != 0){
		  System.out.println("Operacao realizada " +id );
		}else{
		  System.out.println("Id inválido " + id);
		}
		return id;
	}

    
    
    public List<CostCenter> loadAll() {
            return template.query("select * from public.centrocusto",(rs, rowNum) -> new CostCenter( 
            		 rs.getInt("user_id"), 
            		 rs.getString("nome")));
                       }
    
    

    	

}
