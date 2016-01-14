<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<html>
<head>
<title>Struts2 - Lolly</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="resources/css/lolly.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
$(function() {
	var $lang = $('#lang');
	var $dict = $('#dict');
	$lang.change(function() {
 	    $.post("dictList", $('form').serialize(), function(response) {
            $dict.empty();
            $.each(response.dictList, function(index, dict) {
                $dict.append($('<option/>', {text: dict}));
            });
 		});
	});
	$lang.change();
	$('form').submit(function() {
		event.preventDefault();
	    $.post("dictUrl", $('form').serialize(), function(response) {
			var word = $('#word').val();
			var url = response.url.replace('{0}', encodeURIComponent(word));
			$('#dictframe').attr('src', url);
	    });
	    return false;
	});
});
</script>
</head>
<body>
<s:form>
	<s:select id="lang" name="selectedLangID" label="Language" value="selectedLangID" list="langList" listKey="langid" listValue="langname" />
	<s:select id="dict" name="selectedDictName" label="Dictionary" value="selectedDictName" list="langList" listKey="langid" listValue="langname" />
	<s:textfield id="word" name="word" label="Word" required="true" />
	<sj:submit value="Search" />
</s:form>
<iframe id='dictframe'>
</iframe>
</body>
</html>