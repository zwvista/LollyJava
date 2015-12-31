<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html ng-app="app">
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.0/angular.min.js"></script>
<script>
angular.module('app', []).controller("lollyCtrl", ["$scope", "$http", "$sce",
    	function($scope, $http, $sce) {
	$(function() {
		// ng-change won't work without ng-model
		var $lang = $('#lang');
		$lang.change(function() {
			$http.post('dictList3', $('#form').serialize(), {
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}).success(function(data) {
				// if we are not inside angular, we can use the following code instead
				// angular.element($('#lollyCtrl')).scope().dictList = data;
		        $scope.dictList = data;
		        $scope.selectedDictName = data[0];
		    });
		});
		$lang.change();
	});
	$scope.trustSrc = function(url) {
		return $sce.trustAsResourceUrl(url);
	};
	$scope.getDictUrl = function() {
		$scope.dictUrl = null;
		$http.post('dictall3', $('#form').serialize(), {
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function(response) {
			var word = $('#word').val();
			var url = response.url.replace('{0}', encodeURIComponent(word));
			$scope.dictUrl = url;
	    });
	};
}]);
</script>
</head>
<body ng-controller="lollyCtrl" id="lollyCtrl">
<form:form class="form-horizontal" id="form" modelAttribute="formBean">
	<div class="form-group">
		<label class="col-sm-2 control-label" for='lang'>Language:</label>
    	<div class="col-sm-4">
			<form:select class="form-control" path="selectedLangID" id="lang">
				<form:options items="${formBean.langList}" itemValue="langid" itemLabel="langname" />
			</form:select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for='dict'>Dictionary:</label>
    	<div class="col-sm-4">
			<form:select class="form-control" id="dict" path="selectedDictName" ng-model="selectedDictName">
				<option ng-repeat="o in dictList" ng-selected="{{o==selectedDictName}}" value="{{o}}">
				    {{o}}
				</option>
			</form:select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for='word'>Word:</label>
    	<div class="col-sm-4">
			<form:input type="text" class="form-control" path="word" id="word" />
		</div>
	    <button type="button" class="btn btn-primary" id='search' ng-click="getDictUrl()">Search</button>
	</div>
</form:form>
<iframe id='dictframe' ng-src="{{trustSrc(dictUrl)}}">
</iframe>
</body>
</html>