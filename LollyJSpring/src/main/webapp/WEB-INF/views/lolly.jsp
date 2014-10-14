<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<title>Spring4 MVC -Lolly</title>
</head>
<body>
<h1>Lolly</h1>
<form:form id="form" method="post" modelAttribute="formBean" action="options">
	<table>
		<tr>
			<td>Word:</td>
			<td><form:input path="word" /></td>
		</tr>
		<tr>
			<td>Language:</td>
			<td>
				<form:select path="" >
					<form:options items="${langList}" itemValue="langid" itemLabel="langname"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Dictionary:</td>
			<td>
				<form:select path="" >
					<form:options items="${dictList}" itemValue="dictid" itemLabel="dictname"/>
				</form:select>
			</td>
		</tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="Search" />
            </td>
        </tr>
	</table>
</form:form>
</body>
</html>