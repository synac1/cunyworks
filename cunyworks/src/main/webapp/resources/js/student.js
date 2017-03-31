/**
 * 
 */

$(function() {

	function SubjectBean(name) {
		this.name = name;
	}
	function StudentBean(studentId, email, password, firstName,
			lastName, phone, address, birthday, created, courses) {

		this.studentId = studentId;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
		this.created = created;
		this.courses = courses;
	}

	function TeacherBean(teacherId, title, email, firstName,
			lastName, phone, address, birthday, created) {
		this.teacherId = teacherId;
		this.title = title;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = adress;
		this.birthday = birthday;
		this.created = created;
	}

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

	fetchstuff();

	$("#add").click(function() {
		var courseId = $("#idOfClass").val();
		var studentId = 1;

		$.ajax("http://localhost:9999/cunyworks/student/new", {
			method : "POST",
			contentType : "application/json",
			data : JSON.stringify({
				studentN : studentId,
				courseN : courseId
			}),
			success : function(response) {
				alert(response);
			}
		});

	});

	function fetchstuff() {
		$.ajax("http://localhost:9999/cunyworks/student/new_courses", {
			method : "GET",
			dataType : "json",
			success : function(response) {
				console.log(response);
				tablewipe();
				tableload(response);
			}
		});
	}

	function tablewipe() {
		$("#courseTable tbody").empty();
	}

	function tableload(response) {
		$.each(response, function(index, temp) {
			$("#courseTable tbody").append(
					'<tr data-toggle="modal" data-target="#myModal" data-id='
							+ temp.courseId + ' >' + '<td scope="row">'
							+ temp.courseId + '</td>' + "<td id='cname'>"
							+ temp.name + "</td>" + "<td>"
							+ temp.enrollmentCapacity + "</td>" + "<td>"
							+ temp.room + "</td>" + "<td>" + temp.scheduleTime
							+ "</td>" + "<td>" + temp.startDate + "</td>"
							+ "<td>" + temp.endDate + "</td>"
							/*
							 * + "<td><a href='#'>" + temp.syllabus + "</a></td>"
							 */
							+ "<td style='visibility: hidden;'>"
							+ temp.description + "</td>"

							+ "</tr>");

		});
	}

	$('#myModal').on(
			'show.bs.modal',
			function(event) {
				// var getIdFromRow = $(event.relatedTarget).attr('data-id');
				// if you wnat to take the text of the first cell
				var getIdFromRow = $(event.relatedTarget)
						.find('td:first-child').text();
				var getNameFromRow = $(event.relatedTarget).find(
						'td:nth-child(2)').text();
				var getDescFromRow = $(event.relatedTarget).find(
						'td:nth-child(8)').text();
				$("#idOfClass").val(getIdFromRow);
				$("#nameOfClass").val(getNameFromRow);
				$("#descOfClass").val(getDescFromRow);

			});

});