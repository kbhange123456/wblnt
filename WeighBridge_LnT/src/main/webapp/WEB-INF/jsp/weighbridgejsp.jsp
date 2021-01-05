<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <link href="/resources/css/bootstrap.css" rel="stylesheet" /> -->
<link rel="shortcut icon" href = "/resources/favicon.ico"">
<title>Weigh Bridge</title>
<style>
body {
/* 	background-image: url("/resources/images/cotton.jpg"); */
background-image: linear-gradient(-45deg, rgba(218, 44, 77, 1),
		rgba(248, 171, 55, 0.5));
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
}

body:before {
	content: '';
	/* -webkit-filter: blur(10px); */
/* 	filter: blur(50px); */
	height: 100vh;
	position: absolute;
	/* 	top: 50%; */
	/* 	left: 50%; */
	z-index: -1;
	-webkit-transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
	width: 100vw;
}

.split {
	height: 100%;
	width: 50%;
	position: fixed;
	z-index: 1;
	top: 0;
	overflow-x: hidden;
	padding-top: 5px;
}

.left {
	left: 0;
}

.right {
	right: 0;
}

.centered {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	/*   text-align: center; */
}

.reportBtn {
	background: #3a518d;
	outline: none;
	-webkit-appearance: unset !important;
	/* 	display: block; */
	display: inline-block;
	margin-bottom: 31px;
	font-family: sans-serif;
	width: auto;
	height: auto;
/* 	background-image: linear-gradient(298deg, rgba(76, 175, 80, 1), */
/* 		rgba(76, 175, 80, 0.6)); */
background-image: linear-gradient(-45deg, rgba(218, 44, 77, 1),
		rgba(248, 171, 55, 0.5));
	color: #fff;
	padding: 16px 17px;
	font-size: 15px;
	align-content: center;
	border: none;
	-webkit-border-radius: 10px;
	cursor: pointer;
	-webkit-box-shadow: 0px 1px 15px 0px rgba(73, 102, 177, 0.7);
}

.table {
	background: rgba(255, 255, 255, 0.85);
	border-radius: 0.5em;
	box-shadow: 0 0 1em 0 rgba(51, 51, 51, 0.25);
	display: block;
	max-width: 85%;
	overflow: hidden;
	-webkit-transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
	padding: 2em;
	position: absolute;
	top: 50%;
	left: 50%;
	z-index: 1;
	width: 98%;
	height: 80%;
}

.weightbox {
	align-items: right;
	background-color: rgba(76, 175, 80, 1);
/* 	background: linear-gradient(-45deg, rgba(76, 175, 80, 1), */
/* 		rgba(76, 175, 80, 0.5)); */
background: linear-gradient(-45deg, rgba(218, 44, 77, 1),
		rgba(248, 171, 55, 0.5));
	box-shadow: 12px 12px 16px 0 rgba(73, 102, 177, 0.25), -8px -8px 12px 0
		rgba(62, 182, 230, 0.3);
	border-radius: 50px;
	display: flex;
	height: 100px;
	justify-content: center;
	width: 300px;
	float: right;
	font-size: 80px;
	align-content: right;
	
}

.weightbox1{
	align-items: right;
	background-color: rgba(76, 175, 80, 1);
	background: linear-gradient(-45deg, rgba(218, 44, 77, 1),
		rgba(248, 171, 55, 0.5));
	box-shadow: 12px 12px 16px 0 rgba(73, 102, 177, 0.25), -8px -8px 12px 0
		rgba(62, 182, 230, 0.3);
	border-radius: 50px;
	display: flex;
	height: 100px;
	justify-content: center;
	width: 300px;
	float: right;
	font-size: 80px;
	align-content: right;
}

.checkbox:checked ~ .section .container .row .col-12 p {
	color: var(--dark-blue);
}

.checkbox:checked ~ .section .container .row .col-12 .checkbox-tools:not(:checked)+label
	{
	background-color: var(--light);
	color: var(--dark-blue);
	box-shadow: 0 1x 4px 0 rgba(0, 0, 0, 0.05);
}

.checkbox:checked ~ .section .container .row .col-12 .checkbox-booking:not(:checked)+label,
	.checkbox:checked ~ .section .container .row .col-12 .checkbox-booking:checked+label
	{
	background-color: var(--light);
	color: var(--dark-blue);
}

.checkbox:checked ~ .section .container .row .col-12 .checkbox-booking:checked+label::after,
	.checkbox:checked ~ .section .container .row .col-12 .checkbox-booking:not(:checked)+label::after
	{
	background-color: var(--light);
}

.checkbox-tools:checked+label, .checkbox-tools:not(:checked)+label {
	position: relative;
	display: inline-block;
	padding: 20px;
	width: 110px;
	font-size: 14px;
	line-height: 20px;
	letter-spacing: 1px;
	margin: 0 auto;
	margin-left: 5px;
	margin-right: 5px;
	margin-bottom: 10px;
	text-align: center;
	border-radius: 30px;
	overflow: hidden;
	cursor: pointer;
	text-transform: uppercase;
	color: var(--white);
	-webkit-transition: all 300ms linear;
	transition: all 300ms linear;
}

.checkbox-tools:not(:checked)+label {
	background-color: var(--dark-light);
	box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.1);
}

.checkbox-tools:checked+label {
	background-color: transparent;
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.checkbox-tools:not(:checked)+label:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.checkbox-tools:checked+label::before, .checkbox-tools:not(:checked)+label::before
	{
	position: absolute;
	content: '';
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	border-radius: 30px;
/* 	background-image: linear-gradient(298deg, rgba(76, 175, 80, 0.2), */
/* 		rgba(76, 175, 80, 0.2)); */
		background-image: linear-gradient(-45deg, rgba(218, 44, 77, 1),
		rgba(248, 171, 55, 0.5));
	z-index: -1;
}

.checkbox-tools:checked+label .uil, .checkbox-tools:not(:checked)+label .uil
	{
	font-size: 24px;
	line-height: 24px;
	display: block;
	padding-bottom: 10px;
}

.checkbox:checked ~ .section .container .row .col-12 .checkbox-tools:not(:checked)+label
	{
	background-color: var(--light);
	color: var(--dark-blue);
	box-shadow: 0 1x 4px 0 rgba(0, 0, 0, 0.05);
}
/* a */
:root {
	--white: #ffffff;
	--light: #f0eff3;
	--black: #000000;
	--dark-blue: #1f2029;
	--dark-light: #353746;
	--red: #da2c4d;
	--yellow: #f8ab37;
	--grey: #ecedf3;
	
}

/* #Primary
================================================== */
::selection {
	color: var(--white);
	background-color: var(--black);
}

::-moz-selection {
	color: var(--white);
	background-color: var(--black);
}

mark {
	color: var(--white);
	background-color: var(--black);
}

.section {
	position: relative;
	width: 100%;
	display: block;
	text-align: center;
	margin: 0 auto;
}

.over-hide {
	overflow: hidden;
}

.z-bigger {
	z-index: 100 !important;
}

.checkbox:checked ~ .background-color {
	background-color: var(--white);
}

[type="checkbox"]:checked, [type="checkbox"]:not(:checked), [type="radio"]:checked,
	[type="radio"]:not(:checked) {
	position: absolute;
	left: -9999px;
	width: 0;
	height: 0;
	visibility: hidden;
}

.checkbox:checked+label, .checkbox:not(:checked)+label {
	position: relative;
	width: 70px;
	display: inline-block;
	padding: 0;
	margin: 0 auto;
	text-align: center;
	margin: 17px 0;
	margin-top: 100px;
	height: 6px;
	border-radius: 30px;
/* 	background-image: linear-gradient(298deg, rgba(76, 175, 80, 0.2), */
/* 		rgba(76, 175, 80, 0.2)); */
		background-image: linear-gradient(-45deg, rgba(218, 44, 77, 1),
		rgba(248, 171, 55, 0.5));
	z-index: 100 !important;
}

.checkbox:checked+label:before, .checkbox:not(:checked)+label:before {
	position: absolute;
	font-family: 'unicons';
	cursor: pointer;
	top: -17px;
	z-index: 2;
	font-size: 20px;
	line-height: 40px;
	text-align: center;
	width: 40px;
	height: 40px;
	border-radius: 50%;
	-webkit-transition: all 300ms linear;
	transition: all 300ms linear;
}

.checkbox:not(:checked)+label:before {
	content: '\eac1';
	left: 0;
	color: var(--grey);
	background-color: var(--dark-light);
	box-shadow: 0 4px 4px rgba(0, 0, 0, 0.15), 0 0 0 1px
		rgba(26, 53, 71, 0.07);
}

.checkbox:checked+label:before {
	content: '\eb8f';
	left: 30px;
	color: rgba(76, 175, 80, 0.2);
	background-color: var(--dark-blue);
	box-shadow: 0 4px 4px rgba(26, 53, 71, 0.25), 0 0 0 1px
		rgba(26, 53, 71, 0.07);
}

.checkbox:checked ~ .section .container .row .col-12 p {
	color: var(--dark-blue);
}

.checkbox-tools:checked+label, .checkbox-tools:not(:checked)+label {
	position: relative;
	display: inline-block;
	padding: 20px;
	width: 110px;
	font-size: 14px;
	line-height: 20px;
	letter-spacing: 1px;
	margin: 0 auto;
	margin-left: 5px;
	margin-right: 5px;
	margin-bottom: 10px;
	text-align: center;
	border-radius: 30px;
	overflow: hidden;
	cursor: pointer;
	text-transform: uppercase;
	color: var(--white);
	-webkit-transition: all 300ms linear;
	transition: all 300ms linear;
}

.checkbox-tools:not(:checked)+label {
	background-color: var(--dark-light);
	box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.1);
}

.checkbox-tools:checked+label {
	background-color: transparent;
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.checkbox-tools:not(:checked)+label:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.checkbox-tools:checked+label::before, .checkbox-tools:not(:checked)+label::before
	{
	position: absolute;
	content: '';
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	border-radius: 30px;
/* 	background-image: linear-gradient(298deg, rgba(76, 175, 80, 1), */
/* 		rgba(76, 175, 80, 0.5)); */
	background-image: linear-gradient(-45deg, rgba(218, 44, 77, 1),
		rgba(248, 171, 55, 0.5));
	z-index: -1;
}

.checkbox-tools:checked+label .uil, .checkbox-tools:not(:checked)+label .uil
	{
	font-size: 24px;
	line-height: 24px;
	display: block;
	padding-bottom: 10px;
}

.checkbox:checked ~ .section .container .row .col-12 .checkbox-tools:not(:checked)+label
	{
	background-color: var(--light);
	color: var(--dark-blue);
	box-shadow: 0 1x 4px 0 rgba(0, 0, 0, 0.05);
}

.checkbox-budget:checked+label, .checkbox-budget:not(:checked)+label {
	position: relative;
	display: inline-block;
	padding: 0;
	padding-top: 20px;
	padding-bottom: 20px;
	width: 260px;
	font-size: 52px;
	line-height: 52px;
	font-weight: 700;
	letter-spacing: 1px;
	margin: 0 auto;
	margin-left: 5px;
	margin-right: 5px;
	margin-bottom: 10px;
	text-align: center;
	border-radius: 30px;
	overflow: hidden;
	cursor: pointer;
	text-transform: uppercase;
	-webkit-transition: all 300ms linear;
	transition: all 300ms linear;
	-webkit-text-stroke: 1px var(--white);
	text-stroke: 1px var(--white);
	-webkit-text-fill-color: transparent;
	text-fill-color: transparent;
	color: transparent;
}

.checkbox-budget:not(:checked)+label {
	background-color: var(--dark-light);
	box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.1);
}

.checkbox-budget:checked+label {
	background-color: transparent;
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.checkbox-budget:not(:checked)+label:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.checkbox-budget:checked+label::before, .checkbox-budget:not(:checked)+label::before
	{
	position: absolute;
	content: '';
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	border-radius: 4px;
	background-image: linear-gradient(138deg, var(--red), var(--yellow));
	z-index: -1;
}

.checkbox-budget:checked+label span, .checkbox-budget:not(:checked)+label span
	{
	position: relative;
	display: block;
}

.checkbox-budget:checked+label span::before, .checkbox-budget:not(:checked)+label span::before
	{
	position: absolute;
	content: attr(data-hover);
	top: 0;
	left: 0;
	width: 100%;
	overflow: hidden;
	-webkit-text-stroke: transparent;
	text-stroke: transparent;
	-webkit-text-fill-color: var(--white);
	text-fill-color: var(--white);
	color: var(--white);
	-webkit-transition: max-height 0.3s;
	-moz-transition: max-height 0.3s;
	transition: max-height 0.3s;
}

.checkbox-budget:not(:checked)+label span::before {
	max-height: 0;
}

.checkbox-budget:checked+label span::before {
	max-height: 100%;
}

.checkbox:checked ~ .section .container .row .col-xl-10 .checkbox-budget:not(:checked)+label
	{
	background-color: var(--light);
	-webkit-text-stroke: 1px var(--dark-blue);
	text-stroke: 1px var(--dark-blue);
	box-shadow: 0 1x 4px 0 rgba(0, 0, 0, 0.05);
}

.checkbox-booking:checked+label, .checkbox-booking:not(:checked)+label {
	position: relative;
	display: -webkit-inline-flex;
	display: -ms-inline-flexbox;
	display: inline-flex;
	-webkit-align-items: center;
	-moz-align-items: center;
	-ms-align-items: center;
	align-items: center;
	-webkit-justify-content: center;
	-moz-justify-content: center;
	-ms-justify-content: center;
	justify-content: center;
	-ms-flex-pack: center;
	text-align: center;
	padding: 0;
	padding: 6px 25px;
	font-size: 14px;
	line-height: 30px;
	letter-spacing: 1px;
	margin: 0 auto;
	margin-left: 6px;
	margin-right: 6px;
	margin-bottom: 16px;
	text-align: center;
	border-radius: 4px;
	cursor: pointer;
	color: var(--white);
	text-transform: uppercase;
	background-color: var(--dark-light);
	-webkit-transition: all 300ms linear;
	transition: all 300ms linear;
}

.checkbox-booking:not(:checked)+label::before {
	box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.1);
}

.checkbox-booking:checked+label::before {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.checkbox-booking:not(:checked)+label:hover::before {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.checkbox-booking:checked+label::before, .checkbox-booking:not(:checked)+label::before
	{
	position: absolute;
	content: '';
	top: -2px;
	left: -2px;
	width: calc(100% + 4px);
	height: calc(100% + 4px);
	border-radius: 4px;
	z-index: -2;
	background-image: linear-gradient(138deg, var(--red), var(--yellow));
	-webkit-transition: all 300ms linear;
	transition: all 300ms linear;
}

.checkbox-booking:not(:checked)+label::before {
	top: -1px;
	left: -1px;
	width: calc(100% + 2px);
	height: calc(100% + 2px);
}

.checkbox-booking:checked+label::after, .checkbox-booking:not(:checked)+label::after
	{
	position: absolute;
	content: '';
	top: -2px;
	left: -2px;
	width: calc(100% + 4px);
	height: calc(100% + 4px);
	border-radius: 4px;
	z-index: -2;
	background-color: var(--dark-light);
	-webkit-transition: all 300ms linear;
	transition: all 300ms linear;
}

.checkbox-booking:checked+label::after {
	opacity: 0;
}

.checkbox-booking:checked+label .uil, .checkbox-booking:not(:checked)+label .uil
	{
	font-size: 20px;
}

.checkbox-booking:checked+label .text, .checkbox-booking:not(:checked)+label .text
	{
	position: relative;
	display: inline-block;
	-webkit-transition: opacity 300ms linear;
	transition: opacity 300ms linear;
}

.checkbox-booking:checked+label .text {
	opacity: 0.6;
}

.checkbox-booking:checked+label .text::after, .checkbox-booking:not(:checked)+label .text::after
	{
	position: absolute;
	content: '';
	width: 0;
	left: 0;
	top: 50%;
	margin-top: -1px;
	height: 2px;
	background-image: linear-gradient(138deg, var(--red), var(--yellow));
	z-index: 1;
	-webkit-transition: all 300ms linear;
	transition: all 300ms linear;
}

.checkbox-booking:not(:checked)+label .text::after {
	width: 0;
}

.checkbox-booking:checked+label .text::after {
	width: 100%;
}

.checkbox:checked ~ .section .container .row .col-12 .checkbox-booking:not(:checked)+label,
	.checkbox:checked ~ .section .container .row .col-12 .checkbox-booking:checked+label
	{
	background-color: var(--light);
	color: var(--dark-blue);
}

.checkbox:checked ~ .section .container .row .col-12 .checkbox-booking:checked+label::after,
	.checkbox:checked ~ .section .container .row .col-12 .checkbox-booking:not(:checked)+label::after
	{
	background-color: var(--light);
}

.inputField {
	border: 0;
	background: transparent;
	border-bottom: 1px solid black;
	
}

.twintable {
	table-layout: fixed;
	width: 100%;
} 
.twintable td{
table-layout:fixed;
    width:100%;
}

#reportwiseBtn{
	display:block;
	clear:both;
}

/* dropdown style*/
	
	
.dropbtn {
  background: #3a518d;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  outline: none;
	-webkit-appearance: unset !important;
	/* 	display: block; */
	display: inline-block;
	margin-bottom: 31px;
	font-family: sans-serif;
	width: auto;
	height: auto;
/* 	background-image: linear-gradient(298deg, rgba(76, 175, 80, 1), */
/* 		rgba(76, 175, 80, 0.6)); */
		background-image: linear-gradient(-45deg, rgba(218, 44, 77, 1),
		rgba(248, 171, 55, 0.5));
	color: #fff;
	padding: 16px 17px;
	font-size: 15px;
	align-content: center;
	border: none;
	-webkit-border-radius: 10px;
	cursor: pointer;
	-webkit-box-shadow: 0px 1px 15px 0px rgba(73, 102, 177, 0.7);
}

.dropup {
  position: relative;
  display: inline-block;
}

.dropup-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  bottom: 50px;
  z-index: 1;
}

.dropup-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropup-content a:hover {background-color: #ccc}

.dropup:hover .dropup-content {
  display: block;
}

.dropup:hover .dropbtn {
  background-color: #2980B9;
}
</style>
<style>

.ui-dialog{
z-index:3;
background-color: rgba(76, 175, 80, 1);
/* 	background: linear-gradient(-45deg, rgba(76, 175, 80, 1), */
/* 		rgba(76, 175, 80, 0.75)); */
		background: linear-gradient(-45deg, rgba(218, 44, 77, 1),
		rgba(248, 171, 55, 0.5));
	box-shadow: 12px 12px 16px 0 rgba(73, 102, 177, 0.25), -8px -8px 12px 0
		rgba(62, 182, 230, 0.3);
	border-radius: 50px;
	width: 300px !important;
	height: 200px !important;
	
}
#dateForm {background: rgba(255, 255, 255, 0.85);
	border-radius: 0.5em;
	box-shadow: 0 0 1em 0 rgba(51, 51, 51, 0.25);
	width: 260px !important;
	height: 100px !important;
	}
.ui-button{
	margin-left: 42%;
	background-color: var(--light);
	color: var(--dark-blue);
	box-shadow: 0 1x 4px 0 rgba(0, 0, 0, 0.05);
	position: absolute;
	content: '';
	top: 0;
	left: 0;
	
	border-radius: 30px;
/* 	background-image: linear-gradient(298deg, rgba(76, 175, 80, 0.2), */
/* 		rgba(76, 175, 80, 0.2)); */

		
}
.ui-dialog-titlebar{
padding-bottom: 10%;}
#dateRange{
text-align: -webkit-center !important;
}
</style>
<%@ page import="purejavacomm.CommPortIdentifier"%>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/sockjs-client/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/stomp.min.js"></script>
<script src="/webjars/jquery-ui/jquery-ui.min.js"></script>
</head>
<script>
$('#save').submit(function() {
	  return false;
	});
	$('#save').on('keyup keypress', function(e) {
	  var keyCode = e.keyCode || e.which;
	  if (keyCode === 13) { 
	    e.preventDefault();
	    return false;
	  }
	});
	var stompClient = null;

	function setConnected(connected) {
		$("#connect").prop("disabled", connected);
		$("#disconnect").prop("disabled", !connected);
		if (connected) {
			$("#conversation").show();
		} else {
			$("#conversation").hide();
		}
		$("#greetings").html("");
	}

	function connect() {
		var socket = new SockJS('/gs-guide-websocket');
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function() {
			setConnected(true);
			console.log('Connected:');
			stompClient.subscribe('/topic/greetings', function(greeting) {
				console.log('Connected: inside'+greeting);
				showWeight(greeting.body);
			});
		});
	}

	function sendName() {
		stompClient.send("/app/hello", {}, JSON.stringify({
			'name' : $("#Id").val()
		}));
	}

	function showWeight(message) {
		var i = message.split(",");
		if(i[0]=="w0" && i[2]=="w1"){
			$(".weightbox").text(i[1]);	
			$(".weightbox1").text(i[3]);
		}
		if(i[0]=="w0"){
			$(".weightbox").text(i[1]);		
		}
		if(i[0]=="w1"){
			$(".weightbox1").text(i[1]);		
		}
		if(i[4]=="r0"){
			$("#range").text(i[5]);
		}
	}

	$(function() {
		connect();
	});
	function validateForm() {
		  var x = document.forms["wb1form"]["vnum"].value;
		  if (x == "") {
		    alert("Please enter vehicle Number");
		    return false;
		  }
		}
</script>
<script>

							function printWeighSlip() {
								var ticketNo = prompt("Please type Ticket number");
								if (ticketNo != null) {
									window.open("http://localhost:8081/weighBridgeSlip/"+ticketNo,"_blank");
								}
							}
							function getTicketNoForSecond() {
								var ticketNo = prompt("Please type Ticket number");
								if (ticketNo != null) {
									//window.open("http://localhost:8081/second/"+ticketNo,"_self");
									$.ajax({
										type : "GET",
										contentType : "application/json",
										url : "second/"+ticketNo,
										dataType : 'json',				
										success : function(data) {
											$("#Id").val(data.headers.id);
											$("#vnum").val(data.headers.vnum);
											$("#ttype").val(data.headers.ttype);
											$("#pname").val(data.headers.pname);
											$("#addr").val(data.headers.addr);
											$("#city").val(data.headers.city);
											$("#mno").val(data.headers.mno);
											$("#mat").val(data.headers.mat);
											$("#vtype").val(data.headers.vtype);
											$("#ispending").val(data.headers.ispending);
										}
									});
								}
							}
							
							function updateEmpty(){
								console.log("empty clicked");
								$("#tweight").val($(".weightbox")[0].innerText);
								$("#gweight").val("0");
								document.getElementById("vempty").value = "true";
							}
							function checkForSec(){
								if($("#ispending").val=="true"){
									$("#exitval").prop("checked", true);
								}
							}
							function updateLoaded(){
								console.log("loaded clicked");
								$("#gweight").val($(".weightbox")[0].innerText);
								$("#tweight").val("0");
								document.getElementById("vempty").value = "false";
							}
							function updatePweight(){
								var pweightpq = parseFloat($("#pweightpq").val());
								var weight = 0;
								var gweight = parseFloat($("#gweight").val());
								var tweight = parseFloat($("#tweight").val());
								if(gweight>tweight){
									weight=gweight;
								}else{
									weight=tweight;
								}
								$("#pweight").val((pweightpq/100)*weight);
							}
							function update(status) {
								if (status == "entry") {
									document.getElementById("pending").value = "true";
								}
								if (status == "exit") {
									document.getElementById("pending").value = "false";
								}
							}
							function updateNweight(){
								var gweight = parseFloat($("#gweight").val());
								var tweight = parseFloat($("#tweight").val());
								var pweight = parseFloat($("#pweight").val());
								var lweight = parseFloat($("#lweight").val());
								
								$("#nweight").val(gweight+tweight-pweight-lweight);
							}
						</script>
<body>
	<table>

		<tr>
			<td class="split left">
				<div class="centered table" style="top: 46%;">

					<form name="wb1form" id="save" action="save" method="post" onsubmit="return validateForm()">
						<table class="twintable">
						
							<tr>
								<td><div style="font-size: 25px; font-weight: bold;">Weigh
										Bridge 1</div></td>
								<td><div class="weightbox">${weight}</div>
							</tr>
								<tr>
											<td><div class="col-12 pb-5">
													<input onclick="update('entry');" class="checkbox-tools"
														type="radio" name="entry_exit" id="entryval">
													<label class="for-checkbox-tools"
														style="width: 90px; height: 3px; padding-left: 20px; margin-left: 5px;padding-bottom: 31px;"
														for="entryval">FIRST</label> <input  
														onclick="update('exit');getTicketNoForSecond();" onload="checkForSec();" class="checkbox-tools"
														type="radio" name="entry_exit" id="exitval"> 
														<label
														class="for-checkbox-tools"
														style="width: 90px; height: 3px; padding-left: 20px; margin-left: 5px;padding-bottom: 31px;"
														for="exitval">SECOND</label>
												</div></td>
												<td><div class="col-12 pb-5">
													<input class="checkbox-tools" type="radio" name="tools" id="empty">
													<label onclick="updateEmpty();" onload="updateEmpty()"  style="width: 90px; height: 3px; padding-left: 20px;padding-bottom: 31px; margin-left: 5px;"
														class="for-checkbox-tools" for="empty">EMPTY</label> 
													<input class="checkbox-tools" type="radio" name="tools" id="loaded"> 
													<label onclick="updateLoaded();" style="width: 90px; height: 3px; padding-left: 20px; margin-left: 5px;padding-bottom: 31px;" class="for-checkbox-tools"
														for="loaded">LOADED</label>
												</div></td>
										</tr>
										
							<tr>
							
								<td><table>
										<tr>
											<td><label for="Id">Id:</label></td>
											<td><input type="text" id="Id" name="Id" class="inputField" value= ${lastId} readonly><br></td>
										</tr>
										<tr>
											<td><label for="vnum">Vehicle Number:</label></td>
											<td><input type="text" id="vnum" name="vnum"
												class="inputField" value=${vnum}><br></td>
										</tr>
										<tr>
											<td><label for="ttype">Ticket Type:</label></td>
											<td><input type="text" id="ttype" name="ttype"
												value="CASH" class="inputField" value=${ttype}><br></td>
										</tr>
										
										<tr>
											<td><label for="gweight">Gross Weight :</label></td>
											<td><input type="text" id="gweight" name="gweight"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="tweight">Tare Weight :</label></td>
											<td><input type="text" id="tweight" name="tweight"
												class="inputField" ><br></td>
										</tr>
										<tr>
											<td><label for="pweightpq">Packing Weight per
													Qtl:</label></td>
											<td><input type="text" id="pweightpq" name="pweightpq"
												class="inputField" onchange="updatePweight();"><br></td>
										</tr>
										<tr>
											<td><label for="pweight">Packing Weight:</label></td>
											<td><input type="text" id="pweight" name="pweight"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="lweight">Less Weight :</label></td>
											<td><input type="text" id="lweight" name="lweight"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="nweight">Net Weight :</label></td>
											<td><input type="text" id="nweight" name="nweight"
												class="inputField" readonly><br></td>
										</tr>
									</table></td>
								<td><table>

										<tr>
											<td><label for="pname">Party Name :</label></td>
											<td><input type="text" id="pname" name="pname"
												class="inputField" value=${pname}><br></td>
										</tr>
										<tr>
											<td><label for="addr">Address :</label></td>
											<td><input type="text" id="addr" name="addr"
												class="inputField" value=${addr}><br></td>
										</tr>
										<tr>
											<td><label for="city">City :</label></td>
											<td><input type="text" id="city" name="city"
												value="NAGPUR" class="inputField" value=${city}><br></td>
										</tr>
										<tr>
											<td><label for="mno">Mobile No :</label></td>
											<td><input type="text" id="mno" name="mno"
												class="inputField" value=${mno}><br></td>
										</tr>
										<tr>
											<td><label for="mat">Item :</label></td>
											<td><input type="text" id="mat" name="mat" value="KAPAS"
												class="inputField" value=${mat}><br></td>
										</tr>
										<tr>
											<td><label for="vtype">Vehicle Type :</label></td>
											<td><input type="text" id="vtype" name="vtype"
												class="inputField" value=${vtype}><br></td>
										</tr>
										<tr>
											<td><label for="chgs">Charges :</label></td>
											<td><input type="text" id="chgs" name="chgs" value="100"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="ulb">Un/Loaded By:</label></td>
											<td><input type="text" id="ulb" name="ulb" value="SELF"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="ulbchgs">Un/Load Charges :</label></td>
											<td><input type="text" id="ulbchgs" name="ulbchgs"
												value="200" class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="qty">Quantity :</label></td>
											<td><input type="text" id="qty" name="qty"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="rate">Item Rate :</label></td>
											<td><input type="text" id="rate" name="rate"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="amt">Amount :</label></td>
											<td><input type="text" id="amt" name="amt"
												class="inputField"><br></td>
										</tr>

									</table></td>
							</tr>
							<tr>
											<td><input type="text" id="pending" name="pending"
												style="display: none">
											</td>
										</tr>
										<tr>
											<td><input type="text" id="vempty" name="vempty"
												style="display: none">
											</td>
										</tr>
										<tr>
											<td><input type="text" id="ispending" name="ispending" style="display: none" value=${ispending}>
											</td>
										</tr>
										<tr>
											<td><input type="text" id="range" name="range" style="display: none">
											</td>
										</tr>
						</table>
						<input type="hidden" name="weighBridge1" value="weighBridge1" />
						<button class="reportBtn">Save</button>
						<button class="reportBtn" onclick="printWeighSlip()">Print</button>
						<input style="display:none" type="submit" value="Submit">
						

					</form>
				</div>
			</td>
			<td class="split right" style="display: block;">
				<div class="centered table" style="top: 46%;">

					<form id="save1" action="save" method="post">
						<table class="twintable">
						
							<tr>
								<td><div style="font-size: 25px; font-weight: bold;">Weigh
										Bridge 2</div></td>
								<td><div class="weightbox1">${weight}</div>
							</tr>
							<tr>
											<td><div class="col-12 pb-5">
													<input onclick="update1('entry');" class="checkbox-tools"
														type="radio" name="entry_exit1" id="entryval1">
													<label class="for-checkbox-tools"
														style="width: 90px; height: 3px; padding-left: 20px; margin-left: 5px;padding-bottom: 31px;"
														for="entryval1">FIRST</label> <input
														onclick="update1('exit');" class="checkbox-tools"
														type="radio" name="entry_exit1" id="exitval1"> 
														<label
														class="for-checkbox-tools"
														style="width: 90px; height: 3px; padding-left: 20px; margin-left: 5px;padding-bottom: 31px;"
														for="exitval1">SECOND</label>
												</div></td>
												<td><div class="col-12 pb-5">
													<input class="checkbox-tools" type="radio" name="tools1" id="empty1">
													<label onclick="updateEmpty1();" onload="updateEmpty1()"  style="width: 90px; height: 3px; padding-left: 20px;padding-bottom: 31px; margin-left: 5px;"
														class="for-checkbox-tools" for="empty1">EMPTY</label> 
													<input class="checkbox-tools" type="radio" name="tools1" id="loaded1"> 
													<label onclick="updateLoaded1();" style="width: 90px; height: 3px; padding-left: 20px; margin-left: 5px;padding-bottom: 31px;" class="for-checkbox-tools"
														for="loaded1">LOADED</label>
												</div></td>
										</tr>
										<tr>
											<td><input type="text" id="entry1" name="entry1"
												style="display: none"></td>
										</tr>
										<tr>
											<td><input type="text" id="exit1" name="exit1"
												style="display: none"></td>
										</tr>
							<tr>
							
								<td><table>
								
										
								
										
										<tr>
											<td><label for="Id1">Id:</label></td>
											<td><input type="text" id="Id1" name="Id" class="inputField" value= ${lastId} readonly> <br></td>
										</tr>
										<tr>
											<td><label for="vnum">Vehicle Number:</label></td>
											<td><input type="text" id="vnum" name="vnum"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="ttype">Ticket Type:</label></td>
											<td><input type="text" id="ttype" name="ttype"
												value="CASH" class="inputField"><br></td>
										</tr>
										
										<tr>
											<td><label for="gweight">Gross Weight :</label></td>
											<td><input type="text" id="gweight" name="gweight"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="tweight">Tare Weight :</label></td>
											<td><input type="text" id="tweight" name="tweight"
												class="inputField" ><br></td>
										</tr>
										<tr>
											<td><label for="pweightpq">Packing Weight per
													Qtl:</label></td>
											<td><input type="text" id="pweightpq" name="pweightpq"
												class="inputField" onchange="updatePweight();"><br></td>
										</tr>
										<tr>
											<td><label for="pweight">Packing Weight :</label></td>
											<td><input type="text" id="pweight" name="pweight"
												class="inputField" ><br></td>
										</tr>
										<tr>
											<td><label for="lweight">Less Weight :</label></td>
											<td><input type="text" id="lweight" name="lweight"
												class="inputField" ><br></td>
										</tr>
										<tr>
											<td><label for="nweight">Net Weight :</label></td>
											<td><input type="text" id="nweight" name="nweight"
												class="inputField" readonly><br></td>
										</tr>
									</table></td>
								<td><table>

										<tr>
											<td><label for="pname">Party Name :</label></td>
											<td><input type="text" id="pname" name="pname"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="addr">Address :</label></td>
											<td><input type="text" id="addr" name="addr"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="city">City :</label></td>
											<td><input type="text" id="city" name="city"
												value="NAGPUR" class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="mno">Mobile No :</label></td>
											<td><input type="text" id="mno" name="mno"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="mat">Item :</label></td>
											<td><input type="text" id="mat" name="mat" value="KAPAS"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="vtype">Vehicle Type :</label></td>
											<td><input type="text" id="vtype" name="vtype"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="chgs">Charges :</label></td>
											<td><input type="text" id="chgs" name="chgs" value="100"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="ulb">Un/Loaded By:</label></td>
											<td><input type="text" id="ulb" name="ulb" value="SELF"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="ulbchgs">Un/Load Charges :</label></td>
											<td><input type="text" id="ulbchgs" name="ulbchgs"
												value="200" class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="qty">Quantity :</label></td>
											<td><input type="text" id="qty" name="qty"
												class="inputField" readonly><br></td>
										</tr>
										<tr>
											<td><label for="rate">Item Rate :</label></td>
											<td><input type="text" id="rate" name="rate"
												class="inputField"><br></td>
										</tr>
										<tr>
											<td><label for="amt">Amount :</label></td>
											<td><input type="text" id="amt" name="amt"
												class="inputField"><br></td>
										</tr>

									</table></td>
							</tr>
						</table>
						<button class="reportBtn">Save</button>
						<button class="reportBtn" onclick="myFunction()">Print</button>
<!-- 						<input style="display:none" type="submit" value="Submit"> -->
						<script>
			
							function updateEmpty1(){
								$("#tweight").val($(".weightbox")[0].innerText);
								$("#gweight").val("0");
							}
							function updateLoaded1(){
								$("#gweight").val($(".weightbox")[0].innerText);
								$("#tweight").val("0");
							}
							function updatePweight(){
								var pweightpq = parseFloat($("#pweightpq").val());
								var weight = 0;
								var gweight = parseFloat($("#gweight").val());
								var tweight = parseFloat($("#tweight").val());
								if(gweight>tweight){
									weight=gweight;
								}else{
									weight=tweight;
								}
								$("#pweight").val((pweightpq/100)*weight);
							}
							function update(status) {
								if (status == "entry") {
									document.getElementById("pending").value = "true";
								}
								if (status == "exit") {
									document.getElementById("pending").value = "false";
								}
							}
							function updateNweight(){
								var gweight = parseFloat($("#gweight").val());
								var tweight = parseFloat($("#tweight").val());
								var pweight = parseFloat($("#pweight").val());
								var lweight = parseFloat($("#lweight").val());
								
								$("#nweight").val(gweight+tweight-pweight-lweight);
							}
							function disableNetWeight() {
									$("#nweight").prop("disabled",true);
									updateNweight();
								}
						</script>

					</form>
				</div>
			</td>
		</tr>

	</table>
	
	<div class="dropup" style="position:absolute; bottom: inherit;z-index:2;top:90%;transition-duration: 2s;">
  <button class="dropbtn">Generate Report</button>
  <div class="dropup-content">
  <a id="selectDate" onclick="dateRange();">Date wise Report</a>
  <a id="selectCashCredit" onclick="cashCredit();">Cash - Credit</a>
  <a id="selectItem" onclick="item();">Item wise Report</a>
  <a id="selectPending" onclick="pending();">Pending vehicles for Weighment</a>
  <a id="selectLoading" onclick="loading();">Loading Report</a>
  <a id="selectParty" onclick="party();">Party wise Report</a>
  <a id="selectVehicle" onclick="vehicle();">Vehicle type wise Report</a>
  </div>
</div>
	<div id="dateRange" style="z-index:9;text-align: center;">
		<form id="dateForm" action="dateWiseReport" target="_blank">
		<br>
			<label for="startDate">Start Date</label> <input type="date"
				id="startDate" name="startDate" class="inputField"><br>
				<br>
			<label for="endDate">End Date</label> <input type="date"
				id="endDate" name="endDate" class="inputField"><br>
				<br><br>
			<input type="submit" value="Submit">
		</form>
	</div>
	<script type="text/javascript">
    dateDialog = $( "#dateRange" ).dialog({
        autoOpen: false,
        height: 300,
        width: 350,
        modal: true
      });
    
    function dateRange() {
    	dateDialog.dialog( "open" );
      }
    </script>
    
    	<div id="cashcredit" style="z-index:9;text-align: center;">
		<form id="cashcreditForm" action="cashcreditWiseReport"
			target="_blank">
			<br>
			<label for="startDate">Start Date</label> <input type="date"
				id="startDate" name="startDate" class="inputField"><br>
				<br>
			<label for="endDate">End Date</label> <input type="date"
				id="endDate" name="endDate" class="inputField"><br>
				<br><br>
			<label for="cashcreditdd">CASH/CREDIT</label> <select id="cashcreditdd" name="cashcreditdd">
				<option value="CASH">CASH</option>
				<option value="CREDIT">CREDIT</option>
			</select> <input type="submit">
		</form>
	</div>
		<script type="text/javascript">
		cashcreditDialog = $( "#cashcredit" ).dialog({
        autoOpen: false,
        height: 300,
        width: 350,
        modal: true
      });
    
    function cashCredit() {
    	cashcreditDialog.dialog( "open" );
      }
    </script>

    <div id="item" style="z-index:9;text-align: center;">
		<form id="itemForm" action="itemWiseReport"
			target="_blank">
			<br>
			<label for="startDate">Start Date</label> <input type="date"
				id="startDate" name="startDate" class="inputField"><br>
				<br>
			<label for="endDate">End Date</label> <input type="date"
				id="endDate" name="endDate" class="inputField"><br>
				<br><br>
			<label for="itemdd">ITEM</label> <select id="itemdd" name="itemdd">
				<option value="KAPAS">KAPAS</option>
			</select> <input type="submit">
		</form>
	</div>
		<script type="text/javascript">
		itemDialog = $( "#item" ).dialog({
        autoOpen: false,
        height: 300,
        width: 350,
        modal: true
      });
    
    function item() {
    	itemDialog.dialog( "open" );
      }
    </script>
    
      <div id="pendingDiv" style="z-index:9;text-align: center;">
		<form id="pendingForm" action="pendingReport"
			target="_blank">
			<br>
<!-- 			<label for="startDate">Start Date</label> <input type="date" -->
<!-- 				id="startDate" name="startDate" class="inputField"><br> -->
<!-- 				<br> -->
<!-- 			<label for="endDate">End Date</label> <input type="date" -->
<!-- 				id="endDate" name="endDate" class="inputField"><br> -->
<!-- 				<br><br> -->
<!-- 			<label for="pendingdd">ITEM</label> <select id="pendingdd" name="pendingdd"> -->
<!-- 				<option value=" a"> a</option> -->
<!-- 			</select>  -->
			<input type="submit">
		</form>
	</div>
		<script type="text/javascript">
		pendingDialog = $( "#pendingDiv" ).dialog({
        autoOpen: false,
        height: 300,
        width: 350,
        modal: true
      });
    
    function pending() {
    	pendingDialog.dialog( "open" );
      }
    </script>
    
    
        	<div id="loading" style="z-index:9;text-align: center;">
		<form id="loadingForm" action="loadingWiseReport"
			target="_blank"><br>
			<label for="startDate">Start Date</label> <input type="date"
				id="startDate" name="startDate" class="inputField"><br>
				<br>
			<label for="endDate">End Date</label> <input type="date"
				id="endDate" name="endDate" class="inputField"><br>
				<br><br>
			<label for="loadingdd">Loading</label> 
			<select id="loadingdd" name="loadingdd">
				<option value="SELF">SELF</option>
				<option value="OTHER">OTHER</option>
			</select> <input type="submit">
		</form>
	</div>
		<script type="text/javascript">
		loadingDialog = $( "#loading" ).dialog({
        autoOpen: false,
        height: 300,
        width: 350,
        modal: true
      });
    
    function loading() {
    	loadingDialog.dialog( "open" );
      }
    </script>
    
        	<div id="party" style="z-index:9;text-align: center;">
		<form id="partyForm" action="partyWiseReport"
			target="_blank"><br>
			<label for="startDate">Start Date</label> <input type="date"
				id="startDate" name="startDate" class="inputField"><br>
				<br>
			<label for="endDate">End Date</label> <input type="date"
				id="endDate" name="endDate" class="inputField"><br>
				<br><br>
			<label for="partydd">Party Name</label> 
			<select id="partydd" name="partydd">
			
			</select> <input type="submit">
		</form>
	</div>
	    <script>
			var init = "${partyNames}";
			var removebrackets1 = init.split("[");
			var removebrackets2 = removebrackets1[1].split("]");
			var pnames = removebrackets2[0].split(",");
			var placeHolder = "";
			for(var i = 0 ; i < pnames.length ; i++){
				placeHolder += "<option>" +pnames[i]+"</option>";
			}
			document.getElementById("partydd").innerHTML = placeHolder;
	</script>
		    <script>
			var init = "${vehicleTypes}";
			var removebrackets1 = init.split("[");
			var removebrackets2 = removebrackets1[1].split("]");
			var pnames = removebrackets2[0].split(",");
			var placeHolder = "";
			for(var i = 0 ; i < pnames.length ; i++){
				placeHolder += "<option>" +pnames[i]+"</option>";
			}
// 			document.getElementById("vtype").appendChild(placeHolder);
	</script>
		<script type="text/javascript">
		partyDialog = $( "#party" ).dialog({
        autoOpen: false,
        height: 300,
        width: 350,
        modal: true
      });
    
    function party() {
    	partyDialog.dialog( "open" );
      }
    </script>
    
        	<div id="vehicle" style="z-index:9;text-align: center;">
		<form id="vehicleForm" action="vehicleWiseReport"
			target="_blank"><br>
			<label for="startDate">Start Date</label> <input type="date"
				id="startDate" name="startDate" class="inputField"><br>
				<br>
			<label for="endDate">End Date</label> <input type="date"
				id="endDate" name="endDate" class="inputField"><br>
				<br><br>
			<label for="vehicledd">CASH/CREDIT</label> <select id="vehicledd" name="vehicledd">
				<option value="6wheel">6 Wheel</option>
				<option value="8wheel">8 Wheel</option>
			</select> <input type="submit">
		</form>
	</div>
		<script type="text/javascript">
		vehicleDialog = $( "#vehicle" ).dialog({
        autoOpen: false,
        height: 300,
        width: 350,
        modal: true
      });
    
    function vehicle() {
    	vehicleDialog.dialog( "open" );
      }
    </script>
</body>

</html>