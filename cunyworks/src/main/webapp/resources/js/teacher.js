$(document).ready(
		function() {
			// required to get jQuery functions to work properly with CSS
			$(".hidden").hide().removeClass("hidden");

			// Variables / Methods
			var animationSpeed = 1200;
			var populated = false;
			var selectedSubject = "";

			function SubjectBean(name){
				this.name = name;
			}
			
			function CourseBean(enrollmentCapacity, name, room, scheduleTime,
					startDate, endDate, syllabus, subject) {

				this.enrollmentCapacity = enrollmentCapacity;
				this.name = name;
				this.room = room;
				this.scheduleTime = scheduleTime;
				this.startDate = startDate;
				this.endDate = endDate;
				this.syllabus = syllabus;
				this.subject = new SubjectBean(subject);
			}

			function clearEverything() {
				$("#subDiv").hide();
				$("#courseFormDiv").hide();
				
				$("#subSelect").html("");
				$("#courseForm").trigger("reset"); //resets form
			}


			
			function populateSubSelect() {
				$.ajax("http://localhost:9999/cunyworks/teacher/subjects", {
					method : "GET",
					headers : {
						"Content-Type" : "application/json"
					},
					success : function(response) {
						console.log(response);
						$.each(response, function(index, value) {
							$("#subSelect").append($("<option/>", {
								value : value,
								text : value
							}));
						});
						$("#subDiv").toggle(animationSpeed);
						$("#courseFormDiv").toggle(animationSpeed);
					},
					error : function() {
						console.log("Could Not Retrieve Subjects!");
					}
				})
			}

			// Program Flow Logic
			$("#addCourseButton").click(function() {
				if (populated) {
					populated = false;
					clearEverything();
				} else {
					populateSubSelect();
					populated = true;
				}
			});

			$("#courseFormButton").click(function(e) {
				selectedSubject = $("#subSelect option:selected").text();
				console.log(selectedSubject);
			})
			



		});
/*
 * $(document).ready(function(){ $(".launch-modal").click(function(){
 * $("#myModal").modal({ remote:
 * "http://localhost:9999/cunyworks/student1/courses" }); }); });
 * 
 * 
 */