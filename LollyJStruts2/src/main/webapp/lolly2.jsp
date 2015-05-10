<!DOCTYPE html >
<html>
<head>
<title>Struts2 velocity - Lolly</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
#[[<script>
$(function() {
	var $lang = $('#lang');
	var $dict = $('#dict');
	$lang.change(function() {
 	    $.post("dictList2", $(this).serialize(), function(response) {
            $dict.empty();
            $.each(response.dictList, function(index, dict) {
                $dict.append($('<option/>', {text: dict}));
            });
 		});
	});
	$lang.change();
	$('#search').click(function() {
		// cannot use $(this).serialize()
	    $.post("dictUrl2", $('#form').serialize(), function(response) {
			var word = $('#word').val();
			var url = response.url.replace('{0}', encodeURIComponent(word));
			// alert(url);
			$('#dictframe').attr('src', url);
	    });
	    return false;
	});
});
</script>]]#
</head>
<body>
#sform("id=form" "method=post")
	#sselect("id=lang" "name=selectedLangID" "label=Language" "value=selectedLangID" "list=langList" "listKey=langid" "listValue=langname")
	#sselect("id=dict" "name=selectedDictName" "label=Dictionary" "value=selectedDictName" "list=langList" "listKey=langid" "listValue=langname")
	#stextfield("id=word" "name=word" "label=Word")
	#ssubmit("value=Search" "id=search")
#end
<iframe id='dictframe' width='100%' height='500'>
</iframe>
</body>
</html>