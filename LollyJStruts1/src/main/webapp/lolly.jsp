<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
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
    $('form').submit(function() {
		if(validateLollyForm(this)) {
	        $.post("dictUrl.do", $('form').serialize(), function(response) {
	            var word = $('#word').val();
	            var url = response.replace('{0}', encodeURIComponent(word));
	            $('#dictframe').attr('src', url);
	        });
	    }
		return false;
	})
});
</script>
</head>
<body>
<html:form styleClass="form-horizontal" styleId="LollyForm">
	<div class="form-group">
		<label class="col-sm-1 control-label" for='lang'>Language:</label>
    	<div class="col-sm-3">
			<html:select styleClass="form-control" property="selectedLangID" styleId="lang">
				<html:optionsCollection name="lollyForm" property="langList" label="langname" value="langid"/>
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
	    <html:submit styleClass="btn btn-primary" property="search" value="Search" />
        <html:messages id="msg" message="true">
		    <li><bean:write name="msg" ignore="true"/></li>
		</html:messages>
	</div>
</html:form>
<iframe id='dictframe'>
</iframe>
</body>
</html>