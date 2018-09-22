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
        event.preventDefault();
        $.ajax({
            type: "POST",
            url: "dictall3",
            data: $('form').serialize(),
            success: function(response) {
                $('#wordError').empty();
                var word = $('#word').val();
                var url = response.url.replace('{0}', encodeURIComponent(word));
                if(redirectSearch)
                    window.location = url;
                else
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
<xsl:apply-templates />
<iframe id='dictframe'>
</iframe>
</body>
</html>
</xsl:template>
<xsl:template match="java/object">
<table class="table table-striped table-bordered">
<tr>
<th>id</th>
<th>language</th>
</tr>
<xsl:for-each select="void[3]/void/object/void">
<tr>
<td><xsl:value-of select="string"/></td>
<td><xsl:value-of select="string[2]"/></td>
</tr>
</xsl:for-each>
</table>
<form class="form-horizontal" method="post" action='search'>
	<div class="form-group">
		<label class="col-sm-1 control-label" for='lang'>Language:</label>
    	<div class="col-sm-3">
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
		<label class="col-sm-1 control-label" for='dict'>Dictionary:</label>
    	<div class="col-sm-3">
			<select class="form-control" name="selectedDictName" id="dict">
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-1 control-label" for='word'>Word:</label>
    	<div class="col-sm-3">
			<input type="text" class="form-control" name="word" id="word">
			    <xsl:attribute name="value">
			    	<xsl:value-of select="void/void/string"/>
				</xsl:attribute>
			</input>
		</div>
        <input type="submit" class="btn btn-primary" value='Search' id='search' />
        <input type="submit" class="btn btn-primary" value='Search(redirect)' id='redirectSearch' />
        <div class="col-sm-3 error vcenter" id='wordError'></div>
	</div>
</form>
</xsl:template>
</xsl:stylesheet>