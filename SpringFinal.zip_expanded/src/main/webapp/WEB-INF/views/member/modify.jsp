<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="https://code.jquery.com/jquery-3.7.1.min.js">
</script>
<title>회원 정보 수정</title>
</head>
<body>
  <header>
    <a href="../board/list">메인</a>
  </header>
  <sec:authentication property="principal" var="user"/>
  <form id="modifyForm" action="modify" method="POST">
    <div class="modify-content">
      <div class="modify-group">  
      <div class="join-row">
          <h3 class="join-title">
            <label for="memberId">아이디</label>
          </h3>
          <span>
          	${memberDTO.memberId }
            <input id="memberId" type="hidden" name="memberId" value="${memberDTO.memberId }">
            <br>
          </span>
        </div>      
        <div class="modify-row">
          <h3 class="modify-title">
            <label for="memberPw">비밀번호</label>
          </h3>
          <span>
            <input id="memberPw" type="password" name="memberPw" title="비밀번호" maxlength="16" >
            <br>
          </span>
          <span id="pwMsg" ></span>
          
          <h3 class="modify-title">
            <label for="pwConfirm">비밀번호 재확인</label>
          </h3>
          <span>
            <input id="pwConfirm" type="password" title="비밀번호 확인" maxlength="16" >
            <br>
          </span>
          <span id="pwConfirmMsg"></span>
          <h3 class="modify-title">
          	<label for="memberName">이름</label>
          </h3>
          <span>
            <input id="memberName" type="text" name="memberName" title="이름" maxlength="10" value="${memberDTO.memberName }">
            <br>
          </span>
          <span id="nameMsg"></span>
        </div>
      </div>
      <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
      <hr>
    </div>  
  </form>
  
  <button id="btnModify">제출</button>
  
  <script type="text/javascript">
  	$(document).ready(function(){

  		var pwFlag = false; // memberPw 유효성 변수 
  		var pwConfirmFlag = false; // pwConfirm 유효성 변수 
  		var nameFlag = false; // memberName 유효성 변수 
		
	  	// 비밀번호 유효성 검사
	  	$('#memberPw').blur(function() {
	  		var memberPw = $('#memberPw').val();
	  		var pwRegExp = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$^&*-]).{8,16}$/; 
	  		// 8 ~ 16 사이의 대문자, 소문자, 숫자, 특수문자를 1개 이상 포함하는 정규 표현식
	  		
	  		
	  		if(memberPw === '') { // 비밀번호가 입력되지 않은 경우
	  	  		$('#pwMsg').html('필수 입력입니다.');
	  	  		$('#pwMsg').css('color', 'red');
	  			pwFlag = false; // 유효성 false
	  	  		return;
	  	  	}
	  	  
	  		
	  	  	if(!pwRegExp.test(memberPw)) { // 입력한 비밀번호와 정규표현식이 일치하지 않는 경우
	  	  		pwFlag = false; // 유효성 false
	  	  		$('#pwMsg').html('8~16자 영문 대/소문자, 숫자, 특수문자를 모두 포함하세요');
	  	  		$('#pwMsg').css('color', 'red');
	  	  	} else {
	  	  		$('#pwMsg').html('가능한 비밀번호입니다.');
	  	  		$('#pwMsg').css('color', 'green');
	  	  		pwFlag = true; // 유효성 true
	  	  	}
	  	}); // end memberPw.blur()
	  	
	  	// 비밀번호 확인 유효성 검사
	  	$('#pwConfirm').blur(function() {
	  		var memberPw = $('#memberPw').val();
	  	  	var pwConfirm = $('#pwConfirm').val();
	  	  	
	  	 	// 비밀번호 확인을 입력하지 않은 경우
	  	  	if(pwConfirm === '') {
	  	  		$('#pwConfirmMsg').html('필수 입력입니다.');
	  	  		$('#pwConfirmMsg').css('color', 'red');
	  	  		pwConfirmFlag = false; // 유효성 false
	  	  		
	  	  		return;
	  	 	}
	  	  
	  	 	// 입력한 비밀번호와 비밀번호 확인이 일치하는 경우
	  	  	if(memberPw === pwConfirm) {
	  	  		$('#pwConfirmMsg').html('비밀번호가 일치합니다.');
	  	  		$('#pwConfirmMsg').css('color', 'green');
	  	  		pwConfirmFlag = true; // 유효성 true
	  	  		
	  	  	} else {
	  	  		$('#pwConfirmMsg').html('비밀번호가 일치하지 않습니다.');
	  	  		$('#pwConfirmMsg').css('color', 'red');
	  	  		pwConfirmFlag = false; // 유효성 false
	  	  		
	  	  	}
	  	  
	  	});
	  	
	  	// 이름 유효성 검사
	  	$('#memberName').blur(function() {
			var memberName = $('#memberName').val(); // 입력한 데이터 값

		  	if(memberName.trim() === '') {  // 이름이 입력되지 않았을 경우
		  		$('#nameMsg').html('필수 입력입니다.');
		  		$('#nameMsg').css('color', 'red');
		  		nameFlag = false; // 유효성 false
		  	   	return;
		  	} else {
		  		$('#nameMsg').html('');
		  		nameFlag = true; // 유효성 true
		  	} 

		});
	  	
	  	// 회원 정보 form 데이터 전송
	  	$('#btnModify').click(function(){
	  		console.log('pwFlag : ' + pwFlag);
	  		console.log('pwConfirmFlag : ' + pwConfirmFlag);
	  		console.log('nameFlag : ' + nameFlag);
	  		
	  		setTimeout(function(){
		  		if(pwFlag && pwConfirmFlag && nameFlag) { // 입력된 데이터가 모두 유효한 경우
		  			$('#modifyForm').submit(); // form 전송 실행
		  		}	  			
	  		}, 500); // 0.5초 후에 실행
	  	});
	  	
  });

  </script>
  
</body>
</html>













