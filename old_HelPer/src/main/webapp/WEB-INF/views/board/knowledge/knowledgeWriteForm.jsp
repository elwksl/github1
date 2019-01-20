<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->
<title>Helper - Foriener &amp; Help HTML Template</title>

<!-- Favicon -->
<link rel="icon" href="resources/img/core-img/favicon.ico">

<!-- Core Stylesheet -->
<link rel="stylesheet" href="resources/style.css">


</head>
<div class="preloader d-flex align-items-center justify-content-center">
	<div class="preloader-circle"></div>
	<div class="preloader-img">
		<img src="resources/img/core-img/leaf.png" alt="">
	</div>
</div>

<jsp:include page="../../setting/header01.jsp" flush="false" />

<!-- ##### Breadcrumb Area Start ##### -->
<div class="breadcrumb-area">
	<!-- Top Breadcrumb Area -->
	<div
		class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center"
		style="background-image: url(img/bg-img/24.jpg);">
		<h2>CONTENT</h2>
	</div>
</div>
<!-- ##### Breadcrumb Area End ##### -->
<!-- ##### Header Area End ##### -->
<div class="container" style="margin-bottom: 50px;margin-top: 30px;">
	<div style="width:800px; margin:auto;">

<!-- 동욱이 css -->
<link rel="stylesheet" href="resources/ehddnr.css">
<script type="text/javascript" src="resources/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function onsubmitcheck(){
		if(!$('#knowledgeSubject').val()){
			$('#knowledgeSubject').focus();
			$('#knowledgeSubject').attr('placeholder',"제목을 입력하세요.");
			$('#knowledgeSubject').focus().fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
			return false;
		} else if(!$('#knowledgeContent').val()){
			$('#knowledgeContent').focus();
			$('#knowledgeContent').attr('placeholder',"내용을 입력하세요.");
			$('#knowledgeContent').focus().fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
			return false;
		} 
	}
		$(function() {
			$('textarea.content').keyup(function() {
				bytesHandler(this);
			});
		});

		function getTextLength(str) {
			var len = 0;

			for (var i = 0; i < str.length; i++) {
				if (escape(str.charAt(i)).length == 6) {
					len++;
				}
				len++;
			}
			return len;
		}

		function bytesHandler(obj) {
			var text = $(obj).val();
			$('p.bytes').text(getTextLength(text));
		}

		function knowledge() {
			window.location = "knowledge";
		}
		function thbackground(Reward_th) {
			var Reward_th2 = $(Reward_th).text();
			$('.knowledgeWriteForm_Reward_th').css('background-color', '#fff');
			$(Reward_th).css('background-color', 'green');
			$('#addReward').val(Reward_th2);
		}
		function knowledgeWriteForm_Reward_block() {
			$('.knowledgeWriteForm_Reward').css('display', 'block')
			
		}
		function knowledgeWriteForm_Reward_none() {
			$('.knowledgeWriteForm_Reward').css('display', 'none')
			$('#addReward').val('0');
		}
		function knowledgeWriteForm_addReward(){
			
			var addReward = $('#addReward').val();
			if(!$.isNumeric(addReward)){
				$('#addReward').focus();
				$('#addReward').val(null);
				$('#addReward').attr('placeholder',"숫자를 입력하세요.");
				$('#addReward').focus().fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
				return false;
			} 
			$('p.class_addReward').text('포인트 '+addReward+'을 채택자에게 드립니다.');
			$('.knowledgeWriteForm_Reward').css('display', 'none')
		}
	</script>
	<form action="knowledgeWritePro" method="post" name="knowledgeForm" onsubmit="return onsubmitcheck();">
		<ul>
			<li>
				<p align="center">
				 <img src="resources/img/ehddnr.gif" style="margin:0 0 10px 0;"> 
				 <input type="text" maxlength="100" name="knowledgeSubject" id="knowledgeSubject" style="width: 100%;">
				</p>
			</li>
			<li>
			<p style="display: inline" class="bytes">0</p>/5000</li>
			<li style="width: 100%; height: 500px; margin: 0 0 20px 0;">
			<textarea class="content" maxlength="5000"style="width: 100%; height: 100%;" name="knowledgeContent" id="knowledgeContent">
			</textarea>
			</li>
			<li style="position: relative; display:inline;">
					<input class="knowledgeWriteForm_button3" type="button" value="포인트 설정"
						onclick="knowledgeWriteForm_Reward_block();" style="display:inline-block;">
						<p class="class_addReward" style="display:inline-block;">&nbsp;채택한
					답변자에게 포인트를 드리며, 질문자에게도 포인트의 50%(최대100점)을 돌려드립니다.
				</p>
				<div class="knowledgeWriteForm_Reward">
					<table>
						<tr style="height: 10%">
							<th colspan="5">포인트 설정</th>
						</tr>
						<tr style="height: 20%">
							<th class="knowledgeWriteForm_Reward_th" id="Reward_th1"><span
								onclick="thbackground(Reward_th1);" >10</span></th>
							<th class="knowledgeWriteForm_Reward_th" id="Reward_th2"
								onclick="thbackground(Reward_th2);">20</th>
							<th class="knowledgeWriteForm_Reward_th" id="Reward_th3"
								onclick="thbackground(Reward_th3);">30</th>
							<th class="knowledgeWriteForm_Reward_th" id="Reward_th4"
								onclick="thbackground(Reward_th4);">40</th>
							<th class="knowledgeWriteForm_Reward_th" id="Reward_th5"
								onclick="thbackground(Reward_th5);">50</th>
						</tr>
						<tr style="height: 20%">
							<th class="knowledgeWriteForm_Reward_th" id="Reward_th6"
								onclick="thbackground(Reward_th6);">60</th>
							<th class="knowledgeWriteForm_Reward_th" id="Reward_th7"
								onclick="thbackground(Reward_th7);">70</th>
							<th class="knowledgeWriteForm_Reward_th" id="Reward_th8"
								onclick="thbackground(Reward_th8);">80</th>
							<th class="knowledgeWriteForm_Reward_th" id="Reward_th9"
								onclick="thbackground(Reward_th9);">90</th>
							<th class="knowledgeWriteForm_Reward_th" id="Reward_th10"
								onclick="thbackground(Reward_th10);">100</th>
						</tr>
						<tr style="height: 30%; width: 100%;">
							<td colspan="5" style="padding-top: 10px; text-align: left;">
								<p>
									<span style="font-size: 10px; float: right;">보유포인트 : ${userVO.memberPoint} </span><br>
									<input style="width: 100%;" type="text" id="addReward" name="addReward" value="0">
								</p>
							</td>
						</tr>
						<tr center="center" style="height: 20%">
							<td colspan="5">
								<input class="knowledgeWriteForm_button3" type="button"	value="확인" onclick="return knowledgeWriteForm_addReward();">
								<input class="knowledgeWriteForm_button3" type="button" value="취소" onclick="knowledgeWriteForm_Reward_none();">
							</td>
						</tr>
					</table>
				</div>
				<p>
					<input class="knowledgeWriteForm_button3" type="button" value="카테고리">&nbsp;
					<select class="btn_select" name="knowledgeCategory" id="btn_select">
						<option value="교육, 학문">교육, 학문</option>
						<option value="컴퓨터통신">컴퓨터통신</option>
						<option value="게임">게임</option>
						<option value="엔터테이먼트, 예술">엔터테이먼트, 예술</option>
						<option value="생활">생활</option>
						<option value="건강">건강</option>
						<option value="사회, 정치">사회, 정치</option>
						<option value=경제>경제</option>
						<option value="여행">여행</option>
						<option value="스포츠,레저">스포츠,레저</option>
						<option value="쇼핑">쇼핑</option>
						<option value="고민Q&A">고민Q&A</option>
					</select>
					<input style="margin-left:30px;"class="knowledgeWriteForm_button3" type="button" value="ID 공개여부">
					<input type="radio" name="knowledgeOpenCheck" value="Y" checked="checked">공개
					<input type="radio" name="knowledgeOpenCheck" value="N" >비공개
				</p>
			</li>
			<li align="center">
				<br>
				<input class="knowledgeWriteForm_button3" type="submit" value="질문등록">
				<input class="knowledgeWriteForm_button3" type="button"	value="목록보기" onclick="knowledge();">
			</li>
		</ul>
	</form>
	</div>
</div>

<!-- ##### Contact Area End ##### -->

<jsp:include page="../../setting/footer01.jsp" flush="false" />
<!-- ##### Footer Area End ##### -->

</body>
</html>