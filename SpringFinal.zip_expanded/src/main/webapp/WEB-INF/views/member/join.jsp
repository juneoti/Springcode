<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="https://code.jquery.com/jquery-3.7.1.min.js">
</script>
<title>회원가입</title>
</head>
<body>
  <header>
    <a href="../board/list">메인</a>
  </header>
  <form id="joinForm" action="join" method="POST">
    <div class="join-content">
      <div class="row-group">
        <div class="join-row">
          <h3 class="join-title">
            <label for="memberId">아이디</label>
          </h3>
          <span>
            <input id="memberId" type="text" name="memberId" title="아이디" maxlength="10" >
            <br>
          </span>
          <span id="idMsg" ></span>
        </div>
        
        <div class="join-row">
          <h3 class="join-title">
            <label for="memberPw">비밀번호</label>
          </h3>
          <span>
            <input id="memberPw" type="password" name="memberPw" title="비밀번호" maxlength="16" >
            <br>
          </span>
          <span id="pwMsg" ></span>
          
          <h3 class="join-title">
            <label for="pwConfirm">비밀번호 재확인</label>
          </h3>
          <span>
            <input id="pwConfirm" type="password" title="비밀번호 확인" maxlength="16" >
            <br>
          </span>
          <span id="pwConfirmMsg"></span>
          <h3 class="join-title">
          	<label for="memberName">이름</label>
          </h3>
          <span>
            <input id="memberName" type="text" name="memberName" title="이름" maxlength="10" >
            <br>
          </span>
          <span id="nameMsg"></span>
        </div>
      </div>
      <!-- 스프링 시큐리티를 사용하면 모든 post 전송에 csrf 토큰을 추가해야 함 -->
      <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
      <hr>
    </div>  
  </form>
  
  <button id="btnJoin">제출</button>
  
  <script type="text/javascript">
  	$(document).ready(function(){

  		var idFlag = false; // memberId 유효성 변수 
  		var pwFlag = false; // memberPw 유효성 변수 
  		var pwConfirmFlag = false; // pwConfirm 유효성 변수 
  		var nameFlag = false; // memberName 유효성 변수 

  		// blur() : input 태그에서 탭 키나 마우스로 다른 곳을 클릭할 때 이벤트 발생
  		// 아이디 유효성 검사
	  	$('#memberId').blur(function(){ 
	  		console.log('blur()');
			var memberId = $('#memberId').val(); // 입력한 아이디 값
		  	var idRegExp = /^[a-z0-9][a-z0-9_\-]{4,9}$/; 
		  	// 5 ~ 10자 사이의 소문자나 숫자로 시작하고, 소문자, 숫자 밑줄 또는 하이픈을 포함하는 정규표현식
		  	
		  	if(memberId === '') {  // 아이디가 입력되지 않은 경우
		  		$('#idMsg').html('필수 입력입니다.');
		  		$('#idMsg').css('color', 'red');
		  		idFlag = false; // 유효성 false
		  	   	return;
		  	} 
		  	
		  	
				
		  	if(!idRegExp.test(memberId)){ // 입력한 아이디와 정규표현식이 일치하지 않는 경우
		  		$('#idMsg').html('5~10자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.');
		  		$('#idMsg').css('color', 'red');
		  		idFlag = false; // 유효성 false
		  	} else {
		  		checkId(memberId); // 아이디 중복 확인
		  	} 
		}); // end memberId.blur()
		
	  	
	  	// 아이디 중복 확인 함수
	  	function checkId(memberId) {	
	  		// MemberController의 check()로 memberId 전송 
 			$.ajax({
  				type : 'GET', 
  				url : 'check/' + memberId,
  				success : function(result){
  					if(result == 0) { // 중복되지 않은 경우
  					  	$('#idMsg').html('멋진 아이디네요!');
  					  	$('#idMsg').css('color', 'green'); 
  					    idFlag = true; // 유효성 true
  					} else { // 중복된 경우
  					  	$('#idMsg').html('중복된 아이디입니다!');
  					  	$('#idMsg').css('color', 'red');  
  					  	idFlag = false; // 유효성 false
  					}
 	
  				}
  			}); // end ajax()	  		
	  	} // end checkId()
		
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
	  	$('#btnJoin').click(function(){
	  		console.log('idFlag : ' + idFlag);
	  		console.log('pwFlag : ' + pwFlag);
	  		console.log('pwConfirmFlag : ' + pwConfirmFlag);
	  		console.log('nameFlag : ' + nameFlag);
	  		// setTimeout() : 특정 시간 이후에 코드를 실행하는 함수. Millisecond
	  		setTimeout(function(){
		  		if(idFlag && pwFlag && pwConfirmFlag && nameFlag) { // 입력된 데이터가 모두 유효한 경우
		  			$('#joinForm').submit(); // form 전송 실행
		  		}	  			
	  		}, 500); // 0.5초 후에 실행
	  	});
	  	
  });

  </script>
  
</body>
</html>













