package br.com.assertiva.comunika.configurations.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.assertiva.comunika.configurations.domain.Sender;

@Repository
public class SenderConfigurationsRepository {
	
    @Autowired
    NamedParameterJdbcTemplate template;


		public List<Sender> loadbyId(int id) {
	        String sql = "SELECT * from public.remetente where ID ="+id;
	        return template.query(sql, (rs, rowNum) -> new Sender(
	        		rs.getString("nome"),
	        		rs.getInt("usuario_id"),
	        		rs.getBoolean("ativo"), 
	        		rs.getTimestamp("inclusao").toLocalDateTime(), 
	        		rs.getTimestamp("atualizacao").toLocalDateTime()));
	        		
	        		
	       	}

	public int createSender(Sender s) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO public.remetente");
        sql.append("(usuario_id, nome, ativo,inclusao,atualizacao )");                                 
        sql.append("  values                                                          ");
        sql.append(" (:user_id, :nome,:ativo,:inclusao,:atualizacao)");
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("user_id", s.getUserId());
        map.addValue("nome", s.getName());
        map.addValue("ativo", s.isActiveResgister());
        map.addValue("inclusao", s.getInclusion());
        map.addValue("atualizacao", s.getUpdate());
        System.out.println(sql);
        return template.update(sql.toString(), map);
	}

	public int update(int id, Sender s) {
		  final String UPDATE_QUERY = "UPDATE public.remetente SET nome=:nome, usuario_id=:usuario_id, ativo=:ativo, inclusao=:inclusao, atualizacao=:atualizacao WHERE id =:id";
			            MapSqlParameterSource map = new MapSqlParameterSource();
				         	map.addValue("id", id);
					        map.addValue("usuario_id", s.getUserId());
					        map.addValue("nome", s.getName());
					        map.addValue("ativo", s.isActiveResgister());
					        map.addValue("inclusao", s.getInclusion());
					        map.addValue("atualizacao", s.getUpdate());
			    int status = template.update(UPDATE_QUERY, map); 
			    return extracted(status);

		
	}

	public int delete(int id) {
		  final String DELETE_QUERY = "delete from public.remetente where id = :id";
		    SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
		    int status = template.update(DELETE_QUERY, namedParameters);
		    extracted(status);
			return status;
	}
	
	private int extracted(int id) {
		if(id != 0){
		  System.out.println("Operacao realizada " +id );
		}else{
		  System.out.println("Id inválido " + id);
		}
		return id;
	}

    
    
    public List<Sender> loadAll() {
            return template.query("select * from public.remetente", (rs, rowNum) -> new Sender(
	        		rs.getString("descricao"),
	        		rs.getInt("usuario_id"),
	        		rs.getBoolean("ativo"), 
	        		rs.getTimestamp("inclusao").toLocalDateTime(), 
	        		rs.getTimestamp("atualizacao").toLocalDateTime()));
	        		

                       }


}
