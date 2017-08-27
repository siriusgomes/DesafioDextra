<%@ page import="sirius.desafio.dextra.model.Ingrediente"%>
<%@ page import="sirius.desafio.dextra.model.Lanche"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<html>
<body>
	<h1>Atualizar Lanche</h1>

	<%
		Lanche l = (Lanche)request.getAttribute("lanche");
		List<Ingrediente> listIngredientes = (List<Ingrediente>)request.getAttribute("listIngredientes");
	%>

	<form method="post" action="../update" >
		<input type="hidden" name="nomeOriginal" id="nomeOriginal"
			value="<%=l.getNome() %>" />

		<table>
			<tr>
				<td>
					Nome :
				</td>
				<td>
					<input type="text" style="width: 185px;"
                                             maxlength="30" name="nome" id="nome"
						value="<%=l.getNome() %>" />
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
									value="<%= l.getQuantidadeDeIngrediente().get(i.getNome()) == null ? "0" : l.getQuantidadeDeIngrediente().get(i.getNome()) %>" />
							</td>
						</tr>
						<% } %>
					</table>
				
				</td>
			</tr>
		</table>
		<input type="submit" class="update" title="Update" value="Update" />
		<a href="../list">Voltar</a>
	</form>

</body>
</html>