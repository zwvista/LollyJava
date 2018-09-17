	<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring4 Mvc jsp - Lolly</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../resources/css/lolly.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.17/vue.js"></script>
</head>
<body>
<div id="app">
<table class="table table-striped table-bordered">
<tr>
<th>id</th>
<th>language</th>
</tr>
<tr v-for="lang in langList">
<td>{{lang.id}}</td>
<td>{{lang.langname}}</td>
</tr>
</table>
<form class="form-horizontal" action="search" method="post">
	<div class="form-group">
		<label class="col-sm-1 control-label" for='lang'>Language:</label>
    	<div class="col-sm-3">
			<select class="form-control" @change="langChange()" name="selectedLangID" id='lang'>
				<option v-for="lang in langList" :value="lang.id">{{lang.langname}}</option>
			</select>
		</div>
 		<label class="col-sm-1 control-label" for='dict'>Dictionary:</label>
    	<div class="col-sm-3">
			<select class="form-control" name="selectedDictName" id='dict'>
				<option v-for="o in dictList" :value="o">{{o}}</option>
			</select>
		</div>
	</div>
 	<div class="form-group">
		<label class="col-sm-1 control-label" for='word'>Word:</label>
    	<div class="col-sm-3">
			<input class="form-control" v-model="word" name="word" id="word" />
		</div>
	    <input type="submit" class="btn btn-primary" value='Search' id='search' @click="searchClick()" />
	    <input type="submit" class="btn btn-primary" value='Search(redirect)' id='redirectSearch' @click="redirectSearchClick()" />
        <div class="col-sm-3 error vcenter" id='wordError'>{{wordError}}</div>
	</div>
</form>
<iframe id='dictframe' :src="dictUrl">
</iframe>
<script>
var app = new Vue({
	el: '#app',
	data: {
		langList: [],
	    dictList: [],
	    word: '${formBean.word}',
	    redirectSearch: false,
	    wordError: '',
	    dictUrl: 'about:blank',
  	},
  	mounted: function() {
  		<c:forEach items="${formBean.langList}" var="lang">
  		this.langList.push({id: ${lang.id}, langname: '${lang.langname}'});
  		</c:forEach>
  	},
 	methods: {
	    langChange: function() {
	    	var self = this;
	        $.post("dictList3", $('form').serialize(), function(response) {
	        	self.dictList = response;
	        });
	    },
		formSubmit: function() {
			if(this.redirectSearch) return;
			event.preventDefault();
	    	var self = this;
	        $.ajax({
	            type: "POST",
	            url: "dictall3",
	            data: $('form').serialize(),
	            success: function(response) {
	            	self.wordError = '';
	                var url = response.url.replace('{0}', encodeURIComponent(this.word));
	                self.dictUrl = url;
	            },
	            error: function(response) {
	                //alert(JSON.stringify(response));
	                var err = response.responseJSON[0];
	                self.wordError = err.field + ": " + err.defaultMessage;
	                self.dictUrl = 'about:blank';
	            }
	        });
	    },
	    searchClick: function() {
	    	this.redirectSearch = false;
	    	this.formSubmit();
	    },
	    redirectSearchClick: function() {
	    	this.redirectSearch = true;
	    },
	}
});
$(function() {
	app.langChange();
});
</script>
</div>
</body>
</html>