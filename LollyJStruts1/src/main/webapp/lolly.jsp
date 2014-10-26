<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>
<title>Strut1 -Lolly</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
$(function() {
	var $lang = $('#lang1');
	var $dict = $('#dict1');
	$lang.change(function() {
 	    $.post("dictList", $(this).serialize(), function(response) {
            $dict.empty();
            $.each(response.dictList, function(index, dict) {
                $dict.append($('<option/>', {text: dict}));
            });
 		});
	});
	$lang.change();
	$('#search').click(function() {
		// cannot use $(this).serialize()
	    $.post("dictUrl", $('#form').serialize(), function(response) {
			var word = $('#word').val();
			var url = response.url.replace('{0}', encodeURIComponent(word));
			// alert(url);
			$('#dictframe').attr('src', url);
	    });
	    return false;
	});
});
</script>
</head>
<body>
<html:form>
	<table>
		<tr>
			<td>Language:</td>
			<td>
				<html:select property="selectedLangID">
				<html:optionsCollection name="lollyForm" property="langList" label="langname" value="langid"/>
				</html:select>
			</td>
			<td>Dictionary:</td>
			<td>
				<html:select property="selectedDictName">
				</html:select>
			</td>
		</tr>
		<tr>
			<td>Word:</td>
			<td colspan=2>
				<html:text property="word" />
			</td>
            <td>
                <html:submit property="search" value="Search" />
            </td>
        </tr>
	</table>
</html:form>
<iframe id='dictframe' width='100%' height='500'>
</iframe>
</body>
</html>