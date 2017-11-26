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
        $.post("dictList3", $('form').serialize(), function(response) {
            $dict.empty();
            $.each(response, function(index, dict) {
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
        $.ajax({
            type: "POST",
            url: "dictall3",
            data: $('form').serialize(),
            success: function(response) {
                $('#wordError').empty();
                var word = $('#word').val();
                var url = response.url.replace('{0}', encodeURIComponent(word));
                $('#dictframe').attr('src', url);
            },
            error: function(response) {
                //alert(JSON.stringify(response));
                var err = response.responseJSON[0];
                $('#wordError').html(err.field + ": " + err.defaultMessage);
                $('#dictframe').attr('src', 'about:blank');
            }
        });
    });
});
</script>
</head>
<body>
<table class="table table-striped table-bordered">
<tr>
<th>id</th>
<th>language</th>
</tr>
<c:forEach items="${formBean.langList}" var="lang">
<tr>
<td>${lang.id}</td>
<td>${lang.langname}</td>
</tr>
</c:forEach>
</table>
<form:form class="form-horizontal" modelAttribute="formBean" action='search'>
	<div class="form-group">
		<label class="col-sm-1 control-label" for='lang'>Language:</label>
    	<div class="col-sm-3">
			<form:select class="form-control" path="selectedLangID" id="lang">
				<c:forEach items="${formBean.langList}" var="lang">
					<form:option value="${lang.id}" label="${lang.langname}" />
				</c:forEach>
			</form:select>
		</div>
		<label class="col-sm-1 control-label" for='dict'>Dictionary:</label>
    	<div class="col-sm-3">
			<form:select class="form-control" path="selectedDictName" id="dict" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-1 control-label" for='word'>Word:</label>
    	<div class="col-sm-3">
			<form:input class="form-control" path="word" />
		</div>
        <input type="submit" class="btn btn-primary" value='Search' id='search' />
        <input type="submit" class="btn btn-primary" value='Search(redirect)' id='redirectSearch' />
        <div class="col-sm-3 error vcenter" id='wordError'></div>
	</div>
</form:form>
<iframe id='dictframe'>
</iframe>
</body>
</html>