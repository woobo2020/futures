success: function(result){
        		var resultCode = result.resultStr;
        		//alert(resultCode);
        		if(resultCode == 'OK'){ //성공
        			document.getElementById('msgErrSpan').style.display = "none";
        			alert("입력하신 이메일로 아이디를 발송했습니다.");
        			window.document.location.href="/main.do";
        		}else if(resultCode == 'NOT_EXIST'){
					document.getElementById('msgErrSpan').style.display = "block";
        		}else if(resultCode == 'BLOCKED'){
					document.getElementById('msgErrSpan').style.display = "block";
					alert("신청 횟수가 초과되어 해당 서비스를 2시간 동안 사용할수 없습니다.");
        		}else if(resultCode == 'OVERCOUNT'){
					document.getElementById('msgErrSpan').style.display = "block";
					alert("이미 전송되었습니다. 이메일 확인부탁드립니다.");
        		}else{
        			document.getElementById('msgErrSpan').style.display = "none";
        			alert("오류가 발생했습니다. 잠시후 다시 시도해주세요");
        			return
        		}
        	}