package banco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Oportunidade;

public class OportunidadeDAO {

	Connection con = ConexaoBanco.getConnection();

	public void alterarOportunidade(Oportunidade oportunidade) {
		String sql = "update DBOPTN.t_optn set tx_motivo = ? where id_optn= ?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, oportunidade.getTxMotivo());
			preparador.execute();
			preparador.close();
			System.out.println("Oportunidade Atualizada com Sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Oportunidade> buscarTodos() {
		
		String sql = "select * from DBOPTN.t_optn";

		List<Oportunidade> lista = new ArrayList<Oportunidade>();
		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				Oportunidade oportunidade = new Oportunidade();
				oportunidade.setIdOptn(resultado.getInt("id_optn"));
				oportunidade.setNmVendedor(resultado.getString("nm_vendedor"));
				oportunidade.setNmCliente(resultado.getString("nm_cliente"));
				oportunidade.setDtInicio(resultado.getDate("dt_inicio"));
				oportunidade.setDtFim(resultado.getDate("dt_fim"));
				oportunidade.setVlPrevisto(resultado.getDouble("vl_previsto"));
				oportunidade.setTxDescricao(resultado.getString("tx_descricao"));
				oportunidade.setCdStatus(resultado.getInt("cd_status"));
				oportunidade.setTxMotivo(resultado.getString("tx_motivo"));
				lista.add(oportunidade);
			}
			if (!resultado.next()) {
				System.out.println("Não existem dados no banco para serem exibidos");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
}