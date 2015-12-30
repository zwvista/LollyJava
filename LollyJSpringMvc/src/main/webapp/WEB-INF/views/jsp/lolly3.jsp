<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
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
 	    $.post("dictList3", $('#form').serialize(), function(response) {
            $dict.empty();
            $.each(response, function(index, dict) {
                $dict.append($('<option/>', {text: dict}));
            });
 		});
	});
	$lang.change();
	$('#search').click(function() {
	    $.post("dictall3", $('#form').serialize(), function(response) {
			var word = $('#word').val();
			var url = response.url.replace('{0}', encodeURIComponent(word));
			$('#dictframe').attr('src', url);
	    });
	});
});
</script>
</head>
<body>
<form:form id="form" modelAttribute="formBean">
	<label for='selectedLangID'>Language:</label>
	<form:select path="selectedLangID" id="lang" >
		<form:options items="${formBean.langList}" itemValue="langid" itemLabel="langname"/>
	</form:select>
	<label for='selectedDictName'>Dictionary:</label>
	<form:select path="selectedDictName" id="dict" />
	<label for='word'>Word:</label>
	<form:input type="text" path="word" id="word" />
    <input type="button" value="Search" id='search' />
</form:form>
<iframe id='dictframe' width='100%' height='500'>
</iframe>
</body>
</html>