<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<title>Struts2 - Lolly</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/lolly.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
    //$('#search').click(function() {redirectSearch = false;});
    $('#redirectSearch').click(function() {redirectSearch = true;});
	$('form').submit(function() {
		event.preventDefault();
	    $.post("dictUrl", $('form').serialize(), function(response) {
			var word = $('#word').val();
			var url = response.url.replace('{0}', encodeURIComponent(word));
            if(redirectSearch)
                window.location = url;
            else
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
<s:form theme="simple" cssClass="form-horizontal" action='search'>
	<div class="form-group">
		<label class="col-sm-1 control-label" for='lang'>Language:</label>
    	<div class="col-sm-3">
			<s:select cssClass="form-control" id="lang" name="selectedLangID" value="selectedLangID" list="langList" listKey="id" listValue="langname" />
		</div>
		<label class="col-sm-1 control-label" for='dict'>Dictionary:</label>
    	<div class="col-sm-3">
			<s:select cssClass="form-control" id="dict" name="selectedDictName" value="selectedDictName" list="langList" listKey="langid" listValue="langname" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-1 control-label" for='word'>Word:</label>
    	<div class="col-sm-3">
			<s:textfield cssClass="form-control" id="word" name="word" />
		</div>
		<sj:submit cssClass="btn btn-primary" value="Search" id='search' />
		<s:submit cssClass="btn btn-primary" value='Search(redirect)' id='redirectSearch' />
	</div>
</s:form>
<iframe id='dictframe'>
</iframe>
</body>
</html>