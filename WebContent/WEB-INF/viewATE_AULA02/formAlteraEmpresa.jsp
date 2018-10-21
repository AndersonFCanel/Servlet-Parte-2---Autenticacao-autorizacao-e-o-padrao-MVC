<!-- Importação jstl -->>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Valor definido na EL c:url -->
	<form action="${linkEntradaServlet }" method="post">
	
		Nome: <input type="text" name="nome" value="${empresa.nome }" />
		Data Abertura: <input type="text" name="data"  value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>" />
		<!-- Esconder id para que o mesmo não possa ser alterado -->
		<input type="hidden" name="id" value="${empresa.id }">
		<!-- O campo com value altera empresa é para que possa ser passado para a classe UnicaEntradaServlet o valor correto -->
		<input type='hidden' name='acao' value="AlteraEmpresa">
		<input type="submit" />
	</form>

</body>
</html>