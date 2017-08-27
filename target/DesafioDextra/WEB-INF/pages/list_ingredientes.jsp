<%@ page import="sirius.desafio.dextra.model.Ingrediente"%>
<%@ page import="java.util.List" %>
<html>
<body>
	<h1>Ingredientes</h1>

	<a href="addCustomerPage">Adicionar ingrediente</a>
	<hr />

	<h2>Lista de Ingredientes</h2>
	<table border="1">
		<thead>
			<tr>
				<td>Nome</td>
				<td>Valor</td>
				<td>Ação</td>
			</tr>
		</thead>
		<%

		    List<Ingrediente> i = (List<Ingrediente>)request.getAttribute("listIngredientes");
		    for(Ingrediente e : i){

		%>
			<tr>
			  <td><%=e.getNome() %></td>
			  <td><%=e.getValor() %></td>
			  <td><a href="update/<%=e.getNome()%>">Update</a>
                             | <a href="delete/<%=e.getNome()%>">Delete</a></td>
			</tr>
		<%
			}
		%>
	</table>

</body>
</html>