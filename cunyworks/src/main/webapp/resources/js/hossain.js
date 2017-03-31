$(document).ready(function() {
	
		refresh();//initally loads
		
		
				function CourseBean(courseId,name,room,startDate,endDate,description,enrollmentCapacity) {
					this.courseId = courseId;

					this.name = name;
					this.room = room;
					//this.subject = subject;

					//this.scheduleTime = scheduleTime;
					this.startDate = startDate;
					this.endDate = endDate;
					//this.syllabus = syllabus;
					//this.created = created;
					//this.teacher = teacher;
					this.description = description;
					this.enrollmentCapacity = enrollmentCapacity;
				}

				
			var allCourses;
		$("#update").click(function() {

		
			$("#update").prop("disabled", true);
			var courseId = $("#courseId").val();
			
			var name = $("#course").val();
			var room = $("#room").val();
			
			//var subject= $("#subject").val();

			var startDate = $("#startDate").val();
			var endDate = $("#endDate").val();
			var description = $("#description").val();
			var enrollmentCapacity = $("#capacity").val();
			var courseBean = new CourseBean(courseId,name,room,startDate,endDate,description,enrollmentCapacity);

			//allCourses[0].startDate = ;;;;
			
			console.log(course);
			$.ajax("http://localhost:9999/cunyworks/teacher/update", {
				method : "POST",
				data : JSON.stringify(courseBean),
				
					contentType : "application/json",
				
				success : function(response) {
					
					$(".alert-success").text(response);
					$(".alert-success").fadeIn();
					window.setTimeout(function(response) {
						$(".alert-success").fadeOut();
						$("#update").prop("disabled", false);
					}, 3000);
					$('#myForm').get(0).reset();
 //reset form fields
					refresh();
				},
				error: function() {
					$(".alert-danger").fadeIn();
					window.setTimeout(function(response) {
						$(".alert-danger").fadeOut();
						$("#update").prop("disabled", false);
					

					}, 3000);
				}
			});
			return false; // prevent REFRESH
		});
		function refresh() {
			$.ajax("http://localhost:9999/cunyworks/teacher/allCourses", {
				method : "GET",
				headers : {
					"Accept" : "application/json"
				},
				success : function(response) {
					allCourses = response;
					console.log(response);
					tablewipe();
					tableload(response);

					populate("#myForm",response);

					
					//loadForm(response);
				}
			});
			
		}
			
		
		
		
		// clear table body
		function tablewipe() {
			$(".table tbody").empty();
		}
//		function tableload(response) {
//		
//			$.each(response, function(index, temp) {
//
//				$(".table tbody").append("<tr>");
//				$(".table tbody").append("<td>" + temp.courseId + "</td>");
//				$(".table tbody").append("<td>" + temp.name + "</td>");
//				$(".table tbody").append("<td>" + temp.subject.name + "</td>");
//				
//				$(".table tbody").append("<td>" + temp.startDate + "</td>");
//				$(".table tbody").append("<td>" + temp.endDate + "</td>");
//								$(".table tbody").append("<td>" + temp.room + "</td>");
//								$(".table tbody").append("<td>" + temp.scheduleTime + "</td>");
//				
//				$(".table tbody").append("<td>" + temp.enrollmentCapacity + "</td>");
//				$(".table tbody").append("<td>" + '<a href="#myModal" class="btn btn-lg btn-primary" data-toggle="modal">Modify</a>' + "</td>");
//				
//			
//
//				
//				$(".table tbody").append("</tr>");
//
//				
//
//				
//			});
//			
//			
//		}
		var i = 0;
		function tableload(response) {		
			
			
			$.each(response, function(index, temp) {

				var newRow = "<tr>" + "<td>" + temp.courseId + "</td>" + "<td>" + temp.name + "</td>" + "<td>" + temp.subject.name + "</td>" +
				"<td>" + temp.startDate + "</td>" + "<td>" + temp.endDate + "</td>" + "<td>" + temp.description + "</td>"+ "<td>" + temp.room + "</td>" + "<td>" + temp.scheduleTime + "</td>" +
				"<td>" + temp.enrollmentCapacity + "</td>" + "<td>" + '<button href="#myModal" id=\"' + i +  '\" class="btn btn-lg btn-primary" data-toggle="modal">Modify</button>' + "</td>" + 
				"</tr>";
				$(".table tbody").append(newRow);
				
				i++;
				
			});
			
//			
//			var table = document.getElementById('#myTable');
//
//			var rowLength = table.rows.length;
//
//			for(var i=0; i<rowLength; i++){
//				$("#myModal").on("click",function(){
//					populate("#myForm",response);
//
//					
//					
//				});
//				
//			}
			 
						
						
		}
		
		
		
	

		function populate(frm,response){


		$.each(response,function(key,value){
			//$("#formName").addAttribute("id").val=key //
			$('#courseId',frm ).val(value.courseId);
			
		    $('#course',frm ).val(value.name);
		    $('#subject',frm ).val(value.subject.name);
		    
		   	$('#startDate',frm ).val(value.startDate);
		   	$('#endDate',frm ).val(value.endDate);
		   	$('#room',frm ).val(value.room);
		   	$('#description',frm ).val(value.description);

		   	$('#capacity',frm ).val(value.enrollmentCapacity);
		   	
		   	
		    });
		
		
		
		}
			
		
	});
