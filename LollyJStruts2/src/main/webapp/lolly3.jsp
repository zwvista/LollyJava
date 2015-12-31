<!DOCTYPE html>
<html>
<head>
<title>Struts2 freemarker - Lolly</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/lolly.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
$(function() {
	var $lang = $('#lang');
	var $dict = $('#dict');
	$lang.change(function() {
 	    $.post("dictList3", $('#form').serialize(), function(response) {
            $dict.empty();
            $.each(response.dictList, function(index, dict) {
                $dict.append($('<option/>', {text: dict}));
            });
 		});
	});
	$lang.change();
	$('#search').click(function() {
	    $.post("dictUrl3", $('#form').serialize(), function(response) {
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
<@s.form id="form">
	<@s.select id="lang" name="selectedLangID" label="Language:" value="selectedLangID" list="langList" listKey="langid" listValue="langname" />
	<@s.select id="dict" name="selectedDictName" label="Dictionary:" value="selectedDictName" list="langList" listKey="langid" listValue="langname" />
	<@s.textfield id="word" name="word" label="Word:" />
	<@s.submit value="Search" id='search' />
</@s.form>
<iframe id='dictframe'>
</iframe>
</body>
</html>