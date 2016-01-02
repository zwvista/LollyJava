<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" version="4.0" encoding="utf-8" indent="yes" omit-xml-declaration="yes"/>
<xsl:template match="/">
<xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Spring4 Mvc xsl - Lolly</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../resources/css/lolly.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
$(function() {
	var $lang = $('#lang');
	var $dict = $('#dict');
	$lang.change(function() {
 	    $.post("dictList3", $('#form').serialize(), function(response) {
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
	    $.post("dictall3", $('#form').serialize(), function(response) {
			var word = $('#word').val();
			var url = response.url.replace('{0}', encodeURIComponent(word));
			$('#dictframe').attr('src', url);
	    });
	});
});
</script>
</head>
<body>
<xsl:apply-templates />
<iframe id='dictframe'>
</iframe>
</body>
</html>
</xsl:template>
<xsl:template match="java/object">
<form class="form-horizontal" id="form">
	<div class="form-group">
		<label class="col-sm-2 control-label" for='lang'>Language:</label>
    	<div class="col-sm-4">
			<select class="form-control" name="selectedLangID" id="lang" >
		    	<xsl:for-each select="void[3]/void/object/void">
					<option>
					    <xsl:attribute name="value">
					    	<xsl:value-of select="string"/>
			   			</xsl:attribute>
						<xsl:value-of select="string[2]"/>
					</option>
				</xsl:for-each>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for='dict'>Dictionary:</label>
    	<div class="col-sm-4">
			<select class="form-control" name="selectedDictName" id="dict">
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for='word'>Word:</label>
    	<div class="col-sm-4">
			<input type="text" class="form-control" id="word">
			    <xsl:attribute name="value">
			    	<xsl:value-of select="void/void/string"/>
				</xsl:attribute>
			</input>
		</div>
	    <button type="button" class="btn btn-primary" id='search'>Search</button>
	</div>
</form>
</xsl:template>
</xsl:stylesheet>