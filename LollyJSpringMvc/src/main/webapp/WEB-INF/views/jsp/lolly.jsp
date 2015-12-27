<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<title>Spring4 Mvc jsp - Lolly</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
$(function() {
	var $lang = $('#lang');
	var $dict = $('#dict');
	$lang.change(function() {
	    $.getJSON("dictList", {langid: $lang.val()}, function(response) {
            $dict.empty();
            $.each(response, function(index, item) {
				var jstring = encodeURIComponent(JSON.stringify(item));
                $dict.append($('<option/>', {value: jstring, text: item.id.dictname}));
            });
	    });
	});
	$lang.change();
	$('#search').click(function() {
		var item = JSON.parse(decodeURIComponent($dict.val()));
		var word = $('#word').val();
		var url = item.url.replace('{0}', encodeURIComponent(word));
		// alert(url);
		$('#dictframe').attr('src', url);
	});
});
</script>
</head>
<body>
<form:form id="form" modelAttribute="formBean">
	<table>
		<tr>
			<td>Language:</td>
			<td>
				<form:select path="selectedLangID" id="lang" >
					<form:options items="${formBean.langList}" itemValue="langid" itemLabel="langname"/>
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