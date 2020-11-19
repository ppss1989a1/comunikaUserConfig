package br.com.assertiva.comunika.configurations.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.assertiva.comunika.configurations.domain.Blacklist;

@Repository
public class BlacklistConfigurationsRepository   {

    @Autowired
    NamedParameterJdbcTemplate template;
        
    public int createBlacklist(Blacklist b) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO public.blacklist");
        sql.append("(usuario_id, numero, descricao, ativo, inclusao, atualizacao, dd)");                                 
        sql.append("  values                                                          ");
        sql.append(" (:usuario_id, :numero, :descricao, :ativo, :inclusao, :atualizacao,:dd)");
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("usuario_id", b.getUserId());
        map.addValue("numero", b.getNumber());
        map.addValue("descricao", b.getDescription());
        map.addValue("ativo", b.isActive());
        map.addValue("inclusao", b.getInclusion());
        map.addValue("atualizacao", b.getUpdate());
        map.addValue("dd", b.getDd());
        return template.update(sql.toString(), map);

    }
    
    
	public List<Blacklist> loadbyId(int id) {
        String sql = "SELECT * from public.blacklist where ID ="+id;
        return template.query(sql, (rs, rowNum) -> new Blacklist( 
            		 rs.getInt("usuario_id"), 
            		 rs.getInt("numero"), rs.getString("descricao"), 
            		 rs.getBoolean("ativo"), 
            		 rs.getTimestamp("inclusao").toLocalDateTime(), 
            		 rs.getTimestamp("atualizacao").toLocalDateTime()));	
	}

	  

	
	public int delete(int id) {
		  final String DELETE_QUERY = "delete from public.blacklist where id = :id";
		    SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
		    int status = template.update(DELETE_QUERY, namedParameters);
		    extracted(status);
			return status;
	}

	public int update(int id, Blacklist b) {
		  final String UPDATE_QUERY = "UPDATE public.blacklist SET usuario_id=:usuario_id , numero=:numero ,descricao=:descricao, ativo= :ativo, "
		  		+ "inclusao= :inclusao, atualizacao= :atualizacao, dd= :dd"
		  		+ " WHERE id=:id";
		            MapSqlParameterSource map = new MapSqlParameterSource();
			         	map.addValue("id", id);
				        map.addValue("usuario_id", b.getUserId());
				        map.addValue("numero", b.getNumber());
				        map.addValue("descricao", b.getDescription());
				        map.addValue("ativo", b.isActive());
				        map.addValue("inclusao", b.getInclusion());
				        map.addValue("atualizacao", b.getUpdate());
				        map.addValue("dd", b.getDd());
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

    
    
    public List<Blacklist> loadAll() {
            return template.query("select * from public.blacklist",(rs, rowNum) -> new Blacklist( 
            		 rs.getInt("usuario_id"), 
            		 rs.getInt("numero"), rs.getString("descricao"), 
            		 rs.getBoolean("ativo"), 
            		 rs.getTimestamp("inclusao").toLocalDateTime(), 
            		 rs.getTimestamp("atualizacao").toLocalDateTime()));
                       }
    
    

    	
       
}
