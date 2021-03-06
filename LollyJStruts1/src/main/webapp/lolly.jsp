<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Struts1 - Lolly</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/lolly.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
<html:javascript formName="LollyForm"/>
<script>
$(function() {
	var $lang = $('#lang');
	var $dict = $('#dict');
	$lang.change(function() {
 	    $.post("dictList.do", $('form').serialize(), function(response) {
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
        event.preventDefault();
		if(validateLollyForm(this)) {
	        $.post("dictUrl.do", $('form').serialize(), function(response) {
	            var word = $('#word').val();
	            var url = response.replace('{0}', encodeURIComponent(word));
                if(redirectSearch)
                    window.location = url;
                else
                    $('#dictframe').attr('src', url);
	        });
	    }
	})
});
</script>
</head>
<body>
<table class="table table-striped table-bordered">
<tr>
<th>id</th>
<th>language</th>
</tr>
<logic:iterate id="row" name="lollyForm" property="langList">
<tr>
<td><bean:write name="row" property="id"/></td>
<td><bean:write name="row" property="langname"/></td>
</tr>
</logic:iterate>
</table>
<html:form styleClass="form-horizontal" styleId="LollyForm" method="post" action='search'>
	<div class="form-group">
		<label class="col-sm-1 control-label" for='lang'>Language:</label>
    	<div class="col-sm-3">
			<html:select styleClass="form-control" property="selectedLangID" styleId="lang">
				<html:optionsCollection name="lollyForm" property="langList" label="langname" value="id"/>
			</html:select>
		</div>
		<label class="col-sm-1 control-label" for='dict'>Dictionary:</label>
    	<div class="col-sm-3">
			<html:select styleClass="form-control" property="selectedDictName" styleId="dict">
			</html:select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-1 control-label" for='word'>Word:</label>
    	<div class="col-sm-3">
			<html:text styleClass="form-control" property="word" styleId="word" />
		</div>
	    <html:submit styleClass="btn btn-primary" property="search" value="Search" styleId='search' />
        <html:submit styleClass="btn btn-primary" property="search" value="Search(redirect)" styleId='redirectSearch' />
	</div>
</html:form>
<iframe id='dictframe'>
</iframe>
</body>
</html>