<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>
<title>Struts1 - Lolly</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
$(function() {
	var $lang = $('#lang');
	var $dict = $('#dict');
	$lang.change(function() {
 	    $.post("dictList.do", $('#form').serialize(), function(response) {
            $dict.empty();
            $.each(response, function(index, dict) {
                $dict.append($('<option/>', {text: dict}));
            });
 		});
	});
	$lang.change();
	$('#search').click(function() {
	    $.post("dictUrl.do", $('#form').serialize(), function(response) {
			var word = $('#word').val();
			var url = response.replace('{0}', encodeURIComponent(word));
			$('#dictframe').attr('src', url);
	    });
	    return false;
	});
});
</script>
</head>
<body>
<html:form styleId="form">
	<table>
		<tr>
			<label for=''>Language:</label>
			<td>
				<html:select property="selectedLangID" styleId="lang">
				<html:optionsCollection name="lollyForm" property="langList" label="langname" value="langid"/>
				</html:select>
			</td>
			<label for=''>Dictionary:</label>
			<td>
				<html:select property="selectedDictName" styleId="dict">
				</html:select>
			</td>
		</tr>
		<tr>
			<label for=''>Word:</label>
			<td colspan=2>
				<html:text property="word" styleId="word" />
			</td>
            <td>
                <html:submit property="search" value="Search" styleId="search" />
            </td>
        </tr>
	</table>
</html:form>
<iframe id='dictframe' width='100%' height='500'>
</iframe>
</body>
</html>