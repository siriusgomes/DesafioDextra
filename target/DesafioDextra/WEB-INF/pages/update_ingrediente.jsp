<%@ page import="sirius.desafio.dextra.model.Ingrediente"%>
<html>
<body>
	<h1>Atualizar Ingrediente</h1>

	<%
		Ingrediente i = (Ingrediente)request.getAttribute("ingrediente");
	%>

	<form method="post" action="../update" >
		<input type="hidden" name="nomeOriginal" id="nomeOriginal"
			value="<%=i.getNome() %>" />

		<table>
			<tr>
				<td>
					Nome :
				</td>
				<td>
					<input type="text" style="width: 185px;"
                                             maxlength="30" name="nome" id="nome"
						value="<%=i.getNome() %>" />
				</td>
			</tr>
			<tr>
				<td>
					Valor :
				</td>
				<td>
					<input type="text" style="width: 185px;"
                                            maxlength="30" name="valor" id="valor"
						value="<%=i.getValor() %>" />
				</td>
			</tr>
		</table>
		<input type="submit" class="update" title="Update" value="Update" />
	</form>

</body>
</html>