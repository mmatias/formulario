<%@ tag body-content="empty" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ attribute name="tipoForm" required="true" %>
<jsp:useBean id="now" scope="application" class="java.util.Date" /> 
<%
String resultado;



   if (tipoForm == "COM"){
	   resultado = "<form action='comercial_save.jsp' method='post' class='form_custom text-center element-animation'>Nome: <br /><input class='form-control text-center' type='text' id='nome' name='nome'> <br ><br >";
	   resultado = resultado + "CPF: <br /><input  class='form-control text-center'type='text' id='cpf' name='cpf' required> <br ><br >";
	   resultado = resultado + "Email: <br /><input type='email'  class='form-control text-center'id='email' name='email' required> <br ><br >";
	   resultado = resultado + "telefone: <br /><input type='text' class='form-control text-center' id='telefone' name='telefone'> <br ><br >";
	   
	   resultado = resultado + "Produto 1: <br /><input type='text'  class='form-control text-center' id='prod1' name='prod1'> <br >";
	   resultado = resultado + "Valor: <br /><input type='text'  class='form-control text-center' id='vl1' name='vl1'> <br >";
	   resultado = resultado + "Quantidade: <br /><input  class='form-control text-center' type='text' id='qtd1' name='qtd1'> <br >";
	   resultado = resultado + "Data: <br /><input  class='form-control text-center' type='text' id='dt1' name='dt1'> <br ><br >";
	   
	   resultado = resultado + "Produto 2: <br /><input  class='form-control text-center' type='text' id='prod2' name='prod2'> <br >";
	   resultado = resultado + "Valor: <br /><input  class='form-control text-center' type='text' id='vl2' name='vl2'> <br >";
	   resultado = resultado + "Quantidade: <br /><input  class='form-control text-center' type='text' id='qtd2' name='qtd2'> <br >";
	   resultado = resultado + "Data: <br /><input  class='form-control text-center' type='text' id='dt2' name='dt2'> <br ><br >";
	   
	   resultado = resultado + "Produto 3: <br /><input  class='form-control text-center' type='text' id='prod3' name='prod3'> <br >";
	   resultado = resultado + "Valor: <br /><input  class='form-control text-center' type='text' id='vl3' name='vl3'> <br >";
	   resultado = resultado + "Quantidade: <br /><input   class='form-control text-center'type='number' id='qtd3' name='qtd3'> <br >";
	   resultado = resultado + "Data: <br /><input  class='form-control text-center' type='text' id='dt3' name='dt3'> <br ><br >";	   
	   resultado = resultado +"<input type='submit' class='btn btn-default' value='Salvar'/>";
	   out.println(resultado);

   }
   else
   if (tipoForm == "FIN"){
	   resultado = "<form action='financeiro_save.jsp' method='post' class='form_custom text-center element-animation'>Nome: <br /><input class='form-control text-center' type='text' id='nome' name='nome'> <br ><br >";
	   resultado = resultado + "CPF: <br /><input  class='form-control text-center'type='text' id='cpf' name='cpf' required> <br ><br >";
	   resultado = resultado + "Email: <br /><input type='email'  class='form-control text-center'id='email' name='email' required> <br ><br >";
	   resultado = resultado + "telefone: <br /><input type='text' class='form-control text-center' id='telefone' name='telefone'> <br ><br >";

	   resultado = resultado +"Fatura 1: <br /> <textarea class='form-control' rows='4' cols='50' name='fatura[]'></textarea> <br /><br />";
	   resultado = resultado +"Fatura 2: <br /> <textarea class='form-control' rows='4' cols='50' name='fatura[]'></textarea> <br /><br />";
	   resultado = resultado +"Fatura 3: <br /> <textarea class='form-control' rows='4' cols='50' name='fatura[]'></textarea> <br /><br />";			   
	   resultado = resultado +"<input type='submit' class='btn btn-default' value='Salvar'/>";
	   out.println(resultado);
   }
   else
   if (tipoForm == "SUP"){
	   resultado = "<form action='suporte_save.jsp' method='post' class='form_custom text-center element-animation'>Nome: <br /><input class='form-control text-center' type='text' id='nome' name='nome'> <br ><br >";
	   resultado = resultado + "CPF: <br /><input  class='form-control text-center'type='text' id='cpf' name='cpf' required> <br ><br >";
	   resultado = resultado + "Email: <br /><input type='email'  class='form-control text-center'id='email' name='email' required> <br ><br >";
	   resultado = resultado + "telefone: <br /><input type='text' class='form-control text-center' id='telefone' name='telefone'> <br ><br >";

	   resultado = resultado +"Produtos com mais garantia: <br /> <textarea rows='4' cols='50' id='produto' name='produto'></textarea> <br /><br />";
	   resultado = resultado +"<input type='submit' class='btn btn-default' value='Salvar'/>";
	   out.println(resultado);
	}
   else{
	   out.println("Parâmetro componente inválido.");
   }
 %>
