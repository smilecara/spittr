<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page session="false" %>
<div class ="spittleView">
	<div class="spittleMessage"><c:out value="${spittle.message}"/>
	</div>
	<div >
		<span  class="spittleTime"><c:out value="${spittle.time}"/></span>
	</div>
</div>