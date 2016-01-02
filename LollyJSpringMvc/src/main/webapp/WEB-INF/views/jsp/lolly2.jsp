<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring4 Mvc jsp - Lolly</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../resources/css/lolly.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
$(function() {
	var $lang = $('#lang');
	var $dict = $('#dict');
	$lang.change(function() {
	    $.getJSON("dictList2", {langid: $lang.val()}, function(response) {
            $dict.empty();
            $.each(response, function(index, dict) {
                $dict.append($('<option/>', {text: dict}));
            });
	    });
	});
	$lang.change();
	$('#word').keypress(function(event) {
		if(event.which == 13){
			event.preventDefault();
			$('#search').click();
		}
	});
	$('#search').click(function() {
	    $.getJSON("dictall2", {langid: $lang.val(), dictname: $dict.val()}, function(response) {
			var word = $('#word').val();
			var url = response.url.replace('{0}', encodeURIComponent(word));
			$('#dictframe').attr('src', url);
	    });
	});
});
</script>
</head>
<body>
<form:form class="form-horizontal" id="form" modelAttribute="formBean">
	<div class="form-group">
		<label class="col-sm-2 control-label" for='lang'>Language:</label>
    	<div class="col-sm-4">
			<form:select class="form-control" path="selectedLangID" id="lang">
				<form:options items="${formBean.langList}" itemValue="langid" itemLabel="langname" />
			</form:select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for='dict'>Dictionary:</label>
    	<div class="col-sm-4">
			<form:select class="form-control" path="selectedDictName" id="dict" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for='word'>Word:</label>
    	<div class="col-sm-4">
			<form:input type="text" class="form-control" path="word" id="word" />
		</div>
	    <button type="button" class="btn btn-primary" id='search'>Search</button>
	</div>
</form:form>
<iframe id='dictframe'>
</iframe>
</body>
</html>