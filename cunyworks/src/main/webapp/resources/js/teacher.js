$(document).ready(
		function() {
			// required to get jQuery functions to work properly with CSS
			$(".hidden").hide().removeClass("hidden");

			// Variables / Methods
			var animationSpeed = 1200;
			var populated = false;
			var allSubjects;
			var selectedSubject;

			function SubjectBean(id, name) {
				this.subjectId = id;
				this.name = name;
			}

			function CourseBean(enrollmentCapacity, name, room, scheduleTime,
					startDate, endDate, syllabus, subject) {
				this.enrollmentCapacity = enrollmentCapacity;
				this.name = name;
				this.room = room;
				//this.scheduleTime = scheduleTime;
				this.startDate = startDate;
				//this.endDate = endDate;
				this.syllabus = syllabus;
				//this.subject = subject;
			}

			function clearEverything() {
				$("#subDiv").hide();
				$("#courseFormDiv").hide();

				$("#subSelect").html("");
				$("#courseForm").trigger("reset"); // resets form
			}

			function getCourseBeanFromForm() {
				var courseName = $("#courseName").val();
				var courseRoom = $("#courseRoom").val();
				var courseEC = $("#courseEC").val();
				var courseTime = $("#courseTime").val();
				var courseStart = $("#courseStart").val();
				var courseEnd = $("#courseEnd").val();
				var courseSyllabus = null;
				var subject = allSubjects[$("#subSelect").val()];
				console.log(subject);
				return new CourseBean(courseEC, courseName, courseRoom,
						courseTime, courseStart, courseEnd, courseSyllabus,
						subject);
			}

			function populateSubSelect() {
				$.ajax("http://localhost:9999/cunyworks/teacher/subjects", {
					method : "GET",
					headers : {
						"Content-Type" : "application/json"
					},
					success : function(response) {
						allSubjects = response;
						console.log(response);
						$.each(response, function(index, value) {
							$("#subSelect").append($("<option/>", {
								value : value.subjectId,
								text : value.name
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

			function addNewCourse(course) {
				$.ajax("http://localhost:9999/cunyworks/teacher/insert", {
					method : "POST",
					headers : {
						"Content-Type" : "application/json"
					},
					data : JSON.stringify(course),
					success : function(response) {
						console.log(response);
						clearEverything();
					},
					error : function(response) {
						console.log(response);
					}
				})
			}
			// ///////////////////////////////////////////////////////////////////////////
			// Event Handlers
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
				var course = getCourseBeanFromForm();
				console.log(course);
				addNewCourse(course);
			})

			/*
			 * $(document).ready(function(){
			 * $(".launch-modal").click(function(){ $("#myModal").modal({
			 * remote: "http://localhost:9999/cunyworks/student1/courses" });
			 * }); });
			 * 
			 * 
			 */

		});
