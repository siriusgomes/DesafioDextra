<%@ page import="sirius.desafio.dextra.model.Ingrediente"%>
<%@ page import="sirius.desafio.dextra.model.Lanche"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<html>
<body>
	<h1>Adicionar Lanche</h1>

	<%
		List<Ingrediente> listIngredientes = (List<Ingrediente>)request.getAttribute("listIngredientes");
	%>

	<form method="post" action="add" >

		<table>
			<tr>
				<td>
					Nome :
				</td>
				<td>
					<input type="text" style="width: 185px;"                              maxlength="30" name="nome" id="nome" />
				</td>
			</tr>
			<tr>
				<td>
					Ingredientes :
				</td>
				<td>

					<table border="1">
					<thead>
						<tr>
							<td>Nome</td>
							<td>Quantidade</td>
						</tr>
					</thead>
					<% for(Ingrediente i : listIngredientes) {  %>
						<tr>
							<td>
								<%= i.getNome() %>
							</td>
							<td>
								<input type="text" style="width: 105px;"
			                                            maxlength="10" name="qtd_<%=i.getNome()%>" id="qtd_<%=i.getNome()%>"
									value="0" />
							</td>
						</tr>
						<% } %>
					</table>
				
				</td>
			</tr>
		</table>
		<input type="submit" class="sava" title="Salvar" value="Salvar" />
		<a href="list">Voltar</a>
	</form>

</body>
</html>