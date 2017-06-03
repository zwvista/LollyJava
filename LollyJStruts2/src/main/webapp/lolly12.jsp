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
<script src="${pageContext.request.contextPath}/struts/utils.js"></script>
<script src="${pageContext.request.contextPath}/struts/xhtml/validation.js"></script>
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
    var redirectSearch = false;
    $('#search').click(function() {redirectSearch = false;});
    $('#redirectSearch').click(function() {redirectSearch = true;});
    $('form').submit(function() {
        if(redirectSearch) return;
		event.preventDefault();
	    $.post("dictUrl", $('form').serialize(), function(response) {
			var word = $('#word').val();
			var url = response.url.replace('{0}', encodeURIComponent(word));
			$('#dictframe').attr('src', url);
	    });
	});
});
</script>
<sj:head jqueryui="true"/>
</head>
<body>
<table class="table table-striped table-bordered">
<tr>
<th>id</th>
<th>language</th>
</tr>
<s:iterator value="langList">
<tr>
<td><s:property value="id" /></td>
<td><s:property value="langname" /></td>
</tr>
</s:iterator>
</table>
<s:form action='search'>
	<s:select id="lang" name="selectedLangID" label="Language" value="selectedLangID" list="langList" listKey="id" listValue="langname" />
	<s:select id="dict" name="selectedDictName" label="Dictionary" value="selectedDictName" list="langList" listKey="id" listValue="langname" />
	<s:textfield id="word" name="word" label="Word" required="true" />
    <sj:submit validate="true" value="Search" id="search" />
    <s:submit validate="true" value="Search(redirect)" id="redirectSearch" />
</s:form>
<iframe id='dictframe'>
</iframe>
</body>
</html>