<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<title>Spring4 MVC jsp - Lolly</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/linq.js/2.2.0.2/linq.min.js"></script>
<script>
$(function() {
	var $lang = $('#lang');
	var $dict = $('#dict');
	$lang.change(function() {
 	    $.post("dictList3", $(this).serialize(), function(response) {
			$("#dict option").remove();
			var options = Enumerable.From(response).Aggregate("",
				"acc, item => acc + '<option>' + item + '</option>'"
			);
			// alert(options);
			$dict.html(options);
 		});
	});
	$lang.change();
	$('#search').click(function() {
		// cannot use $(this).serialize()
	    $.post("dictall3", $('#form').serialize(), function(response) {
			var word = $('#word').val();
			var url = response.url.replace('{0}', encodeURIComponent(word));
			// alert(url);
			$('#dictframe').attr('src', url);
	    });
	});
});
</script>
</head>
<body>
<form:form id="form" method="post" modelAttribute="formBean">
	<table>
		<tr>
			<td>Language:</td>
			<td>
				<form:select path="selectedLangID" id="lang" >
					<c:forEach items="${formBean.langList}" var="lang">
						<form:option value="${lang.langid}" label="${lang.langname}" />
					</c:forEach>
				</form:select>
			</td>
			<td>Dictionary:</td>
			<td>
				<form:select path="selectedDictName" id="dict">
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Word:</td>
			<td colspan=2><form:input type="text" path="word" id="word" /></td>
            <td>
                <input type="button" value="Search" id='search' />
            </td>
        </tr>
	</table>
</form:form>
<iframe id='dictframe' width='100%' height='500'>
</iframe>
</body>
</html>