<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<title>Spring4 MVC -Lolly</title>
</head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/linq.js/2.2.0.2/linq.min.js"></script>
<script>
</script>
$(function(){
	$('#lang').change(function() {
	    $.getJSON(
	        "dictList.html",
	        {langid: $('#lang').val()},
	        function(data) {
				var html = '';
				var len = data.length;
				for(var i=0; i<len; i++){
					html += '<option value="' + data[i].id.langid + '">' + data[i].id.dictname + '</option>';
				}
				$('#dict').append(html);
	        }
        );
	});
});
<body>
<form:form id="form" method="post" modelAttribute="formBean" action="options">
	<table>
		<tr>
			<td>Language:</td>
			<td>
				<form:select path="selectLang" id="lang" >
					<form:options items="${formBean.langList}" itemValue="langid" itemLabel="langname"/>
				</form:select>
			</td>
			<td>Dictionary:</td>
			<td>
				<form:select path="selectDict" id="dict" >
					<form:options items="${formBean.dictList}" itemValue="dictid" itemLabel="dictname"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Word:</td>
			<td colspan=2><form:input path="word" /></td>
            <td>
                <input type="submit" value="Search" />
            </td>
        </tr>
	</table>
</form:form>
</body>
</html>