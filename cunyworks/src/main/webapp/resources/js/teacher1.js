$(document).ready(
		function() {
			///////////////////////ATEEB///////////////////////////////
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
			var allSubjects;

			function CourseBean1(enrollmentCapacity, name, room, scheduleTime,
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

				return new CourseBean1(courseEC, courseName, courseRoom,
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
					contentType : "application/json",
					data : JSON.stringify(course),
					success : function(response) {
						console.log(response);
						clearEverything();
						refresh();
					},
					error : function(response) {
						console.log(response);
					}
				})
			}
			// ///////////////////////////////////////////////////////////////////////////
			// Event Handlers
			var populated = false;
			$("#addCourseButton").click(function() {
				if (populated) {
					$("#courseFormDiv").toggle(animationSpeed);
					populated = false;
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

			$("#toggleModalButton").click(function(e) {
				clearEverything();
				$("#courseAddModal").modal("show");
			})

			
			
			
			
			////////////////// HOSSAIN ///////////////////////
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
				var startDate = $("#startDate").val();
				var endDate = $("#endDate").val();
				var description = $("#description").val();
				var enrollmentCapacity = $("#capacity").val();
				var courseBean = new CourseBean(courseId,name,room,startDate,endDate,description,enrollmentCapacity);
				
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
							$('#myForm').get(0).reset();
		
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
						populate("#myForm",response);
						tableload(response);
					}
				});
			}

			// clear table body
			function tablewipe() {
				$(".table tbody").empty();
			}
	
			var i = 0;
			function tableload(response) {		
				$.each(response, function(index, temp) {
					var newRow = 	"<tr><td>" + temp.courseId + "</td><td>" + 
									temp.name + "</td><td>" + temp.subject.name + "</td><td>" + 
									temp.startDate + "</td>" + "<td>" + temp.endDate + "</td><td>" + 
									temp.description + "</td><td>" + temp.room + "</td><td>" + 
									temp.scheduleTime + "</td><td>" + temp.enrollmentCapacity + 
									"</td><td>" + "<button href=\"#myModal\" id=\"" + i +  
									"\" class=\"btn btn-lg btn-primary\" data-toggle=\"modal\">Modify</button></td></tr>";
					$(".table tbody").append(newRow);
					i++;
				});		
							
			}

			function populate(frm, response) {
				$.each(response, function(key, value) {
					$('#courseId', frm).val(value.courseId);
					$('#course', frm).val(value.name);
					$('#subject', frm).val(value.subject.name);
					$('#startDate', frm).val(value.startDate);
					$('#endDate', frm).val(value.endDate);
					$('#room', frm).val(value.room);
					$('#description', frm).val(value.description);
					$('#capacity', frm).val(value.enrollmentCapacity);
				});
			}
	
});
