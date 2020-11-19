package br.com.assertiva.comunika.configurations.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.assertiva.comunika.configurations.domain.Blacklist;
import br.com.assertiva.comunika.configurations.domain.Model;
import br.com.assertiva.comunika.configurations.domain.RouteMap;
import br.com.assertiva.comunika.configurations.domain.Sender;

@Repository
public class ModelConfigurationsRepository {
	
    @Autowired
    NamedParameterJdbcTemplate template;
        
    public int createModel(Model m) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO public.modelo");
        sql.append("(usuario_id, nome, mensagem, rota_id, ativo, inclusao, atualizacao)");                                 
        sql.append("  values                                                          ");
        sql.append(" (:usuario_id, :nome, :mensagem, :rota_id, :ativo,:inclusao :atualizacao)");
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("usuario_id", m.getUserId());
        map.addValue("nome", m.getName());
        map.addValue("mensagem",m.getMessagem() );
        map.addValue("rota_id",m.getRoute());
        map.addValue("inclusao", m.getInclusion());
        map.addValue("atualizacao", m.getUpdate());
        return template.update(sql.toString(), map);

    }
    
    
	public List<Model> loadbyId(int id) {
        String sql = "SELECT * from public.modelo where ID ="+id;
        return template.query(sql, (rs, rowNum) ->new Model(rs.getInt("usuario_id"),
        		rs.getString("nome"), 
        		rs.getString("mensagem") , 
        		rs.getString("rota_id"), 
        		rs.getBoolean("ativo"), 
        		rs.getTimestamp("inclusao").toLocalDateTime(), 
        		rs.getTimestamp("atualizacao").toLocalDateTime()));
	
	}

	  

	
	public int delete(int id) {
		  final String DELETE_QUERY = "delete from public.modelo where id = :id";
		    SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
		    int status = template.update(DELETE_QUERY, namedParameters);
		    extracted(status);
			return status;
	}

	public int update(int id, Model m) {
		  final String UPDATE_QUERY = "UPDATE public.modelo"
		  		+ "SET usuario_id=:usuario_id, nome=:nome, mensagem=:mensagem, rota_id=:rota_id, ativo=:ativo, inclusao=:inclusao, atualizacao=:atualizacao WHERE id=";
	        MapSqlParameterSource map = new MapSqlParameterSource();
	        map.addValue("usuario_id", m.getUserId());
	        map.addValue("nome", m.getName());
	        map.addValue("mensagem",m.getMessagem() );
	        map.addValue("rota_id",m.getRoute());
	        map.addValue("ativo",m.isActive());
	        map.addValue("inclusao", m.getInclusion());
	        map.addValue("atualizacao", m.getUpdate());
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

    
    
    public List<Model> loadAll() {
            return template.query("select * from public.modelo",(rs, rowNum) -> 
            new Model(rs.getInt("usuario_id"),
            		rs.getString("nome"), 
            		rs.getString("mensagem") , 
            		rs.getString("rota_id"), 
            		rs.getBoolean("ativo"), 
            		rs.getTimestamp("inclusao").toLocalDateTime(), 
            		rs.getTimestamp("atualizacao").toLocalDateTime()));
            	                     }
    	
       
}



