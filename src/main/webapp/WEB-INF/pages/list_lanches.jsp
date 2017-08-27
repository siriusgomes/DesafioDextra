<%@ page import="sirius.desafio.dextra.model.Lanche"%>
<%@ page import="sirius.desafio.dextra.model.Ingrediente"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<html>
<body>
	<h1>Lanches</h1>

	<a href="new">Adicionar lanche</a>
	<a href="../">Voltar</a>
	<hr />

	<h2>Lista de Lanches</h2>
	<table border="1">
		<thead>
			<tr>
				<td>Nome</td>
				<td>Ingredientes</td>
				<td>Valor</td>
				<td>Promoção</td>
				<td>Ação</td>
			</tr>
		</thead>
		<%

		    List<Lanche> ll = (List<Lanche>) request.getAttribute("listLanches");
		    for(Lanche e : ll){

		%>
			<tr>
			  <td><%=e.getNome() %></td>
			  <td>
			  	<% for(Map.Entry<String, Long> i : e.getQuantidadeDeIngrediente().entrySet()){ %>
			  		<%= i.getValue() + " " + i.getKey() + ";" %>
				<% } %>
			  </td>
			  <td><%=e.getValor() %></td>
			  <td><%=e.getPromocao() %></td>
			  <td><a href="update/<%=e.getNome()%>">Update</a>
                             | <a href="delete/<%=e.getNome()%>">Delete</a></td>
			</tr>
		<%
			}
		%>
	</table>

</body>
</html>