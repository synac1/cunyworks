$(document).ready(
		function() {

			// override jquery validate plugin defaults
			$.validator.setDefaults({
				highlight : function(element) {
					$(element).closest(".form-group").addClass("has-error");
				},
				unhighlight : function(element) {
					$(element).closest(".form-group").removeClass("has-error");
				},
				errorElement : "span",
				errorClass : "help-block",
				errorPlacement : function(error, element) {
					if (element.parent(".input-group").length) {
						error.insertAfter(element.parent());
					} else {
						error.insertAfter(element);
					}
				}
			});

			// Input Validation
			$("#courseForm").validate({ // initialize the jQuery validation
				// plug-in
				rules : {
					courseName : {
						required : true
					},
					courseRoom : {
						required : true
					},
					courseEC : {
						required : true
					},
					groupDays : {
						required : true
					}
				},
				messages : {

				}
			});

			// required to get jQuery functions to work properly with CSS
			$(".hidden").hide().removeClass("hidden");

			// Variables / Methods
			var animationSpeed = 1200;
			var populated = false;
			var selectedSubject = "";
			var allSubjects;
			var currentTeacher;
			
			function CourseBean(enrollmentCapacity, name, room, scheduleTime,
					startDate, endDate, syllabus, subject, description) {
				this.enrollmentCapacity = enrollmentCapacity;
				this.name = name;
				this.room = room;
				this.scheduleTime = scheduleTime;
				this.startDate = startDate;
				this.endDate = endDate;
				this.syllabus = syllabus;
				this.subject = subject;
				this.description = description;
			}

			function clearEverything() {
				$("#courseFormDiv").hide();
				$("#subSelect").html("");
				$("#courseForm").trigger("reset"); // resets form
				$("#courseAddModal").modal("hide");
			}

			function getCourseBeanFromForm() {
				var courseName = $("#courseName").val();
				var courseRoom = $("#courseRoom").val();
				var courseEC = $("#courseEC").val();

				var courseTime = $("#courseStartTime").val() + " - "
						+ $("#courseEndTime").val();
				var checkboxValues = $("input[name=groupDays]:checked").map(
						function() {
							return this.value;
						}).get();
				$.each(checkboxValues, function(i, elt) {
					courseTime = elt + ", " + courseTime;
				})

				var courseStart = $("#courseStart").val();
				var courseEnd = $("#courseEnd").val();
				var courseSyllabus = null;
				var subject = allSubjects[$("#subSelect").val()];
				var description = $("#courseDesc").val();

				return new CourseBean(courseEC, courseName, courseRoom,
						courseTime, courseStart, courseEnd, courseSyllabus,
						subject, description);
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
						$("#subSelect").append($("<option/>", {
							value : "",
							text : ""
						}));
						$.each(response, function(index, value) {
							$("#subSelect").append($("<option/>", {
								value : value.subjectId,
								text : value.name
							}));
						});
						$("#courseFormDiv").toggle(animationSpeed);
					},
					error : function() {
						console.log("Could Not Retrieve Subjects!");
					}
				})
			}

			function addNewCourse(course) {
				console.log(course);
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

			$("#courseForm").submit(function(e) {
				e.preventDefault();
				$form = $(this);
				/*
				 * if ($form != valid) { return false; }
				 */

				var course = getCourseBeanFromForm();
				console.log(course);
				addNewCourse(course);

			});

		});
