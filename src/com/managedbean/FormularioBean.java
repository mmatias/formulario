package com.managedbean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean(name = "formularioBean")
@SessionScoped
public class FormularioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7439255411328872091L;
	private Usuarios usuario = new Usuarios();
	private FormComercial comercial = new FormComercial();
	private FormSuporte suporte = new FormSuporte();
	private FormFinanceiro financeiro = new FormFinanceiro();
	private List<FormComercial> comercialList;

	@PostConstruct
	public void init() {
		System.out.println(" Bean executado! ");
	}

	public String com() {
		return "formulariocomercial";
	}

	public String teste() {
		return "resultado";
	}

	public String saveComercial() {
		try {
			// create a mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/dw2";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "apollo87");

			// the mysql insert statement
			String query = " insert into comercial"
					+ " values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, comercial.getNome());
			preparedStmt.setString(2, comercial.getCpf());
			preparedStmt.setString(3, comercial.getEmail());
			preparedStmt.setString(4, comercial.getTelefone());
			preparedStmt.setString(5, comercial.getProduto1().getNomeproduto());
			preparedStmt.setString(6, comercial.getProduto1().getValor());
			preparedStmt.setString(7, comercial.getProduto1().getQnt());
			preparedStmt.setString(8, comercial.getProduto1().getData());
			preparedStmt.setString(9, comercial.getProduto2().getNomeproduto());
			preparedStmt.setString(10, comercial.getProduto2().getValor());
			preparedStmt.setString(11, comercial.getProduto2().getQnt());
			preparedStmt.setString(12, comercial.getProduto2().getData());
			preparedStmt.setString(13, comercial.getProduto3().getNomeproduto());
			preparedStmt.setString(14, comercial.getProduto3().getValor());
			preparedStmt.setString(15, comercial.getProduto3().getQnt());
			preparedStmt.setString(16, comercial.getProduto3().getData());

			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		
		return "list";
	}
	
	public String listComercial() {
		try {
			// create a mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/dw2";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "apollo87");
				
				this.comercialList = new ArrayList<FormComercial>();
				FormComercial c = new FormComercial();
				Produtos p = new Produtos();
				
				  // our SQL SELECT query. 
			      // if you only need a few columns, specify them by name instead of using "*"
			      String query = "SELECT * FROM comercial";

			      // create the java statement
			      Statement st = conn.createStatement();
			      
			      // execute the query, and get a java resultset
			      ResultSet rs = st.executeQuery(query);
			      
			      // iterate through the java resultset
			      while (rs.next())
			      {
			    	c.setId(rs.getInt("id"));
			        c.setNome(rs.getString("nome"));
					c.setCpf(rs.getString("cpf"));
					c.setEmail(rs.getString("email"));
					c.setTelefone(rs.getString("telefone"));
					p.setNomeproduto(rs.getString("produto"));
					p.setValor(rs.getString("valor"));
					p.setQnt(rs.getString("quantidade"));
					p.setData(rs.getString("data"));
					c.setProduto1(p);
					p = new Produtos();
					p.setNomeproduto(rs.getString("produto1"));
					p.setValor(rs.getString("valor1"));
					p.setQnt(rs.getString("quantidade1"));
					p.setData(rs.getString("data1"));
					c.setProduto2(p);
					p = new Produtos();
					p.setNomeproduto(rs.getString("produto2"));
					p.setValor(rs.getString("valor2"));
					p.setQnt(rs.getString("quantidade2"));
					p.setData(rs.getString("data2"));
					c.setProduto3(p);
					this.comercialList.add(c);
			        
			        // print the results
					 for (int i=0; i<comercialList.size(); i++){
						   System.err.println("Element "+i+comercialList.get(i));
						}
			      }
			      st.close();
			    }
			    catch (Exception e)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e.getMessage());
			    }
		return "list";
	}
	
	public void deleteComercial(int id){
		try
	    {
	      // create the mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/dw2";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "apollo87");
	      
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "delete from comercial where id = ?";
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setLong(1, id);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	
	}
	
	public String updateListComercial(int id) {
		try {
			// create a mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/dw2";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "apollo87");
				
				this.comercial = new FormComercial();
				Produtos p = new Produtos();
				
				  // our SQL SELECT query. 
			      // if you only need a few columns, specify them by name instead of using "*"
			      String query = "SELECT * FROM comercial WHERE id = "+id+";";

			      // create the java statement
			      Statement st = conn.createStatement();
			      
			      // execute the query, and get a java resultset
			      ResultSet rs = st.executeQuery(query);
			      
			      // iterate through the java resultset
			      while (rs.next())
			      {
			    	this.comercial.setId(rs.getInt("id"));
			        this.comercial.setNome(rs.getString("nome"));
					this.comercial.setCpf(rs.getString("cpf"));
					this.comercial.setEmail(rs.getString("email"));
					this.comercial.setTelefone(rs.getString("telefone"));
					p.setNomeproduto(rs.getString("produto"));
					p.setValor(rs.getString("valor"));
					p.setQnt(rs.getString("quantidade"));
					p.setData(rs.getString("data"));
					this.comercial.setProduto1(p);
					p = new Produtos();
					p.setNomeproduto(rs.getString("produto1"));
					p.setValor(rs.getString("valor1"));
					p.setQnt(rs.getString("quantidade1"));
					p.setData(rs.getString("data1"));
					this.comercial.setProduto2(p);
					p = new Produtos();
					p.setNomeproduto(rs.getString("produto2"));
					p.setValor(rs.getString("valor2"));
					p.setQnt(rs.getString("quantidade2"));
					p.setData(rs.getString("data2"));
					this.comercial.setProduto3(p);
			        
			        // print the results
					 for (int i=0; i<comercialList.size(); i++){
						   System.err.println("Element "+i+comercialList.get(i));
						}
			      }
			      st.close();
			    }
			    catch (Exception e)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e.getMessage());
			    }
		return "updateformulariocomercial";
	}

	
	public String updateComercial(int id){
		try {
			// create a mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/dw2";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "apollo87");

			// the mysql insert statement
			String query = "UPDATE comercial SET  "
					+ "nome =  ?,"
					+"cpf =  ?,"
					+"email =  ?,"
					+"telefone =  ?,"
					+"produto =  ?,"
					+"valor =  ?,"
					+"quantidade =  ?,"
					+"data =  ?,"
					+"produto1 =  ?,"
					+"valor1 =  ?,"
					+"quantidade1 =  ?,"
					+"data1 =  ?,"
					+"produto2 =  ?,"
					+"valor2 =  ?,"
					+"quantidade2 =  ?,"
					+"data2 =  ? WHERE id = "+id+";";


			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, comercial.getNome());
			preparedStmt.setString(2, comercial.getCpf());
			preparedStmt.setString(3, comercial.getEmail());
			preparedStmt.setString(4, comercial.getTelefone());
			preparedStmt.setString(5, comercial.getProduto1().getNomeproduto());
			preparedStmt.setString(6, comercial.getProduto1().getValor());
			preparedStmt.setString(7, comercial.getProduto1().getQnt());
			preparedStmt.setString(8, comercial.getProduto1().getData());
			preparedStmt.setString(9, comercial.getProduto2().getNomeproduto());
			preparedStmt.setString(10, comercial.getProduto2().getValor());
			preparedStmt.setString(11, comercial.getProduto2().getQnt());
			preparedStmt.setString(12, comercial.getProduto2().getData());
			preparedStmt.setString(13, comercial.getProduto3().getNomeproduto());
			preparedStmt.setString(14, comercial.getProduto3().getValor());
			preparedStmt.setString(15, comercial.getProduto3().getQnt());
			preparedStmt.setString(16, comercial.getProduto3().getData());

			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		
		return "list";

	}
	
	public FormComercial getComercial() {
		return comercial;
	}

	public void setComercial(FormComercial comercial) {
		this.comercial = comercial;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public FormSuporte getSuporte() {
		return suporte;
	}

	public void setSuporte(FormSuporte suporte) {
		this.suporte = suporte;
	}

	public FormFinanceiro getFinanceiro() {
		return financeiro;
	}

	public void setFinanceiro(FormFinanceiro financeiro) {
		this.financeiro = financeiro;
	}

	public List<FormComercial> getComercialList() {
		return comercialList;
	}

	public void setComercialList(List<FormComercial> comercialList) {
		this.comercialList = comercialList;
	}
}