<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<html lang="en">
<body>
<script src="resources/js/jquery/jquery-2.2.4.min.js"></script>

<c:if test="${insertcnt==1}">
<script type="text/javascript">
	window.location="knowledge";
</script>
</c:if>

<c:if test="${insertcnt==0}">
<script type="text/javascript">
	alert('오류 발생. 잠시 후 다시 시도해 주세요.');
	window.history.back;
</script>
</c:if>

<c:if test="${kCommentCnt==1}">

<script type="text/javascript">
	window.location="knowledgeDetailForm?knowledgeNumber="+${knowledgeNumber};
</script>
</c:if>

<c:if test="${kCommentCnt==0}">
<script type="text/javascript">
	alert('오류 발생. 잠시 후 다시 시도해 주세요.');
	window.history.back;
</script>
</c:if>
</body>
</html>