<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   /* function f1(){
    var a = 1;
   
    return function f2(){ //클로저
    return a;
    }
    }

    var f = f1();
    var a = f(); // a가 참조되고 있어 죽지 못함...
    alert(a); // a = 1;
    a = null; // 이래야 f2->f1 쥬금
    */

   /* function f1(){
    a = 1;
    }
    function f2(){
    alert(a);
    }

    f1();
    f2(); */

   /* function f1(){
    var a = 1;
    }


    f1();
    alert(a); */

   /* var add = new Function("x,y", "return x+y;"); */
   /* var add = function(x, y){
    return x+y;
    }
    */

   /*  var add = function(){
    x = arguments[0];
    y = argumetns[1];
    } */

   /* var add = function(){
    var sum = 0;
    for(var i = 0; i<arguments.length; i++)
       sum += arguments[i]; 
    
    return sum;
    
   };
   
   console.log(add(3,8,10)); */

   /* var data = [2,4,5,7,8];
    var entity = {id:1, title:"Hello", writerId:"newlec"}; */

   /* for(var i = 0; i<data.length; i++)
    console.log(data[i]); */

   /* for(var i in data) //인덱스를 반환.
    console.log(data[i]);
    */
   /*  for(var k in entity) //인덱스를 반환.
    console.log(entity[k]); */

   /* var ob = {};
    ob.name = "test";
    ob.test = "2020494"

    alert(ob.test);
    */
   /* var json = [
    {id: "1", title:"tetet", "writer id": "newlec"},
    {id: "2", title:"good", "writer-id": "2222"}
    ];

    alert(json[1].title);
    alert(json[1]["writer-id"]);
    alert(json[0]["writer id"]);
    */

   /*  var x = 3;
    undefined
    var y = new Number(3);
    undefined
    alert(x===y);
    undefined
    alert(x==y);
    undefined
    alert(3+4.5); //7.5
    undefined
    alert(3+"4"); //34
    undefined
    alert(3.5-"2"); //1.5 빼기는 숫자로 바꿔줌
    undefined
    */

   /*  var data = eval("var x=3; x++;");
    alert(x);
   
    var data = eval("[2,4,6]");
    alert(data[2]);
    */
   /*  var data = JSON.parse("[2,4,6]");
    alert(data[1]);
   
    var data = eval('({id: "1", title:"tetet", "writer id": "newlec"})');
    alert(data.title); */
   /* var data =  JSON.parse('{"id": 1, "title":"tetet", "writer id": "newlec"}');
    alert(typeof data.title);
    alert(typeof data.id); */
   /* json 객체 파싱할 때는 소괄호로 한 번 더 감싸주어야 함 */
    
    
     function calcApp(){
         var addBtn = document.getElementById("add-button");
         var x1 = document.getElementById("x");
         var y1 = document.getElementById("y");
         var result = document.getElementById("result");
         
         addBtn.onclick = printResult;
         
         function printResult(){

            var x;
            var y;
            
            x=(x1.value);
            y=parseInt(y1.value);
         
            result.value=x+y;
         }
         
      }
      
      window.onload = calcApp;
      
      
      //-----------------------------------------------------------------
      
window.onload = function(){
   
   var countLabel=document.getElementById("count-label");
   var countButton=document.getElementById("count-button");
   var timerId=null;
   
   var ex1 = document.getElementById("ex1");
   ex1.style.marginTop="0px";

   countButton.onclick= function(){
   
      if(timerId == null){
         timerId = setInterval(function(){
         var count = parseInt(countLabel.textContent);
         var marginTop = parseInt(ex1.style.marginTop);
         
         if(count<=0){
            clearInterval(timerId);
            timerId = null;
         }
         
         if(marginTop>=100){
            clearInterval(timerId);
            timerId = null;
         }
      
         //countLabel.textContent= count-1;
         ex1.style.marginTop = (marginTop + 1) + "px";
            
         }, 30);
         
      }
   }
};
/*  */   
<!--  open a window 예제 -->
   
window.onload = function(){
   var openButton=document.getElementById("open-button");
   var movButton=document.getElementById("mov-button");
   var transButton = document.getElementById('trans-button');
   var win = null;
   var iframe = window.frames[0];

   openButton.onclick= function(){
      if(win==null)
         win=open("notice.html","_blank","width=500px height=300px");
   };
   movButton.onclick= function(){
     if(win!=null)
         win.moveBy(-10,0);
   };   
   transButton.onclick = function() {
      //iframe.location.href="http://www.daum.net";
      iframe.document.write("http://www.daum.net");
   };
};
 
   
/*    window.onload = function(){
     var navButton = document.getElementById("nav-button");
     var win = window.frames[0];
     
     navButton.onclick = function(){
        win.location.href = "http://www.newlecture.com";
     }; 
};*/


window.addEventListener("load", function() {
   var chButton = document.getElementById("ch-button");
   var p = document.getElementById("p");
   
   chButton.onclick = function() {
      /* //p.style.background = "blue";
      p.firstElementChild.style.border = "1px solid blue";
      //alert(p.firstChild.innerHTML);
      p.parentNode.firstElementChild.style.background = "yellow"; */
      
      for(var node = p.firstChild; node!=null; node = node.nextSibling)
         alert(node.nodeType); // 3 1 3
   };
});

//--Selector API 예제 --
window.addEventListener("load", function() {
   var chButton = document.querySelector("#ch-button1");
   //var p = document.querySelector("#module1 > div:first-child + div > div");
   /* var divs = document.querySelectorAll("#module1 > div");
   var p = divs[1].querySelector("div"); */
   var div = document.querySelector("#module1 > div:first-child"); /* div 첫번째가 나옴 */
   //var p = div.nextElementSibling.querySelector("div");
   var p = div.nextElementSibling.firstElementChild;
   chButton.onclick = function() {
      /* //p.style.background = "blue";
      p.firstElementChild.style.border = "1px solid blue";
      //alert(p.firstChild.innerHTML);
      p.parentNode.firstElementChild.style.background = "yellow"; */
      p.style.background = "blue";
      /* for(var node = p.firstChild; node!=null; node = node.nextSibling)
         alert(node.nodeType); // 3 1 3 */
   };
});

//--속성변경예제 --
window.addEventListener("load", function() {
   var chImgButton = document.querySelector("#ch-img-button");
   var container = document.querySelector("#img-container");   
   var img = container.querySelector("img");
   var imgSrc = document.querySelector("#img-src");

   chImgButton.onclick = function() {
      img.src=imgSrc.value;
   };
});
//--자식노드변경예제 -->
window.addEventListener("load", function() {
   var chNodeButton = document.querySelector("#ch-node-button");
   var container = document.querySelector("#ch-node-container");   
   chNodeButton.onclick = function() {
      //container.textContent = "<h1>testtestset</h1>"
      container.innerHTML = "<h1>testtestset</h1>"
   };
});


//--텍스트 노드 추가 예제 -->
window.addEventListener("load", function() {
   var addTextNodeButton = document.querySelector("#add-text-node-button");
   var addImgNodeButton = document.querySelector("#add-img-node-button");
   var removeNodeButton = document.querySelector("#remove-node-button");
   var container = document.querySelector("#node-container");   
   
   var remove = function(e){
      //container.removeChild(e.target);
      container.removeChild(this);
   }
   var idx = 0;
   addTextNodeButton.onclick = function() {
      //1.TextNode 생성
      var span = document.createElement('span');
      var txt = document.createTextNode('안녕하세여'+ idx++);
      //2. container(부모) 얻기
      //3. 부모에 자식을 추가
      span.appendChild(txt);
      container.appendChild(span);
      
      span.onclick = remove;
      
   };
   addImgNodeButton.onclick = function() {
      /* //How to 1(성능에 좋음)
      //1 Element 생성
      var img = document.createElement('img');
      img.src="http://t1.daumcdn.net/thumb/R1024x0/?fname=http://cfile25.uf.tistory.com/image/2239B038579139CF067E3D";
      //2. container(부모) 얻기
      //3. 부모에 자식을 추가
      container.appendChild(img);
      img.onclick = remove;
      
      */
      //How to 2 (성능에 좋지 않지만 편리함.-> 한두개 넣는 상황의 성능에 영향을 주지 않을 거라면 이를 사용)
      container.innerHTML += '<img onClick="remove()" src="http://t1.daumcdn.net/thumb/R1024x0/?fname=http://cfile1.uf.tistory.com/image/2134514F579B4C7D165741" />';
      
      
   };
   removeNodeButton.onclick = function() {
      // 1. 내정된 노드를 지우기
      if(container.hasChildNodes()){
         container.removeChild(container.lastChild);
      }
      // 2. 선택된 노드를 지우기
      
   };
});
//!--노드 바꾸기 예제 -->
window.addEventListener("load", function() {
   var swapNodeButton = document.querySelector("#swap-node-button");
   var container = document.querySelector("#swap-node-container");   
   
   swapNodeButton.onclick = function() {
      /* var nodes = container.getElementsByTagName("img");
      
      var node1 = nodes[0];
      var node2 = nodes[1];
      var node3 = nodes[2];
       */
      var node1 = container.firstElementChild;
      var node3 = container.lastElementChild;
      var oldNode = container.replaceChild(node1, node3);
      container.insertBefore(node3, container.firstElementChild);
      /* var oldNode = container.replaceChild(node2, node3);
      container.insertBefore(node3, container.firstElementChild); */

   };
});
//!--노드 바꾸기2 예제 -->
window.addEventListener("load", function() {
   var moveUpNodeButton = document.querySelector("#move-up-node-button");
   var container = document.querySelector("#move-up-node-container");
   var tbody = container.querySelector("tbody");
//   var td = tbody.querySelector("tr:first-child td:last-child");
   var td = tbody.firstElementChild.lastElementChild;
   var tr = null;
   /* var trs = container.querySelectorAll("tbody tr");
   
   for(var i in trs){
      trs[i].onclick = function(e){
         e.target.style.background = "pink";
         //this.style.background = "pink";
      };
   } */
   /* td.onclick = function(e) {
      //alert("td");
      console.log("td");
      e.target.style.background = "green";
   } */
   td.addEventListener("click", function(e) {
      //alert("td");
      //console.log("td");
      e.target.style.background = "green";
      //e.stopPropagation();
   });
   var checkedId = 0;
   
   tbody.addEventListener("click", function(e) {
      /* if(e.target.type=="radio"){
         var tr = e.target.parentNode.parentElement;
         tr.style.background = "pink";
         /* alert("라디오 버튼 클릭");
         checkedId = e.target.value;
      } */
       if(e.target.nodeName=="INPUT"){
          tr = e.target.parentNode.parentElement;
   /*        var tr = e.target.parentNode.parentElement;
          var bf = tr.previousElementSibling;
          var af = tr.nextElementSibling;
   
          var oldNode = tbody.replaceChild(tr, bf);
          tbody.insertBefore(bf, af); */
         /*  
          var tr1 = e.target.parentNode.parentElement;
          var tr2 = tr1.previousElementSibling;
         var oldNode = tbody.replaceChild(tr2, tr1);         
          tbody.insertBefore(tr1, tr2); */
          
      }
      //alert(checkedId);
      //alert("tbody");
      /* console.log("tbody");
      e.target.style.background = "pink"; */
      //e.target.parentNode.style.background = "pink";
      //e.currentTarget
   }, false);
   
   moveUpNodeButton.onclick = function() {
      if (tr == null)
         return;
      
      var bf = tr.previousElementSibling;
      var af = tr.nextElementSibling;
       // -> bf, af 예외처리.
      if(bf == null){
         tbody.appendChild(tr);
      } else if (af == null){
//          /* var oldNode = tbody.replaceChild(bf, tr);
//           tbody.insertBefore(tr, bf); */
         var oldNode = tbody.replaceChild(tr, bf);
          tbody.appendChild(bf);
      } else{
         var oldNode = tbody.replaceChild(tr, bf);
          tbody.insertBefore(bf, af);
      }
      
      
      /* var radioCheck = document.getElementsByName("id");
      for(var i in radioCheck){
         if(radioCheck[i].checked == true)
         {
            var node1 = radioCheck[i].parentNode.parentElement;
            if(i-1>=0){
               var node2 = radioCheck[i-1].parentNode.parentElement;
               var oldNode = tbody.replaceChild(node2, node1);
               tbody.insertBefore(node1, node2);
            }else {
               tbody.appendChild(node1);
            }
            break;
         }
      } */
         
   };
});

window.addEventListener("load", function() {
   //var titleText = document.querySelector('form > input[type="text"]');
   var titleText = document.querySelector('form > input[name]');
   var submitButton = document.querySelector('form > input[type="submit"]');
   var cancelButton = document.querySelector('form > a');
   
   submitButton.onclick = function(e){
      if(titleText.value == ""){
         alert("제목을 입력하세요.");
         e.preventDefault();
      }
   }
   cancelButton.onclick = function(e){
      if(titleText.value !=""){
         /* var cancel =confirm("작성중이던 입력을 취소하시겠습니까?");
         if(cancel == true)
            history.back(-1);
         else
            e.preventDefault();    */
         if(!confirm("작성중이던 입력을 취소하시겠습니까?"))
            e.preventDefault();
      }
   }
});
<!-- 노드복제 예제 -->
window.addEventListener("load", function() {
   //var titleText = document.querySelector('form > input[type="text"]');
   var cloneButton = document.querySelector('#ex-clone input[value="단순복제"]');
   var tbody = document.querySelector('#ex-clone tbody');
   
   cloneButton.onclick = function(e){
      var tr = tbody.querySelector("tr");
      var clone = tr.cloneNode(true);
      
      tbody.appendChild(clone);
      
   }
});

<!-- Template 태그를 이용한 노드복제 예제 -->
window.addEventListener("load", function() {
   //var titleText = document.querySelector('form > input[type="text"]');
   var cloneButton = document.querySelector('#ex2-clone input[value="단순복제"]');
   var tbody = document.querySelector('#ex2-clone tbody');
   var template = document.querySelector('#ex2-clone template');
   var ajaxButton = document.querySelector('#ex2-clone input[value="AJAX요청"]');
   var container = document.querySelector('#ex2-clone div:first-child');
   var data = [
      {id:"1", title:"test", writerId:"ttt"},
      {id:"2", title:"test222", writerId:"ttt"},
      {id:"3", title:"test333", writerId:"ttt"}
      ];
   
   
   
   ajaxButton.onclick = function(e) {
      /* 2. 비동기형으로 문서를 요청한 방식 */
      var xhr = new XMLHttpRequest(); // XML을 HTTP으로 요청을 보내고 응답을 받을 수 있는 도구
      /* xhr.onreadystatechange = function(e) {// 안쪽 e 우선시 됨
         if(xhr.readyState == 4)
            data = eval(xhr.responseText);//문자열로 온 것을 표현식으로 실행
      }; */
      xhr.onload = function() {
         //data = eval(xhr.responseText);
         data = JSON.parse(xhr.responseText);
         // 2. ajax icon 제거
         container.removeChild(ajaxButton.parentNode.lastElementChild);
//         ajaxButton.parentNode.removeChild(ajaxButton.parentNode.lastElementChild);
      };
      
      xhr.onerror = function() {
         alert("예기치 못한 오류가 발생하였습니다.");   
      };
      xhr.open("GET","../../customer/notice-ajax", true); // 데이터를 요청하기 위한 설정 // 세번째 파라메터 -> 비동기(true) or 동기(false) 설정
      xhr.send(); // 요청
      
      //1. ajax icon 추가
      var img = document.createElement('img');
      img.src = "../images/ajax-loader.gif";
      
      container.appendChild(img);
      //ajaxButton.parentNode.appendChild(img);
      
      
      /* 동기형으로 문서를 요청한 방식 */
      /* var xhr = new XMLHttpRequest(); // XML을 HTTP으로 요청을 보내고 응답을 받을 수 있는 도구
      xhr.open("GET","../../customer/notice-ajax", false); // 데이터를 요청하기 위한 설정
      xhr.send(); // 요청
      data = eval(xhr.responseText);//문자열로 온 것을 표현식으로 실행
      //data = xhr.responseText; undefine으로 도배됨 */
   }
   
   cloneButton.onclick = function(e){
      
      if('content' in template){
         //1.template의 content에 값을 설정하고 노드를 복제
         /* // template 의 content에 값을 설정
         var tds = template.content.querySelectorAll("td");
         //tes[0].appendChild(document.createTextNode("1"));
         tds[0].textContent  = "1";
         tds[1].textContent  = "test title";
         tds[2].textContent  = "newlec";
         
          */
          
          /*
          //값이 설정된 content를 복제
         var clone = document.importNode(template.content, true);
          
         //2. 복제를 한 후에 content를 설정하는 경우
         var tds = clone.querySelectorAll("td");
         tds[0].appendChild(document.createTextNode("1"));
         tds[1].textContent  = "test title";
         tds[2].textContent  = "newlec";
         
         // 복제된 tr을 노드 트리에 추가
         tbody.appendChild(clone);
          */
          
          
         /* for(var i in data){
            //값이 설정된 content를 복제
            var clone = document.importNode(template.content, true);
             
            //2. 복제를 한 후에 content를 설정하는 경우
            var tds = clone.querySelectorAll("td");
            tds[0].appendChild(document.createTextNode(data[i].id));
            tds[1].textContent  = data[i].title;
            tds[2].textContent  = data[i].writerId;
            
            // 복제된 tr을 노드 트리에 추가
            tbody.appendChild(clone);
         }
           */
         for(var i=0; i<data.length; i++){
            //값이 설정된 content를 복제
            var clone = document.importNode(template.content, true);
             
            //2. 복제를 한 후에 content를 설정하는 경우
            var tds = clone.querySelectorAll("td");
            tds[0].appendChild(document.createTextNode(data[i].id));
            tds[1].textContent  = data[i].title;
            tds[2].textContent  = data[i].writerId;
            
            // 복제된 tr을 노드 트리에 추가
            tbody.appendChild(clone);
         }
      } 
      
      /* 
      var obj = {kor:30, eng:40, math:50};
      
      obj.com = 60;
      
      if("com" in obj)
            laert(obj.kor + obj.com);
      */
   }
});
 // <!----------- Ajax로 파일 전송하기와 트리거---------------->
window.addEventListener("load", function() {
	 var fileInput = document.querySelector("#ex3-upload input");
	 var submitButton = document.querySelector("#ex3-upload span");
	 var progressBar= document.querySelector("#ex3-upload #progress-bar");
	 progressBar.style.width = "0px";
	 
	 var fileViewer = document.querySelector("#ex3-upload ul");
	 
	 //파일 목록 초기화
	 var xhr = new XMLHttpRequest();
	xhr.onload = function(e){
		 var files = JSON.parse(e.target.responseText);//["file1.txt","file2.txt"]
		 for(var i=0; i<files.length; i++){
			 var li = document.createElement("li");
			 li.textContent = files[i];
			 fileViewer.appendChild(li);
		 }
	 };
	 xhr.open("GET","../../file-list");//default값이 비동기
	 xhr.send();

	 
	 submitButton.onclick = function(e) {
		  var event = new MouseEvent("click",{
		  	  'view':window,
			  'bubbles':true,
			  'cancelable':true
			  });
		  	console.log("bf");
		 	fileInput.dispatchEvent(event);
		 	fileInput.onchange = function(){
		 		var file = fileInput.files[0];
		// 		alert(file.name);		//확장자를 알면 제어를 할수 있다.
			 	var formData = new FormData();
			 	formData.append("title","테스트");
			 	formData.append("file",file);
			 	
			 	var xhr = new XMLHttpRequest(); // XML을 HTTP으로 요청을 보내고 응답을 받을 수 있는 도구
			 
			 	xhr.upload.onprogress = function(e){
			 		var percentage = Math.round(e.loaded*100/e.total);
			 		progressBar.textContent = percentage+"%";
			 		//progressBar.style.background = "yellow";
			 		progressBar.style.width = percentage+"px";
			 		console.log(Math.round(e.loaded*100/e.total)+"%");
		         };
			      xhr.onerror = function(e) {
			         alert("예기치 못한 오류가 발생하였습니다.");   
			      };
			      xhr.open("POST","../../upload?${_csrf.parameterName}=${_csrf.token}", true); // 데이터를 요청하기 위한 설정 // 세번째 파라메터 -> 비동기(true) or 동기(false) 설정
			      xhr.send(formData); // 요청
		 	};
		 	console.log("af");
	   };
});

</script>
</head>
<body>
   <!-- Ajax로 파일 전송하기와 트리거 그리고 파일목록뷰어 -->
   <div id="ex3-upload">
   	<input type="file" style = "display:none"/>
   	<span style="border:1px solid #999; border-radius:5px; background: pink; padding:3px; cursor:pointer">파일선택</span>
   	<span id = "progress-bar" style ="background:yellow; display:inline-block;"></span>
   	<hr>
      <form action="../../upload?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
         <div>
            <input type="submit" value="전송" />
         </div>
         <div id="clone-container">
            <table border="1">
               <tbody>
                  <tr>
                     <td>제목</td>
                     <td><input type="text" name="title" /></td>
                  </tr>
                  <tr>
                     <td>파일</td>
                     <td><input type="file" name="file"/></td>
                  </tr>
               </tbody>
            </table>
         </div>
      </form>
      <div>
      	<ul>
      		<li></li>
      	</ul>
      </div>
   </div>
   <hr />
   <!-- Template 태그를 이용한 노드복제 예제 && Ajax 요청 예제-->
   <div id="ex2-clone">
      <div>
         <input type="button" value="단순복제" /> <input type="button"
            value="AJAX요청" />
      </div>
      <div id="clone-container">
         <table border="1">
            <thead>
               <tr>
                  <td></td>
                  <td>코드</td>
                  <td>제목</td>
               </tr>
            </thead>
            <tbody>
               <template>
               <tr>
                  <td></td>
                  <td></td>
                  <td></td>
               </tr>
               </template>
            </tbody>
         </table>


      </div>
   </div>
   <hr />
   <!-- 노드복제 예제 -->
   <div id="ex-clone">
      <div>
         <input type="button" value="단순복제" />
      </div>
      <div id="clone-container">
         <table border="1">
            <thead>
               <tr>
                  <td></td>
                  <td>코드</td>
                  <td>제목</td>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td><input type="radio" name="id" value="1" /></td>
                  <td>1</td>
                  <td>zzz</td>
               </tr>
            </tbody>
         </table>
      </div>
   </div>
   <hr />
   <!--기본 행위 막기 예제 -->
   <form>
      <input type="text" name="title" /><br /> <input type="submit"
         value="전송" /><br /> <a href="">취소</a>

   </form>

   <!--노드 바꾸기2 + 이벤트 심화 : 버블링과 캡처링 예제 -->
   <input id="move-up-node-button" type="button" value="위로 옮기기" />
   <div id="move-up-node-container">
      <table border="1">
         <thead>
            <tr>
               <td></td>
               <td>코드</td>
               <td>제목</td>
            </tr>
         </thead>
         <tbody>
            <tr>
               <td><input type="radio" name="id" value="1" /></td>
               <td>1</td>
               <td>zzz</td>
            </tr>
            <tr>
               <td><input type="radio" name="id" value="2" /></td>
               <td>2</td>
               <td>sdd</td>
            </tr>
            <tr>
               <td><input type="radio" name="id" value="3" /></td>
               <td>3</td>
               <td>zwerzz</td>
            </tr>
            <tr>
               <td><input type="radio" name="id" value="4" /></td>
               <td>4</td>
               <td>sdefd</td>
            </tr>
            <tr>
               <td><input type="radio" name="id" value="5" /></td>
               <td>5</td>
               <td>zaazz</td>
            </tr>
            <tr>
               <td><input type="radio" name="id" value="6" /></td>
               <td>6</td>
               <td>sdqwerd</td>
            </tr>
         </tbody>
      </table>

      <img src="../images/answeris.png" /><img src="../images/w3c.png" /><img
         src="../images/microsoft.png" />
   </div>
   <hr />
   <!--노드 바꾸기 예제 -->
   <input id="swap-node-button" type="button" value="노드 바꾸기" />
   <div id="swap-node-container">
      <img src="../images/answeris.png" /><img src="../images/w3c.png" /><img
         src="../images/microsoft.png" />
   </div>
   <hr />
   <!--텍스트 노드 추가 예제 -->
   <input id="add-text-node-button" type="button" value="텍스트노드 추가" />
   <input id="add-img-node-button" type="button" value="이미지노드 추가" />
   <input id="remove-node-button" type="button" value="노드 삭제" />
   <div id="node-container"></div>
   <hr />

   <!--자식노드변경예제 -->
   <input id="ch-node-button" type="button" value="자식노드 변경" />
   <div id="ch-node-container">hello</div>
   <hr />
   <!--속성변경예제 -->
   <input type="text" id="img-src" />
   <input id="ch-img-button" type="button" value="이미지 변경" />
   <div id="img-container">
      <img src="http://i.huffpost.com/gen/5524070/thumbs/o-THE-570.jpg?3" />
   </div>

   <!-- Selector API 예제 -->
   <input id="ch-button1" type="button" value="배경색 변경" />
   <div id="module1">
      <div>1</div>
      <div>
         <div>2</div>
      </div>
      <div>3</div>
   </div>
   <!-- 노드 순환 예제 -->
   <input id="ch-button" type="button" value="배경색 변경" />
   <div>
      <div>1</div>
      <div id="p">
         <div>2</div>
      </div>
      <div>3</div>
   </div>


   <hr />
   <div>
      <input id="nav-button" type="button" value="페이지 전환" />
      <iframe src="notice.html" style="width: 500px; height: 300px;"></iframe>
   </div>
   <hr />
   <!--  open a window 예제 -->
   <div>
      <input type="button" value="새창띄우기" id="open-button" /> <input
         type="button" value="왼쪽으로 이동" id="mov-button" /><input type="button"
         value="페이지 이동" id="trans-button" />
   </div>

   <hr />
   <p>
      남은시간 <span id="count-label">60</span>초 <input id="count-button"
         type="button" value="카운트 시작" />
   </p>
   <hr />


   <input type="text" id="x" placeholder="x값을 입력하세요" />
   <input type="text" id="y" placeholder="y값을 입력하세요" /> =
   <input type="button" value="더하기" id="add-button" />
   <input type="text" value="" id="result" />
</body>
</html>