<html>
<head>
<title>Spring4 Mvc - Lolly</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../resources/css/lolly.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
$(function() {
	$('input[name=orm]').change(function() {
		var orm = $(this).val();
		$('a').each(function(i, e) {
			$(e).attr('href', orm + '/' + $(e).text());
		});
	});
	$('input[value=hibernate]').click();
});
</script>
</head>
<body>
<p>
    <label class="radio-inline">
        <input type="radio" name="orm" value="hibernate"> hibernate
    </label>
    <label class="radio-inline">
        <input type="radio" name="orm" value="jpa"> jpa
    </label>
    <label class="radio-inline">
        <input type="radio" name="orm" value="mybatis"> mybatis
    </label>
    <label class="radio-inline">
        <input type="radio" name="orm" value="jooq"> jooq
    </label>
</p>
<a href="">lolly1</a><br/>
<a href="">lolly2</a><br/>
<a href="">lolly3</a><br/>
<a href="">lolly32</a><br/>
<a href="">lolly33</a><br/>
<a href="">lolly4</a><br/>
<a href="">lolly5</a><br/>
<a href="">lolly52</a><br/>
<a href="">lolly6</a><br/>
<a href="">lolly62</a><br/>
<a href="">lolly7</a><br/>
</body>
</html>
