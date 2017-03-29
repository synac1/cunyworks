$(document).ready(
		function() {
			// required to get jQuery functions to work properly with CSS
			$(".hidden").hide().removeClass("hidden");

			// Variables / Methods
			var animationSpeed = 1200;
			var populated = false;
			var selectedSubject = "";

			function SubjectBean(name) {
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
<<<<<<< HEAD
				this.subject = new SubjectBean(subject);
=======
				//this.subject = subject;
>>>>>>> branch 'master' of https://github.com/synac1/cunyworks.git
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
<<<<<<< HEAD
				var subject = $("#subSelect option:selected").val();

=======
				var subject = allSubjects[$("#subSelect").val()];
				console.log(subject);
>>>>>>> branch 'master' of https://github.com/synac1/cunyworks.git
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
<<<<<<< HEAD
				return false;
=======
>>>>>>> branch 'master' of https://github.com/synac1/cunyworks.git
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
