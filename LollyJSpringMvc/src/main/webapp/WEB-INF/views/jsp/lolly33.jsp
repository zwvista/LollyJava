<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html ng-app="app">
<head>
<title>Spring4 Mvc jsp - Lolly</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
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
<form:form id="form" modelAttribute="formBean">
	<label for='selectedLangID'>Language:</label>
	<form:select path="selectedLangID" id="lang">
		<form:options items="${formBean.langList}" itemValue="langid" itemLabel="langname" />
	</form:select>
	<label for='selectedDictName'>Dictionary:</label>
	<form:select id="dict" path="selectedDictName" ng-model="selectedDictName">
		<option ng-repeat="o in dictList" ng-selected="{{o==selectedDictName}}" value="{{o}}">
		    {{o}}
		</option>
	</form:select>
	<label for='word'>Word:</label>
	<form:input type="text" path="word" id="word" />
	<input type="button" value="Search" id='search' ng-click="getDictUrl()" />
</form:form>
<iframe id='dictframe' width='100%' height='500' ng-src="{{trustSrc(dictUrl)}}">
</iframe>
</body>
</html>