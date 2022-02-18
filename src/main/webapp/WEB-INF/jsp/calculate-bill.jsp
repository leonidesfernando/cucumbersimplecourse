<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Restaurant FreshVille</title>
    </head>
    <body>
        <div><h2>Eat more Cucumber Restaurant FreshVille</h2></div>

        <c:url var="controller" value="/calculator/finalBill"/>

        <form:form action="${controller}" method="post" modelAttribute="bill">
            <div>
                <form:label path="billAmount">Bill amount: </form:label> <form:input type="text" path="billAmount"/>
            </div>
            <div>
                <form:label path="taxRate">Tax Rate: </form:label> <form:input type="text" path="taxRate"/>
            </div>
            <input type="submit" id="btnCalculate" value="calculate final bill"/>
            <c:if test="${not empty billCalculated}">
                <hr/>
                <h1>Bill Calculated</h1>
                <div id="billDisplayed">Bill amount: $${billCalculated.billAmount}</div>
                <div id="taxRateDisplayed">Tax rate:  ${billCalculated.taxRate} %</div>
                <div id="billCalculated">Final Bill calculated: $${billCalculated.billCalculated}</div>
            </c:if>
        </form:form>
    </body>
</html>