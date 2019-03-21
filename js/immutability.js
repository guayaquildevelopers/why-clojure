
var Student = {
  courses: [],
  enroll: function(course) {
    course.startedAt = new Date()
    this.courses.push(course)
  }
}

function saveStudent(student) {
  console.log('Saving student... %j', student);
}

function saveCourseStats(course) {
  console.log('                                                    |')
  console.log('                                                    |')
  console.log('                                                    |')
  console.log('                                                    V')
  console.log('Updating course... %j', course);
  console.log('Updating stats...');
}

function getStudentById(sid) {
  var student = Object.create(Student)
  student.id = sid
  student.name = 'Marie Curie'
  return student
}

function getCourseByCode(code) {
  var courses = [
    {
      name: 'Math',
      code: 'ma-101'
    },
    {
      name: 'Art',
      code: 'ar-101'
    },
    {
      name: 'History',
      code: 'hi-101'
    }
  ]
  return courses.filter((c) => c.code == code)[0]
}

function enrollInCourse(studentId, courseCode) {
  var course = getCourseByCode(courseCode)
  var st = getStudentById(studentId)
  st.enroll(course)
  saveStudent(st)
  saveCourseStats(course)
}

enrollInCourse('1029384756', 'ma-101')
