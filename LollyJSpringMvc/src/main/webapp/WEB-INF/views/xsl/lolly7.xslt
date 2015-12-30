<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" omit-xml-declaration="yes"/>
<xsl:template match="/">
<html>
<head>
<title>Spring4 Mvc xsl - Lolly</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
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
<iframe id='dictframe' width='100%' height='500'>
</iframe>
</body>
</html>
</xsl:template>
<xsl:template match="java/object">
<form id="form" method="post">
	<label for='selectedLangID'>Language:</label>
	<select name="selectedLangID" id="lang" >
    	<xsl:for-each select="void[3]/void/object/void">
			<option>
			    <xsl:attribute name="value">
			    	<xsl:value-of select="string"/>
	   			</xsl:attribute>
				<xsl:value-of select="string[2]"/>
			</option>
		</xsl:for-each>
	</select>
	<label for='selectedDictName'>Dictionary:</label>
	<select name="selectedDictName" id="dict">
	</select>
	<label for='word'>Word:</label>
	<input type="text" id="word">
	    <xsl:attribute name="value">
	    	<xsl:value-of select="void/void/string"/>
		</xsl:attribute>
	</input>
	<input type="button" value="Search" id='search' />
</form>
</xsl:template>
</xsl:stylesheet>