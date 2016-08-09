<!DOCTYPE html>
<html>
<head>
<title>Struts2 velocity - Lolly</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/lolly.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/struts/utils.js"></script>
<script src="${pageContext.request.contextPath}/struts/xhtml/validation.js"></script>
#[[<script>
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
</script>]]#
</head>
<body>
#sform("theme=simple" "cssClass=form-horizontal" "action=search")
	<div class="form-group">
		<label class="col-sm-1 control-label" for='lang'>Language:</label>
    	<div class="col-sm-3">
			#sselect("cssClass=form-control" "id=lang" "name=selectedLangID" "value=selectedLangID" "list=langList" "listKey=id" "listValue=langname")
		</div>
		<label class="col-sm-1 control-label" for='dict'>Dictionary:</label>
    	<div class="col-sm-3">
			#sselect("cssClass=form-control" "id=dict" "name=selectedDictName" "value=selectedDictName" "list=langList" "listKey=id" "listValue=langname")
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-1 control-label" for='word'>Word:</label>
    	<div class="col-sm-3">
			#stextfield("cssClass=form-control" "id=word" "name=word")
		</div>
        #ssubmit("cssClass=btn btn-primary" "value=Search" "id=search")
        #ssubmit("cssClass=btn btn-primary" "value=Search(redirect)" "id=redirectSearch")
	</div>
#end
<iframe id='dictframe'>
</iframe>
</body>
</html>